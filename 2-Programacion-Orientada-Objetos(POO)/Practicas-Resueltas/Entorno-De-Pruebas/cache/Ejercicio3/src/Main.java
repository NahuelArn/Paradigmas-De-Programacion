/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nahuelArn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EventoOcasional ocasionalEvento = new EventoOcasional("tv","federico",2,"chillipepers",4);
        
        UnaGira giraUna = new UnaGira("NombreGira",5,"nombreBanda",6);
        
        //
        ocasionalEvento.agregarUnTema("ocasionalEventoPista1");
        ocasionalEvento.agregarUnTema("ocasionalEventoPista2");
        ocasionalEvento.agregarUnTema("ocasionalEventoPista3");
        //
        giraUna.agregarUnTema("giraUnaPista1");
        giraUna.agregarUnTema("giraUnaPista2");
        giraUna.agregarUnTema("giraUnaPista3");
        Fecha fecha;
        fecha = new Fecha("LaPlata",5);
        giraUna.agregarFecha(fecha);
        fecha = new Fecha("LaPlata",6);
        giraUna.agregarFecha(fecha);
        fecha = new Fecha("LaPlata",7);
        giraUna.agregarFecha(fecha);
        giraUna.actuar();
        System.out.println("costo calculado "+giraUna.calcularCosto());
    }
    
}
