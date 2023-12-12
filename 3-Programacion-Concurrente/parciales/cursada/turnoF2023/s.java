programa pepe;
procesos 
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1Equipo1)
   { EnviarMensaje(1, bot2Equipo1)}
    EnviarMensaje(2, bot1Equipo2)
   { EnviarMensaje(2, bot2Equipo2)}
  fin
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso movermeJuntando(ES cantF: numero; E nMovimientos: numero)
  comenzar
    repetir nMovimientos
      juntarFlores(cantF)
      mover
    juntarFlores(cantF)
  fin
  proceso quienSigue(E idEquipo: numero; E cantF: numero)
  comenzar
    si(idEquipo = 1)
      EnviarMensaje(idEquipo, bot2Equipo1)
      EnviarMensaje(cantF,bot2Equipo1)
    sino  {soy el equipo 2}
      EnviarMensaje(idEquipo, bot2Equipo2)
      EnviarMensaje(cantF, bot2Equipo2)
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    repetir cantF
      BloquearEsquina(20,20)
      Pos(20,20)
      depositarFlor
      Pos(avIni,caIni)
      LiberarEsquina(20,20)
    cantF:= 0
  fin
  proceso girar(E nVueltas: numero)
  comenzar
    repetir nVueltas
      derecha
  fin
  proceso sacarMax(E id: numero;E total: numero; ES max: numero;ES idMax: numero) 
  comenzar
    si(total > max)
      max:= total
      idMax:= id
  fin
areas
  areaEquipo1: AreaPC(1,1,11,10)
  areaEquipo2: AreaPC(13,1,23,10)
  areaJefe: AreaP(30,1,30,1)
  areaDeposito: AreaC(20,20,20,20)
robots
  robot recolectorInicio
  variables
    cantF,idEquipo: numero
  comenzar
    RecibirMensaje(idEquipo, jefe)
    cantF:= 0
    movermeJuntando(cantF, 9)
    derecha
    movermeJuntando(cantF, 10)
    quienSigue(idEquipo,cantF)
    bloquearDepositarLiberar(cantF)
  fin
  robot recolectorFinal
  variables
    cantF: numero
    idEquipo: numero
    cantFEquipo1,camtFEquipo2,cantFActual: numero
    total: numero
  comenzar
    cantFEquipo1:= 0
    camtFEquipo2:= 0
    total:= 0
    RecibirMensaje(idEquipo, *)
    si(idEquipo = 1)
      RecibirMensaje(cantFActual, bot1Equipo1)
      total:= total+ cantFActual
    sino
      RecibirMensaje(cantFActual, bot1Equipo2)
      total:= total+ cantFActual
    girar(2)
    movermeJuntando(cantF, 8)
    girar(1)  {mira a la izquierda}
    movermeJuntando(cantF, 9)
    EnviarMensaje(idEquipo, jefe)    
    EnviarMensaje(total, jefe)
  fin
  robot coordinador
  variables   
    id,total,idMax,max: numero
  comenzar
    max:= -99
    idMax:= 0
    asignarIds
    repetir 2
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(total,bot2Equipo1)
      sino
        RecibirMensaje(total,bot2Equipo2)
      sacarMax(id, total,max,idMax)  
    si(idMax <> 0)     
      Informar('ElEquipoQueJuntoMasEs',idMax)
      Informar('conUnaCantidadDe', max)
  fin
variables
  bot1Equipo1, bot1Equipo2:recolectorInicio  {directores de orquesta}
  bot2Equipo2, bot2Equipo1:recolectorFinal 
  jefe: coordinador
comenzar
  AsignarArea(bot1Equipo1, areaEquipo1)  {area equipo1}
  AsignarArea(bot2Equipo1, areaEquipo1)  
  AsignarArea(bot1Equipo2, areaEquipo2)  {area equipo 2}
  AsignarArea(bot2Equipo2, areaEquipo2)  
  AsignarArea(bot1Equipo1, areaDeposito)  {area deposito}
  AsignarArea(bot2Equipo1, areaDeposito)  
  AsignarArea(bot1Equipo2, areaDeposito)
  AsignarArea(bot2Equipo2, areaDeposito)  
  AsignarArea(jefe, areaJefe)            {AREA jefe}
  Iniciar(bot1Equipo1, 1,1)  {eqiopo 1 }
  Iniciar(bot2Equipo1, 11,9)
  Iniciar(bot1Equipo2, 13,1)  {eqiopo 2 }
  Iniciar(bot2Equipo2, 23,9)
  Iniciar(jefe, 30,1)
fin