 {
 * Implementar un programa que contenga: 
a. Un módulo que lea información de alumnos de Taller de Programación y almacene en una 
estructura de datos sólo a aquellos alumnos que posean año de ingreso posterior al 2010. De 
cada  alumno  se  lee  legajo,  DNI  y  año  de  ingreso.  La  estructura  generada  debe  ser  eficiente 
para la búsqueda por número de legajo.  
b.  Un  módulo  que  reciba  la  estructura  generada  en  a.  e  informe  el  DNI  y  año  de  ingreso  de 
aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.  
c.  Un  módulo  que  reciba  la  estructura  generada  en  a.  e  informe  el  DNI  y  año  de  ingreso  de 
aquellos  alumnos  cuyo  legajo  esté  comprendido  entre  dos  valores  que  se  reciben  como 
parámetro.  
d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande. 
e.  Un  módulo  que  reciba  la  estructura  generada  en  a.  y  retorne  la  cantidad  de  alumnos  con 
legajo impar. 
}

program ejercicio3;
type
	alumno = record
		legajo: integer;
		dni: integer;
		anhoIngreso: integer;
	end;
	
	arbol = ^nubeAlumnos;
	
	nubeAlumnos = record
		dato: alumno;
		hi: arbol;
		hd: arbol;
	end;
	
procedure inicializarArbol(var a: arbol);
begin
	a:= nil;
end;

procedure leerAlumno(var alu: alumno);
begin
	Writeln('Ingrese el legajo del alumno: ');
	readln(alu.legajo);
	if(alu.legajo <> -1)then
		begin
			Writeln('Ingrese el dni del alumno: ');
			alu.dni:= random(101);
			Writeln('Ingrese el anho de ingreso del alumno: ');
			readln(alu.anhoIngreso);
		end;
end;

procedure cargarArbol(var a: arbol;alu: alumno);
begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= alu;
			a^.hi:= nil;
			a^.hd:= nil;
		end
	else
		begin
			if(alu.legajo <= a^.dato.legajo)then
				cargarArbol(a^.hi,alu)
			else
				cargarArbol(a^.hd,alu);
		end;
end;

procedure imprimir(a: alumno); //registro
begin
	Writeln('--------');
	Writeln('El dni: ',a.dni,' cumple el filtro');
	Writeln('legajo: ',a.legajo);
	Writeln('con el anho: ',a.anhoIngreso,' de ingreso');
	Writeln('--------');
end;
{b.  Un  módulo  que  reciba  la  estructura  generada  en  a.  e  informe  el  DNI  y  año  de  ingreso  de 
aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.}
//aprovechamos el criterio de orden 
procedure informarLegajosConFiltro(a: arbol; legajoCorte: integer);
begin
	if(a <> nil)then
		begin
			if(a^.dato.legajo < legajoCorte)then
				imprimir(a^.dato);
			if( legajoCorte > a^.dato.legajo)then
				informarLegajosConFiltro(a^.hi,legajoCorte)
			else
				informarLegajosConFiltro(a^.hd,legajoCorte);
		end;
end;
{c.  Un  módulo  que  reciba  la  estructura  generada  en  a.  e  informe  el  DNI  y  año  de  ingreso  de 
aquellos  alumnos  cuyo  legajo  esté  comprendido  entre  dos  valores  que  se  reciben  como 
parámetro. }

procedure entreValores(a: arbol; izquierda,derecha: integer);
begin
	if(a <> nil)then
		begin
			if(a^.dato.legajo > izquierda) and (a^.dato.legajo < derecha)then
				begin
					imprimir(a^.dato);
					entreValores(a^.hi,izquierda,derecha);
					entreValores(a^.hd,izquierda,derecha);
				end
			else
				begin
					if(a^.dato.legajo > izquierda)then	//si el elemento actual es > que mi limite inferior, me achico
						entreValores(a^.hi,izquierda,derecha)
					else
						if(a^.dato.legajo < derecha)then
							entreValores(a^.hd,izquierda,derecha)		
				end;
		end;
end;
{d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.}
//retornar dni y esta ordenado por legajo, voy a tener q recorrer todo el arbol
function	dniMax(a: arbol;max: integer): integer;	//max es pasado desde el prog.principal con -9999;
begin
	if(a = nil)then
		dniMax:= max
	else
		begin
			if(a^.dato. dni > max)then
				max:= a^.dato.dni;
			dniMax:= dniMax(a^.hi,max);
			dniMax:= dniMax(a^.hd,max);
		end;
end;

{e.  Un  módulo  que  reciba  la  estructura  generada  en  a.  y  retorne  la  cantidad  de  alumnos  con 
legajo impar. }
function cantAlumnosLegajoImpar(a: arbol; cantImp: integer): integer;	//cantImp es pasado desde el prog.principal con 0;
begin
	if(a = nil)then
		cantAlumnosLegajoImpar:= cantImp
	else
		begin
			if(a^.dato.legajo mod 2 <> 0)then
				cantImp:= cantImp + 1;
			cantAlumnosLegajoImpar:= cantAlumnosLegajoImpar	(a^.hi,cantImp);
			cantAlumnosLegajoImpar:= cantAlumnosLegajoImpar	(a^.hd,cantImp);
		end;
end;

procedure imprimirInOrder(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirInOrder(a^.hi);
			imprimir(a^.dato); 
			imprimirInOrder(a^.hd);
		end;
end;

var
	a: arbol;
	alu: alumno;
	legajoPorDebajo: integer;
	izquierda,derecha: integer;
	maxDni: integer;
	cantImp: integer;
begin
	inicializarArbol(a);
	leerAlumno(alu);
	//no me da condicion de corte, entonces me invento una
	While(alu.legajo <> -1)do
		begin
			if(alu.anhoIngreso > 2010)then
				cargarArbol(a,alu);
			leerAlumno(alu);
		end;
	//
	Writeln('Ingresa un legajo, de ese legajo todos los legajos menores se va mostrar la data del alumno');
	readln(legajoPorDebajo);
	informarLegajosConFiltro(a,legajoPorDebajo);
	//
	Writeln();Writeln();
	Writeln('En el program principal');
	Writeln();Writeln();
	Writeln('-----------------------------impresionArbolInOrden------------------');
	imprimirInOrder(a);
	Writeln('--------------------------------------------------------------------');
	//
	Writeln('valor izquierda');
	readln(izquierda);
	Writeln('valor derecha');
	readln(derecha);
	entreValores(a,izquierda,derecha);
	maxDni:= -9999;
	Writeln('El dni Maximo en el arbol es: ',dniMax(a,maxDni));
	//
	cantImp:= 0;
	Writeln('La cantidad de alumnos con legajo impar es: ',cantAlumnosLegajoImpar(a,cantImp));
end.
