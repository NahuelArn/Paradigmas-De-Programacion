/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package subsidios;

/**
 *
 * @author nahuelarn
 */
public class subsidios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //estadia
        System.out.println("Lugar Destino ");
        String lugarDestino = "estadiaLugar";
        System.out.println("costoPasaje: ");
        double costoPasaje = 100;
        System.out.println(" cantidadDeDiasEstadia: ");
        int cantidadDeDiasEstadia = 4;
        System.out.println(" montoTotalXdia: ");
        double montoTotalXdia = 300;
        System.out.println("Nombre: ");
        String nombre = " feranzoAlnzo";
        System.out.println(" nombreDePlanDeTrabajo: ");
        String nombreDePlanDeTrabajo = "nose1ss";
        System.out.println("fechaDeSolicitud: ");
        int fechaDeSolicitud = 23;
        
        Estadia estadia = new Estadia(lugarDestino,costoPasaje,cantidadDeDiasEstadia,montoTotalXdia,nombre,nombreDePlanDeTrabajo,fechaDeSolicitud);
        System.out.println(estadia.toString());
        
        //bienes
        
         
        System.out.println("Nombre: ");
        nombre = " feranzoAlnzo";
        System.out.println(" nombreDePlanDeTrabajo: ");
        nombreDePlanDeTrabajo = "nose1ss";
        System.out.println("fechaDeSolicitud: ");
        fechaDeSolicitud = 23;
        
        Bienes bienes = new Bienes(5,nombre,nombreDePlanDeTrabajo,fechaDeSolicitud);
        
        System.out.println("descripcion: ");
        nombre = " feranzoAlnzo";
        System.out.println("cantidad: ");
        int cantidad = 23;
        System.out.println("costoXunidad: ");
        double costoXunidad = 23;
        Bien bien = new Bien(nombre,cantidad,costoXunidad);
        bienes.agregarBien(bien);
        System.out.println("bien: "+ bien.toString());
    }
    
}
