/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;

import com.quique.modelo.CNXBorrarDatos;
import com.quique.vista.VISTABorrarDatos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CTRLBorrarDatos {

    public static ArrayList<String> constructor() {
        ArrayList<String> tbs = new ArrayList<String>();
        return tbs = CNXBorrarDatos.constructorDeBorrarDatos();
    }

    public static DefaultTableModel botRecargar() {
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo = CNXBorrarDatos.botonRecargarDeBorrarDatos();
    }

    public static String tablas() {
        String tablas;
        return tablas = String.valueOf(VISTABorrarDatos.tablas.getSelectedItem());
    }

    public static ArrayList<String> condicion() {

        ArrayList<String> con = new ArrayList<String>();
        return con = CNXBorrarDatos.botonCondicionDeBorrarDatos();
    }

    public static void borrar(String concampos, String textoCondicion) {
        CNXBorrarDatos.borrarDatos(concampos, textoCondicion);
    }
}
