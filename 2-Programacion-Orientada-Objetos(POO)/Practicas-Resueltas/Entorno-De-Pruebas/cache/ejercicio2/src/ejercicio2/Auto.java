/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author nahuelArn
 */
public class Auto {
    private String nombreDeDuenho;
    private String patente;

    public Auto(String nombreDeDuenho, String patente) {
        this.nombreDeDuenho = nombreDeDuenho;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public String toString() {
        return "Auto{" + "nombreDeDuenho=" + nombreDeDuenho + ", patente=" + patente + '}';
    }
    
    
}
