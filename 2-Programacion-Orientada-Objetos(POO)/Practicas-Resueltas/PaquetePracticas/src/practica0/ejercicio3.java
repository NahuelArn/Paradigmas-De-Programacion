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
public class ejercicio3 {
    public static void main(String[] args){
        System.out.println("Ingrese el primer numero ");
        int num1 = Lector.leerInt();
        System.out.println("Ingrese el segundo numero ");
        int num2 = Lector.leerInt();
        System.out.println("Ingrese el tercer numero ");
        int num3 = Lector.leerInt();
        System.out.println(num3 +" "+ num2 +" "+ num1);
    }
}
