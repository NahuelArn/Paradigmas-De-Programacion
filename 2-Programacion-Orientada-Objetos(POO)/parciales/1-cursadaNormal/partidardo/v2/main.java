/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nahuelarancibia;

/**
 *
 * @author nahuelArn
 */
public class NahuelArancibia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Torneo torneo = new Torneo("ElMejorTorneo", 3,5);
        
        Goleador goleador1 = new Goleador("Fernando","Brazil",2);
        torneo.agregarGoleador(goleador1, 0);
        goleador1 = new Goleador("pEREZ","Argentina",3);
        torneo.agregarGoleador(goleador1, 0);
        goleador1 = new Goleador("Alonzo","Uruguay",1);
        torneo.agregarGoleador(goleador1, 0);
        goleador1 = new Goleador("Nose","Chile",7);
        torneo.agregarGoleador(goleador1, 0);
        //
        goleador1 = new Goleador("Nose","Chile",3);
        torneo.agregarGoleador(goleador1, 1);
        System.out.println(torneo.toString());
        Goleador goleador = torneo.jugadorMenosGolesEnFechaX(0);
        System.out.println("");
        System.out.println(goleador.getCantGolesEfectuadosEnEstaFecha());
                
    }
    
}
