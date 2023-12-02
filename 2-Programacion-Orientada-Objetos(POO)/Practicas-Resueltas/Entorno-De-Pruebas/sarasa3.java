public class PruebaConMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Padre padre = new Padre(4,3);
        Hijo hijo = new Hijo();

        //  Primera Columna
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        //  Segunda
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        // TERCERA
        padre.agregarHijo(hijo);
        padre.agregarHijo(hijo);
        
        //
        System.out.println(padre.toString());
    }
    
}
