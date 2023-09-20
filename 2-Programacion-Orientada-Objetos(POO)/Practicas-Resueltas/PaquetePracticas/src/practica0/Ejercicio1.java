/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica0;

/**
 *
 * @author nahuelarn
 *
 * Realizar un programa que lea 2 números enteros desde teclado e informe en
 * pantalla cuál de los dos números es el mayor. Si son iguales debe informar en
 * pantalla lo siguiente: “Los números leídos son iguales”.
 *
 */
import PaqueteLectura.Lector;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        System.out.println("Ingrese el primer numero: ");
        int num1 = Lector.leerInt();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = Lector.leerInt();
        
        if (num1 == num2) {
            System.out.println("Los números son iguales");
        } else if (num1 > num2) {
            System.out.println("El num1 es más grande que el num2");
        } else {
            System.out.println("El num2 es más grande que el num1");
        }
    }
}

/*
public class Ejercicio1 {

    public static void main(String[] args) {
        System.out.println("Ingrese el primer numero: ");
        int num1 = Lector.leerInt();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = Lector.leerInt();
        if (num1 == num2) {
            System.out.println("Los numeros son iguales");
        } else {
            if (num1 > num2) {
                System.out.println("El num1 es mas grande q el num2 ");
            } else {
                System.out.println("El num2 es mas grande q el num1");
            }
        }

    }
}
*/