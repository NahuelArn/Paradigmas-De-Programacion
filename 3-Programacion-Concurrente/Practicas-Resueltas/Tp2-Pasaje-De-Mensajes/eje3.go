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
areas
  equipoA1: AreaPC(1,1,10,1)  {papeles} 
  equipoA2: AreaPC(11,1,20,1)  
  equipoB1: AreaPC(1,5,10,5)  {flores}
  equipoB2: AreaPC(11,5,20,5)
robots
  {EQUIPOA}
  robot comportamientoBotA2
  variables
    cantPapeles: numero
  comenzar
    RecibirMensaje(cantPapeles, a1)  {me quedo afk, hasta q me mande un mensaje para arrancar}
    derecha
    repetir 9
      limpiarPapeles(cantPapeles)
      mover
    limpiarPapeles(cantPapeles)
    Informar('equipoAJunto',cantPapeles)
  fin
  robot  comportamientoBotA1  {los 2 tienen casi el mismo comporamiento pero uno va informar y otro va tener q estar esperando la instruccions para avanzar}
  variables
    cantPapeles: numero
  comenzar
    cantPapeles:= 0
    derecha
    repetir 9
      limpiarPapeles(cantPapeles)
      mover
    limpiarPapeles(cantPapeles)
    EnviarMensaje(cantPapeles, a2)
  fin
  {EQUIPOB}
  robot comportamientoBotB2
  variables
    cantFlores: numero
  comenzar
    RecibirMensaje(cantFlores, b1)  {me quedo afk, hasta q me mande un mensaje para arrancar}
    derecha
    repetir 9
      limpiarFlores(cantFlores)
      mover
    limpiarFlores(cantFlores)
    Informar('equipoAJunto',cantFlores)
  fin
  robot  comportamientoBotB1  {los 2 tienen casi el mismo comporamiento pero uno va informar y otro va tener q estar esperando la instruccions para avanzar}
  variables
    cantFlores: numero
  comenzar
    cantFlores:= 0
    derecha
    repetir 9
      limpiarFlores(cantFlores)
      mover
    limpiarFlores(cantFlores)
    EnviarMensaje(cantFlores, b2)
  fin
variables
  a1: comportamientoBotA1
  a2: comportamientoBotA2
  b1: comportamientoBotB1  {podria reutilizar el comportamiento de equipo A, pero no puedo por q uno junta flores y otro Papeles}
  b2: comportamientoBotB2
comenzar
  AsignarArea(a1,equipoA1)
  AsignarArea(a2,equipoA2)
  AsignarArea(b1, equipoB1)
  AsignarArea(b2, equipoB2)
  Iniciar(a1,1,1)
  Iniciar(a2,11,1)
  Iniciar(b1,1,5)
  Iniciar(b2, 11,5)
fin