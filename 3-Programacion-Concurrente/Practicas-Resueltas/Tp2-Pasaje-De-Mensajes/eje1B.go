programa eje1
procesos
  proceso juntarFlores(ES cantEnEsquina: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantEnEsquina:= cantEnEsquina+1
  fin
areas
  primeraAv: AreaP(1,1,1,10)
  segundaAv: AreaP(2,11,2,20)   
  fiscalizadorArea: AreaP(2,1,2,1)
robots
  robot  tipo1  
  variables 
    suma: numero
    sumDelOtro: numero
    diferenciaDeSuma: numero
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
    suma1: numero
    suma2: numero
    diferencia: numero
  comenzar
    RecibirMensaje(suma1, *)
    RecibirMensaje(suma2, *)
    si(suma1 > suma2)
      Informar(suma1 - suma2)
    sino
      si(suma2 > suma1)
        Informar(suma2 - suma1)
  fin
variables
  botAv1: tipo1
  botAv2: tipo1
  botardo: informante
comenzar
  AsignarArea(botAv1, primeraAv)
  AsignarArea(botAv2, segundaAv)
  AsignarArea(botardo, fiscalizadorArea)
  Iniciar(botAv1,1,1)
  Iniciar(botAv2,2,11)
  Iniciar(botardo,2,1)
fin