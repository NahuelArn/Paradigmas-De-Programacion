/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Mes extends Estacion{
    
    public Mes(int desdeAnho,int dimFAnho, String nombre, double latitud, double longitud){
        super(desdeAnho,dimFAnho,nombre,latitud,longitud);
    }
    @Override
    public String promedio(){
        double aux = 0;
        double auxaux;
        int cant = 0;
        String n = " ";
//        for (int i = super.getDesdeANho(); i < this.getDimFAnho(); i++)
        for (int j = 0; j < 12; j++){
            for (int i = super.getDesdeANho(); i < this.getDimFAnho(); i++){
                auxaux = super.getTemperaturas()[j][i];
                if(auxaux != 9999){
                    cant++;
                    aux += auxaux;
                }
//                aux += super.getTemperaturas()[j][i];
            }
            n += "\n Mes: "+(j+1)+": "+(aux/cant)+" C";;
            cant = 0;
        }
        return n;
    }
}
