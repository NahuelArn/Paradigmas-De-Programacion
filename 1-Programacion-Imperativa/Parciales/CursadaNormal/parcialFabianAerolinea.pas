{
1. Una aerolínea dispone de un árbol binario de búsqueda con la información de sus empleados.
*  De cada empleado se conoce: Número de legajo, Dni, Categoría (1..20) y año de ingreso a la empresa. 
* El árbol se encuentra ordenado por número de legajo. Se solicita:
a. Implementar un módulo que reciba el árbol de empleados, número de legajo "A", número de legajo "B" y un número de categoría, 
* y retorne un vector ordenado por número de legajo. El vector debe contener el número de legajo y Dni de aquellos empleados cuyo número 
* de legajo se encuentra comprendido entre los números de legajo recibidos ("A" y "B", siendo "A" menor que "B") y la 
* categoría se corresponda con la recibida por parámetro. Por norma de la empresa, cada categoría puede contar con a lo sumo 250 empleados.
b. Implementar un módulo recursivo que reciba la información generada en "b" y retorne el promedio de los números de Dni.

}

{
1: se dispone de un arbol de empleados --> ordenado por numero de legajo
	empleado = legajo, dni, categoria[1..20] y anhoDeIngreseAlaEmpresa 
a: un proceso q reciba, 2 rangos, izquierda, derecha y un numero de categoria
que recorra de manera eficiente el arbol (entre izquierda y derecha) y si esta dentro del rango y es de la categoria pasada por parametro
voy insertando ordenado en un vector de 1..250, ordenado por LEGAJO, EN TEORIA SI CARGO CON UN AGREGARATRAS, tendria mi vector ya ordenado, solo tegno 
que ir agregando atras,
b: recorre el vector y saco promedio de los dnis
] //0:10
}
//0:40 no testeado

program parcialFabianAerolinea;

type
	rango20 = 1..20;

	empleado = record
		legajo: integer;
		dni: integer;
		categoria: rango20;
		anhoDeIngreso: integer;
	end;
	
	arbol = ^nodoArbol;

	nodoArbol = record
		dato: empleado;
		hi: arbol; hd: arbol;
	end;
	//---------------
	vEmpleados = array[1..250]of empleado;

procedure inicializarArbol(var a: arbol);
begin
	a:= nil;
end;

procedure leerEmpleado(var e: empleado);
begin
	Writeln('legajo: ');
	e.legajo:= random(100)-1;
	Writeln('dni: ');
	e.dni:= random(120);
	Writeln('Ingrese la categoria: ');
	e.categoria:= random(20)+1;
	Writeln('anho de ingreso: ');
	e.anhoDeIngreso:= random(300);
end;

procedure cargarArbol(var a: arbol; e: empleado);
begin
	if(a = nil)then	
		begin
			new(a);
			a^.dato:= e;
			a^.hi:= nil; a^.hd:= nil;
		end
	else
		begin
			if(e.legajo < a^.dato.legajo)then
				cargarArbol(a^.hi,e)
			else
				cargarArbol(a^.hd,e)
		end;
end;

procedure cargarEmpleados(var a: arbol);
var e: empleado;
begin
	leerEmpleado(e);
	While(e.legajo <> -1)do //me invento un criterio de corte ya q se dispone todo esto
		begin
			cargarArbol(a,e);
		end;
end;
{a. Implementar un módulo que reciba el árbol de empleados, número de legajo "A", número de legajo "B" y un número de categoría, 
* y retorne un vector ordenado por número de legajo. El vector debe contener el número de legajo y Dni de aquellos empleados cuyo número 
* de legajo se encuentra comprendido entre los números de legajo recibidos ("A" y "B", siendo "A" menor que "B") y la 
* categoría se corresponda con la recibida por parámetro. Por norma de la empresa, cada categoría puede contar con a lo sumo 250 empleados.]
}

{a: un proceso q reciba, 2 rangos, izquierda, derecha y un numero de categoria
que recorra de manera eficiente el arbol (entre izquierda y derecha) y si esta dentro del rango y es de la categoria pasada por parametro
voy insertando ordenado en un vector de 1..250, ordenado por LEGAJO, EN TEORIA SI CARGO CON UN AGREGARATRAS, tendria mi vector ya ordenado, solo tegno 
que ir agregando atras,}

function cumpleTridente(categoriaActual: rango20;legajoActual,izquierda,derecha,numCategoria: integer): boolean;
begin
	cumpleTridente:= (legajoActual > derecha) and (legajoActual < izquierda) and (categoriaActual = numCategoria);
end;

procedure agregarAlFinalVector(var vE: vEmpleados; var dimL: integer; e: empleado);
begin
	if(dimL <= 250)then
		begin
			dimL:= dimL+1;
			vE[dimL]:= e;
		end;
end;

procedure generarEstuctura(a: arbol;var  vE: vEmpleados; var dimL: integer; izquierda,derecha,numCategoria: integer);

begin
	if(a <> nil)then
		begin
			if(cumpleTridente(a^.dato.categoria,a^.dato.legajo,izquierda, derecha, numCategoria))then
				begin
					generarEstuctura(a^.hi,vE,dimL,izquierda,derecha,numCategoria);
					agregarAlFinalVector(vE,dimL,a^.dato);
					generarEstuctura(a^.hd,vE,dimL,izquierda,derecha,numCategoria);
				end	
			else
				begin
					if(a^.dato.categoria > izquierda)then
						generarEstuctura(a^.hi,vE,dimL,izquierda,derecha,numCategoria)
					else
						begin
							if(a^.dato.categoria < derecha)then
								generarEstuctura(a^.hd,vE,dimL,izquierda,derecha,numCategoria)
						end;
				end;
		end;
end;

{b. Implementar un módulo recursivo que reciba la información generada en "b" y retorne el promedio de los números de Dni.
}
function sumarDnis(v: vEmpleados; dimL: integer): real;
begin
	if(dimL <> 0)then
		sumarDnis:= 0
	else
		begin
			sumarDnis:= sumarDnis(v,dimL-1)+ v[dimL].dni;
		end;
end;

function sacarPromedioDnis(v: vEmpleados; dimL: integer): real;
begin
	sacarPromedioDnis:= sumarDnis(v,dimL) / dimL;
end;

var
	a: arbol;	
	vE: vEmpleados;
	izquierda,derecha, dimL: integer;
	numCategoria: rango20;

begin
	randomize;
	inicializarArbol(a);
	izquierda:= 2;
	derecha:= 20;
	dimL:= 0;
	numCategoria:= 2;
	generarEstuctura(a,vE,dimL,izquierda,derecha,numCategoria);
	Writeln('el promedio es: ',sacarPromedioDnis(vE,dimL));
end.


