/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public abstract class Empleado {
    private String nombre;
    private String dni;
    private int anhoDeIngresoAlaEmpresa;
    private double sueldoBasico;

    public Empleado(String nombre, String dni, int anhoDeIngresoAlaEmpresa, double sueldoBasico) {
        this.nombre = nombre;
        this.dni = dni;
        this.anhoDeIngresoAlaEmpresa = anhoDeIngresoAlaEmpresa;
        this.sueldoBasico = sueldoBasico;
    }
    
    public double sueldoAcobrar(){
        double comision = this.sueldoBasico*0.10;
        double sueldoAcobrar = this.sueldoBasico;
        if((2023 - this.anhoDeIngresoAlaEmpresa)>20 ){
            sueldoAcobrar = this.sueldoBasico+comision;
        }
        return sueldoAcobrar;
    }

    @Override
    public String toString() {
        return "Empleado " + "nombre: " + this.nombre + " dni: " + this.dni;
    }
    
}
