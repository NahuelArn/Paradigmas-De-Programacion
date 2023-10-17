/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Triangulo extends Figura {

    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(String cR, String cF) {
        super(cR, cF);
    }

    @Override
    public double getPerimetro() {
        return this.lado1 + this.lado2 + this.lado3;
    }
    @Override
    public double getArea() {
        double aux;
        aux = this.getPerimetro();
        if (aux > 0) {
            return Math.sqrt(aux * (aux - lado1) * (aux - lado2) * (aux - lado3));
        } else {
            System.out.println("rompiste algo");
            return -404;
        }

    }
}
