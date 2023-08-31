<h1 align="center"> Arboles </h1>

<p align="center">Implementacion</p>

<h1 align="center"> Carga de Arboles </h1>

```pas
program ejercicio1;

type
  arbol = ^nodo;

  nodo = record
    dato: integer;
    hi: arbol;
    hd: arbol;
  end;

procedure inicializarArbol(var a: arbol);
begin
  a:= nil;
end;

procedure cargarArbol(var a: arbol; num: integer);
begin
  if( a = nil)then  //si es el primer el elemento o se crea un nuevo nodo
    begin
      new(a); //creo el MAIN (en la primera iteracion) / despues crea el Main de los nodos
      a^.dato:= num;
      a^.hi:= nil;
      a^.hd:= nil;
    end
  else
    if( num < a^.dato)then
      cargarArbol(a^.hi,num)
    else
      cargarArbol(a^.hd,num);
end;
//imprimir Arbol / criterio de Impresion ''In order''
procedure imprimir(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimir(a^.hi);
      Writeln(a^.dato);
      imprimir(a^.hd);
    end;
end;

var
  a: arbol;
  n: integer;
begin
  inicializarArbol(a);
  Writeln('Ingrese un numero: ');
  readln(n);
  While(n <> 0)do
    begin
      cargarArbol(a,n);
      Writeln('Ingrese un numero: ');
      readln(n);
    end;
  imprimir(a);
end.

```

<h1 align="center"> sacarPromedioArbolRecursivo </h1>

```pas
program sacarPromedioArbolRecursivo;

type
  arbol = ^nodo;

  nodo = record
    dato: integer;
    hi: arbol;
    hd: arbol;
  end;

procedure inicializarLista(var a: arbol);
begin
  a:= nil;
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
      if(n < a^.dato)then
        cargarArbol(a^.hi,n)
      else
        begin
          if(n > a^.dato)then
            cargarArbol(a^.hd,n);
        end;
    end;
end;

procedure imprimirArbol(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirArbol(a^.hi);
      Writeln(a^.dato);
      imprimirArbol(a^.hd);
    end;
end;

function promedio(suma,cant: integer): real;
begin
  promedio:= suma/cant;
end;

procedure sacarPromedio(a: arbol; var suma,cant: integer; var prom: real);
begin
  if(a = nil)then
    begin
      prom:= promedio(suma,cant);
    end
  else
    begin
      suma:= suma+ a^.dato;
      cant:= cant+1;
      sacarPromedio(a^.hi,suma,cant,prom);
      sacarPromedio(a^.hd,suma,cant,prom);
    end;
end;

var
  a: arbol;
  num: integer;
  suma,cant: integer;
  prom: real;
begin
  randomize;
  inicializarLista(a);
  Writeln('Ingrese un numero: ');
  readln(num);
  While(num <> 0)do
    begin
      cargarArbol(a,num);
      Writeln('Ingrese un numero: ');
      readln(num);
    end;
  Writeln();
  imprimirArbol(a);

  suma:= 0;
  cant:= 0;
  sacarPromedio(a,suma,cant,prom);
  Writeln('Promedio: ',prom:2:2);
end.
```

<h1 align="center"> metodos de impresion en Arboles </h1>

```pas
procedure imprimirPreOrden(a: arbol);
begin
  if(a <> nil)then
    begin
      Writeln('PreOrden: full izquierda, full Derecha(extremos)',a^.dato);
      imprimirPreOrden(a^.hi);
      imprimirPreOrden(a^.hd);
    end;
end;

procedure imprimirInOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirInOrder(a^.hi);
      Writeln('In Order: de menor a mayor',a^.dato);
      imprimirInOrder(a^.hd);
    end;
end;
//espejo
procedure imprimirInOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirInOrder(a^.hd);
      Writeln('In Order: de mayor a menor',a^.dato);
      imprimirInOrder(a^.hi);
    end;
end;


procedure imprimirPosOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirPosOrder(a^.hi);
      imprimirPosOrder(a^.hd);
      Writeln('PosOrder: full derecha, full izquierda(extremos)',a^.dato);
    end;
end;
```

<h1 align="center"> Recursion aplicada a Arboles, procedimiento/funcion </h1>

```pas
program moduloDebugArbolRecursion;

type
  cliente = record
    cod: integer;
    monto: integer;
  end;

	arbol = ^nodo;

	nodo = record
		dato: cliente;
		hi: arbol;
		hd: arbol
	end;

procedure leerCliente(var c: cliente);
begin
  Writeln('Ingrese el codigo del cliente: ');
  readln(c.cod);
  if(c.cod <> 0then
		begin
			Writeln('Ingrese el monto del cliente: ');
			readln(c.monto);
		end;
end;

procedure inicializarLista(var L: arbol);
begin
	L:= nil;
end;

procedure cargarArbol(var a: arbol; n: cliente);
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
			if(n.cod < a^.dato.cod) then
				cargarArbol(a^.hi,n)
			else  //se permiten los repetidos
		  	cargarArbol(a^.hd,n);
		end;
end;




procedure imprimirArbolInOrder(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirArbolInOrder(a^.hi);
			Writeln('----------------');
			Writeln('codigoCliente: ',a^.dato.cod);
			Writeln('montoCliente: ',a^.dato.monto);
			Writeln('----------------');
			imprimirArbolInOrder(a^.hd);
		end;
end;

//puede ser q este seria la unica manera de sumar el total usando un procedimiento? con el  <>
procedure montoTotalDecliente(a0: arbol; codBuscado: integer; var monto: integer);
begin
	if(a0 <> nil)then
		begin
			montoTotalDecliente(a0^.hi,codBuscado,monto);
			if(a0^.dato.cod = codBuscado)then
				monto:= monto+ a0^.dato.monto;
			montoTotalDecliente(a0^.hd,codBuscado,monto);
		end;
end;

//--------
function montoTotalDeclienteFunc(a0: arbol; codBuscado,monto: integer): integer;
begin
	if(a0 = nil)then
		montoTotalDeclienteFunc	:= monto
	else
		begin
			if(a0^.dato.cod = codBuscado)then
				monto:= monto + a0^.dato.monto;
			if(codBuscado < a0^.dato.cod)then
				montoTotalDeclienteFunc	:= montoTotalDeclienteFunc(a0^.hi,codBuscado,monto)
			else
				montoTotalDeclienteFunc	:= montoTotalDeclienteFunc(a0^.hd,codBuscado,monto);
		end;
end;
//--------

var
  L: arbol;
  customer: cliente;
  a,b: integer;
  cantCumplen: integer;
  montoTotal: integer;
begin
  randomize;
  inicializarLista(L);
  leerCliente(customer);
  While(customer.cod <> 0)do  //clientes de bancos, codCliente 0 se para la carga, el arbol esta ordenado por cliente
		begin
			cargarArbol(L,customer);
			leerCliente(customer);
		end;
	imprimirArbolInOrder(L);
	Writeln('cod a buscas de cliente: ');
	readln(a);
	montoTotal:= 0;
	montoTotalDecliente(L,a,montoTotal);
	Writeln('monto del cliente: ',a,' con un monto: ',montoTotal);
	Writeln('');
	montoTotal:= 0;
	Writeln('funcion de igual monto',montoTotalDeclienteFunc(L,a,montoTotal));
end.


```
