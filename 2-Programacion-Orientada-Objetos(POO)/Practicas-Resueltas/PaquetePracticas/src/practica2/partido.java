/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

/**
 *
 * @author nahuelArn
 */
public class partido {

    public String local;
    public String visitante;
    public int cantGolesLocal;
    public int cantGolesVisitante;
    

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public int getCantGolesLocal() {
        return cantGolesLocal;
    }

    public void setCantGolesLocal(int cantGolesLocal) {
        this.cantGolesLocal = cantGolesLocal;
    }

    public int getCantGolesVisitante() {
        return cantGolesVisitante;
    }

    public void setCantGolesVisitante(int cantGolesVisitante) {
        this.cantGolesVisitante = cantGolesVisitante;
    }
    
    public partido(String l, String v, int cL, int cV){
        this.local = l;
        this.visitante = v;
        this.cantGolesLocal = cL;
        this.cantGolesVisitante = cV;
    }
    
    //chequea si alguno de los equipos gano el partido
    public boolean getHayGanador() {
        return this.cantGolesVisitante > this.cantGolesLocal || this.cantGolesLocal > this.cantGolesVisitante;

    }
    //retorna el nombre del equipo gandor, si no hay ganador retorna espacio sin asignar
    public String getGanador() {
        if (getHayGanador()) {
            if (this.cantGolesLocal > this.cantGolesVisitante) {
                return this.getVisitante();
            } else {
                return this.getLocal();
            }
        } else {
            return "";
        }
    }
    
    public boolean getHayEmpate(){
        return this.cantGolesVisitante == this.cantGolesLocal;
    }
    
//    public partido setCrearPicadito(){
//        
//        return this.partido;
//    }
}
