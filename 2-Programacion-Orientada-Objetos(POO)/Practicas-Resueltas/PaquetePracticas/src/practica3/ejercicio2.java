/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author nahuelarn
 */
public class ejercicio2 {
    public static void main(String[] args) {
        Libro prueba = new Libro("pepe","bibliografico","originario");
        
        System.out.println("prueba.autor.getBibliografia();");
        System.out.println("b"+ prueba.getAutor().getBibliografia());
        System.out.println("b"+ prueba.getAutor().getOrigen());

    }
}
