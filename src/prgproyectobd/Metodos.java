/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prgproyectobd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author quique
 */
public class Metodos {

    public static void saveAlumno(Alumno alumno) {

        try {
            
            if (PRGProyectoBD.conn != null) {
                System.out.println("Funciona.");
                PreparedStatement st = PRGProyectoBD.conn.prepareStatement("insert into alumnos values (?,?,?)");
                st.setInt(1, alumno.getNumero());
                st.setString(2, alumno.getNombre());
                st.setString(3, alumno.getDni());

                if (st.execute() == false) {
                    System.out.println("Finalizando... Cerrando el estado.");
                    st.close();
                }

            }

        } catch (SQLException ex) {
            System.err.println("Error. " + ex.getMessage());
        }

    }

    public static void createTable() {
        
        try {
            
            if (PRGProyectoBD.conn != null) {
                System.out.println("Funciona.");
                PreparedStatement st = PRGProyectoBD.conn.prepareStatement(" CREATE TABLE `prueba` ("
                        + "`prueba1`	INTEGER NOT NULL,"
                        + "`prueba2`	TEXT,"
                        + "`prueba3`	TEXT UNIQUE,"
                        + "PRIMARY KEY(prueba1));");

                if (st.execute() == false) {
                    System.out.println("Finalizando... Cerrando el estado.");
                    st.close();
                }

            }

        } catch (SQLException ex) {
            System.err.println("Error. " + ex.getMessage());
        }
    }

}
