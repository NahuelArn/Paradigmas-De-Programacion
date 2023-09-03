program p2;
{2.- Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la información de los autos en venta.
Implementar un programa que:
a) Genere un árbol binario de búsqueda ordenado por patente identificatoria del auto en venta. Cada nodo del árbol debe contener patente,
* año de fabricación (2010..2018), la marca y el modelo.
b) Invoque a un módulo que reciba el árbol generado en a) y una marca y retorne la cantidad de autos de dicha marca que posee la agencia. Mostrar el resultado. 
c) Invoque a un módulo que reciba el árbol generado en a) y retorne una estructura con la información de los autos agrupados por año de fabricación.
d) Contenga un módulo que reciba el árbol generado en a) y una patente y devuelva el año de fabricación del auto con dicha patente. Mostrar el resultado. }
Type
	auto = record
		patente:string;
		anio:integer;
		marca:string;
		modelo:string;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:auto;
		HI:arbol;
		HD:arbol;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		dato:auto;
		sig:lista;
	end;
	
	vAnios = array [2010..2018] of lista;
	
procedure crearArbol(var A:arbol);

	procedure leerAuto(var a:auto);
	begin
		writeln('Ingrese patente');
		readln(a.patente);
		if (a.patente <> 'zzz') then
		begin
			writeln('Ingrese anio');
			readln(a.anio);
			writeln('Ingrese marca');
			readln(a.marca);
			//writeln('Ingrese modelo');
			//readln(a.modelo);
		end;
	end;

	procedure cargar(var A:arbol ; dato:auto);		
	begin
		if (A = nil) then
		begin
			new(A);
			A^.dato:= dato;
			A^.HI:= nil;
			A^.HD:= nil;
		end
		else
			if (dato.patente < A^.dato.patente) then
				cargar(A^.HI, dato)
			else
				cargar(A^.HD, dato);
	end;
var
	dato:auto;
begin
	leerAuto(dato);
	while(dato.patente <> 'zzz')do
	begin
		cargar(A, dato);
		leerAuto(dato);
	end;
end;

procedure mostrarArbol(A:arbol);
begin
	if (A <> nil) then
	begin
		writeln(A^.dato.patente);
		writeln(A^.dato.anio);
		writeln(A^.dato.marca);
		//writeln(A^.dato.modelo);
		mostrarArbol(A^.HD);
		mostrarArbol(A^.HI);
	end;
end;

procedure cantidadPorMarca(A:arbol);

	procedure contar(A:arbol ; var cant:integer ; buscado:string);
	begin
		if (A <> nil) then
		begin
			if (A^.dato.marca = buscado) then
				cant:= cant + 1;
			contar(A^.HI, cant, buscado);
			contar(A^.HD, cant, buscado);
		end;
	end;

var
	buscado:string;
	cant:integer;
begin
	writeln('Ingrese marca a contar');
	readln(buscado);
	cant:= 0;
	contar(A, cant, buscado);
	writeln('De la marca ', buscado, ' hay ', cant, ' autos');
end;

procedure iniciarVector(var V:vAnios);
var
	i:integer;
begin
	for i:=2010 to 2018 do
		V[i]:= nil
end;

procedure organizarPorAnio(A:arbol ; var autos:vAnios);

	procedure agregarAdelante(var L:lista ; a:auto);
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.dato:= a;
		nuevo^.sig:= L;
		L:= nuevo;		
	end;

begin
	if (A <> nil) then
	begin
		agregarAdelante(autos[A^.dato.anio], A^.dato);
		organizarPorAnio(A^.HI, autos);
		organizarPorAnio(A^.HD, autos);
	end;
end;

procedure buscarAuto(A:arbol);

	procedure buscar(A:arbol ; buscado:string ; var anio:integer);
	begin
		if (A <> nil) then
			if (A^.dato.patente = buscado) then
				anio:= A^.dato.anio
			else
				if (buscado < A^.dato.patente) then
					buscar(A^.HI, buscado, anio)
				else
					buscar(A^.HD, buscado, anio);
	end;

var
	buscado:string;
	anio:integer;
begin
	anio:= -1;
	writeln('Ingrese patente a buscar');
	readln(buscado);
	buscar(A, buscado, anio);
	if (anio <> -1) then
		writeln('El anio del auto con patente ', buscado, ' es ', anio)
	else
		writeln('El auto buscado no se encuentra');
end;

var 
	A:arbol;
	autos:vAnios;
BEGIN
	A:= nil;
	crearArbol(A);
	//mostrarArbol(A);
	//writeln('- - - - - - - - - -');
	//cantidadPorMarca(A);
	//iniciarVector(autos);
	//organizarPorAnio(A, autos);
	buscarAuto(A);
END.