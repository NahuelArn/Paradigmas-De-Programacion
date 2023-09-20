/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica0;

/**
 *
 * @author nahuelarn
 */
import PaqueteLectura.Lector;

public class sarasaPrueba {

    public static void main(String[] args) {
        int dimF15 = 4;
        double[] alturas = new double[dimF15];

        for (int i = 1; i <= 3; i++) {
            System.out.println("Ingrese la altura del jugador: " + i);
            alturas[i] = Lector.leerDouble();
        }

        //recorrerVector
        int suma;
        for (int i = 1; i <= 3; i++) {
            System.out.println("pos: " + i + " hay " + alturas[i]);
        }
    }
}
