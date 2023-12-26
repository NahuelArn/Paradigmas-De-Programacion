/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Main {
    public static void main(String[] args) {
        Padre padre = new Padre(3,2);
        padre.agregar("Pepe1");
        padre.agregar("Pepe2");
        padre.agregar("Pepe3");
        padre.agregar("Pepe4");
        padre.agregar("Pepe5");
        padre.agregar("Pepe6");
        padre.agregar("Pepe7");
        System.out.println(padre.mostrar());
    }
}
