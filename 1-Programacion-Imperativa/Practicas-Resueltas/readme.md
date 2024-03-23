<h1> Randomize </h1>

```pas

  program sint;
  var
    n: integer;
  begin
    Randomize;
    n:= random(5)+1; //se evita el 0
    writeln('num random ', n);
  end.

  for i:= 3 to 5 do
    begin
    end;
```
