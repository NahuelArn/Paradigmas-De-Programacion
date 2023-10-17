/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public abstract class Coro {
    private int dimL = 0; //voy a cargar a mi corista en forma secuencial 
    private int dimF;
    
    public Coro(int dimF){
        this.dimF = dimF;
    }
    
    
    abstract public void agregarCorista(Corista corista); //esto lo vimos? tener un metodo abstracto para setterar
    public abstract boolean estaLleno();
    public abstract boolean estaBienFormado();
    
    //setters and getters
    public void incrementarDimL(){
        this.dimL += 1;
    }
    public void setDimF(int dimF){
        this.dimF = dimF;
    }

    public int getDimL() {
        return dimL;
    }

    public int getDimF() {
        return dimF;
    }
       
//    @Override
//    public String toString(){
//        return "sarasa";
//    }
}
