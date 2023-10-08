/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsidios;

/**
 *
 * @author nahuelarn
 */
public class Estadia extends Subsidio{
    private String lugarDeDestino;
    private double costoPasaje;
    private int cantidadDeDiasEstadia;
    private double montoTotalXdia;
    
    //consturcor
    public Estadia(String lugarDeDestino, double costoPasaje, int cantidadDeDiasEstadia, double montoTotalXdia, String nombre, String nombreDePlanDeTrabajo, int fechaDeSolicitud) {
        super(nombre, nombreDePlanDeTrabajo, fechaDeSolicitud);
        this.lugarDeDestino = lugarDeDestino;
        this.costoPasaje = costoPasaje;
        this.cantidadDeDiasEstadia = cantidadDeDiasEstadia;
        this.montoTotalXdia = montoTotalXdia;
    }
    
    //setts and getts
    @Override
    public double montoTotalSubsidio(){
        return costoPasaje * cantidadDeDiasEstadia * montoTotalXdia;
    }
    
    @Override
    public String toString(){
        String s = " ";
        return super.toString()+"lugarDeDestino: "+lugarDeDestino + "cantidadDeDiasEstadia: "+cantidadDeDiasEstadia;
    }
}
