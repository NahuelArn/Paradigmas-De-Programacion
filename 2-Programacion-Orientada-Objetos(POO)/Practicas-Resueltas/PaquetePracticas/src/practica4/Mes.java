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
    
    public Mes(int desdeAnho,int hastaAnho, String nombre, double latitud, double longitud){
        super(desdeAnho,hastaAnho,nombre,latitud,longitud);
    }
    @Override
    public String promedio(){
        double sumaTemp = 0;
        String n = " ";
        double temperaturaActual;
        int cant = 0;
        for (int j = 1; j < 13; j++){
            for (int i = super.getDesdeANho(); i < this.getHastaAnho()+1; i++){
//                temperaturaActual = super.getTemperaturas()[j][i];
                temperaturaActual = super.getTemperatura(i,j);
                if(temperaturaActual != 9999){
                    cant++;
                    sumaTemp += temperaturaActual;
                }
            }
            n += "\n Mes: "+(j)+": "+(sumaTemp/cant)+" C";;
            sumaTemp = 0;
            cant = 0;
        }
        return n;
    }
}
