   public static void main(String[] args) {
        Padre padre = new Padre(4, 3);

        padre.agregarNombre("Pepe1");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe3");
        padre.agregarNombre("Pepe4");
        //
        padre.agregarNombre("Pepe4");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe3");
        padre.agregarNombre("Pepe4");
//        //
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe2");
        padre.agregarNombre("Pepe2");
        
        padre.agregarNombre("Pepe2");
        
        System.out.println(padre.toString());
    }