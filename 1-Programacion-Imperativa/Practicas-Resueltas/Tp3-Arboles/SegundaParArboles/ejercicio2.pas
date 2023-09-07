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

program onlypruebas;

type
	{Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
}	
	rango31 = 1..31;
	rango12 = 1..12;
	prestamo = record
		isbn: integer;
		numSocio: integer;
		dia: rango31;
		mes: rango12;
		cantDiasPrestados: integer;
	end;
	
	{a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
		los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
		ser eficientes para buscar por ISBN.}
	{
	* i. En una estructura cada préstamo debe estar en un nodo.
	ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
	(prestar atención sobre los datos que se almacenan).
	* }
	arbol0 = ^nodo0;
	
	nodo0 = record
		dato: prestamo;
		hi: arbol0;
		hd: arbol0;
	end;
	
	listaii = ^listaMismoIsbn;
	
	listaMismoIsbn = record
		dato: prestamo;
		sig: listaii;
	end;
	
	arbol1 = ^nodo1;
	
	nodo1 = record
		dato: listaii;
		hi: arbol1;
		hd: arbol1;
	end;
	
	
	nuevaEstructuraF = record
		isbn: integer;
		cantPrestamos: integer;
	end;
	
	listaNuevaParaElF = ^nodoF;
	
	nodoF = record
		dato: nuevaEstructuraF;
		sig: listaNuevaParaElF;
	end;
	
procedure inicializarPuntero(var a0: arbol0; var a1: arbol1);
begin
	a0:= nil;
	a1:= nil;
end;

procedure leerPrestamo(var p: prestamo);
begin
	Writeln('Ingrese el isb: ');
	readln(p.isbn);
	if(p.isbn <> -1)then
		begin
			Writeln('Ingrese el numero de socio: ');
			p.numSocio:= random(51)+1; 
			Writeln('Ingrese el dia del prestamo ');
			p.dia:= random(32)+1;
			Writeln('Ingrese el mes del prestamo ');
			p.mes:= random(13)+1;
			Writeln('Ingrese la cantidad de dias prestados ');
			p.cantDiasPrestados:= random(100)+1; //puede tener 0 prestamos en mi programa
		end;
end;


procedure cargarPrestamoi(var a0: arbol0;p: prestamo);
begin
	if(a0 <> nil)then
		begin
			a0^.dato:= p;
			a0^.hi:= nil;
			a0^.hd:= nil;
		end
	else
		begin
			if(p.isbn <= a0^.dato.isbn)then	//van a aparecer repetidos juntos ISBN
				cargarPrestamoi(a0^.hi,p)
			else
				cargarPrestamoi(a0^.hi,p);
		end;	
end;

procedure agregarAtrasIneficiente(var L: listaii; p: prestamo);
var
	ant,act: listaii;
	nue: listaii;
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

procedure cargarPrestamoii(var a1: arbol1; p: prestamo);
begin
	if(a1 = nil)then
		begin
      new(a1);
			a1^.dato:= nil;
      
			agregarAtrasIneficiente(a1^.dato,p);
			a1^.hi:= nil;
			a1^.hd:= nil;
		end
	else
		begin
			if(p.isbn <= a1^.dato^.dato.isbn)then	
				begin
					if(p.isbn = a1^.dato^.dato.isbn)then
						agregarAtrasIneficiente(a1^.dato,p);// en teoria estoy parado en el mismo si caigo y paso el filtro
					cargarPrestamoii(a1^.hi,p)
				end			
			else
				cargarPrestamoii(a1^.hd,p);
		end;
end;

procedure cargarPrestamos(var a0: arbol0; a1: arbol1);
var
	p: prestamo;
begin
	leerPrestamo(p);
	While(p.isbn <> -1)do //corte isbn
		begin
			cargarPrestamoi(a0,p);
			cargarPrestamoii(a1,p);
      leerPrestamo(p);
		end;
end;


{b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.
}

function isbnMaxArbol0(var a0: arbol0): integer;
begin
	if(a0 = nil)then
		isbnMaxArbol0	:= -1
	else
		begin
			//if(a0^.hi^.dato.isb > a0^.dato.isb)then
			if(a0^.hd <> nil)then
				isbnMaxArbol0:= isbnMaxArbol0(a0^.hd)
			else
				isbnMaxArbol0	:= a0^.dato.isbn;
		end;
end;
{
c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño
}

function isbnMinArbol1(var a1: arbol1): integer;
begin
	if(a1 = nil)then
		isbnMinArbol1	:= -1
	else
		begin
			//if(a0^.hi^.dato.isb > a0^.dato.isb)then
			if(a1^.hi <> nil)then
				isbnMinArbol1:= isbnMinArbol1(a1^.hi)
			else
				isbnMinArbol1	:= a1^.dato^.dato.isbn;
		end;
end;

{d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
}
//no esta ordenado por numero de socio queda recorrer todo el arbol
function cantPrestamosArbol0(a0: arbol0; numSocio: integer): integer;
begin
	if(a0 = nil)then
		cantPrestamosArbol0:= 0
	else
		begin
			if(a0^.dato.numSocio = numSocio)then
				begin
					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hi,numSocio)+1;
					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hd,numSocio)+1;
				end
			else
				begin
					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hi,numSocio);
					cantPrestamosArbol0:= cantPrestamosArbol0(a0^.hd,numSocio);
				end;
		end;
end;

{e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
* }
//que linux torvals nos ayude

//en teoria tengo una lista contenida en otra entonces esta funcion va buscar en la lista y retonar la cant q aparesca
function cantPrestamosArbollista(L: listaii; numSocio: integer): integer;
begin
	if(L = nil)then
		cantPrestamosArbollista:= 0
	else
		begin
			if(L^.dato.numSocio = numSocio)then
				begin
					cantPrestamosArbollista:= cantPrestamosArbollista(L^.sig,numSocio)+1;
				end
			else
				begin
					cantPrestamosArbollista:= cantPrestamosArbollista(L^.sig,numSocio);
					cantPrestamosArbollista:= cantPrestamosArbollista(L^.sig,numSocio);
				end;
		end;
end;
//buscar en arboles // EN teoria deberia retornar y sumar todo con la pila cuando haga el backtracking
function cantPrestamosArbol1(a1: arbol1; numSocio: integer): integer;
begin
	if(a1 = nil)then
		cantPrestamosArbol1:= 0
	else
		begin		
			cantPrestamosArbol1:= cantPrestamosArbol1(a1^.hi,numSocio);
			cantPrestamosArbol1:= cantPrestamosArbol1(a1^.hd,numSocio);
			cantPrestamosArbol1 :=  cantPrestamosArbollista(a1^.dato, numSocio);
		end;
end;

{
f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}
//aprovecho el orden
procedure agregarAtrasIneficiente2(var L:listaNuevaParaElF; p:nuevaEstructuraF);
var
	ant,act: listaNuevaParaElF;
	nue: listaNuevaParaElF;
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

procedure filtrarData(p: prestamo;var rn: nuevaEstructuraF);
begin
	rn.isbn:= p.isbn;
	rn.cantPrestamos:= rn.cantPrestamos + p.cantDiasPrestados;
end;

procedure generarNuevaEstructuraDesdeArbol0(a0: arbol0; var lista2F:listaNuevaParaElF );
var
	rn: nuevaEstructuraF;
begin
	if(a0 <> nil)then
		begin
			generarNuevaEstructuraDesdeArbol0(a0^.hi,lista2F);
			filtrarData(a0^.dato,rn);
			agregarAtrasIneficiente2(lista2F,rn);
			generarNuevaEstructuraDesdeArbol0(a0^.hd,lista2F);
		end;
end;

{g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.}

procedure generarNuevaEstructuraDesdeArbol1();
begin
	3:17
end.

{h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.
i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}


{j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos)}

var
	a1: arbol1;{<--este es de listas} a0: arbol0;	{<--- este normalito}
	numSocioBuscado: integer;
	lista2F: listaNuevaParaElF;
	lista2G: lista2F;	//mismo registro pra los 2
begin
	randomize;
	inicializarPuntero(a0,a1);
	cargarPrestamos(a0,a1);
	//si cualquierda de los 2 retorna -1, salio algo mal o estan los arboles vacios
	Writeln('El isbn mas grande es: ',isbnMaxArbol0(a0));
	Writeln('El isbn mas pequenho es: ',isbnMinArbol1(a1));
	//
	Writeln('Ingrese un numero de socio ');
	readln(numSocioBuscado);
	Writeln('La cantidad D: ',cantPrestamosArbol0(a0,numSocioBuscado));
	
	//reutilizo la variable numSocio
	Writeln('la canditidad E: ',cantPrestamosArbol1(a1,numSocioBuscado));
	
	//
	lista2F:= nil;
	generarNuevaEstructuraDesdeArbol0(a0,lista2F);	//despues recorrerla y testearla
	//
	lista2G:= nil;
	generarNuevaEstructuraDesdeArbol1(a1,lista2G);
end.
