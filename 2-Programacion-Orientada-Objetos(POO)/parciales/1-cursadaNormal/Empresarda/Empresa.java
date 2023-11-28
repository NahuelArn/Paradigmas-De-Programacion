/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class Empresa {
    private String nombre;
    private String direccion;
    private Director director;
    private Encargado sucursales[];
    
    private int dimF;
    public void inicializarSucursales(){
        for(int i = 0; i < this.dimF; i++){
            sucursales[i] = null;
        }
    }
    //constructor
    public Empresa(String nombre, String direccion, Director director, int nSucursales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.director = director;
        this.sucursales = new Encargado[nSucursales];
        this.dimF = nSucursales;
        inicializarSucursales();
    }
    public void asignarUnEncargado(Encargado encargado, int lugarX){
        this.sucursales[lugarX] = encargado;
    }
    
    private String scrapearVector(){
        String s = " ";
        for(int i = 0; i < this.dimF; i++){
            if(this.sucursales[i] != null){
                s+= "Sucursal: "+ i+this.sucursales[i].toString() + " \n";
                System.out.println("");
            }else{
                s+= "la sucursal: "+i+" no tiene encargado" + " \n";
            }
        }
        return s + "\n";
    }
    @Override
    public String toString() {
        String s = " ";
        s = "Nombre de la empresa: " + this.nombre + " direccion: " + this.direccion + "\n";
        s+= "  "+this.director.toString();
        s+= scrapearVector();
        return s;      
    }
}
