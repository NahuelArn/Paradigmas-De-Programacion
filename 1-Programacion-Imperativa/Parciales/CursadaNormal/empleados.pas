
{IMPORTANTE: Cree un programa en Pascal. Utilice su apellido como nombre del programa y del archivo .pas, y guardelo en el
*  Escritorio de su computadora.
Una empresa desea procesar la información de las horas trabajadas por sus empleados durante 2021. 
* Para ello, la empresa posee registros de las horas trabajadas por cada empleado. 
* Cada registro consta del número de empleado, dia, mes y la cantidad de horas trabajadas (a lo sumo 8) para dicho día y mes.
a) Realizar un módulo que lea la información de los empleados y retorne estructura de datos con todos los registros leidos.
*  La estructura debe ser eficiente para la búsqueda por número de empleado. La lectura finaliza al ingresar un registro con día 0. 
* Se sugiere utilizar el módulo leerRegistro ().
b) Realizar un módulo que reciba la estructura generada en a) y dos números de empleados X e Y, y retorne todos los registros 
* de horas trabajadas por empleados cuyos números estén entre X e Y (incluidos).
c) Realizar un módulo recursivo que reciba la estructura generada en b) y retorne la cantidad total de horas trabajadas.
NOTA: Implementar el programa principal, que invoque a los incisos a, by c.}
{
* Intro:
* 	registro empleado = numEmpleado, con un campo vector de listas --> cada pos corresponde a un mes --> con un vector de 1 a 12 y otro vector de 1 31
* a: arbol = empleado, busqueda eficiente por numero de empleado ---> la lectura finaliza con el dia 0;
* b: buscar entre rangos y retorno todo su registro empleado en una lista
* c: sumar todos las horas trabajasdas de la nueva lista con todos lo empleados q estaban entre rangos
* }
//0:10
//0:48 sin testear
program empleados;

type
	rango12 = 1..12;
	rango31 = 0..31;
	empleado = record
		numEmpleado: integer;
		mes: rango12;
		dia: rango31;
		cantHoras: real;
	end;
	
	arbol = ^nodoArbol;

	nodoArbol = record
		dato: empleado;
		hi: arbol; hd: arbol;
	end;
	//----
	lista = ^nodo;

	nodo = record
		dato: empleado;
		sig: lista;
	end;

procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;

procedure leerEmpleado(var e: empleado);
begin
	Writeln('Ingrese un dia: (dia 0 para cortar) ');
		readln(e.dia);
	if(e.dia <> 0)then
		begin
			Writeln('Num Empleado: ');
			readln(e.numEmpleado);
			Writeln('Ingrese el mes: ');
			//readln(e.mes);
			e.mes:= 1;
			Writeln('Ingrese la cant de horas trabajadas: (minimo 8 )');
			readln(e.cantHoras);
		end;
end;

procedure cargarArbol(var a: arbol; e: empleado);

begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= e;
			a^.hi:= nil ; a^.hd:= nil;
		end
	else
		begin
			if(e.numEmpleado <= a^.dato.numEmpleado)then
				cargarArbol(a^.hi,e)
			else
				cargarArbol(a^.hd,e)
		end;
end;

procedure cargarDatos(var a: arbol);
var e: empleado;
begin
	leerEmpleado(e);
	While(e.dia <> 0)do
		begin
			if(e.cantHoras >= 8)then
				cargarArbol(a,e);
			leerEmpleado(e);
		end;
end;
{b) Realizar un módulo que reciba la estructura generada en a) y dos números de empleados X e Y, y retorne todos los registros 
* de horas trabajadas por empleados cuyos números estén entre X e Y (incluidos).}
procedure inicializarLista(var LpuntoB: lista);
begin
	LpuntoB:= nil;
end;

procedure agregarAdelante(var L: lista; e: empleado);
var nue: lista;
begin
	new(nue);
	nue^.dato:= e;
	nue^.sig:= L;
	L:= nue;
end;

procedure generarEstructuraEntreRangos(a: arbol; izquierda,derecha: integer;var L: lista);
begin
	if(a <> nil)then
		begin
			if(a^.dato.numEmpleado >= izquierda) and(a^.dato.numEmpleado <= derecha)then
				begin
					generarEstructuraEntreRangos(a^.hi,izquierda,derecha,L);
					agregarAdelante(L,a^.dato);
					generarEstructuraEntreRangos(a^.hd,izquierda,derecha,L);
				end
			else
				if(a^.dato.numEmpleado > izquierda)then
					generarEstructuraEntreRangos(a^.hi,izquierda,derecha,L)
				else
					begin
						if(a^.dato.numEmpleado < derecha)then
							generarEstructuraEntreRangos(a^.hd,izquierda,derecha,L)
					end;
		end;
end;

{c) Realizar un módulo recursivo que reciba la estructura generada en b) y retorne la cantidad total de horas trabajadas.
NOTA: Implementar el programa principal, que invoque a los incisos a, by c.}
{* c: sumar todos las horas trabajasdas de la nueva lista con todos lo empleados q estaban entre rangos
}

function cantTotalDeHorasTrabajadas(LpuntoB: lista): real;
begin
	if(LpuntoB = nil)then
		cantTotalDeHorasTrabajadas:= 0
	else
		begin
			cantTotalDeHorasTrabajadas:= cantTotalDeHorasTrabajadas(LpuntoB^.sig)+ LpuntoB^.dato.cantHoras;
		end;
end;
//-----------
procedure imprimirArbol(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirArbol(a^.hi);
			Writeln('num empleado: ',a^.dato.numEmpleado);
			imprimirArbol(a^.hd);
		end;
end;
procedure imprimir(L: lista);
begin
	if(L <> nil)then
		begin
			Writeln('hora : ',L^.dato.cantHoras);
			imprimir(L^.sig);
		end;
end;
var
	a: arbol;
	izquierda,derecha: integer;
	LpuntoB: lista;
begin
	randomize;
	inicializarPuntero(a);
	cargarDatos(a);
	imprimirArbol(a);
	Writeln('Ingrese izquierda ');
	izquierda:= 6;
	Writeln('Ingrese derecha ');
	derecha:= 20;
	inicializarLista(LpuntoB);
	generarEstructuraEntreRangos(a,izquierda,derecha,LpuntoB);
	imprimir(LpuntoB);
	Writeln('la cant total de horas trabajadas por todos los trabajadores es: ',cantTotalDeHorasTrabajadas(LpuntoB):2:2);
end.










// {IMPORTANTE: Cree un programa en Pascal. Utilice su apellido como nombre del programa y del archivo .pas, y guardelo en el
// *  Escritorio de su computadora.
// Una empresa desea procesar la información de las horas trabajadas por sus empleados durante 2021. 
// * Para ello, la empresa posee registros de las horas trabajadas por cada empleado. 
// * Cada registro consta del número de empleado, dia, mes y la cantidad de horas trabajadas (a lo sumo 8) para dicho día y mes.
// a) Realizar un módulo que lea la información de los empleados y retorne estructura de datos con todos los registros leidos.
// *  La estructura debe ser eficiente para la búsqueda por número de empleado. La lectura finaliza al ingresar un registro con día 0. 
// * Se sugiere utilizar el módulo leerRegistro ().
// b) Realizar un módulo que reciba la estructura generada en a) y dos números de empleados X e Y, y retorne todos los registros 
// * de horas trabajadas por empleados cuyos números estén entre X e Y (incluidos).
// c) Realizar un módulo recursivo que reciba la estructura generada en b) y retorne la cantidad total de horas trabajadas.
// NOTA: Implementar el programa principal, que invoque a los incisos a, by c.}
// {
// * Intro:
// * 	registro empleado = numEmpleado, con un campo vector de listas --> cada pos corresponde a un mes --> con un vector de 1 a 12 y otro vector de 1 31
// * a: arbol = empleado, busqueda eficiente por numero de empleado ---> la lectura finaliza con el dia 0;
// * b: buscar entre rangos y retorno todo su registro empleado en una lista
// * c: sumar todos las horas trabajasdas de la nueva lista con todos lo empleados q estaban entre rangos
// * }
// //0:10
// program sarasa;

// type
// 	vDias = array[1..31]of real;

// 	vMeses = array[1..12]of vDias;

// 	empleado = record
// 		numEmpleado: integer;
// 		fecha: vMeses;
// 	end;
	
// 	arbol = ^nodoArbol;

// 	nodoArbol = record
// 		dato: empleado;
// 		hi: arbol; hd: arbol;
// 	end;

// procedure inicializarPuntero(var a: arbol);
// begin
// 	a:= nil;
// end;

// procedure cargarDia(var vD: vDias);
// var dia: integer; horas: real;
// begin
// 	Writeln('Ingrese un dia: ');
// 	readln(dia);
// 	Writeln('Ingrese la cant de horas trabajadas: (minimo 8 )');
// 	readln(horas);
// 	vD[dia]:= horas;
// end;

// procedure cargarMeses(var vM: vMeses);
// var  mes: integer;
// begin
// 	Writeln('Ingrese el mes: ');
// 	readln(mes)
// 	cargarDia(vM[mes]);
// end;

// procedure leerEmpleado(var e: empleado);
// begin
// 	Writeln('Num Empleado: ');
// 	readln(e.empleado);
// 	if(e.empleado <> 0)then
// 		begin
// 			cargarMeses(e.fecha);
// 		end;
// end;

// procedure cargarDatos(var a: arbol);
// var e: empleado;
// begin
// 	leerEmpleado(e);
// 	While(e.[])do
// end;

// var
// 	a: arbol;
// begin
// 	inicializarPuntero(a);
// end.

