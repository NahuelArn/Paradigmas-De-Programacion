/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class CuentaCorriente extends CuentaCliente {
    public CuentaCorriente(int agencia){
        super(agencia);
    }

    @Override
    public boolean retirar(double monto) {
        double comision = 0.2;
        return super.retirar(monto + comision); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
