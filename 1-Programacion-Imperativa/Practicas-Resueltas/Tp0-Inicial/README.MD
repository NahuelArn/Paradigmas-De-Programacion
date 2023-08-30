<h1 align="center"> Estructuras a mano </h1>

<p align="center">carga de vector de listas/Recorrido</p>

```pas
program ejercicio2_2023;

const
  dimF5 = 5;
type

  rango5 = 1..dimF5;


  registro = record
    num: integer;
    codCategoria: rango5;
  end;

  lista = ^nodo;

  nodo = record
    dato: registro;
    sig: lista;
  end;
  
  vLista = array[rango5]of lista;


procedure inicializarLista(var L: lista);
begin
  L:= nil;
end;

procedure inicializarListaAll(var v: vLista);
var 
  i: integer;
begin
  for i:= 1 to dimF5 do
    inicializarLista(v[i]);
end;

procedure leerData(var p: registro);
begin
  Writeln('Ingrese numero: ');
  p.num:=random(11);  //random de 0 a 10
  Writeln('Ingrese categoria [i] del vecto');
  p.codCategoria:= random(6)+1;
end;


procedure insertarOrdenado(var l: lista; r: registro);
var
  nue: lista;
  ant,act: lista;
begin
  ant:= l;
  act:= l;
  new(nue);
  nue^.dato:= r;
  While(act <> nil) and ( r.num > act^.dato.num )do
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

procedure cargarVector(var v: vLista);
var
  r: registro;
begin
  leerData(r);
  While(r.num <> 0)do
    begin
      insertarOrdenado(v[r.codCategoria],r);
      leerData(r);
    end;
end;

procedure imprimir(l: lista);
begin
  While(L <> nil)do
    begin
      Writeln(l^.dato.num);
      L:= l^.sig;
    end;
end;

var
  num,categoriaBuscada: integer;
  L: lista;
  v: vLista;
begin
  randomize;
  inicializarListaALL(v);
  cargarVector(v);
  
  Writeln('Ingrese un numero de categoria a imprimir: ');
  readln(categoriaBuscada);
  imprimir(v[categoriaBuscada]);  //le manda la lista
  
end.

```