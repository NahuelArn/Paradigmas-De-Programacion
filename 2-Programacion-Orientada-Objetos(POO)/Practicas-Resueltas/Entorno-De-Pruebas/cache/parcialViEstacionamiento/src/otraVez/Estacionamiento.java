/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otraVez;

/**
 *
 * @author nahuelArn
 */
public class Estacionamiento {

    private String direccion;
    private double costoPorHora;
    private Vehiculo matriz[][];

    private int cantVehiculosXsector;
    private int cantSectores;

    private int cantVehiculosOcupado;
    private int cantSectoresOcupado;

    public Estacionamiento(String direccion, double costoPorHora, int S, int V) { //sectores, vehiculos
        this.direccion = direccion;
        this.costoPorHora = costoPorHora;
        this.matriz = new Vehiculo[V][S];
        this.cantSectores = S;
        this.cantVehiculosXsector = V;
        this.cantSectoresOcupado = 0;
        this.cantVehiculosOcupado = 0;
    }

//    public void agregarVehiculo(Vehiculo vehiculo) {
//        if ((this.cantSectoresOcupado < this.cantSectores) && (this.cantVehiculosOcupado < this.cantVehiculosXsector)) {
//            this.matriz[this.cantVehiculosOcupado][this.cantSectoresOcupado] = vehiculo;
//            this.cantVehiculosOcupado++;
//        } else {
//            if (this.cantSectoresOcupado < this.cantSectores) {
//                
//                    this.cantSectoresOcupado++;
//                    this.cantVehiculosOcupado = 0;
//                    System.out.println("sarasa");
//                    this.matriz[this.cantVehiculosOcupado][this.cantSectoresOcupado] = vehiculo;
//                
//            }else{
//                 System.out.println("Limite de matriz alcanzado");
//            }
//        }
//        
//    }
    public void agregarVehiculo(Vehiculo vehiculo) {
        if ((this.cantSectoresOcupado < this.cantSectores) && (this.cantVehiculosOcupado < this.cantVehiculosXsector)) {
            this.matriz[this.cantVehiculosOcupado][this.cantSectoresOcupado] = vehiculo;
            this.cantVehiculosOcupado++;    //aumenta en filas
        } else {
            this.cantSectoresOcupado++;
            if (this.cantSectoresOcupado < this.cantSectores) {
//                this.cantSectoresOcupado++;
                this.cantVehiculosOcupado = 0;
//                System.out.println(vehiculo.toString() + "fila: "+cantVehiculosOcupado+" columna: "+this.cantSectoresOcupado);
                this.matriz[this.cantVehiculosOcupado][this.cantSectoresOcupado] = vehiculo;
                this.cantVehiculosOcupado++; 
//                System.out.println("ESTA ACA EL 4: "+this.matriz[0][1].toString());
                System.out.println("");
                
            }else{
                 System.out.println("Limite de matriz alcanzado");
            }
        }
        
    }
       
       
    private int sacarDimL(int sectorX){
        if(sectorX < this.cantSectoresOcupado){
            return this.cantVehiculosXsector;
        }else{
            return this.cantVehiculosOcupado;
        }
            
    }
    public String listarSectorDeMarcaM(String marca,int sectorX){
        int dimL = sacarDimL(sectorX);
        String s = " ";
        if(sectorX < this.cantSectores){
            for(int i =0; i < dimL; i++){
                if(matriz[i][sectorX].getMarca().equals(marca)){
                    s+= matriz[i][sectorX].toString()+" \n";
                }
            }
        }
        return s;
    }
    private boolean sacarMin(int cont, int contMin, int sectorMin, int i){
        if(cont < contMin){
            return true;
        }else{
            return false;
        }
    }
    public int sectorConMenosCantDeMarcaM(String marca){
        int contMin = 999;
        int cont = 0;
        int sectorMin = -1;
        for(int i = 0; i < this.cantSectoresOcupado+1; i++){
            for(int j = 0; j < sacarDimL(i); j++){
                if(this.matriz[j][i].getMarca().equals(marca)){
                   cont++; 
                }
            }
            if(sacarMin(cont,contMin,sectorMin,i)){
                contMin = cont;
//                System.out.println("minimo"+ contMin);
                sectorMin = i;
            }
            cont =0;
        }
        return sectorMin;
    }
    
    private String scrapear(){
        String s = " ";
        for(int i = 0; i < (this.cantSectoresOcupado+1); i++){
            s+= "Sector: "+ i +" \n";
            for(int j = 0; j < sacarDimL(i); j++){
                s += "  "+this.matriz[j][i].toString()+ " \n";            }
            s += " \n";
        }
        return s;
    }
//     private String scrapear(){
//        String s = " ";
//        for(int i = 0; i < 3; i++){
//            s+= "Sector: "+ i +" \n";
//            for(int j = 0; j < 3; j++){
//                if(this.matriz[j][i] != null)
//                    s += "  "+this.matriz[j][i].toString()+ " \n";
//            }
//            s += " \n";
//        }
//        return s;
//    }
    @Override
    public String toString() {
        return "Estacionamiento{" + "direccion=" + direccion + ", costoPorHora=" + costoPorHora +" \n" + scrapear();
    }    
}
