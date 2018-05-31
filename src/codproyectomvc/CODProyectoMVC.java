/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codproyectomvc;

import com.quique.modelo.ConexionBD;
import com.quique.vista.Menu;

/**
 *
 * @author quique
 */
public class CODProyectoMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConexionBD.conexionABD();
        Menu men = new Menu();
        men.setVisible(true);
    }

}
