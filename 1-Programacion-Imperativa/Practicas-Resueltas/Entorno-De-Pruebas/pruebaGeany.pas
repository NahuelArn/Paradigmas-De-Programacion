
program probando;

type

	lista = ^nodo;
	
	nodo = record
		dato: integer;
		sig: lista;
	end;

procedure agregarAdelante(var L: lista; n: integer);
var
	nue: lista;
begin
	new(nue);
	nue^.dato:= n;
	nue^.sig:= L;
	L:= nue;
end;

procedure cargarLista(var L: lista);
var
	num: integer;
begin
	Writeln('Ingrese un numero: ');
	num:= random(11);
	while(num <> 0) do
		begin
			agregarAdelante(L,num);
			Writeln('Ingrese un numero: ');
			num:= random(11);
		end;
end;

procedure imprimirLista(L: lista);
begin
	While(L<> nil)do
		begin
			Writeln('a : ',L^.dato);
			L:= L^.sig;
		end;
end;

function estaEnLaLista(L: lista; valorBuscado: integer): boolean;
begin
	if(L = nil) then
		estaEnLaLista:= false
	else
		if(L^.dato = valorBuscado)then
			estaEnLaLista:= true
		else
			estaEnLaLista:= estaEnLaLista(L^.sig,valorBuscado)
end;

var
	L: lista;
	buscado: integer;
begin
	randomize;
	L:= nil;
	cargarLista(L);
	Writeln('Ingrese un numero a buscar ');
	readln(buscado);
	
	imprimirLista(L);
	
	if(estaEnLaLista(L,buscado))then
		Writeln('valor encontrado ' )
	else
		Writeln('no esta en la lista');
end.
