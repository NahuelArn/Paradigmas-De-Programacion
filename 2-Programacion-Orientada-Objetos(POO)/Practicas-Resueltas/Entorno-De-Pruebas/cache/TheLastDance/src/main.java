/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //    public Estadio(String nombre, String direccion, int capacidad) {

        Estadio  estadio = new Estadio("EstadioUnico","150",40000);
        Concierto concierto;
        for(int i = 0; i < 12; i++){
            for (int j = 0; j < 5; j++){    //solo los 5 primeros dias de cada mes
                //    public Concierto(String nombreDelArtista, double precioEntrada, int cantEntradasVendidas) {

                concierto = new Concierto("nameArtista",100,5);
                estadio.registrarConcierto(concierto, i);
            }
        }
        concierto = new Concierto("nameArtista",100,5);
        estadio.registrarConcierto(concierto, 11);
        System.out.println(estadio.toString());
        System.out.println("gancia: "+ estadio.gananciaDelEstadioEnMes(11));
    }
    
}
