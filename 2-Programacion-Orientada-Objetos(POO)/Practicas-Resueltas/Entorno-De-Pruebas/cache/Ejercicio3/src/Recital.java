/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nahuelArn
 */
public abstract class Recital {
    private String nombreDeLaBanda;
    private String listaDeTemas[];
    private int cantTemas;
    private int dimLTemas;
    public Recital(String nombreDeLaBanda, int cantTemas) {
        this.nombreDeLaBanda = nombreDeLaBanda;
        this.listaDeTemas = new String[cantTemas];
        this.cantTemas = cantTemas;
        this.dimLTemas = 0;
    }
    public void agregarUnTema(String tema){
        if(this.dimLTemas < this.cantTemas){
            listaDeTemas[this.dimLTemas] = tema;
            this.dimLTemas++;
        }
    }
    public void actuar(){
        if((this.dimLTemas > 0) &&(this.dimLTemas < this.cantTemas)){
            String s = listaDeTemas[this.dimLTemas];
            this.dimLTemas++;
            System.out.println("Y ahora tocaremos "+ s);
        }   
    }
    public String imprimirListaDeTemas(){
        String s = " ";
        for(int i =0; i < this.dimLTemas; i++){
            s+= this.listaDeTemas[i] + " ";
        }
        return s;
    }
    public abstract double calcularCosto();
}
