/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 */
package practica3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector; //scanner

public class ejercicio5 {
    public static void main(String[] args) {
        //cargo data local
        System.out.println("color relleno: ");
        String a = Lector.leerString();
        System.out.println("radio: ");
        double b = Lector.leerDouble();
        System.out.println("Color linea: ");
        String c = Lector.leerString();
        //mando la data local al constructor instanciando circulo
        Circulo circulo = new Circulo(b,a,c);
        
        //Los items q me pide
        System.out.println("Perimetro: "+circulo.getPerimetro());
        System.out.println("Area: "+circulo.getzArea());
    }
}
