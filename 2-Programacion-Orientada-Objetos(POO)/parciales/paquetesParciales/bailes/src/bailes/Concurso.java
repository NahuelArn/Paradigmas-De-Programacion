/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bailes;

/**
 *
 * @author nahuelarn
 */
public class Concurso {
    private Pareja parejas[];
    private int dimL = 0;
    private int dimF;
    //constructor
    public Concurso(int dimF) {
        parejas = new Pareja[dimF];
        this.dimF = dimF;
    }
    
    //sets and ggets
    
    public void agregarParejaAlConcurso(Pareja pareja){
        if(dimL < dimF){
            parejas[dimL] = pareja;
            dimL +=1;
        } else{
            System.out.println("Vector sin espacio para parejas (CLASE CONCURSO, METODO AGREGARPAREJA)");
        }
        
    }
    
    public Pareja obtenerParejaConMasDifDeEdad(){
        int maxDifEdad = -999; Pareja parejaDifEdad = null;
        for (int i = 0; i < dimL; i++){
            if(parejas[i].ObtenerDifEdad() > maxDifEdad ){
                maxDifEdad = parejas[i].ObtenerDifEdad();
                parejaDifEdad = parejas[i];
            }
            
        }
        return parejaDifEdad;
    }
}
