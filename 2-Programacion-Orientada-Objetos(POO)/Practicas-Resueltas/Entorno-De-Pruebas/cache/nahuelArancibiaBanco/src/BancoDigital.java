/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class BancoDigital extends Banco {

    private String direccionWeb;

    public BancoDigital(String direccionWeb, String nombreDeBanco, int cantEmpleados, int dimFbanco) {
        super(nombreDeBanco, cantEmpleados, dimFbanco);
        this.direccionWeb = direccionWeb;
    }

    @Override
    public boolean puedeRecibirTarjeta(String cbu) {
        Cuenta cuenta = this.obtenerCuenta(cbu);
        boolean estado = false;
        if (cuenta != null) {
            if (cuenta.getMonto() > 100000) {
                System.out.println("DOLARESS"+cuenta.getCbu());
                estado = true;
            } 
        }
        return estado;
    }

}
