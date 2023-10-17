/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Fecha {
    private String ciudad;
    private int dia;
    private int numFechaSiguiente; //se me hace q accede a esa pos del vector con esto y (de cierta forma tengo q pisar este fecha con la nueva(simular))
    
//getters and setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getNumFechaSiguiente() {
        return numFechaSiguiente;
    }

    public void setNumFechaSiguiente(int numFechaSiguiente) {
        this.numFechaSiguiente = numFechaSiguiente;
    }
    
    
}
