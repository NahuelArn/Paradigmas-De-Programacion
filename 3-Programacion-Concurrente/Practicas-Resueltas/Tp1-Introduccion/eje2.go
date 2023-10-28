//A: las areas se deberian declarar privadas, ya que no comparte ningun robot su recorrido
//B: No existe riesgo de colision ya q no comparten areas

programa eje2
procesos
  proceso rotacion(E cantVeces: numero)
  comenzar
    repetir cantVeces
      derecha
  fin
  proceso movermeNveces (E cantMovimientos: numero)
  variables
    cantPapeles: numero
  comenzar
    cantPapeles:= 0
    repetir cantMovimientos
      limpiezaPapel(cantPapeles)
      mover
    Informar(cantPapeles)
  fin 
  proceso limpiezaFlor
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso limpiezaPapel(ES cantPapeles: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantPapeles:= cantPapeles+1
  fin

areas
  ciudadVertical1: AreaP(1,1,1,99)
  ciudadHorizonal2: AreaP(1,100,99,100)
  ciudadVertical3: AreaP(100,2,100,100) 
  ciudadHorizonal4: AreaP(2,1,100,1)
robots
  robot tip1
  comenzar
    rotacion(0)
    movermeNveces(98)
  fin
  robot tip2
  comenzar
    rotacion(1)
    movermeNveces(98)
  fin
  robot tip3
  comenzar
    rotacion(2)
    movermeNveces(98)
  fin
  robot tip4
  variables
    cantPapeles: numero
  comenzar
    cantPapeles:= 0
    rotacion(3)
    movermeNveces(98)
  fin
variables
  robot1: tip1
  robot2: tip2
  robot3: tip3
  robot4: tip4
comenzar
  AsignarArea(robot1,ciudadVertical1)
  AsignarArea(robot2,ciudadHorizonal2)
  AsignarArea(robot3,ciudadVertical3)
  AsignarArea(robot4,ciudadHorizonal4)
  Iniciar(robot1,1,1)
  Iniciar(robot2,1,100)
  Iniciar(robot3,100,100)
  Iniciar(robot4,100,1)
fin