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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CNXInsertar {

    private static DefaultTableModel mimodelo;
    private static ResultSet r;

    public static ArrayList<String> constructorDeInsertar() {
        ResultSet r;
        ArrayList<String> tablas = new ArrayList<String>();
        DatabaseMetaData meta;
        try {
            meta = ConexionBD.conn.getMetaData();
            r = meta.getTables(null, null, null, null);

            while (r.next()) {
                tablas.add(r.getString("TABLE_NAME"));
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Error en el constructor " + ex);
        }

        return tablas;
    }

    public static DefaultTableModel botonRecargarDeInsertarBoolTrue() {

        try {
            mimodelo = new DefaultTableModel();
            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLInsertar.tablas());

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

            st.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error metadata " + ex);
        }

        return mimodelo;
    }

    public static void botonRecargarDeInsertarBoolFalse(String cadena) {

        try {

            PreparedStatement st = ConexionBD.conn.prepareStatement("insert into "
                    + CTRLInsertar.tablas()
                    + " values (" + cadena + ");");
            st.executeUpdate();
            System.out.println("Realizado.");
            CTRLInsertar.cambiarBoolean();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Error en el metodo false. " + ex);
        }
    }

}
