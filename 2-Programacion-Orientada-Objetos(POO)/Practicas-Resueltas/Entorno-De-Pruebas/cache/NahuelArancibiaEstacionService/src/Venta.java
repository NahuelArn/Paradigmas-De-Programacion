/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Venta {
    private String dniCliente;
    private double cantLitrosCargados;
    private double montoAbonado;
    private String medioDePagoUtilizado;    //debito, credito, efectivo

    public Venta(String dniCliente, double cantLitrosCargados, double montoAbonado, String medioDePagoUtilizado) {
        this.dniCliente = dniCliente;
        this.cantLitrosCargados = cantLitrosCargados;
        this.montoAbonado = montoAbonado;
        this.medioDePagoUtilizado = medioDePagoUtilizado;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public String getMedioDePagoUtilizado() {
        return medioDePagoUtilizado;
    }

    @Override
    public String toString() {
        return "Venta{" + "dniCliente=" + dniCliente + ", cantLitrosCargados=" + cantLitrosCargados + ", montoAbonado=" + montoAbonado + ", medioDePagoUtilizado=" + medioDePagoUtilizado + '}';
    }
    
    
    
}
