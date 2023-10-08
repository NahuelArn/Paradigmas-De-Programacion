/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librardos;

/**
 *
 * @author nahuelarn
 */
public abstract class Libro {
    private String titulo;
    private double precioBase;
    private String nombreAutores[];
    
    private int dimL = 0;
    //constructor
    public Libro(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
        nombreAutores = new String[8];
    }
    
    //settes ang getts

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    public void agregarUnAutor(String autor){
        if(dimL < 8){
            this.nombreAutores[dimL] = autor;
            dimL++;
        } else {
            System.out.println("Te quedaste sin limite en el vector de autores CLASE LIBRO, METODO AGREGARUNAUTOR");
        }
    }


    public int getDimL() {
        return dimL;
    }
    
//    public abstract double precioFinal(); //me parece medio al pedo implementar el binding dinamico en este caso
//    //solo se repite el preciobBase*Iva y si es libro electronico le adiciono 2.5 *MB
//    
     public double precioFinal(){
         System.out.println("Precio base : "+precioBase);
        return precioBase + (precioBase * 0.21);
     }
     @Override
     public String toString(){
         String primerAutor = " ";
         if(dimL >0){
             primerAutor = nombreAutores[0];
         }
         return "Titulo: "+titulo+ " precioFInal: "+ this.precioFinal()+ " Nombre primer autor "+primerAutor;
     }
}
