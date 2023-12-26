/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comeback;

/**
 *
 * @author nahuelArn
 */
public class Fisico extends Libro{
    private boolean tapaDura;

    public Fisico(boolean tapaDura, String title, double price) {
        super(title, price);
        this.tapaDura = tapaDura;
    }
    
}

