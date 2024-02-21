/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //    public Estacionamiento(String direccion, double costoPorHora, int dimFfilas, int dimFcolumnas) {

        Estacionamiento estacionamiento = new Estacionamiento("140/44",100,4,3);
        //    public Vehiculo(String patente, double cantHorasEstacionado, String marca, String modelo) {

        Vehiculo vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        //
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ra","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        //
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ra","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ra","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculo("4455",4,"ca","nose");
        estacionamiento.agregarVehiculo(vehiculo);
        
        System.out.println(estacionamiento.toString());
        System.out.println("e"+estacionamiento.puntoC("ra"));
    }
    
}
