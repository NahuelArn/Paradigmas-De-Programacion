{La ciudad de La Plata está organizando un festival de música. 
Para ello abrió la inscripción para que las bandas locales puedan participar del festival. 
De cada banda se desea conocer su nombre, estilo musical (un string) y cantidad de integrantes.
a) Implementar un módulo que permita la inscripción de las bandas. El ingreso de datos finaliza con la banda que tiene cero integrantes. 
Los datos deben estar almacenados en una estructura ordenada por nombre de banda y ser eficiente para la búsqueda por ese criterio.
b) Implementar un módulo que reciba la estructura generada en a) y devuelva una nueva estructura, ordenada por estilo musical, con todos los solistas 
(bandas con cantidad de integrantes igual a uno).
c) Implementar un módulo recursivo que reciba la estructura generada en a) y devuelva el nombre de la banda con más integrantes.}

{
  a: arboles de bandas ---> ordenado por nombreDeBanda---> corte de carga = cero integrantes
  b: lista normal, con insertarOrdenado por estiloMusica y que cantIntegrantes = 1
  c: recibe el arbol, y el procedimiento devuelve el nombre con la banda con mas integrantes
} 

program Tema1_300323;


	
type
	str20 = string[20];
	
	banda = record
		nombre: str20;
		estiloMusical: string;
		cantIntegrantes: integer;
	end;
	
	arbol = ^ nodoBanda;
	
	nodoBanda = record
		dato: banda;
		hi: arbol;
		hd: arbol;
	end;
	
//	Writeln('------------------');
	
	lista = ^nodo;
	
	nodo = record
		dato: banda;
		sig: lista;
	end;
procedure inicializarArbol(var a: arbol);
begin
	a:= nil
end;

procedure leerBanda(var b: banda);	//no uso random por q no tengo datos basura para el debuggin
begin
	Writeln('Ingrese el nombre de la banda: ');
	readln(b.nombre);
	Writeln('Ingrese el estilo musical: ');
	readln(b.estiloMusical);
	Writeln('Ingrese la cantidad de integrantes' );
	readln(b.cantIntegrantes);
end;

procedure cargarArbol(var a: arbol; b: banda);
begin
	if(a= nil)then
		begin
			new(a);
			a^.dato:= b;
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(b.nombre <= a^.dato.nombre)then
				cargarArbol(a^.hi,b)
			else
				cargarArbol(a^.hd,b);
		end;
	
end;

procedure cargarBandas(var a: arbol);
var
	b: banda;
begin
	leerBanda(b);
	While(b.cantIntegrantes <> 0)do
		begin
			cargarArbol(a,b);
			leerBanda(b);
		end;
end;

procedure inicializarLista(var L: lista);
begin
	L:= nil
end;

procedure insetarOrdenado(var L: lista; b: banda);
var
	ant,act: lista;
	nue: lista;
begin
	new(nue);
	nue^.dato:= b;
	ant:= L;
	act:= L;
	While(act <> nil) and (b.estiloMusical < L^.dato.estiloMusical)do
		begin
			ant:= act;
			act:= act^.sig;
		end;
	if(ant = act)then
		L:= nue
	else
		ant^.sig:= act;
	act^.sig:= nue;
end;

//recorro todo el arbol, no tengo match con el criterio de orden
procedure puntoB(a: arbol; var L: lista);
begin
	if(a <> nil)then
		begin	//nueva estructura ordenada por estilo musical, insertarOrdenado
			if(a^.dato.cantIntegrantes = 1)then
				insetarOrdenado(L,a^.dato);
			puntoB(a^.hi,L);
			puntoB(a^.hd,L);
		end;
end;
////recorro todo el arbol, no tengo match con el criterio de orden
procedure puntoC(a: arbol;var bandaTop: str20; var cantIntegrantes: integer);
begin
	if(a <> nil)then
		begin
			if(a^.dato.cantIntegrantes > cantIntegrantes)then
				begin
					cantIntegrantes:= a^.dato.cantIntegrantes;
					bandaTop:= a^.dato.nombre;
				end;
			puntoC(a^.hi,bandaTop,cantIntegrantes);
			puntoC(a^.hd,bandaTop,cantIntegrantes);
		end;
end;

var
	a: arbol;
	L: lista;
	bandaTop: str20;
	cantIntegrantes: integer;
begin
	inicializarArbol(a);
	cargarBandas(a);
	inicializarLista(L);
	puntoB(a,L);
	bandaTop:= 'ninguna';
	cantIntegrantes:= -9999;
	puntoC(a,bandaTop,cantIntegrantes);//procedimiento  porq el string es un dato compuesto
	Writeln('La banda con mas integrantes es: ',bandaTop,' con ',cantIntegrantes);
end.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
