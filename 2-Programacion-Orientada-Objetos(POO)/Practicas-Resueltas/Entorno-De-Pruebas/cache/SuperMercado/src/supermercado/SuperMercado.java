/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercado;

/**
 *
 * @author nahuelArn
 */
public class SuperMercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Compra minorista--------------------------------
        System.out.println("Ingrese el dia");
        System.out.println("Ingrese el mes");
        System.out.println("Ingrese el anho");
        Fecha fecha = new Fecha(4,1,2023);
        System.out.println("Ingrese el numero de compra");
        Compra compra = new Compra(1,fecha);    
        //Compra Carga--------------------------------
        Producto producto;
        for(int i = 0; i < 6; i++){
            producto = new Producto(22,"descripcion",1000,3);
            compra.agregarUnProductoAlaCompra(producto);
        }
        System.out.println("Precio final "+compra.precioFinal());    //7 productos cargados
        System.out.println("Es abonable? "+ compra.puedeSerAbonable());
        //Compra mayorista--------------------------------
        System.out.println("Ingrese el dia");
        System.out.println("Ingrese el mes");
        System.out.println("Ingrese el anho");
        fecha = new Fecha(4,1,2023);
        System.out.println("Ingrese el cuil");
        System.out.println("Ingrese el nombre");
        PorMayor compraMayorista = new PorMayor("202425","Fernadez",2,fecha);
        //Compra Carga--------------------------------
        for(int i = 0; i < 6; i++){ //estas 6 compras deberian ser rechazadas por ser < 3
            producto = new Producto(22,"descripcion",1000,3);
            compraMayorista.agregarUnProductoAlaCompra(producto);
        }
        producto = new Producto(22,"descripcion",1000,7);
        compraMayorista.agregarUnProductoAlaCompra(producto);
        System.out.println("Precio final "+compraMayorista.precioFinal());    //1 producto cargado
        System.out.println("Es abonable? "+ compraMayorista.puedeSerAbonable());
    }
    
}
