programa ejercicio1

procesos
  proceso depositarEnPos
  comenzar
    mientras(HayFlorEnLaBolsa)
      depositarFlor
  fin
  
  proceso juntarFlores
  variables 
    floresTomadas: numero
    esquinasVacias: numero
  comenzar
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
  ciudad1: AreaC(1,1,1,100)
  ciudad2: AreaC(3,1,3,100)
  ciudad3: AreaC(5,1,5,100)
robots
  robot  tipo1  
  comenzar
    juntarFlores 
  fin
variables
  robot1: tipo1
  robot2: tipo1
  robot3: tipo1
comenzar
  AsignarArea(robot1,ciudad1)
  AsignarArea(robot2,ciudad2)
  AsignarArea(robot3,ciudad3)
  Iniciar(robot1, 1, 1)
  Iniciar(robot2, 3, 1)
  Iniciar(robot3, 5, 1)
fin