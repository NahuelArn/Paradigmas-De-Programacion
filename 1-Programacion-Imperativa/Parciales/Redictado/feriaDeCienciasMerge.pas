{1. En un colegio secundario, cada alumno participa de un proyecto de ciencias. 
* El proyecto de un alumno pertenece a un tópico (volcanes, vida marina, migración de las aves, etc.). 
* Un mismo alumno pudo haber presentado más de un proyecto (en distintos tópicos). 
* En la última hora del evento las personas visitantes pueden votar el proyecto del alumno que más le gustó.
a. Realice un programa para el sistema de votación. Un voto consiste en el nombre del alumno y el tópico en el cual pertenece el proyecto.
b. Almacene esta información en una estructura óptima para la búsqueda, ordenada por nombre de alumno. Para cada alumno almacene todos sus proyectos 
* ordenado por tópico.
c. Al finalizar la carga (se lee el alumno ‘zzz') se debe informar:
i. Cual fue el proyecto ganador: nombre del alumno, tópico y cantidad de votos.
ii. Número de votos totales, es decir la suma de los votos de todos los proyectos en los que participa un alumno, ordenados alfabéticamente por nombre de alumno.}
{
* a: registro voto = nombre, topico
* b: arbol --> ordenado por nombreDelAlumno --> con un campo lista ---> ordenado por topico --> q tiene topico y cant de votos 
* 		criterio de corte alumno con el nombre zzz
* c:
* 	i el proyecto en singular, busco en todo el arbol, sacando un maximo y guardandome el nombre del alumno y cant de votos 
* 	ii generar una lista ---> con un agregarAtras o adelante---> q tenga la cantTotal de votos de todos sus proyecto y su nombre
//.0,10}

{ ARBOL CON MERGE }
program sarasa;

type
	str20 = string[20];

	voto = record
		nombre: str20;
		topico: integer;
	end;
	//-------------------
	proyecto = record
		topico: integer;
		cantVotos: integer;
	end;

	listaTopicos = ^nodo;
	
	nodo = record
		dato: proyecto;
		sig: listaTopicos;	
	end;

	arbol = ^nodoArbol;

	nodoArbol = record
		nombre: str20;
		dato: listaTopicos;	
		hi: arbol; hd: arbol;
	end;
	//---------------------
	Lista2 = ^nodo2;

	nodo2 = record
		dato: voto;	//reutilizo me sirve sus tipos de campos
		sig: lLista2
	end;

procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;

procedure leerVoto(var v: voto);
begin
	Writeln('nombre: ');
	readln(v.nombre);
	if(v.nombre <> 'zzz')then
		begin
			Writeln('topico: ');
			readln(v.topico);
		end;
end;

procedure asignarCampos(var a: arbol; v: voto;var aux: proyecto);
begin
	a^.nombre:= v.nombre;
	//aux:= a^.dato;
	a^.dato:= nil;
	aux.topico:= v.topico;
	aux.cantVotos:= 1;
	//a^.dato:= aux; 
end;

procedure insertarOrdenado(var L:listaTopicos; aux: proyecto );
var
	nue,ant,act: listaTopicos;
begin
	new(nue);
	nue^.dato:= aux;
	ant:= L; act:= L;
	While(act <> nil) and (aux.topico > L^.dato.topico)do
		begin
			ant:= act;
			act:= act^.sig;
		end;
	if(ant = act)then
		L:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;

function buscarEnLista(var L: listaTopicos; topic: integer): listaTopicos;
begin
	if(L = nil)then
		buscarEnLista:= nil
	else
		begin
			if(L^.dato.topico = topic)then
				buscarEnLista:= L	
			else
				buscarEnLista:= buscarEnLista(L^.sig,topic);
		end;
end;

procedure incrementarVotos(var L: listaTopicos );
begin
	L^.dato.cantVotos:= L^.dato.cantVotos+1;
end;

procedure topicoNuevo(v: voto; var aux: proyecto);
begin
	aux.cantVotos:= 1;
	aux.topico:= v.topico;
end;

procedure cargarArbol(var a: arbol; v: voto);
var aux: proyecto;
	puntero: listaTopicos;
begin
	if(a = nil)then
		begin
			new(a);
			asignarCampos(a,v,aux);
			insertarOrdenado(a^.dato,aux);
			a^.hi:= nil; 
			a^.hd:= nil;
		end
	else
		begin
			if(v.nombre <= a^.nombre)then	
				begin
					if(v.nombre = a^.nombre)then
						begin
							puntero:= buscarEnLista(a^.dato,v.topico);
							if(puntero <> nil)then
								incrementarVotos(puntero)
							else
								begin
									topicoNuevo(v,aux);
									insertarOrdenado(a^.dato,aux);
								end;
						end;
					cargarArbol(a^.hi,v);
				end
			else
				begin
					if(v.nombre > a^.nombre)then	
						cargarArbol(a^.hd,v);
				end;
		end;
end;

procedure cargarVotos(var a: arbol);
var	v: voto;
begin
	leerVoto(v);
	While(v.nombre <> 'zzz')do
		begin
			//asignarCampos(a,v);
			cargarArbol(a,v);
			leerVoto(v);
		end;
end;

{i. Cual fue el proyecto ganador: nombre del alumno, tópico y cantidad de votos.
ii. Número de votos totales, es decir la suma de los votos de todos los proyectos en los que participa un alumno, 
* ordenados alfabéticamente por nombre de alumno.}
procedure sacarMaximoProyectoCadaTopico(L: listaTopicos; var L2,L3: Lista2);
var puntero: listaTopicos;
begin
	if(L <> nil)then
		begin
			puntero:= buscarTopico();
			if(puntero <> nil)then
				begin
					if()then
				end;
			if(L^.dato.cant)
		end
end;

procedure proyectoGanador(a: arbol; L2,L3: Lista2);
var
	ganador: proyecto;
begin
	if(a <> nil)then
		begin
			proyectoGanador(a^.hi,L2,L3);
			sacarMaximoProyectoCadaTopico(a,L2,L3);
			proyectoGanador(a^.hd,L2,L3);

		end;
end;

var
	a: arbol;
	L2: Lista2;
	L3: lista2
begin
	inicializarPuntero(a);
	cargarVotos(a);
	L2:= nil;
	L3:= nil
	L2:= a^.dato; //para tener algo con q compar y sacar el max
	proyectoGanador(a,L2,L3); //proyecto con mas votos
end.













{1. En un colegio secundario, cada alumno participa de un proyecto de ciencias. 
* El proyecto de un alumno pertenece a un tópico (volcanes, vida marina, migración de las aves, etc.). 
* Un mismo alumno pudo haber presentado más de un proyecto (en distintos tópicos). 
* En la última hora del evento las personas visitantes pueden votar el proyecto del alumno que más le gustó.
a. Realice un programa para el sistema de votación. Un voto consiste en el nombre del alumno y el tópico en el cual pertenece el proyecto.
b. Almacene esta información en una estructura óptima para la búsqueda, ordenada por nombre de alumno. Para cada alumno almacene todos sus proyectos 
* ordenado por tópico.
c. Al finalizar la carga (se lee el alumno ‘zzz') se debe informar:
i. Cual fue el proyecto ganador: nombre del alumno, tópico y cantidad de votos.
ii. Número de votos totales, es decir la suma de los votos de todos los proyectos en los que participa un alumno, ordenados alfabéticamente por nombre de alumno.}
{
* a: leerVoto [ nombre, topico]
* b: b: almacenar esta data en un arbol ordenado por nombre y cada un campo es tiene una lista de sus topicos que presento el alumno
* 	la carga se corta cuando se lee el alumno zzz
* i: hacer una especie de lista contadora, hacer una lista q cada nodo sea el maximo de cant de votos y nombre and topico (meter corte de control)
* ii: recorrer el arbol y contar todos los votos e ir generando una lista con agregarAdelante o atras ya que la estructura ya esta ordenada
* } 
//0,10


// program sarasa;

// type
// 	str20 = string[20];
// 	voto = record
// 		nombre: str20;
// 		topico: integer; //los topicos los manejo como integer (1: volcanes, 2: vida marina, 3: migración de las aves, etc.). 
// 	end;
// 	//-----------------------
// 	lista = ^nodo;
	
// 	nodo = record
// 		dato: integer;
// 		sig: lista;	
// 	end;

// 	arbol = ^nodoArbol;

// 	nodoArbol = record
// 		nombre: str20;
// 		dato: lista; 
// 		hi: arbol;
// 		hd: arbol;
// 	end;

// 	//-----
// 	nE = record
// 		nombre: str20;	
// 		cantVotos: integer;
// 		topico: integer;
// 	end;
	
// 	listai = ^nodo3

// 	nodo3 = record
// 		dato: nE;
// 		sig: listai;
// 	end;

// procedure inicializarPuntero(var a: arbol);
// begin
// 	a:= nil;
// end;

// procedure leerVoto(var v: voto);
// begin
// 	Writeln('nombre: (zzz para cortar) ');
// 	readln(v.nombre);
// 	Writeln('topico: ');
// 	readln(v.topico);
// end;

// procedure asignarCampos(var a: arbol; v: voto);
// begin
// 	a^.nombre:= v.nombre;
// 	a^.dato:= nil;
// end;

// procedure insertarOrdenado(var L: lista; t: integer);
// var nue,ant,act: lista;
// begin
// 	new(nue);
// 	nue^.dato:= t;
// 	ant:= L; act:= L;
// 	While(act <> nil) and (t > act^.dato)do
// 		begin
// 			ant:= act;	
// 			act:= act^.sig;
// 		end;
// 	if(ant = act)then
// 		L:= nue
// 	else
// 		ant^.sig:= nue;
// 	nue^.sig:= act;
// end;

// procedure cargarArbol(var a: arbol; v: voto);	//no voy a tener alumnos repetidos, voy a tener topicos del alumno tal vez repetidos

// begin	
// 	if(a = nil)then
// 		begin
// 			new(a);
// 			asignarCampos(a,v);
// 			insertarOrdenado(a^.dato, v.topico);
// 			//a^.dato:= v;
// 			a^.hi:= nil;
// 			a^.hd:= nil;
// 		end
// 	else
// 		begin
// 				if(v.nombre = a^.nombre)then
// 					insertarOrdenado(a^.dato, v.topico);
// 				if(v.nombre < a^.nombre)then
// 					cargarArbol(a^.hi,v)
// 				else
// 					if(v.nombre < a^.nombre)then
// 						cargarArbol(a^.hd,v)
// 		end;
// end;

// procedure cargarVotos(var a: arbol);
// var	v: voto;
// begin
// 	leerVoto(v);
// 	While(v.nombre <> 'zzz')do
// 		begin
// 			cargarArbol(a,v);
// 			leerVoto(v)
// 		end;

// end;

// {c. Al finalizar la carga (se lee el alumno ‘zzz') se debe informar:
// i. Cual fue el proyecto ganador: nombre del alumno, tópico y cantidad de votos.}
// {* i: hacer una especie de lista contadora, hacer una lista q cada nodo sea el maximo de cant de votos y nombre and topico (meter corte de control)
// }
// function buscarCod(L2: : listai; topic: integer): listai;
// begin
// 	if(L2 = nil)then
// 		buscarCod:= nil
// 	else
// 		begin
// 			if(topic = L2^dato.topico)then
// 				buscarCod:= L2
// 			else
// 				buscarCod:= buscarCod(L2^.sig,topic);
// 		end;
// end;

// procedure logicaDeActualizarMax(var L2: listai; aux: integer);
// var max: integer;
// begin
// 	if(L2 = nil)then
// 		agregarAdelante(L2,);
// end;

// procedure cargarEstructuraGanadores(a: arbol; var L2: listai);
// var aux: integer; cont : integer; puntero: listai;
// begin
// 	While(a^.dato <> nil)do
// 		begin
// 			aux:= a^.dato^.dato; cont:= 0;
// 			While(a^.dato <> nil) and (aux = a^.dato^.dato)do
// 				begin
// 					cont:= cont+1;
					
// 				end;
// 			puntero:= (buscarCod(L2,aux);
// 			if(puntero = nil)then
// 				agregarAdelante(L2,cont,aux);	
// 			else	
// 				logicaDeActualizarMax(puntero,aux,cont);
// 			else
// 				logicaDeActualizarMax(L2,aux,cont);
// 			if(L2 = nil)then
// 				begin
// 					max:= -999;
					
// 				end;
// 			if(sacarMax(()))then
// 			asignarCamposI(aux,);
// 		end;
// end;

// procedure ganadoresPorTopico(a: arbol; var L2: listai);

// begin
// 	if(a <> nil)then
// 		begin
// 			ganadoresPorTopico(a^.hi,L2);
// 			cargarEstructuraGanadores(a,L2);

// 			ganadoresPorTopico(a^.hD,L2);
// 		end;
// end;

// var
// 	a: arbol;
// 	L2: listai;
// begin
// 	inicializarPuntero(a);
// 	cargarVotos(a);
// 	L2:= nil;
// 	ganadoresPorTopico(a,L2);
// end.


