/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2concursocanciones;

/**
 *
 * @author nahuelarn
 */
public class Concurso {

    private int cantCategorias;
    private int cantMaxCancionesXcategoria;
    private Cancion matriz[][];

    private int vectorDimL[];

    //contructor
    private void inicializarMatriz() {
        for (int i = 0; i < cantCategorias; i++) { //columnas
            for (int j = 0; j < cantMaxCancionesXcategoria; j++) {
                matriz[j][i] = null;
            }
        }
    }

    private void inicializarVector() {
        vectorDimL = new int [cantCategorias];
        for (int i = 0; i < cantCategorias; i++) {
            vectorDimL[i] = 0;
        }
    }

    public Concurso(int cantCategorias, int cantMaxCancionesXcategoria) {
        this.cantCategorias = cantCategorias;
        this.cantMaxCancionesXcategoria = cantMaxCancionesXcategoria;

        matriz = new Cancion[cantMaxCancionesXcategoria][cantCategorias];
        inicializarMatriz();
        inicializarVector();

    }

    //setters ang getters
    public void agregarUnaCancion(Cancion cancion, int posCategoria) {
        matriz[vectorDimL[posCategoria]][posCategoria] = cancion;   //escenario ideal me dice el ENUNCIADO
        vectorDimL[posCategoria] += 1;
    }

    //buscar Cancion por id, encuentro chequeo el puntaje, si el nuevo puntaje es > lo actualizo y actualizo al alumno
    public void interpretarCancion(int id, Estudiante estudiante, double puntajeOtorgado) {
        int i = 0;
        int j = 0;
        boolean prosiga = false;
        while ((i < cantCategorias) && (prosiga = false)) { //columnas
            while ((j < cantMaxCancionesXcategoria) && (prosiga = false)) { //filas
                if (this.matriz[j][i].getNumIdentificacion() == id) {
                    prosiga = true;
                } else {
                    i++;
                }

            }
        }
        if (prosiga) {
            if (puntajeOtorgado > this.matriz[j][i].getPuntajeOtorgado()) {
                this.matriz[j][i].setEstudiante(estudiante);
                this.matriz[j][i].setPuntajeOtorgado(puntajeOtorgado);
            }
        } else {
            System.out.println("Saracatunga");
        }
    }

    //busco por id la cancion, si no es != null devuelvo al estudiante contendido de esa cancion
    public Estudiante conocerEstudianteGanador(int idBuscado) {
        //reutilizo el codigo
        int i = 0;
        int j = 0;
        boolean prosiga = false;
        while ((i < cantCategorias) && (prosiga = false)) { //columnas
            while ((j < cantMaxCancionesXcategoria) && (prosiga = false)) { //filas
                if (this.matriz[j][i].getNumIdentificacion() == idBuscado) {
                    prosiga = true;
                } else {
                    i++;
                }

            }
        }
        if (prosiga) {
            return this.matriz[j][i].getEstudiante();
        } else {
            return null;
        }
    }

    //me paro en la categoria, y empiezo a sacar un maximo de puntaje
    public Cancion conocerCancionTop(int posCategoria) {
        double maxPuntaje = -999;
        Cancion cancionTop = null;

        if (posCategoria < cantCategorias) {
            for (int i = 0; i < vectorDimL[posCategoria]; i++) {
                if (this.matriz[i][posCategoria].getPuntajeOtorgado() > maxPuntaje) {
                    maxPuntaje = this.matriz[i][posCategoria].getPuntajeOtorgado();
                    cancionTop = this.matriz[i][posCategoria];
                }
            }

        }
        return cancionTop;
//        double maxPuntaje = -999; Cancion cancionTop = null;
//        for (int i = 0; i < vectorDimL[posCategoria]; i++){
//            if(this.matriz[i][posCategoria].getPuntajeOtorgado() > maxPuntaje){
//                maxPuntaje = this.matriz[i][posCategoria].getPuntajeOtorgado();
//                cancionTop = this.matriz[i][posCategoria];
//            }
//        }
//        return cancionTop;
    }
}
