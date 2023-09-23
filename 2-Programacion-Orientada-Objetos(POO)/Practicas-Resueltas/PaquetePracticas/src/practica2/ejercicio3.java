/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

/**
 *
 * @author nahuelarn
 */
public class ejercicio3 {

    /* Responda: ¿Qué imprimen los siguientes programas? ¿Qué efecto tiene la asignación utilizada con objetos? 
    ¿Qué efecto tiene la comparación con == y != utilizada con objetos? 
    ¿Qué retorna el mensaje equals cuando se le envía a un String?    

     */

    public class Ej03QueImprimeA {

        public static void main(String[] args) {
            String saludo1 = new String("hola");    // crea espacio en memoria dinamica
            String saludo2 = new String("hola");    //crea otra instancia en memoria dinamica
            System.out.println(saludo1 == saludo2); //el comparador de igualdad, pregunta si las 2 direccones son iguales
            System.out.println(saludo1 != saludo2); //pregunta si las direcciones son diferentes
            System.out.println(saludo1.equals(saludo2));    //equals compara el contendido en este caso daria true
        }
    }

    public class Ej03QueImprimeB {

        public static void main(String[] args) {
            Persona p1;
            Persona p2;
            p1 = new Persona();  //crea una instancia en mem para persona 1
            p1.setNombre("Pablo Sotile");
            p1.setDNI(11200413);
            p1.setEdad(40);
            p2 = new Persona();
            p2.setNombre("Julio Toledo"); //crea una instancia en mem para persona 1
            p2.setDNI(22433516);
            p2.setEdad(51);
            p1 = p2;    //p1 pasa apuntar tambien a la persona 2
            p1.setEdad(p1.getEdad() + 1);   //aumenta en la persona 2   // error en este punto como p1, no estaba siendo utilizado entro el garbash collector y libero p1
            System.out.println(p2.toString());  //obtiene la data de p2
            System.out.println(p1.toString());  //obtiene la data de p2
            System.out.println((p1 == p2));     //daria true porque ambos apuntan a lo mismo
        }
    }

}
