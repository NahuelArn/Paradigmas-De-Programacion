/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelarn
 *
 *
 * 3-A- Defina una clase para representar estantes. Un estante almacena a lo
 * sumo 20 libros. Implemente un constructor que permita iniciar el estante sin
 * libros. Provea métodos para: (i) devolver la cantidad de libros que
 * almacenados (ii) devolver si el estante está lleno (iii) agregar un libro al
 * estante (iv) devolver el libro con un título particular que se recibe. B-
 * Realice un programa que instancie un estante. Cargue varios libros. A partir
 * del estante, busque e informe el autor del libro “Mujercitas”. C- Piense:
 * ¿Qué modificaría en la clase definida para ahora permitir estantes que
 * almacenen como máximo N libros? ¿Cómo instanciaría el estante?
 *
 */
public class Estante {

    Autor[] vLibros = new Autor[20];
    int cantLibros = 0;

    public Estante() {

    }

    public Autor[] getvLibros() {
        return this.vLibros;
    }

    public int getCantLibros() {
        return this.cantLibros;
    }

    //aumenta en 1 la cantidad de libros
    public void setCantLibros() {
        if (getCantLibros() < 20) {
            this.cantLibros += 1;
        } else {
            System.out.println("Error, se esta pasando de la dimF del estante (20)");
        }
    }

    public void setLibro(Autor libro) {
        if (cantLibros < 20) {
            this.vLibros[cantLibros] = libro;
            setCantLibros();
        } else {
            System.out.println("Estante lleno, instancia un nuevo estante");
        }
    }

    public boolean getLleno() {
        return this.cantLibros == 20;
    }

    public Autor getLibro(String titulo) {
        int i = 0;
        while ((i < this.cantLibros) && (this.vLibros[i] != null)) {
            if ((titulo.equals(this.vLibros[i].getTitulo()))) {
                return this.vLibros[i];
            } else {
                i++;
            }
        }
        return null;
    }
//    public Autor getLibro(String titulo) {
//        int i = 0;
//        //System.out.println("num CONTENDIO "+titulo);
//        while ((i < this.cantLibros) && (this.vLibros[i] != null) && (!titulo.equals(this.vLibros[i].getTitulo()))) {
//            i++;
//        }
//        if (titulo.equals(this.vLibros[i].getTitulo())) {
//            return vLibros[i];
//        } else {
//            return null;
//        }
//    }
}
