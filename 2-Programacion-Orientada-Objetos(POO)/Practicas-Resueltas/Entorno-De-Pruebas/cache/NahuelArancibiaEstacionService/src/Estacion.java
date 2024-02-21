/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Estacion {
    private String direccion;
    private Surtidor vectorEstacion[];
    
    private int dimF;
    private int dimL;
    public Estacion(String direccion) {
        this.direccion = direccion;
        this.dimF = 6;
        this.vectorEstacion = new Surtidor[this.dimF];
        this.dimL = 0;
    }
    public void agregarSurtidor(Surtidor surtidor){
        if(this.dimL < this.dimF){
            this.vectorEstacion[this.dimL] = surtidor;
            this.dimL++;
        }else{
            System.out.println("No se pudo agregar el Surtidor");
        }
    }
    public void puntoB(int numSurtidor, String dni,double cantLitros,String formaDePago ){
        double montoAbonado = this.vectorEstacion[numSurtidor].getPrecioXlitro() * cantLitros;
        Venta venta = new Venta(dni,cantLitros,montoAbonado,formaDePago);
        this.vectorEstacion[numSurtidor].generarVenta(venta);
    }
    public int puntoC(){
        double montoActual;
        double montoMax = -999;
        int surtidorMax = -1;
        for(int i = 1; i < this.dimL; i++){
            montoActual= this.vectorEstacion[i].montoSurtidor();
            if(montoActual > montoMax){
                montoMax = montoActual;
                surtidorMax = i;
            }
        }
        return surtidorMax;
    }
    
    private String scrapear(){
        String s = " ";
        for(int i = 0; i < this.dimL; i++){
            s+= "Surtidor: "+ i + this.vectorEstacion[i].toString()+ " \n";
        }
        return s;
    }
    @Override
    public String toString() {
        String s = "Estacion De servicio, direccion: "+this.direccion+"cantidad de surtidores: "+this.dimL + "\n";
        s += scrapear();
        return s;
    }
    
}
