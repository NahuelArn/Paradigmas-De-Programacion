/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

/**
 *
 * @author nahuelArn
 */
public class Compra {
    private int numero;
    private Fecha fecha;
    private Producto productos[];
    private int dimL;
    public Compra(int numero, Fecha fecha) {
        this.numero = numero;
        this.fecha = fecha;
        this.productos = new Producto[10];
        this.dimL = 0;
    }
    public void agregarUnProductoAlaCompra(Producto producto){
        if(this.dimL < 10){
            this.productos[dimL] = producto;
            this.dimL++;
        }else{
            System.out.println("Limite de compras alcanzado");
        }
    }
    public double precioFinal(){
        double total = 0;
        for(int i = 0; i < this.dimL; i++){
            total += this.productos[i].getCantUnidades() * this.productos[i].getPrecioUnitario();
        }
        return total;
    }
    private String listaDeProductos(){
        String s = " ";
        for (int i = 0; i < this.dimL; i++){
            s += productos[i].toString()+ " \n";
        }
        return s;
    }
    public boolean puedeSerAbonable(){
        return precioFinal() > 100000;
    }
    @Override
    public String toString() {
        return "Numero de compra: "+numero+" fecha: " +fecha.toString()+ "\n"+" productos: "+ listaDeProductos();
    }
    
}
