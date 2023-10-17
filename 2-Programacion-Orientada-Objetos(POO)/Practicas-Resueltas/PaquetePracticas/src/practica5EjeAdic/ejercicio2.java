/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ejercicio2 {

    public static void main(String[] args) {
        String nombre;
        String direccionDelEstacionamiento;
        double horaApertura;
        double horaCierre;
        int cantPisos;
        int cantPlazas;
        System.out.println("Ingrese el nombre del estacionamiento ");
        nombre = "Nombre estacionamiento";
        System.out.println("direccion del estacionamiento");
        direccionDelEstacionamiento = "42 y 32";
        System.out.println("hora de apertura ");
        horaApertura = 8;
        System.out.println("Hora de cierre: ");
        horaCierre = 18;
        System.out.println("cant Pisos");
        cantPisos = 3;
        System.out.println("cant Plazas ");
        cantPlazas = 3;
        //Instancio Estacionamiento
        Estacionamiento estacionamiento = new Estacionamiento(nombre, direccionDelEstacionamiento, horaApertura,
                horaCierre, cantPisos, cantPlazas);

        //
        int rn;
        int patente;
        Auto auto;
        GeneradorAleatorio.iniciar();
        for (int j = 1; j < 3; j++) {
            for (int i = 1; i < 4; i++) {
                System.out.println("Ingrese nombre del duenho: ");
                nombre = "Pepe";
                System.out.println("Ingrese la patente ");
                patente = 22342;
                auto = new Auto(nombre,patente);
                estacionamiento.setAuto(j, i, auto);              
            }
        }
        System.out.println( estacionamiento.toString()); //representacion de la matriz
        System.out.println("cant de autos ubicados en la plaza 1"+ estacionamiento.cantAutosEnPlaza(1) );
        System.out.println("Ingrese una patente a buscar en la estructura");
        int patenteBuscada = Lector.leerInt();
        System.out.println(estacionamiento.getDataAutoBuscado(patenteBuscada));
//        estacionamiento.getDataAutoBuscado(patenteBuscada);
    }
}
