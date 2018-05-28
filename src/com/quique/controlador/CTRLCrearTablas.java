/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;

import com.quique.modelo.CNXCrearTablas;
import com.quique.vista.VISTACrearTablas;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author quique
 */
public class CTRLCrearTablas {

    private static String nomtabla;

    public static String retNomTabla() {
        return nomtabla = VISTACrearTablas.nomtabla.getText();
    }

    private static String nomcampo;

    public static String retNomCampo() {
        return nomcampo = VISTACrearTablas.nomcampo.getText();
    }

    public static void setNomcampo(String nomcampo) {
        CTRLCrearTablas.nomcampo = nomcampo;
    }

    private static JComboBox<String> tipo;

    public static JComboBox retTipo() {
        return tipo = VISTACrearTablas.tipo;
    }

    private static JCheckBox unique;

    public static JCheckBox retUnique() {
        return unique = VISTACrearTablas.unique;
    }

    private static JCheckBox notnull;

    public static JCheckBox retNotnull() {
        return notnull = VISTACrearTablas.notnull;
    }

    private static JCheckBox primarykey;

    public static JCheckBox retPrmKey() {
        return primarykey = VISTACrearTablas.primarykey;
    }
    
    public static void añadirCampo(){
        CNXCrearTablas.añadirCampo();
    }
    
    public static void botAceptar(){
    
        CNXCrearTablas.btnAceptar();
    }
}
