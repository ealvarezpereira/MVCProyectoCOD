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

        public static ArrayList<String> constructor() {
        ArrayList<String> tbs = new ArrayList<String>();
        return tbs = CNXInsertar.constructorDeInsertar();
    }

        public static String tablas() {
        String tablas;
        return tablas = String.valueOf(VISTAInsertar.tablas.getSelectedItem());
    }
        
        public static DefaultTableModel botonRecargarTrue(){
        DefaultTableModel modelo = CNXInsertar.botonRecargarDeInsertarBoolTrue();
            return modelo;
        }
        
        public static void botonRecargarFalse(String cadena){
            CNXInsertar.botonRecargarDeInsertarBoolFalse(cadena);
        }
        
        public static void cambiarBoolean(){
            VISTAInsertar.cargado = true;
        }
        
}
