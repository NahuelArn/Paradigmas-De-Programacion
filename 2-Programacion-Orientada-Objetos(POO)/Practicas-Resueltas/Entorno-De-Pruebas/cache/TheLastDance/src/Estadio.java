/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Estadio {

    private String nombre;
    private String direccion;
    private int capacidad;

    private Concierto matriz[][];
    private int disponibilidad[];

    private void iniciarVectorDimLs() {
        for (int i = 0; i < 12; i++) {
            this.disponibilidad[i] = 0;
        }
    }

    public Estadio(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.matriz = new Concierto[31][12];
        this.disponibilidad = new int[12];
        iniciarVectorDimLs();

    }

    public void registrarConcierto(Concierto concierto, int mesM) {
        if (this.disponibilidad[mesM] < 31) {
            this.matriz[this.disponibilidad[mesM]][mesM] = concierto;
            this.disponibilidad[mesM]++;
        }
    }

    public String listarConciertosMesM(int mesM) {
        String s = " ";
        if ((mesM >= 0) && (mesM <= 11)) {
            for (int i = 0; i < this.disponibilidad[mesM]; i++) {
                s += matriz[i][mesM].toString();
            }
        }
        return s;
    }

    public double gananciaDelEstadioEnMes(int mesM) {
        double suma = 0, sumaTotal = 0;
        if ((mesM >= 0) && (mesM <= 11)) {
            for (int j = 0; j < this.disponibilidad[mesM]; j++) {
                suma = this.matriz[j][mesM].getCantEntradasVendidas() * this.matriz[j][mesM].getPrecioEntrada();
                sumaTotal += suma / 2;
            }
        }
        return sumaTotal;
    }

    private String scrapear() {
        String s = " ";
        for (int i = 0; i < 12; i++) {
            s += "Mes: " + i;
            for (int j = 0; j < this.disponibilidad[i]; j++) {
                s +=  " \n" + " Dia: " + j + ": " + this.matriz[j][i].toString() ;
            }
            s+= "\n"+"-----------------------------------------------"+"\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return "Estadio: " + "nombre: " + this.nombre + " capacidad: " + this.capacidad + scrapear();
    }

}
