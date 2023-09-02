{2.- Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la información de los autos en venta.
Implementar un programa que:
a) Genere un árbol binario de búsqueda ordenado por patente identificatoria del auto en venta. Cada nodo del árbol debe contener patente,
* año de fabricación (2010..2018), la marca y el modelo.
b) Invoque a un módulo que reciba el árbol generado en a) y una marca y retorne la cantidad de autos de dicha marca que posee la agencia. Mostrar el resultado. 
c) Invoque a un módulo que reciba el árbol generado en a) y retorne una estructura con la información de los autos agrupados por año de fabricación.
d) Contenga un módulo que reciba el árbol generado en a) y una patente y devuelva el año de fabricación del auto con dicha patente. Mostrar el resultado. }


{
* A: arbol --> criterio de orden Patente ---> dato: ventaRegistro--> 
* B: funcion recursivo --> recorrer todo el arbol --> devolver un entero; chequear todo el arbol para if a^.dato = patente) --> en el program principal imprimo la cantid
* C: recorrer todo el arbol y generar una lista con un insertar Ordenado por anho de fabricacion
* D: funcion, recorrer con criterio y si encuentro la patente  retorno el anho
* }
{debuggin
* lectura
* [patente: 1 : marca: 2 modelo: ]
* A : implementar un modulo in orden y fijarse q las patentes esten de mayor a menor
* B : Ingresar la marca 4| 4 veces  
* C : Imprimir LIsta normal y tienen que imprimirser ordenadado por anho de fabricacion
* D : 
* }

program dsFinal;
const
	iniAnho = 1;
	finAnho = 3267;
type
	//rangoanho19 = 2010..2018;
	
	autoVenta = record
		patente: integer;
		anhoDeFabricacion: integer; //
		//marca: str20;	//1: peugeot 2: etc : 3:etc
		//modelo: str20;	//1: sarasa : 2: rasa: 3: pepe
		marca: integer;	//para debugear mas rapido
		modelo: integer;
	end;
	
	arbol = ^nodo;
		
	nodo = record
		dato: autoVenta;
		hi: arbol;
		hd: arbol;
	end;
		
	LporAnho = ^listaNormal;
		
	listaNormal = record
		dato: autoVenta;
		sig: LporAnho;
	end;

procedure leerVentaAuto(var car: autoVenta);
begin
	Writeln('Ingrese el anho de fabricacion (negativos para corta la impresion)');
	readln(car.anhoDeFabricacion);
	
	if((car.anhoDeFabricacion >= iniAnho) and (car.anhoDeFabricacion <= finAnho))then
		begin
			Writeln('Ingrese la patente ');
			readln(car.patente);
			Writeln('Ingrese la marca del auto en venta');
			readln(car.marca); //solo hay 10 marcas cada numero corresponde a un string
			Writeln('Ingrese el modelo');
			car.modelo:= random(6)+1; //solo hay 5 modelos = string
		end;
end;

procedure cargarArbol(var a: arbol; car: autoVenta);
begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= car;
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(car.patente < a^.dato.patente)then	//no se admiten patentes repetidas
				cargarArbol(a^.hi,car)
			else
				begin
					if(car.patente > a^.dato.patente)then
						cargarArbol(a^.hd,car);
				end;
		end;
end;

procedure cargarVentas(var a: arbol);
var
	car: autoVenta;
begin
	leerVentaAuto(car);
	While(car.anhoDeFabricacion >= iniAnho) and (car.anhoDeFabricacion <= finAnho)do
		begin
			cargarArbol(a,car);
			leerVentaAuto(car);
		end;
end;
{b) Invoque a un módulo que reciba el árbol generado en a) y una marca y retorne la cantidad de autos de dicha marca que posee la agencia. Mostrar el resultado. }

function cantVentasMarca(a: arbol; marcaBuscada,cant: integer): integer;
begin
	if(a = nil)then
		cantVentasMarca:= cant
	else
		begin
			cantVentasMarca:= cantVentasMarca	(a^.hi,marcaBuscada,cant);
			if(a^.dato.marca = marcaBuscada)then
				cant:= cant+1;
			cantVentasMarca:= cantVentasMarca	(a^.hd,marcaBuscada,cant);
		end;
end;

{c) Invoque a un módulo que reciba el árbol generado en a) y retorne una estructura con la información de los autos agrupados por año de fabricación.}
procedure inicializarLista(var L: LporAnho);
begin
	L:= nil
end;

procedure insertarOrdenado(var L: LporAnho; car: autoVenta);
var
	ant,act: LporAnho;
	nue: LporAnho;
begin
	new(nue);
	nue^.dato:= car;
	ant:= L;
	act:= L;
	While(act <> nil ) and (car.anhoDeFabricacion < act^.dato.anhoDeFabricacion)do
		begin
			ant:= act;
			act:= act^.sig;
		end;
	if(ant = act)then
		L:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;

//function informacionOrdenadaPorAnho(a: arbol; L: LporAnho): LporAnho;
//begin
//	if(a = nil)then
//		informacionOrdenadaPorAnho:= L
//	else
//	/	begin
//			informacionOrdenadaPorAnho(a^.hi,L);
//			insertarOrdenado(L,a^.dato);
//			informacionOrdenadaPorAnho(a^.hd,L);
//			informacionOrdenadaPorAnho := L;
//
//		end;
//end;

procedure informacionOrdenadaPorAnho(a: arbol; var L: LporAnho);
begin
	if (a <> nil) then
		begin
			informacionOrdenadaPorAnho(a^.hi, L);
			insertarOrdenado(L,a^.dato);
			informacionOrdenadaPorAnho(a^.hd, L);
		end;
end;


{d) Contenga un módulo que reciba el árbol generado en a) y una patente y devuelva el año de fabricación del auto con dicha patente. Mostrar el resultado. }
//aprovecho el criterio de orden
function buscarPatente(a: arbol;patenteBuscada:integer): integer;

begin
	if(a = nil)then
		buscarPatente:= 0
	else
		begin
			if(a^.dato.patente = patenteBuscada)then
				buscarPatente:= a^.dato.anhoDeFabricacion
			else
				begin
					if(patenteBuscada < a^.dato.patente)then
						buscarPatente:= buscarPatente(a^.hi,patenteBuscada)
					else
						if(patenteBuscada > a^.dato.patente)then
							buscarPatente:= buscarPatente(a^.hd,patenteBuscada)
				end;
		end;
end;

procedure imprimir (registro:autoVenta );
begin
	Writeln('Patente Impriiendo: ',registro.patente);
	Writeln('anhoDeFabricacion Impriiendo: ',registro.anhoDeFabricacion);
	Writeln('Marca Impriiendo: ',registro.marca);
	Writeln('Patente Impriiendo: ',registro.modelo);
	Writeln();
	Writeln('--------------------------------------------------------: ');
end;

procedure imprimirInOrden(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirInOrden(a^.hi);
			imprimir(a^.dato);
			imprimirInOrden(a^.hd);
		end;
end;

procedure imprimiLista(L: LporAnho);
begin
	While(L <> nil)do
		begin
			imprimir(L^.dato);
			L:= L^.sig;
		end;
end;

var
	a: arbol;
	marcaBuscada,cant: integer;
	L: LporAnho;
	patenteBuscada,anhoPatenteBuscado: integer;
begin
	randomize;
	cargarVentas(a);
	imprimirInOrden(a);
	Writeln('Ingrese una marca, para saber la cantidad de autos de esa marca en venta (0--10)');
	readln(marcaBuscada);
	cant:= 0;
	Writeln('La cantidad en venta de esa marca es: ',cantVentasMarca(a,marcaBuscada,cant));
	inicializarLista(L);
	//L:= informacionOrdenadaPorAnho(a,L);
	informacionOrdenadaPorAnho(a,L);
	Writeln('---------------------prom.principal---------------------------');
	imprimiLista(L);
	Writeln('Ingrese la patente a buscar (se va retornar el anho de fabricacion ');
	readln(patenteBuscada);
	anhoPatenteBuscado:= buscarPatente(a,patenteBuscada);
	if(anhoPatenteBuscado <> 0)then
		Writeln('El anho de fabricacion del auto con patente: ',patenteBuscada,' es: ',anhoPatenteBuscado)
	else
		Writeln('No existe esa patente en los registros');
end.

{debuggin
* 
* 
* }










{VARIACION AYRTON}

program p2;
{2.- Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la información de los autos en venta.
Implementar un programa que:
a) Genere un árbol binario de búsqueda ordenado por patente identificatoria del auto en venta. Cada nodo del árbol debe contener patente,
* año de fabricación (2010..2018), la marca y el modelo.
b) Invoque a un módulo que reciba el árbol generado en a) y una marca y retorne la cantidad de autos de dicha marca que posee la agencia. Mostrar el resultado. 
c) Invoque a un módulo que reciba el árbol generado en a) y retorne una estructura con la información de los autos agrupados por año de fabricación.
d) Contenga un módulo que reciba el árbol generado en a) y una patente y devuelva el año de fabricación del auto con dicha patente. Mostrar el resultado. }
Type
	auto = record
		patente:string;
		anio:integer;
		marca:string;
		modelo:string;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:auto;
		HI:arbol;
		HD:arbol;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		dato:auto;
		sig:lista;
	end;
	
	vAnios = array [2010..2018] of lista;
	
procedure crearArbol(var A:arbol);

	procedure leerAuto(var a:auto);
	begin
		writeln('Ingrese patente');
		readln(a.patente);
		if (a.patente <> 'zzz') then
		begin
			writeln('Ingrese anio');
			readln(a.anio);
			writeln('Ingrese marca');
			readln(a.marca);
			//writeln('Ingrese modelo');
			//readln(a.modelo);
		end;
	end;

	procedure cargar(var A:arbol ; dato:auto);		
	begin
		if (A = nil) then
		begin
			new(A);
			A^.dato:= dato;
			A^.HI:= nil;
			A^.HD:= nil;
		end
		else
			if (dato.patente < A^.dato.patente) then
				cargar(A^.HI, dato)
			else
				cargar(A^.HD, dato);
	end;
var
	dato:auto;
begin
	leerAuto(dato);
	while(dato.patente <> 'zzz')do
	begin
		cargar(A, dato);
		leerAuto(dato);
	end;
end;

procedure mostrarArbol(A:arbol);
begin
	if (A <> nil) then
	begin
		writeln(A^.dato.patente);
		writeln(A^.dato.anio);
		writeln(A^.dato.marca);
		//writeln(A^.dato.modelo);
		mostrarArbol(A^.HD);
		mostrarArbol(A^.HI);
	end;
end;

procedure cantidadPorMarca(A:arbol);

	procedure contar(A:arbol ; var cant:integer ; buscado:string);
	begin
		if (A <> nil) then
		begin
			if (A^.dato.marca = buscado) then
				cant:= cant + 1;
			contar(A^.HI, cant, buscado);
			contar(A^.HD, cant, buscado);
		end;
	end;

var
	buscado:string;
	cant:integer;
begin
	writeln('Ingrese marca a contar');
	readln(buscado);
	cant:= 0;
	contar(A, cant, buscado);
	writeln('De la marca ', buscado, ' hay ', cant, ' autos');
end;

procedure iniciarVector(var V:vAnios);
var
	i:integer;
begin
	for i:=2010 to 2018 do
		V[i]:= nil
end;

procedure organizarPorAnio(A:arbol ; var autos:vAnios);

	procedure agregarAdelante(var L:lista ; a:auto);
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.dato:= a;
		nuevo^.sig:= L;
		L:= nuevo;		
	end;

begin
	if (A <> nil) then
	begin
		agregarAdelante(autos[A^.dato.anio], A^.dato);
		organizarPorAnio(A^.HI, autos);
		organizarPorAnio(A^.HD, autos);
	end;
end;

procedure buscarAuto(A:arbol);

	procedure buscar(A:arbol ; buscado:string ; var anio:integer);
	begin
		if (A <> nil) then
			if (A^.dato.patente = buscado) then
				anio:= A^.dato.anio
			else
				if (buscado < A^.dato.patente) then
					buscar(A^.HI, buscado, anio)
				else
					buscar(A^.HD, buscado, anio);
	end;

var
	buscado:string;
	anio:integer;
begin
	anio:= -1;
	writeln('Ingrese patente a buscar');
	readln(buscado);
	buscar(A, buscado, anio);
	if (anio <> -1) then
		writeln('El anio del auto con patente ', buscado, ' es ', anio)
	else
		writeln('El auto buscado no se encuentra');
end;

var 
	A:arbol;
	autos:vAnios;
BEGIN
	A:= nil;
	crearArbol(A);
	//mostrarArbol(A);
	//writeln('- - - - - - - - - -');
	//cantidadPorMarca(A);
	//iniciarVector(autos);
	//organizarPorAnio(A, autos);
	buscarAuto(A);
END.