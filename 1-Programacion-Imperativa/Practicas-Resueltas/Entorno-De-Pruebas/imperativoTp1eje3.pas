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




program imperativoTp1eje3;

const
	dimFmil = 1000;
type
	rango1000 = 1..dimFmil;
	
	tabla = record
		precios: real;
		stock: integer;
	end;
	
	vTabla = array[rango1000]of tabla;
	
	producto = record  
		codigo: integer; //es lo q match con el array
		cantUnidadesSolicitadas: integer;  //si me ingresan 0, o me quedo en 0 en la categoria que estoy pidiendo,termino de leer productos
	end;

	lista = ^nodo;
	
	nodo = record
		dato: producto;
		sig: lista;
	end;

	venta = record
		coddVenta: integer;
		productosVendidos: lista;
	end;


	ticked = record	//-1
		codVenta : venta;
		montoTotalVenta: real;
	end;
	
	lista2 = ^nodo2;
	
	nodo2 = record
		dato: ticked;
		sig: lista2;
	end;

procedure inicializarTickedListas(var L2: lista2);
begin
	L2:= nil;	
end;

procedure cargarTabla(var v: vTabla);
var
	i: integer;
begin
	for i:= 1 to dimFmil do
		begin
			v[i].precios:= random(101);
			v[i].stock:= random(31); //
		end;
end;


procedure agregarAtras(var L1,Ult: lista; p: producto);
var
	nue: lista;
begin
	new(nue);
	nue^.dato:= p;
	nue^.sig:= nil;
	if(L1 = nil)then
		L1:= nue
	else
		Ult^.sig:= nue;
	Ult:= nue;
end;


procedure leerProducto(var productosLista: lista; var vectorTabla: vTabla;var montoTotalDeVenta: real);
var
	Ult: lista;
begin
	
	productosLista^.dato.codigo:= random(100)-1; //genera un numero random de -1 a 100  ( CODIGO Q LE PEGA AL ARRAY )
	
	productosLista^.dato.cantUnidadesSolicitadas:= random(11)-1;  //cantidad de productos q le voy a pedir al array
	// si tengo stock Y la cantidad de unidades solicitadas sea <> de 0 
	While (vectorTabla[productosLista^.dato.codigo].stock <> 0) and (productosLista^.dato.cantUnidadesSolicitadas <> 0) do
		begin	
			//verifico que tenga suficiente stock
			if(vectorTabla[productosLista^.dato.codigo].stock >= productosLista^.dato.cantUnidadesSolicitadas)then
				begin
					agregarAtras(productosLista,Ult,productosLista^.dato);
					//le pego al array, descontando el stock
					vectorTabla[productosLista^.dato.codigo].stock:= vectorTabla[productosLista^.dato.codigo].stock - productosLista^.dato.cantUnidadesSolicitadas;
					//ya verifique esta compra de producto se va hacer
					montoTotalDeVenta:= montoTotalDeVenta + (vectorTabla[productosLista^.dato.codigo].precios * productosLista^.dato.cantUnidadesSolicitadas);
					if(vectorTabla[productosLista^.dato.codigo].stock = 0)then
						Writeln('Flaquito te acabas de quedar sin stock del producto q me pediste, pedi otros productos o termino con tu compra');
				end;
			productosLista^.dato.codigo:= random(100)-1; //genera un numero random de -1 a 100  ( CODIGO Q LE PEGA AL ARRAY )
			productosLista^.dato.cantUnidadesSolicitadas:= random(11);  //cantidad de productos q le voy a pedir al array
		end;
end;

// Agrego un nuevo ticked, a mi lista de tickeds
procedure agregarAdelante(var L2: lista2; tick: ticked);	
var
	nue: lista2;
begin
	new(nue);
	nue^.dato:= tick;
	nue^.sig:= L2;
	L2:= nue;
end;

//carga de tickeds
procedure cargarCompras(var L2: lista2; var vectorTabla: vTabla);
var
	montoTotalDeVenta: real;
begin
	Writeln('FLAG 2');

	L2^.dato.codVenta.coddVenta:= random(20)-1;
	Writeln('sarasaaa');
	Writeln('FLAG 3');
	
	While(L2^.dato.codVenta.coddVenta <> -1)do
		begin
			
			Writeln('FLAG 4');
			montoTotalDeVenta:= 0; //ticked nuevo, montoTotal nuevo
			//le mando una instacia de la lista
			L2^.dato.codVenta.productosVendidos:= nil;	//inicializo la Lista de ventas
			//le mando la lista ventas
			
			leerProducto(L2^.dato.codVenta.productosVendidos,vectorTabla,montoTotalDeVenta);

			L2^.dato.montoTotalVenta:= montoTotalDeVenta;
			agregarAdelante(L2,L2^.dato);
			L2^.dato.codVenta.coddVenta:= random(20)-1;
		end;
end;

var
	vectorTabla: vTabla;
	{L1: lista;	//lista1 = productos = }
	L2: lista2;	//lista2 = ticked = 

begin
	randomize;
	cargarTabla(vectorTabla); //se dispone
	inicializarTickedListas(L2);
	Writeln('FLAG 1');
	cargarCompras(L2, vectorTabla);
	Writeln('FLAG 5');
end.


{program ejercicio3_2023;

const
	dimFmil = 1000;
type
	rango1000 = 1..dimFmil;
	
	tabla = record
		precios: real;
		stock: integer;
	end;
	
	vTabla = array[rango1000]of tabla;
	
	producto = record  
		codigo: integer; //es lo q match con el array
		cantUnidadesSolicitadas: integer;  //si me ingresan 0, o me quedo en 0 en la categoria que estoy pidiendo,termino de leer productos
	end;

	lista = ^nodo;
	
	nodo = record
		dato: producto;
		sig: lista;
	end;

	venta = record
		codVenta: integer;
		productosVendidos: lista;
	end;


	ticked = record	//-1
		codVenta : venta;
		codProducto: integer; //supongo q es el cod q matchea con la tabla //campo q no usaria
		cant: integer;
		precio: real;	//campo q no usaria
		montoTotalVenta: real;
	end;
	
	lista2 = ^nodo2;
	
	nodo2 = record
		dato: ticked;
		sig: lista2;
	end;

procedure inicializarTickedListas(var L1: lista2);
begin
	L1:= nil;	
end;
//productos
procedure leerProducto(produc: lista; var vectorTabla: vTabla);
var
begin
	produc^.dato.codigo:= random(101); //genera un numero random de 0 a 100 //( CODIGO QUE LE PEGA AL ARRAY );

	produc^.dato.cantUnidadesSolicitadas:= random(11); //cantidad de productos q le voy a pedir al array

	While(vectorTabla[produc^.dato.codigo].stock > 0 and produc^.dato.cantUnidadesSolicitadas <> 0)do
		begin
			
		end;

	
	
	if(vectorTabla[produc^.dato.codigo].stock > 0)then
		begin
			produc^.dato.cantUnidadesSolicitadas:= random(11); //cantidad de productos q le voy a pedir al array

		end
	else
		Writeln('Sin stock ');
		produc.cantUnidadesSolicitadas:= 0; //saldria de productos

	produc.cantUnidadesSolicitadas:= random(11); //cantidad de productos q le voy a pedir al array
end;

//venta Lista
procedure leerVenta(var vent: venta; var vectorTabla: vTabla);
var

begin
	vent.codVenta:= random(101)-1; //genera un numero random de -1 a 100  ( CODIGO DE VENTA )
	
	vent.productosVendidos:= nil;
	leerProducto(vent.productosVendidos,vectorTabla);
	While(vent.productosVendidos.dato.cantUnidadesSolicitadas <> 0)do
		begin
			
		end;
	
end;

//main
procedure cargarCompras(var L2: lista2; var vectorTabla: vTabla);
var
	prod: producto;
	vent: venta;

begin
	//le mando una instacia de la lista
	leerVenta(L2^.dato.codVenta,vectorTabla);

	While(L2^.dato.codVenta <> -1)do
		begin
			
		end;
end;

var
	vectorTabla: vTabla;
	L1: lista;
	L2: lista2;
//lista2 = ticked =  

//lista1 = productos = 
begin
	randomize;
	cargarTabla(v); //se dispone
	inicializarTickedListas(L1);
	cargarCompras(L1, vectorTabla);

	//---------------------------
	L2:= L1^.dato.codVenta;	//aca ya estoy parado en productos
	L2^.dato.cantUnidadesSolicitadas;		//tengo acceso a productos
end.}