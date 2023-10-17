/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsidios;

/**
 *
 * @author nahuelarn
 */
public abstract class Subsidio {
    private String nombre;
    private String nombreDePlanDeTrabajo;
    private int fechaDeSolicitud;
    
    //constructor

    public Subsidio(String nombre, String nombreDePlanDeTrabajo, int fechaDeSolicitud) {
        this.nombre = nombre;
        this.nombreDePlanDeTrabajo = nombreDePlanDeTrabajo;
        this.fechaDeSolicitud = fechaDeSolicitud;
    }
    
    public abstract double montoTotalSubsidio();
    
    @Override
    public String toString(){
        return "nombre: "+ nombre + "nombreDePlanDeTrabajo: "+ nombreDePlanDeTrabajo + " fechaDeSolicitud: "+ fechaDeSolicitud+ this.montoTotalSubsidio();
    }
}
