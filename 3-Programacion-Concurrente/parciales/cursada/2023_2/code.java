programa arancibiaNahuel
procesos 
  proceso girar(E giro: numero)
  comenzar
    repetir giro
      derecha
  fin
  proceso juntarPapeles(ES cantP: numero; ES cantEsquinasVaciadas: numero)
  comenzar
    si(HayPapelEnLaEsquina)
      cantEsquinasVaciadas:= cantEsquinasVaciadas+1
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantP:= cantP+1
  fin
  proceso depositarPapeles(ES cantP: numero)
  comenzar
    repetir cantP
      depositarPapel
    cantP:= 0
  fin
  proceso bloquearDepositarLiberar(ES cantP: numero)
  variables
    avIni, caIni: numero
  comenzar
    avIni:= PosAv
    caIni:= PosCa
    BloquearEsquina(99,99)
    Pos(99,99)
    depositarPapeles(cantP)
    Pos(avIni,caIni)
    LiberarEsquina(99,99)
  fin
  proceso hacerEscalon(E ancho: numero; E alto: numero; ES cantEsquinasVaciadas: numero)
  variables
    cantP: numero
  comenzar
    cantP:= 0
    derecha
    repetir ancho-1
      juntarPapeles(cantP,cantEsquinasVaciadas)
      mover
    girar(3){miro arrriba}
    bloquearDepositarLiberar(cantP)
    repetir alto-1
      juntarPapeles(cantP,cantEsquinasVaciadas)
      mover
    bloquearDepositarLiberar(cantP)
  fin
  proceso sincronizar
  comenzar
    EnviarMensaje(V, jefe)
  fin
  proceso sincronizacionExitosa
  variables
    ok: boolean
  comenzar
    RecibirMensaje(ok, *)
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
  fin
  proceso juntarTodosLosPapeles(ES cantP: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantP:= cantP+1  {ta al pedo el contador de papeles, solo los tengoq  juntar}
  fin
  proceso vaciarDeposito(ES cantP: numero)
  comenzar
    Pos(99,99)
    juntarTodosLosPapeles(cantP)
    Pos(1,1)
  fin
areas
  areaBot1: AreaP(2,1,18,12) {16 de ancho,  12 de alto como max}
  areaBot2: AreaP(32,1,48,12)
  areaBot3: AreaP(62,1,78,12)
  areaJefe: AreaP(1,1,1,1)
  areaDeposito: AreaC(99,99,99,99) {todos acceden a ella}
robots
  robot  recolector
  variables
    alto, ancho: numero
    id,cantEsquinasVaciadas: numero
  comenzar
    RecibirMensaje(id, jefe)
    cantEsquinasVaciadas:= 0
    repetir 4
      Random(alto, 2,4)
      Random(ancho,3, 5)
      hacerEscalon(ancho,alto,cantEsquinasVaciadas)
      sincronizar
      sincronizacionExitosa
    EnviarMensaje(cantEsquinasVaciadas, jefe)  {le aviso q termino}
  fin
  robot fiscalizador
  variables
    total,cantP,cantEsquinasVaciadas: numero
    ok: boolean
  comenzar
    cantP:= 0
    asignarIds
    total:= 0 
    repetir 4
      repetir 3
        RecibirMensaje(ok, *)
      EnviarMensaje(V, bot1)
      EnviarMensaje(V, bot2)
      EnviarMensaje(V, bot3)
    repetir 3
      RecibirMensaje(cantEsquinasVaciadas, *)
      total:= cantEsquinasVaciadas+total
    Informar('cantTotalDeEsquinasVaciadas',total)
    vaciarDeposito(cantP){ya limpie el deposito}
  fin
variables 
  bot1, bot2, bot3: recolector
  jefe: fiscalizador
comenzar
  AsignarArea(bot1, areaBot1)  {areas defult}
  AsignarArea(bot2, areaBot2)
  AsignarArea(bot3, areaBot3)
  AsignarArea(jefe, areaJefe)
  AsignarArea(bot1, areaDeposito)  {areas deposito}
  AsignarArea(bot2, areaDeposito)
  AsignarArea(bot3, areaDeposito)
  AsignarArea(jefe, areaDeposito)
  Iniciar(bot1, 2,1)
  Iniciar(bot2, 32,1)
  Iniciar(bot3, 62,1)
  Iniciar(jefe, 1,1)
fin