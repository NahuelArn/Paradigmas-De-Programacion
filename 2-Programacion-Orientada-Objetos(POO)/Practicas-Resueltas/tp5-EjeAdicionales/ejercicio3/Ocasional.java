/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Ocasional extends Recital {
    private String motivo; //a beneficio, show de tv o privado
    private String nombreContratante;
    private int diaEvento;
    
    //constructores
    public Ocasional(String nombre, int cantTemas, String motivo, String nombreContratante, int diaEvento){
       super(nombre,cantTemas); 
       this.motivo = motivo;
       this.nombreContratante = nombreContratante;
       this.diaEvento = diaEvento;
    }
    //getters and setters
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public int getDiaEvento() {
        return diaEvento;
    }

    public void setDiaEvento(int diaEvento) {
        this.diaEvento = diaEvento;
    }
    
    @Override
    public double calcularCosto(){
        if(motivo.equals("a beneficio")){
            return 0;
        }else if(motivo.equals("show de tv")){
            return 50000;
        }else if(motivo.equals("privado")){
            return 150000;
        } else{
            System.out.println("Error en calcularCosto Clase Ocasional");
            return -1; 
        }
    }
    
    @Override
    public String getActuar(){
        if(motivo.equals("show de tv")){
            return "Recuerde colaborar con..."+ nombreContratante+ super.getTemasQvaAtocar();
        } else if(motivo.equals("show de tv")){ 
            return "Saludos amigos televidentes"+ super.getTemasQvaAtocar();
        }else if(motivo.equals("privado")){
            return "Un feliz cumpleanhos para..."+nombreContratante+ super.getTemasQvaAtocar();
        }
        return "rompimos algo Error en getActual de la clase Ocasional";
    }
}
