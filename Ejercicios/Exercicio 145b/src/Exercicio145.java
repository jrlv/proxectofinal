
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
 
public class Exercicio145 {

    static private Connection con;
    
    public static void main(String[] args) {
        
    try {    
         con = DriverManager.getConnection("jdbc:mysql://localhost:3308/", "root", "1234");
         
            SAXBuilder builder = new SAXBuilder();  
            try{                
                Document doc = builder.build("cars.xml");
                Element raiz = doc.getRootElement();
                String nomeBase = raiz.getAttributeValue("nome");
                
                System.out.println("Nome da Base: " + nomeBase);
                
                Statement statement = null;
                statement = con.createStatement();
                statement.execute("CREATE DATABASE IF NOT EXISTS " + nomeBase);
                statement.execute("USE " + nomeBase);
                
                List<Element> taboas = raiz.getChildren("taboa");
                
                System.out.println(  "Cantidade de táboas: " + taboas.size());
                
                Iterator<Element> t = taboas.iterator();
                while(t.hasNext()){
                    Element ta = t.next();
                    List<Element> col = ta.getChildren("columna");
                    List<Element> fil = ta.getChildren("fila");
                    
                    String nomeTaboa = ta.getAttributeValue("nome");
                    
                    System.out.println(   "Nome táboa: " + nomeTaboa);

                    String sql = "CREATE TABLE IF NOT EXISTS " + nomeTaboa + "(";
                    
                    Iterator<Element> co = col.iterator();
                    int contador = 0;
                    while(co.hasNext()){
                        Element c = co.next();
                        String tipo = c.getAttributeValue("tipo");
                        String extra = c.getAttributeValue("extra");
                        String nomeColumna = c.getText();
                        String descripcionColumna = nomeColumna + " " + tipo + " " + extra;
                        
                        System.out.println("      Columna " + descripcionColumna);
                        
                        contador ++;
                        if (contador < col.size()){
                            sql = sql + descripcionColumna + ", ";
                        }else {
                            sql = sql + descripcionColumna;
                        }
                    }                    
                    sql = sql + ")";
                    System.out.println("      " + sql);
                    statement.execute(sql);

                    Iterator<Element> fi = fil.iterator();
                    String sqlIns = null;
                    while(fi.hasNext()){
                        Element f = fi.next();
                        String numFila = f.getAttributeValue("num");
                        String datos = f.getText();
                        
                        System.out.println("        Datos fila " + numFila + ": " + " " + datos);
                        
                        sqlIns = "INSERT INTO " + nomeTaboa + " VALUES(";
  
                        sqlIns += datos;
                        sqlIns = sqlIns + ")";
                        
                        System.out.println("          " + sqlIns);
                        statement.execute(sqlIns);
 
                    }   
                }                         
     
            } catch (JDOMException e){
           }
            catch (IOException e){
            }
       } catch(SQLException e){
           System.out.println(e.getLocalizedMessage());
       }
       }
}
