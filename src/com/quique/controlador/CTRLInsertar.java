/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;

import com.quique.modelo.CNXInsertar;
import com.quique.vista.VISTAInsertar;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quique
 */
public class CTRLInsertar {

    private static ResultSet r;

    public static ResultSet resul() {
        return CNXInsertar.constructorInsertar();
    }

    private static JTable tab;

    public static JTable datos() {
        return tab = VISTAInsertar.datos;
    }

    private static JComboBox<String> tablas;

    public static JComboBox tablas() {
        return tablas = VISTAInsertar.tablas;
    }

    public static DefaultTableModel recargar() {
        return CNXInsertar.recargar();
    }
    
    public static DefaultTableModel añadir(){
        return CNXInsertar.añadir();
    }
}
