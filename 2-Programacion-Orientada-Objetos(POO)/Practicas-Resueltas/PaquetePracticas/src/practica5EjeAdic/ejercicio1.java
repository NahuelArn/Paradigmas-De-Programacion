/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;


public class ejercicio1 {
    public static void main(String[] args) {
        System.out.println("Ingrese el nombre del proyecto ");
        //String nombre = Lector.leerString();
        String nombre = "Proyecto Nombre";
        System.out.println("Ingrese el codigo: ");
        //int codigo = Lector.leerInt();
        int codigo = 1;
        System.out.println("nombre completo del director ");
        //String nombreDirector = Lector.leerString();
        String nombreDirector = "fernando Alonzo";
        
        Proyecto proyecto = new Proyecto(nombre,codigo,nombreDirector);
        
        Investigador investigador;
        String especialidad;
        double montoPedido;
        int categoria;
        String motivo;
        Subsidio subsidio;
        for (int i = 0; i < 3; i++){
            System.out.println("Ingrese el nombre del investigador ");
            nombre = "NombreInvestigador"+i;
            System.out.println("categoria del investigador: ");
            categoria = 2;
            System.out.println("Especialidad ");
            especialidad = "Especial";
            investigador = new Investigador(nombre,categoria,especialidad);
            proyecto.setInvestigadores(investigador);
            //agregarSubsideos
            
            for (int j = 0; j < 2; j++){
                System.out.println("monto pedido ");
                montoPedido = 200;
                System.out.println("motivo: ");
                motivo = "sarasaasdasdasdasd ";
                subsidio = new Subsidio(montoPedido,motivo);
                investigador.setSubsidio(subsidio);
                
            }
            System.out.println(""); System.out.println("");
            System.out.println("total dinero otorgado: "+investigador.getDineroTotalOtorgado());  System.out.println("");  System.out.println("");
        }
        System.out.println("Otorgo el subsidio de un investigador(? "+ proyecto.otorgarTodos("NombreInvestigador1"));
        //imprimo all
        System.out.println("Data del proyecto: \n"+proyecto.toString());
    }
}
