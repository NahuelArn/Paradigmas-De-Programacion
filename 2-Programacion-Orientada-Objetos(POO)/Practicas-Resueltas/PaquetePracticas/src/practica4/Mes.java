/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

/**
 *
 * @author nahuelarn
 */
public class Mes extends Estacion{
    
    public Mes(int dimFAnho){
        super(dimFAnho);
    }
    @Override
    public String promedio(){
        double aux = 0;
        String n = " ";
//        for (int i = super.getDesdeANho(); i < this.getDimFAnho(); i++)
        for (int j = 0; j < 12; j++){
            for (int i = super.getDesdeANho(); i < this.getDimFAnho(); i++){
                aux += super.getTemperaturas()[j][i];
            }
            n += "\n " + (aux/12);
        }
        return n;
    }
}
