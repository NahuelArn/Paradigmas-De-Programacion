/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practica5EjeAdic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nahuelArn
 */
public class InvestigadorTest {
    
    public InvestigadorTest() {
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Investigador instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        
//        System.out.println("getNombre");
//        String nombreEsperado = "John Doe"; // Definir un nombre esperado
//        Investigador instance = new Investigador(nombreEsperado, 1, "Especialidad");
//        String resultado = instance.getNombre();
//        assertEquals(nombreEsperado, resultado);
    }

    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        int expResult = 2;
        Investigador instance = new Investigador("sarasa",expResult,"sarasa");
        
        int result = instance.getCategoria();
        assertEquals(expResult, result);
     
        
        //----------------------------------------------------
       
    }

    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        int categoria = 0;
        Investigador instance = null;
        instance.setCategoria(categoria);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEspecialidad() {
        System.out.println("getEspecialidad");
        Investigador instance = null;
        String expResult = "";
        String result = instance.getEspecialidad();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEspecialidad() {
        System.out.println("setEspecialidad");
        String especialidad = "";
        Investigador instance = null;
        instance.setEspecialidad(especialidad);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSubsidio() {
        System.out.println("setSubsidio");
        Subsidio subsidio = null;
        Investigador instance = null;
        instance.setSubsidio(subsidio);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDimL() {
        System.out.println("getDimL");
        Investigador instance = new Investigador("pepe",2,"pepe2");
        int expResult = 0;
        int result = instance.getDimL();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDineroTotalOtorgado() {
        System.out.println("getDineroTotalOtorgado");
        Investigador instance = null;
        double expResult = 0.0;
        double result = instance.getDineroTotalOtorgado();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Investigador instance = new Investigador("ppepe",2,"pepe");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
