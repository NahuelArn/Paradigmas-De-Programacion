{Punto C}

{
  1.- Implementar un programa que procese la información de los alumnos de la Facultad de
Informática.
a) Implementar un módulo que lea y retorne, en una estructura adecuada, la información de
todos los alumnos. De cada alumno se lee su apellido, número de alumno, año de ingreso,
cantidad de materias aprobadas (a lo sumo 36) y nota obtenida (sin contar los aplazos) en cada
una de las materias aprobadas. La lectura finaliza cuando se ingresa el número de alumno
11111, el cual debe procesarse.
b) Implementar un módulo que reciba la estructura generada en el inciso a) y retorne número
de alumno y promedio de cada alumno.

}

{c) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de
materias aprobadas de cada alumno, y si además se desean registrar los aplazos? ¿cómo
puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?}

//se usaria una Lista, porq tenes 36 notas [q cada una puede tener [X aplazos hasta aprobarla]]que entre essas notas (Lista normal)

//si se desea registrar los aplazos, contar toda nota q sea < q 0
//si no se sabe de antemano la cant de materias aprobas necesitasmo manejar una dimL y si ademas se desea registrar los aplazos, contar toda nota q sea < q 0

program ejercicio1_2023;

const
  dimF36 = 36;

type

  listaNotas = ^nodoNotas;

  nodoNotas = record
    dato: integer;
    sig: listaNotas;
  end;

  str20 = string[20];

  alumno = record
    apellido: str20;
    numAlumno: integer;
    anhoIngreso: integer;
    // cantMatAprobadas: integer;
    notas: listaNotas;
  end;
	
  lista = ^nodo;
	
  nodo = record
    dato: alumno;
    sig: lista;
  end;
	
procedure inicializarLista(var L: lista);
begin
  L:= nil;  
end; 
	
procedure agregarAdelante(var L: listaNotas; valor: integer);
var
  nue: listaNotas;
begin
  new(nue);
  nue^.dato:= valor;
  nue^.sig:= L;
  L:= nue;
end;
	
procedure cargarNotas(var notas: listaNotas);
var 
  valor: integer;
begin
  //como no se sabe la cantidad de notas aprobadas,
  notas:= nil;
  Writeln('Ingrese una nota: ');
  valor:= random(11);
  While(valor <> 0)do
    begin
      agregarAdelante(notas,valor);
			Writeln('Ingrese una nota: ');
      valor:= random(11);
    end;
end;

procedure leerAlumno(var a: alumno);
begin
  Writeln('Ingrese el apellido ');
  readln(a.apellido); //ver como generar strings random
  Writeln('Ingrese el numero de alumno: ');
  a.numAlumno:= random(11); //random de 0 a 1111
  Writeln('Ingrese el anho de ingreso ');
  a.anhoIngreso:= random(2024); 
  cargarNotas(a.notas);
end;

procedure agregarAtras(var L,ult: lista; a: alumno);
var
  nue: lista;
begin
  new(nue);
  nue^.dato:= a;
  nue^.sig:= nil;
  if(L = nil)then
    L:= nue
  else
    Ult^.sig:= nue;
  Ult:= nue;
end;


procedure cargarAlumnos(var L: lista);
var
  a: alumno;
  Ult: lista;
begin
  repeat
    leerAlumno(a);
    agregarAtras(L,Ult,a);
  until  (a.numAlumno = 10);  //1111
end;

procedure informarPromediosDeAlumnos(L: lista);
var
	suma,cant: integer;
	auxL: listaNotas;
	eleccion: integer;
begin
	Writeln('1: para informar promedio con aplazos(nota < 4)');
	Writeln('2: para informar promedio sin aplazos(nota >= 4)');
	eleccion:= random(3)+1;
			While(L <> nil)do
				begin
					suma:= 0;
					cant:= 0;
					auxL:= L^.dato.notas;
					While(auxL <> nil) do
						begin
							if(eleccion = 1)then
								begin
									suma:= suma + auxL^.dato;
									cant:= cant+1;
								end
							else
								begin
									if(auxL^.dato >= 4)then
										begin
											suma:= suma + auxL^.dato;
											cant:= cant+1;
										end;
								end;
							auxL:= auxL^.sig;
						end;
						Writeln('El promedio del alumno: ',L^.dato.apellido,' es: ',suma/cant:2:2);
						L:= L^.sig;
				end
end;
	
var 
  L: lista;
begin
  randomize;
  inicializarLista(L);
  cargarAlumnos(L);
  // procesarData(L);
  Writeln();
  {Implementar un módulo que reciba la estructura generada en el inciso a) y retorne número
de alumno y promedio de cada alumno.}
	informarPromediosDeAlumnos(L);
end.
