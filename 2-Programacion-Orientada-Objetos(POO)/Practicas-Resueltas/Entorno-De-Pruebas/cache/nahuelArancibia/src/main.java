/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //    public SubsidioDeEstadia(String lugarDeDestino, double costoPorPasajes, int cantDiasDeEstadia, double montoDelHotelPorDia, String nombre, String nombreDelPlanDeTrabajo, String fechaDeSolicitud) {
        //No tiene vector
        SubsidioDeEstadia subsidiodeestadia = new SubsidioDeEstadia("lugarDestino1",100,5,100,"nombre","TheLastDance","15/5");
        System.out.println(subsidiodeestadia.toString());
        
        
        subsidiodeestadia = new SubsidioDeEstadia("lugarDestino1",100000,1000,100,"nombre","PlanDeTrabajo","15/5");
        System.out.println("No otorgable"+subsidiodeestadia.toString());
        //
        //    public SubsidioDeBien(String nombre, String nombreDelPlanDeTrabajo, String fechaDeSolicitud, int dimF) {
        
        
        //tiene vector
        SubsidioDeBien subsidiodebien = new SubsidioDeBien("nombre","nombrePlanDeTrabajo","15/2",5);
        //    public Bien(String descripcion, int cantidad, double costoPorUnidad) {
        
        
        
        
        
        
        
        /////
        Bien bien = new Bien("descripcion",5,100);
        subsidiodebien.agregarSubsidio(bien);
        //
        bien = new Bien("descripcion",5,100);
        subsidiodebien.agregarSubsidio(bien);
        //
        bien = new Bien("descripcion",5,100);
        subsidiodebien.agregarSubsidio(bien);
        
        System.out.println(subsidiodebien.toString());
    }
    
}
