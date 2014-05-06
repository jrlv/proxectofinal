/*Programar un servidor web sinxelo capaz de devolver a un navegador o ficheiro que lle
solicite, tanto se é un documento HTML como unha imaxe dos tipos máis habituais.
Para poder axustar os detalles de funcionamento do programa a necesidades concretas
utilizarase un ficheiro de configuración, no que se especificarán, por exemplo, o porto no
que atenderá o servidor, as extensións de ficheiro que considera válidas ou o ficheiro que se
enviará en caso de non atopar o solicitado:
porto=6677
ruta=www/ficheiros
extensions=html,txt,jpg,gif
erro404=nonatopado.html
erroExt=Ext.txt
O programa, no seu inicio, deberá ler o ficheiro para incorporar eses valores a un HashMap
do que poder extraer a información cando sexa preciso.*/

package servidorweb173;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidorweb173{
    
    static HashMap<String, String> dato = new HashMap<String, String>(){};
        
    public static void main (String args[]) throws Exception {
        String requestMessageLine;
        String fileName;
        
        BufferedReader br = null;
        String linea = null;
        
        //ler o ficheiro de configuración//
        try{
            FileReader fr = new FileReader("config.txt");
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null){             
                String[] valores = linea.split("=");
                dato.put(valores[0], valores[1]); 
            } 
            br.close();
                    
        }catch (IOException e) {
        }

        int myPort = Integer.parseInt(dato.get("porto"));
        ServerSocket listenSocket = new ServerSocket(myPort);

        while(true) {
            System.out.println ("Escoitando o porto " + myPort);
            Socket connectionSocket = listenSocket.accept();
            BufferedReader inFromClient = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream (connectionSocket.getOutputStream());
            
            // traballamos na primeira liña da petición
            requestMessageLine = inFromClient.readLine();
            System.out.println (requestMessageLine);

            String[] cachos = requestMessageLine.split("\\s");

            if (cachos[0].equals("GET")) {
                fileName = dato.get("ruta") + cachos[1];
                String extension = "";
                int i = fileName.lastIndexOf(".");
                if (i > 0){
                    extension = fileName.substring(i+1);
                }
                if(extension!="" && dato.get("extension").contains(extension)){
                    if (fileName.startsWith("/") == true){
                        fileName = fileName.substring(1);}

                    // ler o contido do ficheiro solicitado
                    File file = new File(fileName);
                    if (file.exists()) {
                        
                        // converter o ficheiro nun array de bytes
                        int numOfBytes = (int) file.length();
                        FileInputStream inFile = new FileInputStream (fileName);
                        byte[] fileInBytes = new byte[numOfBytes];
                        inFile.read(fileInBytes);

                        // enviar a contestación
                        outToClient.writeBytes ("HTTP/1.0 200 Document Follows\r\n");
                        outToClient.writeBytes ("Content-Length: " + numOfBytes + "\r\n");
                        outToClient.writeBytes ("\r\n");
                        outToClient.write(fileInBytes, 0, numOfBytes);
                    } else {
                        System.out.println("Not Found");
                        String erro = dato.get("erro404");
                        File mErro = new File(erro);
                        int numOfBytes = (int) mErro.length();
                        FileInputStream inFile = new FileInputStream (erro);
                        byte[] fileInBytes = new byte[numOfBytes];
                        inFile.read(fileInBytes);
                        outToClient.writeBytes("HTTP/1.0 404 NOT_FOUND\r\n");
                        outToClient.writeBytes("\r\n");
                        outToClient.write(fileInBytes, 0, numOfBytes);
                    }
                }else {
                    System.out.println("Extensión non admitida.");
                    String erroExt = dato.get("erroExt");
                    File mErroExt = new File(erroExt);
                    int numOfBytes = (int) mErroExt.length();
                    FileInputStream inFile = new FileInputStream (erroExt);
                    byte[] fileInBytes = new byte[numOfBytes];
                    inFile.read(fileInBytes);
                    outToClient.writeBytes("HTTP/1.0 200 Document Follows\r\n");
                    outToClient.writeBytes("\r\n");
                    outToClient.write(fileInBytes, 0, numOfBytes);
                }    
                    // ler sen traballar o resto de liñas da petición
                    requestMessageLine = inFromClient.readLine();
                    while (requestMessageLine.length() >= 5) {
                        System.out.println (requestMessageLine);
                        requestMessageLine = inFromClient.readLine();
                    }
                    System.out.println (requestMessageLine);

                    connectionSocket.close();
            } else {
                System.out.println ("Petición incorrecta");
            }
        }
    }
}
