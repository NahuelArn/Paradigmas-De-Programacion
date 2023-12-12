Funcional pero no modularizado (Pulirlo)
programa eje3
procesos
  proceso limpiarPapeles
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
  fin 
  proceso unaEtapa
  comenzar
    repetir 5
      limpiarPapeles
      si(PosCa < 100)
        mover
    limpiarPapeles
  fin
areas
  areaBot1: AreaP(1,1,1,100)
  areaBot2: AreaP(2,1,2,100)
  areaBot3: AreaP(3,1,3,100)
  areaCoordinador: AreaP(4,1,4,1)
robots
  robot  equipoRecolector
  variables
    confirmacion5: numero
    id: numero
    suma: numero
  comenzar
    RecibirMensaje(id, jefe)
    mientras (PosCa < 100)
      confirmacion5:= 0
      unaEtapa
      si(id = 1)  {Aviso que termine}
        EnviarMensaje(id, r2)
        confirmacion5:= confirmacion5+1
        EnviarMensaje(confirmacion5, r3)
      sino
        si(id = 2)
          EnviarMensaje(id, r1)  {Q se enteren todos q termine}
          confirmacion5:= confirmacion5+1
          EnviarMensaje(confirmacion5, r3)
        sino
          si(id = 3)
            EnviarMensaje(id, r1)  {Q se enteren todos q termine}
            confirmacion5:= confirmacion5+1
            EnviarMensaje(confirmacion5, r2)
      {escuchar}    
      si(id = 1)  {Aviso que termine}
        RecibirMensaje(suma, r2)
        RecibirMensaje(suma, r3)
      sino
        si(id = 2)
          RecibirMensaje(suma, r1)
          RecibirMensaje(suma, r3)
        sino
          si(id = 3)
            RecibirMensaje(suma, r1)
            RecibirMensaje(suma, r2)
  fin
  robot  fiscalizador
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
  fin
variables
  r1, r2, r3: equipoRecolector
  jefe: fiscalizador
comenzar
  AsignarArea(r1, areaBot1)
  AsignarArea(r2, areaBot2)
  AsignarArea(r3, areaBot3)
  AsignarArea(jefe, areaCoordinador)
  Iniciar(r1, 1, 1)
  Iniciar(r2, 2, 1)
  Iniciar(r3, 3, 1)
  Iniciar(jefe, 4, 1)
fin