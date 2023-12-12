programa arn
procesos
  proceso enviarTamanhos
  variables
    alto, ancho: numero
  comenzar
    Random(alto, 2,11)  {AAA}
    Random(ancho, 4,6)
    EnviarMensaje(alto, bot1)
    EnviarMensaje(ancho, bot1)
    Random(alto, 2,11)  {BBBB}
    Random(ancho, 4,6)
    EnviarMensaje(alto, bot2)
    EnviarMensaje(ancho, bot2)
    Random(alto, 2,11)  {CCCC}
    Random(ancho, 4,6)
    EnviarMensaje(alto, bot3)
    EnviarMensaje(ancho, bot3)
  fin
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    repetir cantF
      BloquearEsquina(25,25)
      Pos(25,25)
      depositarFlor
      Pos(avIni,caIni)
      LiberarEsquina(25,25)
    cantF:= 0
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
  proceso sacarMax(E id: numero;ES idMax: numero;ES max: numero; E totalFlores: numero)
  comenzar
    si(totalFlores > max)
      max:= totalFlores
      idMax:= id
  fin
areas
  areaBot1: AreaP(1,1,6,11)
  areaBot2: AreaP(7,1,12,11)
  areaBot3: AreaP(13,1,18,11)
  areaDeposito: AreaPC(25,25,25,25)
  areaJefe: AreaP(24,24,24,24)
robots
  robot recolector
  variables
    alto, ancho,cantF: numero
    totalFlores, id: numero
  comenzar
    RecibirMensaje(id, jefe)
    RecibirMensaje(alto, jefe)
    RecibirMensaje(ancho, jefe)
    cantF:= 0
    totalFlores:= 0
    repetir 2
      repetir alto-1
        mover
        juntarFlores(cantF)
      juntarFlores(cantF)
      totalFlores:= totalFlores+ cantF
      bloquearDepositarLiberar(cantF)
      derecha
      repetir ancho-1
        mover
        juntarFlores(cantF)
      juntarFlores(cantF)
      totalFlores:= totalFlores+ cantF
      bloquearDepositarLiberar(cantF)
      derecha
    EnviarMensaje(id, jefe)
    Informar('totalFloress',totalFlores)
    EnviarMensaje(totalFlores, jefe)
  fin
  robot coordinador
  variables
    id: numero
    max, totalFlores, idMax:numero
  comenzar
    max:= -99
    idMax:= -1
    asignarIds
    enviarTamanhos
    repetir 3
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(totalFlores, bot1)
      sino
        si(id = 2)
          RecibirMensaje(totalFlores, bot2)
        sino
          RecibirMensaje(totalFlores, bot3)
      sacarMax(id, idMax, max,totalFlores)
      {Informar('EntreAca',22) }
    {si(idMax <> (-1)) }   
    Informar('elBotGanadorEs',idMax)   
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: coordinador
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaDeposito)  {area deposto}
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  Iniciar(bot1,1,1)
  Iniciar(bot2,7,1)
  Iniciar(bot3,13,1)
  Iniciar(jefe,24,24)
fin