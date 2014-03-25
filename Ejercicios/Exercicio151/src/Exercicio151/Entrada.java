package Exercicio151;

/*
 * 1. Quérese crear una aplicación que permita xestionar unha base de datos na que se
almacenan direccións url etiquetadas. Cada dirección web estará caracterizada por un
título, poderá levar un comentario e clasificarase utilizando un conxunto de etiquetas.
As direccións son propiedade de diferentes usuarios, polo que o programa deberá identificar
á persoa que o vai usar como primeiro paso. Se non hai ningún usuario identificado, a
aplicación só permitirá o acceso aos enlaces que foron declarados públicos.
Ademais de poder almacenar novas direccións o obxectivo básico da aplicación é
consultalas navegando polas etiquetas.
2. Crearanse as clases Usuario e Enlace. Para a clase Usuario precísase un método
Existe(String login, String clave) que devolva un Boolean informando da existencia da
combinación que se lle proporciona e un método gardar() que copiará o obxecto na base de
datos (UPDATE ou INSERT segundo exista xa ou non). Na clase Enlace precísase un método
Etiquetados(List<String>) que devolva o conxunto de enlaces que están etiquetados polo
conxunto de valores que se pasan como argumento.
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;


public class Entrada extends javax.swing.JFrame {

    public static Connection connection;
    
    public Entrada() {
        initComponents();
        conectar();
        setLocationRelativeTo(null);
        setTitle("Menú Entrada");
    
    }

    private void conectar(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/urls", "root", "1234");
            System.out.println("Conexion correcta" + "\n");
        } catch(SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1Comprobar = new javax.swing.JButton();
        jButton2Rexistrarse = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton1Entrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Clave");

        jButton1Comprobar.setText("Comprobar");
        jButton1Comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ComprobarActionPerformed(evt);
            }
        });

        jButton2Rexistrarse.setText("Rexistrarse");
        jButton2Rexistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2RexistrarseActionPerformed(evt);
            }
        });

        jButton1Entrar.setText("Entrar");
        jButton1Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1EntrarActionPerformed(evt);
            }
        });

        jLabel3.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1Comprobar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addComponent(jButton2Rexistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1Entrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1Comprobar)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2Rexistrarse)
                .addGap(18, 18, 18)
                .addComponent(jButton1Entrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ComprobarActionPerformed
       
        if(Usuario.Existe(jTextField1.getText(), jTextField2.getText())){
            jTextField3.setText("Usuario rexistrado");
            jButton2Rexistrarse.setVisible(false);
            jTextField4.setText(Usuario.Id(jTextField1.getText(), jTextField2.getText()));
        } else {
            jTextField3.setText("Usuario descoñecido");
            jButton2Rexistrarse.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ComprobarActionPerformed

    private void jButton2RexistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2RexistrarseActionPerformed
                
        EnlacesRexistro direcciones = new EnlacesRexistro();
        direcciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2RexistrarseActionPerformed

    private void jButton1EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1EntrarActionPerformed
    
        if(Usuario.Existe(jTextField1.getText(), jTextField2.getText())){
            EnlacesUsuarios direcciones = new EnlacesUsuarios();
            direcciones.setVisible(true);
            
        } else {
            EnlacesPublicos publicos = new EnlacesPublicos();
            publicos.setVisible(true);
            dispose();
        }       
    }//GEN-LAST:event_jButton1EntrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Entrada().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Comprobar;
    private javax.swing.JButton jButton1Entrar;
    private javax.swing.JButton jButton2Rexistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}

class Usuario{
    int id;
    String login;
    String clave;
    
    public static boolean Existe(String login, String clave){
        boolean existe = false;
        String idUsu = null;
        try{
            PreparedStatement ps = Entrada.connection.prepareStatement("SELECT * FROM usuarios WHERE login = ? AND clave = ?");
            ps.setString(1, login);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                existe = true;
                idUsu = String.valueOf(rs.getInt("id"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return existe;
    }
    
        public static String Id(String login, String clave){
        String idUsu = null;
        try{
            PreparedStatement ps = Entrada.connection.prepareStatement("SELECT * FROM usuarios WHERE login = ? AND clave = ?");
            ps.setString(1, login);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                idUsu = String.valueOf(rs.getInt("id"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return idUsu;
    }
        
    
    public Usuario(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public void gardar(Usuario actual){
        PreparedStatement ps;
        try{
            ps = Entrada.connection.prepareStatement("SELECT * FROM usuarios WHERE login = ? AND clave = ?");
            ps.setString(1, actual.getLogin());
            ps.setString(2, actual.getClave());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                PreparedStatement psUp;
                try{
                    psUp = Entrada.connection.prepareStatement("UPDATE usuarios SET login = ?, clave = ? WHERE id = ?");
                    psUp.setString(1, actual.getLogin());
                    psUp.setString(2, actual.getClave());
                    psUp.setInt(3, actual.getId());
                    psUp.executeUpdate();

               } catch (SQLException e) {
                    e.printStackTrace();
               }
            } else{
                PreparedStatement psIn;
                try{
                    psIn = Entrada.connection.prepareStatement("INSERT INTO usuarios VALUE (null,?,?)", Statement.RETURN_GENERATED_KEYS);
                    psIn.setString(1, actual.getLogin());
                    psIn.setString(2, actual.getClave());
                    int inserido = psIn.executeUpdate();
                            
                    if(inserido > 0){
                        ResultSet rsId = psIn.getGeneratedKeys();
                        if (rsId.next()){
                            int idUs = rsId.getInt(1);
                        }
                    }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        }
}


class Enlace{
    
    public static ArrayList<Enlace> enlaces = new ArrayList<Enlace>();

    int id;
    String título;
    String comentario;
    String nomeetiquetas;
    int idUsuario;
    int público = 1;
    
    public Enlace(String título, String comentario, String nomeetiquetas, int idUsuario, int público){
        this.título = título;
        this.comentario = comentario;
        this.nomeetiquetas = nomeetiquetas;
        this.idUsuario = idUsuario;
        this.público = público;
    }
    
    public Enlace(){}
    
    public static void engadir(String título, String comentario, String etiquetas, int idUsuario, int público){
        try{
            PreparedStatement psE = Entrada.connection.prepareStatement("INSERT INTO enlaces VALUES (null, ?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            psE.setString(1, título);
            psE.setString(2, comentario);
            psE.setString(3, etiquetas);
            psE.setInt(4, idUsuario);
            psE.setInt(5, público);
            int inserido = psE.executeUpdate();
            if(inserido > 0){
                ResultSet rsIdE = psE.getGeneratedKeys();
                if (rsIdE.next()){
                    int idE = rsIdE.getInt(1);
                } 
            }
        } catch (SQLException e){
                e.printStackTrace();
        }
    }

        public static void obterEnlaces(){
            try{
                PreparedStatement pm = Entrada.connection.prepareStatement("SELECT * FROM enlaces ORDER BY id");
                ResultSet rsm = pm.executeQuery();
                while(rsm.next()){
                    Enlace novoEnlace = new Enlace();
                    novoEnlace.setId(rsm.getInt("id"));
                    novoEnlace.setTítulo(rsm.getString("título"));
                    novoEnlace.setComentario(rsm.getString("comentario"));
                    novoEnlace.setEtiquetas(rsm.getString("etiquetas"));
                    novoEnlace.setIdUsuario(rsm.getInt("idUsuario"));
                    novoEnlace.setPúblico(rsm.getInt("público"));
                    enlaces.add(novoEnlace);
                }
                rsm.close();
           } catch (SQLException e){
                e.printStackTrace();
           }
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNomeetiquetas() {
        return nomeetiquetas;
    }

    public void setEtiquetas(String nomeetiquetas) {
        this.nomeetiquetas = nomeetiquetas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPúblico() {
        return público;
    }

    public void setPúblico(int público) {
        this.público = público;
    }

    @Override
    public String toString() {
        return "Id= " + id + ", Título= " + título + ", Comentario= " + comentario + ", Etiquetas= " + nomeetiquetas + ", IdUsuario= " + idUsuario + "\n";
    }
    
    public void Etiquetados (ArrayList<Etiqueta> etiquetas){
        try{
            PreparedStatement psEt = Entrada.connection.prepareStatement("SELECT * FROM enlaces WHERE id = ?");
            for(Etiqueta e : etiquetas){
                psEt.setInt(1, e.getIdEnlace());
            }
            ResultSet rs = psEt.executeQuery();
            while (rs.next()){
                Enlace enet = new Enlace();
                enet.setId(rs.getInt(1));
                enet.setTítulo(rs.getString("título"));
                enlaces.add(enet);
            }     
        } catch (SQLException e){
            e.printStackTrace();
        }        
    }
}

class Etiqueta{
    int idEnlace;
    String texto;

    public Etiqueta() {}

    public int getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(int idEnlace) {
        this.idEnlace = idEnlace;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}