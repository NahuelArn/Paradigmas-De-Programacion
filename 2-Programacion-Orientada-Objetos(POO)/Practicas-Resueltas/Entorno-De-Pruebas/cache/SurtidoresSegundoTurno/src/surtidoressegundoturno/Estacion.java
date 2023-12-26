/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package surtidoressegundoturno;

/**
 *
 * @author nahuelArn
 */
public class Estacion {
    private String direccion;
    private double precioM3;
    private Surtidor surtidores[];  //VECTOR DE 6 SURTIDORES
    private int maxVentasPorSurtidor[];
    private int [] cantM3PorSurtidor;
    private int dimLS;
    public Estacion(String direccion, double precioM3) {
        this.direccion = direccion;
        this.precioM3 = precioM3;
        this.surtidores = new Surtidor[6];  //Los vectores comienzan desde 0
        this.maxVentasPorSurtidor = new int[6]; //vector contador
        for (int i = 0; i < 6; i++){
            this.maxVentasPorSurtidor[i] = 0;
        }
        this.cantM3PorSurtidor = new int[6]; //vector contador
        for (int i = 0; i < 6; i++){
            this.cantM3PorSurtidor[i] = 0;
        }
        this.dimLS = 0;
    }
    public void agregarSurtidor(Surtidor surtidor){
        if(this.dimLS < 6){
            this.surtidores[dimLS] = surtidor;
            this.dimLS +=1;
        }else{
            System.out.println("Capacidad maxima de surtidores alcanzada");
        }
    }
    public void generarVenta(int numSurtidor,String dniCliente, double cantM3,String formaDePago){
        double montoAbonado;
        montoAbonado = this.precioM3 * cantM3;
        Venta unaVenta = new Venta(dniCliente,cantM3,montoAbonado,formaDePago);
        if(this.surtidores[numSurtidor].disponibilidad()){
            this.surtidores[numSurtidor].recibirVenta(unaVenta);
            this.cantM3PorSurtidor[numSurtidor] += cantM3;
            this.maxVentasPorSurtidor[numSurtidor] += 1;
        }else{
            System.out.println("Capacidad maxima de ventas alcanzadas \n todas las ventas van a revotar para el surtidor"
                    + ""+ numSurtidor);
        }       
    }
    public void bajoRendimiento(int m3PorDebajo){
        for (int i = 0; i< 6; i++){
            if(this.cantM3PorSurtidor[i] < m3PorDebajo){
                this.surtidores[i].setEstadoServicio(false);
            }
        }
    }
    public Venta ventaMayorMonto(){
        Venta venta = null;
        double max = -99;
        for (int i =0; i< this.dimLS; i++){
            venta = this.surtidores[i].sacarMaxVenta(max);
        }
        return venta;
    }
    
    private String sacarData(){
        String s = " ";
        for (int i= 0; i < 6; i++){
            s += "surtidor "+i+this.surtidores[i].toString() + "\n";
        }
        return s;
    }
    @Override
    public String toString() {
        return "Estacion{" + "direccion: " + direccion + ", precioM3: " + precioM3 + '}'+"\n"+ sacarData();
    }
    
    
}
