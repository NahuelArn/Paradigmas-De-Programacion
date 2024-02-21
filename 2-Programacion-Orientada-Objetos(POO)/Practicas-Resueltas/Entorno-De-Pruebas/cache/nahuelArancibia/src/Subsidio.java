/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public abstract class Subsidio {
    private String nombre;
    private String nombreDelPlanDeTrabajo;
    private String fechaDeSolicitud;

    public Subsidio(String nombre, String nombreDelPlanDeTrabajo, String fechaDeSolicitud) {
        this.nombre = nombre;
        this.nombreDelPlanDeTrabajo = nombreDelPlanDeTrabajo;
        this.fechaDeSolicitud = fechaDeSolicitud;
    }
    
    public abstract double devolverMontoTotal();
    
    public  boolean esOtorgable(){  //binding dinamico
        if(this.devolverMontoTotal() < 150000){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        String s = " ";
        s+= "Subsidio{" + "nombre=" + nombre + ", nombreDelPlanDeTrabajo=" + nombreDelPlanDeTrabajo + ", fechaDeSolicitud=" + fechaDeSolicitud + '}';
        s+= "Monto Total:  "+this.devolverMontoTotal() + " Es otorgable: "+ this.esOtorgable() + "\n";
        return s;
    }
    
    
}
