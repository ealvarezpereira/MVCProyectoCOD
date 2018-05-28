/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author quique
 */
public class ConexionBD {

    public static Connection conn;

    //Metodo para la conexion directa a la base de datos
    public static Connection conexionABD() {
        try {
            String url = "jdbc:sqlite:" + "/home/quique/Documentos/BasesDatos/base.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println("Error de conexion " + ex);
        }

        return conn;
    }
}
