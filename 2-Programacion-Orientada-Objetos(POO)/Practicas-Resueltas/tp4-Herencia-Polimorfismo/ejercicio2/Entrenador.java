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
        //double bonusAntiguedad = this.getAntiguedad() * 0.10;
        
//        double bonusEfectividad;
//        int auxCant = this.getCantCampeonatosGanados();
//        if ((auxCant >= 1) && (auxCant <= 4)) {
//            bonusEfectividad = 5000;
//        } else if ((auxCant >= 5) && (auxCant <= 10)) {
//            bonusEfectividad = 30000;
//        } else if (auxCant > 10) {
//            return bonusEfectividad = 50000;
//        }
        return this.getBonusAntiguedad() + this.getSueldoBasico() + this.getBonusEfectividad();
    }
    
    @Override
    public String toString(){
        return super.toString() + this.calcularSueldoAcobrar() + " efectividad: "+ this.calcularEfectividad();
    }
}
