/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class Bien {
    private String descripcion;
    private int cantidad;
    private double costoPorUnidad;

    public Bien(String descripcion, int cantidad, double costoPorUnidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoPorUnidad = costoPorUnidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoPorUnidad() {
        return costoPorUnidad;
    }
    
    
}
