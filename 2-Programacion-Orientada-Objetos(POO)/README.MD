<h1 align="center"> PROGRAMACION ORIENTADA A OBJETOS </h1>

<h1 align="center"> En donde ? en todoo codeee </h1>

<p align="center">
  <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/100500003/268323762-7a016ddf-14cc-4946-84c6-c8a254a18b31.png" alt="cat">
</p>


<h2 align="center"> Variables </h2>

```java

  int entero = 1;
  double decimal = 1.5;
  char caracter = 'a';
  String cadena = "Hola";
  boolean booleano = true;


```


<h2 align="center"> Operadores </h2>

```java
  
    // Aritméticos
    + - * / % ++ --
  
    // Relacionales
    == != < > <= >=
  
    // Lógicos
    && || !
  
    // Asignación
    = += -= *= /= %=
  
```

<h2 align="center"> Randomize en Java </h2>

```java
  import PaqueteLectura.GeneradorAleatorio; //o import scanner

  public class Demo05Generador {

      public static void main(String[] args) {
          GeneradorAleatorio.iniciar();                              //inicia el generador aleatorio
          System.out.println(GeneradorAleatorio.generarInt(10));    //genera un int entre 0 y 9
          System.out.println(GeneradorAleatorio.generarDouble(10)); //genera un double entre 0 y 9
          System.out.println(GeneradorAleatorio.generarBoolean());  //genera un boolean
          System.out.println(GeneradorAleatorio.generarString(4));  //genera un string de 4 letras
      }
      
  }

```

<h2 align="center"> lectura </h2>

```java

  import PaqueteLectura.Lector; //scanner

  public class Demo05Generador {

      public static void main(String[] args) {
          System.out.println("Ingrese un numero: ");
          int num1 = Lector.leerInt();
          System.out.println("Ingrese un nombre : ");
          String nombre = Lector.leerString();

           Lector.leerBoolean();
           Lector.leerDouble();

      }
      
  }

```

<h2 align="center"> Estructuras de control </h2>

<h3 align = "center"> If/Else </h3>
  
```java

  if (condición) {
      // Código si la condición es verdadera
  } else {
      // Código si la condición es falsa
  }

```

<h3 align = "center"> Switch/Case </h3>
  
```java

  switch (variable) {
    case valor1:
        // Código si la variable tiene el valor1
        break;
    case valor2:
        // Código si la variable tiene el valor2
        break;
    default:
        // Código si no coincide con ningún caso
  }

```

<h3 align = "center"> For </h3>
  
```java

  for (inicialización; condición; actualización) {
    // Código a repetir mientras se cumple la condición
  }

```

<h3 align = "center"> While </h3>
  
```java

  while (condición) {
    // Código a repetir mientras se cumple la condición
  }

```

<h3 align = "center"> Do While / Repeat Until </h3>
  
```java

  do {
    // Código a ejecutar al menos una vez
  } while (condición);

```

<h2 align="center"> Estructuras de datos </h2>

<h3 align = "center"> Arrays </h3>

<p> Unidimensional </p> 

```java
  
    // Declaración
    tipo[] nombre = new tipo[tamaño];
    tipo[] nombre = {valor1, valor2, valor3, ...};
  
    // Acceso
    nombre[posición];
  
```

<p> Multidimensional </p>

```java
  
    // Declaración
    tipo[][] nombre = new tipo[tamaño1][tamaño2];
    tipo[][] nombre = {{valor1, valor2, valor3, ...}, {valor1, valor2, valor3, ...}, ...};
  
    // Acceso
    nombre[posición1][posición2];

```

<h3 align = "center"> ArrayList / Listas </h3>

```java

  import java.util.ArrayList;

  // Declaración
  ArrayList<tipo> nombreLista = new ArrayList<tipo>();
  ArrayList<tipo> nombreLista = new ArrayList<tipo>(tamaño);
  ArrayList<tipo> nombreLista = new ArrayList<tipo>(Arrays.asList(valor1, valor2, valor3, ...));

  // Acceso
  nombreLista.get(posición);
  // Añadir
  nombreLista.add(elemento);

```

<h3 align = "center"> Arbol </h3>

```java
  //Clase para el Nodo del Árbol
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
  }

  // Clase para el Árbol Binario
  class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Métodos para operaciones en el árbol, como inserción, búsqueda, eliminación, recorridos, etc.
  }

  //Inserción de un nodo en el árbol:
  public void insert(int val) {
    root = insertRecursive(root, val);
  }

  private TreeNode insertRecursive(TreeNode root, int val) {
      if (root == null) {
          return new TreeNode(val);
      }

      if (val < root.val) {
          root.left = insertRecursive(root.left, val);
      } else if (val > root.val) {
          root.right = insertRecursive(root.right, val);
      }

      return root;
  }

  //Recorrido en orden
  public void inorderTraversal(TreeNode node) {
    if (node == null) {
        return;
    }

    inorderTraversal(node.left);
    System.out.print(node.val + " ");
    inorderTraversal(node.right);
  }

  //Creación de un árbol y operaciones:

  public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);

        System.out.print("In-order traversal: ");
        tree.inorderTraversal(tree.root);  // Realiza un recorrido en orden del árbol
    }
  }

```


