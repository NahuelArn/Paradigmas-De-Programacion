programa eje4
procesos 
  proceso asignarIds 
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    EnviarMensaje(4, bot4)
  fin
  proceso juntarFlores
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso escucharLosQvanTerminando(ES soyElUltimo: numero)
  variables
    id: numero
    buscandoUltimo: numero
  comenzar
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        buscandoUltimo:= 1
      sino
        si(id = 2)
          buscandoUltimo:= 2
        sino
          si(id = 3)
            buscandoUltimo:= 3
          sino
            buscandoUltimo:= 4
    soyElUltimo:= buscandoUltimo
  fin
  proceso indicarQuienEsElUltimo(ES soyElUltimo: numero)
  comenzar
    si(soyElUltimo = 1)
      EnviarMensaje(1, bot1)  {1 = soy el ultimo}
      EnviarMensaje(2, bot2)  {2 = no era el ultimo}
      EnviarMensaje(2, bot3)
      EnviarMensaje(2, bot4)
    sino
      si(soyElUltimo  = 2)
        EnviarMensaje(1, bot2)
        EnviarMensaje(2, bot1)
        EnviarMensaje(2, bot3)
        EnviarMensaje(2, bot4)
      sino
        si(soyElUltimo = 3)
          EnviarMensaje(2, bot2)
          EnviarMensaje(2, bot1)
          EnviarMensaje(1, bot3)
          EnviarMensaje(2, bot4)
        sino
          EnviarMensaje(2, bot2)
          EnviarMensaje(2, bot1)
          EnviarMensaje(2, bot3)
          EnviarMensaje(1, bot4)
  fin
areas
  areaRecolectar: AreaPC(10,10,11,11)  {lugar para los recolectores}
  areaDefaultBot1: AreaPC(9,9,9,9)
  areaDefaultBot2: AreaPC(9,10,9,10)
  areaDefaultBot3: AreaPC(9,11,9,11)
  areaDefaultBot4: AreaPC(9,12,9,12) 
  areaCoordinador: AreaP(1,1,1,1)  {lugar del jefe}
robots
  robot  recolector
  variables
    id: numero
    posAvIni, posCaIni: numero
    sigo: boolean
    queHago: numero
  comenzar
    sigo:= V
    RecibirMensaje(id, jefe)  {recibo el identificador}
    posAvIni:= PosAv
    posCaIni:= PosCa
    mientras(sigo)
      BloquearEsquina(10,10)  {antes de llegar a la esquina de recoleccion la bloqueo}
      Pos(10,10)
      si(HayFlorEnLaEsquina)
        tomarFlor
        Pos(posAvIni,posCaIni) 
        LiberarEsquina(10,10)
        BloqueoEsquina(11,11)
        depositarFlor
        Pos(posAvIni,posCaIni) 
        LiberarEsquina(11,11)
      sino
        Pos(posAvIni,posCaIni)
        LiberarEsquina(10,10)
        sigo:= F
    EnviarMensaje(id, jefe) {aviso quien soy y q finalice}
    RecibirMensaje(queHago, jefe)  {1: soy el ultimo; 2: no era el ultimo}
    si(queHago = 1)
      Pos(11,11)
      juntarFlores
    {sino, no hago nada}
  fin
  robot  coordinador
  variables
    soyElUltimo: numero
  comenzar
    asignarIds  {le manda a los 4 robots sus ids}
    escucharLosQvanTerminando(soyElUltimo)
    indicarQuienEsElUltimo(soyElUltimo)
    Informar('ElUltimoEs',soyElUltimo)
  fin
variables
  bot1, bot2, bot3, bot4: recolector
  jefe: coordinador
comenzar
  {asignando areas donde van a recolectar}
  AsignarArea(bot1, areaRecolectar)
  AsignarArea(bot2, areaRecolectar)
  AsignarArea(bot3, areaRecolectar)
  AsignarArea(bot4, areaRecolectar)
  {asignando area default}
  AsignarArea(bot1, areaDefaultBot1)
  AsignarArea(bot2, areaDefaultBot2)
  AsignarArea(bot3, areaDefaultBot3)
  AsignarArea(bot4, areaDefaultBot4)
  AsignarArea(jefe, areaCoordinador)
  {iniciando en sus lugares}
  Iniciar(bot1, 9,9)
  Iniciar(bot2, 9,10)
  Iniciar(bot3, 9,11)
  Iniciar(bot4, 9,12)
  Iniciar(jefe, 1,1)
fin