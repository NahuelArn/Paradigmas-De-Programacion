/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Coros {
    private String nombreCoro;
    private Director director;
    private int dimFcoro;   //a priori lo voy a tener q bajar con un getDimF en el main al momento de definir q estructura va usar para generar esa DimF
    private Coro tipoCoro;
    
    //Constructor
    public Coros(String nombreCoro, Director director, int dimFcoro) {
        this.nombreCoro = nombreCoro;
        this.director = director;
        this.dimFcoro = dimFcoro;

    }
    
    //setters and Getters
    public void setTipoCoro(Coro coro){
//        tipoCoro = new Coro();
        this.tipoCoro = coro;
    }

    public String getNombreCoro() {
        return nombreCoro;
    }
    
    public int getDimFcoro(){
        return dimFcoro;
    }
//    @Override
//    public String toString(){
//        return "nombre del coro: "+ nombreCoro+ director.toString()+ " data de los coristas \n"+this.tipoCoro.toString();
//    }
    // En la clase Coros
@Override
public String toString() {
    return "Nombre del coro: " + nombreCoro + "\n" +
           "Director: " + director.toString() + "\n" +
           "Data de los coristas:\n" +
           this.tipoCoro.toString();
}

}
