/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author nahuelArn
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
        Estacionamiento estacionamiento = new Estacionamiento(nombre, direccionDelEstacionamiento);

        //
        int rn;
        String patente;
        Auto auto;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Ingrese nombre del duenho: ");
                nombre = "Pepe";
                System.out.println("Ingrese la patente ");
                patente = "22342";
                auto = new Auto(nombre, patente);
                estacionamiento.registrarAuto(auto,i, j);
            }
        }
        auto = new Auto(nombre, "3333");
        estacionamiento.registrarAuto(auto,9, 4);
        System.out.println(estacionamiento.toString()); //representacion de la matriz
        System.out.println("cant de autos ubicados en la plaza " + estacionamiento.cantAutosUbicadosEnPlaza(0));
        System.out.println("Ingrese una patente a buscar en la estructura");
        System.out.println(estacionamiento.buscarAuto("3333")); 
    }
    
}
