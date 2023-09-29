/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author nahuelarn
 */

/*
4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/
2000 y 8000.
(iii) Implemente en las clases que corresponda todos los métodos necesarios para:
-Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
en el rango 1..N) y que la habitación está libre.
-Aumentar el precio de todas las habitaciones en un monto recibido.
-Obtener la representación String del hotel, siguiendo el formato:
{Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
…
{Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
delegar la responsabilidad de la operación.+
 */
 /*

Objetos: hotel, habitaciones(costoPorNoche,ocupada?),Cliente(nombre,dni,edad)
 */
public class Hotel {

    private int cantHabitaciones;
    //private Habitacion[] Habitaciones = new Habitacion[cantHabitaciones];
    private Habitacion[] Habitaciones;

    //constructor
    private void setInicializarVector() {
        for (int i = 0; i < this.cantHabitaciones; i++) {
            this.Habitaciones[i] = new Habitacion();
            //this.Habitaciones = new Habitacion[cantHabitaciones];
        }
    }

    public Hotel(int cantHabitaciones) {
        // setInicializarVector();
        this.cantHabitaciones = cantHabitaciones;
        Habitaciones = new Habitacion[cantHabitaciones];
        setInicializarVector();

        //setInicializarVector();
    }

    //getters and setters
    public int getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(int cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public Habitacion[] getHabitaciones() {
        return Habitaciones;
    }

    public void setHabitaciones(Habitacion[] Habitaciones) {
        this.Habitaciones = Habitaciones;
    }

    public boolean getHabitacionBuscada(int numHabitacion) {

        if (Habitaciones[numHabitacion].getEstado() != false) {
            return true;
        } else {
            return false;
        }
    }

    public int getDnIEnPos(int pos) {

        if (Habitaciones[pos].getEstado() != false) {

            return Habitaciones[pos].getHuesped().getDni();
        } else {
            return -1;
        }
    }

    public Habitacion getHabitacionDni(int dni) {
        int i = 0;
        boolean ok = false;
        while ((i < cantHabitaciones) && (ok == false)) {
            if (Habitaciones[i].getEstado() != false) {
                if (dni == (Habitaciones[i].getHuesped().getDni())) {
                    ok = true;
                    //return Habitaciones[i];
                }

            }
            i++;
        }
        if (ok) {
            return Habitaciones[i];
        } else {
            return null;
        }
    }
}
