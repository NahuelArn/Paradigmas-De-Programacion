/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package src.javaapplication6;

/**
 *
 * @author nahuelArn
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Torneo torneo = new Torneo("Torneaso",12,24);
        
        Goleador goleador;
        goleador = new Goleador("Messi","meeesi",1212);
        torneo.agregarUnGoleador(goleador, 0);
        goleador = new Goleador("Messi","meeesi",1212);
        torneo.agregarUnGoleador(goleador, 0);
        System.out.println(torneo.toString());
    }
    
}
