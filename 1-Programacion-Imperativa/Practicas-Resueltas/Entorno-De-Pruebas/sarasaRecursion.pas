program sarasaRecursion;

procedure digitoMaximo(n: integer; var max: integer);
var 
  dig: integer;
begin
  dig:= n mod 10;
  if(dig > max)then
    max:= dig;
  n:= n div 10;
  if( n <> 0)then
    digitoMaximo(n,max);
    Writeln('valor de n 13:  ',n,' valor de dig 2: ',dig,' y max 3: ', max);
end;

var
  n: integer;
  max: integer;
begin
  n:= 132;
  max:= -1;
  digitoMaximo(n,max);
end.