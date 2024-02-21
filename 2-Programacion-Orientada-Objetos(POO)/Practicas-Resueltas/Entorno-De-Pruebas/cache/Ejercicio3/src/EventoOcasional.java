/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nahuelArn
 */
public class EventoOcasional extends Recital {

    private String motivo;  //beneficio, tv, privado
    private String nombreDeContratante;
    private int diaDelEvento;

    public EventoOcasional(String motivo, String nombreDeContratante, int diaDelEvento, String nombreDeLaBanda, int cantTemas) {
        super(nombreDeLaBanda, cantTemas);
        this.motivo = motivo;
        this.nombreDeContratante = nombreDeContratante;
        this.diaDelEvento = diaDelEvento;
    }

    @Override
    public void actuar() {
        String s = " ";
        if (this.motivo.equals("beneficio")) {
            s = "Recuerden colaborar con " + this.nombreDeContratante;
        } else {
            if (this.motivo.equals("tv")) {
                s = "Saludos amigos televidentes";
            } else {
                if (this.motivo.equals("privado")) {
                    s = "Un feliz cumpleanhos para " + this.nombreDeContratante;
                }
            }
        }
        s += imprimirListaDeTemas();
        System.out.println(s);
    }

    @Override
    public double calcularCosto() {
        double monto = 0;
        if ("beneficio".equals(motivo)) {
            monto = 0;
        } else if ("tv".equals(motivo)) {
            monto= 50000;
        } else if ("privado".equals(motivo)) {
            monto= 150000;
        }
        return monto;
    }
}
