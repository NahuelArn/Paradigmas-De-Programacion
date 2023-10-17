/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelArn
 */
public class Trabajador extends Persona{
    private String tareaRealizada;
    
    public Trabajador(String nombre, int dni, int anhos, String tareaRealizada){
        super(nombre,dni,anhos);
        this.setTareaRealizada(tareaRealizada);
        
    }
    
    //seters and getrs

    public String getTareaRealizada() {
        return tareaRealizada;
    }

    public void setTareaRealizada(String tareaRealizada) {
        this.tareaRealizada = tareaRealizada;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Soy: "+ this.getTareaRealizada();
    }
}
