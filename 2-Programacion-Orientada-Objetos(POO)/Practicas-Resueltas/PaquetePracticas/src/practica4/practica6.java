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
        //int desdeAnho = Lector.leerInt();
        int desdeAnho = 200;
        System.out.println("Ingrese hasta que anho: ");
        //int hastaAnho = Lector.leerInt();
        int hastaAnho = 205;
        
        System.out.println("Ingrese el nombre de la estacion: ");
        //String nombre = Lector.leerString();   
        String nombre = "LaPlata";
        System.out.println("Ingrese la latitud: ");
        //double latitud = Lector.leerDouble();
        double latitud = 100;
        System.out.println("Ingrese la longitud: ");
        //double longitud = Lector.leerDouble();
        double longitud = 150;
        Anho estacionLaPlata = new Anho(desdeAnho,hastaAnho,nombre,latitud,longitud);
        
        estacionLaPlata.setTemperatura(205, 1, 100);
        estacionLaPlata.setTemperatura(205, 2, 50);
        estacionLaPlata.getTemperatura(205, 1);
        System.out.println(estacionLaPlata.toString());

       
//        estacionLaPlata.setTemperatura(203, 2, 100);
//        System.out.println(estacionLaPlata.toString());
        System.out.println("");
        System.out.println("EMPIZAN LOS MESES"); System.out.println("");
        
        
//       //-----------------------MESES-------------------------------------



        System.out.println("Ingrese desde anho: ");
        int anho = Lector.leerInt();
        System.out.println("Ingrese hasta que anho: ");
        int anho2 = Lector.leerInt();
        
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
