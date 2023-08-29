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

<h1 align="center"> sacarPromedioArbolRecursivo </h1>

```pas
program sacarPromedioArbolRecursivo;

type
  arbol = ^nodo;

  nodo = record
    dato: integer;
    hi: arbol;
    hd: arbol;
  end;

procedure inicializarLista(var a: arbol);
begin
  a:= nil;
end;

procedure cargarArbol(var a: arbol; n: integer);
begin
  if(a = nil)then
    begin
      new(a);
      a^.dato:= n;
      a^.hi:= nil;
      a^.hd:= nil;
    end
  else
    begin
      if(n < a^.dato)then
        cargarArbol(a^.hi,n)
      else
        begin
          if(n > a^.dato)then
            cargarArbol(a^.hd,n);
        end;
    end;
end;

procedure imprimirArbol(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirArbol(a^.hi);
      Writeln(a^.dato);
      imprimirArbol(a^.hd);
    end;
end;

function promedio(suma,cant: integer): real;
begin
  promedio:= suma/cant;
end;

procedure sacarPromedio(a: arbol; var suma,cant: integer; var prom: real);
begin
  if(a = nil)then
    begin
      prom:= promedio(suma,cant);
    end
  else
    begin
      suma:= suma+ a^.dato;
      cant:= cant+1;
      sacarPromedio(a^.hi,suma,cant,prom);
      sacarPromedio(a^.hd,suma,cant,prom);
    end;
end;

var
  a: arbol;
  num: integer;
  suma,cant: integer;
  prom: real;
begin
  randomize;
  inicializarLista(a);
  Writeln('Ingrese un numero: ');
  readln(num);
  While(num <> 0)do
    begin
      cargarArbol(a,num);
      Writeln('Ingrese un numero: ');
      readln(num);
    end;
  Writeln();
  imprimirArbol(a);

  suma:= 0;
  cant:= 0;
  sacarPromedio(a,suma,cant,prom);
  Writeln('Promedio: ',prom:2:2);
end.
```
