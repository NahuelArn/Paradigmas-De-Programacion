/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comeback;

/**
 *
 * @author nahuelArn
 */
public class Electronico extends Libro{
    private String formato;
    private double tamanho;

    public Electronico(String formato, double tamanho, String title, double price) {
        super(title, price);
        this.formato = formato;
        this.tamanho = tamanho;
    }
    
    
    A:
    
    public double precioFinal(){
        return this.getPrice() + (2.5 * this.tamanho);
    }
    
    B:
    
    
    @Override
    public double getPrice(){
        return super.getPrice() + (2.5 * this.tamanho);
    }
}
