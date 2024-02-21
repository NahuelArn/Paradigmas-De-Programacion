/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otraVez;

/**
 *
 * @author nahuelArn
 * 
 */
import PaqueteLectura.GeneradorAleatorio;
public class main {
    //    public Estacionamiento(String direccion, double costoPorHora, int S, int V) { //sectores, vehiculos
    public static void main(String[] args) {
        Estacionamiento  estacionamiento = new Estacionamiento("160,44",100,3,4);
        
        //    public Vehiculo(String patente, double cantHoarsEstacionado, String marca, String modelo) {
        Vehiculo vehiculo = new Vehiculo("1dd1d",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("2222",5,"Vec","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("333",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        //------------------
        vehiculo = new Vehiculo("44444",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("555",5,"Vec","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("666",5,"Vec","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        //-----------------------
        vehiculo = new Vehiculo("77",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("88",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("99",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("99",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        
        vehiculo = new Vehiculo("99",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("99",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("99",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(vehiculo);
        System.out.println(estacionamiento.toString());
//        System.out.println(estacionamiento.sectorConMenosCantDeMarcaM("Peugeot"));
//        System.out.println(estacionamiento.listarSectorDeMarcaM("Peugeot", 0));
        
    }
}
