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
public class ejercicio2 {
    public static void main(String[] args){
        System.out.println("Ingrese un numero ");
        int num = Lector.leerInt();
        if(num > -1){
            System.out.println("El valor absoluto es: "+num);
        } else {
            System.out.println("El valor absoulto es "+ num * -1);
        }
    }
}
