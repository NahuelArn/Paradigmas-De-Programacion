/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Corista extends Persona{
    private int tonoFundamental;
    
    //constructor
    public Corista(String nombre, int dni, int edad, int tonoFundamental) {
        super(nombre, dni, edad);
        this.tonoFundamental = tonoFundamental;
    }

    //setters and getters
    public int getTonoFundamental() {
        return tonoFundamental;
    }

    @Override
    public String toString(){
        return super.toString()+ " tono fundamental: "+tonoFundamental;
    }
}
