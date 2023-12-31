/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author nahuelarn
 */
public class Cliente {
    private String nombre;
    private int dni;
    private int edad;
    
    //constructor 
    public Cliente (){
        this.nombre = "";
        this.dni = 0;
        this.edad = 0;
    }
    
    public Cliente(String n, int d, int e){
        this.nombre = n;
        this.dni = d;
        this.edad = e;
    }
    //getters and setters
    
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
        return "nombre: "+this.nombre+" dni: "+this.dni + " edad: "+this.edad;
    }
}
