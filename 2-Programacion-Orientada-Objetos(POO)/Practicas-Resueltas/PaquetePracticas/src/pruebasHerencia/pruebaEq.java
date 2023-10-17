/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasHerencia;

/**
 *
 * @author nahuelarn
 */
public class pruebaEq {
    public static void main(String[] args) {
        Persona p1 = new Persona("pepe","sarasa");
        Persona p2 = new Persona("pepe","sarasa");
        
        if(p1.equals(p2)){
            System.out.println("Iguales");
        } else{
            System.out.println("error");
        }
    }
}
