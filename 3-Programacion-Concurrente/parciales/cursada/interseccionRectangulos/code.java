programa arn
procesos
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso juntarPapeles(ES cantP: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin
  proceso  bloquearJuntarLiberar1(ES cantF: numero; ES cantP: numero)
  comenzar
    repetir 4
      juntarFlores(cantF)  {junto actual}
      juntarPapeles(cantP)
      BloquearEsquina(PosAv,PosCa+1)  {bloque la q viene posible colision}
      mover    {me muevo al lugar inseguro}
      juntarFlores(cantF)
      juntarPapeles(cantP)
      mover  {me muevo a un lugar seguro}
      LiberarEsquina(PosAv, PosCa-1)  {libero la anterior}
  fin
  proceso  juntarNormal(ES cantF: numero; ES cantP: numero)
  comenzar
    repetir 2
      juntarFlores(cantF)
      juntarPapeles(cantP)   
      mover 
  fin
  proceso bloquearJuntarLiberar2(ES cantF: numero; ES cantP: numero)
  comenzar
    repetir 4
      juntarFlores(cantF)
      juntarPapeles(cantP)
      BloquearEsquina(PosAv-1,PosCa)
      mover
      juntarFlores(cantF)
      juntarPapeles(cantP)
      mover
      LiberarEsquina(PosAv+1, PosCa)
  fin
  proceso bloquearJuntarLiberar3(ES cantF: numero; ES cantP: numero)
  comenzar
    repetir 4
      juntarFlores(cantF)
      juntarPapeles(cantP)
      BloquearEsquina(PosAv+1, PosCa)
      mover
      juntarFlores(cantF)
      juntarPapeles(cantP)
      mover
      LiberarEsquina(PosAv-1, PosCa)
  fin
  proceso  bloquearJuntarLiberar4(ES cantF: numero; ES cantP: numero)
  comenzar
    repetir 4
      juntarFlores(cantF)
      juntarPapeles(cantP)
      BloquearEsquina(PosAv-1, PosCa)
      mover
      juntarFlores(cantF)
      juntarPapeles(cantP)
      mover
      LiberarEsquina(PosAv+1, PosCa)
  fin 
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    EnviarMensaje(4, bot4)
  fin
  proceso paraDondeVoy(ES posAvRectangulo: numero;ES posCaRectangulo: numero)
  comenzar
    si(PosCa =  1)
      posAvRectangulo:= 1
      posCaRectangulo:= 2
    sino
      si(PosCa = 2)
        posAvRectangulo:= 1
        posCaRectangulo:= 6
      sino
        si(PosCa = 4)
          posAvRectangulo:= 2
          posCaRectangulo:= 1
        sino
          si(PosCa = 5)
            posAvRectangulo:= 6
            posCaRectangulo:= 1
  fin
areas
  lugar: AreaPC(1,1,9,9)
  areaBot1: AreaP(20,1,20,1)  {horizontales}
  areaBot2: AreaP(20,2,20,2)
  areaBot3: AreaP(20,4,20,4)  {verticales}
  areaBot4: AreaP(20,5,20,5)
  areaJefe: AreaP(20,15,20,15)
robots
  robot  recolectorVertical
  variables
    cantF, cantP: numero
    id: numero
    posAvRectangulo, posCaRectangulo: numero
  comenzar  
    cantF:= 0
    cantP:= 0
    RecibirMensaje(id, jefe)
    paraDondeVoy(posAvRectangulo, posCaRectangulo)
    Pos(posAvRectangulo, posCaRectangulo)
    bloquearJuntarLiberar1(cantF,cantP)  {para arriba}
    Informar('derechaa',1)
    derecha
    juntarNormal(cantF,cantP)
    derecha
    bloquearJuntarLiberar2(cantF,cantP)  {para abajo}
    derecha
    juntarNormal(cantF,cantP)
    EnviarMensaje(id,jefe)
    EnviarMensaje(cantF, jefe)
    EnviarMensaje(cantP, jefe)
  fin
  robot  recolectorHorizontal
  variables
    cantF,cantP: numero
    posAvRectangulo, posCaRectangulo: numero
    id: numero
  comenzar
    RecibirMensaje(id, jefe)
    paraDondeVoy(posAvRectangulo, posCaRectangulo)
    Pos(posAvRectangulo, posCaRectangulo)
    juntarNormal(cantF,cantP)
    derecha
    bloquearJuntarLiberar3(cantF,cantP)    {de izquierda a derecha, horizontal}
    derecha
    juntarNormal(cantF,cantP)
    derecha
    bloquearJuntarLiberar4(cantF,cantP)
    EnviarMensaje(id,jefe)
    EnviarMensaje(cantF, jefe)
    EnviarMensaje(cantP, jefe)
  fin
  robot   coordinador
  variables
    id, cantF, cantP: numero
  comenzar
    asignarIds
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(cantF, bot1)
        RecibirMensaje(cantP, bot1)
      sino
        si(id = 2)
          RecibirMensaje(cantF, bot2)
          RecibirMensaje(cantP, bot2)
        sino
          si(id = 3)
            RecibirMensaje(cantF, bot3)
            RecibirMensaje(cantP, bot3)
          sino
            si(id = 4)
              RecibirMensaje(cantF, bot4)
              RecibirMensaje(cantP, bot4)
      Informar('robottt',id)
      Informar('flores',cantF)
      Informar('Papeles',cantP)
  fin
variables
  bot1, bot2: recolectorHorizontal
  bot3, bot4:  recolectorVertical
  jefe: coordinador
comenzar
  AsignarArea(bot1, lugar)
  AsignarArea(bot2, lugar)
  AsignarArea(bot3, lugar)
  AsignarArea(bot4, lugar)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(bot4, areaBot4)
  Iniciar(bot1, 20,1)
  Iniciar(bot2, 20,2)
  Iniciar(bot3, 20,4)
  Iniciar(bot4, 20,5)
  Iniciar(jefe, 20,15)
fin