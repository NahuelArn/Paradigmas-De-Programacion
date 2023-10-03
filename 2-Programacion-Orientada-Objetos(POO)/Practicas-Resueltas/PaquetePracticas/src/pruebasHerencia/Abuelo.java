/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasHerencia;

/**
 *
 * @author nahuelarn
 */
public class Abuelo {
    String apellido;
    String nombre;
    int edad;
 
    
    //constructor 
    public Abuelo(String a, String b){
        this.apellido = a;
        this.nombre = b;
    }
    
    public Abuelo(int edad){
        this.edad = edad;
    }
    //getts and setts
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
