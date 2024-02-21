package otraVez;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Vehiculo {
    private String patente;
    private double cantHoarsEstacionado;
    private String marca;
    private String modelo;

    public Vehiculo(String patente, double cantHoarsEstacionado, String marca, String modelo) {
        this.patente = patente;
        this.cantHoarsEstacionado = cantHoarsEstacionado;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", cantHoarsEstacionado=" + cantHoarsEstacionado + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    
    
}
