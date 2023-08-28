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
c) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de
materias aprobadas de cada alumno, y si además se desean registrar los aplazos? ¿cómo
puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?
}

//Programa sin la parte C, mas abajo esta con el criterio que plantea el punto C
program ejercicio1_2023;

const
  dimF36 = 36;

type

  vNotas = array[1..dimF36]of integer;
  str20 = string[20];

  alumno = record
    apellido: str20;
    numAlumno: integer;
    anhoIngreso: integer;
    cantMatAprobadas: integer;
    notas: vNotas;
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

procedure leerDataAlumno(var a: alumno);
begin
  Writeln('Ingrese el apellido ');
  readln(a.apellido); //ver como generar strings random
  Writeln('Ingrese el numero de alumno: ');
  a.numAlumno:= random(1112); //random de 0 a 1111
  Writeln('Ingrese el anho de ingreso ');
  a.anhoIngreso:= random(2024); 
  Writeln('Ingrese la cantidad de materias aprobadas ');
  a.cantMatAprobadas:= random(37); //0..36
end;

procedure cargarNotas(var v: vNotas; dimL: integer);
var 
  i: integer;
begin
  for i:= 1 to dimL do
    begin
      Writeln('Ingrese la nota ',i);
      readln(v[i]);
    end;
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

procedure leerAlumno(var a: alumno);
begin
  leerDataAlumno(a);
  cargarNotas(a.notas,a.cantMatAprobadas);
end;

procedure cargarAlumnos(var L: lista);
var
  a: alumno;
  Ult: lista;
begin
  repeat
    leerAlumno(a);
    agregarAtras(L,Ult,a);
  until  (a.numAlumno = 1111); 
end;

function promedio(cant: integer; vector: vNotas): real;  //puede tener 0 materias aprobadas, caso de error
var 
  i: integer;
  suma: integer;
begin
  suma:= 0;
  for i:= 1 to cant do
    begin
      suma:= suma + vector[i];
    end;
  promedio:= suma/cant;
end;

procedure procesarData(L: lista);
begin
  While(L <> nil)do
    begin
      Writeln('Numero de alumno: ',L^.dato.numAlumno);
      Writeln('Promedio del alumno: ',promedio(L^.dato.cantMatAprobadas,L^.dato.notas));
      L:= L^.sig;
    end;
end;

var 
  L: lista;
begin
  randomize;
  inicializarLista(L);
  cargarAlumnos(L);
  {b) Implementar un módulo que reciba la estructura generada en el inciso a) y retorne número
    de alumno y promedio de cada alumno.}
    //el retorne lo interpreto como que imprima, en este caso, ya que no puedo retonar cada data al program principal, puedo retonar una lista nueva con esos datos
    //pero no creo q me pida eso
  procesarData(L);

  {c) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de
materias aprobadas de cada alumno, y si además se desean registrar los aplazos? ¿cómo
puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?}

end.



{Punto C}
{c) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de
materias aprobadas de cada alumno, y si además se desean registrar los aplazos? ¿cómo
puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?}
//si se desea registrar los aplazos, contar toda nota q sea < q 0
//si no se sabe de antemano la cant de materias aprobas necesitasmo manejar una dimL y si ademas se desea registrar los aplazos, contar toda nota q sea < q 0

program ejercicio1_2023;

const
  dimF36 = 36;

type

  vNotas = array[1..dimF36]of integer;
  str20 = string[20];

  alumno = record
    apellido: str20;
    numAlumno: integer;
    anhoIngreso: integer;
    cantMatAprobadas: integer;
    notas: vNotas;
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

procedure leerDataAlumno(var a: alumno);
begin
  Writeln('Ingrese el apellido ');
  readln(a.apellido); //ver como generar strings random
  Writeln('Ingrese el numero de alumno: ');
  a.numAlumno:= random(1112); //random de 0 a 1111
  Writeln('Ingrese el anho de ingreso ');
  a.anhoIngreso:= random(2024); 
   //este campo se elimininaria
  // Writeln('Ingrese la cantidad de materias aprobadas ');
  // a.cantMatAprobadas:= random(37); //0..36
end;

//recibimos una dimL a cargarse
procedure cargarNotas(var v: vNotas);
var 
  i: integer;
begin
  //como no se sabe la cantidad de notas aprobadas, entre la 1 a 36 van a estar los aprobados y aplazos
  for i:= 1 to dimF36 do
    begin
      Writeln('Ingrese la nota ',i);
      readln(v[i]);
    end;
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

procedure leerAlumno(var a: alumno);
begin
  leerDataAlumno(a);
  cargarNotas(a.notas);
end;

procedure cargarAlumnos(var L: lista);
var
  a: alumno;
  Ult: lista;
begin
  repeat
    leerAlumno(a);
    agregarAtras(L,Ult,a);
  until  (a.numAlumno = 1111); 
end;

function promedio(cant: integer; vector: vNotas): real;  //puede tener 0 materias aprobadas, caso de error
var 
  i: integer;
  suma: integer;
begin
  suma:= 0;
  for i:= 1 to cant do
    begin
      suma:= suma + vector[i];
    end;
  promedio:= suma/cant;
end;

procedure procesarData(L: lista);
begin
  While(L <> nil)do
    begin
      Writeln('Numero de alumno: ',L^.dato.numAlumno);
      Writeln('Promedio del alumno: ',promedio(L^.dato.cantMatAprobadas,L^.dato.notas));
      L:= L^.sig;
    end;
end;

var 
  L: lista;
begin
  randomize;
  inicializarLista(L);
  cargarAlumnos(L);
  procesarData(L);
end;