/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prgproyectobd;

/**
 *
 * @author quique
 */
public class Alumno {
    
    
    int numero;
    String nombre;
    String dni;

    public Alumno() {
    }

    public Alumno(int numero, String nombre, String dni) {
        this.numero = numero;
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Numero: " + numero + ", Nombre: " + nombre + ", DNI: " + dni;
    }
    
    
}
