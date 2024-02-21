/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public abstract class Funcionario {
    private String nombre;
    private int documento;
    private double salario;
    private int tipo;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    //bonificacion del 10%
    public abstract double getBonificacion();//{
//      return this.salario = this.salario+(this.salario*= 0.10);
//        return this.salario *= 0.10;
//    }
    
//    public double getBonificacionAll(){
//      if (this.tipo == 1){
//        return this.salario = this.salario+(this.salario*2);
//      }else if(this.tipo == 2){
//        return this.salario = this.salario+(this.salario*= 0.10);
//      }else return 0;
//    }
    public double getBonificacionAll(){
        return this.salario = this.salario+(this.salario*= 0.10);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }  

}
