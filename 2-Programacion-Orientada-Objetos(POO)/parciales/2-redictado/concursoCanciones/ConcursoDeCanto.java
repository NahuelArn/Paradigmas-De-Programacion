/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author nahuelarn
 */
public class ConcursoDeCanto {

    private int cantCategorias;
    private int cantMaxPorCategoria;
    private Cancion matriz[][];

    private int vectorDimL[];

    //constructor
    private void inicializarMatriz() {
        for (int i = 0; i < cantCategorias; i++) {
            for (int j = 0; j < cantMaxPorCategoria; j++) {
                matriz[j][i] = null;
            }
        }
    }

    private void inicializarVector() {
        vectorDimL = new int[cantCategorias];
        for (int k = 0; k < cantCategorias; k++) {
            vectorDimL[k] = 0;
        }
    }

    public ConcursoDeCanto(int cantCategorias, int cantMaxPorCategoria) {
        this.cantCategorias = cantCategorias;
        this.cantMaxPorCategoria = cantMaxPorCategoria;

        this.matriz = new Cancion[cantMaxPorCategoria][cantCategorias];
        inicializarMatriz();
        inicializarVector();
    }

    //setters and getters
    public void agregarUnaNuevaCancionAlConcurso(Cancion cancion, int posCategoria) {    //escenario ideal, no hace falta controlar q este ok la pos, ni chequear las dimLs/DimfS
        matriz[vectorDimL[posCategoria]][posCategoria] = cancion;
        vectorDimL[posCategoria] += 1;
    }

//    private boolean buscar(int codIdentificador){
//        int i = 0; int j = 0; boolean encontro = false;
//        while((i < cantCategorias) && (!encontro)){
//            while((j < vectorDimL[i]) && (!encontro)) {
//                j++;
//            }
//            i++;
//        }
//        
//    }
    public void interPretarCancion(int codIdentificador, Estudiante estudiante, double puntajeOtorgado) {
        int i = 0;
        int j = 0;
        boolean encontro = false;
        while ((i < cantCategorias) && (!encontro)) {
            while ((j < vectorDimL[i]) && (!encontro)) {
                if (codIdentificador == matriz[i][j].getCodIdentificador()) {
                    encontro = true;
                }
                j++;
            }
            i++;
        }
        if (encontro) {
            if (puntajeOtorgado > matriz[i][j].getPuntaje()) {
                matriz[i][j].setPuntaje(puntajeOtorgado);
                matriz[i][j].setEstudiante(estudiante);
            }
        }
    }

//    public Estudiante conocerEstudianteGanador(int codIdentificacionBuscado) {
      private Estudiante conocerEstudianteGanador(int codIdentificacionBuscado) { //lo cambie a private para solo usarlo en el caso q me dan

        int i = 0;
        int j = 0;
        boolean encontro = false;
        while ((i < cantCategorias) && (!encontro)) {
            while ((j < vectorDimL[i]) && (!encontro)) {
                if (codIdentificacionBuscado == matriz[i][j].getCodIdentificador()) {
                    encontro = true;
                }
                j++;
            }
            i++;
        }
        if (encontro) {
            return matriz[i][j].getEstudiante();
        } else {
            return null;
        }

    }
    
    public String conocerDelMain3erSubPunto(int codIdentificacionBuscado){
        Estudiante estudiante;
        
        estudiante = conocerEstudianteGanador(codIdentificacionBuscado);
        if(estudiante == null){
            return "nadie";
            
        }else {
            return estudiante.toString();
        }
    }
    
//    public Cancion conocerCancionConMejorPuntaje(int cantegoriaX) {
        private Cancion conocerCancionConMejorPuntaje(int cantegoriaX) { //privado por para usarlo solo con lo q me piden

        int j = 0;
        double max = -999;
        Cancion cancionMax = null;
        while (j < vectorDimL[cantegoriaX]) {
            if (matriz[j][cantegoriaX].getPuntaje() > max) {
                max = matriz[j][cantegoriaX].getPuntaje();
                cancionMax = matriz[j][cantegoriaX];
            }
            j++;
        }
        return cancionMax;

    }
        
    public String ultimoPunto(){
        Cancion cancionMax;
        String concateno =  " ";
        for (int i = 0; i < 5; i++){
            cancionMax = conocerCancionConMejorPuntaje(i);
            
            if(cancionMax != null){
                concateno += cancionMax.toString() +" \n";
            }
        }
        return concateno;
    }
}
