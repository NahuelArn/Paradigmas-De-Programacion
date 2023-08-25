<h1 align="center"> Arboles </h1>

<p align="center">Implementacion</p>

<h1 align="center"> Carga de Arboles </h1>

```pas
program ejercicio1;

type
  arbol = ^nodo;
  
  nodo = record
    dato: integer;
    hi: arbol;
    hd: arbol;
  end;

procedure inicializarArbol(var a: arbol);
begin
  a:= nil;  
end;

procedure cargarArbol(var a: arbol; num: integer);
begin
  if( a = nil)then  //si es el primer el elemento o se crea un nuevo nodo
    begin
      new(a); //creo el MAIN (en la primera iteracion) / despues crea el Main de los nodos
      a^.dato:= num;
      a^.hi:= nil;
      a^.hd:= nil;
    end
  else
    if( num < a^.dato)then
      cargarArbol(a^.hi,num)
    else
      cargarArbol(a^.hd,num);
end;
//imprimir Arbol / criterio de Impresion ''In order''
procedure imprimir(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimir(a^.hi);
      Writeln(a^.dato);
      imprimir(a^.hd);
    end;  
end;

var
  a: arbol; 
  n: integer;
begin
  inicializarArbol(a);
  Writeln('Ingrese un numero: ');
  readln(n);
  While(n <> 0)do
    begin
      cargarArbol(a,n);
      Writeln('Ingrese un numero: ');
      readln(n);
    end;
  imprimir(a);
end.

```





