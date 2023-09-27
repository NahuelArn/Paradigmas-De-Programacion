/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author nahuelarn
 */
public class crearPersonaEjercicio2 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // TODO code application logic here
        int i = 0;
        System.out.println("Ingrese la edad: ");
        //int edad = Lector.leerInt();
        int edad = GeneradorAleatorio.generarInt(5);
        personaMain primeraPersona;
        personaMain[] vector = new personaMain[15];
        //inicializo en null
        for (int j = 1; j < 15; j++) {
            vector[i] = null;
        }

        while ((edad != 0) && (i < 15)) {
            primeraPersona = new personaMain();
            primeraPersona.setEdad(edad);
            // personaMain primeraPersona = new personaMain();
            System.out.println("Ingrese el dni: ");
            //int dni = Lector.leerInt();
            int dni = GeneradorAleatorio.generarInt(5);
            primeraPersona.setDni(dni);

            System.out.println("Ingrese el nombre: ");
            //String nombre = Lector.leerString();
            String nombre = GeneradorAleatorio.generarString(4);
            primeraPersona.setNombre(nombre);
            vector[i] = primeraPersona;
            i++;
            System.out.println("Ingrese la edad: ");
            //edad = Lector.leerInt();
            edad = GeneradorAleatorio.generarInt(5);
        }

        for (int k = 0; k < 15; k++) {  //comprueba que cada campo no este en null
            if (vector[k] != null) {
                System.out.println("esta ocupado el campo" + k);
            }
        }
    }
}
