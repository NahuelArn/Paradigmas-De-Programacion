/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author nahuelArn
 */
public class Proyecto {
    private String nombreProyecto;
    private String nombreCompletoDirector;
    private int codigo;
    private Investigador investigadores[];
    private int dimL;
    public Proyecto(String nombreProyecto,String nombreCompletoDirector, int codigo) {
        this.nombreProyecto = nombreProyecto;
        this.nombreCompletoDirector = nombreCompletoDirector;
        this.codigo = codigo;
        this.investigadores = new Investigador[50];
        this.dimL = 0;
    }
    public void agregarInvestigador(Investigador investigador){
        if(this.dimL < 50){
            this.investigadores[dimL] = investigador;
            this.dimL++;
        }
    }
    public double dineroTotalOtorgado(){
        double total = 0;
        for (int i=0; i < this.dimL; i++){
            //if(investigadores[i].getDimL() > 0)
            total+= investigadores[i].scrapearSubsidios();
        }
        return total;
    }
    public void otorgarTodos(String nombreBeneficiado){
        int i = 0;
        boolean encontrado = false;
        while((i < this.dimL) && (encontrado != true)){
            if(investigadores[i].getNombreCompleto().equals(nombreBeneficiado)){
                encontrado= true;               
            }
            i++;
        }
        if(encontrado){
            System.out.println("Se encontro al Beneficiario");
        }else{
            System.out.println("No se encontro al beneficiario");
        }
    }
    
    private String sacarData(){
        String s= " ";
        for(int i = 0; i < this.dimL; i++){
            s+= this.investigadores[i].toString() +" \n";
        }
        return s;
    }
    @Override
    public String toString() {
        String s = " ";
        s += "Nombre del proyecto: "+this.nombreProyecto+" nombreCompletoDirector: " + nombreCompletoDirector + ", codigo=" + codigo + " Total otorgado al proyecto"
                + this.dineroTotalOtorgado() + " \n";
        s+= sacarData() + " \n";
        return s;
    }
    
}
