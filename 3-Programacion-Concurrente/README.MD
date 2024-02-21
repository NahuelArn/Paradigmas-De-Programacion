<h1 align="center"> PROGRAMACION CONCURRENTE </h1>

<p align="center">Algoritmos que se repiten</p>

<h1 align="center"> a tener en cuenta </h1>


```go
  Calles = -----
  Avenidas = |
  
  Identacion: importante
  
  No van los " ; " al final de las lineas
  comentarios: { comentario }

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

  Posicionarme en X,Y: " Pos(X,Y) " / "Pos(Avenida,Calle)"
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

<h1 align="center"> Areas </h1>

```go
    Areas
      unaArea: AreaP(1,1,5,5)
      otraArea: AreaPC(1,1,5,5)
      otraAreaMas: AreaC(1,1,5,5)
      "
      - Area Compartida (C): cuando todos los robots comparten el mismo area y ninguna puede ser privada    porque las usan TODOS los demas.

      - Area Parcialmente compartida (PC): cuando ingresan 2 o mas a un mismo lugar pero por lo menos 1 del resto no ingresa, por ejemplo si tengo 3 robots, 1 jefe (que se queda quieto lejos, es decir en su AreaP), 1 recolector de flores y 1 de papeles, los cuales ambos entran en un cuadrante en comun declaro asi por ej: area1:AreaP(10,1,10,1)
      area2:AreaPC (1,1,6,10)
      Despues le asigno area1 al jefe y area2 a los otros 2.
      
      -Area privada (P): cuando el robot usa un area y nadie mas, si necesita estar en la esquina 2,2, solo declaro 2,2, es decir: "area1:AreaP(2,2,2,2)". Asi como si necesito las primeras 10 avenidas de la calle uno SOLO declaro eso, es decir:
      area1:AreaP(1,1,10,1).

      "
```
