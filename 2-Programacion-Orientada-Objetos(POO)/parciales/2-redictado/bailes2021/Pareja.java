/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bailes;

/**
 *
 * @author nahuelarn
 */
public class Pareja {

    private Participante participante1;
    private Participante participante2;
    private String estiloDeBaile;
    
    //constructor
    public Pareja(Participante participante1, Participante participante2, String estiloDeBaile) {
        this.participante1 = participante1;
        this.participante2 = participante2;
        this.estiloDeBaile = estiloDeBaile;
    }
    
    //gettes ands setts
    public int ObtenerDifEdad() {
        if (participante1.getEdad() > participante2.getEdad()) {
            return participante1.getEdad() - participante2.getEdad();
        } else if (participante1.getEdad() < participante2.getEdad()) {
            return participante2.getEdad() - participante1.getEdad();
        } else {
            return 0;
        }

    }
    
    public String mostrarNombre2Participante(){
        String nombrePareja = " ";
        nombrePareja = "nombre de la pareja con mas dif de edad\n "+
                " nombre1: "+participante1.getNombre() + " nombre2: "+participante2.getNombre();
        return nombrePareja;
    }

}
