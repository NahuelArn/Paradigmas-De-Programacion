/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Jugador extends Empleado {
    private int numPartidosJugados;
    private int golesAnotados;
    
    
    //constructor
    public Jugador(int numPartidosJugados, int golesAnotados, String nombre, double sueldoBasico, int antiguedad){
        super(nombre, sueldoBasico, antiguedad);
        this.numPartidosJugados = numPartidosJugados;
        this.golesAnotados = golesAnotados;
    }
    
    //getts and setts
    
    public int getNumPartidosJugados() {
        return numPartidosJugados;
    }

    public void setNumPartidosJugados(int numPartidosJugados) {
        this.numPartidosJugados = numPartidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    
    @Override
    public double calcularEfectividad(){
        return this.getGolesAnotados() / this.getNumPartidosJugados();
    }
    
    @Override
    public double calcularSueldoAcobrar() {
        if(this.calcularEfectividad() > 0.5){
           return (this.getSueldoBasico() *2)+ this.getBonusAntiguedad();
        } else {
            return this.getBonusAntiguedad()+this.getSueldoBasico();
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + this.calcularSueldoAcobrar()+ " efectividad: "+ this.calcularEfectividad();
    }
}
