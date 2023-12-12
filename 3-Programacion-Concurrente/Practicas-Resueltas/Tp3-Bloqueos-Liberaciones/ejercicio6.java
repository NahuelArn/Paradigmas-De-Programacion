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
  {Colisionadores solo para el primer cuadrado, Lados: ArribaIzquierda, AbajoIzquierda}
  proceso colisionadorArribaIzquierda(E avEnColision: numero; E caEnColision: numero; ES omito: boolean)
  comenzar
    omito:= F
    si(PosAv = avEnColision) & (caEnColision =  PosCa+1)
      BloquearEsquina(PosAv, cPosCa+1 )
      mover
  fin
  proceso colisionadorAbajoIzquierda(E avEnColision: numero; E caEnColision: numero; ES omito: boolean)
  comenzar
    omito:= F
    si(PosAv-1 = avEnColision) & (caEnColision =  PosCa)
      BloquearEsquina(PosAv-1, cPosCa )
      mover
  fin
  proceso juntarPapeles(ES cantFlores: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin    
  proceso perimetroPapel(E alto: numero; E ancho: numero; ES cantFlores: numero)
  variables
    primerColisionAv: numero
    primerColisionCa: numero
    segundaColisionAv: numero
    segundaColisionCa: numero
    omito: boolean
    cantPapeles: numero
  comenzar
    primerColisionAv:= 9
    primerColisionCa:= 15
    segundaColisionAv:= 14
    segundaColisionCa:= 9
    cantPapeles:= 0
    repetir  2
      repetir alto-1
        juntarPapeles(cantPapeles)
        colisionadorArribaIzquierda(primerColisionAv,primerColisionCa,omito)
        si(omito)
          juntarPapeles(cantPapeles)
          mover
          LiberarEsquina(primerColisionAv,primerColisionCa)
        sino
          mover
      derecha
      repetir ancho-1
        juntarPapeles(cantPapeles)
        colisionadorAbajoIzquierda(segundaColisionAv,segundaColisionCa,omito)
        si(omito)
          juntarPapeles(cantPapeles)
          mover
          LiberarEsquina(primerColisionAv,primerColisionCa)
        sino
          mover
      derecha
  fin
  proceso perimetroPapelFlor(E alto: numero; E ancho: numero;ES cantFlores: numero; ES cantPapeles: numero)
  variables
    primerColisionAv: numero
    primerColisionCa: numero
    segundaColisionAv: numero
    segundaColisionCa: numero
    terceraColisionAv: numero
    terceraColisionCa: numero
    omito: boolean
    cantPapeles: numero
    cantFlores: numero
  comenzar
    primerColisionAv:= 5
    primerColisionCa:= 7
    segundaColisionAv: 9
    segundaColisionCa: 14
    terceraColisionAv: 14
    terceraColisionCa: 9    {HASTA AQUI LLEGASTE}
    
    cantPapeles:= 0
    cantFlores:= 0
    repetir 2
      repetir alto-1
        juntarFlores(cantFlores)
        juntarPapeles(cantPapeles)
        colisionadorArribaIzquierda(primerColisionAv,primerColisionCa,omito)
        si(omito)
          juntarFlores(cantFlores)
          juntarPapeles(cantPapeles)
          mover
          LiberarEsquina(primerColisionAv,primerColisionCa,omita)
        sino
          mover
      derecha
      repetir ancho-1
        juntarFlores(cantFlores)
        juntarPapeles(cantPapeles)
        colisionadorHorizontal(segundaColisionAv,segundaColisionCa,omito)
        si(omito)
          juntarFlores(cantFlores)
          juntarPapeles(cantPapeles)
          mover
          LiberarEsquina(segundaColisionAv,segundaColisionCa,omita)
        sino
          mover
      derecha
  fin
  {Colisionadores solo para el primer cuadrado, Lados: Arriba, Derecha}
  proceso colisionadorHorizontal(E avEnColision: numero; E caEnColision: numero; ES omito: boolean)
  comenzar
    omito:= F
    si(PosAv+1 = avEnColision) & (caEnColision )
      BloquearEsquina(PosAv+1, caEnColision )
      mover
  fin
  proceso colisionadorVertical(E avEnColision: numero; E caEnColision: numero; ES omito: boolean)
  comenzar
    omito:= F
    si(PosAv = avEnColision) & (caEnColision-1 )
      BloquearEsquina(PosAv-1, caEnColision )
      mover
  fin

  proceso perimetroFlor(E alto: numero; E ancho: numero; ES cantPapeles: numero)
  variables
    flag: numero
    primerColisionAv: numero
    primerColisionCa: numero
    segundaColisionAv: numero
    segundaColisionCa: numero
    omito: boolean
  comenzar
    flag:= 0
    primerColisionAv:= 5
    primerColisionCa:= 7
    segundaColisionAv:= 7
    segundaColisionCa:= 5
    repetir  2
      repetir alto-1
        juntarPapeles(cantPapeles)
        colisionadorVertical(segundaColisionAv,segundaColisionCa, omito)
        si(omito)
          juntarPapeles(cantPapeles)
          mover
          LiberarEsquina(segundaColisionAv, segundaColisionCa)
        sino
          mover
      derecha
      repetir ancho-1
        juntarPapeles(cantPapeles)
        colisionadorHorizontal(primerColisionAv,primerColisionCa,omito)
        si(omito)
          juntarPapeles(cantPapeles)
          mover
          LiberarEsquina(primerColisionAv,primerColisionCa)
        sino
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