/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class SubsidioDeBien extends Subsidio{
    private Bien vectorBienes[];
    
    private int dimL;
    private int dimF;
    public SubsidioDeBien(String nombre, String nombreDelPlanDeTrabajo, String fechaDeSolicitud, int dimF) {
        super(nombre, nombreDelPlanDeTrabajo, fechaDeSolicitud);
        this.vectorBienes = new Bien[dimF]; //como llevo una dimL y se va a cargar de manera secuancial no necesito inicializar el vector en null
        this.dimL = 0;
        this.dimF = dimF;
    }
    public void agregarSubsidio(Bien bien){
        if(this.dimL < this.dimF){
            this.vectorBienes[this.dimL] = bien;
            this.dimL++;
        }else{
            System.out.println("No se pudo agragar el bien al vector");
        }
    }
    @Override
    public double devolverMontoTotal(){
        double total = 0;
        for(int i = 0; i < this.dimL;i++){
            total += this.vectorBienes[i].getCantidad()* this.vectorBienes[i].getCostoPorUnidad();
        }
        return total;
    }
//    @Override
//    public String toString() {
//        return super.toString() +" SubsidioDeEstadia"+ " montoTotal: "+ this.devolverMontoTotal()+ " es otorgable: "+ this.esOtorgable();
//    }
}
