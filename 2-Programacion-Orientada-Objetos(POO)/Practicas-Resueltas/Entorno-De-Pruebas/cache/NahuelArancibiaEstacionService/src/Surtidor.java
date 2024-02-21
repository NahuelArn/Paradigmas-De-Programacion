/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Surtidor {
    private String combustibleQueDispensa;
    private double precioXlitro;
    private Venta vectorVentas[];
    
    private int dimF;
    private int dimL;
    public Surtidor(String combustibleQueDispensa, double precioXlitro, int dimF) {
        this.combustibleQueDispensa = combustibleQueDispensa;
        this.precioXlitro = precioXlitro;
        this.dimF = dimF;
        this.vectorVentas = new Venta[dimF];
        this.dimL = 0;
    }

    public double getPrecioXlitro() {
        return precioXlitro;
    }
    
    public void generarVenta(Venta venta){
        if(this.dimL < this.dimF){
            this.vectorVentas[this.dimL] = venta;
            this.dimL++;
        }else{
            System.out.println("No se pudo generar la venta");
        }      
    }
    public double montoSurtidor(){
        double montoTotalParcial = 0;
        for(int i = 1; i < this.dimL; i++){
            if(this.vectorVentas[i].getMedioDePagoUtilizado().equals("Efectivo")){
                montoTotalParcial += this.vectorVentas[i].getMontoAbonado();
            }
        }
        return montoTotalParcial;
    }
    private String scrapear(){
        String s = " ";
        for(int i = 0; i < this.dimL; i++){
            s+= this.vectorVentas[i].toString();
        }
        return s;
    }
    @Override
    public String toString() {
        return "Surtidor{" + "combustibleQueDispensa=" + combustibleQueDispensa + ", precioXlitro=" + precioXlitro + scrapear();
    }
    
}
