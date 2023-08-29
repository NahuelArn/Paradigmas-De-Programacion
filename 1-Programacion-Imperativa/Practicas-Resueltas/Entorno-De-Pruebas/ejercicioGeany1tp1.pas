{Se desea procesar la información de las ventas de productos de un comercio (como máximo
50).
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce el
día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).
b. Un módulo que muestre el contenido del vector resultante del punto a).
c. Un módulo que ordene el vector de ventas por código.
d. Un módulo que muestre el contenido del vector resultante del punto c).
e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.
f. Un módulo que muestre el contenido del vector resultante del punto e).
g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
h. Un módulo que muestre la información obtenida en el punto g)}

program ejercicio1_2023;



type
  venta = record
    dia: rango12;
    codProducto: rango15;
    cantVendida: rango99;
  end;

  vectorVentas = array[rango15]of venta;

procedure leerVenta(var v: venta); //registro
begin
	Writeln('Ingrese el dia de la venta: ');
	v.dia:= random(13)+1;
	Writeln('Ingrese el codigo de producto: ');
	v.codProducto:= random(16)+1;
	Writeln('Ingrese la cantidad vendida: ');
	v.cantVendida:= random(100)+1;
end;

procedure cargarVectorVentas(var v: vectorVentas);
var
	i: integer;
begin
	for i:= 1 to dimF15 do
		begin
			leerVenta(v[i]);
		end;
end;

var
  v: vectorVentas;
begin 
  cargarVectorVentas(v);
  
end.
