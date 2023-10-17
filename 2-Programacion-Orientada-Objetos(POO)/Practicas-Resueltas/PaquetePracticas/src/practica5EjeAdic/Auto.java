/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Auto {
    private String nombreDuenho;
    private int patente;
    
    //constructor
    public Auto(String nombreDuenho, int patente) {
        this.nombreDuenho = nombreDuenho;
        this.patente = patente;
    }
    
    //setters and getters

    public String getNombreDuenho() {
        return nombreDuenho;
    }

    public void setNombreDuenho(String nombreDuenho) {
        this.nombreDuenho = nombreDuenho;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }
    
   @Override
    public String toString(){
        return "nombre del duenho: "+ nombreDuenho+ "patente: "+ patente;
    }
}   
