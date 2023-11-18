programa arn
procesos
  proceso juntarFlores(ES cantFlores: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso juntarFloresyPapeles(ES cantFlores: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin
  proceso juntarPapeles(ES cantFlores: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin    
  proceso perimetroPapel(E alto: numero; E ancho: numero; ES cantFlores: numero)
  comenzar
    repetir  2
      repetir alto-1
        juntarFlores(cantFlores)
        mover
      derecha
      repetir ancho-1
        juntarFlores(cantFlores)
        mover
      derecha
  fin
  proceso perimetroPapelFlor(E alto: numero; E ancho: numero;ES cantFlores: numero; ES cantPapeles: numero)
  comenzar
    repetir 2
      repetir alto-1
        juntarFlores(cantFlores)
        juntarPapeles(cantPapeles)
        mover
      derecha
      repetir ancho-1
        juntarFlores(cantFlores)
        juntarPapeles(cantPapeles)
        mover
      derecha
  fin
  proceso perimetroFlor(E alto: numero; E ancho: numero; ES cantPapeles: numero)
  comenzar
    repetir  2
      repetir alto-1
        juntarPapeles(cantPapeles)
        mover
      derecha
      repetir ancho-1
        juntarPapeles(cantPapeles)
        mover
      derecha
  fin
areas
  {areaRobots: AreaC(2,2,15,15)}
  areaRobots: AreaC(2,2,100,100)
  areaFiscal: AreaP(1,1,1,1)
{---------------------------------BOTS--------------------------------------------------}
robots
  robot  recolectorFlor
  variables
    cantFlores: numero
    calleRecibida, id: numero
  comenzar
    cantFlores:= 0
    RecibirMensaje(id, jefe)
    perimetroFlor(6,6,cantFlores)
    EnviarMensaje(id, jefe)
    RecibirMensaje(calleRecibida, jefe)
    Pos(PosAv, calleRecibida)
  fin
  robot recolectorPapelFlor
  variables
    cantFlores, cantPapeles: numero
    calleRecibida, id: numero
  comenzar
    cantPapeles:= 0
    RecibirMensaje(id, jefe)
    perimetroPapelFlor(10,10,cantFlores,cantPapeles)
    EnviarMensaje(id, jefe)
    RecibirMensaje(calleRecibida, jefe)
    Pos(PosAv, calleRecibida)
  fin
  robot recolectorPapel
  variables
    cantPapeles: numero
    id: numero
    calleRecibida: numero
  comenzar
    cantPapeles:= 0
    RecibirMensaje(id, jefe)
    perimetroPapel(7,7,cantPapeles) 
    EnviarMensaje(id, jefe)
    RecibirMensaje(calleRecibida, jefe)
    Pos(PosAv, calleRecibida)
  fin
  robot  fiscalizador
  variables
    id: numero
    calleEnviada: numero
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    calleEnviada:= 20
    repetir 3
      RecibirMensaje(id, *)
      Informar('sarasa',id)
      si(id = 1)
        EnviarMensaje(calleEnviada, bot1)
      sino
        si(id = 2)
          EnviarMensaje(calleEnviada, bot2)
        sino
          si(id = 3)
            EnviarMensaje(calleEnviada, bot3)
      calleEnviada:= calleEnviada+1
  fin
variables
  bot1: recolectorFlor
  bot2: recolectorPapelFlor
  bot3: recolectorPapel
  jefe: fiscalizador
comenzar
  {areas donde recolectores}
  AsignarArea(bot1, areaRobots)
  AsignarArea(bot2, areaRobots)
  AsignarArea(bot3, areaRobots)
  AsignarArea(jefe, areaFiscal)
  {areas default}
  Iniciar(bot1, 2,2)
  Iniciar(bot2, 5,5)
  Iniciar(bot3, 9,9)
  Iniciar(jefe, 1,1)
fin