/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author nahuelArn
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //    public BancoTradicional(String direccion, String localidad, String nombreDeBanco, int cantCuentas, int dimFbanco) {
        
        ///----------------------------------------------
        BancoTradicional bancotradicional = new BancoTradicional("160/44","La Plata","Santander",3,5);
        //    public Cuenta(String cbu, String alias, String dniTitular, String moneda) { //moneta = dolares, pesos

        Cuenta cuenta = new Cuenta("4455","pepe","454029","Pesos");
        bancotradicional.agregarCuenta(cuenta);
        cuenta = new Cuenta("5544","pepe","454029","Pesos");
        bancotradicional.agregarCuenta(cuenta);
        bancotradicional.depositarDinero("4455", 1000);
        System.out.println("Puede recibir dinero? "+bancotradicional.puedeRecibirTarjeta("4455"));
        
        ///----------------------------------------------
        //    public BancoDigital(String direccionWeb, String nombreDeBanco, int cantEmpleados, int dimFbanco) {

        BancoDigital bancodigital = new BancoDigital("pepe.com","BBA",5,5);
        cuenta = new Cuenta("2222","pepe","454029","Dolares");
        bancodigital.agregarCuenta(cuenta);
        bancodigital.depositarDinero("2222", 500000);
        System.out.println("Puede recibirDirero? "+bancodigital.puedeRecibirTarjeta("2222"));
    }
    
}
