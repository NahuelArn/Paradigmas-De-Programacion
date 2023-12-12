programa eje3
procesos
  proceso asignarIds
  comenzar
    EnviarMensaje(1,bot1)
    EnviarMensaje(2,bot2)
    EnviarMensaje(3,bot3)
    EnviarMensaje(4,bot4)
  fin
  proceso sortearPos(ES AvElegida: numero; ES CaElegida: numero)
  variables
    auxAv, auxCa: numero
  comenzar
    Random(auxAv, 2,10)
    Random(auxCa, 2,10)
    AvElegida:= auxAv
    CaElegida:= auxCa
  fin
  proceso avisarQuePosSalio(ES AvElegida: numero; ES CaElegida: numero)
  comenzar
    EnviarMensaje(AvElegida, bot1)  {bot1}
    EnviarMensaje(CaElegida, bot1)
    EnviarMensaje(AvElegida, bot2)  {bot2}
    EnviarMensaje(CaElegida, bot2)
    EnviarMensaje(AvElegida, bot3)  {bot3]
    EnviarMensaje(CaElegida, bot3)
    EnviarMensaje(AvElegida, bot4)  {bot4}
    EnviarMensaje(CaElegida, bot4)
  fin
  proceso quienEsYsuCantidad(E id: numero; ES cantRecolectada: numero)
  comenzar
    si(id = 1)
      RecibirMensaje(cantRecolectada, bot1)
    sino
      si(id = 2)
        RecibirMensaje(cantRecolectada, bot2)
      sino
        si(id = 3)
          RecibirMensaje(cantRecolectada, bot3)
        sino
          si(id = 4)
            RecibirMensaje(cantRecolectada, bot4)
  fin
  proceso sacarMejorRecolector(ES max: numero; ES idMejorRecolector: numero; E id: numero; E cantRecolectada)
  comenzar
    si(cantRecolectada > max)
      max:= cantRecolectada
      idMejorRecolector:= id
  fin
  proceso escucharLosqTerminaron(ES idMejorRecolector: numero)
  variables
    id: numero
    cantRecolectada: numero
    max: numero
  comenzar
    max:= -99
    repetir 4
      RecibirMensaje(id, *)
      quienEsYsuCantidad(id,cantRecolectada)
      sacarMejorRecolector(max, idMejorRecolector, id,cantRecolectada)
  fin
areas
  areaRecoleccion: AreaPC(2,2,10,10)  {donde van a recolectar los 4 bots}
  {lugaresDefault}
  areaJefe: AreaP(1,1,1,1)  {area jefe}
  areaBot1: AreaP(2,1,2,1)  {areas recolectores}
  areaBot2: AreaP(3,1,3,1)
  areaBot3: AreaP(4,1,4,1)
  areaBot4: AreaP(5,1,5,1)
robots
  robot  recolector
  variables
    id: numero
    AvElegida, CaElegida: numero
    sigo: boolean
    cantVecesJunte: numero
    PosAvIni,PosCaIni: numero
  comenzar
    sigo:= V
    cantVecesJunte:= 0
    PosAvIni:= PosAv
    PosCaIni:= PosCa
    RecibirMensaje(id, jefe) {recibo mi identificador}
    RecibirMensaje(AvElegida, jefe)  {recibo la pos donde voy a recolectar}
    RecibirMensaje(CaElegida, jefe)
    {en este punto se Que identificador tengo y en que Pos tengo q recolectar}
    mientras(sigo)
      BloquearEsquina(AvElegida, CaElegida)  {bloqueo antes de mandarme a zona Conflictiva}
      Pos(AvElegida, CaElegida)
      si (HayFlorEnLaEsquina)
        tomarFlor
        cantVecesJunte:= cantVecesJunte+1
      sino
        sigo:= F
      Pos(PosAvIni, PosCaIni)            {me pongo safe}
      LiberarEsquina(AvElegida,CaElegida)  {ya sali y dejo q otro entre a la zona conflictiva}
    {sali, se terminaron las flores, en la esquina}
    EnviarMensaje(id, jefe)  {le aviso quien soy}
    EnviarMensaje(cantVecesJunte, jefe)  {le digo la cantidad que junte}
  fin
  robot  coordinador
  variables
    AvElegida, CaElegida: numero
    idMejorRecolector: numero
  comenzar
    asignarIds
    sortearPos(AvElegida,CaElegida)  {elijo la pos Random}
    avisarQuePosSalio(AvElegida, CaElegida)    {hago q se enteren todos los bots en q Pos van a recolectar}
    escucharLosqTerminaron  (idMejorRecolector){recibe id y cant de cada robot y devuelve el id del bot q junto mas}
    si(idMejorRecolector = -99)
      Informar('NoHuboMejorRecolector',0)
    sino
      Informar('EsteRobotJuntoMas',idMejorRecolector)
  fin
robot
  bot1,bot2,bot3,bot4,: recolector
  jefe: coordinador
comenzar
  {area de recoleccion}
  AsignarArea(bot1, areaRecoleccion)
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)  
  AsignarArea(bot4, areaRecoleccion)
  {areas default}
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaBot1)
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)  
  AsignarArea(bot4, areaBot4)
  {setearlos en sus lugares}
  Iniciar(jefe, 1,1)
  Iniciar(bot1, 2,1)  
  Iniciar(bot2, 3,1)
  Iniciar(bot3, 4,1)
  Iniciar(bot4, 5,1)
fin