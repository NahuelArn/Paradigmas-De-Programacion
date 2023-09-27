package practica3;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 */
import PaqueteLectura.Lector;
public class ejercicio1 {
    public static void main(String[] args) {
        Triangulo tr1 = new Triangulo(10,10,10,"rojo","rosa");
        
        //lado1
        System.out.println("Lado1: ");
        tr1.setLado1(Lector.leerDouble());
        
        System.out.println("tr "+ tr1.getLado1());
        
        //lado2
       // Triangulo tr2 = new Triangulo(10,10,10,"rojo","rosa");
        System.out.println("Lado2: ");
        tr1.setLado2(Lector.leerDouble());
        
        System.out.println("tr "+ tr1.getLado2());
        //lado3
                
       // Triangulo tr3 = new Triangulo(10,10,10,"rojo","rosa");
        System.out.println("Lado3: ");
        tr1.setLado3(Lector.leerDouble());
        
        System.out.println("tr "+ tr1.getLado3());
        
        //perimetro
        System.out.println("perimetro: "+ tr1.getPerimetro());
        //area
        System.out.println("Area: "+ tr1.getArea());
    }
}
