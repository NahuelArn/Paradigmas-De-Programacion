{Escribir un programa que: 
a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee 
código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de 
producto 0. Un producto puede estar en más de una venta. Se pide: 
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de 
producto. 
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por 
código de producto. Cada nodo del árbol debe contener el código de producto y la 
cantidad total vendida. 
               Nota: El módulo debe retornar los dos árboles. 

b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne 
la cantidad total de unidades vendidas de ese producto. 
c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne 
la cantidad total de unidades vendidas de ese producto.
}

program ejercicio2;

type

	rango31 = 1..31;
	
  venta = record
    codProducto: integer;
    diaVenta: rango31;
    fecha: integer; // no creo anho/dia/mes etc etc por q despues no lo uso, vamos a tomarlo solo como dia
    cantVendida: integer;
  end;

  arbolVenta = ^nodoVenta;	//hay varias ventas, con el mismo cod

  nodoVenta = record
    dato: venta;
    hi: arbolVenta;
    hd: arbolVenta;
  end;

  ventaMismoCod = record
    codProducto: integer;
    cantVendida: integer;
  end;

  arbolMismoCod = ^nodoMismoCod;  //ordeno por cada codigo, la cantidad vendida total de ese cod

  nodoMismoCod = record
		dato: ventaMismoCod;
		hi: arbolMismoCod;
		hd: arbolMismoCod;
	end;
	
procedure inicializarArboles(var L0: arbolVenta; var L1: arbolMismoCod);
begin
	L0:= nil;
	L1:= nil;
end;

procedure leerVenta(var v: venta);
begin
	Writeln('Ingrese el codigo de producto: ');
	v.codProducto:= random(11);
	Writeln('Ingrese el dia de la venta del producto: ');
	v.diaVenta:= random(32)+1;
	Writeln('Ingrese la cantidad vendida');
	v.cantVendida:= random(11);
end;

procedure cargarArbol0(var a0: arbolVenta; vent: venta);
begin
	if(a0 = nil)then
		begin
			new(a0);
			a0^.dato:= vent;
			a0^.hi:= nil;
			a0^.hd:= nil;
		end
	else
		begin
			if(vent.codProducto < a0^.dato.codProducto)then	//se permiten repetido y los voy tirando a la derecha
				cargarArbol0(a0^.hi,vent)
			else
				cargarArbol0(a0^.hd,vent);
		end;
end;

procedure cargarArbol1(var a1: arbolMismoCod; ventMisCod: ventaMismoCod);
begin
	if(a1 = nil)then
		begin
			new(a1);
			a1^.dato:= ventMisCod;
			a1^.hi:= nil;
			a1^.hd:= nil;
		end
	else
		begin
			if(ventMisCod.codProducto = a1^.dato.codProducto)then	//si estas aca ya tiene un X en la cantidadVendidaTotal
				a1^.dato.cantVendida := a1^.dato.cantVendida + ventMisCod.cantVendida
			else
				begin
					if(ventMisCod.codProducto < a1^.dato.codProducto)then
						cargarArbol1(a1^.hi,ventMisCod)
					else
						cargarArbol1(a1^.hd,ventMisCod);
				end;
		end;
end;

procedure leerVentas(var a0: arbolVenta; var a1: arbolMismoCod);
var
	vent: venta;
	ventMisCod: ventaMismoCod;
begin
	leerVenta(vent);
	While(vent.codProducto <> 0)do
		begin
			cargarArbol0(a0,vent);
			ventMisCod.codProducto:= vent.codProducto;
			ventMisCod.cantVendida:= vent.cantVendida;
			cargarArbol1(a1,ventMisCod);
			leerVenta(vent);
		end;
end;

{b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne 
la cantidad total de unidades vendidas de ese producto. 
c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne 
la cantidad total de unidades vendidas de ese producto.
* i: tengo q buscar primero el codigo y despues recorrer sus ocurrencias, para sacar la cantTotal
* ii: tengo que buscar en el arbol y si lo encuentro al codigo retorno su cantTotal
* }

procedure informarCantUniVendidas(a0: arbolVenta; codBuscado: integer; var cantVendida0: integer);
begin
	if(a0 <> nil)then
		begin
			if(a0^.dato.codProducto = codBuscado)then
        begin
          cantVendida0:= cantVendida0 + a0^.dato.cantVendida;
          Writeln('SARASAAAAAA',cantVendida0);
        end
			else
				begin
					if(codBuscado < a0^.dato.codProducto)then
						informarCantUniVendidas(a0^.hi,codBuscado,cantVendida0)
					else
						informarCantUniVendidas(a0^.hd,codBuscado,cantVendida0);
				end;
		end;
end;

procedure informarCantUniVendidaSinOcurrencias(a1: arbolMismoCod;codBuscado1: integer;var cantVendida1: integer);
begin
	if(a1 <> nil) and (cantVendida1 = 0){(a^.dato.codProducto <> codBuscado)}then
		begin
			
			if(a1^.dato.codProducto = codBuscado1)then
				cantVendida1:=  a1^.dato.cantVendida
			else
				begin
					if(codBuscado1 < a1^.dato.codProducto) then
						informarCantUniVendidaSinOcurrencias(a1,codBuscado1,cantVendida1)
					else
						informarCantUniVendidaSinOcurrencias(a1,codBuscado1,cantVendida1);
				end;
		end;
end;

var
	a0: arbolVenta;
	a1: arbolMismoCod;
	codBuscado0,cantVendida0: integer;
  cantVendida1: integer;
begin	
  randomize;
	inicializarArboles(a0,a1);
	leerVentas(a0,a1);
	Writeln('Ingrese un codigo buscado');
	codBuscado0:= random(11);
  cantVendida0:= 0;
	informarCantUniVendidas(a0,codBuscado0,cantVendida0);
	Writeln('La cantidad vendida es: ',cantVendida0, ' usando el arbol con varias ocurrencias');
	// reutilizo las variable codBuscado
  cantVendida1:= 0;
  informarCantUniVendidaSinOcurrencias(a1,codBuscado0,cantVendida1);
  Writeln('La cantidad vendida es: ',cantVendida1, ' usando el arbol sin ocurrencias');
end.
