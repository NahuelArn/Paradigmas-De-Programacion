/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bailes;

/**
 *
 * @author nahuelarn
 */
public class Participante {
    private int dni;
    private String nombre;
    private int edad;
    
    //constructor

    public Participante(int dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    //gets ands sets
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    
}
