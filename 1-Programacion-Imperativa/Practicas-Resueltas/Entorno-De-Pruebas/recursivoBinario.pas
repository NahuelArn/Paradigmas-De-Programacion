{

                            Online Pascal Compiler.
                Code, Compile, Run and Debug Pascal program online.
Write your code in this editor and press "Run" button to execute it.

}


program Hello;
type

  vector = array[1..10]of integer;

procedure cargarVector(var v: vector);
var
  i: integer;
begin
  for i:= 1 to 10 do  
    v[i]:= random(10);
end;

procedure imprimirVector(var v: vector);
var
  i: integer;
begin
  for i:= 1 to 10 do
    Writeln('estamos en la iteracion: ',i,' y tiene este valor: ',v[i]);
end;

procedure busquedaDicotomicaRecursiva (v: vector ; ini: integer ; fin: integer ; valorBuscado: integer ; var pos: integer;var encontrado:Boolean);
var
	mid: integer;
begin
	if (ini > fin) then
		pos:= -1
	else
    begin
      mid:= (ini + fin) div 2;
      if (valorBuscado = v[mid]) then
        begin
          pos:= mid;
          encontrado:= true;
        end
      else
        if (valorBuscado < v[mid]) then
          busquedaDicotomicaRecursiva(v, ini, (mid - 1), valorBuscado, pos,encontrado)
        else
          busquedaDicotomicaRecursiva(v, (mid + 1), fin, valorBuscado, pos,encontrado)
    end;
end;


procedure ordenarPorSeleccion(var v: vector; dimL: integer);
var
  a,b,i,min: integer;
begin
  for i:= 1 to dimL-1 do
    begin
      a:= i;
      for b:= i+1 to dimL-1 do
        begin
          if(v[b] < v[a])then
            a:= b;
        end;
        min:= v[a];
        v[a]:= v[i];
        v[i]:= min;
    end;  
end;


procedure buscarNumero(numAbuscar: integer; v1: vector; ini,mitad,fin: integer;var encontrado: Boolean);

begin
  if ((ini <= fin) And (encontrado <> true)) then
    Begin
      mitad := (ini+fin) Div 2;
      If (v1[mitad] = numAbuscar) Then
        encontrado := true
      Else 
        begin
          If (numAbuscar < v1[mitad])Then
            fin := mitad-1
          Else 
            If (numAbuscar > v1[mitad])Then
              ini := mitad+1;
        end;
      buscarNumero(numAbuscar,v1,ini,mitad,fin,encontrado);
    End
  else
    encontrado:= encontrado;
end;

var
  v: vector;
  valorB,ini,pos,fin: integer;
  encontrado: Boolean;
  dimL: integer;
  mitad: integer;
begin
  randomize;
  cargarVector(v);
  dimL:= 10;
  ordenarPorSeleccion(v,dimL);
  imprimirVector(v);
  Writeln('Ingrese un valor ha buscar ');
  readln(valorB);
  encontrado:= false;
  busquedaDicotomicaRecursiva(v,1,10,valorB,pos,encontrado);
  if(encontrado)then
    Writeln('Se encontro el numero: ',pos)
  else  
    Writeln('error: ',pos);

  Writeln('El HABIA hecho yo ');
  Writeln();Writeln();
  encontrado:= false;
  buscarNumero(valorB,v,1,mitad,10,encontrado);
  Writeln();Writeln();
  if(encontrado)then
    Writeln('Se encontro el numero: ')
  else  
    Writeln('error: ');
end.

