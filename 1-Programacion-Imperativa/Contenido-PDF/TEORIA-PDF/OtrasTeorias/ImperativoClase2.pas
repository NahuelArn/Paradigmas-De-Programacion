{Implementar un programa que invoque a los siguientes módulos.
a. Implementar un módulo recursivo que permita leer una secuencia de caracteres 
   terminada en punto y los almacene en un vector con dimensión física igual a 10.
b. Implementar un módulo que imprima el contenido del vector.
c. Implementar un módulo recursivo que imprima el contenido del vector.
d. Implementar un módulo recursivo que permita leer una secuencia de caracteres 
   terminada en punto y retorne la cantidad de caracteres leidos. El programa debe informar el valor retornado.
e. Implementar un módulo recursivo que permita leer una secuencia de caracteres 
   terminada en punto y retorne una lista con los caracteres leidos.
f. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los 
   valores de la lista en el mismo orden que están almacenados.
g. Implemente un módulo recursivo que reciba la lista generada en d. e imprima los 
   valores de la lista en orden inverso al que están almacenados.
}

Program Clase2MI;
const dimF = 10;
type vector = array [1..dimF] of char;
     lista = ^nodo;
     nodo = record
              dato: char;
              sig: lista;
            end;


procedure CargarVector (var v: vector; var dimL: integer);

  procedure CargarVectorRecursivo (var v: vector; var dimL: integer);
  var caracter: char;
  begin
    write ('Ingrese un caracter: ');
    readln(caracter);  
    if (caracter <> '.' ) and (dimL < dimF) 
    then begin
          dimL:= dimL + 1;
          v[dimL]:= caracter;
          CargarVectorRecursivo (v, dimL);
         end;
  end;
  
begin
  dimL:= 0;
  CargarVectorRecursivo (v, dimL);
end;
 
procedure ImprimirVector (v: vector; dimL: integer);
var
   i: integer;
begin
     for i:= 1 to dimL do begin
        write(v[i], ' | ');
     end;
     writeln;
     writeln;
End;

procedure ImprimirVectorRecursivo (v: vector; dimL: integer);
  procedure RecorrerVectorRecursivo(v:vector; i, dimL:integer);
  begin
      if(i<=dimL) then begin
           write(v[i], ' | ');
           RecorrerVectorRecursivo(v,i+1,dimL);
      end;
  end;

begin
  RecorrerVectorRecursivo(v,1,dimL);
  writeln;
  writeln;
end;

function ContarCaracteres(): integer;
var caracter: char;
Begin
  write ('Ingrese un caracter: ');
  readln(caracter);  
  if (caracter <> '.' )  
  then ContarCaracteres:= ContarCaracteres() + 1  
  else ContarCaracteres:=0  
End;
  

procedure CargarLista (var l,ult: lista);
    procedure AgregarAtras (var l, ult: lista; elem: char);
    var nue : lista;
    begin
        new(nue);
        nue^.dato:= elem;
        nue^.sig:= nil;
        if l <> nil then
           ult^.sig := nue
        else
           l:= nue;
        ult:= nue;
    end;
var
  caracter: char;
Begin
  write ('Ingrese un caracter: ');
  readln(caracter);  
  if (caracter <> '.' ) then begin
     AgregarAtras (l, ult, caracter);
     CargarLista (l,ult);
  end;
End;

procedure ImprimirListaMismoOrden (l: lista);
begin
  if (l<> nil) then begin
        write (l^.dato, ' | ');
        ImprimirListaMismoOrden (l^.sig);
  end;
end;

var cont, dimL: integer; l,ult: lista; v: vector;
Begin 
  writeln ('--- Carga del vector ---');
  CargarVector (v, dimL);
  writeln;
  if (dimL = 0) then writeln ('--- Vector sin elementos ---')
                else begin
                       writeln ('--- Imprimir vector iterativo ---');
                       ImprimirVector (v, dimL);
                       writeln ('--- Imprimir vector recursivo ---');
                       ImprimirVectorRecursivo (v, dimL);
                     end;
  writeln;
  writeln;
  writeln ('--- Ingrese una secuencia de caracteres hasta . ---');
  cont:= ContarCaracteres();
  writeln;
  writeln;
  writeln('Se ingresaron ',cont,' caracteres'); 
  writeln;
  writeln;
  writeln ('--- Carga de lista ---');
  l:=nil;
  CargarLista (l,ult);
  writeln;
  writeln;
  if (l = nil) then writeln ('--- Lista sin elementos ---')
               else Begin
                      writeln ('--- Orden ingresado ---');
                      writeln;
                      ImprimirListaMismoOrden (l);
                      writeln;
                      writeln;
                      { writeln ('--- Orden inverso ---');
                      writeln;
                      ImprimirListaOrdenInverso (l); }
                    end;
end.
