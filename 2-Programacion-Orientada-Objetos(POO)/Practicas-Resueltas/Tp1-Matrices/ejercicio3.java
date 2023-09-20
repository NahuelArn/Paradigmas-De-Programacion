/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 *
 * 3- Escriba un programa que defina una matriz de enteros de tamaño 5x5.
 * Inicialice la matriz con números aleatorios entre 0 y 30. Luego realice las
 * siguientes operaciones: - Mostrar el contenido de la matriz en consola. -
 * Calcular e informar la suma de los elementos de la fila 1 - Generar un vector
 * de 5 posiciones donde cada posición j contiene la suma de los elementos de la
 * columna j de la matriz. Luego, imprima el vector. - Lea un valor entero e
 * indique si se encuentra o no en la matriz. En caso de encontrarse indique su
 * ubicación (fila y columna) en caso contrario imprima “No se encontró el
 * elemento”. NOTA: Dispone de un esqueleto para este programa en
 * Ej03Matrices.java
 */
import PaqueteLectura.GeneradorAleatorio;

public class ejercicio3 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        int dimF = 5;

        int[][] matriz = new int[dimF][dimF]; //bidimensional  // filas, columnas

        for (int i = 0; i < dimF; i++) {
            for (int j = 0; j < dimF; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(30);
            }
        }

        //imprimir
        for (int i = 0; i < dimF; i++) {
            System.out.println("");
            for (int j = 0; j < dimF; j++) {
                System.out.print("En la columna: " + i + " fila: " + j + " esta el valor: " + matriz[i][j] + "    I    ");

            }
        }
        //sumar Fila 1
        int suma = 0;

        for (int j = 0; j < dimF; j++) {
            System.out.println("");
            suma += matriz[0][j];
        }
        System.out.println("La suma de todas las fila 1 es: " + suma);

        //generar vector de 5 que cada posicion corresponde a la suma de toda la fila de esa columna
        //columna 1, todas las filas que corresponden a la columna 1
        int[] vectorColumnas = new int[5];
        for (int j = 0; j < dimF; j++) {
            for (int i = 0; i < dimF; i++) {
                vectorColumnas[j] += matriz[i][j];
                //vectorColumnas[j] = vectorColumnas[j] + matriz[i][j];
            }
        }
        //imprimir vector de suma de cada columna
        for (int i = 0; i < 5; i++) {
            System.out.println("En la pos: " + i + " esta la suma: " + vectorColumnas[i]);
        }

        //buscar un numero en una matriz
        //como no tiene orden 
        System.out.println("Ingrese el numero buscado: ");
        int numBuscado = PaqueteLectura.Lector.leerInt();
        boolean ok = false;
        int fila, columna;
        int i = 0;
        fila = -1;
        columna = -1;
        int j = 0;
        while ((i < dimF) && (ok != true)) {
            //i++;
            j = 0;
            while ((j < dimF) && (ok != true)) {
                // j++;
                if (matriz[i][j] == numBuscado) {
                    ok = true;
                    fila = i;
                    columna = j;
                }
                j++;
            }
            i++;
        }
        if (ok) {
            System.out.println("Se encontro el elemento en la fila: " + fila + " en la columna: " + columna);
        } else {
            System.out.println(" No se encontro el elemento");
        }
    }
}
