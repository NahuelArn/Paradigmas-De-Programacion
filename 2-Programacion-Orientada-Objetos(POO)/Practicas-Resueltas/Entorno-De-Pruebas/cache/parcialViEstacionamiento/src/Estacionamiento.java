/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Estacionamiento {
    private String direccion;
    private double costoPorHora;
    private Vehiculo matriz[][];
    
    private int cantVehiculos;
    private int sectores;
    
    private int columnaActual;
    private int filaActual;
    public Estacionamiento(String direccion, double costoPorHora, int cantVehiculos, int sectores) {
        this.direccion = direccion;
        this.costoPorHora = costoPorHora;
        this.matriz = new Vehiculo[cantVehiculos][sectores];
        this.columnaActual = 0;
        this.filaActual= 0;
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        if(this.columnaActual < this.sectores){
            if(this.filaActual < this.cantVehiculos){
                this.matriz[this.filaActual][this.columnaActual] = vehiculo;
                this.filaActual++;
            }else{
                this.columnaActual++;
                this.filaActual = 0; // Reiniciar fila cuando se pasa a la siguiente columna

            }
        }else {
            System.out.println("Matriz llena");
        }
    }
    
}
