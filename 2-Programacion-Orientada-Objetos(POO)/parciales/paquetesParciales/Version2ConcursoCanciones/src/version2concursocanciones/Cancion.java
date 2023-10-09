/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2concursocanciones;

/**
 *
 * @author nahuelarn
 */
public class Cancion {
    private String nombre;
    private String compositorNombre;
    private int numIdentificacion;
    private Estudiante estudiante;
    private double puntajeOtorgado;

    public Cancion(String nombre, String compositorNombre, int numIdentificacion) {
        this.nombre = nombre;
        this.compositorNombre = compositorNombre;
        this.numIdentificacion = numIdentificacion;
        
        this.puntajeOtorgado = 0;
    }

    public int getNumIdentificacion() {
        return numIdentificacion;
    }

    public double getPuntajeOtorgado() {
        return puntajeOtorgado;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setPuntajeOtorgado(double puntajeOtorgado) {
        this.puntajeOtorgado = puntajeOtorgado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    @Override
    public String toString() {
        return "Cancion{" + "nombre=" + nombre + ", compositorNombre=" + compositorNombre + '}';
    }
    
    
}
