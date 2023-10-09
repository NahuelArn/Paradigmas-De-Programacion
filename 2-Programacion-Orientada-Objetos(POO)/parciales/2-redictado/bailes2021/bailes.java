/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bailes;

/**
 *
 * @author nahuelarn
 */
import PaqueteLectura.GeneradorAleatorio;

public class BailesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        //intancio el Concurso
        System.out.println("Ingrese cuantas parejas van a participar como maximo ");
        int dimF = 5;
        Concurso concurso = new Concurso(dimF);
        
        
        //carga data de cada participante
        Pareja pareja;
        Pareja p2;
        
        //Participante
        Participante part1;
        Participante part2;
        
        for (int i = 0; i < 2; i++){
            //pareja1
        
            System.out.println("Ingrese el dni: ");
            int dni = 2244;
            System.out.println("Ingrese el nombre: ");
            String nombre = GeneradorAleatorio.generarString(5);
            System.out.println("Ingrese la edad: ");
            int edad = GeneradorAleatorio.generarInt(19)+1;
            
            part1 = new Participante(dni,nombre,edad);  //instancio
            
            //pareja2

            System.out.println("Ingrese el dni: ");
            dni = 2244;
            System.out.println("Ingrese el nombre: ");
            nombre = GeneradorAleatorio.generarString(5);
            System.out.println("Ingrese la edad: ");
            edad = GeneradorAleatorio.generarInt(19)+1;
            
            part2 = new Participante(dni,nombre,edad);  //instancio

            System.out.println("Ingrese el estilo de baile");
            String estiloBaile = GeneradorAleatorio.generarString(5);

            //pongo a la pareja en el concurso

            pareja = new Pareja(part1,part2,estiloBaile);

            concurso.agregarParejaAlConcurso(pareja);
        }
        Pareja ParejaAux = concurso.obtenerParejaConMasDifDeEdad();
        
        System.out.println(ParejaAux.mostrarNombre2Participante());
    }
    
}
