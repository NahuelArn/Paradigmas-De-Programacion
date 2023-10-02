/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package practica4;
/**
 *
 * @author nahuelarn
 */
public abstract class Figura {
    private String colorRelleno;
    private String ColorLinea;
    
    //constructor
    public Figura(String cR, String cL){
        this.ColorLinea = cL;
        this.colorRelleno = cR;
    }
    //getts and setters
    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return ColorLinea;
    }

    public void setColorLinea(String ColorLinea) {
        this.ColorLinea = ColorLinea;
    }
    
    public void setDespintar(){
        this.setColorLinea("Negro");
        this.setColorRelleno("Blanco");
    }
    
    public abstract double getPerimetro();
    public abstract double getArea();
    
    @Override
    public String toString(){
        return "El perimetro es: "+ this.getPerimetro();
    }
}
