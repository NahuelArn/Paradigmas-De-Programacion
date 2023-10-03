/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Anhos extends Estacion {
    
    
    private double [] dataTemp;
    
            
    public Anhos(int dimFAnho) {
        super(dimFAnho);
        dataTemp = new double[dimFAnho];
    }

    @Override
    public double promedio() {
        double aux = 0;
        String n = " ";
        for (int i = 0; i < this.getDimFAnho(); i++) { //columnas = anhos
            for (int j = 0; j < 12; j++) {  //filas
                aux += super.getTemperaturas()[i][j]; //filas = meses
                
            }
            //tengo la suma de los prom de meses
            this.dataTemp[i] = aux / super.getDimFAnho();
            //CONCATENO EL STR
            n += " "+aux;
        }
        return n;
        //return aux / 12;
    }
}
