programa arn
procesos
  proceso  juntarPapeles(ES cantPapeles: numero)
  comenzar
    mientras(HayPapelEnLaEsquina) & (cantPapeles < 5)
      tomarPapel
      cantPapeles:= cantPapeles+1
  fin
  proceso depositarPapeles
  comenzar
    repetir 5
      depositarPapel
  fin
  proceso cuantosPapelesPuedoTomar(E cantPedida: numero; ES tenianEsaCantidad: boolean)
  variables
    cantOtorgada: numero
  comenzar
    cantOtorgada:= 0
    tenianEsaCantidad:= F
    mientras(HayPapelEnLaEsquina) & (cantOtorgada < cantPedida)
      tomarPapel
      cantOtorgada:= cantOtorgada+1
    si (cantPedida <> cantOtorgada)  {significa que no tenian la cantidad de flores q necesitaba}
      mientras(HayPapelEnLaBolsa)
        depositarPapel
      {ok:= F}
    sino
      tenianEsaCantidad:= V
  fin
areas
  areaProductor1: AreaP(5,1,5,100)
  areaProductor2: AreaP(10,1,10,100)
  areaRecoleccion: AreaC(50,50,50,50)  {acceden todos a este lugar}
  areaConsumidor1: AreaP(11,1,11,1)  {consumidores, areas}
  areaConsumidor2: AreaP(12,1,12,1)
robots
  robot  tipoRecolector
  variables
    cantPapeles: numero
    posIniAv, posIniCa: numero
  comenzar
    mientras(PosCa < 100)
      cantPapeles := 0
      mientras (cantPapeles < 5) & (PosCa < 100)
        juntarPapeles(cantPapeles)
        si(~HayPapelEnLaEsquina)
          mover
      si(cantPapeles = 5)
        posIniAv:= PosAv
        posIniCa:= PosCa
        BloquearEsquina(50,50)
        Pos(50,50)
        depositarPapeles
        Pos(posIniAv,posIniCa)
        LiberarEsquina(50,50)
  fin
  robot tipoConsumidor
  variables
    cantPedida: numero
    intentos: numero
    posIniAv, posIniCa: numero
    tenianEsaCantidad : boolean
  comenzar
    intentos:= 0
    mientras (intentos < 8)
      Random(cantPedida, 2, 5)
      posIniAv:= PosAv
      posIniCa:= PosCa
      BloquearEsquina(50,50)
      Pos(50,50)
      cuantosPapelesPuedoTomar(cantPedida,tenianEsaCantidad) {ya resuelve todo solo este modulo}
      Pos(posIniAv,posIniCa)
      LiberarEsquina(50,50)
      si(tenianEsaCantidad)
        repetir  cantPedida
          depositarPapel 
      sino
        intentos := intentos +1
  fin
variables
  botP1,botP2: tipoRecolector {productores}
  botC1,botC2: tipoConsumidor {consumidores}
comenzar
  {productores}
  AsignarArea(botP1, areaProductor1)
  AsignarArea(botP2, areaProductor2)
  {consumidores}  
  AsignarArea(botC1, areaConsumidor1)
  AsignarArea(botC2, areaConsumidor2)
  {area en comun}
  AsignarArea(botP1, areaRecoleccion)
  AsignarArea(botP2, areaRecoleccion)
  AsignarArea(botC1, areaRecoleccion)
  AsignarArea(botC2, areaRecoleccion)
  {iniciarEnSusLugares default}
  Iniciar(botP1, 5, 1)
  Iniciar(botP2, 10, 1)
  {lugar default de los consumidores}
  Iniciar(botC1, 11, 1)
  Iniciar(botC2, 12, 1)
fin