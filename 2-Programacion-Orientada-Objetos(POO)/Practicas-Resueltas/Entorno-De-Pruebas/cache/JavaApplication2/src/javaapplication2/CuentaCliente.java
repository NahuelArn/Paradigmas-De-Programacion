/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public abstract class CuentaCliente {
    private Cliente titular;
    private Double saldo;
    private int agencia;
    private int numero;
    
    
    //si viene una agencia negativa, se va tomar como la agencia Matriz y se asignar el numero 1
    private static int Total = 0; //esta variable no va ser de la instancia, va a ser de la clase Variable Contadora
    public CuentaCliente(int agencia) {
        
        if(agencia <= 0){
            System.out.println("No se permiten valores negativos");
            this.agencia = 1;
        }else {this.agencia = agencia;}
        saldo = 0.0; // inicializar la variable saldo
        Total++;
        System.out.println("La cantidad de cuentas creadas es: " + Total + " cuentas.");
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }
    
    public void depositar(double monto){
		this.saldo+= monto;
	}
	
    public boolean retirar(double monto) {
        if(this.saldo >= monto) {
			this.saldo-= monto;
			return true;
		}else{ 
                System.out.println("No tiene fondos suficientes.");
		return false; 
		}
    }
	
    public boolean transferir(double monto, CuentaCliente cuenta) {
        if(this.saldo >= monto) {
			this.retirar(monto);
			cuenta.depositar(monto);
			return true;
		}else {
		return false;
	}
    }
    
    public double getsaldoActual(){
       return this.saldo;
    }
    
   public void setAgencia(int nuevaAgencia){
       if(nuevaAgencia > 0){
          this.agencia = nuevaAgencia; 
       }else{System.out.println("Los valores negativos no estan permitidos");
       }     
   }

    public int getAgencia() {
        return agencia;
    }
   
   public void setNumero(int nuevoNumero){
       this.numero = nuevoNumero;
   }

    public int getNumero() {
        return numero;
    }

    public static int getTotal() {
        return Total;
    }
   
}
