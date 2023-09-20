/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author nahuelarn
 *
 *
 * 4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas
 * por piso (1..4). Realice un programa que permita informar la cantidad de
 * personas que concurrieron a cada oficina de cada piso. Para esto, simule la
 * llegada de personas al edificio de la siguiente manera: a cada persona se le
 * pide el nro. de piso y nro. de oficina a la cual quiere concurrir. La llegada
 * de personas finaliza al indicar un nro. de piso 9. Al finalizar la llegada de
 * personas, informe lo pedido.
 *
 */
import PaqueteLectura.GeneradorAleatorio;

public class ejercicio4 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int pisos = 9;
        int oficinas = 4;
        int[][] oficinasV = new int[pisos][oficinas]; //arrays contadores, por defento se inicializan en 0

        System.out.println("Ingrese el nro de piso: ");
        int nroPiso = GeneradorAleatorio.generarInt(pisos) + 1;
        System.out.println("Ingrese el nro de oficina: ");
        int nroOficina = GeneradorAleatorio.generarInt(oficinas) + 1;
        System.out.println("");

        while (nroPiso != 9) {
            oficinasV[nroPiso-1][nroOficina-1] += 1;
            System.out.println("Ingrese el nro de piso: ");
            nroPiso = GeneradorAleatorio.generarInt(pisos) + 1;
            System.out.println("Ingrese el nro de oficina: ");
            nroOficina = GeneradorAleatorio.generarInt(oficinas) + 1;
        }

        for (int i = 0; i <  8; i++) {
            System.out.println("En el piso " + (i+1));
            for (int j = 0; j < 4; j++) {
                System.out.print("En la Oficina: " + (j+1) + "  ");
                System.out.println("La cantidad de personal es: " + oficinasV[i][j]);
            }
        }

    }
}
