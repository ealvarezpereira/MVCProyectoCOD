/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.vista;

import codproyectomvc.CODProyectoMVC;
import com.quique.controlador.Controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.quique.modelo.ConexionBD;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class BorrarDatos extends javax.swing.JFrame {

    /**
     * Creates new form Tablas
     */
    public BorrarDatos() {

        initComponents();
        this.setLocationRelativeTo(null);
        concampos.setVisible(false);
        textoCondicion.setVisible(false);
        interrogante2.setVisible(false);

        try {
            while (Controlador.resul().next()) {
                tablas.addItem(Controlador.resul().getString("TABLE_NAME"));
            }
        } catch (SQLException ex) {
            System.out.println("Error en el constructor: " + ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        tablas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTable();
        recargar = new javax.swing.JButton();
        interrogante = new javax.swing.JLabel();
        borrar = new javax.swing.JButton();
        condicion = new javax.swing.JButton();
        concampos = new javax.swing.JComboBox<>();
        textoCondicion = new javax.swing.JTextField();
        interrogante2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Tablas:");

        datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(datos);
        if (datos.getColumnModel().getColumnCount() > 0) {
            datos.getColumnModel().getColumn(0).setResizable(false);
            datos.getColumnModel().getColumn(1).setResizable(false);
            datos.getColumnModel().getColumn(2).setResizable(false);
            datos.getColumnModel().getColumn(3).setResizable(false);
        }

        recargar.setText("Recargar");
        recargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarActionPerformed(evt);
            }
        });

        interrogante.setText("?");
        interrogante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                interroganteMouseClicked(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        condicion.setText("...");
        condicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                condicionActionPerformed(evt);
            }
        });

        interrogante2.setText("?");
        interrogante2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                interrogante2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tablas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(recargar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(aceptar)))
                            .addComponent(interrogante))
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(concampos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textoCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(interrogante2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(condicion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(interrogante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(borrar)
                        .addGap(4, 4, 4)
                        .addComponent(condicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(interrogante2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(concampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aceptar)
                            .addComponent(recargar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarActionPerformed

        try {
            DefaultTableModel mimodelo = new DefaultTableModel();
            datos.setEnabled(false);
            
                        for (int i = 0; i <Controlador.resul2().getMetaData().getColumnCount(); i++) {
                mimodelo.addColumn(Controlador.resul2().getMetaData().getColumnName(i + 1));
            }

            datos.setModel(mimodelo);

            while (Controlador.resul2().next()) {
                Object[]list = new Object[Controlador.resul2().getMetaData().getColumnCount()];

                for (int i = 0; i < Controlador.resul2().getMetaData().getColumnCount(); i++) {
                    list[i] = Controlador.resul2().getString(i + 1);
                }
                mimodelo.addRow(list);
            }
            datos.setModel(mimodelo);
            concampos.removeAllItems();
            

        } catch (Exception ex) {
            System.out.println("Error metadata " + ex);
        }
        textoCondicion.setVisible(false);
        concampos.setVisible(false);
        interrogante2.setVisible(false);
    }//GEN-LAST:event_recargarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        Menu men = new Menu();
        this.setVisible(false);
        men.setVisible(true);
    }//GEN-LAST:event_aceptarActionPerformed

    private void interroganteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_interroganteMouseClicked

        JOptionPane.showMessageDialog(null, "Borrar: Borra los datos en la tabla."
                + "\n... : Filtra los datos que quieres borrar.");
    }//GEN-LAST:event_interroganteMouseClicked

    boolean con = false;
    String where = "";

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed

        if (con == false) {
            try {

                PreparedStatement pst = ConexionBD.conn.prepareStatement("delete from "
                        + String.valueOf(tablas.getSelectedItem()));
                pst.executeUpdate();
                System.out.println("Hecho.");

                textoCondicion.setText(null);
                pst.close();

            } catch (SQLException ex) {
                System.out.println("Error al borrar datos. " + ex);
            }

        } else {

            try {
                where = " where " + concampos.getSelectedItem() + " = " + "'" + textoCondicion.getText() + "';";

                PreparedStatement pst = ConexionBD.conn.prepareStatement("delete from "
                        + String.valueOf(tablas.getSelectedItem()) + where);
                pst.executeUpdate();
                System.out.println("Pene. Hecho.");

                textoCondicion.setText(null);
                pst.close();

            } catch (SQLException ex) {
                System.out.println("Error al buscar datos. " + ex);
            }
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void condicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_condicionActionPerformed
        try {
            textoCondicion.setVisible(true);
            interrogante2.setVisible(true);
            concampos.setVisible(true);
            con = true;

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + String.valueOf(tablas.getSelectedItem()));

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                concampos.addItem(rs.getMetaData().getColumnName(i + 1));
            }

            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }//GEN-LAST:event_condicionActionPerformed

    private void interrogante2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_interrogante2MouseClicked
        JOptionPane.showMessageDialog(null, "Cuadro de texto: Valor que quieres borrar"
                + "\nComboBox : Campo del valor que quieres borrar");
    }//GEN-LAST:event_interrogante2MouseClicked

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
            java.util.logging.Logger.getLogger(BorrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrarDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton borrar;
    public javax.swing.JComboBox<String> concampos;
    public javax.swing.JButton condicion;
    public javax.swing.JTable datos;
    public javax.swing.JLabel interrogante;
    public javax.swing.JLabel interrogante2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton recargar;
    public static javax.swing.JComboBox<String> tablas;
    public javax.swing.JTextField textoCondicion;
    // End of variables declaration//GEN-END:variables
}
