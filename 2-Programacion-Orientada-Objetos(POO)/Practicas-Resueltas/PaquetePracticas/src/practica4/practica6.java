/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn\
 * 
 * 
 * 
 * 6- El Servicio Meteorológico Nacional necesita un sistema que permita registrar, para una
    determinada estación meteorológica, la temperatura promedio mensual de N años
    consecutivos a partir de un año A dado. Además, necesita dos versiones del sistema: una
    que permita reportar el promedio histórico por años y otra que permita reportar el
    promedio histórico por meses. Esto se detalla más adelante.
    De la estación, interesa conocer: nombre, y latitud y longitud donde se encuentra.
    Implemente las clases, constructores y métodos que considere necesarios para:
 */

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/*
Clases = Estacion (tempMensual[20], desdeAnho, dimFAnhos, nombre, latitud y longitud)
*/

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class practica6 {
    public static void main(String[] args) {
        
        //---------------ANHO---------------
        //Anho estacionLaPlata = new Anho(2000);
        System.out.println("Ingrese desde que anho: ");
        int anho = Lector.leerInt();
        System.out.println("Ingrese desde hasta que anho: ");
        int anho2 = Lector.leerInt();
        
        System.out.println("Ingrese el nombre de la estacion: ");
        String nombre = Lector.leerString();   
        System.out.println("Ingrese la latitud: ");
        double latitud = Lector.leerDouble();
        System.out.println("Ingrese la longitud: ");
        double longitud = Lector.leerDouble();
        
        Anho estacionLaPlata = new Anho(anho,anho2,nombre,latitud,longitud);
        
        System.out.println(estacionLaPlata.toString());
        //estacionLaPlata.toString();
       // estacionLaPlata.setDesdeANho(Lector.leerInt());
       
       
       //-----------------------MESS-------------------------------------
        System.out.println("Ingrese desde que anho: ");
        anho = Lector.leerInt();
        System.out.println("Ingrese desde hasta que anho: ");
        anho2 = Lector.leerInt();
        
        System.out.println("Ingrese el nombre de la estacion: ");
        nombre = Lector.leerString();   
        System.out.println("Ingrese la latitud: ");
        latitud = Lector.leerDouble();
        System.out.println("Ingrese la longitud: ");
        longitud = Lector.leerDouble();
        Mes LaPLata = new Mes(anho,anho2,nombre,latitud,longitud);
        
        System.out.println(LaPLata.toString());
        
        LaPLata.setTemperatura(203, 2, 100);
        System.out.println(LaPLata.toString());

    }
}
