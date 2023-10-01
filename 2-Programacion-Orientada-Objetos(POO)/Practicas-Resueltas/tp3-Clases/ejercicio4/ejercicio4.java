/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 */

package practica3;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector; //scanner

public class ejercicio4 {
    public static void main(String[] args) {
        //instanciado Hotel
        
        Hotel nevada = new Hotel(5); //entra en el primer Constructor de habitacion
        
        
        //Lectura de datos
        System.out.println("Ingrese nombre ");
        String n = Lector.leerString();
        System.out.println("Ingrese el dni ");
        int d = Lector.leerInt();
        System.out.println("Ingrese la edad ");
        int e = Lector.leerInt();
        System.out.println("Ingrese la habitacion a asignar al cliente ");
        int num = Lector.leerInt();
        
        //Instancia de un cliente y carga de datos del cliente
        Cliente cliente = new Cliente(n,d,e);
        
        //seteando el cliente en una habitacion
        nevada.setHabitacion(num, cliente);
        
        //Aumentar el precio a todas las habitaciones
        nevada.setInflacion(800);
        
        //imprimir data del hotel
        System.out.println(nevada.toString());
    }
}
