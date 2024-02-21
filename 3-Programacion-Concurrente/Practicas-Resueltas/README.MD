<h1 align="center"> PROGRAMACION CONCURRENTE </h1>

<p align="center">A mano</p>


<h1 align="center"> sintaxis </h1>

```go
    //Primero van todas las asignaciones de areas y despues los iniciar
    comenzar
      //Primero el nombre del robot y despues la cosa
      AsignarAreas(bot1, areaBot1)

      Iniciar(bot1, 1,1)
    fin
```

<h1 align="center"> Colisionadores </h1>
<p align="center"> Concurrencia maximizada , DEPOSITAR DE A UNA</p>

```go    
    proceso bloquearDepositarLiberar(E avIni: numero; E caIni: numero;ES catF: numero)
    comenzar
      repetir cantF
        BloquearEsquina(35,40) {lugar posible de colision}
        Pos(35,50)
        depositarFlor
        Pos(avIni, caIni) {vuelvo safe}
        LiberarEsquina(35,40)
      cant:= 0
    fin
```

<p align="center"> Variacion , solo deposito una y vuelvo safe</p>
```go    
    proceso bloquearDepositarLiberar(E avIni: numero; E caIni: numero;ES catF: numero)
    comenzar
      BloquearEsquina(35,40) {lugar posible de colision}
      Pos(35,50)
      depositarFlor
      Pos(avIni, caIni) {vuelvo safe}
      LiberarEsquina(35,40)
    fin
```

<h1 align="center"> Problema espacio tiempo,canal seguro </h1>
<h1 align="center"> Tipos de sincronizacion </h1>
<h1 align="center"> Tipos de iteradores, desde jefe y trabajador </h1>
<h1 align="center"> Figurardas </h1>
