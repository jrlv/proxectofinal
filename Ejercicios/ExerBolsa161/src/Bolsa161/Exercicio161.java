
package Bolsa161;

/**
 *
 * @author JRLV
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

interface Bolsa{
    boolean iniciar();
    boolean actualizar();
    boolean novo(String login, String clave, float capital);
    boolean identificar(String login, String clave);
}

interface Inversor{
    boolean comprar(int idEmpresa, int cantidade);
    boolean vender(int idEmpresa, int cantidade);
    float valorar();
}

class BolsaEnBD implements Bolsa{
    
    private int idEmpresa;
    private String nome;
    private float valor;
    
    public static Connection con;
        
    public @Override
    boolean iniciar(){
        boolean iniciado = false;
        try{    
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/", "root", "1234");
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }        
        Statement st = null;
        try{
            st = con.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS bolsa");
            st.execute("USE bolsa");
            st.execute("CREATE TABLE IF NOT EXISTS accions(idEmpresa int, nome varchar(50), valor float)");
            st.execute("CREATE TABLE IF NOT EXISTS clientes(login varchar(50), clave varchar(50), capital float)");
            st.execute("CREATE TABLE IF NOT EXISTS carteira(idEmpresa int, cliente varchar(50), cantidade int)");
            iniciado = true;
            System.out.println("Base de datos creada.");

        } catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return iniciado;
    }
    
    boolean inserirAccions(int idEmpresa, String nome, float valor){
        boolean inserida = false;
        PreparedStatement pst = null;
        try{
            pst = con.prepareStatement("SELECT * FROM accions WHERE idEmpresa = ?");
            pst.setInt(1, idEmpresa);
            ResultSet rsIn = pst.executeQuery();
            if(rsIn.next()){
                System.out.println("As accións de " + nome + " xa están dadas de alta.");
            }else{
                pst = con.prepareStatement("INSERT INTO accions VALUES(?, ?, ?)");
                pst.setInt(1, idEmpresa);
                pst.setString(2, nome);
                pst.setFloat(3, valor);
                int inseridas = pst.executeUpdate();
                if(inseridas > 0){
                    inserida = true;
                    System.out.println("Acción de " + nome + " inserida correctamente.");
                }    
            }    
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return inserida;
    }
    
    public @Override
    boolean novo(String login, String clave, float capital){
        boolean creado = false;
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("SELECT login FROM clientes WHERE login = ?");
            ps.setString(1, login);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                System.out.println("Escolla outro nome, " + login + " xa existe.");
            } else{
                try{
                    ps = con.prepareStatement("INSERT INTO clientes VALUES(?, ?, ?)");
                    ps.setString(1, login);
                    ps.setString(2, clave);
                    ps.setFloat(3, capital);
                    int inseridos = ps.executeUpdate();
                    if (inseridos > 0){
                        creado = true;
                        System.out.println("Cliente " + login + " inserido.");
                    }
                }catch(SQLException e){
                    System.out.println(e.getLocalizedMessage());
                }   
            }  
        }catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return creado;
    }
    
    public @Override
    boolean identificar(String login, String clave){
        boolean identificado = false;
        PreparedStatement ps = null;
        String clienteActual = null;
        try{
            ps = con.prepareStatement("SELECT * FROM clientes WHERE login = ? AND clave = ?");
            ps.setString(1, login);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                identificado = true;
                clienteActual = rs.getString("login");
                System.out.println("Cliente seleccionado: " + clienteActual);
            }  
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return identificado;
    }
    
    public @Override
    boolean actualizar(){
        boolean actualizado = false;
        try{
            PreparedStatement p = con.prepareStatement("SELECT * FROM accions");
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                float valorActual = rs.getFloat(3);
                float variacionValor = (float)(Math.random()*5)+1;
                try{
                    p = con.prepareStatement("UPDATE accions SET valor = ? WHERE idEmpresa = ?");
                    p.setFloat(1, valorActual + variacionValor);
                    p.setInt(2, id);
                    p.executeUpdate();
                }catch(SQLException e){
                    System.out.println(e.getLocalizedMessage());
                }
            }
            rs.close();
            System.out.println("Actualización executada.");
            
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return actualizado;
    }            
}

class Cliente implements Inversor{
    
    private String clave;
    private String login;
    private float capital;

        public float getCapital() {
            return capital;
        }

        public void setCapital(float capital) {
            this.capital = capital;
        }

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    
    
    public @Override
    boolean comprar(int idEmpresa, int cantidade){
        boolean comprou = false;
        PreparedStatement p = null;
        try{
            p = BolsaEnBD.con.prepareStatement("SELECT valor FROM accions WHERE idEmpresa = ?");
            p.setFloat(1, idEmpresa);
            ResultSet rv = p.executeQuery();
            float valorDaAcción = 0;
            float costeCompra = 0;
            if(rv.next()){
                valorDaAcción = rv.getFloat("valor");
                costeCompra = valorDaAcción * cantidade;
                p = BolsaEnBD.con.prepareStatement("SELECT capital FROM clientes WHERE login = ?");
                p.setString(1, this.getLogin());
                ResultSet rc = p.executeQuery();
                float capitalActual = 0;
                while(rc.next()){
                    capitalActual = rc.getFloat("capital");
                    if(capitalActual >= costeCompra){
                        p = BolsaEnBD.con.prepareStatement("UPDATE clientes SET capital = ? WHERE login = ?");
                        p.setFloat(1, capitalActual - costeCompra);
                        p.setString(2, this.getLogin());
                        p.executeUpdate();
                        p = BolsaEnBD.con.prepareStatement("SELECT cantidade FROM carteira WHERE cliente = ? AND idEmpresa = ?");
                        p.setString(1, this.getLogin());
                        p.setInt(2, idEmpresa);
                        ResultSet rs = p.executeQuery();
                        int cantidadeActual = 0;
                        if(rs.next()){
                            cantidadeActual = rs.getInt("cantidade");
                            p = BolsaEnBD.con.prepareStatement("UPDATE carteira SET cantidade = ? WHERE cliente = ? AND idEmpresa = ?");
                            p.setInt(1, cantidadeActual + cantidade);
                            p.setString(2, this.getLogin());
                            p.setInt(3, idEmpresa);
                            p.executeUpdate();
                        }else {
                            p = BolsaEnBD.con.prepareStatement("INSERT INTO carteira VALUES(?,?,?)");
                            p.setInt(1, idEmpresa);
                            p.setString(2, this.getLogin());
                            p.setInt(3, cantidade);
                            p.executeUpdate();
                            comprou = true;
                            System.out.println("Compra de accións realizada correctamente.");
                        }
                    }else {
                        System.out.println(this.getLogin() + " non ten cartos para esta compra.");
                    }
                }
                rc.close();
            }else {
                System.out.println("Esta empresa non existe na base de datos.");
            }
        }catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return comprou;
    }
    
    public @Override
    boolean vender(int idEmpresa, int cantidade){
        boolean vendido = false;
        PreparedStatement p = null;
        try{
            p = BolsaEnBD.con.prepareStatement("SELECT valor FROM accions WHERE idEmpresa = ?");
            p.setFloat(1, idEmpresa);
            ResultSet rv = p.executeQuery();
            float valorDaAcción = 0;
            float valorVenda = 0;
            if(rv.next()){
                valorDaAcción = rv.getFloat("valor");
                valorVenda = valorDaAcción * cantidade;
                p = BolsaEnBD.con.prepareStatement("SELECT cantidade FROM carteira WHERE cliente = ? AND idEmpresa = ?");
                p.setString(1, this.getLogin());
                p.setInt(2, idEmpresa);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    int cantidadeActual = rs.getInt("cantidade");
                    if(cantidadeActual >= cantidade){
                        p = BolsaEnBD.con.prepareStatement("UPDATE carteira SET cantidade = ? WHERE cliente = ? AND idEmpresa = ?");
                        p.setInt(1, cantidadeActual - cantidade);
                        p.setString(2, this.getLogin());
                        p.setInt(3, idEmpresa);
                        p.executeUpdate();
                        p = BolsaEnBD.con.prepareStatement("SELECT capital FROM clientes WHERE login = ?");
                        p.setString(1, this.getLogin());
                        ResultSet rc = p.executeQuery();
                        float capitalActual = 0;
                        while(rc.next()){
                            capitalActual = rc.getFloat("capital");
                            p = BolsaEnBD.con.prepareStatement("UPDATE clientes SET capital = ? WHERE login = ?");
                            p.setFloat(1, capitalActual + valorVenda);
                            p.setString(2, this.getLogin());
                            p.executeUpdate();
                        }
                        rc.close();
                        vendido = true;
                        System.out.println("Venta de accións realizada correctamente.");
                    }else {
                        System.out.println(this.getLogin() + " non ten tantas accións de esta empresa.");
                    }
                } else  {
                    System.out.println(this.getLogin() + " non ten accións de esta empresa.");
                }
            }else {
                System.out.println("Esta empresa non existe na base de datos.");
            }
        }catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return vendido;
    }
    
    public @Override
    float valorar(){
        float valor = 0;
        PreparedStatement pv = null;
        try{
            pv = BolsaEnBD.con.prepareStatement("SELECT SUM(cantidade*valor) AS valoracion FROM carteira INNER JOIN accions ON carteira.idEmpresa = accions.idEmpresa WHERE carteira.cliente = ?");
            pv.setString(1, this.getLogin());
            ResultSet rsm = pv.executeQuery();
            while(rsm.next()){
                valor = rsm.getFloat("valoracion");    
                System.out.println("Valor da carteira de accións de " + this.getLogin() + ":" + valor);
            }
            rsm.close();
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    return valor;
    }        
}

