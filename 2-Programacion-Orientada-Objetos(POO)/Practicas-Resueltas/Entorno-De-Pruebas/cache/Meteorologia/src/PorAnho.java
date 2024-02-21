/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class PorAnho extends Estacion {

    public PorAnho(String nombre, double latitud, double longitud, int nAnhosIzq, int nAnhosDer) {
        super(nombre, latitud, longitud, nAnhosIzq, nAnhosDer);
    }
    
    public String scrapear() {
        String s = " Por anho ";
        double suma = 0;
        int cantAnhos = this.getnAnhosDer() - this.getnAnhosIzq();
        for (int j = 0; j < cantAnhos; j++) {
            suma = 0;
            for (int i = 0; i < 12; i++) {
                suma += this.retornarTemperaturaDeXfecha(i, j);
            }
            s += "  Anho: " + (j + this.getnAnhosIzq()) + " promedio: " + (suma / 12) + " \n";
        }
        return s;
    }

    @Override
    public String toString() {
        return super.toString() + "PorAnho \n";
    }
//    @Override
//    public String toString() {
//        return super.toString() + "PorAnho \n" + scrapear();
//    }


}
