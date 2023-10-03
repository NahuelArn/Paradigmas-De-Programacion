/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
package practica4;

public class Persona {
    private String nombre;
    private int dni;
    private int edad;
    
    //constructor
    public Persona(String nombre, int dni, int edad){
        this.setNombre(nombre);
        this.setDni(dni);
        this.setEdad(edad);
    }
    
    
    //gets and setts

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString(){
        return "Mi nombre es: "+ this.getNombre()+ " mi Dni es: "+ this.getDni()+ " y tengo: "+ this.getEdad()+ " anhos. ";
    }
}
