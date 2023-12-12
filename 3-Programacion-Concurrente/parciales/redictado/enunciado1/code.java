programa nahuelArancibia
procesos 
  proceso juntarFlores(ES cantF: numero; E id: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
      Informar('sarasa',id)
      EnviarMensaje(id, jefe)
      Informar('sarasa',id)
  fin
  proceso juntarPapeles(ES cantP: numero; E id: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantP:= cantP+1
      EnviarMensaje(id, jefe)
      Informar('sarasa',id)
  fin
  proceso bloquearPosicionarLiberar(E avRandom: numero; E caRandom: numero;ES cantF: numero; ES cantP: numero;E avIni: numero; E caIni: numero; E id: numero)
  variables
    auxCa,auxAv: numero
    auxIniCa,auxIniAv: numero
  comenzar
    auxCa:= caRandom
    auxAv:= avRandom
    auxIniCa:= caIni
    auxIniAv:= avIni
    BloquearEsquina(auxAv, auxCa)
    Pos(auxAv,auxCa)
    juntarFlores(cantF,id)
    juntarPapeles(cantP,id)
    Pos(auxIniAv,auxIniCa)
    LiberarEsquina(auxAv, auxCa)
  fin
  proceso depositarFlores(ES cantF: numero)
  comenzar
    repetir cantF
      depositarFlor
  fin
  proceso depositarPapeles(ES cantP: numero) {por es para q me queden en 0}
  comenzar
    repetir cantP
      depositarPapel
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    EnviarMensaje(4, bot4)
  fin
  proceso sacarMax(E totalBot1: numero;E totalBot2: numero;E totalBot3: numero;E totalBot4: numero;ES idMax: numero)
  variables
    max: numero
  comenzar
    idMax:= 1
    Informar('sarasaAcaaaaa',idMax)
    max:= totalBot1
    si(max > totalBot2)
      max:= totalBot2
      idMax:= 2
    si(max > totalBot3)
      max:= totalBot3
      idMax:= 3
    si(max > totalBot4)
      max:= 4
      idMax:= 4   
    Informar('sarasaAcaaaaa',idMax)   
  fin
  proceso avisarAlGanador(E idMax: numero)
  comenzar
    si(idMax = 1)
      EnviarMensaje(V, bot1)
      EnviarMensaje(F, bot2)
      EnviarMensaje(F, bot3)
      EnviarMensaje(F, bot4)
    sino
      si(idMax = 2)
        EnviarMensaje(V, bot2)
        EnviarMensaje(F, bot1)
        EnviarMensaje(F, bot3)
        EnviarMensaje(F, bot4)
      sino
        si(idMax = 3)
          EnviarMensaje(V, bot3)
          EnviarMensaje(F, bot1)
          EnviarMensaje(F, bot2)
          EnviarMensaje(F, bot4)
        sino
          EnviarMensaje(V, bot4)
          EnviarMensaje(F, bot1)
          EnviarMensaje(F, bot2)
          EnviarMensaje(F, bot3)
  fin
areas
  areaBot1: AreaP(10,10,10,10)
  areaBot2: AreaP(11,10,11,10)
  areaBot3: AreaP(12,10,12,10)
  areaBot4: AreaP(13,10,13,10)
  areaJefe: AreaP(1,1,1,1)
  areaRecoleccion: AreaPC(45,48,62,69)
robots
  robot recolector
  variables
    avRandom, caRandom: numero
    cantF,cantP,avIni,caIni,id: numero
    gane: boolean
  comenzar 
    cantF:= 0
    cantP:= 0
    avIni:= PosAv
    caIni:= PosCa
    RecibirMensaje(id, jefe)
    repetir 5
      Random(avRandom, 45,62)
      Random(caRandom, 48,69)
      bloquearPosicionarLiberar(avRandom,caRandom,cantF,cantP,avIni,caIni,id)
    EnviarMensaje(0, jefe) {le aviso q termine los intentos}
    RecibirMensaje(gane, jefe)
    si(gane)
      depositarFlores(cantF)
      depositarPapeles(cantP)
  fin
  robot fiscalizador
  variables
    totalBot1: numero
    totalBot2: numero
    totalBot3: numero
    totalBot4: numero
    cant4F: numero
    id,idMax: numero
  comenzar
    asignarIds
    totalBot1:= 0
    totalBot2:= 0
    totalBot3:= 0
    totalBot4:= 0
    cant4F:= 0
    mientras(cant4F < 4)
      RecibirMensaje(id, *)
      si(id = 1)
        totalBot1:= totalBot1+1
      sino
        si(id = 2)
          totalBot2:= totalBot2+1
        sino
          si(id = 3)
            totalBot3:= totalBot3+1
          sino
            si(id = 4)
              totalBot4:= totalBot4+1
            sino
              cant4F:= cant4F+1
              Informar('sarasaTermine',cant4F)
    Informar('casablanca',id)
    sacarMax(totalBot1, totalBot2, totalBot3, totalBot4, idMax)
    avisarAlGanador(idMax)
    Informar('gano',idMax)
  fin
variables
  bot1,bot2, bot3, bot4: recolector
  jefe: fiscalizador
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(bot4, areaBot4)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaRecoleccion)  {area de recoleccion}
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)
  AsignarArea(bot4, areaRecoleccion)
  Iniciar(bot1, 10,10) 
  Iniciar(bot2, 11,10) 
  Iniciar(bot3, 12,10) 
  Iniciar(bot4, 13,10)
  Iniciar(jefe, 1,1)   
fin