/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Circulo extends Figura{
    private double radio;
    //constructor
    public Circulo(String cR, String cF) {
        super(cR, cF);
    }
    
   //getters andas settres

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
   
   
   @Override
   public double getPerimetro(){
       return 2*(Math.PI)*radio;
   }
   @Override
   public double getArea(){
       return (Math.PI)*radio*radio;
   }
}
