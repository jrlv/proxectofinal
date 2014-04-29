import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String args[]) throws Exception {
        String frase;
        String resposta;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            frase = inFromClient.readLine();
            String[] protocolo = frase.split(";");
            
            if(protocolo[1].equals("A")){
                resposta = Integer.toString(wordCount(protocolo[0])) + "\n";
                outToClient.writeBytes(resposta);
            }
            
            if(protocolo[1].equals("B")){
                resposta = Integer.toString(protocolo[0].length()) + "\n";
                outToClient.writeBytes(resposta);
            }
            
            if(protocolo[1].equals("C")) {
                resposta = protocolo[0].trim() + "\n";
                outToClient.writeBytes(resposta);
            }
        }
    }
    static int wordCount(String frase){
        String[] wordArray = frase.split("\\s+"); //cualquier separador
        return wordArray.length;
    }
}