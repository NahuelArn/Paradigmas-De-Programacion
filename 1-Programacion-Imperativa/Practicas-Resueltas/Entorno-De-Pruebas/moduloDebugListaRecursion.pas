program moduloDebugListaRecursion;

type
  lista = ^nodo;
  
  nodo = record
    dato: integer;
    sig: lista;
  end;
  
procedure agregarAdelante(var L: lista; n: integer);
var
  nue: lista;
begin
  new(nue);
  nue^.dato:= n;
  nue^.sig:= L;
  L:= nue;
end;
//busca max, en una lista de manera recursiva
function buscarMaximo(L: lista; max: integer): integer;  //max lo pasas en 0
begin
  if(L = nil)then
    buscarMaximo:= max
  else
    begin
      if(L^.dato > max)then
        max:= L^.dato;
      buscarMaximo:= buscarMaximo(L^.sig,max);
    end;
end;

var
  L: lista;
  num, max: integer;
begin
  L:= nil;
  Writeln('Ingrese un numero: ');
  readln(num);
  While(num <> 0)do
    begin
      agregarAdelante(L,num);
      Writeln('Ingrese un numero: ');
      readln(num);
    end;
  max:= 0;
  Writeln('El numero maximo en la lista es: ',buscarMaximo(l,max));
end.