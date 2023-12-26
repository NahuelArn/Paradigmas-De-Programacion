/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class tesControlBonificacion {
    public static void main(String[] args) {
        Funcionario diego = new Contador();
        diego.setSalario(2000);
        
        Gerente jimena = new Gerente();
        jimena.setSalario(4000);
        
        Contador pepe = new Contador();
        pepe.setSalario(1000);
   
        ControlBonificacion controlBonificacion = new ControlBonificacion();
        
        System.out.println("Control funcionario");
        System.out.println(controlBonificacion.registrarSalario(diego));
        
        System.out.println("Control gerente");
        System.out.println(controlBonificacion.registrarSalario(jimena));
        
        System.out.println("Control contador");
        System.out.println(controlBonificacion.registrarSalario(pepe));
    }
}
