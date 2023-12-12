/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nahuelarancibia;

/**
 *
 * @author nahuelArn
 */
public class Goleador {
    private String nombre;
    private String nombreEquipo;
    private int cantGolesEfectuadosEnEstaFecha;
    
    //constructor

    public Goleador(String nombre, String nombreEquipo, int cantGolesEfectuadosEnEstaFecha) {
        this.nombre = nombre;
        this.nombreEquipo = nombreEquipo;
        this.cantGolesEfectuadosEnEstaFecha = cantGolesEfectuadosEnEstaFecha;
    }

    public int getCantGolesEfectuadosEnEstaFecha() {
        return cantGolesEfectuadosEnEstaFecha;
    }

    @Override
    public String toString() {
        return "Goleador" + "nombre: " + nombre + ", nombreEquipo=" + nombreEquipo + ", cantGolesEfectuadosEnEstaFecha=" + cantGolesEfectuadosEnEstaFecha ;
    }
    
}
