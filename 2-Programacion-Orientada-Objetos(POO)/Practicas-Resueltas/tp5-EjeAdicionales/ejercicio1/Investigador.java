/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Investigador {
    private String nombre;
    private int categoria;  //1..5
    private String especialidad;
    private Subsidio subsidios[];
    private int dimL = 0;
    
    //constructor
    private void inicializarVector(){
        subsidios = new Subsidio[5];
        for (int i = 0; i < dimL; i++){
            this.subsidios[i] = new Subsidio();
        }
    }
    public Investigador(String nombre, int categoria, String especialidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.especialidad = especialidad;
        inicializarVector();
    }
    
    //getters and setters
    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) { //podria cambiar
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) { //podria cambiar
        this.especialidad = especialidad;
    }
    
    private void incrementarDimL() {
        this.dimL +=1;
    } 
    
    public void setSubsidio(Subsidio subsidio) { //podria servir
        if(dimL < 5){
            this.subsidios[dimL] = subsidio;
            incrementarDimL();
        }else{
            System.out.println("Alcanzo sus limite de 5 subsidios este Investigador");
        }
    }

    public int getDimL() {
        return dimL;
    }
    
    public double getDineroTotalOtorgado(){
        double totalMontoInvestigador = 0;
        for (int i = 0; i < dimL; i++){
            totalMontoInvestigador += subsidios[i].getMontoPedido();
        }
        return totalMontoInvestigador;
    }
    
    @Override
    public String toString(){
        return "Nombre Investigador: "+this.nombre + "Categoria: "+this.categoria +"Especialidad: "+this.especialidad+"Total gasto subsideo: "+this.getDineroTotalOtorgado();
    }
}
