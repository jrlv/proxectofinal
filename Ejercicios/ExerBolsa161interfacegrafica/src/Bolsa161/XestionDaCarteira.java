/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bolsa161;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JRLV
 */
public class XestionDaCarteira extends javax.swing.JFrame {

    BolsaEnBD novaB = new BolsaEnBD();
    Cliente novoC = new Cliente();

    public XestionDaCarteira() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Xestión da Carteira");
        jTable3Carteira.setVisible(false);
        jTable3Bolsa.setVisible(false);
        jButton2Comprar.setVisible(false);
        jButton3Vender.setVisible(false);
    }

private void verCarteira(){
    PreparedStatement pb;
    jTable3Carteira.removeAll();
    try{
        pb = BolsaEnBD.con.prepareStatement("SELECT * FROM carteira WHERE cliente = ?");
        pb.setString(1, jTextField4Login.getText());
        ResultSet rb = pb.executeQuery();
        jTable3Carteira.setModel(DbUtils.resultSetToTableModel(rb));
        rb.close();
    }catch(SQLException e){
        System.out.println(e.getLocalizedMessage());
    }
}

private void verBolsa(){
    PreparedStatement pb;
    jTable3Bolsa.removeAll();
    try{
        pb = BolsaEnBD.con.prepareStatement("SELECT * FROM accions");
        ResultSet rb = pb.executeQuery();
        jTable3Bolsa.setModel(DbUtils.resultSetToTableModel(rb));
        rb.close();
    }catch(SQLException e){
        System.out.println(e.getLocalizedMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField9Clave = new javax.swing.JTextField();
        jTextField4Login = new javax.swing.JTextField();
        jButton1Identificarse = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3Carteira = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1Mensaxe = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextField1IdEmpresaCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2CantidadeCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3IdEmpresaVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4CantidadeVenta = new javax.swing.JTextField();
        jButton3Vender = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3Bolsa = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonResumoInversor = new javax.swing.JButton();
        jButtonResumoBolsa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jButton2Comprar = new javax.swing.JButton();
        jButton2Valorar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel10.setText("LOGIN:");

        jLabel11.setText("CLAVE:");

        jButton1Identificarse.setText("IDENTIFICARSE");
        jButton1Identificarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1IdentificarseActionPerformed(evt);
            }
        });

        jTable3Carteira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idEmpresa", "Cliente", "Cantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3Carteira);

        jButton1.setText("Volver a Acceso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("idEmpresa:");

        jLabel2.setText("Cantidade:");

        jLabel3.setText("idEmpresa:");

        jLabel4.setText("Cantidade:");

        jButton3Vender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3Vender.setText("VENDER");
        jButton3Vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3VenderActionPerformed(evt);
            }
        });

        jTable3Bolsa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idEmpresa", "Nome", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable3Bolsa);

        jButtonResumoInversor.setText("Resumo do Inversor");
        jButtonResumoInversor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResumoInversorActionPerformed(evt);
            }
        });

        jButtonResumoBolsa.setText("Resumo da Bolsa");
        jButtonResumoBolsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResumoBolsaActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2Comprar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2Comprar.setText("COMPRAR");
        jButton2Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ComprarActionPerformed(evt);
            }
        });

        jButton2Valorar.setText("Valorar Carteira do Inversor");
        jButton2Valorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ValorarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2Comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3Vender, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3IdEmpresaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4CantidadeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1IdEmpresaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2CantidadeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField1Mensaxe, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4Login, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField9Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1Identificarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonResumoInversor)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2Valorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(495, 495, 495)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonResumoBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1Mensaxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1Identificarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonResumoInversor)
                    .addComponent(jButton2Valorar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1IdEmpresaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2CantidadeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2Comprar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3Vender)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3IdEmpresaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4CantidadeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonResumoBolsa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1IdentificarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1IdentificarseActionPerformed
        if(novaB.identificar(jTextField4Login.getText(), jTextField9Clave.getText())){
            jTextField1Mensaxe.setText("Inversor atopado.");
            novoC.setLogin(jTextField4Login.getText());
            jTable3Carteira.setVisible(true);
            jTable3Bolsa.setVisible(true);
            verCarteira();
            verBolsa();
            jButton2Comprar.setVisible(true);
            jButton3Vender.setVisible(true);
        }else {
            jTextField1Mensaxe.setText("Inversor descoñecido.");
        }
    }//GEN-LAST:event_jButton1IdentificarseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Acceso acc = new Acceso();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3VenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3VenderActionPerformed
        novoC.vender(Integer.parseInt(jTextField3IdEmpresaVenta.getText()), Integer.parseInt(jTextField4CantidadeVenta.getText()));
        verCarteira();
    }//GEN-LAST:event_jButton3VenderActionPerformed

private void jButtonResumoInversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResumoInversorActionPerformed
    jTextArea2.setText(novoC.resumir());
}//GEN-LAST:event_jButtonResumoInversorActionPerformed

private void jButtonResumoBolsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResumoBolsaActionPerformed
    jTextArea1.setText(novaB.resumir());
}//GEN-LAST:event_jButtonResumoBolsaActionPerformed

    private void jButton2ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ComprarActionPerformed
        novoC.comprar(Integer.parseInt(jTextField1IdEmpresaCompra.getText()), Integer.parseInt(jTextField2CantidadeCompra.getText()));
        verCarteira();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ComprarActionPerformed

    private void jButton2ValorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ValorarActionPerformed
        jTextArea2.setText("O valor da Carteira de " + novoC.getLogin() + " é de " + novoC.valorar() + " euros.");
    }//GEN-LAST:event_jButton2ValorarActionPerformed

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
            java.util.logging.Logger.getLogger(XestionDaCarteira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XestionDaCarteira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XestionDaCarteira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XestionDaCarteira.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XestionDaCarteira().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Identificarse;
    private javax.swing.JButton jButton2Comprar;
    private javax.swing.JButton jButton2Valorar;
    private javax.swing.JButton jButton3Vender;
    private javax.swing.JButton jButtonResumoBolsa;
    private javax.swing.JButton jButtonResumoInversor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable3Bolsa;
    private javax.swing.JTable jTable3Carteira;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1IdEmpresaCompra;
    private javax.swing.JTextField jTextField1Mensaxe;
    private javax.swing.JTextField jTextField2CantidadeCompra;
    private javax.swing.JTextField jTextField3IdEmpresaVenta;
    private javax.swing.JTextField jTextField4CantidadeVenta;
    private javax.swing.JTextField jTextField4Login;
    private javax.swing.JTextField jTextField9Clave;
    // End of variables declaration//GEN-END:variables
}
