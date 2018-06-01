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

    /**
     * Recibe el nombre que le asignas a la tabla y se lo manda al modelo
     * @return nombtabla es el nombre de la tabla
     */
    public static String retNomTabla() {
        return nomtabla = VISTACrearTablas.nomtabla.getText();
    }

    private static String nomcampo;

    /**
     * Recibe el nombre que le asignas al campo y se lo manda al modelo
     * @return nomcampo Retorna el nombre del campo
     */
    public static String retNomCampo() {
        return nomcampo = VISTACrearTablas.nomcampo.getText();
    }

    /**
     *  Setter del parametro nomcampo
     * @param nomcampo Nombre del campo
     */
    public static void setNomcampo(String nomcampo) {
        CTRLCrearTablas.nomcampo = nomcampo;
    }

    private static JComboBox<String> tipo;

    /**
     * Recibe el tipo de campo que quieres que sea (integer o text)
     * @return tipo es el tipo de dato
     */
    public static JComboBox retTipo() {
        return tipo = VISTACrearTablas.tipo;
    }

    private static JCheckBox unique;

    /**
     * Recibe si el checkbox "unique" está seleccionado
     * @return unique checkbox unique
     */
    public static JCheckBox retUnique() {
        return unique = VISTACrearTablas.unique;
    }

    private static JCheckBox notnull;

    /**
     * Recibe si el checkbox "notnull" está seleccionado
     * @return notnull checkbox notnull
     */
    public static JCheckBox retNotnull() {
        return notnull = VISTACrearTablas.notnull;
    }

    private static JCheckBox primarykey;

    /**
     * Recibe si el checkbox "primarykey" está seleccionado
     * @return primarykey checkbox primarykey
     */
    public static JCheckBox retPrmKey() {
        return primarykey = VISTACrearTablas.primarykey;
    }
    
    /**
     * Llama a la clase de añadir campo.
     */
    public static void añadirCampo(){
        CNXCrearTablas.añadirCampo();
    }
    
    /**
     * Llama a la clase del boton aceptar.
     */
    public static void botAceptar(){
    
        CNXCrearTablas.btnAceptar();
    }
}
