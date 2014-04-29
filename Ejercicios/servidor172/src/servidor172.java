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
                        resposta = "Fallou. " + e.getLocalizedMessage() + '\n';
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
                        resposta = "Fallou. " + e.getLocalizedMessage() + '\n';
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
                        resposta = "Fallou. " + e.getLocalizedMessage() + '\n';
                    }
                }
            } else{
                resposta = "Protocolo incorrecto.";
            }
        }
    }
}
