programa arn
procesos
  proceso  queDepositoTeDoy(E avActual: numero; ES lugarFigura: numero)
  comenzar
    si(avActual = 50)
      lugarFigura:= 5
    sino
      si(avActual = 52)
        lugarFigura:= 11
  fin
  proceso  queDepositoTeDoy2(E avActual: numero; ES lugarFigura: numero)
  comenzar
    si(avActual = 51)
      lugarFigura:= 6
    sino
      si(avActual = 53)
        lugarFigura:= 12
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1, botEq1Num1)  {Primer equipo}
    EnviarMensaje(2, botEq1Num2)
    EnviarMensaje(3, botEq2Num1)    {segundo equipo}
    EnviarMensaje(4, botEq2Num2)
  fin
areas
  areaRecoleccion: AreaPC(15,15,15,15)   {area de recoleccion}
  areaBot1Equipo1: AreaP(50,50,50,50)   {areas default Equipo 1}
  areaBot2Equipo1: AreaP(51,51,51,51)   {areas default}
  areaBot1Equipo2: AreaP(52,52,52,52)   {areas default Equipo 2}
  areaBot2Equipo2: AreaP(53,53,53,53)   {areas default}
  areaDeFiguraEquipoVertical1: AreaP(5,4,5,16)  {Figura del equipo 1}
  areaDeFiguraEquipoHorizontal1: AreaP(6,4,9,4)  {12 de alto y 4 de ancho}
  areaDeFiguraEquipoVertical2: AreaP(11,4,11,15)  {Figura del equipo 2}
  areaDeFiguraEquipoHorizontal2: AreaP(12,4,15,4)  {12 de alto y 4 de ancho}
  areaCoordinador: AreaP(1,1,1,1)
robots
  robot  vertical  {papel}
  variables
    avIni, caIni: numero    {lugar default}
    avRecoleccion, caRecoleccion: numero  {lugar donde voy a ir a buscar los papeles}
    avFigura, caFigura: numero  {lugar donde voy a hacer mi figura}
    id: numero {en este caso el id lo voy a usar como filtro de los equipos q lleguen primero}
  comenzar
    RecibirMensaje(id, jefe)
    avIni:= PosAv
    caIni:= PosCa
    queDepositoTeDoy(avIni, avFigura)    {me devuelve la avenida donde voy a hacer mi figura}
    caFigura:= 4
    avRecoleccion:= 15
    caRecoleccion:= 15
    repetir 11
      BloquearEsquina(avRecoleccion, caRecoleccion)
      Pos(avRecoleccion, caRecoleccion)
      si(HayPapelEnLaEsquina)
        tomarPapel
      Pos(avFigura, caFigura)
      LiberarEsquina(avRecoleccion,caRecoleccion)
      si(HayPapelEnLaBolsa)  {estas verificaciones estan de mas, sabes q nunca te van a faltar los papeles}
        depositarPapel
      caFigura:= caFigura+1
      mover
    BloquearEsquina(avRecoleccion, caRecoleccion)
    Pos(avRecoleccion, caRecoleccion)
    si(HayPapelEnLaEsquina)
      tomarPapel
    Pos(avFigura, caFigura)
    LiberarEsquina(avRecoleccion,caRecoleccion)
    si(HayPapelEnLaBolsa)  {estas verificaciones estan de mas, sabes q nunca te van a faltar los papeles}
      depositarPapel
    EnviarMensaje(id, jefe)
  fin
  robot  horizontal  {flor}
  variables
    avIni, caIni: numero    {lugar default}
    avRecoleccion, caRecoleccion: numero  {lugar donde voy a ir a buscar los papeles}
    avFigura, caFigura: numero  {lugar donde voy a hacer mi figura}
    id: numero {en este caso el id lo voy a usar como filtro de los equipos q lleguen primero}
  comenzar
    RecibirMensaje(id, jefe)
    avIni:= PosAv
    caIni:= PosCa
    queDepositoTeDoy2(avIni, avFigura)    {me devuelve la avenida donde voy a hacer mi figura}
    caFigura:= 4
    avRecoleccion:= 15
    caRecoleccion:= 15
    derecha
    repetir 3
      BloquearEsquina(avRecoleccion, caRecoleccion)
      Pos(avRecoleccion, caRecoleccion)
      si(HayFlorEnLaEsquina)
        tomarFlor
      Pos(avFigura, caFigura)
      LiberarEsquina(avRecoleccion,caRecoleccion)
      si(HayFlorEnLaBolsa)  {estas verificaciones estan de mas, sabes q nunca te van a faltar los papeles}
        depositarFlor
      avFigura:= avFigura+1
      mover
    BloquearEsquina(avRecoleccion, caRecoleccion)
    Pos(avRecoleccion, caRecoleccion)
    si(HayFlorEnLaEsquina)
      tomarFlor
    Pos(avFigura, caFigura)
    LiberarEsquina(avRecoleccion,caRecoleccion)
    si(HayFlorEnLaBolsa)  {estas verificaciones estan de mas, sabes q nunca te van a faltar los papeles}
      depositarFlor
    EnviarMensaje(id, jefe)
  fin
  robot  coordinador
  variables
    id: numero
    contEquipo1: numero
    contEquipo2: numero
    informo: boolean
  comenzar
    asignarIds
    contEquipo1:= 0
    contEquipo2:= 0
    informo:= V
    repetir 4 
      RecibirMensaje(id, *)  
      si(id = 1) | (id = 2)  {equipo 1}
        contEquipo1:= contEquipo1 + 1
      sino  {equipo2}
        contEquipo2:= contEquipo2 + 1
      si(contEquipo1 = 2) & (informo)
        Informar('ganoElEquipo',1)
        informo:= F
      si(contEquipo2 = 2) & (informo)
        Informar('ganElEquipo',2)
        informo:= F
  fin
variables
  botEq1Num1,botEq2Num1: vertical
  botEq1Num2,botEq2Num2: horizontal
  jefe: coordinador
comenzar
  AsignarArea(botEq1Num1, areaBot1Equipo1)  {asignando a sus areas default}
  AsignarArea(botEq1Num2, areaBot2Equipo1)
  AsignarArea(botEq2Num1, areaBot1Equipo2)
  AsignarArea(botEq2Num2, areaBot2Equipo2)
  AsignarArea(jefe, areaCoordinador)
  AsignarArea(botEq1Num1, areaRecoleccion)  {asignando al area de recoleccion}
  AsignarArea(botEq1Num2, areaRecoleccion)
  AsignarArea(botEq2Num1, areaRecoleccion)
  AsignarArea(botEq2Num2, areaRecoleccion)
  AsignarArea(botEq1Num1, areaDeFiguraEquipoVertical1)  {lugar de las figuras verticales}
  AsignarArea(botEq2Num1, areaDeFiguraEquipoVertical2)
  AsignarArea(botEq1Num2, areaDeFiguraEquipoHorizontal1)  {lugar de las figuras horizontales}
  AsignarArea(botEq2Num2, areaDeFiguraEquipoHorizontal2)
  Iniciar(botEq1Num1, 50,50)  {Asignando areas default}
  Iniciar(botEq1Num2, 51,51)
  Iniciar(botEq2Num1, 52,52)  
  Iniciar(botEq2Num2, 53,53)
  Iniciar(jefe, 1,1)
fin