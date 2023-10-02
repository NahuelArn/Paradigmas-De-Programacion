/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasHerencia;

/**
 *
 * @author nahuelarn
 */
public class Hijo extends Abuelo{
//    public Hijo(String a, String b){
//        super(a,b);
//    }
    
    int dni;
    public Hijo(int dni, String apellido){
        this.apellido = apellido;
        this.dni = dni;
    }
}
