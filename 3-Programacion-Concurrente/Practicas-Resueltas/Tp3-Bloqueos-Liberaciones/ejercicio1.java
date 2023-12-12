programa eje1
procesos
  proceso azar(ES Av: numero; ES Ca: numero)  {se encarga de darme una Pos random Flores}
  variables
    Av1, Ca1: numero
  comenzar
    Random(Av1,1,5)
    Random(Ca1,1,10)
    Av:= Av1
    Ca:= Ca1
  fin
  proceso azar2(ES Av: numero; ES Ca: numero)
  variables
    Av1, Ca1: numero
  comenzar
    Random(Av1,6,10)
    Random(Ca1,1,9)
    Av:= Av1
    Ca:= Ca1
  fin
  proceso juntarFlores
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
  fin
  proceso depositarFlores
  comenzar
    mientras(HayFlorEnLaBolsa)
      depositarFlor
  fin
  proceso limpiarPapeles
  comenzar
    mientras(HayPapelEnLaBolsa)
      depositarPapel
  fin
  proceso depositarPapeles
  comenzar
    mientras(HayPapelEnLaBolsa)
      depositarPapel
  fin
areas
  {Areas Flores}
  areaFloreros: AreaPC(1,1,5,10)
  EsquinaFlor1: AreaP(6,10,6,10)
  EsquinaFlor2: AreaP(7,10,7,10)
  {Areas Papeles}
  areaPapeleros: AreaPC(6,1,10,9)
  EsquinaPapel1: AreaP(8,10,8,10)
  EsquinaPapel2: AreaP(9,10,9,10)
  lugarDeDePosito: AreaC(10,10,10,10)
robots
  robot  papelero
  variables
    Av, Ca: numero 
    AvIni, CaIni: numero
  comenzar
    AvIni:= PosAv
    CaIni:= PosCa
    repetir 3
      azar2(Av, Ca)
      BloquearEsquina(Av, Ca)
      Pos(Av,Ca)
      limpiarPapeles
      Pos(AvIni,CaIni)
      LiberarEsquina(Av, Ca)
    BloquearEsquina(10,10)
    Pos(10,10)
    depositarPapeles
    Pos(AvIni,CaIni)   
    LiberarEsquina(10,10)
  fin
  robot florero
  variables
    CaInicial, AvInicial: numero
    Av, Ca: numero
  comenzar
    CaInicial:= PosCa
    AvInicial:= PosAv
    repetir 5
      azar(Av,Ca)
      BloquearEsquina(Av,Ca)  {antes de entrar bloqueo}
      Pos(Av,Ca)
      juntarFlores
      Pos(AvInicial,CaInicial)
      LiberarEsquina(Av,Ca)  {me muevo a un lugar safe y libero}
    BloquearEsquina(10,10)
    Pos(10,10)
    depositarFlores
    Pos(AvInicial,CaInicial)
    LiberarEsquina(10,10)
  fin
variables
  botF1: florero
  botF2: florero
  botP1: papelero
  botP2: papelero
comenzar
  {Cuadrado del Azar}
  AsignarArea(botF1, areaFloreros)
  AsignarArea(botF2, areaFloreros)
  AsignarArea(botP1, areaPapeleros)
  AsignarArea(botP2, areaPapeleros)
  {Area Deposito}
  AsignarArea(botF1, lugarDeDePosito)
  AsignarArea(botF2, lugarDeDePosito)
  AsignarArea(botP1, lugarDeDePosito)
  AsignarArea(botP2, lugarDeDePosito)
  {lugar De inicio}
  AsignarArea(botF1, EsquinaFlor1)
  AsignarArea(botF2, EsquinaFlor2)
  AsignarArea(botP1, EsquinaPapel1)
  AsignarArea(botP2, EsquinaPapel2)
  {Inicien su logica}
  Iniciar(botF1, 6,10)
  Iniciar(botF2, 7,10)
  Iniciar(botP1, 8,10)
  Iniciar(botP2, 9,10)
fin