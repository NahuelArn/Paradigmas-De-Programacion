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
    private double cantHorasEstacionado;
    private String marca;
    private String modelo;

    public Vehiculo(String patente, double cantHorasEstacionado, String marca, String modelo) {
        this.patente = patente;
        this.cantHorasEstacionado = cantHorasEstacionado;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }
    
    
    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", cantHorasEstacionado=" + cantHorasEstacionado + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    
            
}
