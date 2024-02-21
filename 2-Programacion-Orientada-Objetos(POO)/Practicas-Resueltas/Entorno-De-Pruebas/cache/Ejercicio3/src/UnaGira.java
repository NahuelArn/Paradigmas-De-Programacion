/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nahuelArn
 */
public class UnaGira extends Recital{
    private String nombreDeLaGira;
    private Fecha fechas[];
    //private int fechaActual;
    private int fechaProxima; 
    private int dimF;
    private int dimL;
    public UnaGira(String nombreDeLaGira, int dimF, String nombreDeLaBanda, int cantTemas) {
        super(nombreDeLaBanda, cantTemas);
        this.nombreDeLaGira = nombreDeLaGira;
        this.fechas = new Fecha[dimF];
        this.dimF = dimF;
        this.dimL = 0;
        this.fechaProxima = 0; //sarasa
    } 
    public void agregarFecha(Fecha fecha){
        if(this.dimL < this.dimF){
           this.fechas[this.dimL] = fecha;
           this.dimL++; 
        }
    }
    private String fechaActual(){
        String s = " ";
        if((this.fechas[this.fechaProxima] != null) && (this.fechaProxima < this.dimL)){
            s += this.fechas[this.fechaProxima].getCiudad();
            this.fechaProxima++;
        }else{
            this.fechaProxima = 0; //reseteo las fechas 
            return "Se renovaron las fechas o No hay ninguna fecha todavia";
        }
        return s;
    }
    @Override
    public void actuar(){
        String s = " ";
        //s += " Buenas noches " + fechaActual() + super.actuar();  //imprimiria un solo tema
        s += " Buenas noches " + fechaActual() + this.imprimirListaDeTemas();
        System.out.println(s);
    }
    @Override
    public double calcularCosto(){
        return 30000 * this.dimL;
    }
}
