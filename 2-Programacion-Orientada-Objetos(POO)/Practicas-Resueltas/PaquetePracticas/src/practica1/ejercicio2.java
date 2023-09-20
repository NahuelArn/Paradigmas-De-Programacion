/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author nahuelarn
 *
 * 2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo
 * de básquet y las almacene en un vector. Luego informe: - la altura promedio -
 * la cantidad de jugadores con altura por encima del promedio NOTA: Dispone de
 * un esqueleto para este programa en Ej02Jugadores.java
 */
import PaqueteLectura.Lector;

public class ejercicio2 {

    public static void main(String[] args) {
        int dimF = 4;
        int dimF15 = 3;
        double[] alturas = new double[dimF];

        for (int i = 1; i <= dimF15; i++) {
            System.out.println("Ingrese la altura del jugador: " + i);
            alturas[i] = Lector.leerDouble();
        }

        //recorrerVector
        int suma; double promedio;
        suma = 0;
        for (int i = 1; i <= dimF15; i++) {
            suma += alturas[i];
        }
        //iformar
        promedio = suma/dimF15;
        System.out.println("la altura promedio es: "+ promedio);
        //cant cumplen
        
        int cant;
        cant = 0;
        for (int i = 1; i <= dimF15; i++) {
            if(promedio > alturas[i]){
                cant += 1;
            }
        }
        System.out.println("la cant de jugadores con altura de encima del promedo es: "+cant);
    }
}
