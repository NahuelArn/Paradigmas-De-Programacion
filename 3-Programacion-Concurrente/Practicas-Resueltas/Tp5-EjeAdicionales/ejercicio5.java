programa eje5
procesos 
  proceso movermeRecolectarLiberar( E avIni:numero; E caIni: numero)
  comenzar
    BloquearEsquina(100,1)
    Pos(100,1)
    tomarPapel
    Pos(avIni, caIni)
    LiberarEsquina(100,1)
  fin
  proceso depositarPapeles(E cantP: numero)
  comenzar
    repetir cantP
      depositarPapel
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
  proceso bloquearDepositarLiberar(E cantAdepositar: numero)
  comenzar
    BloquearEsquina(100,1)
    Pos(100,1)
    depositarPapeles(cantAdepositar)
    Pos(13,1)
    LiberarEsquina(100,1)
  fin
areas
  areaBot1: AreaP(10,1,10,1)
  areaBot2: AreaP(11,1,11,1)
  areaBot3: AreaP(12,1,12,1)
  areaServidor: AreaP(13,1,13,1)
  areaDeposito: AreaC(100,1,100,1)
robots
  robot  cliente
  variables
    id,cantPaRecolectar: numero
    avIni, caIni: numero
  comenzar
    RecibirMensaje(id, jefe)
    avIni:= PosAv
    caIni:= PosCa
    repetir 4
      EnviarMensaje(id, jefe)
      RecibirMensaje(cantPaRecolectar, jefe)
      repetir cantPaRecolectar
        movermeRecolectarLiberar(avIni,caIni)
      depositarPapeles(cantPaRecolectar)  {no especifica si tambien lo deposito 1 a 1}
    EnviarMensaje(0, jefe)  {lo atrapa el recibir id, si es 0 uno ya termino}
  fin
  robot  servidor
  variables
    id: numero
    cont3: numero
    cantPrandom: numero
  comenzar
    asignarIds
    cont3:= 0
    mientras(cont3 < 3)
      Random(cantPrandom, 1,5)
      RecibirMensaje(id, *)
      si(id = 1)
        bloquearDepositarLiberar(cantPrandom)
        EnviarMensaje(cantPrandom, bot1)
      sino
        si(id = 2)
          bloquearDepositarLiberar(cantPrandom)
          EnviarMensaje(cantPrandom, bot2)
        sino
          si(id = 3)
            bloquearDepositarLiberar(cantPrandom)
            EnviarMensaje(cantPrandom, bot3)
          sino
            cont3:= cont3+1
  fin
variables  
  bot1, bot2, bot3: cliente
  jefe: servidor
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)  
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaServidor)
  AsignarArea(bot1, areaDeposito)  {areas deposito / recoleccion}
  AsignarArea(bot2, areaDeposito)  
  AsignarArea(bot3, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 10,1)
  Iniciar(bot2, 11,1)
  Iniciar(bot3, 12,1)
  Iniciar(jefe, 13,1)
fin




V2
programa eje5
procesos
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
  proceso bloquearJuntarLiberar(E cantR: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    repetir cantR
      BloquearEsquina(100,1)
      Pos(100,1)
      tomarFlor
      Pos(avIni,caIni)
      LiberarEsquina(100,1)
  fin
  proceso depositarFlores(ES cantR: numero)
  comenzar
    repetir cantR
      depositarFlor
    cantR:= 0
  fin
  proceso bloquearDepositarLiberar(E cantRandom: numero)
  comenzar
    BloquearEsquina(100,1)
    Pos(100,1)
    depositarFlores(cantRandom)  {reutilizo modulo y como tengo cantR por valor no me lo resetea a 0}
    {Informar('tieneValor',cantRandom) SI LO IMPRIMO AFUERA TIENE EL VALOR}
    Pos(13,1)
    LiberarEsquina(100,1)
  fin
areas
  areaBot1: AreaP(10,1,10,1)
  areaBot2: AreaP(11,1,11,1)
  areaBot3: AreaP(12,1,12,1)
  areaJefe: AreaP(13,1,13,1)
  areaDeposito: AreaC(100,1,100,1)
robots
  robot  recolector
  variables
    id,cantR: numero
  comenzar
    RecibirMensaje(id, jefe)
    repetir 4
      EnviarMensaje(id, jefe)
      RecibirMensaje(cantR, jefe)
      bloquearJuntarLiberar(cantR) {maximizar concurrencia}
      depositarFlores(cantR)  
    EnviarMensaje(0, jefe)    
  fin
  robot coordinador
  variables
    id,cont3: numero
    cantF,cantRandom: numero
  comenzar
    cont3:= 0
    asignarIds
    mientras(cont3 < 3)
      RecibirMensaje(id, *)
      si(id <> 0)
        Random(cantRandom, 1, 5)
        bloquearDepositarLiberar(cantRandom)
        Informar('tieneValor',cantRandom)  {Chequeo q si tiene el valor}
      si(id = 1)
        EnviarMensaje(cantRandom, bot1)
      sino
        si(id = 2)
          EnviarMensaje(cantRandom, bot2)
        sino
          si(id = 3)
            EnviarMensaje(cantRandom, bot3)
          sino
            cont3:= cont3+1
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: coordinador
comenzar
  AsignarArea(bot1, areaBot1)  {area Default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaDeposito)  {area Deposito}
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 10,1)
  Iniciar(bot2, 11,1)
  Iniciar(bot3, 12,1)
  Iniciar(jefe, 13,1)
fin