/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.javaapplication6;

/**
 *
 * @author nahuelArn
 */
public class Torneo {
    private String nombre;
    private Goleador matriz[][];
    private int vector[];
    
    private int cantFechas;
    private int cantGoleadoresXfecha;
    //constructor
    
    public Torneo(String nombre, int cantFechas, int cantGoleadoresXfecha) {
        this.nombre = nombre;
        
        this.cantFechas = cantFechas;
        this.cantGoleadoresXfecha = cantGoleadoresXfecha;
        matriz = new Goleador[cantGoleadoresXfecha][cantFechas];
        vector = new int[cantFechas];
    }
    //setters and geettrs
    public void agregarUnGoleador(Goleador goleador, int fechaX){
        //asumo en escenario ideal x lo q me dice el enunciado
        matriz[vector[fechaX]][fechaX] = goleador;
        if(vector[fechaX] < cantGoleadoresXfecha){
            vector[fechaX] += 1;
        } else {
            System.out.println("Te quedaste sin espacio a nivel de filas para agregar otro juador en X fecha");
        }
    }
    
    public Goleador obtenerGoleadorConMenosGoles(int fechaX){
        Goleador goleadorMenosGoles = null;
        int menosGoles = 999;
        for (int i = 0; i < vector[fechaX]; i++){
            if(matriz[i][fechaX].getCantGolesEnEsaFecha() < menosGoles){
                menosGoles = matriz[i][fechaX].getCantGolesEnEsaFecha();
                goleadorMenosGoles = matriz[i][fechaX];
            }
        }
        return goleadorMenosGoles;
    }
    
    public int obtenerLaCantidadDeGoleadoresRegistrados(){
        int totalGoleadoresRegistrados = 0;
        for (int i = 0; i < cantFechas; i++){
            totalGoleadoresRegistrados += vector[i];
        }
        return totalGoleadoresRegistrados;
    } 
    
    private String sacarData(int columna){
        String dataAux = " ";
        for (int j = 0; j < vector[columna]; j++){
            dataAux += matriz[j][columna].toString() +" \n";
        }
        return dataAux;
    }
    @Override
    public String toString(){
        String s = " ";
        for (int i = 0; i < cantFechas; i++ ){
            s += "Fecha: "+i+ " cantidad de goleadores de la fecha "+vector[i]+ " \n"+sacarData(i);         
        }
        return s; 
    }
    
}
