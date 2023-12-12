programa eje5
procesos
  proceso  asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    EnviarMensaje(4, bot4)
  fin
  proceso sacarMax (E id: numero; E posCaFin: numero; ES PosCaMax:numero; ES idMax: numero)
  comenzar
    si(posCaFin > PosCaMax)
      idMax:= id
      PosCaMax:= posCaFin
  fin
areas
  {fuente en comun}
  areaRecoleccion: AreaPC(11,11,11,11)
  {areas default}
  areaBot1: AreaP(4,1,4,100)
  areaBot2: AreaP(6,1,6,100)
  areaBot3: AreaP(8,1,8,100)
  areaBot4: AreaP(10,1,10,100)
  {area default del jefe}
  areaJefe: AreaP(1,1,1,1)
robots
  robot papelero
  variables
    PosAvIni, PosCaIni: numero 
    sigo: boolean  
    id: numero
    canalSeguro: numero  {auxiliar}
    auxDeCalleActual: numero
  comenzar
    sigo:= V
    RecibirMensaje(id, jefe)
    mientras(sigo)  &  (PosCa <> 100)
      PosAvIni:= PosAv
      PosCaIni:= PosCa
      BloquearEsquina(11,11)  {esquina donde recolecto}
      Pos(11,11)
      si(HayFlorEnLaEsquina)
        tomarFlor
        Pos(PosAvIni,PosCaIni)
        LiberarEsquina(11,11)
        depositarFlor
        mover
      sino
        Pos(PosAvIni,PosCaIni)
        sigo:= F
    si(sigo)  {sali porq llegue a mi limite de calles}
      BloquearEsquina(11,11)  {estoy en la calle 100, me falta hacer la logica en esta calle}
      Pos(11,11)
      si(HayFlorEnLaEsquina)
        tomarFlor
        Pos(PosAvIni,PosCaIni)
        depositarFlor
        EnviarMensaje(id, jefe)
        RecibirMensaje(canalSeguro, jefe) {me confirma q llego}
        LiberarEsquina(11,11)  {si libero aca y al procesador se le ocurre dar tiempo al segundo robot, los ids no podrian corresponder} 
        EnviarMensaje(sigo, jefe)  
        EnviarMensaje(PosCa, jefe)   
    sino  {se terminaron las X cosas del area recolectora}    
      Informar('sigo',sigo) 
      EnviarMensaje(id, jefe)
      RecibirMensaje(canalSeguro, jefe) {me confirma q llego}
      LiberarEsquina(11,11)
      Informar('entreAca',0)
      EnviarMensaje(sigo, jefe)
      Informar('entreAca',1)
      auxDeCalleActual:= PosCa   
      EnviarMensaje(auxDeCalleActual, jefe)  
      Informar('entreAca',2)
      {LiberarEsquina(11,11)}
      Informar('entreAca',3)
  fin
  robot  coordinador
  variables
    id: numero
    estado: boolean
    PosCaFin: numero
    PosCaMax: numero
    idMax: numero
  comenzar
    asignarIds    {asigno ids}
    idMax:= -99
    repetir 4
      RecibirMensaje(id, *) {recibo quien es}  
      Informar('id1',id)
      si(id = 1)
        Informar('id2',id)
        EnviarMensaje(1, bot1)  {le mando cualquier valor}
        Informar('id3',id)
        Informar('llegueAcA',22)
        RecibirMensaje(estado, bot1)      
        RecibirMensaje(PosCaFin, bot1)
        sacarMax(id,PosCaFin,PosCaMax, idMax)
      sino
        si(id = 2)
          EnviarMensaje(2, bot2)  {le mando cualquier valor}
          RecibirMensaje(estado, bot2)       {realmente me interesa en que estado quedo??? creo q no}
          RecibirMensaje(PosCaFin, bot2)
          sacarMax(id,PosCaFin,PosCaMax, idMax)
        sino
          si(id = 3)
            EnviarMensaje(3, bot3)  {le mando cualquier valor}
            RecibirMensaje(estado, bot3)     
            RecibirMensaje(PosCaFin, bot3)
            sacarMax(id,PosCaFin,PosCaMax, idMax)
          sino
            si(id = 4)
              EnviarMensaje(4, bot4)  {le mando cualquier valor}
              RecibirMensaje(estado, bot4)     
              RecibirMensaje(PosCaFin, bot4)
              sacarMax(id,PosCaFin,PosCaMax, idMax)
    Informar('elRobotQllegoMasLejosEs',idMax)
  fin
variables  {lugar de aplicacion de logica}
  bot1: papelero
  bot2: papelero
  bot3: papelero
  bot4: papelero
  jefe: coordinador
comenzar
  {area en comun}
  AsignarArea(bot1, areaRecoleccion)
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)
  AsignarArea(bot4, areaRecoleccion)
  {areaDefault}
  AsignarArea(bot1, areaBot1)
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(bot4, areaBot4)
  AsignarArea(jefe, areaJefe)
  {Iniciarlos en sus areas default}
  Iniciar(bot1, 4,1)
  Iniciar(bot2, 6,1)
  Iniciar(bot3, 8,1)
  Iniciar(bot4, 10,1)
  Iniciar(jefe, 1,1)
fin