/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaconmatrices;

/**
 *
 * @author nahuelArn
 */
public class PruebaConMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Padre padre = new Padre(4,3);
        Hijo hijo = new Hijo();

        //  Primera Columna
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        //  Segunda
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        // TERCERA
        padre.agregarHijo(hijo);
        
        
        //
        System.out.println(padre.toString());
    }
    
}
