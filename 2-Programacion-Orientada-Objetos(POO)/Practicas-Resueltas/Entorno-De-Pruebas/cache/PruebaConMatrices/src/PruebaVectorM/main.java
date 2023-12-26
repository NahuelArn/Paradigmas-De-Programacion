/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaVectorM;

/**
 *
 * @author nahuelArn
 */
public class main {

    public static void main(String[] args) {
        Padre padre = new Padre(4, 3);

        padre.agregarNombre("Pepe1");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe3");
        padre.agregarNombre("Pepe4");
        //
        padre.agregarNombre("Pepe4");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe3");
        padre.agregarNombre("Pepe4");
//        //
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe2");
        
        padre.agregarNombre("Pepe2");
        
        System.out.println(padre.toString());
    }
}
