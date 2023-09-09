{
* Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).
b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.
c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.
d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.
g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.
h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.
i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos)

{Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).
b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.
c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.
d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.
g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.
h. Un módulo recursivo que reciba la estructura generada en g. y muestre su contenido.
i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos)

}
{contexto
}

program ejercicio2;

type
	rango12 = 1..12;
	rango31 = 1..31;
	
  prestamo = record
    isbn: integer;
    numSocio: integer;
    dia: rango31;
    mes: rango12;
    cantDiasPrestados: integer;
  end;

  {i. En una estructura cada préstamo debe estar en un nodo.}

  arbol0 = ^a0;	//arbol 0

  a0 = record 
    dato: prestamo;
    hi: arbol0;
    hd: arbol0;
  end;
  {ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.}
  listaRepetidos = ^nodoRepetidos;
	
	nodoRepetidos = record
		dato: prestamo;
		sig: listaRepetidos;
	end;

  arbol2 = ^a2;	//arbol 2
  
  a2 = record 
    dato: listaRepetidos;
    hd: arbol2;
    hi: arbol2;
  end;
  //--------------------
  prestamosTotales = record
		isbn: integer;
		cantPrestamos: integer;
	end;
	
  listaF = ^nodoLista;
  
  nodoLista = record
		dato: prestamosTotales;
		sig: listaF;
	end;
	
procedure inicializarPunterosArbol(var a0: arbol0; var a2: arbol2);
begin
	a0:= nil;
	a2:= nil;
end;

procedure leerPrestamo(var p: prestamo);
begin
	Writeln('Ingrese el isb: (corta con -1 )');
	readln(p.isbn);
	if(p.isbn <> -1)then
		begin
			Writeln('Ingrese el numero de socio: ');
			readln(p.numSocio); 
			Writeln('Ingrese el dia del prestamo ');
			p.dia:= random(32)+1;
			Writeln('Ingrese el mes del prestamo ');
			p.mes:= random(13)+1;
			Writeln('Ingrese la cantidad de dias prestados ');
			p.cantDiasPrestados:= random(100)+1; //puede tener 0 prestamos en mi programa
		end;
end;
//carga Arbol normalito
procedure cargarArbol0(var a0: arbol0; p: prestamo);
begin
	if(a0 = nil)then
		begin
			new(a0);
			a0^.dato:= p;
			a0^.hi:= nil;
			a0^.hd:= nil;   
		end
	else
		begin
			if(p.isbn <= a0^.dato.isbn)then
				cargarArbol0(a0^.hi,p)
			else
				cargarArbol0(a0^.hd,p);
		end;
end;

procedure inicializarListaArb2(var L: listaRepetidos);
begin
	L:= nil;
end;
//es la variacion del agregarAtras con un Ult, pero en este caso se tiene que usar asi porq tendrias q tener Ult para las N listas
procedure agregarAtrasIneficiente(var L: listaRepetidos; p: prestamo);
var
	ant,act,nue: listaRepetidos;
begin
	new(nue);
	nue^.dato:= p;
	ant:= L;
	act:= L;
	While(act <> nil)do
		begin
			ant:= act;
			act:= act^.sig;
		end;
	if(ant = act)then
		L:= nue
	else
		ant^.sig:= nue;	//entonces ant = era el ultimo en la lista
	nue^.sig:= act;	//al nue . sig le asigno nil, 
end;

//carga el arbol de listas
procedure cargarArbol2(var a2: arbol2; p: prestamo);
var
	aux: prestamo;
begin
	if(a2 = nil)then
		begin
			new(a2);
			inicializarListaArb2(a2^.dato);
			agregarAtrasIneficiente(a2^.dato,p);
			Writeln(); Writeln();
			//Writeln('Que valor se esta guardando en el arbol2 ',a2^.dato^.dato.isbn);
			Writeln(); Writeln();
			a2^.hi:= nil;
			a2^.hd:= nil;
		end
	else
		begin
			aux:= a2^.dato^.dato;
			if(p.isbn = aux.isbn)then
				agregarAtrasIneficiente(a2^.dato,p)
      else
        begin
          if(p.isbn < aux.isbn)then
              cargarArbol2(a2^.hi,p)
          else
            cargarArbol2(a2^.hd,p);
        end;
		end;
end;
//carga de los arboles de forma iterativa
procedure cargarPrestamos(var a0: arbol0;var a2: arbol2);
var
	p: prestamo;
begin
	leerPrestamo(p);
	While(p.isbn <> -1)do
		begin
			cargarArbol0(a0,p);
			cargarArbol2(a2,p);
			leerPrestamo(p);
		end;
end;

//modulo Para los 2 arboles imprimir
procedure imprimirPrestamo(p: prestamo);
begin
  Writeln();
	Writeln('El isbn del arbol: ',p.isbn);
	Writeln('El numero de socio: ',p.numSocio);
	Writeln('El dia del prestamo del socio: ',p.dia);
	Writeln('El mes del prestamo ',p.mes);
	Writeln('La cantidad de dias prestado ',p.cantDiasPrestados);
  Writeln('-----------------------------------------------------------');
end;
//Modulo del Arbol normalito
procedure imprimirInOrder0(a0: arbol0);
begin
	if(a0 <> nil)then
		begin
			imprimirInOrder0(a0^.hi);
			imprimirPrestamo(a0^.dato);
			imprimirInOrder0(a0^.hd);
		end;
end;
//Modulos del Arbol de Listas (recorre una lista y va imprimiendo su contendio)
procedure imprimirLista(L: listaRepetidos);
begin
	While(L <> nil)do
		begin
			imprimirPrestamo(L^.dato);
			L:= L^.sig;
		end;
end;
//recorre el arbol, cuando llega a nil empieza el backtracking y va mandando la lista que esta en ese nodo a otro modulo
procedure imprimirInOrder2(a2: arbol2);
begin
	if(a2 <> nil)then
		begin
			imprimirInOrder2(a2^.hi);
			imprimirLista(a2^.dato);
			imprimirInOrder2(a2^.hd);
		end;
end;

//------------------------------------------------------------------------


{b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.}


{ Modulos Max Arbol (aprovechando el criterio de orden)
procedure isbnMasGrande(a0: arbol;var isbnMax: integer);
begin
	if(a0 <> nil)then
		begin
			if(a0^.hd = nil)then
				isbnMax:= a0^.dato
			else
				isbnMasGrande(a0^.hd,isbMax);
		end
	else
		isbnMax:= 0;
end;
}
function isbnMasGrande(a0: arbol0): integer;
begin
	if(a0 = nil)then
		isbnMasGrande	:= 0
	else
		begin
			if(a0^.hd = nil)then
				isbnMasGrande:= a0^.dato.isbn
			else
				isbnMasGrande	:= isbnMasGrande(a0^.hd);
		end;
end;
//------------------------------------------------------------------------

{c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
	pequeño.} //aprovecho el criterio de orden del arbol
	
//Modulos Min Arbol (aprovechando el criterio de orden)	
{
procedure minimoDelArbol(a2 arbol2; var isbnMinimo: integer);
begin
	if(a2 <> nil)then
		begin
			if(a2^.hi = nil)then
				isbMinimo:= a2^.dato^.dato.isbn
			else
				minimoDelArbol:= minimoDelArbol(a2^.hi,isbnMinimo);
		end
	else
		isbnMinimo:= 0;
end;
}
function minimoDelArbol(a2: arbol2): integer;
begin
	if(a2 = nil)then
		minimoDelArbol:= 0
	else
		begin
			if(a2^.hi = nil)then
				minimoDelArbol:= a2^.dato^.dato.isbn
			else
				minimoDelArbol:= minimoDelArbol(a2^.hi);
		end;
end;
//------------------------------------------------------------------------
{d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.}
{no match criterio de orden, tengo que recorrer todo el arbol}

//con procedimiento no se puede sacar creo(por q solo podes recibir 2 valores por parametro)
// procedure cuantosPrestamosTieneElSocio(a0: arbol0; numSocio: integer; var cantPrestamos:integer);
// begin
// 	if(a0 <> nil)then
// 		begin
// 				cuantosPrestamosTieneElSocio(a0^.hi,numSocio,cantPrestamos);
// 				if(a0^.dato.numSocio = numSocio)then
// 					begin
// 						cantPrestamos:= cantPrestamos+1;
// 						Writeln('a ',cantPrestamos);
// 					end;
// 				cuantosPrestamosTieneElSocio(a0^.hd,numSocio,cantPrestamos);
// 		end
	
// end;

function cuantosPrestamosTieneElSocio(a0: arbol0; numSocio: integer): integer;
begin
	if(a0 = nil)then
		cuantosPrestamosTieneElSocio:= 0
	else
		begin 
			if(a0^.dato.numSocio = numSocio)then
				cuantosPrestamosTieneElSocio:= cuantosPrestamosTieneElSocio(a0^.hi,numSocio)+cuantosPrestamosTieneElSocio(a0^.hd,numSocio)+1
			else
				cuantosPrestamosTieneElSocio:= cuantosPrestamosTieneElSocio(a0^.hi,numSocio) + cuantosPrestamosTieneElSocio(a0^.hd,numSocio);
		end
end;
//------------------------------------------------------------------------

{e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
}
//con prodimiento necesito una var +1 pasada por parametro, entonces solo uso la funcion para este caso
{procedure sacarCantPrestamosSocio(L: listaRepetidos;numSocio: integer; var cantPrestamos: integer);
begin
	if(L <> nil)then
		begin
			if(L^.dato.numSocio = numSocio)then
				cantPrestamos:= cantPrestamos+1;
			sacarCantPrestamosSocio	(L^.sig,numSocio,cantPrestamos);
		end
end;

procedure cuantosPrestamosTieneElSocioA2(a2: arbol2; numSocio: integer; var cantPrestamos: integer);
begin
	if(a2 <> nil)then
		begin
			cuantosPrestamosTieneElSocioA2(a2^.hi,numSocio,cantPrestamos);		
			sacarCantPrestamosSocio(a2^.dato,numSocio,cantPrestamos);
			cuantosPrestamosTieneElSocioA2(a2^.hd,numSocio,cantPrestamos);
		end
end;}

function cuantasVecesEstaElSocioEnLista(L: listaRepetidos; numSocio: integer): integer;
begin
	if(L = nil)then
		cuantasVecesEstaElSocioEnLista:= 0
	else
		begin
			if(L^.dato.numSocio = numSocio)then
				cuantasVecesEstaElSocioEnLista:= cuantasVecesEstaElSocioEnLista(L^.sig,numSocio)+1
			else
				cuantasVecesEstaElSocioEnLista:= cuantasVecesEstaElSocioEnLista(L^.sig,numSocio);
		end;
end;

function cuantosPrestamosTieneElSocioA2(a2: arbol2; numSocio: integer): integer;
begin
	if(a2 = nil)then
		cuantosPrestamosTieneElSocioA2:= 0
	else
		begin
			//cuantosPrestamosTieneElSocioA2:= cuantosPrestamosTieneElSocioA2(a2^.hi,numSocio)+ cuantosPrestamosTieneElSocioA2(a2^.hd,numSocio)+ cuantasVecesEstaElSocioEnLista(L^.dato,numSocio);
			cuantosPrestamosTieneElSocioA2:= cuantosPrestamosTieneElSocioA2(a2^.hi,numSocio)+ cuantasVecesEstaElSocioEnLista(a2^.dato,numSocio) + cuantosPrestamosTieneElSocioA2(a2^.hd,numSocio);
		end;
end;
//------------------------------------------------------------------------
procedure inicializarListaPuntoFyG(var L,L2G: listaF);
begin
	L:= nil;
	L2G:= nil;
end;

{f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}
//Se podria ir recorriendo el arbol2 y enganchando punteros, seria mas eficiente en tiempo de ejecucion

//carga data filtrada
procedure cargarDataCompartida(var nE: prestamosTotales; p: prestamo );
begin
	nE.isbn:= p.isbn;
	nE.cantPrestamos:= nE.cantPrestamos+1;
end;
//agrega atras recorriendo toda la lista
procedure agregarAtrasIneficiente(var L: listaF; p: prestamo);
var
	nE: prestamosTotales;
	ant,act,nue: listaF;
begin
	ant:= L;
	act:= L;
	new(nue);
	nE.cantPrestamos:= 0;	//si estoy aca es por q cambio el isbn y estoy creando un nuevo nodo para otro isbn
	cargarDataCompartida(nE,p);
	//nE.cantPrestamos:= 0;	//si estoy aca es por q cambio el isbn y estoy creando un nuevo nodo para otro isbn
	nue^.dato:= nE;
	while (act <> nil) do
		begin
			ant:= act;
			act:= act^.sig;
		end;
	if(act = ant)then
		L:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;



// function buscarUltimoIsb(L: listaF): integer;
// begin
// 	if(L^.sig = nil)then
// 		buscarUltimoIsb:= L^.dato.isbn
// 	else	
// 		buscarUltimoIsb(L^.sig);
// end;
// function buscarUltimoIsb(L: listaF;isbnActual: integer): integer;
// begin
// 	if(L = nil)then	
// 		buscarUltimoIsb:= -1
// 	else
// 		begin
// 			if(L^.dato.isbn = isbnActual)then
// 				buscarUltimoIsb:= isbnActual
// 			else
// 				buscarUltimoIsb:= buscarUltimoIsb(L^.sig,isbnActual);
// 		end;
// end;
//buca en la lista si hay alguno nodo con el isbn actual, y si hay lo agrego
function buscarUltimoIsb(L: listaF;isbnActual: integer): listaF;
begin
	if(L = nil)then	
		buscarUltimoIsb:= nil
	else
		begin
			if(L^.dato.isbn = isbnActual)then
				buscarUltimoIsb:= L
			else
				buscarUltimoIsb:= buscarUltimoIsb(L^.sig,isbnActual);
		end;
end;
//hago una especie de corte de control, tengo que generar una lista con la cant total de cada ocurrencia en isbns
procedure generarNuevaEstructuraOrdenadaPorIsbn(a0: arbol0;var L: listaF);
var
	isbnActual: integer;
	//nE: prestamosTotales;
	aux: listaF;
begin
	if(a0 <> nil)then
		begin		
			generarNuevaEstructuraOrdenadaPorIsbn(a0^.hi,L); 	///me voy full izquierda
			isbnActual:= a0^.dato.isbn; //para hacerlo mas legible
			if(L = nil)then	//signfica que es el primer elememento
				agregarAtrasIneficiente(L,a0^.dato)	//aprovecho q ya esta ordenado el arbol
			else
				begin
					//if(isbnActual = L^.dato.isbn)then	//si el nodo esta con el mismo isbn, no creo nada, solo sumo
					//if(isbnActual = buscarUltimoIsb(L,isbnActual))then	//si el nodo esta con el mismo isbn, no creo nada, solo sumo
					aux:= buscarUltimoIsb(L,isbnActual);
					if(aux <> nil)then	//si el nodo esta con el mismo isbn, no creo nada, solo sumo
						cargarDataCompartida(aux^.dato,a0^.dato)
					else
						agregarAtrasIneficiente(L,a0^.dato);	//si no es un nuevo isbn
					generarNuevaEstructuraOrdenadaPorIsbn(a0^.hd,L);
				end;
			//corteDeControl(a0,isbnActual);
		end;
end;
//imprime la lista normal de manera recursiva
procedure imprimirListaNormal(L: listaF);
begin
	if(L <> nil)then
		begin
			Writeln();
			Writeln('-------------------------------------');Writeln();
			Writeln('El isbn en la lista normal es: ',L^.dato.isbn );
			Writeln('La cantidad total de prestamos del isbn es: ',L^.dato.cantPrestamos);
			imprimirListaNormal(L^.sig);
		end;
end;

//------------------------------------------------------------------------
{g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}
{g: Hago una lista con 2 campos[ISB y cantTotalPrestamosDeEseISBN] a esa lista la cargo con un agregarAtras, aprovecho el criterio de orden ISBN}
//en este caso podria pasarle el nodo y que agrege atras de maneraIneficiente pero ya tengo todo ese nodo del arbol ordenado por isbn
// podria hacer un enganche entre nodos
// vos tenes un nodo del arbol que es una lista, esa lista va ser todos los prestamos de ese isbn, entonces llevando un puntero al ultimo
// y como es una sola lista puedo recorrer la primera vez 

//cuenta la cant de nodos de la lista
function cantVecesSePresto(L: listaRepetidos): integer;
begin
	if(L = nil)then
		cantVecesSePresto:= 0
	else
		cantVecesSePresto:= cantVecesSePresto(L^.sig)+1;
end;

//encargador de reasignar campos
procedure asignarCampos(var nE: prestamosTotales; L2: listaRepetidos);
begin
	nE.isbn:= L2^.dato.isbn;
	nE.cantPrestamos:= cantVecesSePresto(L2);
end;
//el agregarAdelante de toda la vida
procedure agregarAdelante(var L: listaF; p:prestamosTotales);
var nue: listaF;
begin
	new(nue);
	nue^.dato:= p;
	nue^.sig:= L;
	L:= nue;
end;
//recorre el arbol y por cada nodo q es una lista cuanta la cant de nodos de la lista y los devuelve en una lista nueva q cada nodo representa a un prestamo su isbn y total
procedure generarEstructuraG(a2: arbol2; var L2G: listaF);
var	
	nE: prestamosTotales;
begin
	if(a2 <> nil)then
		begin
			generarEstructuraG(a2^.hi,L2G);
			asignarCampos(nE,a2^.dato);
			//nE.isb:= A2^.dato.dato.isbn;
			//nE.cantPrestamos:= cantVecesSePresto(a2^.dato);
			agregarAdelante(L2G,nE);
			generarEstructuraG(a2^.hd,L2G);
		end;
end;

//------------------------------------------------------------------------
{h. Un módulo recursivo que reciba la estructura generada en g. y muestre su contenido.
}
//reutilice un modulo Listo

//------------------------------------------------------------------------

{i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}

function cantEntreRangos(a: arbol0; izquierda,derecha: integer): integer;
begin
	if(a = nil)then
		cantEntreRangos:= 0
	else
		begin
			if(a^.dato.isbn >= izquierda) and (a^.dato.isbn <= derecha)then
				cantEntreRangos:= cantEntreRangos(a^.hi,izquierda,derecha) + cantEntreRangos(a^.hd,izquierda,derecha)+1
			else
				begin
					if(a^.dato.isbn > izquierda)then
						cantEntreRangos:= cantEntreRangos(a^.hi,izquierda,derecha)
					else	
						begin
							if(a^.dato.isbn < derecha)then
								cantEntreRangos:= cantEntreRangos(a^.hd,izquierda,derecha)
						end;
				end;
		end;
end;

{j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos)}

function contar(L: listaRepetidos): integer;
begin
	if (L = nil) then
		contar:= 0
	else
		contar:= contar(L^.sig)+1;	
end;

function cantEntreRangosJ(a2: arbol2; izquierda,derecha: integer):integer;
var	aux: listaRepetidos;
begin
	if(a2 = nil)then
		cantEntreRangosJ:= 0
	else
		begin
			aux:= a2^.dato;
			if((aux^.dato.isbn >= izquierda) and (aux^.dato.isbn  <= derecha))then
				cantEntreRangosJ:= cantEntreRangosJ(a2^.hi,izquierda,derecha) + contar(a2^.dato) + cantEntreRangosJ(a2^.hd,izquierda,derecha)
			else
				begin
					if(aux^.dato.isbn > izquierda)then
						cantEntreRangosJ:= cantEntreRangosJ(a2^.hi,izquierda,derecha)
					else
						begin
							if(aux^.dato.isbn < derecha)then
								cantEntreRangosJ:= cantEntreRangosJ(a2^.hd,izquierda,derecha);
						end;
				end;
		end;
end;
// procedure cantEntreRangosJ(a2: arbol2; izquierda,derecha: integer);
// begin
// 	if(a2 <> nil)then
// 		begin
			
// 		end;
// end;

var 
	ar0: arbol0; ar2: arbol2;
	puntoB: integer; puntoC: integer;
	numSocio: integer; //cantPrestamos: integer;
	//ListaNueva: listaF;
	L,L2G: listaF; izquierda,derecha: integer;
begin
	randomize;
  inicializarPunterosArbol(ar0,ar2);
  cargarPrestamos(ar0,ar2); //carga arbol 1 y 2
  Writeln(); Writeln();
  Writeln('ENTRO del arbol I ');
  Writeln(); Writeln();
  imprimirInOrder0(ar0);  //impresion del arbol 1
	Writeln(); Writeln();
  Writeln('SALIO del arbol I ');
  Writeln(); Writeln();
  Writeln(); Writeln();
  Writeln('ENTRO del arbol II ');
  Writeln(); Writeln();
  imprimirInOrder2(ar2);  //impresion del arbol 2
  Writeln('SALIO del arbol II ');
  Writeln(); Writeln();
  
  //
	{b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más grande.}
	puntoB:= isbnMasGrande(ar0);
	//isbnMasGrande(ar0,puntoB);
	Writeln('El isbn mas grande es: ',puntoB);
	//------------------------------------------------------------------------

	{c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más pequeño.}
	puntoC:= minimoDelArbol(ar2);
	//minimoDelArbol(ar2,puntoC);
	Writeln('El isbn mas chico es: ',puntoC);
	//------------------------------------------------------------------------

	{d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El módulo debe retornar la cantidad de préstamos realizados a dicho socio.}
	Writeln('Ingrese un numero de socio para saber la cantidad de prestamos ');
	readln(numSocio);
	Writeln('el socio tiene: ',cuantosPrestamosTieneElSocio(ar0,numSocio));
	//cantPrestamos:= 0;
	//cuantosPrestamosTieneElSocio(ar0,numSocio,cantPrestamos);
	//Writeln('el socio tiene: ',cantPrestamos);
	//------------------------------------------------------------------------
	{e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
	módulo debe retornar la cantidad de préstamos realizados a dicho socio.
	}
	//reutilizo el numero de socio
	//cuantosPrestamosTieneElSocioA2(ar2,numSocio,cantPrestamos);
	//Writeln('tiene con el prcoedimiento :',cantPrestamos);
	Writeln('El socio :',numSocio,' en el arbol2, tiene: ',cuantosPrestamosTieneElSocioA2(ar2,numSocio));
	//
	//ListaNueva:= generarNuevaEstructuraOrdenadaPorIsbn(ar0);
	inicializarListaPuntoFyG(L,L2G);
	generarNuevaEstructuraOrdenadaPorIsbn(ar0,L);
	Writeln();Writeln();
	Writeln('sarasaaaaa ');
	imprimirListaNormal(L);
	//
	generarEstructuraG(ar2,L2G);
	{h. Un módulo recursivo que reciba la estructura generada en g. y muestre su contenido.}
	Writeln('Punto gggggggggggggggggggg ');
	imprimirListaNormal(L2G);
	//
	{i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}
	

	izquierda:= 2;	// "Hardcodear"
	derecha:= 12;
	Writeln('hay entre rangos en el arbol 1: ',cantEntreRangos(ar0,izquierda,derecha));
	//
	izquierda:= 2;
	derecha:= 12;
	Writeln('hay entre rangos en el arbol 2: ',cantEntreRangosJ(ar2,izquierda,derecha));

end.


* 
* a: los 2 arboles comparten el criterio de orden por ISB
*   i: en una estructura se guarda el prestamo como tal, cada uno es =  a un nodo
*      ii: la otra es como un vector contador, solo va tener 2 campos ISB y cantPrestamos de ese ISB (fijarse el 0 como resolver eso para q empice a contar)
* b: recibe el Arbol con un Prestamo completo y retorne el isb mas grande, me tengo q ir full derecha (aprovecho el criterio de orden = por ISBN)
* c: recibo el Arbol con 2 campos ISB y CantTotal de prestamos de ese Isbn, me tengo qie ir full izquierda (/lo mismo q arriba aprovecho el orden/)
* d: recorro el Arbol de Prestamo completo i y voy contando los prestamos de ese socio, en este caso no me sirve el criterio de orden
* e: seguro se equivoco, me pide algo y no tengo ese criterio en el arbol 2 (me mando con el arbol 1) (ademas mi arbol 2 solo tiene cantTotalDePrestamos no hay relacion con el codSocio)
* f: La estructura ya esta ordenada por ISBN, retorno una lista y la cargo con un agregarAtras
* g: 
* cague entendi el enunciado mal xD me di cuenta al minuto 20  F parcial
* 
* //denuevo
* a: los 2 arboles comparten el criterio de orden por ISB
*   i: en una estructura se guarda el prestamo como tal, cada uno es =  a un nodo
*      ii: la otra estructura almacena de cada ISBN todos los prestamos = un arbol de listas [cada nodo[ordenadoXIsbn][todosLosprestamos]]
* b: recibe el Arbol con un Prestamo completo y retorne el isb mas grande, me tengo q ir full derecha (aprovecho el criterio de orden = por ISBN)
* c: recibo el Arbol con 2 campos ISB y CantTotal de prestamos de ese Isbn, me tengo qie ir full izquierda (/lo mismo q arriba aprovecho el orden/)
* d: recorro el Arbol de Prestamo completo i y voy contando los prestamos de ese socio, en este caso no me sirve el criterio de orden
* e: tengo que entrar en cada nodo del arbol de listas e ir contando, en este caso no me sirve el criterio de orden
* f: La estructura ya esta ordenada por ISBN, retorno una lista y la cargo con un agregarAtras
* g: Hago una lista con 2 campos[ISB y cantTotalPrestamosDeEseISBN] a esa lista la cargo con un agregarAtras, aprovecho el criterio de orden ISBN
* h: seguro era G... hasta el enunciado es recursivo se llama a si mismo JASJDAJSDJAS 
* 	 Entonces imprimo la lista como tal e imprimo el isb y la cantTotalDePrestamos
* i: recibo el arbol ordenado por Isbn y 2 valores ISBN tengo q tener un contador de cantPrestamos e ir sumando, con los nodos q sean nod0>=izquierda and nod0<=derecha 
* j: lo mismo que arriba pero me meto en cada lista
* 14min +los 20 anteriores
* }

// program onlypruebas;

// type
// 	{Una biblioteca nos ha encargado procesar la información de los préstamos realizados
// durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
// y mes del préstamo y cantidad de días prestados. Implementar un programa con:
// }	
// 	rango31 = 1..31;
// 	rango12 = 1..12;
// 	prestamo = record
// 		isbn: integer;
// 		numSocio: integer;
// 		dia: rango31;
// 		mes: rango12;
// 		cantDiasPrestados: integer;
// 	end;
	
// 	{a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
// 		los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
// 		ser eficientes para buscar por ISBN.}
// 	{
// 	* i. En una estructura cada préstamo debe estar en un nodo.
// 	ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
// 	(prestar atención sobre los datos que se almacenan).
// 	* }
// 	arbol0 = ^nodo0;
	
// 	nodo0 = record
// 		dato: prestamo;
// 		hi: arbol0;
// 		hd: arbol0;
// 	end;
	
// 	listaii = ^listaMismoIsbn;
	
// 	listaMismoIsbn = record
// 		dato: prestamo;
// 		sig: listaii;
// 	end;
	
// 	arbol1 = ^nodo1;
	
// 	nodo1 = record
// 		dato: listaii;
// 		hi: arbol1;
// 		hd: arbol1;
// 	end;
	
	
// 	nuevaEstructuraF = record
// 		isbn: integer;
// 		cantPrestamos: integer;
// 	end;
	
// 	listaNuevaParaElF = ^nodoF;
	
// 	nodoF = record
// 		dato: nuevaEstructuraF;
// 		sig: listaNuevaParaElF;
// 	end;
	
// procedure inicializarPuntero(var a0: arbol0; var a1: arbol1);
// begin
// 	a0:= nil;
// 	a1:= nil;
// end;

// procedure leerPrestamo(var p: prestamo);
// begin
// 	Writeln('Ingrese el isb: ');
// 	readln(p.isbn);
// 	if(p.isbn <> -1)then
// 		begin
// 			Writeln('Ingrese el numero de socio: ');
// 			p.numSocio:= random(51)+1; 
// 			Writeln('Ingrese el dia del prestamo ');
// 			p.dia:= random(32)+1;
// 			Writeln('Ingrese el mes del prestamo ');
// 			p.mes:= random(13)+1;
// 			Writeln('Ingrese la cantidad de dias prestados ');
// 			p.cantDiasPrestados:= random(100)+1; //puede tener 0 prestamos en mi programa
// 		end;
// end;


// procedure cargarPrestamoi(var a0: arbol0;p: prestamo);
// begin
// 	if(a0 <> nil)then
// 		begin
// 			a0^.dato:= p;
// 			a0^.hi:= nil;
// 			a0^.hd:= nil;
// 		end
// 	else
// 		begin
// 			if(p.isbn <= a0^.dato.isbn)then	//van a aparecer repetidos juntos ISBN
// 				cargarPrestamoi(a0^.hi,p)
// 			else
// 				cargarPrestamoi(a0^.hi,p);
// 		end;	
// end;

// procedure agregarAtrasIneficiente(var L: listaii; p: prestamo);
// var
// 	ant,act: listaii;
// 	nue: listaii;
// begin
// 	new(nue);
// 	nue^.dato:= p;
// 	ant:= L;
// 	act:= L;
// 	While(act <> nil)do
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

// procedure cargarPrestamoii(var a1: arbol1; p: prestamo);
// begin
// 	if(a1 = nil)then
// 		begin
//       new(a1);
// 			a1^.dato:= nil;
      
// 			agregarAtrasIneficiente(a1^.dato,p);
// 			a1^.hi:= nil;
// 			a1^.hd:= nil;
// 		end
// 	else
// 		begin
// 			if(p.isbn <= a1^.dato^.dato.isbn)then	
// 				begin
// 					if(p.isbn = a1^.dato^.dato.isbn)then
// 						agregarAtrasIneficiente(a1^.dato,p);// en teoria estoy parado en el mismo si caigo y paso el filtro
// 					cargarPrestamoii(a1^.hi,p)
// 				end			
// 			else
// 				cargarPrestamoii(a1^.hd,p);
// 		end;
// end;

// procedure cargarPrestamos(var a0: arbol0; a1: arbol1);
// var
// 	p: prestamo;
// begin
// 	leerPrestamo(p);
// 	While(p.isbn <> -1)do //corte isbn
// 		begin
// 			cargarPrestamoi(a0,p);
// 			cargarPrestamoii(a1,p);
//       leerPrestamo(p);
// 		end;
// end;


// {b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
// grande.
// }

// function isbnMaxArbol0(var a0: arbol0): integer;
// begin
// 	if(a0 = nil)then
// 		isbnMaxArbol0	:= -1
// 	else
// 		begin
// 			//if(a0^.hi^.dato.isb > a0^.dato.isb)then
// 			if(a0^.hd <> nil)then
// 				isbnMaxArbol0:= isbnMaxArbol0(a0^.hd)
// 			else
// 				isbnMaxArbol0	:= a0^.dato.isbn;
// 		end;
// end;
// {
// c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
// pequeño
// }

// function isbnMinArbol1(var a1: arbol1): integer;
// begin
// 	if(a1 = nil)then
// 		isbnMinArbol1	:= -1
// 	else
// 		begin
// 			//if(a0^.hi^.dato.isb > a0^.dato.isb)then
// 			if(a1^.hi <> nil)then
// 				isbnMinArbol1:= isbnMinArbol1(a1^.hi)
// 			else
// 				isbnMinArbol1	:= a1^.dato^.dato.isbn;
// 		end;
// end;

// {d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
// módulo debe retornar la cantidad de préstamos realizados a dicho socio.
// }
// //no esta ordenado por numero de socio queda recorrer todo el arbol
// function cantPrestamosArbol0(a0: arbol0; numSocio: integer): integer;
// begin
// 	if(a0 = nil)then
// 		cantPrestamosArbol0:= 0
// 	else
// 		begin
// 			if(a0^.dato.numSocio = numSocio)then
// 				begin
// 					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hi,numSocio)+1;
// 					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hd,numSocio)+1;
// 				end
// 			else
// 				begin
// 					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hi,numSocio);
// 					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hd,numSocio);
// 				end;
// 		end;
// end;

// {e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
// módulo debe retornar la cantidad de préstamos realizados a dicho socio.
// * }
// //que linux torvals nos ayude

// //en teoria tengo una lista contenida en otra entonces esta funcion va buscar en la lista y retonar la cant q aparesca
// function cantPrestamosArbollista(L: listaii; numSocio: integer): integer;
// begin
// 	if(L = nil)then
// 		cantPrestamosArbollista:= 0
// 	else
// 		begin
// 			if(L^.dato.numSocio = numSocio)then
// 				begin
// 					cantPrestamosArbollista:= cantPrestamosArbollista(L^.sig,numSocio)+1;
// 				end
// 			else
// 				begin
// 					cantPrestamosArbollista:= cantPrestamosArbollista(L^.sig,numSocio);
// 					cantPrestamosArbollista:= cantPrestamosArbollista(L^.sig,numSocio);
// 				end;
// 		end;
// end;
// //buscar en arboles // EN teoria deberia retornar y sumar todo con la pila cuando haga el backtracking
// function cantPrestamosArbol1(a1: arbol1; numSocio: integer): integer;
// begin
// 	if(a1 = nil)then
// 		cantPrestamosArbol1:= 0
// 	else
// 		begin		
// 			cantPrestamosArbol1:= cantPrestamosArbol1(a1^.hi,numSocio);
// 			cantPrestamosArbol1:= cantPrestamosArbol1(a1^.hd,numSocio);
// 			cantPrestamosArbol1 :=  cantPrestamosArbollista(a1^.dato, numSocio);
// 		end;
// end;

// {
// f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
// ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
// que se prestó.}
// //aprovecho el orden
// procedure agregarAtrasIneficiente2(var L:listaNuevaParaElF; p:nuevaEstructuraF);
// var
// 	ant,act: listaNuevaParaElF;
// 	nue: listaNuevaParaElF;
// begin
// 	new(nue);
// 	nue^.dato:= p;
// 	ant:= L;
// 	act:= L;
// 	While(act <> nil)do
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

// procedure filtrarData(p: prestamo;var rn: nuevaEstructuraF);
// begin
// 	rn.isbn:= p.isbn;
// 	rn.cantPrestamos:= rn.cantPrestamos + p.cantDiasPrestados;
// end;

// procedure generarNuevaEstructuraDesdeArbol0(a0: arbol0; var lista2F:listaNuevaParaElF );
// var
// 	rn: nuevaEstructuraF;
// begin
// 	if(a0 <> nil)then
// 		begin
// 			generarNuevaEstructuraDesdeArbol0(a0^.hi,lista2F);
// 			filtrarData(a0^.dato,rn);
// 			agregarAtrasIneficiente2(lista2F,rn);
// 			generarNuevaEstructuraDesdeArbol0(a0^.hd,lista2F);
// 		end;
// end;

// {g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
// ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
// que se prestó.}

// procedure generarNuevaEstructuraDesdeArbol1();
// begin
// 	3:17
// end.

// {h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.
// i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
// módulo debe retornar la cantidad total de préstamos realizados a los ISBN
// comprendidos entre los dos valores recibidos (incluidos).}


// {j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
// módulo debe retornar la cantidad total de préstamos realizados a los ISBN
// comprendidos entre los dos valores recibidos (incluidos)}

// var
// 	a1: arbol1;{<--este es de listas} a0: arbol0;	{<--- este normalito}
// 	numSocioBuscado: integer;
// 	lista2F: listaNuevaParaElF;
// 	lista2G: lista2F;	//mismo registro pra los 2
// begin
// 	randomize;
// 	inicializarPuntero(a0,a1);
// 	cargarPrestamos(a0,a1);
// 	//si cualquierda de los 2 retorna -1, salio algo mal o estan los arboles vacios
// 	Writeln('El isbn mas grande es: ',isbnMaxArbol0(a0));
// 	Writeln('El isbn mas pequenho es: ',isbnMinArbol1(a1));
// 	//
// 	Writeln('Ingrese un numero de socio ');
// 	readln(numSocioBuscado);
// 	Writeln('La cantidad D: ',cantPrestamosArbol0(a0,numSocioBuscado));
	
// 	//reutilizo la variable numSocio
// 	Writeln('la canditidad E: ',cantPrestamosArbol1(a1,numSocioBuscado));
	
// 	//
// 	lista2F:= nil;
// 	generarNuevaEstructuraDesdeArbol0(a0,lista2F);	//despues recorrerla y testearla
// 	//
// 	lista2G:= nil;
// 	generarNuevaEstructuraDesdeArbol1(a1,lista2G);
// end.
