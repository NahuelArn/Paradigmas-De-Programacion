/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class ejercicio3 {
    public static void main(String[] args) {
        
//         // Instanciar un evento ocasional (Andando (? )
//        Ocasional eventoOcasional = new Ocasional ("Banda 1", 10, "show de tv", "Contratante 1", 2);
//        eventoOcasional.setListaTemasQvaAtocar("Tema 1");
//        eventoOcasional.setListaTemasQvaAtocar("Tema 2");
//
//        // Imprimir costo y llamar a actuar para evento ocasional
//        System.out.println("Costo del evento ocasional: " + eventoOcasional.calcularCosto());
//        System.out.println(eventoOcasional.getActuar());
        

        // Instanciar una gira

        Gira gira = new Gira("Gira Mundial", 3,"sarasa2",4);
        Fecha fecha= new Fecha();
        System.out.println("Ingrese el la ciudad de la fecha");
//        String ciudadName = "La Plata";
        fecha.setCiudad("La Plata");
        System.out.println("Ingrese el dia de la fecha");
//        int diaName = 2;
        fecha.setDia(2);
        System.out.println("Ingrese el numero de la fecha siguiente");
//        int fechaSiguiente = 3;
        fecha.setNumFechaSiguiente(3); //la siguiente fecha se encuentra en la pos 2
        
        gira.setAgregarFecha(fecha);
        
        
        Fecha fecha2= new Fecha();
        System.out.println("Ingrese el numero de la fecha siguiente");
        fecha2.setNumFechaSiguiente(2);
        gira.setAgregarFecha(fecha2); //60k
       
        
        // Imprimir costo y llamar a actuar para la gira
        System.out.println("\nCosto de la gira: " + gira.calcularCosto());
        System.out.println(gira.getActuar());
    }
}
