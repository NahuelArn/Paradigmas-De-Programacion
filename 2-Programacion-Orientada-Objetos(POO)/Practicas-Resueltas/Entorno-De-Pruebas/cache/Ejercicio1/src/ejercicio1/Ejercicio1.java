/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author nahuelArn
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Proyecto proyecto = new Proyecto("NombreProyector"," nombreDirector" ,1);
        Investigador invest1 = new Investigador("Fernadez",2,"Especialidad");
        Investigador invest2 = new Investigador("NombreInvestigador",3,"Especialidad");
        Investigador invest3 = new Investigador("NombreInvestigador",4,"Especialidad");
        Subsidio sub1 = new Subsidio(1000,"motivo");
        Subsidio sub2 = new Subsidio(1000,"motivo");
        invest1.agregarSubsidio(sub1);
        invest1.agregarSubsidio(sub2);
        proyecto.agregarInvestigador(invest1);
        proyecto.agregarInvestigador(invest2);
        proyecto.agregarInvestigador(invest3);
        proyecto.otorgarTodos("Fernadez");
        System.out.println(proyecto.toString());
    }
    
}
