/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamientos;

/**
 *
 * @author nahuelArn
 */
public class Estacionamiento {

    private String nombre;
    private String direccion;
    private String horaDeApertura;
    private String horaDeCierre;
    private int numPiso;
    private int numPlaza;
    private Auto[][] lugares;

    private void inicializarMatriz() {   //como se van a cargar de forma "random" inicializo mi matriz
        int i, j;
        for (i = 0; i < this.numPiso; i++) {     //donde me desplazo cada tanto
            for (j = 0; j < this.numPlaza; j++) {    //donde itero mas
                this.lugares[i][j] = null;
            }
        }
    }

    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaDeApertura = "8:00";
        this.horaDeCierre = "21:00";
        this.numPiso = 5;
        this.numPlaza = 10;
        lugares = new Auto[this.numPiso][this.numPlaza];    //reservo espacio
        inicializarMatriz();
    }

    public Estacionamiento(String nombre, String direccion, String horaDeApertura, String horaDeCierre, int numPlaza, int numPiso) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaDeApertura = horaDeApertura;
        this.horaDeCierre = horaDeCierre;
        this.numPlaza = numPlaza;
        this.numPiso = numPiso;
        lugares = new Auto[this.numPlaza][this.numPiso];
        inicializarMatriz();
    }

    public void setAuto(int piso, int plaza, Auto auto) {
        lugares[piso - 1][plaza - 1] = auto;
    }

    public String buscarAuto(String patente) {
        boolean sigo = true;
        int i = 0;
        int j = 0;
        while ((i < this.numPiso) && (sigo)) {
            j = 0;
            System.out.println("entra aca ");
            while ((j < this.numPlaza) && (sigo)) {
                System.out.println("entra aca 222");
                if (lugares[i][j] != null) {
                    if (lugares[i][j].getPatente().equals(patente)) {
                        sigo = false;
                    }
                } 
                j++;
            }
            i += 1;
        }
        if (sigo) {
            System.out.println("sarasa1");
            return "auto Inexistente";
        } else {
            System.out.println("sarasa2");
            return "Num Piso:" + i + " Num plaza: " + j;
        }
    }

    private String sacarData() {
        String s = " ";
        for (int i = 0; i < this.numPiso; i++) {
            for (int j = 0; j < this.numPlaza; j++) {
                s += "Plso: " + i + " NumPlaza: " + j + " : ";
                if (lugares[i][j] != null) {
                    s += lugares[i][j].toString() + "\n";
                } else {
                    s += " Libre \n";
                }
            }
        }
        return s;
    }

    @Override
    public String toString() {
        String s = " ";
        s = "Estacionamiento \n";
        return s + sacarData() + "\n";
    }

    public int cantAutosEnDichaPlaza(int plaza) {
        int cont = 0;
        for (int i = 0; i < this.numPiso; i++) {
            if (lugares[i][plaza] != null) {
                cont++;
            }
        }
        return cont;
    }
}
