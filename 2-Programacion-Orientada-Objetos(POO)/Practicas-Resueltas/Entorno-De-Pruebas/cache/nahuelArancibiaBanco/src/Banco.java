/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public abstract class Banco {
    private String nombreDeBanco;
    private int cantEmpleados;
    private Cuenta vector[];
    
    private int dimFbanco;
    private int dimL;
    public Banco(String nombreDeBanco, int cantEmpleados, int dimFbanco) {
        this.nombreDeBanco = nombreDeBanco;
        this.cantEmpleados = cantEmpleados;
        this.vector = new Cuenta[dimFbanco]; 
        this.dimFbanco = dimFbanco;
        this.dimL = 0;
    }
    public boolean agregarCuenta(Cuenta cuenta){
        if(this.dimL < this.dimFbanco){
            this.vector[this.dimL] = cuenta;
            this.dimL++;
            return true;
        }else
            return false;
    }   
    public Cuenta obtenerCuenta(String cbu){
        boolean sigo = true;
        Cuenta cuentaBuscada = null;
        int i = 0; 
        while((i < this.dimL) && (sigo)){
            if(vector[i].getCbu().equals(cbu)){
                sigo = false;
                cuentaBuscada = vector[i];
            }else{
                i++;
            }
        }
        if(cuentaBuscada == null){
            System.out.println("No encontraste la cuenta buscada");
        }
        return cuentaBuscada;
    }
    public void depositarDinero(String cbu, double monto){
        Cuenta cuentaBuscada = obtenerCuenta(cbu);
        if(cuentaBuscada != null){
            cuentaBuscada.setMonto(monto);
        }else{
            System.out.println("No se pudo depositar el monto, cuenta no encontrada!");
        }
    }
    public abstract boolean puedeRecibirTarjeta(String cbu);
}
