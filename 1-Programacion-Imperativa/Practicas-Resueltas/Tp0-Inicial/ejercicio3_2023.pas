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


program ejercicio3_2023;

const
	dimF1k = 10;
type
	rango1000 = 1..dimF1k;

	tabla = record
		precio: real;
		stock: integer;
	end;

	vTabla = array[rango1000]of tabla;

	venta = record	//el q le pega al array
		codProducto: integer;
		cantidadDeUnidadesVendidas: integer;
		precioUnitario: real;
	end;

	listaDetalle = ^nodoDetalle;

	nodoDetalle = record
		dato: venta;
		sig: listaDetalle;
	end;

	ticked = record	//lista de tickeds
		codigoDeVenta: integer;	//cod random del ticked
		detalle: listaDetalle;	//en un ticked puede tener muchas ventas
		montoTotalDeVenta: real;
	end;

	listaTicked = ^nodoTicked;

	nodoTicked = record
		dato: ticked;
		sig: listaTicked;
	end;

procedure leerTabla(var t: tabla);
begin
	Writeln('Ingrese el precio del producto: ');
	t.precio:= random(101);
	Writeln('Ingrese el stock del producto: ');
	t.stock:= random(21); //random de 0 a 20
end;

procedure cargarVtabla(var v: vTabla);
var
	t: tabla;
	i: integer;
begin
	for i:= 1 to dimF1k do
		begin
			leerTabla(t);
			v[i]:= t;
		end;
end;

procedure inicializarLista(var L: listaTicked);
begin
	L:= nil;
end;

procedure leerProducto(var p: venta; var v: vTabla);

begin
	Writeln('Ingrese el codigo del producto: ');
	p.codProducto:= random(11)+1;
	Writeln('Ingrese la cantidad de unidades solicitadas ');
	p.cantidadDeUnidadesVendidas:= random(21);
	Writeln('Ingrese el precio unitario: ');
	p.precioUnitario:= v[p.codProducto].precio;
	Writeln('sarasa 3');
end;

procedure inicializarListaProductos(var l: listaDetalle);
begin
	
	l:= nil;	
	
end;

procedure validandoStockYasignando(p: venta; var v: vTabla);
begin
	if(v[p.codProducto].stock >= p.cantidadDeUnidadesVendidas)then	//si lo que pido es menor o = al stock q tengo disponible le pego al array descontando
		begin
			v[p.codProducto].stock := v[p.codProducto].stock - p.cantidadDeUnidadesVendidas;
		end
	else
		if(p.cantidadDeUnidadesVendidas >= v[p.codProducto].stock)then	//si la cantidad pedida es mayor o igual al stock
		begin
			p.cantidadDeUnidadesVendidas:= v[p.codProducto].stock;	//lo que habia en stock, va ser lo que se pidio/cantidadVendida // si no tengo el stock q me pide, le tengo q dar todo el stock disponible q tenga
			v[p.codProducto].stock:= 0;	
		end;
end;

procedure agregarAtras(var L,Ult: listaDetalle; p: venta);
var
	nue: listaDetalle;
begin
	new(nue);
	nue^.dato:= p;
	nue^.sig:= nil;
	Writeln('sarasa 6');
	if(L = nil)then
		L:= nue
	else
		Ult^.sig:= nue;
	Ult:= nue;
	Writeln('sarasa 8');
end;

procedure agregarAtras2(var L,Ult: listaTicked; t: ticked);
var
	nue: listaTicked;
begin
	new(nue);
	nue^.dato:= t;
	nue^.sig:= nil;
	if(L = nil)then
		L:= nue
	else
		Ult^.sig:= nue;
	Ult:= nue;
end;

procedure leerVentas(var L: listaTicked; var v: vTabla);
var
	p: venta;
	Ult: listaDetalle;
	Ult2: listaTicked;
	codVentaAux: integer;
	tick: ticked;	//Uso de registro auxliar para acceder a la lista
	i: integer;
begin
	i:= 0;
	// L^.dato.codigoDeVenta:= random(11)-1;	
	Writeln('Codigo de ticked ');
	tick.codigoDeVenta:= random(11)-1;
	While(tick.codigoDeVenta <> -1)do
		begin			
			Writeln('sarasa 2');
			leerProducto(p,v);
			// inicializarListaProductos(L^.dato.detalle);
			inicializarListaProductos(tick.detalle);
			Writeln('sarasa 4');
			While (p.cantidadDeUnidadesVendidas <> 0)do	//mientras no ingrese la cantidad 0 de unidades solicitadas voy a estar pegandole al array (o cant unidades vendidas)
				begin
					validandoStockYasignando(p,v);	
					Writeln('sarasa 5');
					agregarAtras(tick.detalle,Ult,p);	//en este caso me sirve el agregarAtrasNormal
					Writeln('sarasa 8');
					leerProducto(p,v); //vuel a leer otro producto
					wRITELN();wRITELN();
					i:= i+1;
					Writeln('cant Iteraciones DEbug',i);
					wRITELN();wRITELN();
				end;
			//si estoy aca es otro ticked nuevo
			// L^.dato.codigoDeVenta:= tick.codigoDeVenta;
			agregarAtras2(L,Ult2,tick);
			Writeln('Codigo de ticked ');
			tick.codigoDeVenta:= random(11)-1;
		end;
end;

//en listas contenidas en listas rinde, sacarlo a un registro para manejarlo mas facil
function informarCantidad(L: listaTicked; codBuscado: integer): integer;
var
	ListaProductos: listaDetalle;
	contTotal: integer;
begin
	contTotal:= 0;
	While(L <> nil)do
		begin
			ListaProductos:= L^.dato.detalle;
			While(ListaProductos <> nil)do
				begin
					if(ListaProductos^.dato.codProducto = codBuscado)then
						begin
							contTotal:= contTotal + ListaProductos^.dato.cantidadDeUnidadesVendidas;						
						end;
						ListaProductos:= ListaProductos^.sig;
				end;
			L:= L^.sig;
		end;
		informarCantidad:= contTotal;
end;

var
	v: vTabla;
	Ltickeds: listaTicked;
	codProducBuscado: integer;
begin
	randomize;
	cargarVtabla(v); //se dispone
	inicializarLista(Ltickeds);
	leerVentas(Ltickeds,v);	//solo se van a guardar "ventas de cada producto"
	Writeln('sarasa 1');
	{
		Implementar un módulo que reciba la estructura generada en el inciso a) y un código de
producto y retorne la cantidad de unidades vendidas de ese código de producto
	}
	Writeln('Ingrese un codigo de producto para saber la cantidad de unidades vendidas ');
	codProducBuscado:= random(11)+1;
	Writeln('La cantidad total de productos vendidos del codigo: ',codProducBuscado, ' es: ',informarCantidad(Ltickeds,codProducBuscado));
end.




























{Franco version}

{program tres;
type
	tabla=record
		precioUnitario:real;
		stock:integer;
	end;
	Vtabla=array [1..1000] of tabla;
	productos=record
		CodProducto:integer;
		Cantidad:integer;
		PrecioXUnidad:real;
	end;
	ListaProductos=^nodo;
	nodo=record
		elem:productos;
		sig:ListaProductos;
	end;
	Ticket=record
		CodVenta:integer;
		Detalle:ListaProductos;
		MontoTotal:real;
	end;
	ListaTicket=^nodo2;
	nodo2=record
		elem:Ticket;
		sig:ListaTicket;
	end;
procedure leerRegistroProducto(var r:productos);
begin
	readln(r.CodProducto);
	readln(r.Cantidad);
	r.PrecioXUnidad:=0;//Se tiene que leer del arreglo;
end;
procedure InicializarListaProductos(var l:ListaProductos);
begin
	l:=nil;
end;

procedure InicializarListaTicket(var l:ListaTicket);
begin
	l:=nil;
end;

procedure agregarAdelanteProducto (var pI:ListaProductos;elem:Productos);
var
	nue:ListaProductos;
begin
	New(nue);
	nue^.elem:=elem;
	nue^.sig:=pI;
	pI:=nue;
end;
procedure agregarAdelanteTicket (var pI:ListaTicket;elem:Ticket);
var
	nue:ListaTicket;
begin
	New(nue);
	nue^.elem:=elem;
	nue^.sig:=pI;
	pI:=nue;
end;
procedure CargarVentas(var LT:ListaTicket;v:Vtabla);
var
	RP:Productos;
	AuxLT:Ticket;//Esta Variable es necesaria para llenar el elemento que luego se agregara adelante en la ListaTicket
	CodVenta:integer;
	preciofinal:real;
begin
	readln(CodVenta);
	while (CodVenta<>-1) do begin
		AuxLT.CodVenta:=CodVenta;
		leerRegistroProducto(RP);
		InicializarListaProductos(AuxLT.Detalle);//inicializo la Lista de los productos en nill
		preciofinal:=0;
		while (RP.Cantidad > 0) do begin
			RP.PrecioxUnidad:=v[RP.CodProducto].precioUnitario;//lleno el registro de los productos para empezar a hacer la lista de productos
			if RP.Cantidad >= v[RP.CodProducto].stock then begin //Si la cantidad que le pido es mayor o igual al stock directamente le doy todo el stock.
				RP.Cantidad:=v[RP.CodProducto].stock ; //Entonces la Cantidad Vendida es el stock
				v[RP.CodProducto].stock := 0 ;
			end
			else  //Sino significa que le puedo dar la cantidad que se leyo y tengo que reducir el stock.  
				v[RP.CodProducto].stock:=v[RP.CodProducto].stock - RP.Cantidad;  //por ende la Cantidad Vendida es directamente la cantidad que se leyo
			
			preciofinal:=preciofinal + (RP.Cantidad*RP.PrecioXunidad);//contador de montototal para el ticket
			
			agregarAdelanteProducto(AuxLT.Detalle,RP);//Y le mando el registro RP que en este punto el producto ya tendria su Codigo de producto , precio unitario
												 //y cantidad que se vendio teniendo en cuenta si alcanza o no el stock.
			LeerRegistroProducto(RP);
		end;
		AuxLT.MontoTotal:=preciofinal;
		agregarAdelanteTicket(LT,AuxLT);//Le mando a la lista de tickets , un nuevo ticket
		readln(CodVenta);
	end;
end;
procedure RecorrerTikets (pI:ListaTicket;CodProd:integer;var CantVendida:integer);
var
	ListaProducto:ListaProductos;
begin
	while pI<>nil do begin
		ListaProducto:=pI^.elem.Detalle;
		while ListaProducto <> nil do begin
			if ListaProducto^.elem.CodProducto = CodProd then 
				CantVendida:=CantVendida+ListaProducto^.elem.Cantidad;
			ListaProducto:=ListaProducto^.sig;
		end;
		pI:=pI^.sig;
	end;
end;
var
	ListaT:ListaTicket;
	v:Vtabla;
	CodigoDeProducto,CantidadVendida:integer;
begin
	ListaT:=nil;
	//CargarVectorTabla(v);//se dispone
	InicializarListaTicket(ListaT);
	CargarVentas(ListaT,v);
	readln(CodigoDeProducto);
	CantidadVendida:=0;
	RecorrerTikets(ListaT,CodigoDeProducto,CantidadVendida);
	writeln('Se vendio una cantidad de : ',CantidadVendida, ' Del producto con codigo : ',CodigoDeProducto);
end.}

{error durante tiempo de ejecucion, devlp, reestructurar}

// program ejercicio3_2023;

// const
// 	dimFmil = 1000;
// type
// 	rango1000 = 1..dimFmil;
	
// 	tabla = record
// 		precios: real;
// 		stock: integer;
// 	end;
	
// 	vTabla = array[rango1000]of tabla;
	
// 	producto = record  
// 		codigo: integer; //es lo q match con el array
// 		cantUnidadesSolicitadas: integer;  //si me ingresan 0, o me quedo en 0 en la categoria que estoy pidiendo,termino de leer productos
// 	end;

// 	lista = ^nodo;
	
// 	nodo = record
// 		dato: producto;
// 		sig: lista;
// 	end;

// 	venta = record
// 		codVenta: integer;
// 		productosVendidos: lista;
// 	end;


// 	ticked = record	//-1
// 		codVenta : venta;
// 		{codProducto: integer; //supongo q es el cod q matchea con la tabla //campo q no usaria
// 		cant: integer;
// 		precio: real;	//campo q no usaria}
// 		montoTotalVenta: real;
// 	end;
	
// 	lista2 = ^nodo2;
	
// 	nodo2 = record
// 		dato: ticked;
// 		sig: lista2;
// 	end;

// procedure inicializarTickedListas(var L2: lista2);
// begin
// 	L2:= nil;	
// end;

// procedure cargarTabla(var v: vTabla);
// var
// 	i: integer;
// begin
// 	for i:= 1 to dimFmil do
// 		begin
// 			v[i].precios:= random(101);
// 			v[i].stock:= random(31); //
// 		end;
// end;
// {//productos
// procedure leerProducto(produc: lista; var vectorTabla: vTabla);
// var
// begin
// 	produc^.dato.codigo:= random(101); //genera un numero random de 0 a 100 //( CODIGO QUE LE PEGA AL ARRAY );

// 	produc^.dato.cantUnidadesSolicitadas:= random(11); //cantidad de productos q le voy a pedir al array

// 	While(vectorTabla[produc^.dato.codigo].stock > 0 and produc^.dato.cantUnidadesSolicitadas <> 0)do
// 		begin
			
// 		end;

	
	
// 	if(vectorTabla[produc^.dato.codigo].stock > 0)then
// 		begin
// 			produc^.dato.cantUnidadesSolicitadas:= random(11); //cantidad de productos q le voy a pedir al array

// 		end
// 	else
// 		Writeln('Sin stock ');
// 		produc.cantUnidadesSolicitadas:= 0; //saldria de productos

// 	produc.cantUnidadesSolicitadas:= random(11); //cantidad de productos q le voy a pedir al array
// end;}

// procedure agregarAtras(var L1,Ult: lista; p: producto);
// var
// 	nue: lista;
// begin
// 	new(nue);
// 	nue^.dato:= p;
// 	nue^.sig:= nil;
// 	if(L1 = nil)then
// 		L1:= nue
// 	else
// 		Ult^.sig:= nue;
// 	Ult:= nue;
// end;

// //venta Lista
// //esto asume que el stock inicial de todos los campos es  > a 0
// //si introducis una categoria que se acaba de quedar en 0 el stock, tomo que ya no tenes mas productos que leer
// //lo mismo que si me pedis 0 unidades de un producto

// //al ir a un super, vas y llenas productos al carrito, si vas y buscas un producto y lo ultimo que quedaba te lo llevas (stock),
// //no volves a buscar el mismo producto si ya sabes que no tiene stock y si vas se asume que ya no tenias mas productos que querias comprar(Uno no va a buscar algo que sabe que se acaba de acabar)
// //.. Si vas y decis no quiero comprar nada, tu cantidad de unidadesSolicitades va ser 0, ya que no queres comprar nada
// //no quiero comprar nada mas. Vas a la caja y te generan tu ticked de todos los productos
// procedure leerProducto(var productosLista: lista; var vectorTabla: vTabla;var montoTotalDeVenta: real);
// var
// 	Ult: lista;
// begin
	
// 	productosLista^.dato.codigo:= random(100)-1; //genera un numero random de -1 a 100  ( CODIGO Q LE PEGA AL ARRAY )
	
// 	productosLista^.dato.cantUnidadesSolicitadas:= random(11)-1;  //cantidad de productos q le voy a pedir al array
// 	// si tengo stock Y la cantidad de unidades solicitadas sea <> de 0 
// 	While (vectorTabla[productosLista^.dato.codigo].stock <> 0) and (productosLista^.dato.cantUnidadesSolicitadas <> 0) do
// 		begin	
// 			//verifico que tenga suficiente stock
// 			if(vectorTabla[productosLista^.dato.codigo].stock >= productosLista^.dato.cantUnidadesSolicitadas)then
// 				begin
// 					agregarAtras(productosLista,Ult,productosLista^.dato);
// 					//le pego al array, descontando el stock
// 					vectorTabla[productosLista^.dato.codigo].stock:= vectorTabla[productosLista^.dato.codigo].stock - productosLista^.dato.cantUnidadesSolicitadas;
// 					//ya verifique esta compra de producto se va hacer
// 					montoTotalDeVenta:= montoTotalDeVenta + (vectorTabla[productosLista^.dato.codigo].precios * productosLista^.dato.cantUnidadesSolicitadas);
// 					if(vectorTabla[productosLista^.dato.codigo].stock = 0)then
// 						Writeln('Flaquito te acabas de quedar sin stock del producto q me pediste, pedi otros productos o termino con tu compra');
// 				end;
// 			productosLista^.dato.codigo:= random(100)-1; //genera un numero random de -1 a 100  ( CODIGO Q LE PEGA AL ARRAY )
// 			productosLista^.dato.cantUnidadesSolicitadas:= random(11);  //cantidad de productos q le voy a pedir al array
// 		end;
// end;

// // Agrego un nuevo ticked, a mi lista de tickeds
// procedure agregarAdelante(var L2: lista2; tick: ticked);	
// var
// 	nue: lista2;
// begin
// 	new(nue);
// 	nue^.dato:= tick;
// 	nue^.sig:= L2;
// 	L2:= nue;
// end;

// //carga de tickeds
// procedure cargarCompras(var L2: lista2; var vectorTabla: vTabla);
// var
// 	montoTotalDeVenta: real;
// begin
// 	Writeln('FLAG 2');
	
// 	L2^.dato.codVenta.codVenta:= random(20)-1;
// 	Writeln('sarasaaa');
// 	Writeln('FLAG 3');
// 	While(L2^.dato.codVenta.codVenta <> -1)do
// 		begin
// 			Writeln('FLAG 4');
// 			montoTotalDeVenta:= 0; //ticked nuevo, montoTotal nuevo
// 			//le mando una instacia de la lista
// 			L2^.dato.codVenta.productosVendidos:= nil;	//inicializo la Lista de ventas
// 			//le mando la lista ventas
			
// 			leerProducto(L2^.dato.codVenta.productosVendidos,vectorTabla,montoTotalDeVenta);
// 			//si estoy aca, ya lei todas los productos de este ticked, salto al proximo ticked

// 			{L2^.dato.codVenta:= L2^.dato.codVenta; //toy haciendo lo mismo, arriba manejo directamente desde la direccion actual //esta de mas}
// 			{vent.codVenta:= L2^.dato.codVenta.codVenta;	//cargo el codigo que se genero de la venta de todos los productos
// 			vent.productosVendidos:= L2^.dato.codVenta.productosVendidos; //le paso el puntero principal de los productos}
// 			L2^.dato.montoTotalVenta:= montoTotalDeVenta;
// 			agregarAdelante(L2,L2^.dato);
// 			L2^.dato.codVenta.codVenta:= random(20)-1;
// 		end;
// end;

// var
// 	vectorTabla: vTabla;
// 	{L1: lista;	//lista1 = productos = }
// 	L2: lista2;	//lista2 = ticked = 

// begin
// 	randomize;
// 	cargarTabla(vectorTabla); //se dispone
// 	inicializarTickedListas(L2);
// 	cargarCompras(L2, vectorTabla);
// 	Writeln('FLAG 1');
// 	//---------------------------
// 	// L2:= L1^.dato.codVenta;	//aca ya estoy parado en productos
// 	// L2^.dato.cantUnidadesSolicitadas;		//tengo acceso a productos
// end.































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
end.
}