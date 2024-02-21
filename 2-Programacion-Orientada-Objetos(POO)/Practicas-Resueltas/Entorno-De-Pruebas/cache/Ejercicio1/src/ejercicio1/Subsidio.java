/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author nahuelArn
 */
public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean estado; //OTORGADO O NO

    public Subsidio(double montoPedido, String motivo) {
        this.montoPedido = montoPedido;
        this.motivo = motivo;
        this.estado = false;
    }

    public double getMontoPedido() {
        return montoPedido;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
