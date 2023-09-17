program playStation;
type
  arbol = ^hoja; // esta es la primera estructura
  compra = record
    codVideojuego : integer;
    codCliente : integer;
    dia : 1..31;
    mes : 1..12; 
   end;
  Meses = array [1..12] of integer; // esta es la segunda estructura
  hoja = record
    elem : compra;
    hi : arbol;
    hd : arbol;
   end;
  
procedure inicializarvector (var v : Meses);
var
  i : integer;
begin
  for i := 1 to 12 do 
    v[i] := 0;
end;

procedure agregarnodo (var a : arbol ;  c : compra ; var v : Meses);

begin
  if (a = nil) then begin
    new (a);
    a^.elem := c;
    a^.hd := nil;
    a^.hi := nil;
    v[c.mes] := v[c.mes] + 1;
   end
   else begin
     if (c.codCliente <= a^.elem.codCliente) then
       agregarnodo (a^.hi,c,v)
     else
       agregarnodo (a^.hd,c,v)
    end;
end;

procedure leercompra ( var c : compra);
begin
  writeln ('inserte codigo de cliente');
  read (c.codCliente);
  if (c.codCliente <> 0) then begin
    writeln ('inserte codigo del videojuego');
   // read (c.codVideojuego);
    c.codVideojuego:= 2;
    writeln ('inserte numero de dia');
   // read (c.dia); 
   c.dia:= 1;
    writeln ('inserte numero de mes');
   // read (c.mes);
   c.mes:= 3;
   end;
end;
procedure crearArbol (var a : arbol);
var
  c : compra;
  v : Meses;
begin
  inicializarvector (v);
  leercompra (c);
  while (c.codcliente <> 0) do begin
    agregarnodo (a,c,v);
    leercompra (c)
  end;
end;

procedure inscisoB (a : arbol; cod : integer; var cantCompras : integer) ;
begin
  if (a <> nil) then begin
    if (cod < a^.elem.codCliente) then 
       inscisoB (a^.hi,cod,cantCompras)
    else
      if (cod > a^.elem.codCliente) then
        inscisoB (a^.hd,cod,cantcompras)
      else begin
        cantCompras := cantCompras + 1;
        inscisoB (a^.hi,cod,cantCompras);
        inscisoB (a^.hd,cod,cantCompras);
      end;
  end;
  if (cantCompras <> 0) then
  writeln('la cantidad de compras realizadas por el cliente', cod,'es', cantCompras)
  else
    writeln ('no se encontro el cliente');
end;

function infomarCompras(a: arbol; cod: integer): integer;
begin 
  if(a = nil)then
    infomarCompras:= 0
  else  
    begin
      if(a^.elem.codCliente = cod)then
        infomarCompras:= infomarCompras(a^.hi,cod) + 1+infomarCompras(a^.hd,cod)
      else  
        begin 
          if(a^.elem.codCliente > cod)then
            infomarCompras:= infomarCompras(a^.hi,cod)
          else
            infomarCompras:= infomarCompras(a^.hd,cod);
        end;
    end;
end;

var 
  a : arbol;
  cantCompras,cod : integer;
BEGIN
  a := nil;
  cantCompras := 0;
  crearArbol (a);
  writeln('inserte un codigo de cliente del que quiera saber la cantidad de compras que realizo');
  read (cod);
  //inscisoB (a,cod,cantcompras);
    writeln('la cantidad de compras realizadas por el cliente ', cod,' es ', infomarCompras(a,cod))
END.