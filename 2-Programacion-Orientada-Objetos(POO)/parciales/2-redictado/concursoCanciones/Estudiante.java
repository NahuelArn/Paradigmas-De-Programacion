/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author nahuelarn
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int dni;
    
    //constructor
    public Estudiante(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    } 
    
    ///setters and getters

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    }
    

    
    
}
