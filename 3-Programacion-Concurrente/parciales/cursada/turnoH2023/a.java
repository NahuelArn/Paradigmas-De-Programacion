programa theLastDance
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
      cantF:= cantF+1
  fin
  proceso bloquearJuntarLiberar(ES cantF: numero; E avR: numero; E caR: numero)
  variables
    avIni,caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    BloquearEsquina(avR,caR)
    Pos(avR,caR)
    juntarFlores(cantF)
    Pos(avIni,caIni)
    LiberarEsquina(avR,caR)
  fin
  proceso calcularRandoms(ES avR: numero;ES caR: numero)
  variables
    a,b: numero
  comenzar
    Random(a, 10,30)
    Random(b, 10,30)
    avR:= a
    caR:= b
  fin
areas
  areaRecoleccion: AreaPC(10,10,30,30)
  areaBot1: AreaP(1,1,1,1)
  areaBot2: AreaP(2,1,2,1)
  areaBot3: AreaP(3,1,3,1)
  areaJefe: AreaP(9,9,9,9)
robots
  robot recolector
  variables
    cantEntradas,id,cantF: numero
    cantEntradasTotal,avR,caR: numero
    espera: boolean
  comenzar
    cantF:= 0
    Random(cantEntradas,2,5)
    cantEntradasTotal:= cantEntradas
    RecibirMensaje(id, jefe)
    mientras(cantEntradas > 0)
      EnviarMensaje(id, jefe)
      RecibirMensaje(avR, jefe)
      RecibirMensaje(caR, jefe)
      bloquearJuntarLiberar(cantF,avR,caR)
      cantEntradas:= cantEntradas -1
    EnviarMensaje(0, jefe)
    RecibirMensaje(espera, jefe)
    EnviarMensaje(cantEntradasTotal, jefe)
  fin
  robot coordinador
  variables
    cont,avR,caR,cantEntradasTotal,id: numero
    suma: numero
  comenzar
    asignarIds
    cont:= 0
    suma:= 0
    mientras(cont < 3)
      RecibirMensaje(id, *)
      calcularRandoms(avR,caR)
      si(id = 1)
        EnviarMensaje(avR, bot1)
        EnviarMensaje(caR, bot1)
      sino
        si(id = 2)
          EnviarMensaje(avR, bot2)
          EnviarMensaje(caR, bot2)
        sino
          si(id = 3)
            EnviarMensaje(avR, bot3)
            EnviarMensaje(caR, bot3)
          sino
            cont := cont +1
    EnviarMensaje(F, bot1)
    EnviarMensaje(F, bot2)
    EnviarMensaje(F, bot3)
    repetir 3
      RecibirMensaje(cantEntradasTotal, *)
      suma:= suma + cantEntradasTotal
    Informar('intentosTotal',suma)
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: coordinador
comenzar
  AsignarArea(bot1, areaBot1)  {area default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaRecoleccion)  {area default}
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 2,1)
  Iniciar(bot3, 3,1)
  Iniciar(jefe, 9,9)
fin