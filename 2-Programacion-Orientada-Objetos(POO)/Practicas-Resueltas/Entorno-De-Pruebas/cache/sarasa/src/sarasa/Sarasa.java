package sarasa;

import PaqueteLectura.Lector;

public class Sarasa {

    public static void main(String[] args) {
        int filas = 3, columnas = 3;
        int matriz[][] = new int[filas][columnas];
        int i = 0;
        int j = 0;

        System.out.println("Ingrese un numero");
        int numLeido = Lector.leerInt();

        while ((i < filas) && (numLeido != 0)) {
            j = 0;
            while ((j < columnas) && (numLeido != 0)) {
                System.out.println("Se guardo en la fila: " + i + " columna: " + j);
                matriz[i][j] = numLeido;
                System.out.println("Ingrese un numero");
                numLeido = Lector.leerInt();
                j++;
            }
            i++;
        }
        //Imprimir hasta donde fue cargado
        int p = 0;
        int pp = 0;
        while (p < filas) {
            pp = 0;
            while ((pp < columnas) && (matriz[p][pp] != 0)) {
                System.out.print("Valor contenido[" + matriz[p][pp]+"]"+ " | ");
                pp++;
            }
            System.out.println("");
            p++;
        }
    }
}

