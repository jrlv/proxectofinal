package Exercicio151;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnlacesUsuarios extends javax.swing.JFrame {
    ArrayList<Enlace> enlaces = new ArrayList<Enlace>();
    ArrayList<String> etiquetas = new ArrayList<String>();
    Enlace novoEnlace;

    public EnlacesUsuarios() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Engadir enlaces");
        jLabel4Título.setVisible(false);
        jLabel5Comentarios.setVisible(false);
        jLabel6Etiquetas.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        jCheckBox1Público.setVisible(false);
        jCheckBox2Privado.setVisible(false);
        jButton2Engadir.setVisible(false);
        Enlace.obterEnlaces();
        jTextArea1.setText(Enlace.enlaces.toString());
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1Inicio = new javax.swing.JButton();
        jLabel4Título = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5Comentarios = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6Etiquetas = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jCheckBox1Público = new javax.swing.JCheckBox();
        jCheckBox2Privado = new javax.swing.JCheckBox();
        jButton2Engadir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();

        jLabel1.setText("Nome");

        jLabel3.setText("Clave");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Direcciones:");

        jButton1Inicio.setText("INICIO");
        jButton1Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1InicioActionPerformed(evt);
            }
        });

        jLabel4Título.setText("Título url:");

        jLabel5Comentarios.setText("Comentario:");

        jLabel6Etiquetas.setText("Etiquetas:");

        jCheckBox1Público.setText("Público");

        jCheckBox2Privado.setText("Privado");

        jButton2Engadir.setText("Engadir");
        jButton2Engadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2EngadirActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome");

        jLabel5.setText("Clave");

        jLabel6.setText("ID Usuario");

        jButton1.setText("Verificar usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mensaxe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1Inicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1Público)
                                .addGap(10, 10, 10)
                                .addComponent(jCheckBox2Privado))
                            .addComponent(jButton2Engadir)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel6)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4Título)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField3))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6Etiquetas)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5Comentarios)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4Título)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5Comentarios)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6Etiquetas)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1Público)
                    .addComponent(jCheckBox2Privado))
                .addGap(18, 18, 18)
                .addComponent(jButton2Engadir)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jButton1Inicio)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1InicioActionPerformed
        Entrada entrada = new Entrada();
        entrada.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1InicioActionPerformed

    private void jButton2EngadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2EngadirActionPerformed
        
    for(String et : jTextField5.getText().split(",")){
        etiquetas.add(et);
    }

    int público;
    if (jCheckBox1Público.isSelected()){
        público=1;
        novoEnlace = new Enlace(jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), Integer.parseInt(jTextField8.getText()), público);
        enlaces.add(novoEnlace);
    } else {
        if(jCheckBox2Privado.isSelected()){
            público=0;
            novoEnlace = new Enlace(jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), Integer.parseInt(jTextField8.getText()), público);
            enlaces.add(novoEnlace);
        }
    } 
        
    for(String etq : etiquetas){
        try{
            PreparedStatement pet = Entrada.connection.prepareStatement("INSERT INTO etiquetas VALUES(?, ?)");
            pet.setInt(1, novoEnlace.getId());
            pet.setString(2, etq);
            int inseridas = pet.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_jButton2EngadirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(Usuario.Existe(jTextField6.getText(), jTextField7.getText())){
            jTextField8.setText(Usuario.Id(jTextField6.getText(), jTextField7.getText()));
            jTextField9.setText("Benvido");
            jLabel4Título.setVisible(true);
            jLabel5Comentarios.setVisible(true);
            jLabel6Etiquetas.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jCheckBox1Público.setVisible(true);
            jCheckBox2Privado.setVisible(true);
            jButton2Engadir.setVisible(true);
        } else {
            jTextField8.setText("");
            jTextField9.setText("Descoñecido!!!!");
            jLabel4Título.setVisible(false);
            jLabel5Comentarios.setVisible(false);
            jLabel6Etiquetas.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jTextField5.setVisible(false);
            jCheckBox1Público.setVisible(false);
            jCheckBox2Privado.setVisible(false);
            jButton2Engadir.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EnlacesUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnlacesUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnlacesUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnlacesUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnlacesUsuarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Inicio;
    private javax.swing.JButton jButton2Engadir;
    private javax.swing.JCheckBox jCheckBox1Público;
    private javax.swing.JCheckBox jCheckBox2Privado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4Título;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel5Comentarios;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel6Etiquetas;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
