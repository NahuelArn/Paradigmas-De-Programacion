<h1 align="center"> PROGRAMACION ORIENTADA IMPERATIVA </h1>

<p align="center">Algoritmos que se repiten</p>

<h1 align="center"> Imperativo </h1>

 
<h1 align="center"> Ordenacion-Seleccion </h1>

```pas 

procedure ordenarVectorSeleccion(var v: vOrdenar; dimL: integer);
var a,b,i,min: integer;
begin
  for i:= 1 to (dimL-1) do  
    begin
      a:= i; 
      for b:= i+1 to dimL do
        begin
          if(v[b] < v[a])then 
            begin
              a:= b; 
            end;          
          min:= v[a]; 
          v[a]:= v[i]; 
          v[i]:= min;  
        end;
    end;
end;

```

<h1 align="center"> Ordenacion-Insercion </h1>

  
```pas 
Procedure ordenarVectorInsercion(v: vector; dimL: integer)
var
  elemAct,i,b: integer;
begin
  for i = 2 to (dimL-1) do
    begin
      elemAct = v[i];
      b = i - 1;
      while b > 0 and (v[b] > elemAct) do  //si el anterior es mas grande que el segundo 
        begin
          v[b+1] := v[b]; 
          b = b - 1;
        end;
        v[b+1] = elemAct
    end;
end;

```

<h1 align="center"> Recursion</h1>

<h1 align="center"> Sacar un el digito maximo de un numero</h1>
```pas
function estaEnLaLista(L: lista; valorBuscado: integer): boolean;
begin
	if(L = nil) then
		estaEnLaLista:= false
	else
		if(L^.dato = valorBuscado)then
			estaEnLaLista:= true
		else
			estaEnLaLista:= estaEnLaLista(L^.sig,valorBuscado)
end;

if(estaEnLaLista(L,buscado))then
		Writeln('valor encontrado ' )
	else
		Writeln('no esta en la lista');

```

<h1 align="center"> Sacar un el digito maximo de un numero</h1>
```pas

program sarasaRecursion;

procedure digitoMaximo(n: integer; var max: integer);
var 
  dig: integer;
begin
  dig:= n mod 10;
  if(dig > max)then
    max:= dig;
  n:= n div 10;
  if( n <> 0)then
    digitoMaximo(n,max);
    Writeln('valor de n 13:  ',n,' valor de dig 2: ',dig,' y max 3: ', max);
end;

var
  n: integer;
  max: integer;
begin
  n:= 132;
  max:= -1;
  digitoMaximo(n,max);
end.

```
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