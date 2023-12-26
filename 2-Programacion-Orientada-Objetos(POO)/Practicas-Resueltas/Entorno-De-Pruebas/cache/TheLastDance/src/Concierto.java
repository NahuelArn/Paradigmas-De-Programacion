/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Concierto {
    private String nombreDelArtista;
    private double precioEntrada;
    private int cantEntradasVendidas;

    public Concierto(String nombreDelArtista, double precioEntrada, int cantEntradasVendidas) {
        this.nombreDelArtista = nombreDelArtista;
        this.precioEntrada = precioEntrada;
        this.cantEntradasVendidas = cantEntradasVendidas;
    }


    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public int getCantEntradasVendidas() {
        return cantEntradasVendidas;
    }
    
    @Override
    public String toString() {
        return "NombreDelArtista: "+ this.nombreDelArtista+ " precio de la entrada: "+ this.precioEntrada+ " cantidad de entradas vendidas: "+ this.cantEntradasVendidas+ " \n";
    }
    
}
