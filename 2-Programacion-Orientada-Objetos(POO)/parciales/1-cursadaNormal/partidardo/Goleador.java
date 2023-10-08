/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.javaapplication6;

/**
 *
 * @author nahuelArn
 */
public class Goleador {
    private String nombre;
    private String nombreDeSuEquipo;
    private int cantGolesEnEsaFecha;
    
    //constructor
    public Goleador(String nombre, String nombreDeSuEquipo, int cantGolesEnEsaFecha) {
        this.nombre = nombre;
        this.nombreDeSuEquipo = nombreDeSuEquipo;
        this.cantGolesEnEsaFecha = cantGolesEnEsaFecha;
    }
    
    //setters and getters

    public String getNombre() {
        return nombre;
    }

    public String getNombreDeSuEquipo() {
        return nombreDeSuEquipo;
    }

    public int getCantGolesEnEsaFecha() {
        return cantGolesEnEsaFecha;
    }

    @Override 
    public String toString(){
        return " Nombre: "+ nombre+ " nombreDeSuEquipo: "+nombreDeSuEquipo+ " cantGolesEnEsaFecha: "+ cantGolesEnEsaFecha;
    }
}
