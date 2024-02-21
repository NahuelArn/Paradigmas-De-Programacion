/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diMov;

/**
 *
 * @author nahuelArn
 */
public class Padre {

    private String matriz[][];

    private int dimFfilas;
    private int dimFcolumnas;

    private int vectorDimL[];
    private int columnaActual;
    private int columnaCargada;

    private void inicializarVector() {
        for (int i = 0; i < this.dimFcolumnas; i++) {
            this.vectorDimL[i] = 0;
        }
    }

    public Padre(int dimFfilas, int dimFcolumnas) {
        this.matriz = new String[dimFfilas][dimFcolumnas];
        this.dimFcolumnas = dimFcolumnas;
        this.dimFfilas = dimFfilas;
        this.vectorDimL = new int[dimFcolumnas];
        inicializarVector();
        this.columnaActual = 0;
        this.columnaCargada = 0;
    }

    public void agregar(String nombre) {
        if (this.columnaActual < this.dimFcolumnas) {
            int fila = this.vectorDimL[this.columnaActual] / this.dimFcolumnas;
            int columna = this.vectorDimL[this.columnaActual] % this.dimFcolumnas;

            this.matriz[fila][columna] = nombre;
            this.vectorDimL[this.columnaActual]++;

            if (this.vectorDimL[this.columnaActual] == this.dimFfilas * (this.columnaActual + 1)) {
                if (this.columnaActual + 1 < this.dimFcolumnas) {
                    this.columnaCargada++;
                }
                this.columnaActual++;
            }
        } else {
            System.out.println("Matriz llena");
        }
    }

    public String mostrar() {
        String s = " ";
        for (int i = 0; i < this.columnaCargada + 1; i++) {
            s += " Columna: " + i + " \n";
            for (int j = 0; j < this.dimFfilas; j++) {
                int index = j * this.dimFcolumnas + i;
                s += "    Fila: " + j + " " + this.matriz[j][i] + " \n";
            }
        }
        return s;
    }
}
