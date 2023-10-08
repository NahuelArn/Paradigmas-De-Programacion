/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librardos;

/**
 *
 * @author nahuelarn
 */
public class LibroImpreso extends Libro{
    private boolean tapaDura;
    
    //constructor

    public LibroImpreso(boolean tapaDura, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.tapaDura = tapaDura;
    }
    
    //settes ang geets
        @Override
     public String toString(){
         return super.toString() + "tipo de tapa: (Si o no)"+ tapaDura;
     }
}
