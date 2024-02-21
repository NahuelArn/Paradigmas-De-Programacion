/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class ControlBonificacion {
    private double suma;
    public double registrarSalario(Funcionario funcionario){
        this.suma = funcionario.getBonificacion() + this.suma;
        return this.suma;
    }
    
//    public double registrarSalario(Gerente gerente){
//        this.suma = gerente.getBonificacion() + this.suma;
//        return this.suma;
//    }
//    
//    public double registrarSalario(Contador contador){
//        this.suma = contador.getBonificacion() + this.suma;
//        return this.suma;
//    }
}
