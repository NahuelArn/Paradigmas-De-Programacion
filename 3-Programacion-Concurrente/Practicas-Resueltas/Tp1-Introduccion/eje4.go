{La ciudad se dividió en 4 áreas:
Área 1: desde la avenida 1 hasta la avenida 25--
Área 2: desde la avenida 26 hasta la avenida 50
 Área 3: desde la avenida 51 hasta la avenida 75
 Área 4: desde la avenida 76 hasta la avenida 100
Las áreas impares (1 y 3) deben limpiarse de flores, y las áreas pares (2 y 4) deben
 limpiarse de papeles.
 Realice un programa en el que un robot se encarga de limpiar las áreas 1 y 3, y otro
 robot se encarga de las áreas 2 y 4. Para ello, modularice el recorrido de cada área.
 a) Analizar (no es necesario implementar) qué se debería modificar si ahora se pide que
 la ciudad se divida en 20 áreas:
 ● Área 1: Avenidas 1 a 5
 ● Área 2: Avenidas 6 a 10
 ● …
 ● Área 19: Avenidas 91 a 95
 ● Área 20: Avenidas 96 a 100

}
{A: a priori no se deberia modificar nada, solo cambiar los valores de las avenidas/saltos, siempre y cuando se tenga solo esas 2 variantes, papeles y flores}

programa eje4
procesos
  proceso  limpiarFlores
  comenzar
    mientras(HayFlorEnLaBolsa)
      tomarFlor
  fin
  proceso movermeImpares
  comenzar
    limpiarFlores
    mover
  fin
  proceso recorrerAvImpares
  comenzar
    repetir 10  
      movermeImpares {limpia y se mueve}
    limpiarFlores
  fin
  proceso logicaBotImpares
  comenzar
    repetir 24
      recorrerAvImpares
      Pos(PosAv+1,1)
    recorrerAvImpares  {evaluacion de ultima avenida}
  fin
  proceso limpiarPapel
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin
  proceso recorrerAvenidasPapel
  comenzar
    repetir 4
      limpiarPapel
      mover
    limpiarPapel
  fin
  proceso logicaPares
  comenzar
    repetir 24
      recorrerAvenidasPapel
      Pos(PosAv+1, 1)
    recorrerAvenidasPapel
  fin
areas
  AreaImpar1: AreaP(1,1,25,100)
  AreaImpar3: AreaP(51,1,75,100)
  AreaPar2: AreaP(26,1,50,100)
  AreaPar4: AreaP(76,1,100,100)
robots
  robot impar  {flores}
  comenzar
    logicaBotImpares
    Pos(PosAv + 26, 1)
    logicaBotImpares
  fin
  robot par {papeles}
  comenzar
    logicaPares
    Pos(PosAv + 26, 1)
    logicaPares
  fin
variables
  botImpar: impar
  botPar: par
comenzar
  AsignarArea(botImpar, AreaImpar1)
  AsignarArea(botImpar, AreaImpar3)
  AsignarArea(botPar, AreaPar2)
  AsignarArea(botPar, AreaPar4)
  Iniciar(botImpar,1,1)
  Iniciar(botPar,26,1)
fin













































//variante no terminada
programa eje4
procesos
  proceso  limpiezaDeFlores
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso recorridoAreasImpares(E cantAiterar: numero)
  comenzar
    repetir cantAiterar-1
      repetir 99
        limpiezaDeFlores
      limpiezaDeFlores
  fin
  {son iguales pero si se quisiera modularizar los 2, es medio rebuscado, logica de mas}
  proceso  limpiezaDePapeles
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin
  proceso recorridoAreasPares(E cantAiterar: numero)
  comenzar
    repetir cantAiterar-1
      repetir 99
        limpiezaDePapeles
      limpiezaDePapeles
  fin
areas
  ciudad1: AreaP(1,1,25,100)
  ciudad2: AreaP(26,1,50,100)
  ciudad3: AreaP(51,1,75,100)
  ciudad4: AreaP(76,1,100,100)
robots
  robot BotImpares
  variables
    cantAiterar: numero
  comenzar
    cantAiterar:= (25-1)+1
    recorridoAreasImpares(cantAiterar)
    Pos(51,1)
    cantAiterar:= (75-51)+1
    recorridoAreasImpares(cantAiterar)
  fin
  robot BotPares
  variables
    cantAiterar: numero    
  comenzar
    cantAiterar:= (50-26)+1
    recorridoAreasPares(cantAiterar)  
    Pos(76,1)
    cantAiterar:= (100-76)+1
    recorridoAreasPares(cantAiterar)
  fin
variables
  robotImpares: BotImpares
  robotPares: BotPares
comenzar
  AsignarArea(robotPares,ciudad2)
  AsignarArea(robotPares,ciudad4)
  AsignarArea(robotImpares,ciudad1)
  AsignarArea(robotImpares,ciudad3)
  Iniciar(robotImpares,1,1)
  Iniciar(robotPares,6,1)
fin