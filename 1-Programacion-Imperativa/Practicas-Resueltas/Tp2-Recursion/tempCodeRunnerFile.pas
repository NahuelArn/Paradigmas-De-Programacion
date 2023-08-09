procedure imprimirVector(v: vectorRandom);
var i: integer;
begin
  for i:= 1 to dimF20 do
    begin
      Writeln('Elemento actual: ',v[i]);
    end;  
end;