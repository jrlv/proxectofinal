package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * Inicio do proxecto final.
 * @author JRLV
 * @version 20/05/2014
 */
public class Entrada extends javax.swing.JFrame {

    /**
     * Declaración da conexión.
     */
    public static Connection conex;
/**
 * Constructor. Situamos o frame no centro da pantalla e conectamos coa base de datos.
 */
    public Entrada() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Entrada á biblioteca popular");
        conectar();
    }
    /** 
     * Método para conectar coa base de datos.
     */
    private void conectar(){
        try {
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3308/biblio", "root", "1234");
            System.out.println("Conexion correcta" + "\n");
        } catch(SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Administrador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Boton para entrar no frame do administrador.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Administrador xestor = new Administrador();
        xestor.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Botton para entrar no frame do usuario.
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Usuarios usuario = new Usuarios();
        usuario.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}

/**
 * Usuario que interactúa coa base de datos e métodos para facelo.
 * @author JRLV
 * @version 20/05/2014
 */
class Usuario{
    String nome;
    String contrasinal;

    /**
     * Constructor
     * @param nome. Login que identifica ao usuario.
     */
    public Usuario(String nome) {
        this.nome = nome;
    }
    
    public Usuario(){};

    /**
     * Getter
     * @return nome. Login do usuario.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     * @param nome. Login para usuario.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter.
     * @return contrasinal. Contrasinal que identifica ao usuario na base de datos.
     */
    public String getContrasinal() {
        return contrasinal;
    }

    /**
     * Setter.
     * @param contrasinal asignada aleatoriamente
     */
    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
    /** 
     * Método para insertar un novo usuario na base de datos xerando unha contrasinal aleatoria e encriptándoa.
     * @param nome. Nome do usuario a inserir.
     */
    public void Alta(String nome){
        int aleatorio = (int)(Math.random()*(9999-1)+1);
        String contrasinal = Integer.toString(aleatorio);
        System.out.println("CONTRASINAL para " + nome + ": " + contrasinal);
        char[] array = contrasinal.toCharArray();
        for (int i = 0; i<array.length; i++){
            array[i] = (char)(array[i] + (char)4);
        }
        String contraEncriptada = String.valueOf(array);
        System.out.println("ENCRIPTADA: " + contraEncriptada);
        try{
            PreparedStatement pa = Entrada.conex.prepareStatement("INSERT INTO usuarios VALUE(?,?)");
            pa.setString(1, nome);
            pa.setString(2, contraEncriptada);
            pa.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    /** 
     * Método para eliminar os datos dun usuario das tres táboas da base de datos.
     * @param nome do usuario
     */
    public void Baixa(String nome){
        try{
            PreparedStatement pE = Entrada.conex.prepareStatement("DELETE FROM etiquetas WHERE creador = ?");
            pE.setString(1, nome);
            pE.executeUpdate();
        
            PreparedStatement pP = Entrada.conex.prepareStatement("DELETE FROM libros WHERE propietario = ?");
            pP.setString(1, nome);
            pP.executeUpdate();
        
            PreparedStatement pU = Entrada.conex.prepareStatement("DELETE FROM usuarios WHERE nome = ?");
            pU.setString(1, nome);
            pU.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    /** 
     * Método boolean para comprobar a existencia dun usuario na base de datos.
     * @param nome. Login do usuario a buscar.
     * @param contraEncrip. Contrasinal do usuario a buscar.
     * @return existe. Se o usuario está na base de datos, existe = true.
     */ 
    public static boolean Existe(String nome, char[] contraEncrip){
        boolean existe = false;
        char[] array = contraEncrip;
        for (int i = 0; i<array.length; i++){
            array[i] = (char)(array[i] + (char)4);
        }
        String contraEncriptada = String.valueOf(array);
        try{
            PreparedStatement ps = Entrada.conex.prepareStatement("SELECT * FROM usuarios WHERE nome = ? AND contrasinal = ?");
            ps.setString(1, nome);
            ps.setString(2, contraEncriptada);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                existe = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return existe;
    }    
    
    /** 
     * Método boolean para comprobar a existencia dun usuario administrador na base de datos.
     * @param nome. Login do usuario a buscar.
     * @return existeAd. Se o usuario está na base de datos como administrador, existe = true.
     */
    public static boolean ExisteAdmin(String nome){
        boolean existeAd = false;
            try{
                PreparedStatement ps = Entrada.conex.prepareStatement("SELECT * FROM usuarios WHERE nome = ?");
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    if(rs.getString("nome").endsWith("&")){
                        existeAd = true;
                    } else {
                        existeAd = false;
                    }
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        return existeAd;
        }
    
    /** 
     * Método boolean para comprobar a existencia dun nome de usuario na base de datos.
     * @param nome. Nome a buscar na base de datos.
     * @return existe. Se o nome do usuario está na base de datos, existe = true.
     */
    public static boolean ExisteLogin(String nome){
        boolean existe = false;
        try{
            PreparedStatement ps = Entrada.conex.prepareStatement("SELECT * FROM usuarios WHERE nome = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                existe = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return existe;
    }
}

/**
 * Libro. Parámetros e métodos para atopalos, editalos ou eliminalos da base de datos.
 * @author JRLV
 */
class Libro{
    String titulo;
    String autor;
    String resume;
    String etiquetas;
    String propietario;
    
    /**
     * Coleccións
     */
    public static ArrayList<Libro> libros = new ArrayList<Libro>();
    public static ArrayList<Libro> atopados = new ArrayList<Libro>();

    /**
     * Constructor sen parámetros.
     */
    public Libro() {}
    
    /**
     * Constructor con parámetro.
     * @param titulo do libro.
     */
    public Libro(String titulo){}

    /**
     * Getter
     * @return titulo do libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter
     * @param titulo do libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter
     * @return autor do libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Setter
     * @param autor do libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Getter
     * @return resume do libro. Texto resume co contido do libro.
     */
    public String getResume() {
        return resume;
    }

    /**
     * Setter
     * @param resume. Texto que explica o contido do libro. 
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * Getter
     * @return etiquetas. Palabras que describen o contido do libro.
     */
    public String getEtiquetas() {
        return etiquetas;
    }

    /**
     * Setter
     * @param etiquetas. Palabras que deben identificarse co contido do libro.
     */
    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * Getter
     * @return propietario. Usuario que engadeu o libro á base de datos.
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * Setter
     * @param propietario. Usuario que crea o libro na base de datos.
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * toString. Todos os datos dun libro.
     * @return String. Cadea de datos dun libro.
     */
    @Override
    public String toString() {
        return "Título= " + titulo + ", Autor= " + autor + ", Resume= " + resume + ", Propietario= " + propietario + ", Etiquetas= " + etiquetas + '\n';
    }
    
    /** 
     * Método para obter os datos de todos os libros dun usuario.
     * @param propietario. Usuario que engadeu os libros na base de datos.
     */
    public static void mostrarLibros(String propietario){
        libros.removeAll(libros);
        try{
            PreparedStatement mL = Entrada.conex.prepareStatement("SELECT * FROM libros WHERE propietario = ?");
            mL.setString(1, propietario);
            ResultSet rsML = mL.executeQuery();
            while(rsML.next()){
                Libro novoLibro = new Libro();
                novoLibro.setTitulo(rsML.getString("titulo"));
                novoLibro.setAutor(rsML.getString("autor"));
                novoLibro.setResume(rsML.getString("resume"));
                novoLibro.setEtiquetas(rsML.getString("etiquetas"));
                novoLibro.setPropietario(rsML.getString("propietario"));
                libros.add(novoLibro);
            }
            rsML.close();
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    /** 
     * Método para que un usuario engada un novo libro á base de datos.
     * @param titulo do novo libro.
     * @param autor do novo libro.
     * @param resume. Texto explicativo do novo libro.
     * @param propietario. Usuario que engade o libro.
     * @param etiquetas. Palabras que identifican o contido do libro.
     */
    public static void novoLibro(String titulo, String autor, String resume, String propietario, String etiquetas){
        try{
            PreparedStatement novo = Entrada.conex.prepareStatement("INSERT INTO libros VALUES (?,?,?,?,?)");
            novo.setString(1, titulo);
            novo.setString(2, autor);
            novo.setString(3, resume);
            novo.setString(4, propietario);
            novo.setString(5, etiquetas);
            novo.executeUpdate();
            for(String et : etiquetas.split(", ")){
                PreparedStatement novaE = Entrada.conex.prepareStatement("INSERT INTO etiquetas VALUES (?,?,?)");
                novaE.setString(1, titulo);
                novaE.setString(2, et);
                novaE.setString(3, propietario);
                novaE.executeUpdate();
            }            
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }    
    
    /** 
     * Método para actualizar os datos dun libro despois de editalos.
     * @param titulo do libro a editar.
     * @param autor do libro editado.
     * @param resume. Texto explicativo do libro editado.
     * @param etiquetas que identifican o libro editado.
     * @param propietario. Usuario que edita o libro.
     */
    public static void actualizar(String titulo, String autor, String resume, String etiquetas, String propietario){
        try{
            PreparedStatement act = Entrada.conex.prepareStatement("UPDATE libros SET autor = ?, resume = ?, etiquetas = ? WHERE titulo = ? AND propietario = ?");
            act.setString(1, autor);
            act.setString(2, resume);
            act.setString(3, etiquetas);
            act.setString(4, titulo);
            act.setString(5, propietario);
            act.executeUpdate();
            
            PreparedStatement pd = Entrada.conex.prepareStatement("DELETE FROM etiquetas WHERE tituloLibro = ? AND creador = ?");
            pd.setString(1, titulo);
            pd.setString(2, propietario);
            pd.executeUpdate();
            
            for(String et : etiquetas.split(", ")){
                PreparedStatement novaE = Entrada.conex.prepareStatement("INSERT INTO etiquetas VALUES (?,?,?)");
                novaE.setString(1, titulo);
                novaE.setString(2, et);
                novaE.setString(3, propietario);
                novaE.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    /** 
     * Método para atopar os libros dun usuario dado que conteñen no resume un texto que se pasa como parámetro.
     * @param texto a buscar dentro do resume do libro.
     * @param propietario. Usuario que engadiu o libro á base de datos.
     */
    public static void buscador(String texto, String propietario){
        atopados.removeAll(atopados);
        try{
            PreparedStatement pB = Entrada.conex.prepareStatement("SELECT * FROM libros WHERE resume LIKE ? AND propietario = ?");
            pB.setString(1, "%"+texto+"%");
            pB.setString(2, propietario);
            ResultSet rsB = pB.executeQuery();
            while(rsB.next()){
                Libro atopado = new Libro();
                atopado.setTitulo(rsB.getString("titulo"));
                atopado.setAutor(rsB.getString("autor"));
                atopado.setResume(rsB.getString("resume"));
                atopado.setPropietario(rsB.getString("propietario"));
                atopado.setEtiquetas(rsB.getString("etiquetas"));
                atopados.add(atopado);
            }
            rsB.close();
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    /** 
     * Método para eliminar un libro do que se sabe o título.
     * @param titulo do libro a eliminar. 
     */
    public static void eliminarLibro(String titulo){
        try{
            PreparedStatement pD = Entrada.conex.prepareStatement("DELETE FROM libros WHERE titulo = ?");
            pD.setString(1, titulo);
            pD.executeUpdate();
            PreparedStatement pDE = Entrada.conex.prepareStatement("DELETE FROM etiquetas WHERE tituloLibro = ?");
            pDE.setString(1, titulo);
            pDE.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}

/**
 * Etiqueta. Describe o contido dun libro e créaa o usuario propietario de éste.
 * @author JRLV
 * @version 20/05/2014
 */
class Etiqueta{
    String libro;
    String textoEtiqueta;
    String creador;
    
    /**
     * Coleccións que acumulan as etiquetas.
     */
    public static ArrayList<Etiqueta> etiqu = new ArrayList<Etiqueta>();
    public static DefaultListModel modelo = new DefaultListModel();
    
    /**
     * Constructor sen parámetros.
     */
    public Etiqueta() {
    }

    /**
     * Getter
     * @return o libro ao que se refire a etiqueta.
     */
    public String getLibro() {
        return libro;
    }

    /**
     * Setter
     * @param libro ao que se asigna a etiqueta.
     */
    public void setLibro(String libro) {
        this.libro = libro;
    }

    /**
     * Getter
     * @return textoEtiqueta. Texto da etiqueta.
     */
    public String getTextoEtiqueta() {
        return textoEtiqueta;
    }

    /**
     * Setter
     * @param textoEtiqueta que define un libro
     */
    public void setTextoEtiqueta(String textoEtiqueta) {
        this.textoEtiqueta = textoEtiqueta;
    }

    /**
     * Texto da etiqueta
     * @return textoEtiqueta
     */
    @Override
    public String toString() {
        return textoEtiqueta;
    }
    
    /** 
     * Método para obter as etiquetas creadas por un usuario dado.
     * @param creador. Usuario que creou a etiqueta e o libro ao que se refire.
     */
    public static void mostrarEtiquetas(String creador){
        modelo.removeAllElements();
        try{
            PreparedStatement etiq = Entrada.conex.prepareStatement("SELECT DISTINCT texto FROM etiquetas WHERE creador = ?");
            etiq.setString(1, creador);
            ResultSet rsEtiq = etiq.executeQuery();
            while(rsEtiq.next()){
                Etiqueta e = new Etiqueta();
                e.setTextoEtiqueta(rsEtiq.getString("texto"));
                modelo.addElement(e.getTextoEtiqueta());
            }
            rsEtiq.close();
        }catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}