/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Anho extends Estacion {
    
    
    //private double [] dataTemp;
    
            
    public Anho(int desdeAnho,int dimFAnho, String nombre, double latitud, double longitud) {
        super(desdeAnho,dimFAnho,nombre,latitud,longitud);
        //dataTemp = new double[dimFAnho];
    }

    @Override
    public String promedio() {
        double aux = 0;
        String n = " ";
        double auxaux;
        int cant = 0;
        for (int i = super.getDesdeANho(); i < this.getDimFAnho(); i++) { //columnas = anhos
            for (int j = 0; j < 12; j++) {  //filas
                auxaux = super.getTemperaturas()[j][i];
                if(auxaux != 9999){
                    cant++;
                    aux += super.getTemperaturas()[j][i]; //filas = meses
                }
                //aux += super.getTemperaturas()[i][j]; //filas = meses
                
            }
            //tengo la suma de los prom de meses
            //this.dataTemp[i] = aux / super.getDimFAnho();
            //CONCATENO EL STR
            n += "\n Anho: "+i+": "+(aux/cant)+" C";
            cant = 0;
        }
        return n;
        //return aux / 12;
    }
}
