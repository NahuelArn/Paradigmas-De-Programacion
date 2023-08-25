{Realizar un programa que lea números hasta leer  el valor 0 e imprima, para cada número 
leído, sus dígitos en el orden en que aparecen en el número. Debe implementarse un módulo 
recursivo  que  reciba  el  número  e  imprima  lo  pedido.  Ejemplo  si  se  lee  el  valor  256,  se  debe 
imprimir 2  5  6}
program ejercicio2;

  procedure leerNumero(var n: integer);
  begin
    Writeln();
    Writeln('Ingrese un numero ');
    readln(n);
  end;

  procedure descomposicionDeNumero(VAR dig: integer; var num: integer);
  begin
    dig:= num mod 10;
    // Writeln(' ',dig);
    num:= num div 10;
  end;
  //se encarga de descomponer e imprimir todos los digitos del numero pasado por parametro
  procedure imprimirDigitos(num: integer);
  var
    dig: integer;
  begin
    if(num <> 0)then
      begin
        // dig:= num mod 10;
        // Writeln(' ',dig);  ta boem modularizar la descomposicion?
        // num:= num div 10;
        
        descomposicionDeNumero(dig,num);
        imprimirDigitos(num);
        Write(' ',dig);
      end;
  end;
  //se encarga de leer Numeros y pasarlos para la descomposicion de sus digitos
  procedure procesamientoDeNumeros();

  var
    n: integer;
  begin
    leerNumero(n);  
    if(n <> 0)then
      begin
        imprimirDigitos(n);
        procesamientoDeNumeros();
      end;
  end;

begin
  procesamientoDeNumeros();
end.
