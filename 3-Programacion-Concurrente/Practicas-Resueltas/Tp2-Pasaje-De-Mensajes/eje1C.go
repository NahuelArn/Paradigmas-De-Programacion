programa eje1
procesos
  proceso juntarFlores(ES cantEnEsquina: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantEnEsquina:= cantEnEsquina+1
  fin
  proceso maxBotardoFlores(ES suma: numero; ES maxFlores: numero)
  comenzar
    si(suma > maxFlores)
      maxFlores:= suma
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
  comenzar             
    suma:= 0 
    repetir 9
      juntarFlores(suma)
      mover
    juntarFlores (suma)               
    EnviarMensaje(suma, botardo)    
  fin
  robot informante
  variables
    suma: numero
    maxFlores: numero
    diferencia: numero
  comenzar
    maxFlores:= -999
    repetir 6
      RecibirMensaje(suma, *)
      maxBotardoFlores(suma,maxFlores)
    Informar(maxFlores)
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