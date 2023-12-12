/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class PorMayor extends Compra {
    private String cuil;
    private String nombre;

    public PorMayor(String cuil, String nombre, int numero, Fecha fecha) {
        super(numero, fecha);
        this.cuil = cuil;
        this.nombre = nombre;
    }
    @Override
    public double precioFinal(){
        double total;
        double iva;
        total = super.precioFinal();
        iva = total * 0.21;
        total -= iva;
        return total;
    }
    @Override
    public void agregarUnProductoAlaCompra(Producto producto){
        if(producto.getCantUnidades() > 6){
            super.agregarUnProductoAlaCompra(producto); //lock up
        }else{
            System.out.println("Esta compra por mayor no alcanzo el limite minimo");
        }
    }
     
}
