/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author nahuelarn
 */
public class Habitacion {
    private double costoPorNoche;
    private boolean estado; //ocupada o desocupada
    private Cliente huesped;
    
    //constructor
    public Habitacion(){
        this.costoPorNoche = 0;
        this.estado = false;
        this.huesped = null;
    }
    
       public Habitacion(double precio){
        this.costoPorNoche = precio;
        this.estado = false;
        this.huesped = null;
    }
       
       public Habitacion(double precio, Cliente persona){
        this.costoPorNoche = precio;
        this.estado = true;
        this.huesped = persona;
    }   
    
    //getters and setters

    public double getCostoPorNoche() {
        return costoPorNoche;
    }

    public void setCostoPorNoche(double costoPorNoche) {
        this.costoPorNoche = costoPorNoche;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cliente getHuesped() {
        return huesped;
    }

    public void setHuesped(Cliente huesped) {
        this.huesped = huesped;
    }
    
}
