/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OtraVezOtraVez;

/**
 *
 * @author nahuelArn
 */
public class Auto {
    private String patente;
    private double cantHoras;
    private String marca;
    private String modelo;

    public Auto(String patente, double cantHoras, String marca, String modelo) {
        this.patente = patente;
        this.cantHoras = cantHoras;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Auto{" + "patente=" + patente + ", cantHoras=" + cantHoras + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
    
    
}
