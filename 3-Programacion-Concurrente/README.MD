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
  True: " V "
  False: " F "
  Ok:= V 
  Imprimir: " Informar() "
  Random(VariableDondeSeGuarda,limiteInferior,limiteSuperior)

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

<h1 align="center"> Comunicacion </h1>

```go
    EnviarMensaje(Valor, robotDestinatario)
    RecibirMensaje(valorRecibido, robotEmisor)

    Para enviar mensajes o Recibir Mensajes de cualquier robot, se usa *

    EnviarMensaje(Valor, *)
    RecibirMensaje(valorRecibido, *)
```

<h1 align="center"> Bloqueos de memoria </h1>

```go
    BloquearEsquina(x,y)
    LiberarEsquina(x,y)

    ejemplo
    BloqueoEsquina(2,1) {bloqueo antes de posicionarme}
    Pos(2,1)  {me posiciono}
    logica  {hago lo q tenga q hacer}
    Pos(3,1)  {lo muevo a un lugar seguro}
    LiberarEsquina(2,1) {libero el recurso para q otro bot pueda accederlo}
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

    Algo como un switch
  si(condicion) 
    bloqueCodigo
  sino
    si(condicion)
      bloqueCodigo

  Con mas condiciones

  mientras((x = 2) & (3<>2))
    bloqueCodigo
```

<h1 align="center"> Modulos </h1>

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
  "Modulo con varios parametros" //ES
  Proceso nombreModulo(ES sarasa: numero; E sarasa2: numer; E sarasa3: numer)  
  comenzar
    bloqueCodigo
  fin
```