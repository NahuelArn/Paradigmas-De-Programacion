programa eje4
procesos
  proceso  asignarIds
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
  fin
  proceso elegirTrabajador(ES idTrabajadorElegido: numero)
  variables
    aux: numero
  comenzar
    Random(aux, 1, 2)
    idTrabajadorElegido:= aux
  fin
  proceso avisarQueTermino
  comenzar
    EnviarMensaje(0, bot1)
    EnviarMensaje(0, bot2)
  fin
  proceso mandarTareaYesperarConfirmacion(E idTrabajadorElegido: numero ;E numTarea: numero; E posAvRandom: numero;  E posCaRandom: numero)
  variables
    ok: boolean
  comenzar
    si(idTrabajadorElegido = 1)
      EnviarMensaje(numTarea, bot1)
      EnviarMensaje(posAvRandom, bot1)
      EnviarMensaje(posCaRandom, bot1)
      RecibirMensaje(ok, bot1)    {Le avisa que termino}
    sino
      EnviarMensaje(numTarea, bot2)
      EnviarMensaje(posAvRandom, bot2)
      EnviarMensaje(posCaRandom, bot2)
      RecibirMensaje(ok, bot2)
  fin
  proceso tarea1RecogerFlores(ES cantFlores: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantFlores:= cantFlores +1
  fin
  proceso tarea2RecogerPapeles(ES cantPapeles: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantPapeles:= cantPapeles +1
  fin
  proceso tarea3VaciarBolsa(ES cantPapeles: numero; ES cantFlores: numero)
  comenzar
    repetir cantPapeles
      depositarPapel
    repetir cantFlores
      depositarFlor  
  fin
areas
  areaTrabajadores:  AreaPC(2,2,100,100)
  areaJefe: AreaP(1,1,1,1)  {Asigno las areas default}
  areaBot1: AreaP(2,1,2,1) 
  areaBot2: AreaP(3,1,3,1)
robots
  robot  tipoTrabajador
  variables
    id, posAvRecibida, posCaRecibida, numTarea: numero
    ok: boolean
    cantFlores, cantPapeles: numero
    posAvIni, posCaIni: numero
  comenzar
    cantFlores:= 0
    cantPapeles:= 0
    RecibirMensaje(id, jefe)
    RecibirMensaje(numTarea, jefe)
    mientras(numTarea <> 0)  {con la tarea 0, corta}
      RecibirMensaje(posAvRecibida, jefe)
      RecibirMensaje(posCaRecibida, jefe)
      posAvIni:= PosAv
      posCaIni:= PosCa
      si(numTarea = 1)
        BloquearEsquina(posAvRecibida, posCaRecibida)    {El bloquear Esquina y todo lo se repite lo podria hacer arriba?}
        Pos(posAvRecibida, posCaRecibida)                {yyy no, ya que para la tarea 4, voy a tener bloqueada una esquina y}
        tarea1RecogerFlores(cantFlores)                  {me dice q no tiene q accerder a una esquina, rompe mi estructura}
        Pos(posAvIni, posCaIni)
        LiberarEsquina(posAvRecibida,posCaRecibida)
        EnviarMensaje(ok, jefe)
      sino
        si(numTarea = 2)
          BloquearEsquina(posAvRecibida, posCaRecibida)
          Pos(posAvRecibida, posCaRecibida)
          tarea2RecogerPapeles(cantPapeles)
          Pos(posAvIni, posCaIni)
          LiberarEsquina(posAvRecibida, posCaRecibida)
          EnviarMensaje(ok, jefe)
        sino
          si(numTarea = 3)
            BloquearEsquina(posAvRecibida, posCaRecibida)
            Pos(posAvRecibida, posCaRecibida)
            tarea3VaciarBolsa(cantPapeles,cantFlores)
            cantPapeles:= 0
            cantFlores:= 0
            Pos(posAvIni, posCaIni)
            LiberarEsquina(posAvRecibida, posCaRecibida)
            EnviarMensaje(ok, jefe)
          sino
            Informar('Tarea4NoHacerNada',4)
            EnviarMensaje(ok, jefe)
      RecibirMensaje(numTarea, jefe)  {si me mandan la tarea 0, me entero que el jefe ya termino sus 10 intentos}
  fin
  robot tipoJefe
  variables
    numTarea,id,posAvRandom,posCaRandom: numero
    idTrabajadorElegido: numero
  comenzar  
    asignarIds      {les asigna ids a los bots}
    repetir 10
      elegirTrabajador(idTrabajadorElegido)  {elijo q trabajador va hacer la tarea}
      Random(numTarea, 1, 4)  {tarea q le voy a mandar}
      Random(posAvRandom, 2, 100)  {saco la esquina random q le voy a mandar}
      Random(posCaRandom, 2, 100)
      mandarTareaYesperarConfirmacion(idTrabajadorElegido,numTarea, posAvRandom,posCaRandom)
    avisarQueTermino
  fin
variables
  bot1, bot2: tipoTrabajador
  jefe: tipoJefe
comenzar
  AsignarArea(bot1, areaBot1)  {areas default}
  AsignarArea(bot2, areaBot2)
  AsignarArea(jefe, areaJefe)
  {lugar de recoleccion}
  AsignarArea(bot1, areaTrabajadores)
  AsignarArea(bot2, areaTrabajadores)
  {IniciarValores}
  Iniciar(bot1, 2,1)
  Iniciar(bot2, 3,1)
  Iniciar(jefe, 1,1)
fin