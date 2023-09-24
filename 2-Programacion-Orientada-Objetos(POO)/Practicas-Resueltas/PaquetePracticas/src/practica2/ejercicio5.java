/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

/**
 *
 * @author nahuelArn
 */

/*
5-    Se  dispone  de  la  clase  Partido  (en  la carpeta  tema2). 
Un  objeto  partido  representa  un encuentro  entre  dos  equipos  (local  y  visitante).  
Un  objeto  partido  puede  crearse  sin valores  iniciales  o  enviando  en  el  mensaje  de  creación  el  nombre  del  equipo  local,  
el nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto partido sabe responder a los siguientes mensajes: 

getLocal()                                      retorna el nombre (String) del equipo local 
getVisitante()                                  retorna el nombre (String) del equipo visitante 
getGolesLocal()                                 retorna la cantidad de goles (int) del equipo local 
getGolesVisitante()                             retorna la cantidad de goles (int) del equipo visitante 
setLocal(X)                                     modifica el nombre del equipo local al “String” X 
setVisitante(X)                                 modifica el nombre del equipo visitante al “String” X 
setGolesLocal(X)                                modifica la cantidad de goles del equipo local al “int” X 
setGolesVisitante(X)                            modifica la cantidad de goles del equipo visitante al “int” X 
hayGanador()                                    retorna un boolean que indica si hubo (true) o no hubo (false) ganador 
getGanador()                                    retorna el nombre (String) del ganador del partido (si no hubo retorna un String vacío). 
hayEmpate()                                     retorna un boolean que indica si hubo (true) o no hubo (false) empate 
 

Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el campeonato. 
La información de cada partido se lee desde teclado hasta ingresar uno con nombre de visitante “ZZZ” o alcanzar los 20 partidos. 

Luego de la carga: - Para cada partido, 
armar e informar una representación String del estilo:  {EQUIPO-LOCAL golesLocal    VS   EQUIPO-VISITANTE golesVisitante } - 
Calcular e informar la cantidad de partidos que ganó River. - Calcular e informar el total de goles que realizó Boca jugando de local. 
 
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ejercicio5 {

    public static void main(String[] args) {
        int dimF20 = 20;
        partido[] partidoDisputado = new partido[dimF20];
        //partido fulbo;
        System.out.println("local: ");
        String local = Lector.leerString();
        System.out.println("Visitante: ");
        String visitante = Lector.leerString();
        System.out.println("cant Goles Local: ");
        int cantLocal = Lector.leerInt();
        System.out.println("cant Goles visitante: ");
        int cantVisitante = Lector.leerInt();

//        fulbo = new partido (local,visitante,cantLocal,cantVisitante);
        //fulbo a = partido.setCrearPicadito();
        //cargar data
        int i = 0;
        while ((i < dimF20) && (!visitante.equals("ZZZ"))) {
            partidoDisputado[i] = new partido(local, visitante, cantLocal, cantVisitante);
            System.out.println("local: ");
            local = Lector.leerString();
            System.out.println("Visitante: ");
            visitante = Lector.leerString();

            System.out.println("cant Goles Local: ");
            cantLocal = Lector.leerInt();
            System.out.println("cant Goles visitante: ");
            cantVisitante = Lector.leerInt();
            i++;
        }
        //procesarData
        int golesBoquita = 0;
        int cantPartRiverGano = 0;
        for (int j = 0; j < i; j++) {
            System.out.println("{EQUIPO-LOCAL golesLocal" + partidoDisputado[i].getCantGolesLocal() + "VS   EQUIPO-VISITANTE golesVisitante" + partidoDisputado[i].getCantGolesVisitante());
            if (partidoDisputado[i].getLocal().equals("Boca")) {
                golesBoquita += 1;
            }
            if ((partidoDisputado[i].getHayGanador()) && (partidoDisputado[i].getGanador().equals("River"))) {
                cantPartRiverGano += 1;
            }

        }
        System.out.println("goles de boca jugando de local: " + golesBoquita);
    }
}
