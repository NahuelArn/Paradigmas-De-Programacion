/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author nahuelarn
 */
public class Autor {
    private String nombre;
    private String bibliografia;
    private String origen;

//    public Autor(String n, String b, String o){
//        this.nombre = n;
//        this.bibliografia = b;
//        this.origen = o;
//    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    @Override
        public String toString(){
            String s = ("nombre: "+this.nombre+ " bibliografica: "+this.bibliografia+ "origen: "+this.origen);
            return s;
        }
}
