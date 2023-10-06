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
         // Instanciar un evento ocasional
        Ocasional eventoOcasional = new Ocasional ("Banda 1", 10, "A beneficio", "Contratante 1", 2);
        eventoOcasional.setListaTemasQvaAtocar("Tema 1");
        eventoOcasional.setListaTemasQvaAtocar("Tema 2");

        // Imprimir costo y llamar a actuar para evento ocasional
        System.out.println("Costo del evento ocasional: " + eventoOcasional.calcularCosto());
        eventoOcasional.getActuar();

        // Instanciar una gira

        Gira gira = new Gira("Gira Mundial", 3,"sarasa2",4);
        Fecha fecha1= new Fecha();
        gira.setAgregarFecha(fecha1);
        gira.setAgregarFecha(new Fecha());
        gira.setAgregarFecha(new Fecha());

        // Imprimir costo y llamar a actuar para la gira
        System.out.println("\nCosto de la gira: " + gira.calcularCosto());
        gira.getActuar();
    }
}
