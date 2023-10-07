/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;


/**
 *
 * @author nahuelArn
 */
import PaqueteLectura.Lector;
public class ejercicio4 {
    public static void main(String[] args) {
        //Director
        Director director = new Director(10,"nombre",23212,42);
        //Coros Super Clase
        Coros coros = new Coros("Coro nombre",director,4);
        
        //elegir tipo de coro
        CoroSemiCircular coroSemiCircular = new CoroSemiCircular(coros.getDimFcoro());
        
        //cargar informacion de un corista
        System.out.println("nombre: ");
        String nameCorista = Lector.leerString();
        System.out.println("dni: ");
        int dni = Lector.leerInt();
        System.out.println("Edad: ");
        int edad = Lector.leerInt();
        System.out.println("Tono fundamental: ");
        int nameTono = Lector.leerInt();
        
        Corista corista = new Corista(nameCorista,dni,edad,nameTono);
        
        //pongo el nuevo corista en Coros
        coroSemiCircular.agregarCorista(corista);
        coros.setTipoCoro(coroSemiCircular);
        System.out.println( coroSemiCircular.toString());
        
        
        //
        System.out.println(coros.toString());
//        coroSemiCircular.toString();
    }
}
