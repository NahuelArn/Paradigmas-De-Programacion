/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
package practica4;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ejercicio2 {
    public static void main(String[] args) {
        System.out.println("nombre: ");
        String n = Lector.leerString();
        System.out.println("sueldo Basico: ");
        double s = Lector.leerDouble();
        System.out.println("Antiguedad: ");
        int a = Lector.leerInt();
        
        System.out.println("num partidos jugados: ");
        int np = Lector.leerInt();
        System.out.println("Goles anotados: ");
        int ga = Lector.leerInt();
        
        Jugador jugador = new Jugador(np,ga,n,s,a);
        
        
        System.out.println("to string: "+jugador.toString());
        // lo mismo para Entrenador
        
        System.out.println("nombre: ");
        n = Lector.leerString();
        System.out.println("sueldo Basico: ");
        s = Lector.leerDouble();
        System.out.println("Antiguedad: ");
        a = Lector.leerInt();
        
        System.out.println("cant campeonatos ganados ");
        int cantC = Lector.leerInt();
        
        
        Entrenador entrenador = new Entrenador(cantC,n,s,a);
        
        
        System.out.println("to string: "+entrenador.toString());
        
    }
}
