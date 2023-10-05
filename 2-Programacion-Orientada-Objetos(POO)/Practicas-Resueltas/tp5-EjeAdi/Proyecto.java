/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author nahuelArn
 */
public class Proyecto {

    private String nombre;
    private int codigo;
    private String nombreDirector; //nombre completo director
    private Investigador investigadores[];
    private int dimL = 0;

    //constructor
    private void inicializarArray() {
        investigadores = new Investigador[50];  //se sabe q como max tengo 50 investigadores x proyecto
    }

    public Proyecto(String nombre, int codigo, String nombreDirector) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreDirector = nombreDirector;
        inicializarArray();
    }

    //getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {  //me interesa que me cambien el nombre? Si puede cambiar el nombre del proyecto no calienta
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) { //lo mismo puede cambiar el nombre del director
        this.nombreDirector = nombreDirector;
    }

    public int getDimL() {
        return dimL;
    }

    private void incrementarDimL() {
        this.dimL += 1;
    }

    public void setInvestigadores(Investigador investig) {
        if (dimL < 50) {
            this.investigadores[dimL] = investig;
            incrementarDimL();
        } else {
            System.out.println("Limite de investigadores por proyecto alcanzado!");
        }

    }

    public int otorgarTodos(String nombre) {
        int i = 0;
        boolean ok = false;
        String nombreActual;
        while ((i < this.dimL) && (!this.investigadores[i].getNombre().equals(nombre))) {
            i++;
        }
        //nombreActual = this.investigadores[i].getNombre();
        if (i < dimL) {
            if (this.investigadores[i].getNombre().equals(nombre)) {
                return 5 - this.investigadores[i].getDimL();
            } else {
                return -1;
            }
//        if (this.investigadores[i].getNombre().equals(nombre)) {
//            return 5 - this.investigadores[i].getDimL();
//        } else {
//            System.out.println("No se encontro al Investigador " + nombre);
//            return -1;
//        }

        } else {
            System.out.println("No se encontro al Investigador " + nombre);
            return -1;
        }
    }

    private double totalDineroOtorgado() {
        double gastoTotalProyecto = 0;
        for (int i = 0; i < dimL; i++) {
            gastoTotalProyecto += this.investigadores[i].getDineroTotalOtorgado();
        }
        return gastoTotalProyecto;
    }

    private String concatenarInvestigadores() {
        String dataInvestigador = " ";
        for (int i = 0; i < dimL; i++) {
            dataInvestigador += this.investigadores[i].toString() +"\n";
        }
        return dataInvestigador;
    }

    @Override
    public String toString() {
        return "Nombre del Proyecto: " + this.nombre + " Codigo: " + this.codigo + " Nombre del director: "
                + this.nombreDirector + " Total de dinero otorgado al proyecto: " + this.totalDineroOtorgado() + "\n"+concatenarInvestigadores();

    }

}
