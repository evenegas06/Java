/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.Serializable;

/**
 *
 * @author Eduardo
 */
public class Persona implements Serializable{
    private String nombre,paterno, materno;
    private int edad;

    public Persona(String nombre, String paterno, String materno, int edad) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", edad=" + edad + '}';
    }
    
    
    
}
