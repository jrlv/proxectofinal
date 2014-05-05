/*Precísase un servidor capaz de recibir peticións de clientes segundo o seguinte protocolo:
opción::base de datos[::táboa][::novo_nome]
na que as opcións posibles serán list, num, del e ren. No primeiro caso devolverase un
listado cos nomes das táboas na base de datos, no segundo caso o número de filas da
táboa, no terceiro eliminaranse todos os datos dunha táboa e no cuarto cambiarase o nome
da táboa.
En caso de erro habería que devolver unha mensaxe o máis significativa posible. O cliente
será un GUI que oculte aos usuarios estes detalles de protocolo.*/

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class servidor172 {
    
    public static Connection con;
    
    public static void main(String args[]) throws Exception {
        String peticion;
        String resposta;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/", "root", "1234");
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        while(true) {            
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            peticion = inFromClient.readLine();
            String[] partes = peticion.split("::");
            
            if(partes.length < 5){
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + partes[1], "root", "1234");
                } catch(SQLException e) {
                    resposta = "Parece ser que " + e.getLocalizedMessage();
                }
                if(partes[0].equals("list")){
                    try{
                        PreparedStatement ls = con.prepareStatement("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = " + "'" + partes[1] + "'");
                        ResultSet rs = ls.executeQuery();
                        String resparcial = "";
                        while(rs.next()){
                            resparcial = resparcial + rs.getString("TABLE_NAME") + ", ";    
                        }
                        resposta = "As táboas da base " + partes[1] + " son: " + resparcial + '\n';
                        outToClient.writeBytes(resposta);
                        rs.close();
                    }catch(SQLException e){
                        resposta = "Xa que logo " + e.getLocalizedMessage() + '\n';
                        outToClient.writeBytes(resposta);
                    }
                } 
                if(partes[0].equals("num")){
                    try{
                        PreparedStatement nm = con.prepareStatement("SELECT COUNT(*) AS total FROM " + partes[1] + "." + partes[2]);
                        ResultSet rnm = nm.executeQuery();
                        while(rnm.next()){
                            resposta = "A base " + partes[1] + " ten: " + Integer.toString(rnm.getInt("total")) + " táboas. " + '\n';
                            outToClient.writeBytes(resposta);
                        }
                        rnm.close();
                    }catch (SQLException e){
                        resposta = "Fallou a consulta. " + e.getLocalizedMessage() + '\n';
                        outToClient.writeBytes(resposta);
                    }
                }
                if(partes[0].equals("ren")) {
                    try{
                        PreparedStatement re = con.prepareStatement("RENAME TABLE " + partes[1] + "." + partes[2] + " TO " + partes[1] + "." + partes[3]);
                        re.executeUpdate();
                        resposta = "O novo nome para a táboa " + partes[2] + " foi correctamente aplicado. " + '\n';
                        outToClient.writeBytes(resposta);
                    }catch (SQLException e){
                        resposta = "Fallou o intento de renombrar " + partes[2] + ". " + e.getLocalizedMessage() + '\n';
                        outToClient.writeBytes(resposta);
                    }
                }
                if(partes[0].equals("del")) {
                    try{
                        PreparedStatement del = con.prepareStatement("DELETE FROM " + partes[1] + "." + partes[2]);
                        del.executeUpdate();
                        resposta = "Borrado dos datos da táboa " + partes[2] + " realizado." + '\n';
                        outToClient.writeBytes(resposta);
                    }catch (SQLException e){
                        resposta = "Fallou o borrado de datos de " + partes[2] + ". " + e.getLocalizedMessage() + '\n';
                    }
                }
            } else{
                resposta = "Protocolo incorrecto.";
            }
        }
    }
}
