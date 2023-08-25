{1.- Implementar un programa que invoque a los siguientes módulos. 
a. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y los almacene en un vector con dimensión física igual a 10. 
b. Implementar un módulo que imprima el contenido del vector. 
c. Implementar un módulo recursivo que imprima el contenido del vector.   [x]
d. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y retorne la cantidad de caracteres leídos.  
El programa debe informar el valor retornado. [x]
e. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y retorne una lista con los caracteres leídos. [x]
f. Implemente un módulo recursivo que reciba la lista generada en E. e imprima los valores de 
la lista en el mismo orden que están almacenados. 
g. Implemente un módulo recursivo que reciba la lista generada en E. e imprima los valores de 
la lista en orden inverso al que están almacenados. }




program ejercicio1;

const
  dimF10 = 10;
type
  vectorCaracteres= array[1..dimF10]of char;
  lista = ^nodo;

  nodo = record
    dato: char;
    sig: lista;
  end;

  procedure leerCaracter(var c: char);
  begin
    Writeln('Ingrese un caracter e ingrese "." para terminar de leer');
    readln(c);
  end;
  
  {a. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y los almacene en un vector con dimensión física igual a 10.}
  procedure cargarEstructura(var v: vectorCaracteres; var dimL: integer);
  var
    c: char;
  begin
    leerCaracter(c);
    if(dimL < dimF10) and (c <> '.')then
      begin
        dimL:= dimL+1;  //1 2 3
        v[dimL]:= c;
        cargarEstructura(v,dimL);
        // dimL:= dimL+1; // 3 2 1
        // v[dimL]:= c;
      end;  
  end;

{b. Implementar un módulo que imprima el contenido del vector.}
procedure imprimirVector(v: vectorCaracteres;dimL: integer);
var
  i: integer;
begin
  for i:= 1 to dimL do
    Writeln('Pos actual: ',i,' valor actual: ',v[i]);
end;

{c. Implementar un módulo recursivo que imprima el contenido del vector. }
procedure imprimirVectorRecursivo(v:vectorCaracteres; dimL: integer);

begin
  // dimL:= dimL-1;
  Writeln('cant dimL: ',dimL);
  if(dimL >0)then
    begin  
      imprimirVectorRecursivo(v,dimL-1);
      Writeln('Pos actual: ',dimL,' valor actual: ',v[dimL]);
    end; 
end;
{D Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y retorne la cantidad de caracteres leídos. 
El programa debe informar el valor retornado.  }
function leerYretornarCantCaract(v:vectorCaracteres): integer;
var
  dimL  : integer;
begin
  dimL:= 0;
  cargarEstructura(v,dimL);
  leerYretornarCantCaract:= dimL;
end;

procedure agregarAdelante(var L: lista; c: char);
var
  nue: lista;
begin
  new(nue);
  nue^.dato:= c;
  nue^.sig:= L;
  L:= nue;
end;

{e. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y retorne una lista con los caracteres leídos.}
procedure cargarLista(var L: lista);
var
  c: char;
begin
  leerCaracter(c);
  if(c <> '.')then
    begin
      agregarAdelante(L,c);
      cargarLista(L);
    end;
end;

{f. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los valores de 
la lista en el mismo orden que están almacenados.}
procedure imprimirListaNormal(L: lista);
begin
  if(L <> nil)then
    begin
      Writeln('Lo que esta contenido en la lista es: ',L^.dato);
      imprimirListaNormal(L^.sig);
    end;
end;

{g. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los valores de 
la lista en orden inverso al que están almacenados.}
//Lifo
procedure imprimirListaInverso(L: lista);
begin
  if(L <> nil)then
    begin
      imprimirListaInverso(L^.sig);
      Writeln('Lo que esta contendio en la lista es: ',L^.dato);
    end;
end;

var
  v: vectorCaracteres;
  dimL: integer;
  auxD: integer;
  L: lista;
begin
  dimL:= 0;
  cargarEstructura(v,dimL);
  imprimirVector(v,dimL);
  Writeln('Recursivo');
  imprimirVectorRecursivo(v,dimL);
  auxD:= leerYretornarCantCaract(v);
  Writeln('La cantidad de caracteres leidos es: ',auxD);
  L:= nil;
  cargarLista(L);
  imprimirListaNormal(L);
  imprimirListaInverso(L);
end.





















// program ejercicio1;

// const
//   dimF10 = 10;
// type

//   vectorPuntoA = array[1..dimF10]of char;

// procedure leerCaracteres(var vCaracteres: vectorPuntoA; var dimL: integer);
// var
//   car: char;
// begin
//   Writeln('Ingrese un caracter ');
//   readln(car);
//   if(car <> '.') and (dimL < dimF10)then
//     begin
//       dimL:= dimL+1;
//       vCaracteres[dimL]:= car;
//       leerCaracteres(vCaracteres, dimL);
//       // Writeln('LIFO=porValor ',dimL);
//     end;
// end;

// procedure imprimirVectorCaracteres(vCaracteres: vectorPuntoA; dimL: integer);
// var
//   i: integer;
// begin
//   for i:= 1 to dimL do
//     Writeln('Letra actual: ',vCaracteres[i],' en la pos: ',i,' del vector');
// end;

// procedure imprimirVectorCaracteresRecursivo(v: vectorPuntoA; dimL: integer {var i: integer});

// begin
//   if((dimL - 1) > 0)then
//     begin
//       dimL:= dimL - 1;
//       imprimirVectorCaracteresRecursivo(v,dimL{,i});
//       Writeln('Letra actual: ',v[dimL], ' en la pos: ',dimL, ' del vector');
//     end;
// end;


// var
//   dimL: integer;
//   vCaracteres: vectorPuntoA;
// begin
//   dimL:= 0;
//   leerCaracteres(vCaracteres,dimL);
//   imprimirVectorCaracteres(vCaracteres,dimL);
//   Writeln();
//   Writeln('Manera recursiva ');
//   Writeln();
//   dimL:= dimL+1;
//   imprimirVectorCaracteresRecursivo(vCaracteres,dimL{,0});
// end.