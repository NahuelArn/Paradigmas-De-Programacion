programa sarasa
procesos
  proceso juntarFlores(ES cantF: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantF:= cantF+1
  fin
  proceso excepcion(ES cantF: numero;E tamanho: numero)
  comenzar
    si(tamanho = 1)
      juntarFlores(cantF)
      mover
  fin
  proceso hacerCuadrado(ES cantF: numero;E tamanho: numero)
  comenzar
    repetir 2
      repetir tamanho-1
        juntarFlores(cantF)
        mover
      excepcion(cantF,tamanho)
      derecha
      repetir tamanho-1
        juntarFlores(cantF)
        mover
      excepcion(cantF,tamanho)
      derecha      
  fin
  proceso sincronizar(E id: numero)
  comenzar
    si(id = 1)
      EnviarMensaje(V, bot2)
      EnviarMensaje(V, bot3)
    sino
      si(id = 2)
        EnviarMensaje(V, bot1)
        EnviarMensaje(V, bot3)
      sino
        si(id = 3)
          EnviarMensaje(V, bot1)
          EnviarMensaje(V, bot2)
  fin
  proceso sincronizacionExitosa
  variables
    ok: boolean
  comenzar
    repetir 2
      RecibirMensaje(ok, *)
  fin
  proceso bloquearDepositarLiberar(ES cantF: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    repetir cantF
      BloquearEsquina(50,50)
      Pos(50,50)
      depositarFlor
      Pos(avIni, caIni)
      LiberarEsquina(50,50)
    cantF:= 0
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
areas
  areaBot1: AreaP(1,1,5,50)
  areaBot2: AreaP(8,1,12,50)
  areaBot3: AreaP(15,1,19,50)
  areaDeposito: AreaPC(50,50,50,50)
  areaJefe: AreaP(51,1,51,1)
robots
  robot recolector
  variables 
    cantF: numero
    id, tamanho: numero
  comenzar
    RecibirMensaje(id, jefe)
    repetir 5
      Random(tamanho, 1, 5)
      hacerCuadrado(cantF, tamanho)
      sincronizar(id)
      sincronizacionExitosa
      Informar('srtasa',tamanho)
      si(tamanho = 1)
        tamanho:= tamanho+1
      Pos(PosAv, (PosCa+tamanho))
    bloquearDepositarLiberar(cantF)
  fin
  robot fiscalizador
  comenzar
    asignarIds
  fin
variables
  bot1, bot2, bot3: recolector
  jefe: fiscalizador
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaDeposito)  {areas deposito}
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  Iniciar(bot1, 1,1)
  Iniciar(bot2, 8,1)
  Iniciar(bot3, 15,1)
  Iniciar(jefe, 51,1)
fin