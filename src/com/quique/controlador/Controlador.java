/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.controlador;

import com.quique.modelo.ConexionBD;
import com.quique.vista.BorrarDatos;
import java.sql.*;
import javax.swing.JComboBox;

/**
 *
 * @author quique
 */
public class Controlador {
    
    
    private static Connection conexion;
    public static Connection conn(){
    
        conexion = ConexionBD.conexionABD();
        
        return conexion;
    }
    
    private static ResultSet r;
    public static ResultSet resul(){
        
        r = ConexionBD.borrarDatosConstructor();
        
        return r;
    }
    
    private static JComboBox tablas;
    public static JComboBox tablas(){
    
   
        tablas = BorrarDatos.tablas;
        return tablas;
    }
    
    private static ResultSet r2;
    public static ResultSet resul2(){
    
        r2 = ConexionBD.borrarDatosResultSet();
    return r2;
    }
    
}
