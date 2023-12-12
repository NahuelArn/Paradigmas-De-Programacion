programa eje1
procesos
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso bloquerMoverLiberar(ES cantF:numero)
  comenzar
    BloquearEsquina(PosAv,PosCa+1)
    mover
    juntarFlores(cantF)
    BloquearEsquina(PosAv,PosCa+1)
    mover
    LiberarEsquina(PosAv,PosCa-1) 
    juntarFlores(cantF) 
    mover  
    LiberarEsquina(PosAv,PosCa-1)
  fin
  proceso bloquearMoverLiberar2(ES cantF: numero)
  comenzar
    BloquearEsquina(PosAv+1,PosCa)
    mover
    juntarFlores(cantF)
    BloquearEsquina(PosAv+1, PosCa)
    mover
    LiberarEsquina(PosAv-1,PosCa)
    juntarFlores(cantF)
    mover
    LiberarEsquina(PosAv-1,PosCa)
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1Equipo1)
    EnviarMensaje(2, bot2Equipo1)
    EnviarMensaje(3, bot1Equipo2)
    EnviarMensaje(4, bot2Equipo2)
  fin
areas
  areaBot1Equipo1: AreaP(2,1,2,97)
  areaBot2Equipo1: AreaP(3,1,3,97)
  areaBot1Equipo1FT: AreaP(2,100,2,100)
  areaBot2Equipo1FT: AreaP(3,100,3,100)
  areaProblematica: AreaPC(2,98,3,99)
  areaBot1Equipo2: AreaP(4,98,100,98)  {equibo 2}
  areaBot2Equipo2: AreaP(4,99,100,99)
  areaBot1Equipo2FT: AreaP(1,98,1,98)
  areaBot2Equipo2FT: AreaP(1,99,1,99)
  areaJefe: AreaP(1,1,1,1)
robots
  robot  recolectorEquipo1  {vertical}
  variables
    cantF,id: numero
  comenzar
    cantF:= 0
    RecibirMensaje(id, jefe)
    repetir 96
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
    bloquerMoverLiberar(cantF)
    juntarFlores(cantF)
    EnviarMensaje(id, jefe)
    EnviarMensaje(cantF,jefe)
  fin
  robot  recolectorEquipo2  {Horizontal}
  variables
    cantF,id: numero
  comenzar
    cantF:= 0
    RecibirMensaje(id, jefe)
    derecha
    juntarFlores(cantF)
    bloquearMoverLiberar2(cantF)
    juntarFlores(cantF)
    repetir 95
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
    EnviarMensaje(id, jefe)
    EnviarMensaje(cantF,jefe)
  fin
  robot coordinador
  variables
    id: numero
    cant: numero
    equipo1, equipo2: numero
  comenzar
    asignarIds
    equipo1:= 0
    equipo2:= 0
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(cant,bot1Equipo1)
        equipo1:= equipo1+ cant
      sino
        si(id = 2)
          RecibirMensaje(cant,bot2Equipo1)
          equipo1:= equipo1+ cant
        sino
          si(id = 3)
            RecibirMensaje(cant, bot1Equipo2)
            equipo2:= equipo2+ cant
          sino
            si(id = 4)
              RecibirMensaje(cant, bot2Equipo2)
              equipo2:= equipo2+ cant
    si(equipo2 > equipo1)
      Informar('ganoElEquipo2',0)
    sino
      Informar('ganoElEquipo1',0)
  fin
variables
  bot1Equipo1, bot2Equipo1: recolectorEquipo1 {vertical}
  bot1Equipo2, bot2Equipo2: recolectorEquipo2  {Horizontal}
  jefe: coordinador
comenzar
  AsignarArea(bot1Equipo1, areaBot1Equipo1)  {areasDefault Vertical}
  AsignarArea(bot1Equipo1,areaBot1Equipo1FT)
  AsignarArea(bot2Equipo1, areaBot2Equipo1)
  AsignarArea(bot2Equipo1, areaBot2Equipo1FT)
  AsignarArea(bot1Equipo2, areaBot1Equipo2)  {areasDefault Horizontal}
  AsignarArea(bot1Equipo2,areaBot1Equipo2FT)
  AsignarArea(bot2Equipo2, areaBot2Equipo2)
  AsignarArea(bot2Equipo2, areaBot2Equipo2FT)
  AsignarArea(bot1Equipo1, areaProblematica)  {areasDefault Compartida}
  AsignarArea(bot2Equipo1, areaProblematica)
  AsignarArea(bot1Equipo2, areaProblematica)  
  AsignarArea(bot2Equipo2, areaProblematica)
  AsignarArea(jefe, areaJefe)
  Iniciar(bot1Equipo1, 2,1)  {vertical}
  Iniciar(bot2Equipo1, 3,1)
  Iniciar(bot1Equipo2, 1,98)  {horizontal}
  Iniciar(bot2Equipo2, 1,99)
  Iniciar(jefe, 1,1)
fin