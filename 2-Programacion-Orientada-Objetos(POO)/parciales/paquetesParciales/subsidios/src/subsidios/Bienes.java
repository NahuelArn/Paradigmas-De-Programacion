/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsidios;

/**
 *
 * @author nahuelarn
 */
public class Bienes extends Subsidio{
    private Bien vector[];
    private int dimF;
    
    private int dimL = 0;
    //constructor

    public Bienes(int dimF, String nombre, String nombreDePlanDeTrabajo, int fechaDeSolicitud) {
        super(nombre, nombreDePlanDeTrabajo, fechaDeSolicitud);
        vector = new Bien[dimF];
        this.dimF = dimF;
    }
    
    public void agregarBien(Bien bien){
        if(dimL < dimF){
            vector[dimL] = bien;
            dimL++;
        }
    }
    
//    public double montoTotalSubsidioBienes(){
    @Override
    public double montoTotalSubsidio(){
        double total = 0;
        for (int i = 0; i < dimL; i++){
            total += vector[i].costoFinalBien();
        }
        return total;
    }
    
    @Override
    public String toString(){
        String s = " ";
        for (int i =0; i < dimL; i++){
            s += "Descripcion "+i+ ": "+vector[i].getDescripcion()+ "\n";
        }
        return super.toString() + s;
    }
}
