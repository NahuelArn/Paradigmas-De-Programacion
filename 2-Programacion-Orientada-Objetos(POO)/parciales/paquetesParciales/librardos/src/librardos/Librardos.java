/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librardos;

/**
 *
 * @author nahuelarn
 */
public class Librardos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String tittle;
        double precioBase;
        String formato;
        double tamanho;
        
        //electronico
        System.out.println("Ingrese un titulo ");
        tittle = "titulo1 ";
        System.out.println("Ingrese el precio base del libro: ");
        precioBase = 200;
        System.out.println("Ingrese el formato ");
        formato = "pdf";
        System.out.println("Ingrese el tamanho en mb ");
        tamanho = 1000;
        LibroElectronico libroElectronico = new LibroElectronico(formato, tamanho,tittle,precioBase);
        
        libroElectronico.agregarUnAutor("pepe");
        libroElectronico.agregarUnAutor("pepe2");
        libroElectronico.agregarUnAutor("pepe3");
        
        System.out.println("Libro electronico: \n"+ libroElectronico.toString());
        
        
        System.out.println("");         System.out.println("");

        //impreso
        System.out.println("Ingrese un titulo ");
        tittle = "titulo1 ";
        System.out.println("Ingrese el precio base del libro: ");
        precioBase = 200;
        System.out.println("Ingrese el formato ");
        boolean tapaDura = true;
        
        LibroImpreso libroImpreso = new LibroImpreso(tapaDura,tittle,precioBase);
        libroImpreso.agregarUnAutor("pipo1");
        libroImpreso.agregarUnAutor("pipo2");
        libroImpreso.agregarUnAutor("pipo3");
        System.out.println("Libro impreso: \n"+ libroImpreso.toString());

    }
     
}
