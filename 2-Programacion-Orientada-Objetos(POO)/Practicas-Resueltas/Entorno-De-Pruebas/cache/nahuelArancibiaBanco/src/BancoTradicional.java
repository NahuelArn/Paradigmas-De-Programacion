/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class BancoTradicional extends  Banco{
    private String direccion;
    private String localidad;
    private int cantCuentasEnDolaresAbiertas;

    public BancoTradicional(String direccion, String localidad, String nombreDeBanco, int cantEmpleados, int dimFbanco) {
        super(nombreDeBanco, cantEmpleados, dimFbanco);
        this.direccion = direccion;
        this.localidad = localidad;
        this.cantCuentasEnDolaresAbiertas = 0;
    }
    @Override
    public boolean agregarCuenta(Cuenta cuenta){
        boolean estado = false;
        if(this.cantCuentasEnDolaresAbiertas <= 100){
            estado = super.agregarCuenta(cuenta);
            this.cantCuentasEnDolaresAbiertas++;
        }
        return estado;
    }
    @Override
    public  boolean puedeRecibirTarjeta(String cbu){
        Cuenta cuenta = this.obtenerCuenta(cbu);
        boolean puede = false;
        if(cuenta.getMoneda().equals("Pesos") && (cuenta.getMonto() > 70000)){
            puede = true;
        }else{
            if(cuenta.getMoneda().equals("Dolares") && (cuenta.getMonto() > 500)){
                puede = true;
            }
        }
        return puede;
    }
}
