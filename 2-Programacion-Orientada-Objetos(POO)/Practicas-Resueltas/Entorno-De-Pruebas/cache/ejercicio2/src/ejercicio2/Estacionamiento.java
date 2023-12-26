/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author nahuelArn
 */
public class Estacionamiento {

    private String nombre;
    private String direccion;
    private String horaDeApertura;
    private String horaDeCierre;
    private Auto[][] lugarDeMatriz;

    private int cantPlazas;
    private int cantPisos;

    private void inicializarMatriz() {   //pisos
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {   //plazas
                this.lugarDeMatriz[i][j] = null;
            }
        }
    }

    private void setDimensiones(int x, int y) {
        this.cantPlazas = x;
        this.cantPisos = y;
    }

    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaDeApertura = "8:00";
        this.horaDeCierre = "21:00";
        this.lugarDeMatriz = new Auto[5][10];   //filas columnas
        setDimensiones(10, 5);
        inicializarMatriz();
    }

    public Estacionamiento(String nombre, String direccion, String horaDeApertura, String horaDeCierre, int n, int m) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaDeApertura = horaDeApertura;
        this.horaDeCierre = horaDeCierre;
        this.lugarDeMatriz = new Auto[n][m];
        setDimensiones(m, n);
        inicializarMatriz();
    }

    public void registrarAuto(Auto auto, int x, int y) {
        this.lugarDeMatriz[y][x] = auto;    //escenario ideal, no validacion de = null y rangos correctos x, y
    }

    public String buscarAuto(String patente) {
        boolean sigo = true;
        int i = 0;
        int j = 0;
        while ((i < this.cantPlazas) && (sigo)) {
            j = 0;
            while ((j < this.cantPlazas) && (sigo)) {
                if (lugarDeMatriz[i][j] != null) {
                    if (lugarDeMatriz[i][j].getPatente().equals(patente)) {
                        sigo = false;
                    }
                }
                if (sigo) {
                    j++;
                }
            }
            if (sigo) {
                i++;
            }
        }
        if (!sigo) {
            return "El auto de patente: " + patente + " esta en la plaza: " + j + " piso: " + i;
        } else {
            return "Auto inexistente";
        }
    }
    private String scrapearMatriz(){
        String s = " ";
        for (int i = 0; i < this.cantPisos; i++){
            for (int j=0; j < this.cantPlazas; j++){
                s+= " Piso: "+i+" Plaza: "+j+ " ";
                if(this.lugarDeMatriz[i][j] == null){
                    s+= " Libre";
                }else{
                    s+=  this.lugarDeMatriz[i][j].toString() + " \n";
                }
            }
        }
        return s;
    }
    @Override
    public String toString() {
        return "Estacionamiento: " + scrapearMatriz();
    }
    public int cantAutosUbicadosEnPlaza(int plaza){
        int cant = 0;
        for(int i = 0; i < this.cantPisos; i++){
            if(this.lugarDeMatriz[i][plaza] != null){
                cant++;
            }
        }
        return cant;
    }
}
