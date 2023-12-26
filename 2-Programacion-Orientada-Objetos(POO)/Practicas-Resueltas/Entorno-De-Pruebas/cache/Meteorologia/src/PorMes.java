/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class PorMes extends Estacion {

    public PorMes(String nombre, double latitud, double longitud, int nAnhosIzq, int nAnhosDer) {
        super(nombre, latitud, longitud, nAnhosIzq, nAnhosDer);
    }

    public String scrapear() {
        String s = " PorMes ";
        double suma = 0;
        int cantAnhos = this.getnAnhosDer() - this.getnAnhosIzq();
        for (int i = 0; i < 12; i++) {
            suma = 0;
            for (int j = 0; j < cantAnhos; j++) {
                suma += this.retornarTemperaturaDeXfecha(i, j);
            }
            s += "  Mes: " + (i+1) + " promedio: " + (suma / cantAnhos) + " \n";
        }
        return s;
    }

    @Override
    public String toString() {
        return super.toString() + "PorMes \n";
    }
}
