/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import com.quique.controlador.CTRLCrearTablas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author quique
 */
public class CNXCrearTablas {

    private static ArrayList<String> nombres = new ArrayList<String>();
    private static ArrayList<String> nprimary = new ArrayList<String>();
    private static boolean añadido = false;
    private static boolean seleccionado = false;
    private static int m = 0;
    private static String sqlcreate;


    public static void añadirCampo(){
    
         if (m == 0) {
            sqlcreate = "CREATE TABLE " + CTRLCrearTablas.retNomTabla() + "(";
            nombres.add(CTRLCrearTablas.retNomCampo());
        } else {
            for (int i = 0; i < nombres.size(); i++) {
                if (CTRLCrearTablas.retNomCampo().equals(nombres.get(i))) {
                    añadido = false;
                    CTRLCrearTablas.setNomcampo(JOptionPane.showInputDialog("Ese nombre está repetido.")) ;
                } else {
                    añadido = true;
                }
            }
        }

        if (añadido == true) {
            nombres.add(CTRLCrearTablas.retNomCampo());
        }

        String sentencia = "";
        sentencia = String.valueOf(CTRLCrearTablas.retTipo().getSelectedItem() + " ");

        if (CTRLCrearTablas.retNotnull().isSelected()) {
            sentencia = sentencia + CTRLCrearTablas.retNotnull().getText() + " ";
        }
        if (CTRLCrearTablas.retUnique().isSelected()) {
            sentencia = sentencia + CTRLCrearTablas.retUnique().getText() + " ";
        }
        if (CTRLCrearTablas.retPrmKey().isSelected()) {
            seleccionado = true;
            nprimary.add(CTRLCrearTablas.retNomCampo());
        }

        if (m == 0) {
            sqlcreate = sqlcreate + CTRLCrearTablas.retNomCampo() + " " + sentencia;
        } else {
            sqlcreate = sqlcreate + "," + CTRLCrearTablas.retNomCampo() + " " + sentencia;
        }

        m++;
        añadido = false;
        System.out.println(sqlcreate);
    }
    
    public static void btnAceptar(){
    
        if (seleccionado == true) {
            sqlcreate = sqlcreate + "," + CTRLCrearTablas.retPrmKey().getText() + "(";
            for (int i = 0; i < nprimary.size(); i++) {
                if (i == 0) {
                    sqlcreate = sqlcreate + nprimary.get(i);
                } else {
                    sqlcreate = sqlcreate + "," + nprimary.get(i);
                }
            }
            sqlcreate = sqlcreate + ")";
        }
        sqlcreate = sqlcreate + ");";

        try {
            PreparedStatement st = ConexionBD.conexionABD().prepareStatement(sqlcreate);

            if (st.execute() == false) {
                System.out.println("Finalizando... Cerrando el estado.");
                st.close();
            }
            
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }   
    }
}
