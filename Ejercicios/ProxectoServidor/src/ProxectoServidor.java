import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para opter a cantidade de libros de un usuario rexistrado que responden á condición de busca.
 * @author JRLV
 * @version 20/05/2014
 */
public class ProxectoServidor {
    
    public static Connection con;

    public static void main(String args[]) throws Exception {
        String pedido;
        String resposta;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        while(true) {            
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            pedido = inFromClient.readLine();
            String[] partes = pedido.split("::");
            
            if (partes.length < 5){
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/biblio", "root", "1234");
                } catch(SQLException e) {
                    resposta = "Erro na conexión coa base de datos. " + e.getLocalizedMessage() + '\n';
                    outToClient.writeBytes(resposta);
                }
                System.out.println("CONTRASINAL: " + partes[2]);
                char[] array = partes[2].toCharArray();
                for (int i = 0; i<array.length; i++){
                    array[i] = (char)(array[i] + (char)4);
                }
                String contraEncriptada = String.valueOf(array);
                try{
                    PreparedStatement pu = con.prepareStatement("SELECT * FROM usuarios WHERE nome = ? AND contrasinal = ?");
                    pu.setString(1, partes[1]);
                    pu.setString(2, contraEncriptada);
                    ResultSet r = pu.executeQuery();
                    if(r.next()){
                        if (partes[0].equals("E")){
                            try{
                                PreparedStatement pE = con.prepareStatement("SELECT COUNT(tituloLibro) AS total FROM etiquetas WHERE texto = ? AND creador = ?");
                                pE.setString(1, partes[3]);
                                pE.setString(2, partes[1]);
                                ResultSet rE = pE.executeQuery();
                                while(rE.next()){
                                    resposta = Integer.toString(rE.getInt("total")) + '\n';
                                    outToClient.writeBytes(resposta);
                                }
                                rE.close();
                            }catch (SQLException e){
                                resposta = "Erro na conexión coa base de datos. " + e.getLocalizedMessage() + '\n';
                                outToClient.writeBytes(resposta);
                            }
                        }
                        if (partes[0].equals("T")){
                            try{
                                PreparedStatement pT = con.prepareStatement("SELECT COUNT(titulo) AS total FROM libros WHERE resume LIKE ? AND propietario =?");
                                pT.setString(1, "%"+partes[3]+"%");
                                pT.setString(2, partes[1]);
                                ResultSet rT = pT.executeQuery();
                                if(rT.next()){
                                    resposta = Integer.toString(rT.getInt("total")) + '\n';
                                    outToClient.writeBytes(resposta);
                                }else{
                                    resposta = "Non hai libros que conteñan este texto." + '\n';
                                    outToClient.writeBytes(resposta);
                                }
                            }catch (SQLException e){
                                resposta = "Erro na conexión coa base de datos. " + e.getLocalizedMessage() + '\n';
                                outToClient.writeBytes(resposta);
                            }
                        } 
                    }else {
                        resposta = "Usuario non atopado. " + '\n';
                        outToClient.writeBytes(resposta);
                    }
                }catch(SQLException e){
                    resposta = "Erro na conexión coa base de datos. " + e.getLocalizedMessage() + '\n';
                    outToClient.writeBytes(resposta);
                }
            }else {
                resposta = "Protocolo incorrecto." + '\n';
                outToClient.writeBytes(resposta);
            }
        }
    }
}
