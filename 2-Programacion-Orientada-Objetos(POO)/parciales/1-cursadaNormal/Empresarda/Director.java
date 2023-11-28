/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Director extends Empleado{
    private double montoViaticos;

    public Director(double montoViaticos, String nombre, String dni, int anhoDeIngresoAlaEmpresa, double sueldoBasico) {
        super(nombre, dni, anhoDeIngresoAlaEmpresa, sueldoBasico);
        this.montoViaticos = montoViaticos;
    }
    
    @Override
    public double sueldoAcobrar(){
        return super.sueldoAcobrar() + this.montoViaticos;
    }

    @Override
    public String toString() {
        return "Director "+super.toString()+"sueldo a cobrar:" + this.sueldoAcobrar()+ "\n";
    }
    
}
