/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

/**
 *
 * @author nahuelarn
 * 
 *  UTILIZAR LA MISMA CLASE PERSONAMAIN DEL EJERCICIO 2,1
 */
public class ejercicio3 {

    /* Responda: 
    ¿Qué imprimen los siguientes programas? 
    //
    
    ¿Qué efecto tiene la asignación utilizada con objetos? 
    se copia la direccion del objeto y pasa ha apuntar a lo mismo y si el anterior objeto no es referenciado por ninguna cosa, entra el garbash collector
    
    ¿Qué efecto tiene la comparación con == y != utilizada con objetos? 
    Compara si apuntan a lo mismo, o si no apuntan a lo mismo
    
    ¿Qué retorna el mensaje equals cuando se le envía a un String?    
    No entiendo la pregunta
     */
 /*
    public static void main(String[] args) {
        String saludo1 = new String("hola");    // crea espacio en memoria dinamica
        String saludo2 = new String("hola");    //crea otra instancia en memoria dinamica
        System.out.println("Pregunta si las 2 variables apuntan a lo mismo: " + (saludo1 == saludo2)); //el comparador de igualdad, pregunta si las 2 direccones son iguales
        System.out.println("Tendria que dar true, ya que no apuntan a lo mismo las variables: " + (saludo1 != saludo2)); //pregunta si las direcciones son diferentes

        System.out.println("Chequea si el contenido de los 2 objetos son iguales: " + (saludo1.equals(saludo2)));    //equals compara el contendido en este caso daria true

    }
     */


    public static void main(String[] args) {
        personaMain p1;
        personaMain p2;
        p1 = new personaMain();  //crea una instancia en mem para persona 1
        p1.setNombre("Pablo Sotile"); // | 
        p1.setDni(11200413);            // |  carga la data de la persona 1
        p1.setEdad(40);                //  |
        p2 = new personaMain(); // //crea una instancia en mem para persona 2
        p2.setNombre("Julio Toledo"); //  |
        p2.setDni(22433516);            //  |   carga la data de persona 2
        p2.setEdad(51);                //   |     
        
        p1 = p2;    //p1 pasa apuntar tambien a la persona 2
        p1.setEdad(p1.getEdad() + 1);   //aumenta en la persona 2, su misma edad +1   // error en este punto como p1, no estaba siendo utilizado entro el garbash collector y libero p1
        System.out.println(p2.toString());  //obtiene la data de p2
        System.out.println(p1.toString());  //obtiene la data de p2
        System.out.println((p1 == p2));     //daria true porque ambos apuntan a lo mismo 
        
    }
}
