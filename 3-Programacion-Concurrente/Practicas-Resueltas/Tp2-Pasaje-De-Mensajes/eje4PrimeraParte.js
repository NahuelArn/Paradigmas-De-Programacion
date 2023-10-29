programa eje4
procesos
  proceso limpiarFlores
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso limpiarPapeles
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin
  proceso calcularEsquina(ES Av: numero; ES Ca: numero)
  variables
    a1: numero
    a2: numero
  comenzar  
    Random(a1, 25,75)
    Random(a2, 25,75)
    Av:= a1
    Ca:= a2
  fin
  proceso quienEntra(ES botX: numero)
  variables
    queRobot: numero
  comenzar
    Random(queRobot, 1,4)
    si(queRobot = 1)
      EnviarMensaje(queRobot, bot1)
      EnviarMensaje(0,bot2)
      EnviarMensaje(0,bot3)
      EnviarMensaje(0,bot4) 
      RecibirMensaje(queRobot, bot1)        
    sino
      si (queRobot= 2)
        EnviarMensaje(queRobot, bot2)
        EnviarMensaje(0, bot1)
        EnviarMensaje(0,bot3)
        EnviarMensaje(0,bot4)
        RecibirMensaje(queRobot, bot2)
      sino 
        si(queRobot= 3)
          EnviarMensaje(queRobot, bot3)
          EnviarMensaje(0, bot1)
          EnviarMensaje(0,bot2)
          EnviarMensaje(0,bot4)
          RecibirMensaje(queRobot, bot3)
        sino
          si(queRobot= 4)
            EnviarMensaje(queRobot, bot4)
            EnviarMensaje(0,bot1)
            EnviarMensaje(0,bot2)
            EnviarMensaje(0,bot3)
            RecibirMensaje(queRobot, bot4)
      botX:= queRobot
  fin
areas
  trabajadores: AreaPC(25,25,75,75)
  state: AreaC(1,1,100,1)
robots
  robot  trabajador
  variables
    ok: numero
    Av: numero
    Ca: numero
    PosInicialAV: numero
    PosInicialCA: numero
  comenzar
    PosInicialAV:= PosAv
    PosInicialCA:= PosCa
    RecibirMensaje(ok, botFiscalizador)
    si (ok <> 0)
      calcularEsquina(Av,Ca)
      Pos(Av,Ca)
      limpiarFlores
      limpiarPapeles
    EnviarMensaje(ok, botFiscalizador)
    Pos(PosInicialAV, PosInicialCA)
  fin
  robot  fiscalizador
  variables
    botX: numero
  comenzar
    quienEntra(botX)
    Informar('TerminoLaLogica',botX)
  fin
variables
  bot1: trabajador
  bot2: trabajador
  bot3: trabajador
  bot4: trabajador
  botFiscalizador: fiscalizador
comenzar
  {lugar donde se mueven}
  AsignarArea(bot1, trabajadores)
  AsignarArea(bot2, trabajadores)
  AsignarArea(bot3, trabajadores)
  AsignarArea(bot4, trabajadores)
  {LugarDeEspera}
  AsignarArea(bot1, state)
  AsignarArea(bot2, state)
  AsignarArea(bot3, state)
  AsignarArea(bot4, state)
  AsignarArea(botFiscalizador, state)
  {Asignando sus posiciones de espera}
  Iniciar(botFiscalizador, 1,1)
  Iniciar(bot1, 25,1)
  Iniciar(bot2, 26,1)
  Iniciar(bot3, 27,1)
  Iniciar(bot4, 28,1)
fin