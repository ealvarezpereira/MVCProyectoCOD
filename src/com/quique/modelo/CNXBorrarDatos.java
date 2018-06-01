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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CNXBorrarDatos {

    /**
     * Método que recibe los nombres de las tablas de la base de datos y los guarda en un Array
     * Este método se ejecuta en el constructor
     * @return tablas Es el array de nombres de tablas.
     */
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

    /**
     * Metodo que según la tabla que haya seleccionada en el combobox,
     * recibe los datos de esa tabla, y los guarda en un DefaultTableModel
     * @return mimodelo Retorna el DefaultTableModel
     */
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

    /**
     * Metodo que al pulsar el boton de establecer condición para borrar los datos, carga
     * en un JComboBox los campos de la tabla seleccionada.
     * @return concampos Retorna un arraylist de campos
     */
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
    
    /**
     * Metodo que borra los datos de la tabla de la base de datos
     * Si con = false quiere decir que borra todos los datos de la tabla
     * Si con = true quiere decir que borra un dato especifico
     * @param concampos Recibe el campo seleccionado del jcombobox de la condición
     * @param textoCondicion es el dato del campo por el cual quieres hacer el borrado
     */
    public static void borrarDatos(String concampos,String textoCondicion){
    
        if (con == false) {
            try {

                PreparedStatement pst = ConexionBD.conn.prepareStatement("delete from "
                        + CTRLBorrarDatos.tablas());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");

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
                JOptionPane.showMessageDialog(null, "Fila eliminada correctamente.");
                
            } catch (SQLException ex) {
                System.out.println("Error al buscar datos. " + ex);
            }
        }
    }

}
