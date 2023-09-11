{11) Un psicólogo necesita un sistema para administrar a sus pacientes. 
* De cada paciente registra: dni, cód. de paciente, obra social (
* 1: ioma 2: pami 3: osde 4: galeno 5: no tiene) y costo abonado por sesión. Implemente un programa que:
a) Genere un ABB ordenado por dni. Para ello, genere información hasta el paciente con dni 0
A partir del ABB, realice módulos (uno por inciso) para:
b) Generar una estructura con dni y cód de paciente de los pacientes de ioma, ordenados por dni descendente
c) Dado un dni, modificar la obra social de dicho paciente a una recibida. Considere que el paciente puede no existir.
NOTA: Realice el programa principal que invoque a los módulos desarrollados.]
}
{
 intro: paciente = dni, codDePaciente, obraSocial(rango5), costoAbonadoPorSesion
	a: nache
	b: no matchea el criterio de orden del arbol, entonces recorro todo el arbol y los q sean ioma(1) los guardo en una lista ordenado de manera descendente
 	c: hago una funcion que busque de manera eficiente en el arbol y me retorne el puntero, si retorna nil no existe y le tiro un mensaje
 }
//0:31 sin testear
//0: 41 testeado
program psicologia;

type
	rango5 = 1..5;

	paciente = record
		dni: integer;
		codPaciente: integer;
		obraSocial: rango5;
		costoAbonadoPorSesion: real;
	end;
	
	arbol = ^nodoArbol;
	
	nodoArbol = record
		dato: paciente;
		hi: arbol;
		hd: arbol;
	end;

	//------------------
	listab = ^nodo;
		
	nodo = record
		dato: paciente;
		sig: listab;
	end;

procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;

procedure leerPaciente(var p: paciente);
begin
	Writeln('dni: (corta con 0)');
	readln(p.dni);
	if(p.dni <> 0)then
		begin
			Writeln('codPaciente: ');
			//readln(p.codPaciente);
			p.codPaciente:= 3;
			Writeln('obra social: ( 1: ioma 2: pami 3: osde 4: galeno 5: no tiene)) ');
			//readln(p.obraSocial);	
			p.obraSocial:= 1;
			Writeln('costoAbonadoPorSesion: ');
			//readln(p.costoAbonadoPorSesion);
			p.costoAbonadoPorSesion:= 5;
		end;
end;

procedure cargarArbol(var a: arbol; p: paciente);	//ordenado por dni
begin
	if(a = nil)then
		begin
			new(a);
			a^.dato:= p;
			a^.hi:= nil; a^.hd:= nil;
		end
	else
		begin
			if(p.dni < a^.dato.dni)then
				cargarArbol(a^.hi,p)
			else
				cargarArbol(a^.hd,p)
		end;
end;

procedure cargarPacientes(var a: arbol);
var p: paciente;
begin
	leerPaciente(p);
	While(p.dni <> 0)do	//corta con dni 0
		begin
			cargarArbol(a,p);
			leerPaciente(p);
		end;
end;

{b) Generar una estructura con dni y cód de paciente de los pacientes de ioma, ordenados por dni descendente
}
{	b: no matchea el criterio de orden del arbol, entonces recorro todo el arbol y los q sean ioma(1) los
  guardo en una lista ordenado de manera descendente
}

procedure insertarOrdenado(var L: listab;p: paciente);
var ant,act, nue: listab;
begin
	new(nue);
	nue^.dato:= p;
	ant:= L;
	act:= L;
	While (act <> nil) and (p.dni < act^.dato.dni)do		//de mayor a menor por dni
		begin
			ant:= act;
			act:= act^.sig;
		end;
	if(act = ant)then
		L:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;


procedure filtroIoma(a: arbol; var L: listab);	//no matchea mi criterio de orden, entoncs recorro todo el arbol
begin
	if(a <> nil)then
		begin
			filtroIoma(a^.hi,L);
			if(a^.dato.obraSocial = 1)then
				insertarOrdenado(L,a^.dato);
			filtroIoma(a^.hd,L);
		end;
end;

{c) Dado un dni, modificar la obra social de dicho paciente a una recibida. Considere que el paciente puede no existir.
}
{ 	c: hago una funcion que busque de manera eficiente en el arbol y me retorne el puntero, si retorna nil no existe y le tiro un mensaje
}

function buscarDni(a: arbol; dniBuscado: integer): arbol;
begin
	if(a = nil)then
		buscarDni:= nil
	else
		begin
			if(a^.dato.dni = dniBuscado)then
				buscarDni:= a
			else
				begin
					if(dniBuscado < a^.dato.dni)then
						buscarDni:= buscarDni(a^.hi,dniBuscado)
					else
						begin
							if(dniBuscado > a^.dato.dni)then
								buscarDni:= buscarDni(a^.hd,dniBuscado);
						end;
				end;
		end;
end;

procedure imprimirInOrden(a: arbol);
begin
	if(a <> nil)then
		begin
			imprimirInOrden(a^.hi);
			Writeln('el dni : sarasa ', a^.dato.dni);
			imprimirInOrden(a^.hd);

		end;
end;

procedure imprimirListaNormal(L:listab );
begin
	if(L <> nil)then
		begin
			Writeln('dni: ',L^.dato.dni);
			imprimirListaNormal(L^.sig);
		end;
end;

var
	a: arbol;
	LpuntoB: listab;
	dniBuscado: integer;
	ubicacionDni: arbol;
	obraActualizada: rango5;
begin
	randomize;
	inicializarPuntero(a);
	cargarPacientes(a);
	//imprimirInOrden(a); testing
	LpuntoB:= nil;// si qda tiempo hacer preoceso
	filtroIoma(a,LpuntoB);
	//Writeln(); Writeln();
	//imprimirListaNormal(LpuntoB);	//testing lista normal
	//
	dniBuscado:= 4540; //hardcodeo ya q no me dice q se ingresa por teclado
	ubicacionDni:= buscarDni(a,dniBuscado);
	if(ubicacionDni <> nil)then
		begin
			Writeln('Ingrese un numero de 1..5 para modificar la obra social del paciente buscado');
			readln(obraActualizada);
			ubicacionDni^.dato.obraSocial:= obraActualizada;
			if(ubicacionDni^.dato.obraSocial = obraActualizada)then
				Writeln('se ha modificado con exito ');
		end
	else
		Writeln('no se encontraba en la estructura ese dni ');
end.

