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

    /**
     * Recibe el arraylist de nombres y lo envia a la vista
     * @return tbs es el array de nombres
     */
    public static ArrayList<String> constructor() {
        ArrayList<String> tbs = new ArrayList<String>();
        return tbs = CNXBorrarDatos.constructorDeBorrarDatos();
    }
    
/**
 * Recibe el defaulttablemodel del modelo y lo envia a la vista
 * @return modelo es el DefaultTableModel
 */
    public static DefaultTableModel botRecargar() {
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo = CNXBorrarDatos.botonRecargarDeBorrarDatos();
    }

    /**
     * Tablas recibe la tabla seleccionada en la vista y se la envía al modelo
     * @return tablas Es la tabla seleccionada en el jcombobox
     */
    public static String tablas() {
        String tablas;
        return tablas = String.valueOf(VISTABorrarDatos.tablas.getSelectedItem());
    }

    /**
     * Recibe el array de campos del modelo y se lo envía a la vista
     * @return con Es el array de campos
     */
    public static ArrayList<String> condicion() {

        ArrayList<String> con = new ArrayList<String>();
        return con = CNXBorrarDatos.botonCondicionDeBorrarDatos();
    }

    /**
     * Recibe dos string y se los envía al controlador
     * @param concampos Campo por el cual quieres borrar un dato
     * @param textoCondicion Valor del campo por el cual quieres borrar un dato
     */
    public static void borrar(String concampos, String textoCondicion) {
        CNXBorrarDatos.borrarDatos(concampos, textoCondicion);
    }
}
