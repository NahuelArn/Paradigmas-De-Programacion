programa eje1
procesos
  proceso juntarFlores(ES cantEnEsquina: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantEnEsquina:= cantEnEsquina+1
  fin
  proceso maxBotardoFlores(ES suma: numero; ES maxFlores: numero; ES idMax: numero; E id: numero)
  comenzar
    si(suma > maxFlores)
      maxFlores:= suma
      idMax:= id
  fin
  proceso carteroIds
  comenzar
    EnviarMensaje(1,botAv1) 
    EnviarMensaje(2,botAv2)
    EnviarMensaje(3,botAv3)
    EnviarMensaje(4,botAv4)
    EnviarMensaje(5,botAv5)
    EnviarMensaje(6,botAv6) 
  fin
  proceso switch( E id: numero; ES sumaActual: numero)
  comenzar
    si(id = 1)
      RecibirMensaje(sumaActual, botAv1)
    sino
      si(id = 2)
        RecibirMensaje(sumaActual, botAv2)
      sino
        si(id = 3)
          RecibirMensaje(sumaActual, botAv3)
        sino
          si (id = 4)
            RecibirMensaje(sumaActual, botAv4)
          sino
            si(id = 5)
              RecibirMensaje(sumaActual, botAv5)
            sino
              si(id = 6)
                RecibirMensaje(sumaActual, botAv6)         
  fin
areas
  primeraAv: AreaP(1,1,1,10)
  segundaAv: AreaP(2,11,2,20)   
  fiscalizadorArea: AreaP(2,1,2,1)
  tercerAv: AreaP(3,21,3,30)
  cuartaAv: AreaP(4,31,4,40)
  quintaAv: AreaP(5,41,5,50)
  sextaAv: AreaP(6,51,6,60)
robots
  robot  tipo1  
  variables 
    suma: numero
    id: numero
  comenzar      
    RecibirMensaje(id, botardo)       
    suma:= 0 
    repetir 9
      juntarFlores(suma)
      mover
    juntarFlores (suma)    
    EnviarMensaje(id,botardo)         
    EnviarMensaje(suma, botardo)    
  fin
  robot informante
  variables
    sumaActual: numero
    maxFlores: numero
    idMax: numero
    diferencia: numero
    id: numero
  comenzar
    carteroIds {se encarga de asignarles ids}
    maxFlores:= -999
    idMax:= 0
    repetir 6
      RecibirMensaje(id, *)
      switch(id,sumaActual)  {sarasaaACAAAAAAAAAAAA}
      maxBotardoFlores(sumaActual,maxFlores,idMax,id)
    Informar('ElRobotConId',idMax)
    Informar('juntoXFlores',maxFlores)
  fin
variables
  botAv1: tipo1
  botAv2: tipo1
  botardo: informante
  botAv3: tipo1
  botAv4: tipo1
  botAv5: tipo1
  botAv6: tipo1
comenzar
  AsignarArea(botAv1, primeraAv)
  AsignarArea(botAv2, segundaAv)
  AsignarArea(botardo, fiscalizadorArea)
  AsignarArea(botAv3, tercerAv)
  AsignarArea(botAv4, cuartaAv)
  AsignarArea(botAv5, quintaAv)
  AsignarArea(botAv6, sextaAv)
  Iniciar(botAv1,1,1)
  Iniciar(botAv2,2,11)
  Iniciar(botardo,2,1)
  Iniciar(botAv3, 3,21)
  Iniciar(botAv4, 4,31)
  Iniciar(botAv5, 5,41)
  Iniciar(botAv6, 6,51)
fin