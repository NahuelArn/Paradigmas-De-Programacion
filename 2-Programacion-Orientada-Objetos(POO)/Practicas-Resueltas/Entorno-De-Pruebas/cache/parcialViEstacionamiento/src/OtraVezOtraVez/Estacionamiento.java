/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OtraVezOtraVez;

/**
 *
 * @author nahuelArn
 */
public class Estacionamiento {

    private String direccion;
    private double costoPorHora;
    private Auto matriz[][];

    private int cantSectores;
    private int cantAutosXsector;
    private int vectorDiml[];
    private int dimLCantSectores;

    public void inicializarVector() {
        for (int i = 0; i < this.cantSectores; i++) {
            this.vectorDiml[i] = 0;
        }
    }

    public Estacionamiento(String direccion, double costoPorHora, int cantSectores, int cantAutosXsector) {
        this.direccion = direccion;
        this.costoPorHora = costoPorHora;
        this.matriz = new Auto[cantAutosXsector][cantSectores];
        this.cantAutosXsector = cantAutosXsector;
        this.cantSectores = cantSectores;
        this.vectorDiml = new int[this.cantSectores];
        inicializarVector();
    }

    public void agregarVehiculo(Auto auto) {
        if ((this.dimLCantSectores < this.cantSectores) && (this.vectorDiml[this.dimLCantSectores] < this.cantAutosXsector)) {
            matriz[this.vectorDiml[this.dimLCantSectores]][dimLCantSectores] = auto;
            this.vectorDiml[this.dimLCantSectores]++;
        } else {
            this.dimLCantSectores++;
            if (this.dimLCantSectores < this.cantSectores) {
                matriz[this.vectorDiml[this.dimLCantSectores]][dimLCantSectores] = auto;
                this.vectorDiml[this.dimLCantSectores]++;
            } else {
                System.out.println("Matriz llena");
            }
        }
    }

    public String listarVehiculos(String marca, int sectorX) {
        String s = " ";
        if (sectorX < this.dimLCantSectores) {    //le paso sectores de 0 a n validos
            for (int i = 0; i < this.vectorDiml[sectorX]; i++) {
                if (this.matriz[i][sectorX].getMarca().equals(marca)) {
                    s += " " + this.matriz[i][sectorX].toString() + " \n";
                }
            }
        }
        return s;
    }

    public int puntoC(String marca) {
        int cont = 0;
        int min = 999;
        int sectorMin = -1;
        for (int i = 0; i < this.dimLCantSectores; i++) {
            for (int j = 0; j < this.vectorDiml[this.dimLCantSectores]; j++) {
                if (this.matriz[j][i].getMarca().equals(marca)) {
                    cont++;
                }
            }
            if (cont < min) {
                min = cont;
                sectorMin = i;
            }
            cont = 0;
        }
        return sectorMin;
    }

    private String scrapear() {
        String s = " ";
        if ((this.dimLCantSectores == 0) && (this.vectorDiml[0] > 0)) {
            s += " \n Sector: " + 0 + " \n";
            for (int i = 0; i < this.vectorDiml[0]; i++) {
                s += "   Lugar: " + i + " " + this.matriz[i][0].toString() + " \n";
            }
        } else {
            for (int i = 0; i < this.dimLCantSectores + 1; i++) {
                s += " \n Sector: " + i + " \n";
                for (int j = 0; j < this.vectorDiml[i]; j++) {
                    s += "   Lugar: " + j + " " + this.matriz[j][i].toString() + " \n";
                }
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return "Estacionamiento{" + "direccion=" + direccion + ", costoPorHora=" + costoPorHora + ", dimLCantSectores=" + dimLCantSectores + scrapear();
    }

}
