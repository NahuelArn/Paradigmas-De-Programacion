/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaVectorM;

/**
 *
 * @author nahuelArn
 */
public class Padre {

    private String matriz[][];
    private int filaN;
    private int columnaN;

    private int vectorDimls[];
    private int columnaActual;
    private int columnasOcupadas = 0;

    private void inicializarVector() {
        for (int i = 0; i < this.columnaN; i++) {
            this.vectorDimls[i] = 0;
        }
    }

    public Padre(int filaN, int columnaN) {
        this.matriz = new String[filaN][columnaN];
        this.filaN = filaN;
        this.columnaN = columnaN;
        this.vectorDimls = new int[columnaN];
        inicializarVector();
        this.columnaActual = 0;
    }

    public void agregarNombre(String nombre) {
        if (this.columnaActual < this.columnaN) {
            this.matriz[this.vectorDimls[this.columnaActual]][this.columnaActual] = nombre;
            this.vectorDimls[this.columnaActual]++;
            if (this.vectorDimls[this.columnaActual] == this.filaN) {
                if ((this.columnaActual + 1) < this.columnaN) {
                    columnasOcupadas++;
                }
                this.columnaActual++;   //corta con 3 cuando estoy en la ultima columna,pasa a 3 y despues entra en matriz llena
//                System.out.println("Valores de columna Actual: " + this.columnaActual);
            }
        } else {
            System.out.println("Matriz llena");
        }
    }

    private void imprimirVector() {
        for (int i = 0; i < this.columnaN; i++) {
            System.out.println("lugar: " + i + " contenido: " + this.vectorDimls[i]);
        }
    }

    public String scrapear() {
        String msj = " ";
        imprimirVector();
        for (int i = 0; i < this.columnasOcupadas + 1; i++) {
            msj += " Columna: " + i+"\n";
            for (int j = 0; j < this.vectorDimls[i]; j++) {
                msj += "    Fila: " + j + " " + this.matriz[j][i] + " \n";
            }
        }
        return msj;
    }

    @Override
    public String toString() {
        return scrapear();
    }

}
