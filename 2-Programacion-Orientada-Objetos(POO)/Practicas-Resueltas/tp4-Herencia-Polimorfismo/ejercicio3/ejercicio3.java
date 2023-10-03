/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelArn
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ejercicio3 {
    public static void main(String[] args) {
        System.out.println("Nombre: ");
        String n = GeneradorAleatorio.generarString(5);
        System.out.println("dni: ");
        int d = GeneradorAleatorio.generarInt(5);
        System.out.println("edad: ");
        int e = GeneradorAleatorio.generarInt(5);
        
        Persona persona = new Persona(n,d,e);
        
        System.out.println("to string: "+persona.toString());
        //
        
        System.out.println("Nombre: ");
        n = GeneradorAleatorio.generarString(5);
        System.out.println("dni: ");
        d = GeneradorAleatorio.generarInt(5);
        System.out.println("edad: ");
        e = GeneradorAleatorio.generarInt(5);
        
        System.out.println("tarea realizada: ");
        String t = GeneradorAleatorio.generarString(5);
        
        Trabajador trabajador = new Trabajador(n,d,e,t);
        
        System.out.println("to string: "+trabajador.toString());
    }
}
