/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nahuelarancibia;

/**
 *
 * @author nahuelArn
 */
public class Torneo {
    private String nombreTorneo;
    private Goleador tabla[][];
    
    private int nFechas;
    private int mJugadores;
    
    private int cantidadGoleadores[]; // dimension Logica de la matriz
    
    private void inicializarVectorDimls(){
        for (int i =0 ; i < this.nFechas; i++){
            this.cantidadGoleadores[i] = 0;
        }
    }
    //contructor
    
    public Torneo(String nombreTorneo, int nFechas, int mJugadores) {
        this.nombreTorneo = nombreTorneo;
        this.nFechas = nFechas;
        this.mJugadores = mJugadores;
        this.tabla = new Goleador[mJugadores][nFechas];
        this.cantidadGoleadores = new int[nFechas];
        inicializarVectorDimls();
    }
    public void agregarGoleador(Goleador goleador, int fechaX){
        this.tabla[this.cantidadGoleadores[fechaX]][fechaX] = goleador; //escenario ideal no hago validaciones
        this.cantidadGoleadores[fechaX]++;
    }
    public Goleador jugadorMenosGolesEnFechaX(int fechaX){
        int min = 9999;
        Goleador goleador = null;
        for(int i = 0; i < this.cantidadGoleadores[fechaX]; i++){
            if(this.tabla[i][fechaX].getCantGolesEfectuadosEnEstaFecha() < min){
                min = this.tabla[i][fechaX].getCantGolesEfectuadosEnEstaFecha();
                goleador = this.tabla[i][fechaX];
            }
        }
        return goleador;
    }
    public int cantidadDeJugadoresRegistrados(){
        int suma = 0;
        for (int i = 0; i < this.nFechas; i++){
            suma += this.cantidadGoleadores[i];
        }
        return 0;
    }
    private String scrapearTorneo(String s){
        for(int i=0; i < this.nFechas; i++){
            for(int j = 0; j < this.cantidadGoleadores[i]; j++){
                s+= "\n"+"Fecha: "+i+" cantidad de goleadores: "+ this.cantidadGoleadores[i]+"\n "+ this.tabla[j][i].toString();
            }
        }
        return s;
    }
    @Override
    public String toString() {
        String s = " ";
        s = "Torneo 2022 "+ this.nombreTorneo;
        s+= scrapearTorneo(s);
        return s;
    }
    
}
