/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Gira extends Recital{
    private String nombreGira;
    private Fecha fechas[]; // a priori "fechas un string"
    
    private int dimL;
    
    //constructor

    private void inicializarFechas(int cantFechas){
       fechas = new Fecha[cantFechas];
    }
    public Gira(String nombre, int cantTemas, String nombreGira, int cantFechas){
       super(nombre,cantTemas); 
       this.nombreGira = nombreGira;
       inicializarFechas(cantFechas);
       dimL = 0;
    }
    //getters and setters
    public String getNombreGira() {
        return nombreGira;
    }

    public void setNombreGira(String nombreGira) {
        this.nombreGira = nombreGira;
    }
    
    public void setAgregarFecha(Fecha fecha){
        if(dimL < super.getCantTemas()){
            fechas[dimL] = fecha;
            dimL += 1;
        } else {
            System.out.println("Sin fechas disponibles para anhadir Error en metodo SetFecha, clase Gira");
        }
    }
    
    @Override
    public double calcularCosto(){
        return 30000*dimL;
    }
    
    @Override
    public String getActuar(){
        this.fechas[dimL].setDia(this.fechas[dimL].getNumFechaSiguiente());
        return "Buenas noches.."+" Ciudad: "+this.fechas[dimL].getCiudad()+super.getTemasQvaAtocar();
    }
}
