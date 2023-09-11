{Una facultad nos ha encargado procesar la información de sus alumnos de la carrera XXX.
Esta carrera tiene 30 materias. Implementar un programa con:
a. Un módulo que lea la información de los finales rendidos por los alumnos y los
almacene en dos estructuras de datos.
i. Una estructura que para cada alumno se almacenen sólo código y nota de las
materias aprobadas (4 a 10). De cada final rendido se lee el código del alumno, el
código de materia y la nota (valor entre 1 y 10). La lectura de los finales finaliza con
nota -1. La estructura debe ser eficiente para buscar por código de alumno.
ii. Otra estructura que almacene para cada materia, su código y todos los finales
rendidos en esa materia (código de alumno y nota).
b. Un módulo que reciba la estructura generada en i. y un código de alumno y retorne los
códigos y promedios de los alumnos cuyos códigos sean mayor al ingresado.
c. Un módulo que reciba la estructura generada en i., dos códigos de alumnos y un valor
entero, y retorne la cantidad de alumnos con cantidad de finales aprobados igual al
valor ingresado para aquellos alumnos cuyos códigos están comprendidos entre los dos
códigos de alumnos ingresados.
2}
//codigoDeAlumno, codigoDeMateria
//i solo se almacena el codigo de alumno y lo nota de la materia aprobada, como se a q materia pertenece? por q voy a tener un vector y leo el final q en el final tengo codMateria y codAlumno
{	a:
* i: vector de 1..30 de arboles, cada materia [i], su arbol va estar ordenado por cod de alumno
* ii: vector de 1..30 pero de listas me guardo en la estructura principal el cod de materia asi no se repite en la lista
* b: sacar el promedio de un rango superior en el arbol
* c: entre valores y cantidad de alumnos q tengan 
* }
	//esta maldito el codigo, falla en mi corte de control todo meado
program ejercicio3;

const
	dimF30 = 30;
type
	
	rango30 = 1..dimF30;
	rango10 = -1..10;
	
	finalRendido = record
		codAlumno: integer;
		codMateria: rango30;
		nota: rango10;
	end;
	
	//----------------------------
	rango4a10 = 4..10;
	
	finalAprobado = record
		codAlumno : integer;
		nota: rango4a10; //solo se acepta de 4 a 10
		//nota: integer; //lo puse tipo integer para poder reutilizar el registro, igual el corte lo hago con not >= 4 y <= 10, asi q no pasa naty
	end;
	
	arbol = ^arbolAprobados;
	
	arbolAprobados = record
		dato: finalAprobado;
		hi: arbol;
		hd: arbol;
	end;
	
	vectorMaterias = array[rango30] of arbol;
	
	//----------------------------------------------
	lista = ^nodo;
	
	nodo = record
		dato: finalRendido; //final aprobado como no aprobado
		sig: lista;
	end;
	
	vectorTodosLosFinales = array[rango30] of lista;
	
	//--------------------------------------------------
	puntoB = record
		codAlumno: integer;
		promedio: real;	//promedio como yo en mi estructura I tengo directamte la nota aprobada, esa nota corresponde al promedio
		//la nota final se saca, con la suma de las notas, ahora si aca esta una nota, significa que es el promedio final q obtuvo, presentandose 1 o varias veces le dio esta nota
	end;
	
	lista2= ^nodo2;
	
	nodo2 = record
		dato: puntoB;
		sig: lista2;
	end;
	
procedure inicializarPuntero(var a: arbol; var L: lista);
begin
	a:= nil;
	L:= nil;
end;
	
procedure inicializarEstructuras(var vM: vectorMaterias; var vT: vectorTodosLosFinales);
var i: integer;
begin
	for i:= 1 to dimF30 do
		inicializarPuntero(vM[i],vT[i]);
end;
	
procedure leerFinal(var f: finalRendido);
begin
	Writeln('Ingrese la nota la materia (1..10)- (con -1 corta )');
	//f.nota:= random(11)-1;
	readln(f.nota);
	if(f.nota <> -1 )then
		begin
			Writeln('Ingrese el codigo del alumno: ');
			readln(f.codAlumno);
			Writeln('Ingrese el cod de la materia: ');
			//f.codMateria:= random(31)+1;
			readln(f.codMateria);
		end;
end;

//filtra la data de la informacion del final rendido, si estas aca el alumno aprobo el final de la materia
procedure estructuraQueSeGuarda(f: finalRendido; var aP: finalAprobado);
begin
	aP.codAlumno:= f.codAlumno;
	aP.nota:= f.nota;
end;

//carga a la estructura de datos los alumnos aprobados
procedure guardarAlumnoAprobado(var a: arbol; aP: finalAprobado);	//no se permiten repetidos, si un alumno aprueba una materia no va a volver a rendir el final q ya aprobo
begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= aP;
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(aP.codAlumno <= a^.dato.codAlumno)then	// 
				guardarAlumnoAprobado(a^.hi,aP)
			else
				begin
					if(aP.codAlumno > a^.dato.codAlumno)then
						guardarAlumnoAprobado(a^.hd,aP)
				end;
		end;
end;

procedure agregarAdelante(var L: lista; f: finalRendido);
var nue: lista;
begin
	new(nue);
	nue^.dato:= f;
	nue^.sig:= L;
	L:= nue;
end;

//procedure insertarOrdenado(var L: lista; f: finalRendido);
//var ant,act,nue: lista;
//begin
//	new(nue);
//	nue^.dato:= f;
//	ant:= L;
//	act:= L;
//	While(act <> nil) and (f.codAlumno > act^.dato.codAlumno) do
//		begin
//			ant:= act;
//			act:= act^.sig;
//		end;
//	if(act <> nil)then
//		begin
//			if(ant = act)then
//				L:= nue
//			else
//				ant^.sig:= nue;
//			nue^.sig:= act;
//		end;
//end;

procedure cargarFinales(var vM: vectorMaterias;var vT: vectorTodosLosFinales);
var
	f: finalRendido;	// F = registro general que se guarda la informacion del finla rendido
	aP: finalAprobado;	//aP: alumnoAprobado; // aP = registro de aprobados q se guarda en el arbol
begin
	leerFinal(f);	// F = registro general que se guarda la informacion del finla rendido
	While(f.nota <> -1)do
		begin
			if(f.nota >= 4) and (f.nota <= 10)then
				begin
					estructuraQueSeGuarda(f,aP);
					guardarAlumnoAprobado(vM[f.codMateria],aP);	//ya se guarda la data del alumno aprobado		
				end;
			agregarAdelante(vT[f.codMateria],f);	//carga finales aprobados y desaprobados, sin ningun orden (solo se filtra por materia)
			//insertarOrdenado(vT[f.codMateria],f); //cambio de estructura para ordenarlos por cod de alumno
			leerFinal(f);
		end;
end;
{b. Un módulo que reciba la estructura generada en i. y un código de alumno y retorne los
códigos y promedios de los alumnos cuyos códigos sean mayor al ingresado.}
//aaaaaaaaaaa promedios, por cada alumno creo un nodo en mi lista y voy sumando sus notas de aprobados de sus 30 materias, una vez q recorri las 30 materias
//saco el promedio de cada uno, sobreescribo el valor promedio

//Vos lo q recorres es un arbol que esta ordenado por codigo de alumno, cada nodo tiene su nota de aprobado
procedure insertarOrdenadoVariacion(var L: lista2; nE: puntoB);
var
	ant,act,nue: lista2;
begin
	act:= L;
	ant:= L;
	new(nue);
	Writeln('te llega la nota flaquito? ',nE.promedio);
	Writeln('te llega la codALumno flaquito? ',nE.codAlumno);
	nue^.dato:= nE;
	While(act <> nil) and (nE.codAlumno > L^.dato.codAlumno) and (act^.dato.codAlumno <> nE.codAlumno)do
		begin
			ant:= act;
			act:= act^.sig;
		end;
		if(ant = act)then	//si es el primer elemento de la lista o es vacio
			begin
				//nue^.dato.promedio:= 0;
				L:= nue;
			end
		else
			begin
				if(act^.dato.codAlumno = nE.codAlumno)then	//si se encontro que ya existia ese codigo de alumno en la estructura
					act^.dato.promedio:= act^.dato.promedio + nE.promedio
				else
					begin	//si no es el primer elemento y no se encontro ese codigo en toda la estructura, lo inserto ordenado
						//new(nue);
						//nue^.dato:= nE;
						ant^.sig:= nue;
					end;
				nue^.sig:= act;
			end;
end;

procedure reasignarData(f: finalAprobado; var nE: puntoB);
begin
	nE.codAlumno:= f.codAlumno;
	nE.promedio:= f.nota;
end;

procedure obtenerAlumnosMayores( a: arbol;var L:lista2; codAlumnoBase: integer);
var
	nE: puntoB;
begin
	if(a <> nil)then
		begin
			if(a^.dato.codAlumno > codAlumnoBase)then
				begin
					obtenerAlumnosMayores(a^.hi,L,codAlumnoBase);
					reasignarData(a^.dato,nE);
					Writeln('--entre aca 3 -');
					insertarOrdenadoVariacion(L,nE);
					obtenerAlumnosMayores(a^.hd,L,codAlumnoBase);
					Writeln('--entre aca 4 -');
				end
			else
				obtenerAlumnosMayores(a^.hd,L,codAlumnoBase);
		end
end;

procedure recorrerAprobados(vM: vectorMaterias; var L: lista2; codAlumnoBase: integer);
var
	i: integer;
begin
	Writeln('--entre aca 1 -');
	for i:= 1 to dimF30 do
		begin
			if(vM[i] <> nil)then
				begin
					obtenerAlumnosMayores(vM[i],L,codAlumnoBase);
				end;
		end;
	Writeln('--entre aca 2 -');
end;

procedure imprimirListaNormal(L: lista2);
begin
	if(L <> nil)then
		begin
			Writeln('codigo de alumno ',L^.dato.codAlumno);
			Writeln('promedio de alumno ',L^.dato.promedio);
			imprimirListaNormal(L^.sig);
		end;
end;


procedure imprimirArbol(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirArbol (a^.hi);
			Writeln('nota: ',a^.dato.nota);
			imprimirArbol(a^.hd);
		end;
end;

var
	vM : vectorMaterias;
	vT: vectorTodosLosFinales;
	L2: lista2;
	codAlumnoBase: integer;
begin
  randomize;
	inicializarEstructuras(vM,vT);
	cargarFinales(vM,vT);
	imprimirArbol(vM[1]);
	imprimirArbol(vM[2]);
	//
	L2:= nil;
	Writeln('punto b, ingrese un numero para sacar el promedio de todos los almns aprbdos con cod mayor q ese ');
	readln(codAlumnoBase);
	recorrerAprobados(vM,L2,codAlumnoBase);
	Writeln('--entre aca 1 -');
	imprimirListaNormal(L2);
end.
