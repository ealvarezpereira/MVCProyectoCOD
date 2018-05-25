/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codproyectomvc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author quique
 */
public class CODProyectoMVC {

    static Connection conn;
    static DatabaseMetaData meta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String url = "jdbc:sqlite:" + "/home/quique/Documentos/BasesDatos/base.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println("Error de conexion " + ex);
        }

        Menu men = new Menu();
        men.setVisible(true);
    }

}
