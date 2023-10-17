<h1 align="center"> PROGRAMACION CONCURRENTE </h1>

<p align="center">Algoritmos que se repiten</p>

<h1 align="center"> a tener en cuenta </h1>


```go
  Calles = -----
  Avenidas = |

  Identacion: importante
  
  No van los " ; " al final de las lineas
  
  Asignacion:  " := "
  Igualdad:   " = "
  Desigualdad: " <> "
  Mayor: " > "
  Menor: " < "
  Mayor o igual: " >= "
  Menor o igual: " <= "
  Y: " & "
  O: " | "
  Negacion: " ~ "

  Imprimir: " Informar() "

  " Palabras Clave "
  HayFlorEnLaBolsa
  HayFlorEnLaEsquina
  TomarFlor

  HayPapelEnLaBolsa
  HayFlorEnLaEsquina
  TomarPapel

  Posicionarme en X,Y: " Pos(X,Y) "
  Mover : una pos para arriba
  derecha : gira 90 grados a la derecha
```

<h1 align="center"> Estructuras de control </h1>

```go
  mientras(condicion) //while
    bloqueCodigo

  repetir(condicion)  //for
    bloqueCodigo

  si(condicion) 
    bloqueCodigo
  sino
    bloqueCodigo


  Con mas condiciones

  mientras((x = 2) & (3<>2))
    bloqueCodigo
  
```

<h1 align="center"> Modulos </h1>\

```go

  "Modulo sin parametros"
  Proceso moduloSinParametros  //si lo declaro sin () no va esperar q ponga un parametro y lo invoco solo con el nombre
  comenzar
    bloqueCodigo
  fin
  "Modulo con parametros de Entrada, por valor" // E
  Proceso nombreModulo(E sarasa: numero)  
  comenzar
    bloqueCodigo
  fin
  "Modulo con parametros de Entrada Salida, por referencia" //ES
  Proceso nombreModulo(ES sarasa: numero)  
  comenzar
    bloqueCodigo
  fin

```