{1.- Implementar un programa que invoque a los siguientes módulos. 
a. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y los almacene en un vector con dimensión física igual a 10. 
b. Implementar un módulo que imprima el contenido del vector. 
c. Implementar un módulo recursivo que imprima el contenido del vector. 
d. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y retorne la cantidad de caracteres leídos.  
El programa debe informar el valor retornado. 
e. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada 
en punto y retorne una lista con los caracteres leídos. 
f. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los valores de 
la lista en el mismo orden que están almacenados. 
g. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los valores de 
la lista en orden inverso al que están almacenados. }

program ejercicio1;

const
  dimF10 = 10;
type

  vectorPuntoA = array[1..dimF10]of char;

procedure leerCaracteres(var vCaracteres: vectorPuntoA; var dimL: integer);
var
  car: char;
begin
  Writeln('Ingrese un caracter ');
  readln(car);
  if(car <> '.') and (dimL < dimF10)then
    begin
      dimL:= dimL+1;
      vCaracteres[dimL]:= car;
      leerCaracteres(vCaracteres, dimL);
      // Writeln('LIFO=porValor ',dimL);
    end;
end;

procedure imprimirVectorCaracteres(vCaracteres: vectorPuntoA; dimL: integer);
var
  i: integer;
begin
  for i:= 1 to dimL do
    Writeln('Letra actual: ',vCaracteres[i],' en la pos: ',i,' del vector');
end;

procedure imprimirVectorCaracteresRecursivo(v: vectorPuntoA; dimL: integer {var i: integer});

begin
  if((dimL - 1) > 0)then
    begin
      dimL:= dimL - 1;
      imprimirVectorCaracteresRecursivo(v,dimL{,i});
      Writeln('Letra actual: ',v[dimL], ' en la pos: ',dimL, ' del vector');
      
    end;
end;


var
  dimL: integer;
  vCaracteres: vectorPuntoA;
begin
  dimL:= 0;
  leerCaracteres(vCaracteres,dimL);
  imprimirVectorCaracteres(vCaracteres,dimL);
  Writeln();
  Writeln('Manera recursiva ');
  Writeln();
  dimL:= dimL+1;
  imprimirVectorCaracteresRecursivo(vCaracteres,dimL{,0});
end.