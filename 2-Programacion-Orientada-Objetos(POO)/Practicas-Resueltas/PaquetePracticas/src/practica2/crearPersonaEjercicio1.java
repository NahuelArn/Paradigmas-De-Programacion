/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

/**
 *
 * @author nahuelarn
 */
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class crearPersonaEjercicio1 {

    public static void main(String[] args) {
        // TODO code application logic here
        personaMain primeraPersona = new personaMain();
        System.out.println("Ingrese el dni: ");
        int dni = Lector.leerInt();
        primeraPersona.setDni(dni);
        System.out.println("Ingrese la edad: ");
        int edad = Lector.leerInt();
        primeraPersona.setEdad(edad);
        System.out.println("Ingrese el nombre: ");
        String nombre = Lector.leerString();
        primeraPersona.setNombre(nombre);

        System.out.println("Dni : " + dni + " Edad: " + edad + " Nombre: " + nombre);

    }

}
