/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5EjeAdic;

/**
 *
 * @author nahuelArn
 */
public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean estado; //otorgado o no
    
    //constructores  / Sobrecarga
    public Subsidio(){ //Un subsidio siempre se crea en estado no-otorgado.
        estado = false;
    }
    
    public Subsidio(double montoPedido, String motivo){
        this.montoPedido = montoPedido;
//        System.out.println("MOBTOO PEDIDOOOO "+ this.montoPedido );
        this.motivo = motivo;
        this.estado = true; //si se instancia usando este constructor se tuvo q otorgar el subsidio
    }
    //getters ands setters

    public double getMontoPedido() {
        return montoPedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean getEstado() {
        return estado;
    }
       
}
