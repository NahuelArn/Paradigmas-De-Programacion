/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public abstract class Empleado {
    private String nombre;
    private double sueldoBasico;
    private int antiguedad;
    
    //constructores
    
    public Empleado(){
        
    }
    
    public Empleado(String nombre, double sueldoBasico, int antiguedad){
        this.setNombre(nombre);
        this.setAntiguedad(antiguedad);
        this.setSueldoBasico(sueldoBasico);
    }
    
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    //se repite siempre para todos los empleados, podria accederlo con un super
    public double getBonusAntiguedad(){
        return this.getAntiguedad() * 0.10;
    }
    
    public abstract double calcularEfectividad();
    
    public abstract double calcularSueldoAcobrar();
    
    @Override
    public String toString(){
        return "Nombre: "+ this.getNombre()+ " sueldo a cobrar: ";
    }
}
