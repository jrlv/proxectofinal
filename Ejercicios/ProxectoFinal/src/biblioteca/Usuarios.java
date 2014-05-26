package biblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para xestionar os libros dos que é propietario
 * @author JOSELV
 * @version 21/05/2014
 */
public class Usuarios extends javax.swing.JFrame {
    
    /**
     * Constructor. Compoñentes iniciais e frame no centro da pantalla.
     */
    public Usuarios() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Usuarios da biblioteca popular");
        jLabel2.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel4.setEnabled(false);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel7.setEnabled(false);
        jLabel8.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextArea1.setEnabled(false);
        jTextArea2.setEnabled(false);
        jTextArea3.setEnabled(false);
        jTextArea4.setEnabled(false);
        jList2.setEnabled(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        jScrollPane1.setEnabled(false);
        jScrollPane2.setEnabled(false);
        jScrollPane3.setEnabled(false);
        jScrollPane4.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField8 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Acceso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Libro:");

        jLabel3.setText("Título:");

        jLabel4.setText("Autor:");

        jLabel5.setText("Resume:");

        jLabel6.setText("Etiquetas:");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Engadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Libros do usuario:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Etiquetas:");

        jScrollPane2.setViewportView(jList2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jButton3.setText("VOLTA AO INICIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Buscar libros por etiquetas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Buscar por Texto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane1.setViewportView(jTextArea3);

        jButton6.setText("Editar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("Eliminar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel9.setText("Contrasinal");

        jButton9.setText("Lembrar contrasinal");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
                                    .addComponent(jScrollPane3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5))))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Introdúcese un nome, créase un usuario co nome introducido,
    // compróbase a súa existencia dentro da base de datos co método Existe
    // e de existir móstranse os libros e etiquetas que lle pertenecen.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Usuario actual = new Usuario(jTextField1.getText());
            if (actual.Existe(jTextField1.getText(), jPasswordField1.getPassword())){
                jTextField2.setText("Hola " + actual.getNome() + ".");
                jLabel2.setEnabled(true);
                jLabel3.setEnabled(true);
                jLabel4.setEnabled(true);
                jLabel5.setEnabled(true);
                jLabel6.setEnabled(true);
                jLabel7.setEnabled(true);
                jLabel8.setEnabled(true);
                jTextField3.setEnabled(true);
                jTextField4.setEnabled(true);
                jTextField6.setEnabled(true);
                jTextField7.setEnabled(true);
                jTextField3.setText(null);
                jTextField4.setText(null);
                jTextField6.setText(null);
                jTextField7.setText(null);
                jTextArea1.setEnabled(true);
                jTextArea2.setEnabled(true);
                jTextArea3.setEnabled(true);
                jTextArea4.setEnabled(true);
                jTextArea2.setText(null);
                jTextArea3.setText(null);
                jTextArea4.setText(null);
                jTextField8.setEnabled(true);
                jTextField8.setText(null);
                jList2.setEnabled(true);
                jButton2.setEnabled(true);
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
                jButton6.setEnabled(true);
                jButton7.setEnabled(true);
                jScrollPane1.setEnabled(true);
                jScrollPane2.setEnabled(true);
                jScrollPane3.setEnabled(true);
                jScrollPane4.setEnabled(true);

                Libro.mostrarLibros(actual.getNome());
                jTextArea1.setText(Libro.libros.toString());
                Etiqueta.mostrarEtiquetas(actual.getNome());
                jList2.setModel(Etiqueta.modelo);
            }else{
                jTextField2.setText("Usuario descoñedido.");
                jButton9.setEnabled(true);
                jLabel2.setEnabled(false);
                jLabel3.setEnabled(false);
                jLabel4.setEnabled(false);
                jLabel5.setEnabled(false);
                jLabel6.setEnabled(false);
                jLabel7.setEnabled(false);
                jLabel8.setEnabled(false);
                jTextField3.setEnabled(false);
                jTextField4.setEnabled(false);
                jTextField6.setEnabled(false);
                jTextField7.setEnabled(false);
                jTextField8.setEnabled(false);
                jTextArea1.setEnabled(false);
                jTextArea2.setEnabled(false);
                jTextArea3.setEnabled(false);
                jTextArea4.setEnabled(false);
                jList2.setEnabled(false);
                jButton2.setEnabled(false);
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
                jButton6.setEnabled(false);
                jButton7.setEnabled(false);
                jButton8.setEnabled(false);
                jScrollPane1.setEnabled(false);
                jScrollPane2.setEnabled(false);
                jScrollPane3.setEnabled(false);
                jScrollPane4.setEnabled(false);
            }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Introdúcense os datos dun novo libro para engadir,
    // compróbase a súa existencia na base de datos,
    // se non existe engádese e móstranse os datos do
    // usuario que engade o libro actualizados.
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Libro novoL = new Libro(jTextField3.getText());
        try{
            PreparedStatement ps = Entrada.conex.prepareStatement("SELECT * FROM libros WHERE titulo = ?");
            ps.setString(1, jTextField3.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                jTextField7.setText(jTextField3.getText() + " xa está na base de datos.");
            } else{
                novoL.novoLibro(jTextField3.getText(), jTextField4.getText(), jTextArea4.getText(), jTextField1.getText(), jTextField6.getText());
                jTextField7.setText(jTextField3.getText() + " engadiuse correctamente.");
            }
        }catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        
        jTextArea1.removeAll();
        Libro.mostrarLibros(jTextField1.getText());
        jTextArea1.setText(Libro.libros.toString());
        
        jList2.removeAll();
        Etiqueta.mostrarEtiquetas(jTextField1.getText());
        jList2.setModel(Etiqueta.modelo);
    }//GEN-LAST:event_jButton2ActionPerformed
    // Volta ao inicio ocultando outros frames.
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    // Buscar e mostrar os libros do usuario actual que están etiquetados coas etiquetas seleccionadas.
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if (jList2.getSelectedIndex() != -1){
            jTextArea2.setText("");
            for(Object eS : jList2.getSelectedValuesList()){
                try{
                PreparedStatement pes = Entrada.conex.prepareStatement("SELECT titulo, resume, etiquetas FROM libros WHERE titulo IN "
                        + "(SELECT tituloLibro FROM etiquetas WHERE texto = ? AND creador = ?)");
                pes.setString(1, eS.toString());
                pes.setString(2, jTextField1.getText());
                ResultSet rsEt = pes.executeQuery();
                while(rsEt.next()){
                    Libro atopado = new Libro();
                    atopado.setTitulo(rsEt.getString("titulo"));
                    atopado.setResume(rsEt.getString("resume"));
                    atopado.setEtiquetas(rsEt.getString("etiquetas"));
                    String resultado = "TITULO: " + atopado.getTitulo() + ". RESUME: " + atopado.getResume() + ". ETIQUETAS: " + atopado.getEtiquetas() + "\n";
                    jTextArea2.setText(jTextArea2.getText() + resultado);
                }
                rsEt.close();
                }catch (SQLException e){
                    System.out.println(e.getLocalizedMessage());
                }
            }
        } else {
            jTextArea2.setText("Para atopar resultados selecciona unha ou varias etiquetas.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    // Buscar e mostrar os libros do usuario actual que conteñen no seu resume un texto dado.
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        if(!jTextField8.getText().equals("")){
            jTextArea3.removeAll();
            Libro.buscador(jTextField8.getText(), jTextField1.getText());
            jTextArea3.setText(Libro.atopados.toString());
        }else jTextArea3.setText("Escribe na caixa de arriba un texto para buscar.");
    }//GEN-LAST:event_jButton5ActionPerformed
    // Introdúcese un título, compróbase a súa existencia na base de datos
    // e en caso de existir móstranse os seus datos para poder editalos.
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        if(!jTextField3.getText().equals("")){
            Usuario usu = new Usuario(jTextField1.getText());
            usu.setNome(jTextField1.getText());
            Libro editable = new Libro(jTextField3.getText());
            editable.setTitulo(jTextField3.getText());
            jTextField7.setText("");
            try{
                PreparedStatement pE = Entrada.conex.prepareStatement("SELECT * FROM libros WHERE titulo = ? AND propietario = ?");
                pE.setString(1, editable.getTitulo());
                pE.setString(2, usu.getNome());
                ResultSet rsPE = pE.executeQuery();
                if(rsPE.next()){
                    editable.setAutor(rsPE.getString("autor"));
                    jTextField4.setText(editable.getAutor());
                    editable.setResume(rsPE.getString("resume"));
                    jTextArea4.setText(editable.getResume());
                    editable.setEtiquetas(rsPE.getString("etiquetas"));
                    jTextField6.setText(editable.getEtiquetas());
                    editable.setPropietario(rsPE.getString("propietario"));
                    jButton8.setEnabled(true);
                }else {
                    jTextField3.setText("Libro descoñedido.");
                }
            }catch(SQLException e){
                System.out.println(e.getLocalizedMessage());
            }
        }else {
            jTextField3.setText("Escribe o titulo dun libro para editalo.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    // Actualiza os datos do libro editado.
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(!jTextField3.getText().equals("")){
            Libro actual = new Libro(jTextField3.getText());
            try{
                PreparedStatement ps = Entrada.conex.prepareStatement("SELECT * FROM libros WHERE titulo = ?");
                ps.setString(1, jTextField3.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    actual.actualizar(jTextField3.getText(), jTextField4.getText(), jTextArea4.getText(), jTextField6.getText(), jTextField1.getText());
                    jTextField7.setText(jTextField3.getText() + " foi actualizado correctamente.");
                } else{
                    jTextField7.setText("Este título non se pode actualizar.");
                }
            }catch (SQLException e){
                System.out.println(e.getLocalizedMessage());
            }

            jTextArea1.removeAll();
            Libro.mostrarLibros(jTextField1.getText());
            jTextArea1.setText(Libro.libros.toString());

            jList2.removeAll();
            Etiqueta.mostrarEtiquetas(jTextField1.getText());
            jList2.setModel(Etiqueta.modelo);
        }else {
            jTextField3.setText("Escribe o titulo dun libro para editalo.");
        }
    }//GEN-LAST:event_jButton7ActionPerformed
    // Elimina o libro que se mostra para editar.
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(!jTextField3.getText().equals("")){
            Libro libroAborrar = new Libro(jTextField3.getText());
            libroAborrar.setTitulo(jTextField3.getText());
            try{
                PreparedStatement pb = Entrada.conex.prepareStatement("SELECT * FROM libros WHERE titulo = ?");
                pb.setString(1, libroAborrar.getTitulo());
                ResultSet rb = pb.executeQuery();
                if (rb.next()){
                    libroAborrar.eliminarLibro(jTextField3.getText());
                } else{
                    jTextField3.setText("Este libro non existe na base de datos.");
                }
            }catch (SQLException e){
                System.out.println(e.getLocalizedMessage());
            }
            jTextArea1.removeAll();
            Libro.mostrarLibros(jTextField1.getText());
            jTextArea1.setText(Libro.libros.toString());

            jList2.removeAll();
            Etiqueta.mostrarEtiquetas(jTextField1.getText());
            jList2.setModel(Etiqueta.modelo);            
        }else {
            jTextField3.setText("Escribe o titulo dun libro para editalo.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try{
            PreparedStatement pr = Entrada.conex.prepareStatement("SELECT contrasinal FROM usuarios WHERE nome = ?");
            pr.setString(1, jTextField1.getText());
            ResultSet rr = pr.executeQuery();
            while(rr.next()){
                String contraEncriptada = rr.getString("contrasinal");
                System.out.println("Encriptada: " + contraEncriptada);
                char[] arrayD = contraEncriptada.toCharArray();
                for (int i= 0; i<arrayD.length; i++){
                    arrayD[i] = (char)(arrayD[i] - (char)4);
                }
                String desencriptado = String.valueOf(arrayD);
                System.out.println("A contrasinal é: " + desencriptado);
            }
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
