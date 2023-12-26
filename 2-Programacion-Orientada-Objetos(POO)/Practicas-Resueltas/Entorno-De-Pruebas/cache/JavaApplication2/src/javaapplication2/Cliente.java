/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class Cliente implements Autenticable {
    private String nombre;
    private String numeroIdentidad;
    private String profesion;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumeroIdentidad () {
        return numeroIdentidad;
    }
    public void setNumeroIdentidad (String numeroIdentidad) {
        this. numeroIdentidad = numeroIdentidad;
    }
    public String getProfesion () {
        return profesion;
    }
    public void setProfesion(String profesion) {
        this. profesion = profesion;
    }

    @Override
    public void setClave(String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean iniciarSesion(String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
