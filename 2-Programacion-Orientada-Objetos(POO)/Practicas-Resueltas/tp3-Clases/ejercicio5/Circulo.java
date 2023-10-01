/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author nahuelarn
 */
public class Circulo {
    private double radio;
    private String relleno;
    private String colorLinea;

    
    //constructor
    public Circulo(){
        
    }
    
    public Circulo(double ra,String re, String co){
        this.radio = ra;
        this.colorLinea = co;
        this.relleno = re;
    }
    
    //getters and setters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    // ((2*PI) *radio)
    public double getPerimetro(){
        return (radio *(2*Math.PI));
    }
    
    public double getzArea(){
        return (Math.PI *(radio*radio));
    }
}
