/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author nahuelarn
 */

//import PaqueLectura
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConcursoDeCanto concurso = new ConcursoDeCanto(3,5);
        
        Cancion cancion;
        cancion = new Cancion ("Perez"," sarasa", 2); //codigo despues ahcerlo con random
        
        
        for (int i = 0; i < 5; i++){
            cancion = new Cancion ("Perez"," sarasa", 2); //codigo despues ahcerlo con random
            concurso.agregarUnaNuevaCancionAlConcurso(cancion, 1); //agrega las 5 canciones en la primera columna
        }
        
        System.out.println("punto 4 COd Identificador ");
        int codLeido = 2;
        System.out.println("asdasd "+ concurso.conocerDelMain3erSubPunto(3));
        
        System.out.println("ultimo PUnto"+ concurso.ultimoPunto());
    }
    
    ///error por los temas de no considerar ciertas cosas q te dice q el enunciado q no considres.
}
