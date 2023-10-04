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
              
    public Anho(int desdeAnho,int hastaAnho, String nombre, double latitud, double longitud) {
        super(desdeAnho,hastaAnho,nombre,latitud,longitud);
    }

    @Override
    public String promedio() {
        double sumaTemp = 0;
        String n = " ";
        double temperaturaActual;
        int cant = 0;
        for (int i = super.getDesdeANho(); i < this.getHastaAnho()+1; i++) { //columnas = anhos
            for (int j = 1; j < 13; j++) {  //filas
                temperaturaActual = super.getTemperatura(i,j);
                if(temperaturaActual != 9999){
                    cant++;
                    sumaTemp += temperaturaActual; //filas = meses
                }                
            }
            n += "\n Anho: "+i+": "+(sumaTemp/cant)+" C";
            sumaTemp= 0;
            cant = 0;
        }
        return n;
    }
}

/*
Logica del promedio con el getTemperatura

public class Main
{
	public static void main(String[] args) {
	  for (int i = 200; i < 205; i++){
	      System.out.println("cant anhos"+i);
	  }
	  System.out.println("");
	  for (int i = 200; i < 206; i++){
	      System.out.println("cant anhos"+i);
	  }

	  System.out.println("");
	  for (int i = 0; i < 5; i++){
	      System.out.println("cant anhos"+i);
	  }
		System.out.println("Hello World");
	}
}

*/
