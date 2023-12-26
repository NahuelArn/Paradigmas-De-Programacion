/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estacion estacion = new Estacion("160/44");
        //    public Surtidor(String combustibleQueDispensa, double precioXlitro, int dimF) {
        
        //
        Surtidor surtidor = new Surtidor("ggg",100,5);
        estacion.agregarSurtidor(surtidor);
        surtidor = new Surtidor("ggg",100,5);
        estacion.agregarSurtidor(surtidor);
        surtidor = new Surtidor("ggg",100,5);
        estacion.agregarSurtidor(surtidor);
        surtidor = new Surtidor("ggg",100,5);
        estacion.agregarSurtidor(surtidor);
        surtidor = new Surtidor("ggg",100,5);
        estacion.agregarSurtidor(surtidor);
        surtidor = new Surtidor("ggg",100,5);
        estacion.agregarSurtidor(surtidor);
        
        estacion.puntoB(0, "4540", 10, "Efectivo");
        estacion.puntoB(5, "4540", 10, "Efectivo");
        System.out.println(estacion.toString());
    }
    
}
