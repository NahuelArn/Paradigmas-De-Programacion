program Clase1MI;
const dimF = 50;
type rango1 = 1..15;
     rango2 = 1..99;
     rango3 = 0..dimF;
     rango4= 0..30;
     venta = record
				codigoP: rango1;
				cantidad: rango2;
                dia_venta:rango4;
			 end;
	 vector = array [1..dimF] of venta;
	 venta1=record
	   codigo:rango1;
	   cantidad:rango2;
	 end;
	 lista = ^nodo;
	 nodo = record
	          dato: venta1;
	          siguiente: lista;
	        end;

procedure LeerVenta (var v: venta);
begin
	Randomize;
    write ('Ingrese el dia de la venta(termina en 0): ');
    readln (v.dia_venta);
	if (v.dia_venta <> 0)
	then begin
 	   write ('Codigo de producto: ');
	   v.codigoP:= random(14)+1;
	   writeln (v.codigoP);
	   write ('Ingrese cantidad (entre 1 y 99): ');
	   readln (v.cantidad);
	end;
end;


procedure AlmacenarInformacion (var v: vector; var dimL: rango3);
var unaVenta: venta;
begin
    dimL := 0;
    LeerVenta (unaVenta);
    while (unaVenta.dia_venta <> 0)  and ( dimL < dimF ) do
    begin
       dimL := dimL + 1;
       v[dimL]:= unaVenta;
       LeerVenta (unaVenta);
    end;
end;

procedure ImprimirVector (v: vector; dimL: rango3);
var
   i: integer;
begin
     write ('         -');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write ('  Codigo:| ');
     for i:= 1 to dimL do begin
        if(v[i].codigoP <= 9)then
            write ('0');
        write(v[i].codigoP, ' | ');
     end;
     writeln;
     writeln;
     write ('Cantidad:| ');
     for i:= 1 to dimL do begin
        if (v[i].cantidad <= 9)then
            write ('0');
        write(v[i].cantidad, ' | ');
     end;
     writeln;
     writeln;
     write ('Dia:| ');
     for i:= 1 to dimL do begin
        if (v[i].dia_venta <= 9)then
            write ('0');
        write(v[i].dia_venta, ' | ');
     end;
     write ('         -');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End;

procedure Ordenar (var v: vector; dimL: rango3);

var i, j, pos: rango3; item: venta;	
		
begin
 for i:= 1 to dimL - 1 do 
 begin {busca el mínimo y guarda en pos la posición}
   pos := i;
   for j := i+1 to dimL do 
        if (v[j].codigoP < v[pos].codigoP) then pos:=j;

   {intercambia v[i] y v[pos]}
   item := v[pos];   
   v[pos] := v[i];   
   v[i] := item;
 end;
end;

function BuscarPosicion (v: vector; dimL: rango3; elemABuscar: rango1): rango3;
var pos: rango3;
begin
    pos:= 1;
    while (pos <= dimL) and (elemABuscar > v[pos].codigoP) do
       pos:= pos + 1;
    if (pos > dimL) then BuscarPosicion:= 0
                    else BuscarPosicion:= pos;
end;
  

procedure Eliminar (var v: vector; var dimL: rango3; valorInferior, valorSuperior: rango1);
var posInferior,i: rango3; 
Begin
  posInferior:= BuscarPosicion (v, dimL, valorInferior);
  if (posInferior <> 0)
  then begin
        
         while ((v[posInferior].codigoP) > valorInferior) and ((v[posInferior].codigoP < valorSuperior)) do begin
           for i:=posInferior+1 to diml do
             v[i]:=v[i+1];
           diml:=diml-1;
         end;      
       
         
       end;
end;

procedure AgregarAdelante (var L: lista; codigo:rango1;cant:rango2);
var
  nue:lista;
begin
  new(nue);
  nue^.dato.codigo:=codigo;
  nue^.dato.cantidad:=cant;
  nue^.siguiente:=l;
  l:=nue;
end;
 
  
  function Cumple (num: rango1): boolean;
  begin
    Cumple:=(num mod 2 = 0);
  end;
  
procedure GenerarLista (v: vector; dimL: rango3; var L: lista); 
var i: rango3; 
  
begin
  L:= nil;
  for i:= dimL downto 1 do 
    if Cumple (v[i].codigoP) then 
    AgregarAdelante (L, L^.dato.codigo,L^.dato.cantidad);
end; 

procedure ImprimirLista (L: lista);
begin
  while (L<>nil) do begin 
     Writeln(L^.dato.codigo);
     writeln(L^.dato.cantidad);
     L:=L^.siguiente;
 end;
end;

var v: vector;
    dimL: rango3;
    valorInferior, valorSuperior: rango1;
    L: lista;
    
Begin
  L:=NIL;
  AlmacenarInformacion (v, dimL);
  writeln;
  if (dimL = 0) then writeln ('--- Vector sin elementos ---')
                else begin
                       writeln ('--- Vector ingresado --->');
                       writeln;
                       ImprimirVector (v, dimL);
                       writeln;
                       writeln ('--- Vector ordenado --->');
                       writeln;
                       Ordenar (v, dimL);
                       ImprimirVector (v, dimL);
                       write ('Ingrese valor inferior: ');
                       readln (valorInferior);
                       write ('Ingrese valor superior: ');
                       readln (valorSuperior);
                       Eliminar (v, dimL, valorInferior, valorSuperior);
                       if (dimL = 0) then writeln ('--- Vector sin elementos, luego de la eliminacion ---')
                                     else begin
                                            writeln;
                                            writeln ('--- Vector luego de la eliminacion --->');
                                            writeln;
                                            ImprimirVector (v, dimL);
                                            GenerarLista (v, dimL, L);
                                            if (L = nil) then writeln ('--- Lista sin elementos ---')
                                                         else begin
                                                                writeln;
                                                                writeln ('--- Lista obtenida --->');
                                                                writeln;
                                                                ImprimirLista (L);
                                                              end;
                                          end;
                      end;
                      readln();
end.