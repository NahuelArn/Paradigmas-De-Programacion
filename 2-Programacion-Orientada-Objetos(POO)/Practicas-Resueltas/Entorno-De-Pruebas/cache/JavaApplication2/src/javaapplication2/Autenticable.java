/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public abstract interface Autenticable{
    
    public abstract void setClave(String clave);
    public abstract boolean iniciarSesion(String clave);
}
