programa arn
procesos
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    EnviarMensaje(4, bot4)
  fin
  proceso calleRandom(ES avRandom: numero; ES caRandom: numero)
  variables
    auxAv, auxCa: numero
  comenzar
    Random(auxAv, 45, 62)
    Random(auxCa, 48, 69)
    avRandom:= auxAv
    caRandom:= auxCa
  fin
  proceso mandarMensajeAlganador(E idMax: numero)  {avisa al que gano}
  comenzar
    si(idMax = 1)
      EnviarMensaje(1, bot1) {1 = ganaste | 2 = perdiste}
      EnviarMensaje(2,bot2)
      EnviarMensaje(2,bot3)
      EnviarMensaje(2,bot4)
    sino
      si(idMax = 2)
        EnviarMensaje(2, bot1) {1 = ganaste | 2 = perdiste}
        EnviarMensaje(1,bot2)
        EnviarMensaje(2,bot3)
        EnviarMensaje(2,bot4)
      sino
        si(idMax = 3)
          EnviarMensaje(2, bot1) {1 = ganaste | 2 = perdiste}
          EnviarMensaje(2,bot2)
          EnviarMensaje(1,bot3)
          EnviarMensaje(2,bot4)
        sino
          EnviarMensaje(2, bot1) {1 = ganaste | 2 = perdiste}
          EnviarMensaje(2,bot2)
          EnviarMensaje(2,bot3)
          EnviarMensaje(1,bot4)
  fin
  proceso  inicializarCantidades(ES bot1Cant: numero;ES bot2Cant: numero;ES bot3Cant: numero;ES bot4Cant: numero)
  comenzar
    bot1Cant:= 0
    bot2Cant:= 0
    bot3Cant:= 0
    bot4Cant:= 0
  fin
  proceso sacarMax(ES idMax: numero; E bot1Cant: numero; E bot2Cant: numero;E bot3Cant: numero; E bot4Cant: numero; ES max: numero)
  comenzar
    max:= bot1Cant
    idMax:= 1
    si(bot2Cant > max)
      max:= bot2Cant
      idMax:= 2
    si(bot3Cant > max)
      max:= bot3Cant
      idMax:= 3
    si(bot4Cant > max)
      max:= bot4Cant
      idMax:= 4
  fin
areas
  areaRecoleccion: AreaPC(45,48,62,69)
  areaBot1: AreaP(10,10,10,10)  {areas default}
  areaBot2: AreaP(11,10,11,10)
  areaBot3: AreaP(12,10,12,10)
  areaBot4: AreaP(13,10,13,10)
  areaJefe: AreaP(1,1,1,1)
robots
  robot  recolector
  variables
    id: numero
    ok: boolean
    avRandom, caRandom: numero
    caIni, avIni: numero
    cantFlores,cantPapeles: numero
    avisoGanador: numero
  comenzar
    RecibirMensaje(id, jefe)
    avIni:= PosAv
    caIni:= PosCa
    cantFlores:= 0
    cantPapeles:= 0
    repetir 5
      calleRandom(avRandom, caRandom)
      {Random(avRandom, 45, 62)}
     {Random(caRandom, 48, 69)}
      EnviarMensaje(id, jefe)
      BloquearEsquina(avRandom, caRandom)
      Pos(avRandom, caRandom)
      mientras(HayFlorEnLaEsquina) | (HayPapelEnLaEsquina)
        ok:= V
        si(HayFlorEnLaEsquina)
          tomarFlor
          cantFlores:= cantFlores+1
          EnviarMensaje(ok, jefe)
        si(HayPapelEnLaEsquina)
          tomarPapel
          cantPapeles:= cantPapeles+1
          EnviarMensaje(ok, jefe)
      ok:= F
      EnviarMensaje(ok, jefe)
      Pos(avIni,caIni)
      LiberarEsquina(avRandom, caRandom)
    EnviarMensaje(0, jefe)               {le aviso que un robot ya termino}
    RecibirMensaje(avisoGanador, jefe)  {avisa si gano}
    si(avisoGanador = 1)
      Informar('Gane',231)
      repetir cantFlores
        depositarFlor
      repetir cantPapeles
        depositarPapel
  fin
  robot  coordinador
  variables
    avRandom, caRandom: numero
    ok: boolean
    contOk: numero
    bot1Cant, bot2Cant, bot3Cant, bot4Cant: numero
    cont4,max,idMax: numero
    id: numero
  comenzar
    asignarIds
    cont4:= 0
    inicializarCantidades(bot1Cant, bot2Cant, bot3Cant, bot4Cant)
    mientras(cont4 < 4)
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(ok, bot1)
        mientras(ok)
          bot1Cant:= bot1Cant+1
          RecibirMensaje(ok, bot1)
      sino
        si(id = 2)
          RecibirMensaje(ok, bot2)
          mientras(ok)
            bot2Cant:= bot2Cant+1
            RecibirMensaje(ok, bot2)
        sino
          si(id = 3)
            RecibirMensaje(ok, bot3)
            mientras(ok)
              bot3Cant:= bot3Cant+1
              RecibirMensaje(ok, bot3)
          sino  {es 4}
            si(id = 4)
              RecibirMensaje(ok, bot4)
              mientras(ok)
                bot4Cant:= bot4Cant+1
                RecibirMensaje(ok, bot4)
            sino
              cont4:= cont4 +1
    sacarMax(idMax,bot1Cant,bot2Cant,bot3Cant,bot4Cant,max)
    mandarMensajeAlganador(idMax)
  fin
variables
  bot1, bot2, bot3, bot4: recolector
  jefe: coordinador
comenzar
  AsignarArea(bot1, areaBot1)  {area default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(bot4, areaBot4)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaRecoleccion)  {area en comun}
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)
  AsignarArea(bot4, areaRecoleccion)
  Iniciar(bot1, 10, 10)
  Iniciar(bot2, 11, 10)
  Iniciar(bot3, 12, 10)
  Iniciar(bot4, 13, 10)
  Iniciar(jefe, 1, 1)
fin