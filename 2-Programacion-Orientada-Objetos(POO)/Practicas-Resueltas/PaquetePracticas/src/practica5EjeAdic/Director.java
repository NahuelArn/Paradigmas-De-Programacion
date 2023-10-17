/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Director extends Persona{
    private int antiguedad;
    
    //constructor
    public Director(int antiguedad,String nombre, int dni, int edad) {
        super(nombre, dni,edad);
        this.antiguedad = antiguedad;
    }
    //setters and getters

    public int getAntiguedad() {
        return antiguedad;
    }
    
    @Override
    public String toString(){
        return super.toString() + " antiguedad: "+ antiguedad;
    }
}
