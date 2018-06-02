/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;


import com.quique.modelo.CNXInsertar;
import com.quique.vista.VISTAInsertar;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author quique
 */
public class CTRLInsertar {

    /**
     * Llama al método del modelo y lo manda a la vista
     * @return tbs arraylist nombre de tablas
     */
    public static ArrayList<String> constructor() {
        ArrayList<String> tbs = new ArrayList<String>();
        return tbs = CNXInsertar.constructorDeInsertar();
    }

    /**
     * Recibe la tabla seleccionada de la vista
     * @return el nombre de la tabla
     */
    public static String tablas() {
        String tablas;
        return tablas = String.valueOf(VISTAInsertar.tablas.getSelectedItem());
    }
        
    /**
     * Llama al metodo del modelo y se lo pasa a la vista
     * @return modelo de tabla
     */
    public static DefaultTableModel botonRecargarTrue(){
        DefaultTableModel modelo = CNXInsertar.botonRecargarDeInsertarBoolTrue();
            return modelo;
        }
        
    /**
     * Llama al metodo del modelo y se lo pasa a la vista
     * @param cadena Datos introducidos
     */
    public static void botonRecargarFalse(String cadena){
            CNXInsertar.botonRecargarDeInsertarBoolFalse(cadena);
        }
        
    /**
     * Metodo que cambia el boolean de si está recargada la tabla o no.
     */
    public static void cambiarBoolean(){
            VISTAInsertar.cargado = true;
        }
        
}
