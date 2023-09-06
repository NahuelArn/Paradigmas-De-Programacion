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

//--------

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


function montoTotalDeclienteFunc(a0: arbol; codBuscado,monto: integer): integer;
begin
	if(a0 = nil)then  //va iterar todas las veces q se encuentre el mismo cod'
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

<h1 align="center"> eliminar nodo en un Arbol /sin Repetidos </h1>

```pas
    procedure Borrar(x: elem; var a: arbol; var ok: boolean);
    var
      aux: arbol;
    begin
      if (a = nil) then
        ok := false
      else 
        begin
          if (x < a^.dato) then	// BUSCO EN EL SUBARBOL IZQUIERDO
            Borrar (x, a^.HI, ok)
          else
            begin
              If (x > a^.dato) then	// BUSCO EN EL SUBARBOL DERECHO
                Borrar (x, a^.HD, ok)
              else 
                begin
                  ok := true;
                  if (a^.HI = nil) then 
                    begin				// SOLO HIJO A DERECHA
                      aux := a;
                      a := a^.HD;
                      dispose(aux)
                    end
                  else
                    if (a^.HD = nil) then 
                      begin		// SOLO HIJO A IZQUIERDA
                        aux := a;
                        a := a^.HI;
                        dispose(aux)
                      end
                    else 
                      begin		// DOS HIJOS. REEMPLAZO CON EL MENOR DE LA DERECHA
                        aux := Minimo(a^.HD);
                        a^.dato = aux^.dato;
                        Borrar(a^.dato, a^.HD, ok);
                      end
                end
            end;
    end;

```

* <details>
  <summary> 1) Implementacion eliminar nodo Arbol / sin ocurrencias </summary>
        
  ```pas
      program moduloDebugArbolRecursion;

      type
          arbol = ^nodo;

          nodo = record
              dato: integer;
              hi: arbol;
              hd: arbol;
          end;

      procedure inicializarLista(var L: arbol);
      begin
          L:= nil;
      end;

      procedure cargarArbol(var a: arbol; n: integer);
      begin
          if (a = nil) then
          begin
              new(a);
              a^.dato:= n;
              a^.hi:= nil;
              a^.hd:= nil;
          end
          else
          begin
              if (n < a^.dato) then
                  cargarArbol(a^.hi, n)
              else
                  if (n > a^.dato) then
                      cargarArbol(a^.hd, n);
          end;
      end;

      function minimo(a: arbol): arbol;
      begin
          if (a <> nil) then
          begin
              if (a^.hi = nil) then
                  minimo := a
              else
                  minimo := minimo(a^.hi);
          end
          else
              minimo := nil;
      end;

      procedure Borrar(x: integer; var a: arbol; var ok: boolean);
      var
          aux: arbol;
      begin
          if (a = nil) then
              ok := false
          else
          begin
              if (x < a^.dato) then
                  Borrar(x, a^.hi, ok)
              else
                  if (x > a^.dato) then
                      Borrar(x, a^.hd, ok)
                  else
                  begin
                      ok := true;
                      if (a^.hi = nil) then
                      begin
                          aux := a;
                          a := a^.hd;
                          dispose(aux);
                      end
                      else
                          if (a^.hd = nil) then
                          begin
                              aux := a;
                              a := a^.hi;
                              dispose(aux);
                          end
                          else
                          begin
                              aux := minimo(a^.hd);
                              a^.dato := aux^.dato;
                              Borrar(aux^.dato, a^.hd, ok);
                          end;
                  end;
          end;
      end;

      procedure imprimirArbolInOrder(a: arbol);
      begin
          if (a <> nil) then
          begin
              imprimirArbolInOrder(a^.hi);
              Write('In order: ', a^.dato, ' ');
              imprimirArbolInOrder(a^.hd);
          end;
      end;

      var
          L: arbol;
          num: integer;
          a: integer;
          ok: boolean;
      begin
          randomize;
          inicializarLista(L);
          Writeln('Ingresa un numero');
          readln(num);
          while (num <> 0) do
          begin
              cargarArbol(L, num);
              Writeln('Ingresa un numero');
              readln(num);
          end;
          imprimirArbolInOrder(L);
          Writeln('Valor a eliminar: ');
          readln(a);
          Borrar(a, L, ok);
          if (ok) then
              Writeln('Se pudo eliminar el nodo');
          imprimirArbolInOrder(L);
      end.

      ```
</details>


<h1 align="center">Arbol de Listas </h1>

```pas

{Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).
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
			Writeln('Que valor se esta guardando en el arbol2 ',a2^.dato^.dato.isbn);
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

var 
	ar0: arbol0; ar2: arbol2;
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
end.

```