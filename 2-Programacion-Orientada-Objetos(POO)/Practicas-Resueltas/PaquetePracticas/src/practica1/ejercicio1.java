package practica1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 */
import PaqueteLectura.GeneradorAleatorio;
public class ejercicio1 {
 public static void main(String[] args) {
        int dimF = 11;
        int[] tabla2 = new int[dimF];
        int i;
        for (i = 0; i < dimF; i++) {    //del 0 al 10
            tabla2[i] = 2 * i;
            System.out.println("2 x " + i + " = " + tabla2[i]);
        }
        
        System.out.println(""); System.out.println("Empieza el ejercicio "); System.out.println(" ");
        GeneradorAleatorio.iniciar();
        int[] tabla3 = new int[dimF];
        int numeroRandom = GeneradorAleatorio.generarInt(12); //genera un random de 0 a 11
        
        while (numeroRandom != 11) {
            tabla3[numeroRandom] = 2 * numeroRandom;
            System.out.println("2 x " + numeroRandom + " = " + tabla3[numeroRandom]);
            numeroRandom = GeneradorAleatorio.generarInt(12);
            
        }
    }
}
