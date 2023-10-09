/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsidios;

/**
 *
 * @author nahuelarn
 */
public class Bien {
    private String descripcion;
    private int cantidad;
    private double costoXunidad;
    
    //constructor

    public Bien(String descripcion, int cantidad, double costoXunidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoXunidad = costoXunidad;
    }
    //sts and getts
    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoXunidad() {
        return costoXunidad;
    }
    
    public double costoFinalBien(){
        return cantidad * costoXunidad;
    }
    
}
