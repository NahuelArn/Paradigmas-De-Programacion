/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Producto {
    private int cod;
    private String descripcion;
    private double precioUnitario;
    private int cantUnidades;

    public Producto(int cod, String descripcion, double precioUnitario, int cantUnidades) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantUnidades = cantUnidades;
    }

    public int getCantUnidades() {
        return cantUnidades;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        return "Codigo de producto" + cod + " descripcion: " + descripcion + "precio final de cada producto:"+this.cantUnidades * this.precioUnitario;
    }  
}
