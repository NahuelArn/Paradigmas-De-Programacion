/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class main {
    public static void main(String[] args) {
      //public Director(double montoViaticos, String nombre, String dni, int anhoDeIngresoAlaEmpresa, double sueldoBasico) {

        Director director = new Director(500,"Carlos","4550",2000,3000);
        //    public Empresa(String nombre, String direccion, Director director, int nSucursales) {

        Empresa empresa = new Empresa("Empresa","1450/43",director,10);
        
        Encargado encargado;
        //    public Encargado(int cantEmpleados, String nombre, String dni, int anhoDeIngresoAlaEmpresa, double sueldoBasico) {

        encargado = new Encargado(4,"Pepe","4540",1999,1800);
        empresa.asignarUnEncargado(encargado, 0);
        
        encargado = new Encargado(4,"Pepe","4540",1999,1800);
        empresa.asignarUnEncargado(encargado, 2);
        
        encargado = new Encargado(4,"Pepe","4540",1999,1800);
        empresa.asignarUnEncargado(encargado, 5);
        
        System.out.println(empresa.toString());
    }
}
