/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author nahuelArn
 */
public class Gerente extends Funcionario implements Autenticable{
      private String clave;

      @Override
      public void setClave (String clave){
          this.clave = clave;
      }
      @Override
      public boolean iniciarSesion(String clave){
          return "Alura".equals(this.clave);
      }
      
    /**
     * @return
     */
    @Override //le indico al compilador que estoy usando un metodo del padre
    //bonificacion de *2 del salario y un 10% de un funcionario
      public double getBonificacion(){
//        return 2 * super.getSalario();
//        return super.getSalario() + super.getSalario()* 0.1;
          return 2* super.getSalario() + + super.getSalario()* 0.1;
      }
}
