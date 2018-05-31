/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;

import com.quique.modelo.CNXTablas;
import com.quique.vista.VISTATablas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CTRLTablas {

    public static ArrayList<String> constructor() {
        ArrayList<String> tbs = new ArrayList<String>();
        return tbs = CNXTablas.constructorDeTablas();
    }

    public static DefaultTableModel botRecargar() {
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo = CNXTablas.botonRecargarDeTablas();
    }

    public static String tablas() {
        String tablas;
        return tablas = String.valueOf(VISTATablas.tablas.getSelectedItem());
    }

    public static void cambiarBoolean() {
        VISTATablas.con = true;
    }

    public static DefaultTableModel botonBuscarCondTrue(String elemento, String concampos, String textoCondicion) {
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo = CNXTablas.botonBuscarCondTrue(elemento, concampos, textoCondicion);
    }

    public static DefaultTableModel botonBuscarCondFalse(String elemento) {
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo = CNXTablas.botonBuscarCondFalse(elemento);
    }

    public static ArrayList<String> botonCondicionDeTablas() {
        ArrayList<String> campos = new ArrayList<String>();
        return campos = CNXTablas.botonCondicionDeTablas();
    }
}
