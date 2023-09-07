procedure wsp;

type
  
 
  producto = record
    cod: integer;
    cant: integer;
  end;
  
  lista = ^nodo;
  
  nodo = record;
    dato: producto ;
    sig: lista;
  end;
  
  venta = record
    numVenta: integer;
    montoTotal: real;
    listaProduc: lista;
  end;
  
  vVentas = array[1..500]of venta ;
  
function tiene5(L: lista): boolean;
var
  sigo: boolean
  cant: integer;
begin
  sigo:= true; cant:= 0;
  While(L <> nil) and (sigo <> false)do
    begin
      cant:= cant+1;
      if(cant = 5)then
        sigo:= true;
      L:= L^.sig
    end;
   tiene5:= sigo;
end;


procedure eliminarVector(var v: vVentas; pos: integer; var dimL: integer);
var  i: integer;
begin
  for i:= pos to dimL-1 do
    v[i]:= v[i+1];
  dimL: dimL-1;
end;

procedure filtrarLista(var v: vVentas;var dimL: integer);
var
  i: integer;
begin
  i:= 0;
  While(i < dimL)do  
    begin
      i:= i+1;
      if(tiene5(v[i].listaProduc))then
        eliminarVector(v,i,dimL);
    end;
end;  
  
  
var
  v: vector;
begin
  dimL:= 0;  
  cargarVector(dimL,v);  //se dispone
  filtrarLista(v,dimL);
end.  