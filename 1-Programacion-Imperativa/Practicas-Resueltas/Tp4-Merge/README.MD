

<h1 align="center"> Program ejemplo de carga </h1>
<p align="center">Algoritmos que se repiten</p>

```pas

program merge;
Type 
 lista =^nodo;
 
 nodo = record
  dato: string;
  sig: lista;
 end; 
	
procedure inicializarLista(var L: lista);
begin
	L:= nil;
end;



procedure agregarAtras(var L: lista; car: string);
var
	ant,act: lista;
	nue: lista;
begin
	new(nue);
	nue^.dato:= car;
	ant:= nil; // Inicializamos ant como nil
	act:= L;
	while (act <> nil) do
	begin
		ant:= act;
		act:= act^.sig;
	end;
	if (ant = nil) then
		L:= nue // Si la lista está vacía, asignamos el nuevo nodo como el primero
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;

procedure generarEstante(var L: lista);
var
	car: string;
begin
	Writeln('Ingrese algo (sarasa para para cortar) ');
	readln(car);
	while (car <> 'sarasa') do
	begin
		agregarAtras(L, car);
		Writeln('Ingrese algo ');
		readln(car);
	end;
end;

procedure minimo(var E1,E2:lista; var min:string);
begin
	min := 'zzz';
	if (E1 <> nil) and (E2 <> nil) then
	begin
		if (E1^.dato <= E2^.dato) then
		begin
			min:= E1^.dato;
			E1:= E1^.sig;
		end
		else
		begin
			min:= E2^.dato;
			E2:= E2^.sig;
		end;
	end
	else if (E1 <> nil) and (E2 = nil) then
		begin
			min:= E1^.dato;
			E1:= E1^.sig;
		end 
		else if (E1 = nil) and (E2 <> nil) then
			begin
				min:= E2^.dato;
				E2:= E2^.sig; 
			end;
end;

procedure merge (E1,E2:lista; var Enuevo:lista);
var 
	min: string;
begin
	Enuevo:= nil;
	minimo (E1,E2,min);
	while (min <> 'zzz') do
	begin
		agregarAtras (Enuevo,min);
		minimo (E1,E2,min);
	end;
end;  

procedure imprimir(L: lista);
begin
	while (L <> nil) do
	begin
		Writeln('imprimiendo: ',L^.dato);
		L:= L^.sig;
	end;
end;

Var
 estante1, estante2: lista;
 estanteNuevo: lista; 

Begin
	inicializarLista(estante1);
	generarEstante (estante1);
	estante2:= estante1; //en teoria se podria
	merge (estante1,estante2,estanteNuevo);
	imprimir(estanteNuevo);
End.

```
