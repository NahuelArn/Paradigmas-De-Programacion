/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comeback;

import java.awt.BorderLayout;

/**
 *
 * @author nahuelArn
 */
public abstract class Libro {
    private String title;
    private double price;
    private String nameAutor[];
    private int dimL;
    
    public Libro(String title,double price){
        this.title = title;
        this.price = price;
        nameAutor = new String[8];
        this.dimL = 0;
    }

    public void setNameAutor(String nameAutor) {
        if(this.dimL < 8){
            this.nameAutor[dimL] = nameAutor;
            dimL++;
        }else{
            System.out.println("Algun error");
        }
    }

    public double getPrice() {
        return (this.price * 0.21)+ this.price;
    }
    
}
