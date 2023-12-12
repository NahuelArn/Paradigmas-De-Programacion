Ultimo hecho, creo q esta mejor (la parte de ca+1 y controlar depositando lo manejo con cada trabajador, el SERVIDOR NI SE ENTERA) le paso siempre una calle+1 valida

programa arn
procesos
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
  proceso juntarFlores(E cantFpedidas: numero)
  comenzar
    repetir cantFpedidas
      tomarFlor
  fin
  proceso depositandoDeAunaMoviendome (ES cantF: numero; ES ok: boolean)
  comenzar
    mientras(cantF > 0) & (PosCa +1 < 10)
      depositarFlor
      mover
      cantF:= cantF -1
    si(PosCa + 1 = 10)
      mientras(cantF > 0)
        depositarFlor
        cantF:= cantF-1
      mover
  fin
  proceso depositarFlores(ES avRecibida: numero;ES caRecibida: numero;ES cantFpedidas: numero)
  comenzar
    Pos(avRecibida, caRecibida)
    repetir cantFpedidas
      depositarFlor
    Pos(100,100)
  fin
areas
  areaBot1: AreaPC(1,1,1,100)
  areaBot2: AreaPC(2,1,2,100)
  areaBot3: AreaPC(3,1,3,100)
  areaJefe: AreaP(100,100,100,100)
robots
  robot  recolector
  variables
    id, cantFpedidas: numero
    ok: boolean
    aux: numero
    aux2: numero
  comenzar
    RecibirMensaje(id, jefe)
    ok:= V
    mientras(ok)
      Random(cantFpedidas, 1, 4)
      aux:= PosCa+1
      aux2:= PosAv
      si (aux < 11)
        EnviarMensaje(id, jefe)  {manda sus datos}
        EnviarMensaje(aux, jefe)
        EnviarMensaje(aux2, jefe)
        EnviarMensaje(cantFpedidas, jefe)
        RecibirMensaje(ok, jefe)  {me confirma q deposito el jefe}
        mover
        juntarFlores(cantFpedidas)
        Pos(PosAv,PosCa-1)
        depositandoDeAunaMoviendome(cantFpedidas,ok)
      sino
        ok:= F
        EnviarMensaje(4, jefe)
  fin
  robot coordinador
  variables
    caRecibida, avRecibida,cant3,id,cantFpedidas: numero
    ok: boolean
  comenzar
    asignarIds
    cant3 := 0
    ok:= V
    mientras (cant3 < 3)
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(caRecibida, bot1)
        RecibirMensaje(avRecibida, bot1)
        RecibirMensaje(cantFpedidas, bot1)
        depositarFlores(avRecibida,caRecibida,cantFpedidas)
        EnviarMensaje(ok, bot1)
      sino
        si(id = 2) 
          RecibirMensaje(caRecibida, bot2)
          RecibirMensaje(avRecibida, bot2)
          RecibirMensaje(cantFpedidas, bot2)
          depositarFlores(avRecibida,caRecibida,cantFpedidas)
          EnviarMensaje(ok, bot2)
        sino
          si(id = 3)
            RecibirMensaje(caRecibida, bot3)
            RecibirMensaje(avRecibida, bot3)
            RecibirMensaje(cantFpedidas, bot3)
            depositarFlores(avRecibida,caRecibida,cantFpedidas)
            EnviarMensaje(ok, bot3)
          sino
            si(id = 4)
              cant3:= cant3+1
              Informar('cantdd',cant3)
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: coordinador
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(jefe, areaBot1)  {area de trabajo}
  AsignarArea(jefe, areaBot2)
  AsignarArea(jefe, areaBot3)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 2,1)
  Iniciar(bot3 ,3,1)
  Iniciar(jefe, 100,100)
fin