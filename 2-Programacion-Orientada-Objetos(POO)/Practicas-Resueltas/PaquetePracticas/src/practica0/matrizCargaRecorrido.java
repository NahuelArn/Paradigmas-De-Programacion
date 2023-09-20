/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica0;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author nahuelarn
 */
public class matrizCargaRecorrido {
    public static void main(String[] args){
        int dimF = 5;
        
        int[][] matriz = new int[dimF][dimF]; //bidimensional  // fila, columna
        
        for (int i = 0; i < dimF; i++){
            for (int j = 0; j < dimF; j++ ) {
                matriz[i][j] = GeneradorAleatorio.generarInt(30);    
            }
        }
        
        //imprimir
        for (int i= 0; i < dimF; i++){
            System.out.println("");
            for (int j = 0; j < dimF; j++){
                System.out.print("En la columna: "+i+" fila: "+j+ " esta el valor: "+matriz[i][j]+ "    I    ");
                
            }
        }
    }
}
