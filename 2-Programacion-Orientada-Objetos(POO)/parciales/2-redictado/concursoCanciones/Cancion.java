/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author nahuelarn
 */
public class Cancion {
    private String nombreCancion;
    private String suCompositor;
    private int codIdentificador;
    private Estudiante estudiante;
    private double puntaje;
    
    //construtor
    
    public Cancion(String nombre, String suCompositor, int codIdentificador ){
        this.nombreCancion = nombre; //x
        this.suCompositor = suCompositor; //x
        this.codIdentificador = codIdentificador; ///x
//        this.estudiante = estudiante;
        this.puntaje = 0; // 
    }
    
    //setters and ggets

    public String getNombreCancion() {
        return nombreCancion;
    }

    public String getSuCompositor() {
        return suCompositor;
    }

    public int getCodIdentificador() {
        return codIdentificador;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Cancion{" + "nombreCancion=" + nombreCancion + ", suCompositor=" + suCompositor + '}';
    }
    
    
}
