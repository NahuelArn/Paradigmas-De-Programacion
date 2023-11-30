programa eje3
procesos 
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras((HayFlorEnLaEsquina) & (cantF < 10))
      tomarFlor
      cantF:= cantF+1
  fin
  proceso depositarFlores(ES cantF: numero)
  comenzar
    repetir cantF
      depositarFlor
    {cantF:= 0 ya lo reseteo abajo}
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero)
  variables
    avIni,caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    BloquearEsquina(10,10)
    Pos(10,10)
    depositarFlores(cantF)
    Pos(avIni,caIni)
    LiberarEsquina(10,10)
  fin
  proceso juntarFlores2(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso bloquearJuntarLiberar(ES cantF: numero)
  comenzar
    BloquearEsquina(10,10)
    Pos(10,10)
    juntarFlores2(cantF)
    Pos(1,5)
    LiberarEsquina(10,10)
  fin
areas
  areaBot1: AreaP(1,3,100,3)
  areaBot2: AreaP(1,4,100,4)
  areaJefe: AreaP(1,5,1,5)
  areaDeposito: AreaC(10,10,10,10)
robots
  robot  recolector
  variables
    cantF: numero
    cantPasos: numero
  comenzar
    cantF:= 0
    cantPasos:= 0
    derecha
    repetir 99
      juntarFlores(cantF)
      si(cantF = 10) | (cantPasos= 5) 
        bloquearDepositarLiberar(cantF)
        EnviarMensaje(V, jefe)
        cantF:= 0
        cantPasos:= 0
      mover
      cantPasos:= cantPasos+1
    juntarFlores(cantF)
    si(cantF = 10) | (cantPasos= 5) 
      bloquearDepositarLiberar(cantF)
      EnviarMensaje(V, jefe)
      cantF:= 0
      cantPasos:= 0
      mover
      cantPasos:= cantPasos+1
    EnviarMensaje(F, jefe)
  fin
  robot  coordinador
  variables
    sigo: boolean
    cantF: numero
  comenzar
    cantF:= 0
    RecibirMensaje(sigo, *)
    mientras(sigo)
      bloquearJuntarLiberar(cantF)
      RecibirMensaje(sigo, *)
    Informar('LaCantidadDeFloresJuntadasEs',cantF)
  fin
variables
  bot1, bot2: recolector
  jefe: coordinador
comenzar
  AsignarArea(bot1,areaBot1)  {area default}
  AsignarArea(bot2,areaBot2)
  AsignarArea(jefe,areaJefe)
  AsignarArea(bot1,areaDeposito)  {area deposito}
  AsignarArea(bot2,areaDeposito)
  AsignarArea(jefe,areaDeposito)
  Iniciar(bot1, 1,3)
  Iniciar(bot2, 1,4)
  Iniciar(jefe, 1,5)
fin