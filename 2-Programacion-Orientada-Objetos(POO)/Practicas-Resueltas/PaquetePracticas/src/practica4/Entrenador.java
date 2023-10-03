/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Entrenador extends Empleado {

    private int cantCampeonatosGanados;

    //constructor
    public Entrenador(int cantCampeonatosGanados, String nombre, double sueldoBasico, int antiguedad) {
        super(nombre, sueldoBasico, antiguedad);
        this.setCantCampeonatosGanados(cantCampeonatosGanados);
    }

    //getrs and setts
    public int getCantCampeonatosGanados() {
        return cantCampeonatosGanados;
    }

    public void setCantCampeonatosGanados(int cantCampeonatosGanados) {
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }

    @Override
    public double calcularEfectividad() {
        return this.getCantCampeonatosGanados() / this.getAntiguedad();
        //return this.getCantCampeonatosGanados()/ super.getAntiguedad();
    }
    
    //cumple la funcion de un case/switch 
    private double getBonusEfectividad() {
        int auxCant = this.getCantCampeonatosGanados();
        if ((auxCant >= 1) && (auxCant <= 4)) {
            return 5000;
        } else if ((auxCant >= 5) && (auxCant <= 10)) {
            return 30000;
        } else if (auxCant > 10) {
            return 50000;
        } else {
            return 0;
        }
    }

    @Override
    public double calcularSueldoAcobrar() {
        return super.calcularSueldoAcobrar() + this.getBonusEfectividad();
    }
}