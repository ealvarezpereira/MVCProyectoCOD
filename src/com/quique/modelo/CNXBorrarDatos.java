/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import com.quique.controlador.CTRLBorrarDatos;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CNXBorrarDatos {

    public static Connection conn;
    public static DatabaseMetaData meta;

    //Metodo para la conexion directa a la base de datos
    public static Connection conexionABD() {
        try {
            String url = "jdbc:sqlite:" + "/home/quique/Documentos/BasesDatos/base.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println("Error de conexion " + ex);
        }

        return conn;
    }

    //Metodo para recargar las tablas en el jcombobox. Directo al constructor de BorrarDatos
    public static ResultSet borrarDatosConstructor() {
        ResultSet r = null;
        try {
            meta = conn.getMetaData();
            r = meta.getTables(null, null, null, null);

        } catch (SQLException ex) {
            System.out.println("Error metadata " + ex);
        }

        return r;
    }

    private static Statement st;
    private static ResultSet rs;
    private static JComboBox tablas;

    public static ResultSet borrarDatosResultSet() {

        tablas = CTRLBorrarDatos.tablas();

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from " + String.valueOf(tablas.getSelectedItem()));
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar datos. " + ex);
        }

        return rs;
    }

    public static DefaultTableModel modeloBorrarDatos() {

        DefaultTableModel modelo = new DefaultTableModel();

        try {

            while (borrarDatosResultSet().next()) {
                Object[] list = new Object[borrarDatosResultSet().getMetaData().getColumnCount()];

                for (int i = 0; i < borrarDatosResultSet().getMetaData().getColumnCount(); i++) {
                    list[i] = borrarDatosResultSet().getString(i + 1);
                }
                modelo.addRow(list);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el modelo. " + ex);
        }

        return modelo;
    }

    private static boolean con = false;
    private static String where = "";

    public static void botonBorrarDatos() {

        if (con == false) {
            try {

                PreparedStatement pst = CNXBorrarDatos.conn.prepareStatement("delete from "
                        + String.valueOf(tablas.getSelectedItem()));
                pst.executeUpdate();
                System.out.println("Hecho.");
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Error al borrar datos. " + ex);
            }

        } else {

            try {
                where = " where " + CTRLBorrarDatos.recibirCampos().getSelectedItem() + " = " + "'" + CTRLBorrarDatos.textoCond() + "';";

                PreparedStatement pst = CNXBorrarDatos.conn.prepareStatement("delete from "
                        + String.valueOf(tablas.getSelectedItem()) + where);
                pst.executeUpdate();
                System.out.println("Pene. Hecho.");

                pst.close();

            } catch (SQLException ex) {
                System.out.println("Error al buscar datos. " + ex);
            }
        }
    }
    
    public static void botonCondicion(){
        try {
            con = true;

            Statement st = CNXBorrarDatos.conn.createStatement();
            ResultSet rs = st.executeQuery("select * from " + String.valueOf(CTRLBorrarDatos.tablas().getSelectedItem()));

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                CTRLBorrarDatos.recibirCampos().addItem(rs.getMetaData().getColumnName(i + 1));
            }

            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }
}
