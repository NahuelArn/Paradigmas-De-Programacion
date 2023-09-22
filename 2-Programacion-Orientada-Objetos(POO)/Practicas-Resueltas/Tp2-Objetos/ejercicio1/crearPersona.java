
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nahuelArn
 */
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class crearPersona {

  public static void main(String[] args) {
    // TODO code application logic here
    personaMain primeraPersona = new personaMain();
    System.out.println("Ingrese el dni: ");
    int dni = Lector.leerInt();
    primeraPersona.setDni(dni);
    System.out.println("Ingrese la edad: ");
    int edad = Lector.leerInt();
    primeraPersona.setEdad(edad);
    System.out.println("Ingrese el nombre: ");
    String nombre = Lector.leerString();
    primeraPersona.setNombre(nombre);

    System.out.println("Dni : " + dni + " Edad: " + edad + " Nombre: " + nombre);

  }

}


