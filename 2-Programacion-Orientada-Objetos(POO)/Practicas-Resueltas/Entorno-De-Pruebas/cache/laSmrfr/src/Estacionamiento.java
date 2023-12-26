/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Estacionamiento {
    private String direccion;
    private double costoPorHora;
    
    private Vehiculo matriz[][];
    private int dimFfilas;
    private int dimFcolumnas;
    
    private int columnaActual;
    private int columnaOcupada;
    private int vectorDimL[];
    
    private void inicilizarVector(){
        for(int i = 0; i < this.dimFcolumnas; i++){
            this.vectorDimL[i] = 0;
        }
    }
    public Estacionamiento(String direccion, double costoPorHora, int dimFfilas, int dimFcolumnas) {
        this.direccion = direccion;
        this.costoPorHora = costoPorHora;
        this.dimFcolumnas = dimFcolumnas;
        this.dimFfilas = dimFfilas;
        this.matriz = new Vehiculo[dimFfilas][dimFcolumnas];
        this.vectorDimL = new int [dimFcolumnas];
        this.inicilizarVector();
        this.columnaActual = 0;
        this.columnaOcupada = 0;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo){
        if(this.columnaActual < this.dimFcolumnas){
            this.matriz[this.vectorDimL[this.columnaActual]][this.columnaActual] = vehiculo;
            this.vectorDimL[this.columnaActual]++;
            if(this.vectorDimL[this.columnaActual] == this.dimFfilas){
                if(this.columnaActual+1 < this.dimFcolumnas){
                    this.columnaOcupada++;
                }
                this.columnaActual++;
            }
        }else{
            System.out.println("Matriz llena");
        }
    }
    public String listarVehiculos(String marca, int sectorX){
        String s = " ";
        if(sectorX < this.columnaActual){
            for(int i = 0; i < this.vectorDimL[sectorX];i++){
                s+= this.matriz[i][sectorX].toString();
            }
        }
        return s;
    }
    public int puntoC(String marca){
        int sectorMenor = -1;
        int min = 999;int cont = 0;
        for(int i = 0; i < this.columnaOcupada+1;i++ ){      //COLUMNA OCUPADAAAAAA
            for(int j = 0; j < this.vectorDimL[i]; j++){
                if(this.matriz[j][i].getMarca().equals(marca)){
                    cont++;
                }
            }
            if(cont < min){
                min = cont;
                sectorMenor = i;
                System.out.println("sectorMenor"+sectorMenor);
            }
            cont = 0;
        }
        return sectorMenor;
    }
    
    private String screapear(){
        String s = " ";
        for(int i= 0; i < this.columnaOcupada+1; i++){
            s += " \n Sector: "+ i+ " \n";
            for(int j = 0; j < this.vectorDimL[i];j++){
                s+= "   Lugar: "+j+" "+ this.matriz[j][i].toString()+ " \n";
            }
        }
        return s;
    }
    @Override
    public String toString() {
        String s = "Estacionamiento{" + "direccion=" + this.direccion + ", costoPorHora=" + this.costoPorHora + '}';
        s+= screapear();
        return s;
    }
    
}
