/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class SistenamaInterno {
    private String key = "12345";
    public boolean auntentica(Gerente gerente){
        boolean puedeIniciarSesion = gerente.iniciarSesion(key);
        if (puedeIniciarSesion){
            System.out.println("Login exitoso");
            return true;
        }else {
            System.out.println("Error en login");
             return false;
        }     
    }
}
