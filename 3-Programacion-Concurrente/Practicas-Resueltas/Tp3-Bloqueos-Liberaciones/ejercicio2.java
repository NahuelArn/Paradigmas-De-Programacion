programa eje2
procesos
  proceso limpiarFlores(ES cantFlores: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantFlores:= cantFlores+1
  fin
  proceso limpiarPapeles(ES cantPapeles: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantPapeles:= cantPapeles+1
  fin
  proceso dondeMiro(E cantVeces: numero)
  comenzar
    repetir  cantVeces
      derecha
  fin
  proceso validadorMid(ES ok: boolean)
  variables
    auxOk: boolean
  comenzar
    auxOk:= F
    si(PosAv+1 = 16) & (PosCa = 16)
      {Informar(PosAv) Control de calidad}
      BloquearEsquina(16,16)
      auxOk:= V {que loco no? "V" faaa}
    ok:= auxOk
    {Informar(ok)}
  fin
  {Esta logica se me hace q se puede reutilizar para las 2 cosas, pasandole un parametro n}
  {pero se me hace q es bastante logica}
  proceso logicaCrecienteFlores(ES cantFlores: numero)  
  variables
    n: numero
    ok: boolean
    cantFlores: numero
  comenzar
    n:= 6
    cantFlores:= 0
    repetir (5)  {iteredor de vertices}
      repetir (n-1)  {iterador arriba}
        mover
      derecha
      limpiarFlores(cantFlores)  {estoy en un vertice}
      repetir (n-1)  {iterador derechar}
        validadorMid(ok)  {ponele q bloquea}
        mover  {se mueve es el ganador}
        si(ok)
          EnviarMensaje(1, jefe) {1 = robot 1 gano, le manda al jefe}
          {LiberarEsquina(16,16)}
      dondeMiro(3)  {miro arriba}
      limpiarFlores(cantFlores)  {estoy en un vertice}
      n:= n-1
    dondeMiro(3)  {miro izquierda}
    mover  {me pongo safe}
    LiberarEsquina(16,16)  {libero ahora q estoy seguro de romper nada}
  fin
  proceso logicaCrecienteInversa(ES cantFlores: numero)
  variables
    n: numero
  comenzar
    n:= 2 {hasta 6}
    repetir 4
      repetir n
        mover
      derecha  {mira para arriba}
      limpiarFlores(cantFlores)  {estoy en un vertice}
      repetir n
        mover
      dondeMiro(3)  {miro izquierda}
      limpiarFlores(cantFlores)  {estoy en un vertice}
      n:= n+1
    Informar('CantFloresJuntadas',cantFlores)
  fin
  proceso logicaTrambolica(ES cantFlores: numero)
  variables
    n: numero
  comenzar
    logicaCrecienteFlores(cantFlores)
    logicaCrecienteInversa(cantFlores)
  fin
  proceso validadorPorDerecha(ES ok: boolean)
  comenzar
    ok:= F
    si(PosAv-1 = 16) & (PosCa = 16)
      BloquearEsquina(16,16)
      ok:= V     
  fin
  proceso logicaGraficoDerecha(ES cantPapeles: numero)
  variables
    n: numero
    ok: boolean
  comenzar
    cantPapeles:= 0
    n:= 5+1
    repetir 5
      repetir n-1
        mover
      dondeMiro(3)  {izquierda}
      limpiarPapeles(cantPapeles) {estoy en un vertice}
      repetir (n-1)
        validadorPorDerecha(ok)
        mover
        si(ok)
          EnviarMensaje(2, jefe) {gano el bot 2}
      derecha {miro arriba}
      limpiarPapeles(cantPapeles) {estoy en un vertice}
      n:= n-1
    dondeMiro(1) {miro derecha}
    mover  {me pongo en un lugar safe}
    LiberarEsquina(16,16)
  fin
  proceso logicaGraficoDerechaPorArriba(ES cantPapeles: numero)
  variables
    n: numero
  comenzar
    {no tengo q contar el primer vertice, ya lo tendria contado}
    {igual no me joderia, porq hago full derecha y me choco con el primer vertice superior}
    n:= 2
    repetir 4   
      repetir n
        mover
      dondeMiro(3) {miro arriba}
      limpiarPapeles(cantPapeles) {estoy en un vertice}
      repetir n
        mover
      derecha {miro derecha}
      limpiarPapeles(cantPapeles) {estoy en un vertice}
      n:= n+1
    Informar('CantPapelesJuntados',cantPapeles)
  fin
areas
  lugarCarrera: AreaC(1,1,31,30)
  {lugarJefe: AreaC(15,1,15,1) } {deberia ser privada pero para probar}
robots
  robot  comportamientoFlor
  variables
    cantFlores: numero
  comenzar
    cantFlores:= 0
    logicaTrambolica(cantFlores)  {lo de cant Flores esta re al pedo}
  fin
  robot comportamientoPapel
  variables
    cantPapeles: numero
  comenzar
    cantPapeles:= 0
    logicaGraficoDerecha(cantPapeles)
    logicaGraficoDerechaPorArriba(cantPapeles)
  fin
  robot  comportamientoJefe
  variables
    QuienGano: numero
  comenzar
    RecibirMensaje(QuienGano, * )  {el primer mensaje q llega gana}
    Informar('GanoElRobot',QuienGano)
  fin
variables
  botFlor: comportamientoFlor
  botPapel: comportamientoPapel
  jefe: comportamientoJefe
comenzar
  AsignarArea(botFlor, lugarCarrera)
  AsignarArea(jefe, lugarCarrera)  {Este deberia tener una area privada}
  AsignarArea(botPapel, lugarCarrera)
  Iniciar(jefe,15,1)
  Iniciar(botFlor,1,1)
  Iniciar(botPapel, 31,1)
fin