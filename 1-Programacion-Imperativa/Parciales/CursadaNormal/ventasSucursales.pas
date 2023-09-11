{Se lee información acerca de las ventas de productos realizadas en las sucursales de una empresa. 
* De cada venta se conoce fecha, código de producto, cantidad vendida y monto total de la venta. 
* La lectura finaliza cuando se lee el código de producto -1, el cual no se procesa. 
* Implementar un programa para que a partir de la información leida, resuelva los siguientes ítems:
a) Generar un árbol binario de búsqueda ordenado por código de producto, donde cada nodo contenga el código del producto y el monto total vendido. 
* El código de producto no puede repetirse en el árbol.
b) Realizar un módulo que reciba el árbol generado en a. y un código de producto y retorne la suma de todos los montos 
* vendidos para los códigos de productos mayores al código recibido.
Nota: La información se lee en forma desordenada. Puede existir más de una venta para un mismo código de producto.}
{
* Intro : venta = fecha, codProducto, cantVendida, montoTotalVenta
* a: generar Arbol ---> ordenado por codigo de producto --> en cada nodo del arbol se guarda codProducto y montoTotal vendido --corte con -1 codProducto
* b: se recibe un cod y el arbol, y todo valor mayor al cod pasado se va sumar su monto despues lo imprimo
* 
* }
//0:34
//0:45 testeado
program ventasSucursales;

type
	venta = record
		fecha: integer;	//dia;
		codProducto: integer;
		cantVendida: integer;
		montoTotalVenta: real;
	end;
	
	//-------
	producto = record		
		codProducto: integer;
		montoTotalVendido: real;
	end;
	
	arbol = ^nodoArbol;
	
	nodoArbol = record
		dato: producto;
		hi: arbol; hd: arbol;
	end;

procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;

procedure leerVenta(var v: venta);
begin
	Writeln('codProducto: (-1 corta)');
	readln(v.codProducto);
	if(v.codProducto <> -1)then
		begin
			Writeln('fecha: ');
			//readln(v.fecha);
			v.fecha:= random(32)+1;
			Writeln('cant Vendida: ');
			//readln(v.cantVendida);
			v.cantVendida:= random(10);
			Writeln('monto total de venta: ');
			readln(v.montoTotalVenta);
			//v.montoTotalVenta:= random(1000);
		end;
end;

procedure filtrarData(v: venta; var p: producto);
begin
	p.codProducto:= v.codProducto;
	p.montoTotalVendido:= v.montoTotalVenta;
end;

procedure cargarArbol(var a: arbol; p: producto);	//ordenado por cod de producto
begin
	if(a = nil)Then
		begin
			new(a);
			a^.dato:= p; //no hace falta inicializar en 0 por q este eseria el valor inicial al cual sumar despues 
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(p.codProducto <= a^.dato.codProducto)then
				begin
					if(p.codProducto = a^.dato.codProducto)then
						a^.dato.montoTotalVendido:= a^.dato.montoTotalVendido + p.montoTotalVendido;
					cargarArbol(a^.hi,p);
				end
			else
				begin
					if(p.codProducto > a^.dato.codProducto)then
						cargarArbol(a^.hd,p)
				end;
		end;
end;

procedure cargarVentas(var a: arbol);
var	v: venta; p: producto;
begin
	leerVenta(v);
	While(v.codProducto <> -1)do
		begin
			filtrarData(v,p);
			cargarArbol(a,p);
			leerVenta(v);
		end;
end;
{b) Realizar un módulo que reciba el árbol generado en a. y un código de producto y retorne la suma de todos los montos 
* vendidos para los códigos de productos mayores al código recibido.}

{* b: se recibe un cod y el arbol, y todo valor mayor al cod pasado se va sumar su monto despues lo imprimo
}

function sumarApartirDe(a: arbol; codParaArriba: integer): real;
begin
	if(a = nil)then
		sumarApartirDe:= 0
	else
		begin
			if(a^.dato.codProducto > codParaArriba)then
				sumarApartirDe:= sumarApartirDe(a^.hi,codParaArriba) + a^.dato.montoTotalVendido + sumarApartirDe(a^.hd,codParaArriba)
			else
				sumarApartirDe:= sumarApartirDe(a^.hd,codParaArriba);
		end;
end;

//testing
procedure imprimirVentas(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirVentas(a^.hi);
			Writeln('Cod actual ',a^.dato.codProducto);
			imprimirVentas(a^.hd);
		end;
end;

var
	a: arbol;
	suma: real;
	codParaArriba: integer;
begin
	inicializarPuntero(a);
	cargarVentas(a);
	imprimirVentas(a); //testing
	Writeln('Ingrese un cod de producto (se van a imprimir la suma de todos los cod mayores q el )');
	codParaArriba:= 12;
	suma:= sumarApartirDe(a,codParaArriba);
	Writeln('la suma de todos los montos es: ',suma:2:2); //se puede directamente imprimir la funcion aca y ahorrarme la variable 
	//pero como te pide retorna y despues el dato lo tuviera que usar tendria q llamar de nuevo  a la funcion
end.
