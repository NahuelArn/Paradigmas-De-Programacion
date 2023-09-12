program moduloDebugListaRecursion;

const
	dimF = 5;
type
	vector = array[1..10]of integer;
	

// procedure ordenarVector(var v: vector; dimL: integer);
// var a,b,i,min: integer;
// begin
// 	for i:= 1 to dimL-1 do
// 		begin
// 			a:= i;
// 			for b:= i+1 to dimL do
// 				begin
// 					if(v[b] < v[a])then
// 						a:= b;
// 				end;
// 				min:= v[a];
// 				v[a]:= v[i];
// 				v[i]:= min;
// 		end;

// end;

procedure imprimir(v: vector);
var i: integer;
begin
	for i:= 1 to dimF do
		Writeln('actual: ',v[i]);
end;

Procedure ordenarVector(var v: vector; dimL: integer);
var
  elemAct,i,b: integer;
begin
  for i := 2 to (dimL) do
    begin
      elemAct := v[i];
      b := i - 1;
      while (b > 0) and (v[b] > elemAct) do  //si el anterior es mas grande que el segundo 
        begin
          v[b+1] := v[b]; 
          b := b - 1;
        end;
        v[b+1] := elemAct
    end;
end;

// procedure estaEnElArray(v: vector; dimL: integer; var ok: boolean;valorBuscado: integer);
// var ini,mid,fin: integer;
// begin
// 	ok:= false;
// 	ini:= 1;
// 	fin:= dimL;
// 	While(ini <= fin) and (ok <> true)do
// 		begin
// 			mid:= (ini+fin)div 2;
// 			if(v[mid] = valorBuscado)then
// 				ok:= true
// 			else
// 				begin
// 					if(valorBuscado > v[mid])then
// 						ini:= mid+1
// 					else
// 						begin
// 							if(valorBuscado < v[mid])then
// 								fin:= mid-1;
// 						end;
// 				end;
// 		end;
// end;

procedure busquedaDicotomicaRecursiva(v: vector; ini,fin,valorBuscado: integer; var ok: boolean);
var mid: integer;
begin
  if(ini > fin)then
    ok:= False
  else
    begin
      mid:= (ini+fin) div 2;
      if(valorBuscado = v[mid])then
        ok:= true
      else
        begin
          if(valorBuscado > v[mid])then
            busquedaDicotomicaRecursiva(v,mid+1,fin,valorBuscado,ok)
          else
            busquedaDicotomicaRecursiva(v,ini,mid-1,valorBuscado,ok);
          
        end;
    end;
end;


var
  num: integer;
  dimL,i,valorBuscado: integer;
  v: vector; ok: boolean;
  fin,ini: integer;
begin
  Writeln('Ingrese un numero: (-1 para cortar) ');
  readln(num);
  for i:= 1 to dimF do
    begin
      v[i]:= num;
      Writeln('Ingrese un numero: (-1 para cortar) ');
      readln(num);
    end;
  imprimir(v);
	dimL:= dimF;
  ordenarVector(v,dimL);
  Writeln();
  imprimir(v);
  valorBuscado:= 3;
  //estaEnElArray(v,dimL,ok,valorBuscado);
  ini:= 1; fin:= dimL;
  busquedaDicotomicaRecursiva(v,ini,fin,valorBuscado,ok);
  if(ok = true)then
		Writeln('se encontro')
	else
		Writeln('no se encontro');
end.


