<h1 align="center"> Sintaxis </h1>

<p align="center">En donde ? en todoo codeee</p>

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