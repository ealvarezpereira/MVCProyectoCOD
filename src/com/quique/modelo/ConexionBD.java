/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import com.quique.controlador.Controlador;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author quique
 */
public class ConexionBD {

    public static Connection conn;
    public static DatabaseMetaData meta;

    public static Connection conexionABD() {
        try {
            String url = "jdbc:sqlite:" + "/home/quique/Documentos/BasesDatos/base.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println("Error de conexion " + ex);
        }

        return conn;
    }

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

        tablas = Controlador.tablas();

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from " + String.valueOf(tablas.getSelectedItem()));
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar datos. " + ex);
        }

        return rs;
    }

}
