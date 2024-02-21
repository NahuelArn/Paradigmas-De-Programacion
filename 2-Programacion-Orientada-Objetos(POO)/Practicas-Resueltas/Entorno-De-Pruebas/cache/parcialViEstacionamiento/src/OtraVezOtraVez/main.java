/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OtraVezOtraVez;

/**
 *
 * @author nahuelArn
 */
public class main {
    public static void main(String[] args) {
        Estacionamiento  estacionamiento = new Estacionamiento("160,44",100,3,4);
        
        //    public Auto(String patente, double cantHoarsEstacionado, String marca, String modelo) {
        Auto Auto = new Auto("1dd1d",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(Auto);
        
        Auto = new Auto("2222",5,"Vec","sarasa");
        estacionamiento.agregarVehiculo(Auto);
        
        Auto = new Auto("333",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(Auto);
        //------------------
        Auto = new Auto("44444",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(Auto);
        
        Auto = new Auto("44444",5,"Peugeot","sarasa");
        estacionamiento.agregarVehiculo(Auto);
        


        
    }
}
