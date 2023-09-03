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

procedure cuantosEntreRango(a: arbol;izquierda,derecha: integer;var cantCumplen: integer);
begin
	// if(a^.dato.numSocio = derecha)then //termina cuando llego al limite superior
	if(a <> nil)then
begin     
  if( a^.dato> izquierda ) and (a^.dato < derecha) then  //el actual no es menor al limite inferior
    begin
			cuantosEntreRango(a^.hi,izquierda,derecha,cantCumplen);
			cuantosEntreRango(a^.hd,izquierda,derecha,cantCumplen);
			// if( a^.dato.numSocio > izquierda ) and (a^.dato.numSocio < derecha) then
			//if( a^.dato > izquierda ) and (a^.dato < derecha) then
			cantCumplen:= cantCumplen+1;
				//en teoria cuando este aca, voy a estar parado en la pos q queria         
		end;
end

end;

procedure imprimirArbolInOrder(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirArbolInOrder(a^.hi);
			Writeln('In order: ',a^.dato);
			imprimirArbolInOrder(a^.hd);
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
  Writeln('Ingresa un numero');
  readln(num);
  While(num <> 0)do
		begin
			cargarArbol(L,num);
			Writeln('Ingresa un numero');
			readln(num);
		end;
	imprimirArbolInOrder(L);
	Writeln('ingrese a: ');
	readln(a);
	Writeln('Ingrese b: ');
	readln(b);
	cantCumplen:= 0;
	cuantosEntreRango(L,a,b,cantCumplen);
	Writeln('cantidad q cumplen: ',cantCumplen);
end.