programa arancibiaNahuel
procesos 
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina) & (cantF < 10)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso depositarFlores(ES cantF: numero)
  comenzar
    repetir cantF
      depositarFlor
    cantF:= 0
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero; E avIni: numero; E caIni: numero)
  variables
    ok: boolean
  comenzar
    ok:= V
    BloquearEsquina(10,10)
    Pos(10,10)
    depositarFlores(cantF)
    Pos(avIni, caIni)
    LiberarEsquina(10,10)
    EnviarMensaje(ok, jefe)
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
  fin
  proceso juntarFloresJefe(ES juntarFloresJefe: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      juntarFloresJefe:= juntarFloresJefe+1
  fin
  proceso bloquearJuntarLiberar(ES cantRecolectada: numero)
  comenzar
    BloquearEsquina(10,10)
    Pos(10,10)
    juntarFloresJefe(cantRecolectada)
    Pos(1,5)
    LiberarEsquina(10,10)
  fin
areas
  areaBot1: AreaP(1,3,100,3)
  areaBot2: AreaP(1,4,100,4)
  areaCosechador: AreaP(1,5,1,5)
  areaDeposito: AreaC(10,10,10,10)
robots
  robot  recolector
  variables
    cantPasos: numero
    cantF: numero
    avIni,caIni: numero
    ok: boolean
  comenzar
    derecha
    cantF:= 0
    cantPasos:= 0
    repetir 99
      juntarFlores(cantF)
      avIni:= PosAv
      caIni:= PosCa
      si(cantF = 10)
        bloquearDepositarLiberar(cantF, avIni,caIni)
        cantPasos:= 0
      mover
      cantPasos:= cantPasos+1
      si(cantPasos = 5)
        avIni:= PosAv
        caIni:= PosCa
        bloquearDepositarLiberar(cantF, avIni,caIni)
        cantPasos:= 0
    juntarFlores(cantF)
    si(cantF = 10)
      bloquearDepositarLiberar(cantF, avIni,caIni)
      cantPasos:= 0 
    ok:= F
    EnviarMensaje(ok, jefe)
  fin
  robot  cosechador
  variables
    ok: boolean
    cantRecolectada: numero
  comenzar
    asignarIds
    cantRecolectada:= 0
    RecibirMensaje(ok, *)
    mientras(ok)
      bloquearJuntarLiberar(cantRecolectada)
      RecibirMensaje(ok, *)
    Informar('cantTotal',cantRecolectada)
  fin
variables
  bot1, bot2 : recolector
  jefe: cosechador
comenzar
  AsignarArea(bot1, areaBot1)
  AsignarArea(bot2, areaBot2)
  AsignarArea(jefe, areaCosechador)
  AsignarArea(bot1, areaDeposito)
  AsignarArea(bot2, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 1,3)
  Iniciar(bot2, 1,4)
  Iniciar(jefe, 1,5) 
fin