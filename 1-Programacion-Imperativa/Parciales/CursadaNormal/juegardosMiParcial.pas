
{

a: compra = codJuego, codCliente, dia, mes, ---> criterio de corte cod cliente = 0
i: arbol ---> ordenado por codCliente --> 


ii:  un vector de 1 a 12 q almacena la cantidad de compras hechas cada mes 

b: recorrer arbol encontrar cliente y retornar todas sus compras  que realizo en una lista

c: ordenar vector de mayor a menor >
}

program nahuelArn;

type
	
	rango31 = 1..31;
	rango12 = 1..12;
	
	compra = record
		codJuego: integer;
		codCliente: integer;
		dia: rango31;
		mes: rango12
	end;
	
	arbol = ^nodoArbol;
	
	nodoArbol = record
		dato: compra;
		hi: arbol; hd: arbol;
	end;
	//
	
	vCantCompras = array[rango12]of integer;
	
	lista = ^nodo;
	
	nodo = record
		dato: compra;
		sig: lista;
	end;
	
procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;



procedure inicializarVector(var v: vCantCompras);
var i: integer;
begin
	for i:= 1 to 12 do
		v[i]:= 0;
end;

procedure leerCompra(var c: compra);
begin
	Writeln('cod Cliente:  corta con 0 ');
	readln(c.codCliente);
	if(c.codCliente <> 0)then
		begin
			Writeln('cod juego: ');
			//readln(c.codJuego);
			c.codJuego:= 2; //
			Writeln('dia: hasta 31 ');
			//readln(c.dia);
			c.dia:= 6;
			Writeln('mes: hasta 12 ');
			readln(c.mes);
			//c.mes:= 5;
		end;
end;

procedure cargarArbol(var a: arbol; c: compra);

begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= c;
			a^.hi:= nil; a^.hd:= nil;		
		end
	else
		begin
			if(c.codCliente <= a^.dato.codCliente)then	//se guandan tambien los clientes repetidos
				cargarArbol(a^.hi,c)
			else
				cargarArbol(a^.hd,c);
		end;
end;

procedure cargarVector(var v: vCantCompras; mes: rango12);
begin
	v[mes]:= v[mes]+1;
end;

procedure cargarCompras(var a: arbol; var v:vCantCompras);
var c: compra;
begin
	leerCompra(c);  //cod cliente = 0, criterio de corte
	While(c.codCliente <> 0)do
		begin
			cargarArbol(a,c);
			cargarVector(v,a^.dato.mes);
			leerCompra(c);
		end;
end;

{b: recorrer arbol encontrar cliente y retornar todas sus compras  que realizo en una lista
}
function recorrerSumar(a: arbol; codBuscado: integer): integer;
begin
	if(a = nil)then
		recorrerSumar:= 0
	else
		begin
			if(a^.dato.codCliente = codBuscado)then
				recorrerSumar:= recorrerSumar(a^.hi,codBuscado) + recorrerSumar(a^.hd,codBuscado)+1
			else
				begin
					if(codBuscado < a^.dato.codCliente)then
						recorrerSumar:= recorrerSumar(a^.hi,codBuscado)
					else
						begin
							if(codBuscado > a^.dato.codCliente)then
								recorrerSumar:= recorrerSumar(a^.hd,codBuscado)
						end;
				end;
		end;
end;

procedure ordenarVector(var v:vCantCompras; dimL: integer);
var a,b,i,min: integer;
begin
	for i:=  1 to (dimL-1) do
		begin
			a:= i;
			for b:= i+1 to dimL do
				begin
					if (v[b] > v[a])then
						a:= b;
				end;
				min:= v[a];
				v[a]:= v[i];
				v[i]:= min;
		end;
end;

//

procedure agregarAdelante(var L: lista; c: compra);
var nue: lista;
begin
	new(nue);
	nue^.dato:= c;
	nue^.sig:= L;
	L:= nue;
end;

procedure todasLasComprasMismoCliente(a: arbol; codClienteB: integer; var L: lista);
begin
	if(a <> nil)then
		begin
			if(a^.dato.codCliente = codClienteB)then
				begin
					todasLasComprasMismoCliente(a^.hi,codClienteB,L);
					agregarAdelante(L,a^.dato);
					todasLasComprasMismoCliente(a^.hd,codClienteB,L);
				end
			else
				begin
					if(codClienteB < a^.dato.codCliente)then
						todasLasComprasMismoCliente(a^.hi,codClienteB,L)
					else
						begin
							if(codClienteB > a^.dato.codCliente)then
								todasLasComprasMismoCliente(a^.hd,codClienteB,L)
						end;
				end;
		end;
end;
//---------------

procedure imprimirArbol(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirArbol(a^.hi);
			Writeln('cod cliente en arbol: ',a^.dato.codCliente);
			imprimirArbol(a^.hd);
		end;
end;


procedure imprimirVector(v: vCantCompras);
begin
	Writeln('cantidad de compras: ',v[5]);
end;

procedure imprimirLista(L: lista);
begin
	if(L <> nil)then
		begin
			Writeln(L^.dato.codCliente);
			imprimirLista(L^.sig);
		end;
end;



var
	a: arbol;
	v: vCantCompras;
	codClienteCantCompras, cantCliente: integer;
	dimL,codClienteB: integer;
	L2: lista;
begin
	randomize;
	inicializarPuntero(a);
	inicializarVector(v);
	cargarCompras(a,v);
	
	L2:= nil;
	codClienteB:= 4540;
	todasLasComprasMismoCliente(a,codClienteB,L2);
	//imprimirArbol(a); testeado Arbol
	//imprimirVector(v); testeado
	//imprimirLista(L2); testeado
	//
	codClienteCantCompras:= 4540;
	cantCliente:= recorrerSumar(a,codClienteCantCompras); //raro
	Writeln('cant cliente: ',cantCliente);
	//
	dimL:= 12;
	Writeln('antees ordenado '); Writeln(); Writeln();
	ordenarVector(v,dimL);
	Writeln('ya ordenado '); Writeln(); Writeln();
	
end.

