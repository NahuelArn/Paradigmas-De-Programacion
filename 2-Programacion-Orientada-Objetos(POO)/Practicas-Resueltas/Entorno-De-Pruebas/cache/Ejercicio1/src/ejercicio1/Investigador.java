/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author nahuelArn
 */
public class Investigador {
    private String nombreCompleto;
    private int categoria;
    private String especialidad;
    private Subsidio subsidios[];
    private int dimL;
    public Investigador(String nombreCompleto, int categoria, String especialidad) {
        this.nombreCompleto = nombreCompleto;
        this.categoria = categoria;
        this.especialidad = especialidad;
        this.subsidios = new Subsidio[5];
        this.dimL =0;
        
    }
    
    public void agregarSubsidio(Subsidio subsidio){
        if(this.dimL < 5){
            this.subsidios[this.dimL] = subsidio;
            this.dimL++;
        }
    }
    public int getDimL() {
        return dimL;
    }
    public double scrapearSubsidios(){
        double total = 0;
        if(this.dimL > 0){
            for(int i=0; i < this.dimL; i++){
                if(this.subsidios[i].getEstado()){
                    total+= this.subsidios[i].getMontoPedido();
                }
            }
        }
        return total;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void otorgarTodosLosBeneficios(){
        for(int i = 0; i < this.dimL; i++){
            subsidios[i].setEstado(true);
        }
    }
    
    @Override
    public String toString() {
        return "Investigador{" + "nombreCompleto=" + nombreCompleto + ", categoria=" + categoria + ", especialidad=" + especialidad + " totalOtorgadoEnSubsidios"+scrapearSubsidios();
    }
    
}
