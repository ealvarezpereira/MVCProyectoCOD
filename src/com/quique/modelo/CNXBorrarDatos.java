/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import com.quique.controlador.CTRLBorrarDatos;
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
public class CNXBorrarDatos {

    //Metodo para recargar las tablas en el jcombobox. Directo al constructor de BorrarDatos
    public static ArrayList<String> constructorDeBorrarDatos() {
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

    public static DefaultTableModel botonRecargarDeBorrarDatos() {
        DefaultTableModel mimodelo = new DefaultTableModel();
        try {

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLBorrarDatos.tablas());

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

    private static boolean con = false;
    private static String where = "";

    public static ArrayList<String> botonCondicionDeBorrarDatos() {
        ArrayList<String>concampos = new ArrayList<String>();
        try {

            con = true;

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLBorrarDatos.tablas());

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
    
    public static void borrarDatos(String concampos,String textoCondicion){
    
        if (con == false) {
            try {

                PreparedStatement pst = ConexionBD.conn.prepareStatement("delete from "
                        + CTRLBorrarDatos.tablas());
                pst.executeUpdate();
                System.out.println("Hecho.");

                pst.close();

            } catch (SQLException ex) {
                System.out.println("Error al borrar datos. " + ex);
            }

        } else {

            try {
                where = " where " + concampos + " = " + "'" + textoCondicion + "';";

                PreparedStatement pst = ConexionBD.conn.prepareStatement("delete from "
                        + CTRLBorrarDatos.tablas()+where);
                pst.executeUpdate();
                pst.close();
                
            } catch (SQLException ex) {
                System.out.println("Error al buscar datos. " + ex);
            }
        }
    }

}
