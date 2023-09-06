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
h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.
i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos)
}

program ejercicio2v2;

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
  
	
procedure inicializarPunterosArbol(var a0: arbol0; var a2: arbol2);
begin
	a0:= nil;
	a2:= nil;
end;

// procedure leerPrestamo(var p: prestamo);
// begin
// 	Writeln('Ingrese el isbn del arbol: (-1 PARA CORTAR) ');
// 	p.isbn:= random(11)-1;
// 	if(p.isbn <> -1)then
// 		begin
// 			Writeln('Ingrese el numero de socio: ');
// 			p.numSocio:= random(101)+1;
// 			Writeln('Ingrese el dia del prestamo del socio: ');
// 			p.dia:= random(32)+1;
// 			Writeln('Ingrese el mes del prestamo ');
// 			p.mes:= random(13)+1;
// 			Writeln('Ingrese la cantidad de dias prestado ');
// 			p.cantDiasPrestados:= 51+1;
// 		end;
// 		Writeln('------2-----');
// end;
procedure leerPrestamo(var p: prestamo);
begin
	Writeln('Ingrese el isbn del arbol: (-1 PARA CORTAR) ');
	readln(p.isbn);
	if(p.isbn <> -1)then
		begin
			Writeln('Ingrese el numero de socio: ');
			readln(p.numSocio);
			Writeln('Ingrese el dia del prestamo del socio: ');
			readln(p.dia);
			Writeln('Ingrese el mes del prestamo ');
			readln(p.mes);
			Writeln('Ingrese la cantidad de dias prestado ');
			readln(p.cantDiasPrestados);
		end;
		Writeln('------2-----');
end;

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
      Writeln('------ARBOL0 1----');
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
		ant^.sig:= nue;
	nue^.sig:= act;
end;
// procedure agregarAdelante(var L: listaRepetidos; p:prestamo);
// var 
//   nue: listaRepetidos;
// begin
//   new(nue);
//   nue^.dato:= p;
//   nue^.sig:= L;
//   L:= nue;
// end;


procedure cargarArbol2(var a2: arbol2; p: prestamo);
var
	aux: prestamo;
begin
	if(a2 = nil)then
		begin
			new(a2);
			inicializarListaArb2(a2^.dato);
			agregarAtrasIneficiente(a2^.dato,p);
      // agregarAdelante(a2^.dato,p);
			a2^.hi:= nil;
			a2^.hd:= nil;
      Writeln('------ADENTRO1----');
		end
	else
		begin
       Writeln('------ADENTRO2----');
			aux:= a2^.dato^.dato;
			if(p.isbn <= aux.isbn)then
				begin
					if(p.isbn = aux.isbn)then
						agregarAtrasIneficiente(a2^.dato,p);
            // agregarAdelante(a2^.dato,p);
					cargarArbol2(a2^.hi,p)
				end
			else
				cargarArbol2(a2^.hd,p);
		end;
end;

procedure cargarPrestamos(var a0: arbol0;var a2: arbol2);
var
	p: prestamo;
begin
	Writeln('------1-----');
	leerPrestamo(p);
	While(p.isbn <> -1)do
		begin
			cargarArbol0(a0,p);
      // imprimirInOrder0(a0);
			Writeln('------3-----');
			cargarArbol2(a2,p);
			Writeln('------5-----');
      // cargarPrestamos(a0,a2);
			leerPrestamo(p);
			Writeln('------4-----');
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

procedure imprimirInOrder0(a0: arbol0);
begin
	if(a0 <> nil)then
		begin
			imprimirInOrder0(a0^.hi);
			imprimirPrestamo(a0^.dato);
			imprimirInOrder0(a0^.hd);
		end;
end;

procedure imprimirLista(L: listaRepetidos);
begin
	While(L <> nil)do
		begin
			imprimirPrestamo(L^.dato);
			L:= L^.sig;
		end;
end;

procedure imprimirInOrder2(a2: arbol2);
begin
	if(a2 <> nil)then
		begin
			imprimirInOrder2(a2^.hi);
			imprimirLista(a2^.dato);
			imprimirInOrder2(a2^.hd);
		end;
end;

var 
	ar0: arbol0; ar2: arbol2;
	
begin
	randomize;
  inicializarPunterosArbol(ar0,ar2);
  cargarPrestamos(ar0,ar2);
  Writeln(); Writeln();
  Writeln('ENTRO del arbol I ');
  Writeln(); Writeln();
  imprimirInOrder0(ar0);
	Writeln(); Writeln();
  Writeln('salio del arbol I ');
  Writeln(); Writeln();
  Writeln(); Writeln();
  Writeln('ENTRO del arbol II ');
  Writeln(); Writeln();
  imprimirInOrder2(ar2);
  Writeln('salio del arbol II ');
  Writeln(); Writeln();
  {Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).}
end.
