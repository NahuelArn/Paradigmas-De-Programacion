programa eje2
procesos 
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso depositarFlores(ES cantF: numero)
  comenzar
    repetir cantF
      depositarFlor
    cantF:= 0
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero)
  variables
    avIni,caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    BloquearEsquina(50,50)
    Pos(50,50)
    depositarFlores(cantF)
    Pos(avIni,caIni)
    LiberarEsquina(50,50)
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
  proceso sincronizar(E id: numero)
  variables
    ok: boolean
  comenzar
    si(id = 1)
      EnviarMensaje(V, bot2)
      EnviarMensaje(V, bot3)
      RecibirMensaje(ok,bot2)
      RecibirMensaje(ok,bot3)
    sino
      si(id = 2)
        EnviarMensaje(V, bot1)
        EnviarMensaje(V, bot3)
        RecibirMensaje(ok,bot1)
        RecibirMensaje(ok,bot3)
      sino  {es el 3}
        EnviarMensaje(V, bot1)
        EnviarMensaje(V, bot2)
        RecibirMensaje(ok,bot1)
        RecibirMensaje(ok,bot2)
  fin
areas
  areaBot1: AreaP(1,1,100,1)
  areaBot2: AreaP(1,2,100,2)
  areaBot3: AreaP(1,3,100,3)
  areaJefe: AreaP(1,4,1,4)
  areaDeposito: AreaC(50,50,50,50)
robots
  robot  recolector
  variables
    cantF: numero
    cont,id: numero
  comenzar
    cantF:= 0
    cont:= 0
    derecha
    RecibirMensaje(id, jefe)
    repetir 10
      si(cont = 2)
        cont:= 1
      repetir 9 + cont
        juntarFlores(cantF)
        mover
      juntarFlores(cantF)
      bloquearDepositarLiberar(cantF)
      sincronizar(id)  
      cont:= cont+1  
    EnviarMensaje(V,jefe)
  fin
  robot  coordinador
  variables
    ok: boolean
    cantF: numero
  comenzar
    cantF:= 0
    asignarIds
    repetir 3
      RecibirMensaje(ok, *)
    Pos(50,50)
    juntarFlores(cantF)
    Pos(1,4)
    Informar('LaCantidadTotalDeFloresEs',cantF)
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: coordinador
comenzar  
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaDeposito)  {areaDeposito}
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 1,2)
  Iniciar(bot3, 1,3)
  Iniciar(jefe, 1,4)
fin











//Variacion Ajustar el tema de la sincronizacion, que estaria mal por el desfasaje, despues bien, quedarme con el de arriba q esta bien
programa nahuelArn
procesos   
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso depositarFlores(ES cantF: numero)
  comenzar
    repetir cantF
      depositarFlor
    cantF:= 0
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero;E avIni: numero;E caIni: numero)
  comenzar
    BloquearEsquina(50,50)
    Pos(50,50)
    depositarFlores(cantF)
    Pos(avIni, caIni)
    LiberarEsquina(50,50)
  fin
  proceso sincronizar(E id: numero)
  variables
    ok: boolean
  comenzar
    si(id = 1)
      EnviarMensaje(ok, bot2)
      EnviarMensaje(ok, bot3)
    sino
      si(id = 2)
        EnviarMensaje(ok, bot1)
        EnviarMensaje(ok, bot3)
      sino  {soy el 3}
        EnviarMensaje(ok, bot1)
        EnviarMensaje(ok, bot2)
  fin
  proceso sincronizacionExitosa(E id: numero)
  variables
    ok: boolean
  comenzar
    repetir 2
      RecibirMensaje(ok, *)
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
areas
  areaBot1: AreaP(1,1,100,1)  {recorro calles}
  areaBot2: AreaP(1,2,100,2)
  areaBot3: AreaP(1,3,100,3)
  areaJefe: AreaP(1,4,1,4)
  areaDeposito: AreaC(50,50,50,50)
robots
  robot  recolector
  variables
    contPasos,cantF: numero
    avIni,caIni,id: numero
    ok: boolean
  comenzar
    derecha
    RecibirMensaje(id, jefe)
    contPasos:= 0
    repetir 99
      juntarFlores(cantF)
      mover
      contPasos:= contPasos+1
      si(contPasos = 10)
        avIni:= PosAv
        caIni:= PosCa
        bloquearDepositarLiberar(cantF,avIni,caIni)
        sincronizar(id)
        sincronizacionExitosa(id)
        contPasos:= 0
    {el paso 10, lo cuenta bien}
    EnviarMensaje(ok, jefe)
  fin
  robot  fiscalizador
  variables
    ok: boolean
    totalF: numero
  comenzar
    asignarIds
    repetir 3
      RecibirMensaje(ok, *)
    Pos(50,50)
    juntarFlores(totalF)
    Informar('elTotalEs',totalF)
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: fiscalizador
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaDeposito)
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 1,2)
  Iniciar(bot3, 1,3)
  Iniciar(jefe, 1,4)
fin