/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public abstract class Estacion {

    private int desdeANho;
    private int hastaAnho;
    private double temperaturas[][]; //meses anhos

    private String nombre;  //nombre estacion
    private double latidud;
    private double longitud;

    //private double dataTemperaturas[][]; //estructura de datos para almacenar los promedios
    private void inicializarMatriz() {
        for (int i = this.desdeANho; i < this.getHastaAnho()+1; i++) {
            for (int j = 0; j < 12; j++) {
                this.temperaturas[j][i] = 9999;
            }
        }
    }
   
    public Estacion(int desdeAnho,int hastaAnho, String nombre, double latitud, double longitud) {
        
        this.desdeANho = desdeAnho;
        this.hastaAnho = hastaAnho;
        this.nombre = nombre;
        this.latidud = latitud;
        this.longitud = longitud;
        
//        temperaturas = new double[12][this.getHastaAnho()+1];
        temperaturas = new double[12][hastaAnho+1];
        inicializarMatriz();
        
    }

    //gettrs and setts
    public int getDesdeANho() {
        return desdeANho;
    }

    public int getHastaAnho() {
        return hastaAnho;
    }
    //Funciona bienm cuando preguntas una temperatura mandole un mes directo 1..12;
    //cuando hago el binding dinamico y utilizo la logica de pasarle el mes 0, 0-1 = -1 error
    public double getTemperatura(int anho, int mes) {
        
//        System.out.println("desdeAnho: "+this.getDesdeANho());
//        System.out.println("desdeAnho: "+this.getHastaAnho());
        
        if ((anho >= this.getDesdeANho()) && (anho <= this.getHastaAnho())) {
            //200 >= 200     |      200 <= 205 TRUE 
//            return this.temperaturas[mes - 1][anho];
//            System.out.println("temperatura del get "+this.temperaturas[mes-1][anho]);
            return this.temperaturas[mes-1][anho];

        } else {
            System.out.println("se paso por parametro un anho fuera del rango q contenplas");
            return -1;
        }
    }
        
    public void setTemperatura(int anho, int mes, double temp) {
//        if (this.getTemperaturas()[mes - 1][anho - 1] == 9999) {
        if (this.getTemperatura(anho,mes) == 9999) {
            this.temperaturas[mes - 1][anho] = temp;
        } else {
            System.out.println("El lugar ya esta ocupado.");
        }

    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatidud() {
        return latidud;
    }

    public void setLatidud(double latidud) {
        this.latidud = latidud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    public String getMesAnhoMaxTemp() {
        int mes = -1;
        int anho = -1;
        double maxTemp = -999;
        for (int i = this.desdeANho; i < this.hastaAnho; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.temperaturas[j][i] > maxTemp) {
                    mes = j;
                    anho = i;
                    maxTemp = this.temperaturas[j][i];
                }
            }
        }
        if (mes != mes) {
            return "mes: " + mes + " anho: " + anho;
        } else {
            return "no hubo mes max, error";
        }
    }
    @Override
    public String toString(){
        return "Estacion: "+ this.getNombre() + " Latitud: "+this.getLatidud()+ " Longitud "+this.getLongitud() +this.promedio(); //binding dinamico
    }

    public abstract String promedio();

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