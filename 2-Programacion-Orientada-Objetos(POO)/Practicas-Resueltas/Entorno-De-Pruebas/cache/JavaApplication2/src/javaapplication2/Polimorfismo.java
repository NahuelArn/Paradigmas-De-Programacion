/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class Polimorfismo {
    public static void main(String[] args) {
        Funcionario funcionario = new Contador();
        funcionario.setNombre("Diego");
        funcionario.setSalario(2000);
        
        Gerente gerente = new Gerente();
        gerente.setNombre("Cecilia");
        gerente.setSalario(4000);
    }
}
