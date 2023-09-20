/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author nahuelarn
 * 
 * 5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
* 
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class ejercicio5 {
    public static void main(String[] args){
        int puntaje = 3; int aspectos = 3; int clientes = 5;
        //int [][] calificacion = new int[aspectos][puntaje]; //para cada aspecto va tener su calificacion
        int [][] calificacion = new int[aspectos][clientes]; //para cada cliente vas a tener sus 3 calificaciones
        
//        for (int j = 0; j < 3; j++){    //estoy parado en las 3 calificaciones X cliente
//            for (int i = 0; i < 5; i++){    //estoy parado en los clientes
//                System.out.println("Ingrese la calificacion del aspecto "+j);
//            }
//        }
        for (int i= 0; i < 5; i++){
            System.out.println("");
            System.out.println("Cliente "+ (i+1)); 
            for (int j= 0; j< 3; j++){
                System.out.println("Ingrese la calificacion para el aspecto "+(j+1));
                System.out.println("del 1 al 10 ");
                calificacion[j][i] = Lector.leerInt();
            }
        }
        
      
        for (int i = 0; i < 3; i++){
            int suma = 0;
            for (int j = 0; j < 5; j++){
                suma += calificacion[i][j];
            }
            System.out.println("El promedio es: "+ suma/5);
        }
    }
}
