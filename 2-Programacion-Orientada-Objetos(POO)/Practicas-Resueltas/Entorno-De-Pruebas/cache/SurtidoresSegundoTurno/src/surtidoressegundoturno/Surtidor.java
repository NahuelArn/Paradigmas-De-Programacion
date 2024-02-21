/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package surtidoressegundoturno;

/**
 *
 * @author nahuelArn
 */
public class Surtidor {
    private boolean estadoServicio;
    private Venta ventas[];
    private int dimL;
    private int dimF;
    public Surtidor(int capacidadDeVentas) {
        this.estadoServicio = true;
        this.ventas = new Venta[capacidadDeVentas];
        this.dimL = 0;
        this.dimF = capacidadDeVentas;
    }
    
    public boolean disponibilidad(){
        return (dimL < dimF);
    }
    public void recibirVenta(Venta venta){
        ventas[dimL] = venta;
        dimL++;
    }
    public void setEstadoServicio(boolean estado){
        this.estadoServicio = estado;
    }
    public Venta sacarMaxVenta(double max){
        Venta venta = null;
        for (int i = 0; i< this.dimL; i++){
            if(this.ventas[i].getMontoAbonado() > max){
                venta = this.ventas[i];
                max= this.ventas[i].getMontoAbonado();
            }
        }
        return venta;
    }
    private String sacarData(){
        String s = " ";
        for (int i =0; i < this.dimL; i++){
            s += this.ventas[i].toString() + " \n";
        }
        return s;
    }
    @Override
    public String toString() {
        return " : esta en servicio "+estadoServicio+ "\n"+sacarData();
    }
    
}
