/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 * 
 * 4- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en 
cada día se entrevistarán a 8 personas en distinto turno. 
a)  Simular  el  proceso  de  inscripción  de  personas  al  casting.  
* A  cada  persona  se  le  pide nombre,  DNI  y  edad  y  se  la  debe  asignar  
* en  un  día  y  turno  de  la  siguiente  manera:  las personas primero completan el primer día en turnos sucesivos, luego el segundo día y así 
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de casting. Una vez finalizada la inscripción:  
* 
b) Informar para cada día y turno el nombre de la persona a entrevistar. NOTA: utilizar la clase Persona y pensar en la estructura de datos a utilizar.  
* 
 */

/*
intro: matriz de 5 columnas x 8 filas, Pueden no cargarse todas las columnas... 5 = dias, 8 turnos (en cada turno se puede entrevistar a una sola persona)
A: La inscripcion se hace en turnos sucesivos, entonces de cada turno 
B: informar x cada dia x turno el nombre de la persona
*/
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
public class ejercicio4 {
    
    public static void main(String[] arg){
        int dia = 5;
        int turno = 1;
        personaMain [][]casting = new personaMain[turno][dia];
        
        //inicializarMatriz
        for (int i =0; i < dia; i++){
            for (int j = 0; j < turno; j++){
                casting[j][i] = null;
            }
        } 
        
        //declaracion de aux(Candidato) para instanciarlo N veces
        personaMain candidato;
        int i = 0; int j = 0;
        System.out.println("Estas en el dia: "+(i+1));
        System.out.println("Nombre: ");
        String nombre = Lector.leerString();
        
        while((!nombre.equals("zzz")) && (i < dia)){
             j = 0; 
            while (j < turno){
                candidato = new personaMain(); //creo el objeto para ese candidato
                System.out.println("dni: ");
                int dni = Lector.leerInt();
                System.out.println("edad: ");
                int edad = Lector.leerInt();
                candidato.setGuardarSusDatos(nombre,dni,edad);
                casting[j][i] = candidato;
                System.out.println(""); System.out.println("Nombre: ");
                nombre = Lector.leerString();
                j++;
            }
            i++;
            System.out.println("Estas en el dia: "+(i+1));
        }
        //punto B
        
        //i = 0; j=0;
         int r = 0; // i
         int k=0; // j
         //while((casting[j][i] != null) && (i < dia)){    //en este caso si me sirve el != PREGUNTO SI LA DIRECCION ES DISTINTA DE NULL
         while((r < dia) && (casting[k][r] != null)){ 
            //k = 0;
            while(k < turno){
                System.out.println("Dia: "+(r+1)+" Turno: "+(r+1)+" el nombre del candidato: "+casting[k][r].getNombre());
                k++;
            }
            r++; k = 0;
        }
    }
}
