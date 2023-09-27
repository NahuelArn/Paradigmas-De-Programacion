/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author nahuelarn
 */
public class Libro {
    private String title;
    private Autor autor = new Autor(); //cada vez que instancie la clase libro se instancia un auto
    private String editorial;
    private int anhoEdicion;
    private int isbn;
    private double precio;
    
    //constructor q le pega directo al autor
    public Libro(String n, String b, String o){
        this.autor.setNombre(n);
        this.autor.setBibliografia(b);
        this.autor.setOrigen(o);
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnhoEdicion() {
        return anhoEdicion;
    }

    public void setAnhoEdicion(int anhoEdicion) {
        this.anhoEdicion = anhoEdicion;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
