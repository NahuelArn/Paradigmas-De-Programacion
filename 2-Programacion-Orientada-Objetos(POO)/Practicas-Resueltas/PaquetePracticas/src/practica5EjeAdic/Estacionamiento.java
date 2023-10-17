/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private double horaApertura;
    private double horaCierre;
    
    private int piso;
    private int plaza;
    
    private Auto estacionamientos[][];
    //cosntructor
    public Estacionamiento(String nombre, String direccion) {    
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = 8.00;
        this.horaCierre = 21.00;
        this.piso = 5;
        this.plaza = 10;
        
        estacionamientos = new Auto[piso][plaza];
    }
    
    public Estacionamiento(String nombre, String direccion, double horaApertura, double horaCierre,int pisos, int plazas) {    
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.piso = pisos;
        this.plaza = plazas;
        
        estacionamientos = new Auto[this.piso][plazas];
    }
    
    //getters ands setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(double horaApertura) {
        this.horaApertura = horaApertura;
    }

    public double getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(double horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int getPiso() {
        return piso;
    }


    public int getPlaza() {
        return plaza;
    }
    
    
    public void setAuto(int x, int y, Auto auto){
        estacionamientos[x-1][y-1] = auto; //no hago ninguna validacion el enunciado me aclara q tengo un escenario ideal
    }
    
    public String getDataAutoBuscado(int patente){
        int i = 0; int j = 0; boolean sigo = true;
        while ((i < plaza) && (sigo)){
            while ((j < piso) && (sigo)){
                if(estacionamientos[j][i].getPatente() == patente ){
                    sigo = false;
                }
            }
        } 
        if(sigo){
            return "Auto inexistente";
        } else {
            return "El auto con patente: "+ patente+ " esta en la "+plaza+ " en el piso: "+piso;
        }
               
    }
    @Override
    public String toString(){
        String s = " ";
        for (int i = 0; i < plaza; i++){
            for (int j = 0; j < piso; j++){
                if(estacionamientos[j][i] != null ){
                    s += "Plaza"+i+ " Piso: "+j + "Data auto: \n" +estacionamientos[j][i].toString();
                } else {
                    s += "Plaza"+i+ " Piso: "+j;
                }
            }
        } 
        return s;
    }
    
    public int cantAutosEnPlaza(int plaza){ //columna
        int cont = 0;
        for (int i = 0; i < piso; i++){
            if (estacionamientos[i][plaza-1] != null ){
                cont += 1; // cont++;
            }
        }
        return cont;
    }
}
