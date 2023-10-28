programa eje3
procesos
  proceso arriba
  comenzar
    repetir 3
      derecha
  fin 
  proceso contarPapeles( ES cantPapeles: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)  
      tomarPapel
      cantPapeles:= cantPapeles + 1
    mientras(HayPapelEnLaBolsa)
      depositarPapel
  fin
  proceso contarFlores(ES cantFlores: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantFlores:= cantFlores+1
    mientras(HayFlorEnLaBolsa) 
      depositarFlor
  fin
  proceso contar (ES cantCumplen: numero)
  variables
    cantFlores: numero
    cantPapeles: numero
    resta: numero
  comenzar
    cantFlores:= 0
    cantPapeles:= 0
    contarPapeles(cantPapeles)
    contarFlores(cantFlores)
    resta:= cantPapeles - cantFlores
    si(resta = 1)
      cantCumplen := cantCumplen + 1
  fin
  proceso  movermeDerecha  (E nVeces: numero; ES cantCumplen: numero)
  comenzar
    repetir nVeces
      contar(cantCumplen)
      mover  
    contar(cantCumplen)
  fin
  proceso  movermeArriba  (E nVeces: numero)
  comenzar
    repetir nVeces
      mover  
  fin
  proceso escalon
  variables
    n: numero
    cantCumplen: numero
  comenzar
    n := 0 
    cantCumplen:= 0
    repetir 4
      derecha
      n:= n+1
      movermeDerecha(n,cantCumplen) 
      arriba
      movermeArriba(n)
    Informar(cantCumplen)
  fin
areas
  ciudad: AreaC(1,1,100,100)
robots
  robot  tip1
  comenzar
    escalon
  fin
variables
  robot1: tip1
  robot2: tip1
  robot3: tip1
comenzar
  AsignarArea(robot1,ciudad)
  AsignarArea(robot2,ciudad)
  AsignarArea(robot3,ciudad)
  Iniciar(robot1, 22,6)
  Iniciar(robot2,17,10)
  Iniciar(robot3, 12,14)
fin