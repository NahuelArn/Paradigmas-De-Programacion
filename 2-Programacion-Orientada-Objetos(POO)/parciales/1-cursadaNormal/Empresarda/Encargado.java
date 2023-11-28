/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Encargado extends Empleado{
    private int cantEmpleados;

    public Encargado(int cantEmpleados, String nombre, String dni, int anhoDeIngresoAlaEmpresa, double sueldoBasico) {
        super(nombre, dni, anhoDeIngresoAlaEmpresa, sueldoBasico);
        this.cantEmpleados = cantEmpleados;
    }
    @Override
    public double sueldoAcobrar(){
        return super.sueldoAcobrar() + (this.cantEmpleados*1000);
    }
    @Override
    public String toString() {
        return " Encargado "+super.toString()+"sueldo a cobrar:" + this.sueldoAcobrar();
    }
}
