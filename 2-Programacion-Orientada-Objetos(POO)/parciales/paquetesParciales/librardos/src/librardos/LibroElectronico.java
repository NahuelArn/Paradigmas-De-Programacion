/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librardos;

/**
 *
 * @author nahuelarn
 */
public class LibroElectronico extends Libro{
    private String formato; // pdf epub
    private double tamanho; // en mb
    
    //constueocrre

    public LibroElectronico(String formato, double tamanho, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.formato = formato;
        this.tamanho = tamanho;
    }
    
    //setts ang geegs
    @Override
    public double precioFinal(){
        return super.precioFinal() + (2.5 * tamanho);
    }
    @Override
     public String toString(){
         return super.toString() + "formato: "+ formato+ " tamanho: "+tamanho;
     }
}
