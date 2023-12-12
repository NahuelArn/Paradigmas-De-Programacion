<h1 align="center"> Problema espacio tiempo </h1>

```go

  programa prueba
areas
  areaRecoleccion: AreaPC(1,5,1,5)
  areaBots AreaC(6,1,8,1)  {cada lugar deberia ser privado}
  areaCoordinador AreaP(10,10,10,10)
robots
  robot recolector
  variables
    cantJuntar: numero
    caIni, avIni: numero
    id: numero
    sigo: boolean
    ACK: boolean
  coemenzar
    RecibirMensaje(id, jefe)
    sigo:= V
    mientras(sigo)
      Random(cantJuntar, 1,5)
      caIni: PosCa
      avIni: PosAv
      BloquearEsquina(5,5)
      Pos(5,5)
      mientras (cantJuntar < 5 ) & (HayFlorEnLaEsquina)
        tomarFlor
        cantJuntar:= cantJuntar -1
      {Pos(avIni, caIni) }
      {LiberarEsquina(5,5) }
      si(~HayFlorEnLaEsquina)
        sigo:= F
        EnviarMensaje(id, jefe)
        RecibirMensaje(ACK, jefe)
      Pos(avIni, caIni)
      LiberarEsquina(5,5)
  fin
  robot coordinador
  variables
    id: numero
    PosQsalio: numero
  comenzar
    EnviarMensaje(1, bot1)
    EnviarMensaje(2, bot2)
    EnviarMensaje(3, bot3)
    PosQsalio:= 0
    repetir 3
      RecibirMensaje(id, *)
      si(id = 1)
        EnviarMensaje(id, bot1)
      sino
        si(id = 2)
          EnviarMensaje(id, bot2)
        sino
          si(id = 3)
            EnviarMensaje(id, bot3)
      PosQsalio:= PosQsalio +1
      si(PosQsalio = 2)
        Informar(´EsteRobotSalioSegundo´,id)
  fin
variables
  bot1, bot2, bot3: numero
  jefe: coordinador
comenzar
  AsignarArea(bot1, areaBots) {cada lugar deberia ser privado}
  AsignarArea(bot2, areaBots)
  AsignarArea(bot3, areaBots)
  {recoleccion}
  AsignarArea(bot1, areaRecoleccion)
  AsignarArea(bot2, areaRecoleccion)
  AsignarArea(bot3, areaRecoleccion)
  AsignarArea(jefe, areaCoordinador)
  Iniciar(bot1, 6,1)
  Iniciar(bot1, 7,1)
  Iniciar(bot1, 8,1)
  Iniciar(jefe, 10,10)
fin

```
