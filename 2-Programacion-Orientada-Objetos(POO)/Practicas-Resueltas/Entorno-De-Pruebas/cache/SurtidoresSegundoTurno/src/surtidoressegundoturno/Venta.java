/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package surtidoressegundoturno;

/**
 *
 * @author nahuelArn
 */
public class Venta {
    private String dni;
    private double cantM3Cargados;
    private double montoAbonado;
    private String medioDePago;

    public Venta(String dni, double cantM3Cargados, double montoAbonado, String medioDePago) {
        this.dni = dni;
        this.cantM3Cargados = cantM3Cargados;
        this.montoAbonado = montoAbonado;
        this.medioDePago = medioDePago;
    }

    public double getMontoAbonado() {
        return this.montoAbonado;
    }

    @Override
    public String toString() {
        return "Venta{" + "dni=" + dni + ", cantM3Cargados=" + cantM3Cargados + ", montoAbonado=" + montoAbonado + ", medioDePago=" + medioDePago + '}';
    }
    
    
}
