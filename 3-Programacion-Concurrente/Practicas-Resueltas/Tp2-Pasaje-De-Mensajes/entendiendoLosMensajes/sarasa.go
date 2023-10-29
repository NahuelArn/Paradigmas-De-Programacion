programa eje4
procesos
  proceso limpiarFlores(ES cantFlores: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantFlores:= cantFlores+1
  fin
  proceso limpiarPapeles(ES cantPapeples: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      cantPapeples:= cantPapeples+1
  fin
  proceso calcularEsquina(ES Av: numero; ES Ca: numero)
  variables
    a1: numero
    a2: numero
  comenzar  
    Random(a1, 25,75)
    Random(a2, 25,75)
    Av:= a1
    Ca:= a2
  fin
  proceso quienEntra(ES botX: numero; ES cantTotal: numero)
  variables
    queRobot: numero
  comenzar
    Random(queRobot, 1,4)
    cantTotal:= 0
    si(queRobot = 1)
      EnviarMensaje(queRobot, bot1)
      EnviarMensaje(0,bot2)
      EnviarMensaje(0,bot3)
      EnviarMensaje(0,bot4) 
      RecibirMensaje(cantTotal, bot1)        
    sino
      si (queRobot= 2)
        EnviarMensaje(queRobot, bot2)
        EnviarMensaje(0, bot1)
        EnviarMensaje(0,bot3)
        EnviarMensaje(0,bot4)
        RecibirMensaje(cantTotal, bot2)
      sino 
        si(queRobot= 3)
          EnviarMensaje(queRobot, bot3)
          EnviarMensaje(0, bot1)
          EnviarMensaje(0,bot2)
          EnviarMensaje(0,bot4)
          RecibirMensaje(cantTotal, bot3)
        sino
          si(queRobot= 4)
            EnviarMensaje(queRobot, bot4)
            EnviarMensaje(0,bot1)
            EnviarMensaje(0,bot2)
            EnviarMensaje(0,bot3)
            RecibirMensaje(cantTotal, bot4)
      botX:= queRobot
  fin
  proceso asignarIds
  comenzar
    EnviarMensaje(1,bot1)
    EnviarMensaje(2,bot2)
    EnviarMensaje(3,bot3)
    EnviarMensaje(4,bot4)
  fin
  proceso inicializarContadores(ES cantBot1: numero;ES cantBot2: numero;ES cantBot3: numero;ES cantBot4: numero)
  comenzar
    cantBot1:= 0
    cantBot2:= 0
    cantBot3:= 0
    cantBot4:= 0
  fin 
  proceso asignacionCantId(E id: numero; E cantTotal: numero; ES cantBot1: numero; ES cantBot2: numero; ES cantBot3: numero; ES cantBot4: numero)
  comenzar
    si (id = 1)
      cantBot1:= cantBot1 + cantTotal
    sino
      si(id = 2)
        cantBot2:= cantBot2 + cantTotal
      sino
        si(id = 3)
          cantBot3:= cantBot3 + cantTotal
        sino
          si(id = 4)
            cantBot4:= cantBot4 + cantTotal
  fin
  proceso sacarMaxCantidad(ES idMax: numero; ES cantBot1: numero; ES cantBot2: numero; ES cantBot3: numero; ES cantBot4: numero)
  variables
    maxCantidad: numero
  comenzar
    idMax := 1
    maxCantidad := cantBot1
    si cantBot2 > maxCantidad
      maxCantidad := cantBot2
      idMax := 2
    si cantBot3 > maxCantidad
      maxCantidad := cantBot3
      idMax := 3
    si cantBot4 > maxCantidad
      maxCantidad := cantBot4
      idMax := 4
  fin
  proceso chequearSiGane(E gane: numero)
  comenzar
    si(gane = 0)      
      Informar('NOGane',0)
    sino
      si(gane = 1)
        Pos(50,50)
        Informar('Gane',1)
  fin
  proceso informarGanador(E id: numero)
  comenzar
    si(id = 1)
      EnviarMensaje(1, bot1)
      EnviarMensaje(0,bot2)
      EnviarMensaje(0,bot3)
      EnviarMensaje(0,bot4)      
    sino
      si (id = 2)
        EnviarMensaje(1, bot2)
        EnviarMensaje(0, bot1)
        EnviarMensaje(0,bot3)
        EnviarMensaje(0,bot4)
      sino 
        si(id = 3)
          EnviarMensaje(1, bot3)
          EnviarMensaje(0, bot1)
          EnviarMensaje(0,bot2)
          EnviarMensaje(0,bot4)
        sino
          si(id = 4)
            EnviarMensaje(1, bot4)
            EnviarMensaje(0,bot1)
            EnviarMensaje(0,bot2)
            EnviarMensaje(0,bot3)
  fin
	proceso logicaNormal
	comenzar
		EnviarMensaje(10,bot1)
		EnviarMensaje(10,bot2)
		EnviarMensaje(10,bot3)
		EnviarMensaje(10,bot4)
	fin
	proceso logicaTermino
	comenzar
		EnviarMensaje(20,bot1)
		EnviarMensaje(20,bot2)
		EnviarMensaje(20,bot3)
		EnviarMensaje(20,bot4)
	fin
areas
  trabajadores: AreaPC(25,25,75,75)
  state: AreaC(1,1,100,1)
  {posGanador: AreaC(50,50,50,50)}
robots
  robot  trabajador
  variables
    cantTotal: numero
    Av: numero
    Ca: numero
    PosInicialAV: numero
    PosInicialCA: numero
    cantFlores: numero
    cantPapeles: numero
    id: numero
    Gane: numero
    ok: numero
    logica: numero
  comenzar
    cantFlores:= 0
    cantPapeles:= 0
    PosInicialAV:= PosAv
    PosInicialCA:= PosCa
    RecibirMensaje(id, botFiscalizador)    {ya tiene cada uno un Id}
		RecibirMensaje(logica, botFiscalizador) {Que LOGICA aplicar  (10 normal) (20 termino}
		si(logica = 10)
			RecibirMensaje(ok, botFiscalizador)	{si este entra o no}
			si (ok <> 0)
				calcularEsquina(Av,Ca)
				Pos(Av,Ca)
				limpiarFlores(cantFlores)
				limpiarPapeles(cantPapeles)
			cantTotal:=  cantFlores + cantPapeles
			EnviarMensaje(cantTotal, botFiscalizador)
			Pos(PosInicialAV, PosInicialCA)
    
    {ESTA PARTE NO VA}
    sino
			si(logica = 20)
				RecibirMensaje(Gane, botFiscalizador) {1, si gane; 0 sino gane}
				chequearSiGane(Gane)
  fin
  robot  fiscalizador
  variables  {aca me serviria un vector contador para los 4 robots}
    id: numero
    cantTotal: numero
    cantBot1: numero
    cantBot2: numero
    cantBot3: numero
    cantBot4: numero
    idMax: numero
  comenzar
    asignarIds
    inicializarContadores(cantBot1,cantBot2,cantBot3,cantBot4)
    repetir 10 
			logicaNormal
      quienEntra(id,cantTotal)  {este se encarga recibir, el id y la cant}
      asignacionCantId(id,cantTotal,cantBot1,cantBot2,cantBot3,cantBot4)
    Informar('Saliste',122)
    sacarMaxCantidad(idMax,cantBot1,cantBot2,cantBot3,cantBot4)
		logicaTermino
    informarGanador(idMax)
  fin
variables
  bot1: trabajador
  bot2: trabajador
  bot3: trabajador
  bot4: trabajador
  botFiscalizador: fiscalizador
comenzar
  {lugar donde se mueven}
  AsignarArea(bot1, trabajadores)
  AsignarArea(bot2, trabajadores)
  AsignarArea(bot3, trabajadores)
  AsignarArea(bot4, trabajadores)
  {LugarDeEspera}
  AsignarArea(bot1, state)
  AsignarArea(bot2, state)
  AsignarArea(bot3, state)
  AsignarArea(bot4, state)
  AsignarArea(botFiscalizador, state)
  {Asignando sus posiciones de espera}
  Iniciar(botFiscalizador, 1,1)
  Iniciar(bot1, 25,1)
  Iniciar(bot2, 30,1)
  Iniciar(bot3, 35,1)
  Iniciar(bot4, 40,1)
fin