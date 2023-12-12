V0
programa eje4
procesos
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF +1
  fin
  proceso bloquearJuntarLiberar(E avRecibida: numero; E caRecibida:  numero; ES cantF: numero; E avIni: numero;E caIni: numero)
  comenzar
    BloquearEsquina(avRecibida,caRecibida)
    Pos(avRecibida,caRecibida)
    juntarFlores(cantF)
    Pos(avIni, caIni)
    LiberarEsquina(avRecibida,caRecibida)
  fin
  proceso depositarFlores(ES  cantF: numero)
  comenzar
    repetir cantF
      depositarFlor
    cantF:= 0
  fin
  proceso bloquearDepositarLiberar(E avIni: numero; E caIni: numero; ES cantF: numero)
  comenzar
    BloquearEsquina(10,10)
    Pos(10,10)
    depositarFlores(cantF)
    Pos(avIni, caIni)
    LiberarEsquina(10,10)
  fin
areas
  areaRecoleccion: AreaPC(40,40,60,60)
  areaBot1: AreaP(1,1,1,1)
  areaBot2: AreaP(2,1,2,1)
  areaBot3: AreaP(3,1,3,1)
  areaFiscalizador: AreaP(4,1,4,1)
  areaDeposito: AreaC(10,10,10,10)
robots
  robot  recolector
  variables
    cantF, id: numero
    sigo: boolean
    avRecibida, caRecibida: numero
    avIni, caIni: numero
    ok: boolean
  comenzar
    cantF:= 0
    avIni:= PosAv
    caIni:= PosCa
    RecibirMensaje(avRecibida, jefe)
    mientras(avRecibida <> 0)
      RecibirMensaje(caRecibida, jefe)
      bloquearJuntarLiberar(avRecibida,caRecibida,cantF,avIni,caIni)
      RecibirMensaje(avRecibida, jefe)
    bloquearDepositarLiberar(avIni,caIni,cantF)
    EnviarMensaje(ok, jefe)
  fin
  robot  fiscalizador
  variables
    id: numero
    botRandom: numero
    avRandom,cantFtotal, caRandom: numero
    ok: boolean
  comenzar
    cantFtotal:= 0
    botRandom:= 1
    repetir 8
      {Random(botRandom, 1, 3)}
      Random(avRandom, 40, 60)
      Random(caRandom, 40, 60)
      si(botRandom = 1)
        EnviarMensaje(avRandom, bot1)
        EnviarMensaje(caRandom, bot1)
      sino
        si(botRandom = 2)
          EnviarMensaje(avRandom, bot2)
          EnviarMensaje(caRandom, bot2)
        sino
          si(botRandom = 3)
            EnviarMensaje(avRandom, bot3)
            EnviarMensaje(caRandom, bot3)
    EnviarMensaje(0, bot1)
    EnviarMensaje(0, bot2)
    EnviarMensaje(0, bot3)
    repetir 3
      RecibirMensaje(ok, *)
    Pos(10,10)  {no tengo peligro de colision, porq los 3 robots ya terminaron}
    juntarFlores(cantFtotal)
    Pos(4,1)
    Informar('totalFjuntadas',cantFtotal)
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: fiscalizador
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaFiscalizador)
  AsignarArea(bot1, areaRecoleccion)  {area de trabajo}
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)
  AsignarArea(bot1, areaDeposito)  {area de deposito}
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 2,1)
  Iniciar(bot3, 3,1)
  Iniciar(jefe, 4,1)
fin



V1

programa eje4
procesos
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso bloquearJuntarLiberar(ES cantF: numero; E avR: numero; E caR: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    BloquearEsquina(avR,caR)
    Pos(avR,caR)
    juntarFlores(cantF)
    Pos(avIni,caIni)
    LiberarEsquina(avR,caR)
  fin
  proceso depositarFlores(ES cantF: numero)
  comenzar
    repetir cantF
      depositarFlor
    cantF:= 0
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    BloquearEsquina(10,10)
    Pos(10,10)
    depositarFlores(cantF)
    Pos(avIni,caIni)
    LiberarEsquina(10,10)
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
areas  
  areaBot1: AreaP(1,1,1,1)
  areaBot2: AreaP(2,1,2,1)
  areaBot3: AreaP(3,1,3,1)
  areaRecoleccion: AreaPC(40,40,60,60)
  areaDeposito: AreaC(10,10,10,10)
  areaJefe: AreaP(4,1,4,1)
robots
  robot  recolector
  variables
    id,avR,caR,cantF: numero
  comenzar
    cantF:= 0
    RecibirMensaje(id, jefe)
    RecibirMensaje(avR, jefe)
    mientras(avR <> 0)
      RecibirMensaje(caR, jefe)
      bloquearJuntarLiberar(cantF,avR,caR)
      RecibirMensaje(avR, jefe)
    EnviarMensaje(cantF, jefe)
    si(cantF > 0)
      bloquearDepositarLiberar(cantF)
  fin
  robot coordinador
  variables
    idRandom: numero
    avR,caR,cantF,total: numero
  comenzar
    total:= 0
    asignarIds
    repetir 8
      Random(idRandom,1,3)
      Random(avR, 40,60)
      Random(caR, 40,60)
      si(idRandom = 1)
        EnviarMensaje(avR, bot1)
        EnviarMensaje(caR, bot1)
      sino
        si(idRandom = 2)
          EnviarMensaje(avR, bot2)
          EnviarMensaje(caR, bot2)
        sino  {es el bot3}
          EnviarMensaje(avR, bot3)
          EnviarMensaje(caR, bot3)
    EnviarMensaje(0, bot1)
    EnviarMensaje(0, bot2)
    EnviarMensaje(0, bot3)
    repetir 3
      RecibirMensaje(cantF, *)
      total:= total+ cantF
    Informar('LaCantidadToltaDeFloresEs',total)  
  fin
variables
  bot1, bot2 bot3: recolector
  jefe: coordinador
comenzar
  AsignarArea(bot1, areaBot1)  {area default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaRecoleccion)  {area recoleccion}
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)
  AsignarArea(bot1, areaDeposito)  {area deposito}
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 2,1)
  Iniciar(bot3, 3,1)
  Iniciar(jefe, 4,1)
fin