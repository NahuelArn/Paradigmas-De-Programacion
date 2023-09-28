/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 */
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
public class ejercicio3 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();   //inicializa los aleatorios
        
        Estante estante = new Estante();
        System.out.println("sarasa " + estante.getCantLibros());
        System.out.println(estante.getLleno());
        //cargando data de libros
        
        Autor libro = new Autor();
        
        System.out.println("Ingrese el nombre del libro: ");
        libro.setNombre(GeneradorAleatorio.generarString(5));
 
        System.out.println("Ingrese el nombre del bibliografia: ");
        //String bibliografia = GeneradorAleatorio.generarString(5);
        libro.setBibliografia(GeneradorAleatorio.generarString(5));
        
        System.out.println("Ingrese el nombre del origen: ");
        //String origen = GeneradorAleatorio.generarString(5);
        libro.setNombre(GeneradorAleatorio.generarString(5));
        
        System.out.println("Ingrese el nombre del titulo: ");
        //libro.setTitulo(GeneradorAleatorio.generarString(5));
        libro.setTitulo(Lector.leerString());
        //String titulo = GeneradorAleatorio.generarString(5);
        
        estante.setLibro(libro);
        
        System.out.println("cant libros "+estante.getCantLibros());
        //System.out.println("libroN "+ estante.getvLibros()[0].getNombre());

        //Busqueda de un titulo en el vector de objetos y devuelve el objeto si matchea, int titulo, out objeto,null
        
        System.out.println("Ingrese el titulo del libro buscado ");//si encuentra devuelve todo el objeto, caso contrario null
        String buscado = Lector.leerString();
        
        Autor sarasa ;
        sarasa = estante.getLibro(buscado);
        if(sarasa != null){
            System.out.println("Se encontro el titulo buscado ");
        }
       // System.out.println("libroN "+ estante.vLibros[estante.cantLibros].getNombre());
    }
}
