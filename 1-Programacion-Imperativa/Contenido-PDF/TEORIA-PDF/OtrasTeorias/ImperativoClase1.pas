{Implementar un programa que procese la información de las ventas de productos de un comercio (como máximo 20). 
De cada venta se conoce código del producto (entre 1 y 15) y cantidad vendida (como máximo 99 unidades). 
El ingreso de las ventas finaliza con el código 0 (no se procesa).

a. Almacenar la información de las ventas en un vector. El código debe generarse automáticamente (random) y la cantidad se debe leer. 
b. Mostrar el contenido del vector resultante.
c. Ordenar el vector de ventas por código.
d. Mostrar el contenido del vector resultante.
e. Eliminar del vector ordenado las ventas con código de producto entre dos valores que se ingresan como parámetros. 
f. Mostrar el contenido del vector resultante.
g. Generar una lista ordenada por código de producto de menor a mayor a partir del vector resultante del inciso e., 
* sólo para los códigos pares.
h. Mostrar la lista resultante.}

program Clase1MI;
const dimF = 20;
type rango1 = 0..15;
     rango2 = 1..99;
     rango3 = 0..dimF;
     venta = record
				codigoP: rango1;
				cantidad: rango2;
			 end;
	 vector = array [1..dimF] of venta;

procedure AlmacenarInformacion (var v: vector; var dimL: rango3);
  
  procedure LeerVenta (var v: venta);
  begin
    Randomize;
    write ('Codigo de producto: ');
    v.codigoP:= random(15);
    writeln (v.codigoP);
    if (v.codigoP <> 0)
    then begin
           write ('Ingrese cantidad (entre 1 y 99): ');
           readln (v.cantidad);
         end;
  end;

var unaVenta: venta;
begin
    dimL := 0;
    LeerVenta (unaVenta);
    while (unaVenta.codigoP <> 0)  and ( dimL < dimF ) do 
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
     writeln('Vector de ventas: 1era linea codigo, 2da linea cantidad');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if(v[i].codigoP <= 9)then
            write ('0');
        write(v[i].codigoP, ' | ');
     end;
     writeln;
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if (v[i].cantidad <= 9)then
            write ('0');
        write(v[i].cantidad, ' | ');
     end;
     writeln;
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

procedure Eliminar (var v: vector; var dimL: rango3; valorInferior, valorSuperior: rango1);
var
  ini,fin,i: integer;
  aBorrar: integer;
begin

  {Buscar en el vector la posicion donde debo empezar a borrar: ini} 
  ini:=1;
  while (ini <= dimL) and (v[ini].codigoP < valorInferior) do ini:=ini+1;

  {Buscar en el vector la posicion donde debo terminar de borrar: fin}
  {Comenzar a partir de ini porque el vector esta ordenado} 
  fin:= ini;
  while (fin <= dimL) and (v[fin].codigoP<=valorSuperior) do fin:=fin+1;
  
  {Cantidad de elementos a borrar: aBorrar}
  aBorrar:= fin - ini;  
  if (aBorrar>0)then begin
         {Eliminar todos las ventas entre las posiciones ini y fin-1 } 
		  for i:= fin to dimL do begin
			  v[ini]:=v[i];
			  ini:= ini+1;
		  end;
		  {Actualizar dimL}
		  dimL:= dimL - aBorrar;
  end;
end;

var v: vector;
    dimL: rango3;
    valorInferior, valorSuperior: rango1;
Begin
  AlmacenarInformacion (v, dimL);
  writeln;
  if (dimL = 0) then writeln ('--- Vector sin elementos ---')
                else begin
                       ImprimirVector (v, dimL);
                       Ordenar (v, dimL);
                       ImprimirVector (v, dimL);
                       write ('Ingrese valor inferior: ');
                       readln (valorInferior);
                       write ('Ingrese valor superior: ');
                       readln (valorSuperior);
                       Eliminar (v, dimL, valorInferior, valorSuperior);
                       if (dimL = 0) then writeln ('--- Vector sin elementos, luego de la eliminación ---')
                                     else begin
                                            ImprimirVector (v, dimL);
                                          {  GenerarLista (v, dimL, L);
                                            if (L = nil) then writeln ('--- Lista sin elementos ---')
                                                         else ImprimirLista (L);}
                                     end;
                      end;
                       
end.
