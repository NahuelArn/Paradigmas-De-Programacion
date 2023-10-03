/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public abstract class Estacion {
    //    tipo[][] nombre = new tipo[tamaño1][tamaño2];
    private int desdeANho;
    private int dimFAnho;
//    private double temperaturas[][] = new double[12][dimFAnho]; //meses anhos
    private double temperaturas[][]; //meses anhos

    private String nombre;
    private double latidud;
    private double longitud;
    
    private double dataTemperaturas[][]; //estructura de datos para almacenar los promedios
    
    private void inicializarMatriz (){
        for (int i = 0; i< this.getDimFAnho(); i++){
            for (int j = 0; j < 12; j++){
                this.temperaturas[j][i] = 9999;
            }
        }
    }
    //constructor
    public Estacion(int dimFAnho){
        
        this.dimFAnho = dimFAnho;
        temperaturas = new double [12][this.getDimFAnho()];
        inicializarMatriz();
    }
    
    //gettrs and setts

    public int getDesdeANho() {
        return desdeANho;
    }

    public void setDesdeANho(int desdeANho) {
        this.desdeANho = desdeANho;
    }

    public int getDimFAnho() {
        return dimFAnho;
    }

    public void setDimFAnho(int dimFAnho) {
        this.dimFAnho = dimFAnho;
    }

    public double[][] getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(double[][] temperaturas) {
        this.temperaturas = temperaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatidud() {
        return latidud;
    }

    public void setLatidud(double latidud) {
        this.latidud = latidud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double[][] getDataTemperaturas() {
        return dataTemperaturas;
    }

    public void setDataTemperaturas(double[][] dataTemperaturas) {
        this.dataTemperaturas = dataTemperaturas;
    }
    
    
    
//    private double sumaMeses(){
//        double aux = 0;
//        this.dataTemperaturas = new double [1][12];  //cada columna es un mes y va tener su representacion total del promedio
//        for (int i =0; i < this.getDimFAnho(); i++){
//            for (int j = 0; j < 12; j++){
//                aux += this.temperaturas[i][j];
//            }
//            this.dataTemperaturas[1][] = 
//        }
//    }
//    public double promHistoricoXmeses(){
//        double suma = sumaMeses();
//    }
    //creo q 
    
    
    public abstract double promedio();
//    public abstract double promHistoricoXmeses();
//    
//    public abstract double promHistoricoXanhos();
    
}
