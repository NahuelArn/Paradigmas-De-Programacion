/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Funcionario nawel = new Contador();
        nawel.setDocumento(45402934);
        nawel.setNombre("pepe");
        nawel.setSalario(3000);
        System.out.println("Funcionario salario");
        System.out.println(nawel.getSalario());
        System.out.println(nawel.getBonificacion());
        
        Gerente pepe = new Gerente();    
        pepe.setSalario(2000);
        pepe.getBonificacion();
        System.out.println("Gerente salario");
        System.out.println(pepe.getSalario());
        
        
        Funcionario carlos = new Contador();
        carlos.setSalario(1000);
        carlos.setTipo(2);
        carlos.getBonificacionAll();
        
        System.out.println(carlos.getTipo());
        System.out.println(carlos.getSalario());
        
        //------------------------------------
        System.out.println("estamos aca");
        Gerente gerente = new Gerente();
        gerente.setClave("Alura");
        gerente.setSalario(1000);
        System.out.println(gerente.getBonificacion());
         //verifico la clave
        System.out.println(gerente.iniciarSesion("sarasa"));
        
    }
}