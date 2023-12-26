/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaconmatrices;

/**
 *
 * @author nahuelArn
 */
public class Padre {

    private Hijo matriz[][];
    private int dimFfilas;
    private int dimFColumnas;

    private int dimLFilasOcupadas;
    private int dimLColumnasOcupadas;

    public Padre(int dimFfilas, int dimFColumnas) {
        this.matriz = new Hijo[dimFfilas][dimFColumnas];
        this.dimFColumnas = dimFColumnas;
        this.dimFfilas = dimFfilas;
        this.dimLFilasOcupadas = 0;
        this.dimLColumnasOcupadas = 0;
    }

    public void agregarHijo(Hijo hijo) { //cargarlo en orden secuencial
        if ((this.dimLColumnasOcupadas < this.dimFColumnas) && (this.dimLFilasOcupadas < this.dimFfilas)) {
            this.matriz[this.dimLFilasOcupadas][this.dimLColumnasOcupadas] = hijo;
            this.dimLFilasOcupadas++;
        }else{
            this.dimLColumnasOcupadas++;
            if(this.dimLColumnasOcupadas < this.dimFColumnas){
                this.dimLFilasOcupadas = 0;
                this.matriz[this.dimLFilasOcupadas][this.dimLColumnasOcupadas] = hijo;
                this.dimLFilasOcupadas++;
            }else{
                System.out.println("\n Matriz completa \n");
            }
        }
    }
    private int testigo(int columnaActual){
        if(columnaActual < this.dimLColumnasOcupadas){
            return this.dimFfilas;
        }else{
            return this.dimLFilasOcupadas;
        }
    }
    private String scrapear(){
        String s = " ";
        for(int i = 0; i < this.dimLColumnasOcupadas+1; i++){
            s+= "ColumnaActual: "+ i+ " \n";
            for(int j = 0; j < this.testigo(i); j++){
                s+= "   filaActual: "+ j+ " \n";
            }
        }
        return s;
    }
    @Override
    public String toString() {
        return scrapear();
    }
    
}
