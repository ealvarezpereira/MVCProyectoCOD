/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;

import com.quique.modelo.CNXBorrarDatos;
import com.quique.vista.BorrarDatos;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CTRLBorrarDatos {

    private static Connection conexion;

    public static Connection conn() {
        return conexion = CNXBorrarDatos.conexionABD();
    }

    private static ResultSet r;

    public static ResultSet resul() {
        return r = CNXBorrarDatos.borrarDatosConstructor();
    }

    private static JComboBox tablas;

    public static JComboBox tablas() {
        return tablas = BorrarDatos.tablas;
    }

    private static ResultSet r2;

    public static ResultSet resul2() {
        return r2 = CNXBorrarDatos.borrarDatosResultSet();
    }

    private static DefaultTableModel model;

    public static DefaultTableModel modelo() {
        return model = CNXBorrarDatos.modeloBorrarDatos();
    }

    private static JComboBox<String> campos;

    public static JComboBox recibirCampos() {
        return campos = BorrarDatos.concampos;
    }

    private static String textCond;

    public static String textoCond() {
        return textCond = BorrarDatos.textoCondicion.getText();
    }
    
    public static void botonBorrarDatos(){
        CNXBorrarDatos.botonBorrarDatos();
    }

    public static void botonCondicion(){
        CNXBorrarDatos.botonCondicion();
    }
}
