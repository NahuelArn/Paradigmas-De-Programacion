/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package version2concursocanciones;

/**
 *
 * @author nahuelarn
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Version2ConcursoCanciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Concurso concurso = new Concurso(3,5); //int cantCategorias, int cantMaxCancionesXcategoria) 
        Cancion cancion;
        
        for (int i = 0; i < 5; i++){  //implementar el aleatorio
            cancion = new Cancion("pedro","nose",2); //(String nombre, String compositorNombre, int numIdentificacion
            concurso.agregarUnaCancion(cancion, 0); //en la columna 0 se cargan las 5 canciones
        }
        
        //interpretarCancion
        String nombre;
        String apellido;
        int dni;
        int id;
        double puntaje;
        Estudiante estudiante;
        System.out.println("INgrese el identificador:");
        id = Lector.leerInt();
        while (id != 0){
            System.out.println("INgrese el nombre:");
            nombre = Lector.leerString();
            System.out.println("INgrese el apellido:");
            apellido = Lector.leerString();
            System.out.println("INgrese el dni :");
            dni = Lector.leerInt();
            System.out.println("INgrese el puntaje otorgado:");
            puntaje = Lector.leerDouble();
            System.out.println("INgrese el identificador:");
            id = Lector.leerInt();
            estudiante = new Estudiante(nombre,apellido,dni);
            concurso.interpretarCancion(id, estudiante, puntaje);
        }
        
        System.out.println("Ingrese un identificador de cancion ");
        int buscadoId = Lector.leerInt();
        Estudiante sarasaBuscado;
        sarasaBuscado = concurso.conocerEstudianteGanador(buscadoId);
        if(sarasaBuscado != null){
            sarasaBuscado.toString();
        }else{
            System.out.println("NADIE");
        }
        //conocerCancionTop
        String concateno = " ";
        for (int m = 0; m < 5; m++){
            if(concurso.conocerCancionTop(m) != null)
                concateno+= "Categoria "+ m+"  "+concurso.conocerCancionTop(m).toString() + "\n";
        }
        System.out.println(concateno);
    }
    
}
