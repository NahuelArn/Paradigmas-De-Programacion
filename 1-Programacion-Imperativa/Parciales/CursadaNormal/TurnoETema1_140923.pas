{
La Facultad de Informática desea procesar la información de los finales rendidos por sus alumnos. De cada alumno se conoce el número de alumno (entre 1 y 7000), el código de materia (entre 300 y 356) y nota de finales (entre 0 y 10).  
a) Realizar un módulo que lea la información de los finales y retorne una estructura de datos agrupada por número de alumno con todas las notas 
  de los finales rendidos por cada uno de los alumnos. La lectura finaliza con el número de alumno 0. Se sugiere utilizar el módulo leerRegistro ().
b) Realizar un módulo recursivo que reciba la estructura generada en el inciso a), y retorne una nueva estructura
  que contenga el promedio de cada alumno.
c) Realizar un módulo que reciba la estructura generada en Inciso b) y retorne la misma estructura con la Información ordenada por promedio.}

{
  //Si lo hag asi no estoy usando ninguna de Las estructuras q se evaluan?
  a: vector[1..7000] - finaliza con numAlumno 0 - agrupadas por numero de alumno[1..7000]
  b: vector de [1..700] - reales,  only promedio y codAlumno (recursivo)
  c: aplicar un metodo de ordenacion al vector nuevo
}
{opciones
a: arbol de listas? 
b: lo mismo
c: lo mismo
CON El punto C, se me hace q es full vectores
}

{

  a: arbol de listas
  b: lista;

}
program TurnoETema1_140923;

type
  rango7000 = 0..7000; //0 para q corte;
  rango57 = 1..57; //cod materia + 100 y me da el cod verdero
  rango10 = 0..10; //nota de final;
  
  alumno = record
    numAlumno: rango7000;
    codMateria: rango57;
    notaFinal: rango10;
  end;

  lista = ^nodo;

  nodo = record 
    dato: alumno;
    sig: lista;
  end;

  vAlumnos = array[1..7000]of lista;
  //-----------------------------------

  vPromedio = array[1..7000]of real;

procedure inicializarLista(var L: lista);
begin
  L:= nil;  
end;

procedure inicializarVectorAlumnos(var v: vAlumnos);
var
  i: integer;
begin
  for i:= 1 to 7000 do
    v[i]:= nil;
end;

procedure leerAlumno(var a: alumno);
begin
  Writeln('numAlumno: ');
  readln(a.numAlumno);
  Writeln('codMateria: ');
  a.codMateria:= random(58)+1;  
  Writeln('Nota obtenida: ');
  a.numAlumno:= random(11);
end;

procedure agregarAtras(var L: lista; a: alumno);
var
  ant,act: lista;
  nue: lista;
begin
  new(nue);
  nue^.dato:= a;
  ant:= L;
  act:= L;
  while (act <> nil) do
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

procedure cargarFinales(var vAlu: vAlumnos);
var
  a: alumno;
begin
  leerAlumno(a);
  While(a.numAlumno <> 0)do
    begin
      agregarAtras(vAlu[a.numAlumno],a);
      leerAlumno(a);
    end;
end;

procedure inicializarVpromedio(var v2: vPromedio);
var
  i: integer;
begin
  for i:= 1 to 7000 do
    V2[i]:= 0;
end;

function sacarPromedio(L: lista; suma,cant: integer): real;
begin
  if(L = nil)then
    sacarPromedio:= suma/cant
  else
    begin
      suma:= suma + L^.dato.notaFinal;
      cant:= cant+1;
      sacarPromedio:= sacarPromedio(L^.sig,suma,cant);
    end;
end;

procedure puntoB(v1: vAlumnos; var v2: vPromedio; i: integer);
var 
  suma: integer;
  cant: integer;
begin
   if(i < 7000)then 
    begin
      i:= i+1;
      suma:= 0;
      cant:= 0;
      v2[i]:= sacarPromedio(v1[i],suma,cant);
      puntoB(v1,v2,i);
    end;
end;

procedure puntoC(var v2: vPromedio);
var
  a,b,i: integer;
  min: real;
begin
  for i:= 1 to 7000 -1 do
    begin
      a:= i;
      for b := i+1 to 7000 do
        begin
          if(v2[b] < v2[a])then
            a:= b;
        end;
      min:= v2[a];
      v2[a]:= v2[i];
      v2[i]:= min;
    end;
end;

var
  vAlu: vAlumnos;
  v2: vPromedio; 
  i: integer;
begin
  inicializarVectorAlumnos(vAlu);
  cargarFinales(vAlu);
  inicializarVpromedio(v2);
  i:= 0;
  puntoB(vAlu,v2,i);
  puntoC(v2);
end.