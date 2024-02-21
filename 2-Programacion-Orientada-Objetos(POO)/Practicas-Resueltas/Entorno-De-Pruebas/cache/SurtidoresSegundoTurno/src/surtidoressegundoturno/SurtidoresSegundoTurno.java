/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package surtidoressegundoturno;

/**
 *
 * @author nahuelArn
 */
public class SurtidoresSegundoTurno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Surtidor s;
        Estacion e;
        System.out.println("Ingrese la direccion: ");
        System.out.println("Ingrese el precio x m3");
        e = new Estacion("LaPlata",100);
        for (int i=0; i < 6; i++){
            System.out.println("Ingrese la capacidad de ventas de este surtidor"+i);
            s = new Surtidor(10); 
            e.agregarSurtidor(s);
        }
        for (int i = 0; i < 6; i++){
            System.out.println("Ingrese el numero de surtidor: ");
            System.out.println("Ingrese el dni del cliente");
            System.out.println("Ingrese la cant de m3");
            System.out.println("Ingrese la forma de pago");
            e.generarVenta(i, "4540", 5, "mercado pago");

        }
        e.generarVenta(1, "7777", 5, "mercado pago");
        System.out.println(e.toString());
        e.bajoRendimiento(6);
        System.out.println(e.toString());
        } 
        
    }
    
