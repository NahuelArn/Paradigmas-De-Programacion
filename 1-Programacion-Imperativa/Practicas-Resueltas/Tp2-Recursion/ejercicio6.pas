{Realizar un programa que lea números y que utilice un procedimiento recursivo que escriba 
el equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa 
el número 0 (cero).  
 
Ayuda:  Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2. 
¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la 
próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.}

program ejercicio6;

procedure swap(num: integer);
begin
  if(num <> 0)then
    begin
      // num:= num div 2;
      swap(num div 2);
      Write(num mod 2);
    end;
end;

var
  num: integer;
begin
  Writeln('Ingrese un numero para pasarlo a su equivalencia en BSS ');
  readln(num);
  While(num <> 0)do
    begin
      swap(num); 
      Writeln('');
      Writeln('Ingrese un numero para pasarlo a su equivalencia en BSS ');
      readln(num);
    end;
end.