/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import com.quique.controlador.CTRLModificarDatos;
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
public class CNXModificarDatos {

    /**
     * Carga los nombres de las tablas en un jcombobox.
     * @return array de nombres de tablas
     */
    public static ArrayList<String> constructorModificarDatos() {

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

    /**
     * Recarga los datos de la tabla seleccionada.
     * @return modelo de tabla.
     */
    public static DefaultTableModel botonRecargar() {
        DefaultTableModel mimodelo = new DefaultTableModel();
        try {

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLModificarDatos.tablas());

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

    static ArrayList<String> acampos = new ArrayList<String>();
    static String where = "";
    static String cadena = "";

    /**
     * Modifica los datos de la fila de la tabla seleccionada
     * @param adatos Array de datos
     * @param concampos Condicion por la cual modificas
     * @param textoCondicion Texto de la condicion
     */
    public static void botonModificar(ArrayList<String> adatos,String concampos, String textoCondicion) {
        try {

            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLModificarDatos.tablas());

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                acampos.add(rs.getMetaData().getColumnName(i + 1));
            }

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

                if (i == rs.getMetaData().getColumnCount() - 1) {
                    cadena = cadena + acampos.get(i) + " = " + "'" + adatos.get(i) + "'";
                } else {
                    cadena = cadena + acampos.get(i) + " = " + "'" + adatos.get(i) + "'" + ",";
                }

            }
            where = " where " + concampos + " = " + "'" + textoCondicion + "';";

            PreparedStatement pst = ConexionBD.conn.prepareStatement("update " + CTRLModificarDatos.tablas() + " set "
                    + cadena + where);
            pst.executeUpdate();
            System.out.println("Hecho.");

            pst.close();
            st.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar datos. " + ex);
        }

    }

    /**
     * Boton que habilita la condicion
     * @return array de nombres de campos
     */
    public static ArrayList<String> botonCondicion() {

        ArrayList<String> concampos = new ArrayList<String>();
        try {
            Statement st = ConexionBD.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + CTRLModificarDatos.tablas());

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
