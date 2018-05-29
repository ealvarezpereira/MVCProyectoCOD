/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import com.quique.controlador.CTRLInsertar;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author quique
 */
public class CNXInsertar {

    private static DefaultTableModel mimodelo;
    private static String prueba;
    private static boolean cargado = true;
    private static ResultSet r;

    public static ResultSet constructorInsertar() {

        try {
            DatabaseMetaData meta;
            meta = ConexionBD.conexionABD().getMetaData();
            r = meta.getTables(null, null, null, null);

            r.close();
        } catch (SQLException ex) {
            System.out.println("Error metadata " + ex);
        }
        return r;
    }

    //igual los datos.setModel se pueden reducir a 1.
    public static DefaultTableModel recargar() {

        if (cargado == true) {
            try {
                mimodelo = new DefaultTableModel();
                Statement st = ConexionBD.conexionABD().createStatement();
                ResultSet rs = st.executeQuery("select * from " + String.valueOf(CTRLInsertar.tablas().getSelectedItem()));

                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    mimodelo.addColumn(rs.getMetaData().getColumnName(i + 1));
                }



                while (rs.next()) {
                    Object[] list = new Object[rs.getMetaData().getColumnCount()];

                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        list[i] = rs.getString(i + 1);
                    }
                    mimodelo.addRow(list);
                }
                prueba = String.valueOf(CTRLInsertar.tablas().getSelectedItem());

                st.close();
                rs.close();

            } catch (SQLException ex) {
                System.out.println("Error metadata " + ex);
            }

        } else {

            String cadena = "";

            try {

                int lastRow = CTRLInsertar.datos().getRowCount() - 1;

                for (int i = 0; i < CTRLInsertar.datos().getColumnCount(); i++) {

                    if (i == CTRLInsertar.datos().getColumnCount() - 1) {
                        cadena = cadena + "'" + CTRLInsertar.datos().getValueAt(lastRow, i) + "'";
                    } else {
                        cadena = cadena + "'" + CTRLInsertar.datos().getValueAt(lastRow, i) + "'" + ", ";
                    }
                }

                PreparedStatement st = ConexionBD.conexionABD().prepareStatement("insert into "
                        + String.valueOf(CTRLInsertar.tablas().getSelectedItem())
                        + " values (" + cadena + ");");
                st.executeUpdate();
                System.out.println("Realizado.");
                cargado = true;
                st.close();

            } catch (Exception ex) {
                System.out.println("Error de inserccion " + ex);
            }
        }

        return mimodelo;
    }

    public static DefaultTableModel añadir() {
        cargado = false;
        Vector v = new Vector();
        mimodelo.addRow(v);
        return mimodelo;
    }
}
