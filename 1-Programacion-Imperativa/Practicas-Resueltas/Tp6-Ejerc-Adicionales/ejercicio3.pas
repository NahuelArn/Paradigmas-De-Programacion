{Un supermercado requiere el procesamiento de sus productos. De cada producto se
conoce código, rubro (1..10), stock y precio unitario. Se pide:

a) Generar una estructura adecuada que permita agrupar los productos por rubro. A su
vez, para cada rubro, se requiere que la búsqueda de un producto por código sea lo
más eficiente posible. La lectura finaliza con el código de producto igual a -1.
b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código
de producto y retorne si dicho código existe o no para ese rubro.
c) Implementar un módulo que reciba la estructura generada en a), y retorne, para cada
rubro, el código y stock del producto con mayor código.
d) Implementar un módulo que reciba la estructura generada en a), dos códigos y
retorne, para cada rubro, la cantidad de productos con códigos entre los dos valores
ingresados
}
{
* producto = cod,rubro[1..10], stock y precio unitario
* a: un vector de arboles ordenado por codigo
* b: recibe un campo del vector, osea un arbol y busca en ese arbol el codigo de producto y que devuelva true si existe
* c: generar un vector, recorriendo cada arbol del vector, y la lista nueva va tener el mayor de ese arbol
* d: retornar otro vector, pero este de enteros
* }
program ejercicio3;
const
	dimF = 10;
type
	
	rango10 = 1..dimF;
	
	producto = record
		cod: integer;
		rubro: rango10;
		stock: integer;
		precioUnitario: real;
	end;
	
	arbol = ^nodo;
	
	nodo = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;
	
	vectorRubros = array[rango10]of arbol;
	
	nuevaEstructura = record
		cod: integer;
		stock: integer;
	end;
	
	vPuntoc = array[rango10]of nuevaEstructura;
	 
procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;

procedure inicializarArboles(var v: vectorRubros);
var
	i: integer;
begin
	for i:= 1 to dimF do
		inicializarPuntero(v[i]);
end;

procedure leerProducto(var p: producto);
begin
	Writeln('Ingrese cod (-1 para cortar)');
	readln(p.cod);
	if(p.cod <> -1)then
		begin
			Writeln('Ingrese rubro ');
			readln(p.rubro);
			Writeln('Ingrese stock');
			readln(p.stock);
			Writeln('Ingrese precioUnitario');
			readln(p.precioUnitario);
		end;
end;

procedure agregarProductos(var a: arbol;p: producto);
begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= p;
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(p.cod <= a^.dato.cod)then
				agregarProductos(a^.hi,p)
			else
				agregarProductos(a^.hd,p);
		end;
end;

procedure cargarProductosEnRubros(var v: vectorRubros);
var p: producto;
begin
	leerProducto(p);
	While(p.cod <> -1)do
		begin
			agregarProductos(v[p.rubro],p);
			leerProducto(p);
		end;
end;

procedure imprimirNodo(p: producto);
begin
	Writeln('El cod es: ',p.cod);
	Writeln('El rubro es: ',p.rubro);
	Writeln('Ingrese stock',p.stock);
	Writeln('Ingrese precioUnitario',p.precioUnitario);
end;

procedure imprimirArbol(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirArbol(a^.hi);
			imprimirNodo(a^.dato);
			imprimirArbol(a^.hd);
		end;
end;

procedure imprimirVector(v: vectorRubros);
var i: integer;
begin
	for i:= 1 to dimF do
		begin
			if(v[i] <> nil)then
				begin
					Writeln(); Writeln();
					Writeln('estas parado en el rubro ',i);
					imprimirArbol(v[i]); //rubro
					Writeln(); Writeln();
				end;
		end;
end;

{b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código
de producto y retorne si dicho código existe o no para ese rubro.}
{* b: recibe un campo del vector, osea un arbol y busca en ese arbol el codigo de producto y que devuelva true si existe
}
function estaEnElNodo(a: arbol; codProducto: integer):boolean;
begin
	if(a = nil)then
		estaEnElNodo:= false
	else
		begin
			if(codProducto = a^.dato.cod)then
				estaEnElNodo:= true
			else
				begin
					if(codProducto < a^.dato.cod)then
						estaEnElNodo:= estaEnElNodo(a^.hi,codProducto)
					else
						estaEnElNodo:= estaEnElNodo(a^.hd,codProducto)
				end;
		end;
end;

function elCodEstaEnLaEstructura(v: vectorRubros; codRubro: integer;codProducto: integer):boolean;
begin
	elCodEstaEnLaEstructura:= estaEnElNodo(v[codRubro],codProducto);
end;

{c) Implementar un módulo que reciba la estructura generada en a), y retorne, para cada
rubro, el código y stock del producto con mayor código.}
//podria ser una lista? Si, pero ya sabbes q vas a generar 5 cosas
//mandale a un vector pa
procedure inicializarCampos(var vC: vPuntoc);
var i: integer;
begin
	for i:= 1 to dimF do
		begin //podria ser un modulo pero bueno
			vC[i].cod:= 0;
			vC[i].stock:= 0;
		end;
end;

function sacarMax(a: arbol): arbol;
begin
	if(a = nil)then
		sacarMax:= nil
	else
		begin
			if(a^.hd = nil)then
				sacarMax:= a
			else
				sacarMax:= sacarMax(a^.hd);
		end;
end;

procedure filtrarData(aux:arbol;var nE: nuevaEstructura);
begin
	nE.cod:= aux^.dato.cod;
	nE.stock:= aux^.dato.stock;
end;

procedure generarNuevaEstructura(v: vectorRubros;var vC: vPuntoc);
var i:integer; aux: arbol;
begin
	for i:= 1 to dimF do
		begin
			if(v[i] <> nil)then	//puede q no cargue todos los rubros, para no mandarme cagadas con los punteros
				begin
					aux:= sacarMax(v[i]);
					filtrarData(aux,vC[i]);
				end;
		end;
end;

procedure imprimir(n: nuevaEstructura);
begin
	Writeln('cod: ',n.cod);
	Writeln('stock: ',n.stock);
end;

procedure imprimirNuevaEstructura(vC: vPuntoc);
var i: integer; //
begin
	for i:=  1 to dimF do
		begin
			if(vC[i].cod <> 0)then
				imprimir(vC[i]);
		end;
end;

var
	v: vectorRubros;
	codRubroBuscado: integer; codProducto: integer;
	vC: vPuntoc;
begin
	inicializarArboles(v);
	cargarProductosEnRubros(v);
	imprimirVector(v);
	Writeln('Ingres el cod del producto ');
	readln(codProducto);
	Writeln('Ingres el rubro del producto ');
	readln(codRubroBuscado);
	if(elCodEstaEnLaEstructura(v,codRubroBuscado,codProducto))then
		Writeln('si esta cara ')
	else
		Writeln(' nao nao cara nao tem, caraloho');
	inicializarCampos(vC);
	generarNuevaEstructura(v,vC);
	imprimirNuevaEstructura(vC);
end.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
