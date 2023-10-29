programa eje3
procesos
  proceso  limpiarPapeles(ES cantPapeles: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantPapeles:= cantPapeles+1
  fin
  proceso limpiarFlores(ES cantFlores: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantFlores:= cantFlores+1
  fin
  proceso logicaEquipoA(ES cantPapeles: numero)
  comenzar
    repetir 9
      limpiarPapeles(cantPapeles)
      mover
      limpiarPapeles(cantPapeles)
  fin
  proceso logicaEquipoB(ES cantFlores: numero)
  comenzar
    repetir 9
      limpiarFlores(cantFlores)
      mover
    limpiarFlores(cantFlores)
  fin
areas
  equipoA1: AreaP(1,1,10,1)  {papeles} 
  equipoA2: AreaP(11,1,20,1)  
  equipoA1Salto: AreaP(21,1,30,1)
  equipoA2Salto: AreaP(31,1,40,1)
  equipoB1: AreaP(1,5,10,5)  {flores}
  equipoB2: AreaP(11,5,20,5)
  equipoB1Salto: AreaP(21,5,30,5)
  equipoB2Salto: AreaP(31,5,40,5)
robots
  {EQUIPOA}
  robot comportamientoBotA2
  variables
    cantPapeles: numero
  comenzar
    RecibirMensaje(cantPapeles, a1)  {me quedo afk, hasta q me mande un mensaje para arrancar}
    derecha
    logicaEquipoA(cantPapeles)
    Pos(PosAv+11, 1)
    EnviarMensaje(cantPapeles, a1)
    RecibirMensaje(cantPapeles, a1)
    logicaEquipoA(cantPapeles)
    Informar('equipoAJunto',cantPapeles)
  fin
  robot  comportamientoBotA1  {los 2 tienen casi el mismo comporamiento pero uno va informar y otro va tener q estar esperando la instruccions para avanzar}
  variables
    cantPapeles: numero
  comenzar
    cantPapeles:= 0
    derecha
    logicaEquipoA(cantPapeles)
    Pos(PosAv+11, 1)
    EnviarMensaje(cantPapeles, a2)
    RecibirMensaje(cantPapeles, a2)
    logicaEquipoA(cantPapeles)
    EnviarMensaje(cantPapeles, a2)
  fin
  {EQUIPOB}
  robot comportamientoBotB2
  variables
    cantFlores: numero
  comenzar
    derecha
    RecibirMensaje(cantFlores, b1)  {me quedo afk, hasta q me mande un mensaje para arrancar}
    logicaEquipoB(cantFlores)
    Pos(PosAv+11, 5)
    EnviarMensaje(cantFlores, b1)
    RecibirMensaje(cantFlores, b1)
    logicaEquipoB(cantFlores)
    Informar('equipoAJunto',cantFlores)
  fin
  robot  comportamientoBotB1  {los 2 tienen casi el mismo comporamiento pero uno va informar y otro va tener q estar esperando la instruccions para avanzar}
  variables
    cantFlores: numero
  comenzar
    cantFlores:= 0
    derecha
    logicaEquipoB(cantFlores)
    EnviarMensaje(cantFlores, b2)
    Pos(PosAv+11, 5)
    RecibirMensaje(cantFlores,b2)
    logicaEquipoB(cantFlores)
    EnviarMensaje(cantFlores, b2)
  fin
variables
  a1: comportamientoBotA1
  a2: comportamientoBotA2
  b1: comportamientoBotB1  {podria reutilizar el comportamiento de equipo A, pero no puedo por q uno junta flores y otro Papeles}
  b2: comportamientoBotB2
comenzar
  AsignarArea(a1,equipoA1)
  AsignarArea(a1,equipoA1Salto)
  AsignarArea(a2,equipoA2)
  AsignarArea(a2,equipoA2Salto)
  AsignarArea(b1, equipoB1)
  AsignarArea(b1, equipoB1Salto)
  AsignarArea(b2, equipoB2)
  AsignarArea(b2, equipoB2Salto)
  Iniciar(a1,1,1)
  Iniciar(a2,11,1)
  Iniciar(b1,1,5)
  Iniciar(b2, 11,5)
fin