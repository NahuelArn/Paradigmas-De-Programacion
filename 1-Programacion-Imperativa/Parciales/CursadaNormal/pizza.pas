{Una pizzería recibe pedidos telefónicos de sus clientes. De cada pedido interesa conocer: 
* DNI del cliente, nombre, fecha y monto a abonar por el pedido.
1- Lea la información de los pedidos telefónicos hasta ingresar uno con monto 0. 
* A partir de esto, genere una estructura que almacene para cada DNI de cliente, 
* su nombre y una lista con información de la fecha y monto de los pedidos realizados. 
* La estructura debe estar ordenada por DNI y ser eficiente para la búsqueda por dicho criterio.
A partir de la estructura generada en 1) realice módulos independientes para:
2- Informar la cantidad de clientes que realizaron pedidos en una fecha que se lee de teclado.
3- Informar el total abonado y el total de pedidos realizados por el cliente cuyo DNI coincide con uno ingresado.
Nota: la información en 1 se lee sin orden alguno.]
 }


// 1: pedido = dniCliente, nombre, fecha y monto por el pedido criterio de corte monto = 0
//* arbol --> cliente --> dni,nombre y un campo es una lista con la fecha y monto de los pedidos realizados
//* la estructura tiene q ser eficiente por dni del cliente 
//* 
//* 2: se lee un fecha por teclado y se busca por todo el arbol ya q no matchea el criterio de orden
//* me meto en cada lista y si retorna true cuento 1 en cantQcumplen en X fecha
//* 3: buscar de manera eficiente en el arbol y sumar sus montos y cant de productos q compro
//* 
//* 0: 6min
//* 
// 1:05
program pizza;

type
	str20 = string[20];
	datos = record
		dni: integer;
		nombre : str20;
		fecha: integer; // dia o mes
		monto: real;
	end;
	//------------------------------
	orden = record
		fecha: integer;
		monto: real;	
	end;

	pedidos = ^nodo;

	nodo = record
		dato: orden;
		sig: pedidos;
	end;

	cliente = record
		nombre : str20;
		pedido: pedidos;
	end;

	arbol = ^nodoArbol;

	nodoArbol = record
		dni: integer;
		dato: cliente;
		hi: arbol;
		hd: arbol;
	end;
{ 1  Lea la información de los pedidos telefónicos hasta ingresar uno con monto 0
* A partir de esto, genere una estructura que almacene para cada DNI de cliente, 
* su nombre y una lista con información de la fecha y monto de los pedidos realizados. 
* La estructura debe estar ordenada por DNI y ser eficiente para la búsqueda por dicho criterio. }
procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;

procedure leerPedido(var d: datos);
begin
	Writeln('monto: ');
	readln(d.monto);
	if(d.monto <> 0)then
		begin
			Writeln('dni: ');
			readln(d.dni);
			Writeln('nombre: ');
			readln(d.nombre);
			Writeln('fecha: ');
			readln(d.fecha);
		end;
end;

//--
procedure cargaFiltrada(var p: orden; d: datos);
begin
	p.fecha:= d.fecha;
	p.monto:= d.monto;
end;

procedure agregarAdelante(var L: pedidos; d: datos);
var nue: pedidos;	p: orden;
begin
	new(nue);
	cargaFiltrada(p,d);
	nue^.dato:= p;
	nue^.sig:= L;
	L:= nue;
end;

procedure cargarDatos(var a: arbol; d: datos);
begin
	a^.dni:= d.dni;
	a^.dato.nombre:= d.nombre;
	agregarAdelante(a^.dato.pedido,d);
end;

procedure cargarArbol(var a: arbol; d: datos);
begin
	if(a = nil)then
		begin
			new(a);
			cargarDatos(a,d);
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		if(d.dni < a^.dni)then
			cargarArbol(a^.hi,d)	
		else
			begin
				if(d.dni > a^.dni)then
					cargarArbol(a^.hd,d)
			end;	
end;



procedure cargarPedidos(var a: arbol);
var d: datos;
begin
	leerPedido(d);
	While(d.monto <> 0)do
		begin
			cargarArbol(a,d);
			leerPedido(d);
		end;
end;

{2- Informar la cantidad de clientes que realizaron pedidos en una fecha que se lee de teclado.}
function buscarEnLista(L: pedidos; fechaBuscada: integer): integer;
begin
	if(L = nil)then
		buscarEnLista:= 0
	else
		begin
			if(L^.dato.fecha = fechaBuscada)then
				buscarEnLista:= 1
			else
				buscarEnLista(L^.sig,fechaBuscada);
		end;
end;

function puntoB(a: arbol;fechaBuscada: integer): integer;
begin
	if(a = nil)then
		puntoB:= 0
	else
		begin
			puntoB:= puntoB(a^.hi,fechaBuscada) +buscarEnLista(a^.dato.pedido,fechaBuscada)+ puntoB(a^.hd,fechaBuscada);
		end;
end;

{3- Informar el total abonado y el total de pedidos realizados por el cliente cuyo DNI coincide con uno ingresado.
Nota: la información en 1 se lee sin orden alguno.}
procedure imprimir(m: real; cant: integer);
begin
	Writeln('monto total ',m);
	Writeln('cant total: ',cant);
end;

procedure informarData(L: pedidos);
var cant: integer; montoTotal: real;
begin
	cant:= 0; montoTotal:= 0;
	if(L <> nil)then
		begin
			cant:= cant+1;
			montoTotal:= montoTotal+ L^.dato.monto;
			informarData(L^.sig);
		end;
	imprimir(montoTotal,cant);
end;

procedure puntoC(var a: arbol; dniBuscado: integer);
begin
	if(a <> nil)then
		begin
			if(dniBuscado = a^.dni)then
				informarData(a^.dato.pedido);
			if(dniBuscado < a^.dni)then
				puntoC(a^.hi,dniBuscado)	
			else
				puntoC(a^.hd,dniBuscado)	
		end;

end;

var
	a: arbol;
	fechaBuscada: integer;
	dniBuscado: integer;
begin
	inicializarPuntero(a);
	cargarPedidos(a);
	Writeln('Ingrese una fecha para saber la cant de pedidos ');
	readln(fechaBuscada);
	Writeln('la cantidad es ',puntoB(a,fechaBuscada));
	Writeln('Ingrese un dni para buscar su cant de compras y su monto total ');
	readln(dniBuscado);
	puntoC(a,dniBuscado);
end.









