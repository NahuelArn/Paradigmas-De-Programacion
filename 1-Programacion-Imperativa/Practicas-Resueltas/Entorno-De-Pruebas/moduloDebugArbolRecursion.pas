program moduloDebugArbolRecursion;

type
	arbol = ^nodo;
	
	nodo = record
		dato: integer;
		hi: arbol;
		hd: arbol
	end;
	
procedure inicializarLista(var L: arbol);
begin
	L:= nil;
end;
	
procedure cargarArbol(var a: arbol; n: integer);
begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= n;
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(n < a^.dato) then
				cargarArbol(a^.hi,n)
			else
				if(n > a^.dato)then
					cargarArbol(a^.hd,n);
		end;
end;


procedure imprimirPreOrden(a: arbol);
begin
  if(a <> nil)then
    begin
      Writeln('PreOrden: full izquierda, full Derecha(extremos) ',a^.dato);
      imprimirPreOrden(a^.hi);
      imprimirPreOrden(a^.hd);
    end;
end;

procedure imprimirInOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirInOrder(a^.hi);
      Writeln('In Order: de menor a mayor ',a^.dato);
      imprimirInOrder(a^.hd);
    end;
end;
//espejo
procedure imprimirInOrder2(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirInOrder(a^.hd);
      Writeln('In Order: de mayor a menor ',a^.dato);
      imprimirInOrder(a^.hi);
    end;
end;


procedure imprimirPosOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirPosOrder(a^.hi);
      imprimirPosOrder(a^.hd);
      Writeln('PosOrder: full derecha, full izquierda(extremos) ',a^.dato);
    end;
end;

var 
  L: arbol;
  num: integer;
  a,b: integer;
  cantCumplen: integer;
begin
  randomize;
  inicializarLista(L);
  Writeln('Ingresa un numero (0 PARA PARAR)');
  readln(num);
  While(num <> 0)do
		begin
			cargarArbol(L,num);
			Writeln('Ingresa un numero (0 PARA PARAR) ');
			readln(num);
		end;
	imprimirPreOrden(L);
	Writeln();Writeln();
	Writeln('----------------------------------------');
	Writeln();Writeln();
	imprimirInOrder(L);
	Writeln();Writeln();
	Writeln('----------------------------------------');
	Writeln();Writeln();
	imprimirInOrder2(L);
	Writeln();Writeln();
	Writeln('----------------------------------------');
	Writeln();Writeln();
	imprimirPosOrder(L);
end.
