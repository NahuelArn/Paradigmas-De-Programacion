/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 */

/*
1-  Analice  el  programa  Ej01Tabla2.java,  que  carga  un  vector  que  representa  la 
tabla del 2. Luego escriba las instrucciones necesarias para:  - generar  enteros  aleatorios  hasta  obtener  el  número  11.  Para  cada  número 
muestre el resultado de multiplicarlo por 2 (accediendo al vector).

 */
//import PaqueteLectura.GeneradorAleatorio; no anda
import java.util.Random;

public class ejercicio1 {

    public static void main(String[] args) {
        int dimF = 11;
        int[] tabla2 = new int[dimF];
        int i;
        for (i = 0; i < dimF; i++) {    //del 0 al 10
            tabla2[i] = 2 * i;
            System.out.println("2 x " + i + " = " + tabla2[i]);
        }
        
        System.out.println(""); System.out.println("Empieza el ejercicio "); System.out.println("");
        Random random = new Random();
        int[] tabla3 = new int[dimF];
        int numeroRandom = random.nextInt(12); //genera un random de 0 a 11
        while (numeroRandom != 11) {
            tabla3[numeroRandom] = 2 * numeroRandom;
            System.out.println("2 x " + numeroRandom + " = " + tabla3[numeroRandom]);
            numeroRandom = random.nextInt(12);
        }
    }
}
