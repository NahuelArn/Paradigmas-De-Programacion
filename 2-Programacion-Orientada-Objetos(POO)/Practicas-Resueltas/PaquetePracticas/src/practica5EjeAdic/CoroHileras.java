/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class CoroHileras extends Coro {

    private Corista matriz[][];

    //private int vDimLColumnas[]; //para guardar hasta las dimL de cada fila o columna
    private int vDimLFilas[];

    private int columnaActual = 0; //me va tirar la data en que fila me encuentro parado
//    private int dimL = 0; //voy a cargar a mi corista en forma secuencial 
//    private int dimF;

    private void inicializarContador() {
        for (int i = 0; i < super.getDimF(); i++) {
            vDimLFilas[i] = 0;
        }
    }

    public CoroHileras(int dimF) {
        super(dimF);
        vDimLFilas = new int[dimF];
        inicializarContador();
    }

    //el super dimL en esta clase no me sirve
    //setters and getters
    @Override
    public void agregarCorista(Corista corista) {   //vos ya le pasas un corista instanciado
        if (vDimLFilas[columnaActual] < super.getDimF()) {
            matriz[vDimLFilas[columnaActual]][columnaActual] = corista; //durisimo loco
            vDimLFilas[columnaActual] += +1;
        } else {
            if (columnaActual < super.getDimF()) {
                columnaActual += 1;
            } else {
                System.out.println("Matriz completa");
            }
        }
    }

    @Override
    public boolean estaLleno() {
        if (vDimLFilas[super.getDimF()] == super.getDimF()) {    //si el vector de dimL en la ultima posicion esta en el limite, esta llena toda la matriz
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean estaBienFormado() {  //se supne q esta lleno
        boolean vieneCumpliendo = true;
        int max = 999;
        int tonoActual;
        int i = 0; //columnas
        int j; //filas
        while ((i < super.getDimF()) && (vieneCumpliendo)) {    //recorro columnas
            j = 0;
            tonoActual = matriz[j][i].getTonoFundamental();
            while ((i < super.getDimF()) && (vieneCumpliendo) && (j < super.getDimF()) && (tonoActual == matriz[j][i].getTonoFundamental())) {   //recorro filas
                j++;
            }
            //if (tonoActual != matriz[j][i].getTonoFundamental()) {
            if (j < super.getDimF()) {
                vieneCumpliendo = false;
//            } else if (tonoActual == matriz[j][i].getTonoFundamental()) {
            } else if (j == super.getDimF()) {
                if (tonoActual < max) {
                    max = tonoActual;
                    i++;
                }
            }

        }
        return vieneCumpliendo;
    }
    //    Banding dinamico

    @Override
    public String toString() {
        String dataCoristas = " ";
        int r = 0;
        while (r < columnaActual) { //itera en columnas
            for (int i = 0; i < vDimLFilas[r]; i++) { // Itera a través de las filas
                dataCoristas += matriz[i][r].toString() + " \n";
            }
            r++;
        }
        return dataCoristas;
    }

}
