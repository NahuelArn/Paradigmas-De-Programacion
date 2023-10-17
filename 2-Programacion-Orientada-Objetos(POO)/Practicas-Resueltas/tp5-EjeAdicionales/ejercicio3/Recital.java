/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public abstract class Recital {

    private String nombreDeBanda;
    private String listaTemasQvaAtocar; // a priori un String, no hay nada q se haya dadoq adapte a esto    [podria tener una dimF, Un vector de strings]
//    private String listaTemasQvaAtocar[];
    private int cantTemas; // chequear con el string de arriba uno tiene q volar
    private int dimLTemas;

//    private void inicializarArray(){
//        listaTemasQvaAtocar = new String[cantTemas];
//    }
    public Recital(String nombre, int cantTemas) {
        this.nombreDeBanda = nombre;
        this.cantTemas = cantTemas;
        this.listaTemasQvaAtocar = " Lista de tomas a tocar: " + "\n"; //creo q voy a concatenar
//        inicializarArray();
        dimLTemas = 0;
    }

    //getters and setters
    public String getNombreDeBanda() {
        return nombreDeBanda;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setNombreDeBanda(String nombreDeBanda) {
        this.nombreDeBanda = nombreDeBanda;
    }

//    public String getListaTemasQvaAtocar() {
//        return listaTemasQvaAtocar;
//    }
    public void setListaTemasQvaAtocar(String listaTemasQvaAtocar) {
        if (dimLTemas < cantTemas) {
            this.listaTemasQvaAtocar += "y ahora tocaremos " + listaTemasQvaAtocar + " \n";
        } else {
            System.out.println("Error, alcanzaste la cantidad maxima de temas a tocar");
        }
    }
    
    public String getTemasQvaAtocar(){
        return this.listaTemasQvaAtocar;
    }
    public int getDimLTemas() {
        return dimLTemas;
    }
    
    
//    public void setAgregarTema(String nombreTema) {
//        this.listaTemasQvaAtocar[dimLTemas] = nombreTema;
//        dimLTemas += 1;
//    }

    //me hace ruido esto Podria hacer un binding dinamico? como si yo guardo para cada cosa un dato ya concatenado
//    public void setAgregarTema(String temaNuevo){
//        listaTemasQvaAtocar += "y ahora tocaremos "+temaNuevo + " \n";
//    }
    public abstract String getActuar();
    
    public abstract double calcularCosto();
}
