/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class ejercicio1 {
  public static void main(String[] args) {
    Circulo circulo = new Circulo("Rojo", "Amarillo");
    circulo.setRadio(20);
    // imprime perimetro
    System.out.println(circulo.toString());

    System.out.println("color: " + circulo.getColorLinea());
    // estaba Amarillo
    circulo.setDespintar();
    System.out.println("color: " + circulo.getColorLinea());

  }
}
