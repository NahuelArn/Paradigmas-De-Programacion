programa ejercicio1

procesos
  proceso depositarEnPos
  comenzar
    mientras(HayFlorEnLaBolsa)
      depositarFlor
  fin
  
  proceso juntarFlores(E avenida: numero)
  variables 
    floresTomadas: numero
    esquinasVacias: numero
  comenzar
    Pos(avenida,1)
    floresTomadas:= 0
    esquinasVacias:= 0
    repetir 99
      si ~(HayFlorEnLaEsquina)
        esquinasVacias:= esquinasVacias+1
      mientras(HayFlorEnLaEsquina)
        tomarFlor
        floresTomadas:= floresTomadas+1
      mover
    depositarEnPos
    Informar(floresTomadas,esquinasVacias)    
  fin
  
areas
  ciudad: AreaC(1,1,100,100)
robots
  robot  tipo1  
  comenzar
    juntarFlores(1)  
    juntarFlores(2) 
    juntarFlores(3) 
  fin
variables
  robot1: tipo1
comenzar
  AsignarArea(robot1,ciudad)
  Iniciar(robot1,1,1)  
fin
