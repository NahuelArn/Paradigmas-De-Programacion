/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public abstract class Estacion {
    private String nombre;
    private double latitud;
    private double longitud;
    
    private double matriz[][];
    private int nAnhosIzq;
    private int nAnhosDer;
    
    private void inicializarMatriz(){
        for(int i = 0; i < this.nAnhosDer; i++){
            for(int j = 0; j < 12; j++){
                this.matriz[j][i] = 999;
            }
        }
    }
    public Estacion(String nombre, double latitud, double longitud, int nAnhosIzq, int nAnhosDer) {
        int resta;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        resta = nAnhosDer - nAnhosIzq;
        this.matriz = new double[12][resta+1];
        this.nAnhosIzq = nAnhosIzq;
        this.nAnhosDer = nAnhosDer;
        inicializarMatriz();
    }
    public void registrarTemperatura(double temp, int mes, int anho){
        int anhoPasado = anho - this.nAnhosIzq;
        if((mes >= 1) && (mes < 13) && (anho >= this.nAnhosIzq)&&(anho <= this.nAnhosDer)){
            this.matriz[mes-1][anhoPasado] = temp;
        }
    }
    public double retornarTemperaturaDeXfecha(int mes, int anho){
        int anhoPasado = anho - this.nAnhosIzq;
        if((mes >= 1) && (mes < 13) && (anho >= this.nAnhosIzq)&&(anho <= this.nAnhosDer)){
            return this.matriz[mes-1][anhoPasado];  //sino se registro una temperatura devuelve 999, caso contrario devuelve la temperatura
        }
        System.out.println("Fuera de rango");
        return -1;  //sino se registro una temperatura devuelve 999, caso contrario devuelve la temperatura
//        {if(this.matriz[mes-1][anhoPasado] != 999){
//            return this.matriz[mes-1][anhoPasado]
//        }else}
            
    } 
    public String fechaMaxTemperatura(){
        double tempMax = -999;
        String s = " ";
        int mesMax = 0; int anhoMax = 0;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < this.nAnhosDer; j++){
                if(this.matriz[i][j] != 999){
                    if(this.matriz[i][j] > tempMax){
                        tempMax = this.matriz[i][j];
                        mesMax = i;
                        anhoMax = j;
                    }
                }                 
            }
        }
        return "Fecha max Temperatura, mes: "+ mesMax+" anhoMax: "+anhoMax;
    }

    public int getnAnhosIzq() {
        return nAnhosIzq;
    }

    public int getnAnhosDer() {
        return nAnhosDer;
    } 
    public abstract String scrapear();
//    public abstract String screapear();
    @Override
    public String toString() {
        return "Estacion: "  + nombre + " latitud: " + latitud + " longitud: " + longitud + this.scrapear();
    }
    
}
