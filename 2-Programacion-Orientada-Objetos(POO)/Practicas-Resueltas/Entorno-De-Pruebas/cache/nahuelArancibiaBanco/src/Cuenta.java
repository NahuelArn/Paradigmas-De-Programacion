/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Cuenta {
    private String cbu;
    private String alias;
    private String dniTitular;
    private String moneda;
    private double monto;

    public Cuenta(String cbu, String alias, String dniTitular, String moneda) { //moneta = dolares, pesos
        this.cbu = cbu;
        this.alias = alias;
        this.dniTitular = dniTitular;
        this.moneda = moneda;
        this.monto = 0;
    }

    public String getCbu() {
        return cbu;
    }
    public void setMonto(double monto){
        this.monto += monto;
    }

    public double getMonto() {
        return monto;
    }

    public String getMoneda() {
        return moneda;
    }
    
    
}
