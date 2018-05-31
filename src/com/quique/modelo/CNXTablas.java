/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import java.sql.DatabaseMetaData;
import com.quique.controlador.CTRLTablas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CNXTablas {

    public static ArrayList<String> constructorDeTablas() {
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

    public static DefaultTableModel botonRecargarDeTablas() {
        DefaultTableModel mimodelo = new DefaultTableModel();
        try {

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLTablas.tablas());

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

    static String where = "";

    public static DefaultTableModel botonBuscarCondFalse(String elemento) {

        DefaultTableModel mimodelo = new DefaultTableModel();
        try {

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select " + elemento + " from " + CTRLTablas.tablas());
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
            System.out.println("Error al buscar datos. " + ex);
        }
        return mimodelo;
    }

    public static DefaultTableModel botonBuscarCondTrue(String elemento, String concampos, String textoCondicion) {
        
        DefaultTableModel mimodelo = new DefaultTableModel();
        try {

            Statement st = ConexionBD.conn.createStatement();

            where = " where " + concampos + " = " + "'" + textoCondicion + "';";
            ResultSet rs = st.executeQuery("select " + elemento + " from " + CTRLTablas.tablas() + where);

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
            System.out.println("Error al buscar datos. " + ex);
        }

        return mimodelo;
    }
    
        public static ArrayList<String> botonCondicionDeTablas() {
        ArrayList<String>concampos = new ArrayList<String>();
        try {

            CTRLTablas.cambiarBoolean();

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLTablas.tablas());

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                concampos.add(rs.getMetaData().getColumnName(i + 1));
            }

            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        
        return concampos;
    }
}
