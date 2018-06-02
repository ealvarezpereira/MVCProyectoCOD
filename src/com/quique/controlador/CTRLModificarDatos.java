/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;

import com.quique.modelo.CNXModificarDatos;
import com.quique.vista.VISTAModificarDatos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CTRLModificarDatos {

    /**
     * Llama al metodo del modelo
     * @return nombre de tablas
     */
    public static ArrayList<String> constructorModificarDatos() {
        ArrayList<String> tablas = new ArrayList<String>();
        return tablas = CNXModificarDatos.constructorModificarDatos();
    }
    
    /**
     * Recibe la tabla seleccionada
     * @return nombre de la tabla
     */
    public static String tablas() {
        String tablas;
        return tablas = String.valueOf(VISTAModificarDatos.tablas.getSelectedItem());
    }
        
    /**
     * Llama al metodo recargar del modelo
     * @return modelo de tabla
     */
    public static DefaultTableModel botonRecargar(){
        DefaultTableModel modelo = new DefaultTableModel();
        return modelo = CNXModificarDatos.botonRecargar();
        }    
        
    /**
     * Llama al metodo condicion
     * @return array de campos
     */
    public static ArrayList<String> botonCondicion() {
        ArrayList<String> concampos = new ArrayList<String>();
        return concampos = CNXModificarDatos.botonCondicion();
    }
        
    /**
     * Llama al metodo condicion
     * @param adatos Array de datos
     * @param concampos Condicion de modificar
     * @param textoCondicion Condicion por la cual modificas
     */
    public static void botonModificar(ArrayList<String>adatos,String concampos, String textoCondicion){
        
        CNXModificarDatos.botonModificar(adatos, concampos, textoCondicion);
        }
}
