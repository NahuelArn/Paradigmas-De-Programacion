{Implementar un programa que procese las ventas de un supermercado. El supermercado
dispone de una tabla con los precios y stocks de los 1000 productos que tiene a la venta.

a) Implementar un módulo que retorne, en una estructura de datos adecuada, los tickets de las ventas.
De cada venta se lee código de venta y los productos vendidos. Las ventas finalizan con el código de
venta -1. 

De cada producto se lee código y cantidad de unidades solicitadas. Para cada venta, la lectura
de los productos a vender finaliza con cantidad de unidades vendidas igual a 0. El ticket debe contener:
- Código de venta
- Detalle (código de producto, cantidad y precio unitario) de los productos que se pudieron vender. En
caso de no haber stock suficiente, se venderá la máxima cantidad posible.
- Monto total de la venta.

c) Implementar un módulo que reciba la estructura generada en el inciso a) y un código de
producto y retorne la cantidad de unidades vendidas de ese código de producto.}


productos = record  
  codigo: integer; //es lo q match
  cantUnidadesSolicitadas;
end;

venta = record
  codVenta: integer;
  productosVendidos: productos;
end;

program ejercicio3_2023;

const
	dimFmil = 1000;
type
	rango1000 = 1..dimFmil;
	
	tabla = record
		precios: real;
		stock: integer;
	end;
	
	vTabla = array[rango1000]of tabla;
	
	ticked = record
		codVenta : integer;
		codProducto: integer; //supongo q es el cod q matchea con la tabla
		cant: integer;
		precio: real;
		montoTotalVenta: real;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato: ticked;
		sig: lista;
	end;
		
var
	v: vTabla;
begin
	cargarTabla(v); //se dispone
	
end.











