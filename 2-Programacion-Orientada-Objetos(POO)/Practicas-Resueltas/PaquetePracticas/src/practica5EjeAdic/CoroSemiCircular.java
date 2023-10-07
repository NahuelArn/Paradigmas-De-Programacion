/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class CoroSemiCircular extends Coro{
    private Corista vector [];
    
//    private int dimL = 0; //voy a cargar a mi corista en forma secuencial 
//    private int dimF;
     public CoroSemiCircular(int dimF){
        super(dimF);
        vector = new Corista[dimF];
    }
     
    //setters and getters
     @Override
     public void agregarCorista(Corista corista){ //vos ya le pasas un corista instanciado
         if(super.getDimL() < super.getDimF() ){
             vector[super.getDimL()] = corista;
             super.incrementarDimL();
         }
     }
     
     @Override
     public boolean estaLleno(){
         if(super.getDimL() == super.getDimF() ){
             return true;
         }else{
             return false;
         }
     }
     @Override
     public boolean estaBienFormado(){
         boolean vieneCumpliendo = true;
         int max = -999;
         int i = 0;
         while (i < super.getDimL() && (vieneCumpliendo)){
             if(vector[i].getTonoFundamental() > max){
                 max = vector[i].getTonoFundamental();
            }else{
                 vieneCumpliendo = false;
             }
         }
       return vieneCumpliendo;
     }
     
    //    pruebaBanding dinamico
    @Override
    public String toString(){
        String dataCoristas = " ";
        for (int i = 0; i < super.getDimL(); i++){
            dataCoristas += vector[i].toString();
        }   
        return  dataCoristas + "\n Aplico la logica del, vector de figuras, el vector contenia circulo,cuadrado,triangulo y sabia responder a cada cosa";
    } 
    
    
}
