/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class SubsidioDeEstadia extends Subsidio{
    private String lugarDeDestino;
    private double costoPorPasajes;
    private  int cantDiasDeEstadia;
    private double montoDelHotelPorDia;

    public SubsidioDeEstadia(String lugarDeDestino, double costoPorPasajes, int cantDiasDeEstadia, double montoDelHotelPorDia, String nombre, String nombreDelPlanDeTrabajo, String fechaDeSolicitud) {
        super(nombre, nombreDelPlanDeTrabajo, fechaDeSolicitud);
        this.lugarDeDestino = lugarDeDestino;
        this.costoPorPasajes = costoPorPasajes;
        this.cantDiasDeEstadia = cantDiasDeEstadia;
        this.montoDelHotelPorDia = montoDelHotelPorDia;
    }
    @Override
    public double devolverMontoTotal(){
//        double total = 0;
          double total = this.costoPorPasajes + (this.cantDiasDeEstadia*this.montoDelHotelPorDia);
//          System.out.println("Costooooss"+ this.costoPorPasajes);
//        total = (this.costoPorPasajes + (this.cantDiasDeEstadia*this.montoDelHotelPorDia));
        return total;
    }
//    @Override
//    public  boolean esOtorgable(){
//        if(this.devolverMontoTotal() < 150000){
//            return true;
//        }else{
//            return false;
//        }
//    }

//    @Override
//    public String toString() {
//        return super.toString() +" SubsidioDeEstadia"+ " montoTotal: "+ this.devolverMontoTotal()+ " es otorgable: "+ this.esOtorgable();
//    }
    
}
