programa  arancibiNahuel
procesos
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    EnviarMensaje(4, bot4)
  fin
  proceso empiecen
  variables
    ok: boolean
  comenzar
    EnviarMensaje(ok, bot1)
    EnviarMensaje(ok, bot2)
    EnviarMensaje(ok, bot3)
    EnviarMensaje(ok, bot4)
  fin
  proceso verificarSigano(E id: numero; E cantF: numero)
  comenzar
    si(cantF = 0)
      EnviarMensaje(id, jefe)
      RecibirMensaje(id, jefe)
  fin
  proceso bloquearDepositarLiberar(E avIni: numero;E caIni: numero; ES cantF: numero; E id: numero)
  comenzar
    BloquearEsquina(35,50)
    Pos(35,50)
    depositarFlor
    cantF:= cantF-1
    verificarSigano(id,cantF)
    Pos(avIni, caIni)
    LiberarEsquina(35,50)
  fin
areas
  areaJefe: AreaP(1,1,1,1)
  areaBot1: AreaP(3,1,3,29)
  areaBot2: AreaP(5,1,5,29)
  areaBot3: AreaP(7,1,7,29)
  areaBot4: AreaP(9,1,9,29)
  areaEnComun: AreaPC(3,30,15,45)
  {areaEnComun2: AreaPC(3,45,15,45)}
  esquinaDeposito: AreaPC(35,50,35,50)
robots
  robot  corredor
  variables
    cantPasos, cantF: numero
    avIni,caIni,id: numero
    ok: boolean
  comenzar
    RecibirMensaje(id, jefe)
    cantF:= 0
    mientras(PosCa < 30)
      Random(cantPasos, 1,5)
      juntarFlores(cantF)
      mover
    avIni:= PosAv
    caIni:= PosCa
    EnviarMensaje(ok, jefe)
    RecibirMensaje(ok, jefe)
    si(cantF <> 0)
      mientras (cantF > 0)    
        bloquearDepositarLiberar(avIni,caIni,cantF,id)
    sino
      Informar('ningunOgano',0)
      EnviarMensaje(0, jefe)
  fin
  robot  fiscalizador
  variables
    ok: boolean
    primerGanador,id: numero
  comenzar
    primerGanador:= 0
    asignarIds
    repetir 4
      RecibirMensaje(ok, *)
    empiecen
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        EnviarMensaje(id, bot1)
      sino    
        si(id = 2)
          EnviarMensaje(id, bot2)
        sino
          si(id = 3)
            EnviarMensaje(id, bot3)
          sino
            si(id = 4)
              EnviarMensaje(id, bot4)
            sino
              id:= 0
              Informar('sarasa',1)
      si(id <> 0)
        primerGanador:= primerGanador+1    
        si(primerGanador = 1)
          Informar('ganoElBot',id)    
  fin
variables
  bot1, bot2, bot3, bot4: corredor
  jefe: fiscalizador
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(bot4, areaBot4)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaEnComun)  {areas en comun}
  AsignarArea(bot2, areaEnComun)
  AsignarArea(bot3, areaEnComun)
  AsignarArea(bot4, areaEnComun)
  AsignarArea(bot1, esquinaDeposito)  {areas deposito}
  AsignarArea(bot2, esquinaDeposito)
  AsignarArea(bot3, esquinaDeposito)
  AsignarArea(bot4, esquinaDeposito)
  Iniciar(bot1, 3,1)
  Iniciar(bot2, 5,1)
  Iniciar(bot3, 7,1)
  Iniciar(bot4, 9,1)
  Iniciar(jefe, 1,1)
fin