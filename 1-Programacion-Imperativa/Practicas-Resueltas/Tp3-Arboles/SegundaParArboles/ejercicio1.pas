{
* Implementar un programa modularizado para una librería que:
a. Almacene los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados la cantidad total de
unidades vendidas y el monto total. De cada venta se lee código de venta, código del
producto vendido, cantidad de unidades vendidas y precio unitario. El ingreso de las
ventas finaliza cuando se lee el código de venta -1.
b. Imprima el contenido del árbol ordenado por código de producto.
c. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.
d. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.
e. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir).
* }
{
* a: arbol de productos --> criterio de orden por codigo de producto --> 
* el ingreso de las ventas finaliza con el codigo de venta -1 -->no todo se guarda, se filtra de lo q se lee para cargar el arbol
* b: impresion inOrder (ya lo tengo ordenado por codigo de producto)
* c: tengo que recorrer todo el arbol, para saber el codigo de producto con mayor cantidad cant vendidas (mi criterio de orden no me sirve en este caso)
* d: usar mi criterio de orden e ir imprimiendo entre rangos (mirar otra vez)
* e: usar mi criterio de orden e ir imprimiendo entre rangos ( -1 bot y +1top) Funcion
* 
* 9//
* la quede > 1:30 error en tiempo de ejecucion
* }
program ejercicio1;
  
type
	producto = record	//criterio de orden cod producto
		codProducto: integer;
		canTotalUniVendidas: integer;
		montoTotal: real;
	end;
	
	arbol = ^arbolProducto;
	
	arbolProducto = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;
	
	ventaAux = record	//termina de leer cuando se lee el cod -1
		codProducto: integer;
		cantVendida: integer;
		precioUnitario: real;
	end;

procedure inicializarPunteroArbol(var a: arbol);
begin
	a:= nil;
end;

procedure leerVenta(var vent: ventaAux);
begin
	Writeln('Ingrese el codigo de producto: (-1 para cortar) ');
	readln(vent.codProducto);
	if(vent.codProducto <> -1)then
		begin
			Writeln('Ingrese la cantidad vendida: ');
			readln(vent.cantVendida);
			Writeln('Ingrese el precio unitario');
			readln(vent.precioUnitario);
		end;
end;

procedure sacarData(vent: ventaAux; var produ: producto);
begin
	produ.canTotalUniVendidas:= vent.cantVendida;
	produ.montoTotal:= vent.precioUnitario * vent.cantVendida;
	produ.codProducto:= vent.codProducto;
end;

//en este caso voy a tener repetidos, pero no nodos repetidos
procedure cargarArbol(var a: arbol;produ: producto);
begin
	Writeln('---1--');
	if(a = nil)then
		begin
			new(a);
			a^.dato:= produ;
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(a^.dato.codProducto = produ.codProducto)then	//cargo la data para cada nodo (cod Producto)
				begin
					a^.dato.canTotalUniVendidas:= a^.dato.canTotalUniVendidas + produ.canTotalUniVendidas;
					a^.dato.montoTotal:= a^.dato.montoTotal + produ.montoTotal;
					a^.dato.codProducto:= produ.codProducto; //sarasa
				end;
			if(produ.codProducto < a^.dato.codProducto)then	//filtro si pasara algun repetido, no deberia 
				cargarArbol(a^.hi,produ)
			else
				if(produ.codProducto > a^.dato.codProducto)then
					cargarArbol(a^.hd,produ);
		end;
end;

procedure cargarVentas(var a: arbol);
var 
	vent: ventaAux;
	produ: producto;
begin
	leerVenta(vent);
	While(vent.codProducto <> -1)do
		begin
			sacarData(vent,produ);
			cargarArbol(a,produ);
			Writeln('---2--');
			leerVenta(vent);
		end;
end;

{b. Imprima el contenido del árbol ordenado por código de producto.}

procedure imprimirInOrder(a: arbol);
begin
	Writeln('---4--');
	imprimirInOrder(a^.hi);
	Writeln('Imprimiendo el cod In order: ',a^.dato.codProducto);
	Writeln('---5--');
	imprimirInOrder(a^.hd);
	Writeln('---6--');
end;

{c. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.}

function buscarAlMayor(a: arbol; bigVentas,codMayor: integer):integer;
begin
	if(a = nil)then
		begin
			buscarAlMayor:= codMayor;
		end
	else
		begin
			buscarAlMayor:= buscarAlMayor(a^.hi,bigVentas,codMayor);
			if(a^.dato.canTotalUniVendidas > bigVentas)then
				begin
					bigVentas:= a^.dato.canTotalUniVendidas;
					codMayor:= a^.dato.codProducto;
				end;
			buscarAlMayor:= buscarAlMayor(a^.hd,bigVentas,codMayor);
		end;
end;

{d. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.}
function cantMenoresXcod(a: arbol; codMenorRecibido,auxCant: integer): integer;
begin
	if(a = nil)then
		cantMenoresXcod:= auxCant
	else
		begin
			if(codMenorRecibido < a^.dato.codProducto)then
				begin
					auxCant:= auxCant+1;
					cantMenoresXcod:= cantMenoresXcod(a^.hi,codMenorRecibido,auxCant);
				end
			else
				cantMenoresXcod:= cantMenoresXcod(a^.hd,codMenorRecibido,auxCant)
		end;
end;

{e. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir}

function cuantoGana(a: arbol;montoTotal: real; codIzquierda,codDerecha: integer): real;
begin
	if(a = nil)then
		cuantoGana:= montoTotal
	else
		begin
			if(a^.dato.codProducto > codIzquierda) and (a^.dato.codProducto  < codDerecha)then
				begin
					montoTotal:= montoTotal + a^.dato.montoTotal;
					cuantoGana:= cuantoGana(a^.hi,montoTotal,codIzquierda,codDerecha);
					cuantoGana:= cuantoGana(a^.hd,montoTotal,codIzquierda,codDerecha); 
				end
			else
				begin
					if(a^.dato.codProducto > codIzquierda)then
						cuantoGana:= cuantoGana(a^.hi,montoTotal,codIzquierda,codDerecha)
					else
						cuantoGana:= cuantoGana(a^.hd,montoTotal,codIzquierda,codDerecha); 
				end;
		end;
end;

var
	a: arbol;
	bigVentas: integer; codMayor: integer;
	auxCant: integer; codMenorRecibido: integer;
	codIzquierda,codDerecha: integer;
	montoTotal: integer;
begin
  inicializarPunteroArbol(a);
  cargarVentas(a);
  Writeln('---3--');
  imprimirInOrder(a);
  bigVentas:= -999;
  codMayor:= 0;
  Writeln('El cod de producto con mayor cant de uni vendidas es: ',buscarAlMayor(a,bigVentas,codMayor));
  
  Writeln('ingrese un cod de producto para ver cuantos cod menores q el hay ');
  readln(codMenorRecibido);
  auxCant:= 0;
  Writeln('ingrese un cod de producto y la cantida de cods menores q el es: ',cantMenoresXcod(a,codMenorRecibido,auxCant));
  
  Writeln('Ingrese el rango inferior: ');
  readln(codIzquierda);
  Writeln('Ingrese el rango superior ');
  readln(codDerecha);
  codIzquierda:= codIzquierda +1;
  codDerecha:= codDerecha-1;
  montoTotal:= 0;
  Writeln('El monto total entre el rango A y B es: ',cuantoGana(a,montoTotal,codIzquierda,codDerecha):2:2);
  
end.
