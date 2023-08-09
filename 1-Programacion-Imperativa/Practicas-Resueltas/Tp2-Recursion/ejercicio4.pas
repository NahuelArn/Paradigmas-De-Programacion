{Escribir un programa que: 
a. Implemente un módulo recursivo que genere un vector de 20 números enteros “random” 
mayores a 0 y menores a 100.  
b. Implemente un módulo recursivo que devuelva el máximo valor del vector.  
c.  Implementar  un  módulo  recursivo  que  devuelva  la  suma  de  los  valores  contenidos  en  el 
vector}

program ejercicio4;

const
  dimF20 = 20;
type
  vectorRandom = array[1..dimF20]of integer;

procedure generarNumeroYguardar(var r: integer; var posNum: integer);
begin
  r:= random(101);
  posNum:= r;
end;
{a. Implemente un módulo recursivo que genere un vector de 20 números enteros “random” 
mayores a 0 y menores a 100.  }
procedure generarVector(var v: vectorRandom; i: integer);
var
  r: integer;
begin
  if(i < 20)then
    begin
      i:= i+1;
      // r:= random(101);
      // v[i]:= r;
      generarNumeroYguardar(r,v[i]);
      generarVector(v,i);
    end;   
end;

procedure calcularMax(num: integer; var max: integer);
begin
  if(num > max)then
    max:= num;
end;
{b. Implemente un módulo recursivo que devuelva el máximo valor del vector. }
procedure sacarMax(v: vectorRandom; var max,i: integer);
begin
  if (i < dimF20) then
    begin
      i:= i+1;
      calcularMax(v[i],max);
      sacarMax(v,max,i);
    end;
end;

// prueba
procedure imprimirVector(v: vectorRandom);
var i: integer;
begin
  for i:= 1 to dimF20 do
    begin
      Writeln('Elemento actual: ',v[i]);
    end;  
end;

{c.  Implementar  un  módulo  recursivo  que  devuelva  la  suma  de  los  valores  contenidos  en  el 
vector}
// function sumarElementosVector(v: vectorRandom;i,total: integer): integer;
// var 
// begin
//   if(i < dimF20)then
//     begin
//       i:= i+1;
//       total:= total + v[i];
//       total:= total + sumarElementosVector(v,i,total);
//     end;
//     sumarElementosVector:= total;
// end;

function sumarElementosVector(v: vectorRandom;i,total: integer): integer;
begin
  if(i < dimF20)then
    begin
      i:= i+1;
      total:= total + v[i];
      sumarElementosVector:= sumarElementosVector(v,i,total);
    end
  else
    sumarElementosVector:= total;
end;

var
  i: integer;
  v: vectorRandom;
  max,total: integer;
begin
  randomize;
  i:= 0;
  generarVector(v,i);
  //podria ser un procedimiento? el retornar el max
  max:= -999;
  i:= 0; //reutilizo la variable i
  imprimirVector(v);// prueba
  sacarMax(v,max,i);
  Writeln('El numero maximo en el vector es: ',max);
  i:= 0; //reutilizo la variable i
  total:= 0;
  Writeln('La suma de todos lo elementos del vectore es: ',sumarElementosVector(v,i,total));
end.