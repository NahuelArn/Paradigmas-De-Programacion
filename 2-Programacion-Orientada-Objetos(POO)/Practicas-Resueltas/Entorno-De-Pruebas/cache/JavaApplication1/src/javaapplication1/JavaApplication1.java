/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author nahuelArn
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setNumeroIdentidad("123456");
        cliente.setProfesion("Abogado");
        
        CuentaCliente cuenta = new CuentaCliente(555);
        CuentaCliente cuenta2 = new CuentaCliente(33);
        cuenta.setTitular(cliente);
        System.out.println(cuenta.getAgencia());
        System.out.println(cuenta2.getAgencia());
        
        System.out.println(CuentaCliente.getTotal());
    }
    
}
