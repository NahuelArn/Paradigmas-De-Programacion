{ Escribir un programa que: 
a.  Implemente  un  módulo  recursivo  que  genere  una lista de números enteros “random” 
mayores a 0 y menores a 100. Finalizar con el número 0. 
b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista.  
c. Implemente un módulo recursivo que devuelva el máximo valor de la lista.  
d.  Implemente  un  módulo  recursivo  que  devuelva  verdadero  si  un  valor  determinado  se 
encuentra en la lista o falso en caso contrario.  }

program ejercicio3;

type
  lista = ^nodo;

  nodo = record
    dato: integer;
    sig: lista;
  end;

procedure inicializarLista(var L:lista);
begin
  L:= nil;  
end;

procedure agregarAtrasOptimizado(var L,Ult: lista; n: integer);
var
  nue: lista;
begin
  new(nue);
  nue^.dato:= n;
  nue^.sig:= Nil;
  if(L = nil)then
    L:= nue
  else
    Ult^.sig:= nue;
  Ult:= nue;
end;

procedure cargarEstructura(var L,Ult: lista);
var
  n: integer;
  // Ult: lista;
begin
  n:= random(101);
  if(n <> 0)then
    begin
      agregarAtrasOptimizado(L,Ult,n);
      cargarEstructura(L,Ult);
    end;
end;

procedure sacarUnMinimo(var min: integer; num: integer);
begin
  if(num < min)then
    min:= num;  
end;

// function valorMinimo(L: lista;min: integer): integer;
// // var
//   // min: integer;
// begin
//   // min:= 999;
//   if(L<> nil)then
//     begin
//       valorMinimo(L^.sig,min);
//       sacarUnMinimo(min,L^.dato);
//       // valorMinimo(L^.sig,min);
//     end; 
//   valorMinimo:= min; 
// end;

// function valorMinimo(L: lista): integer;
// begin
//   if L = nil then
//     valorMinimo := 999  // Devolver un valor alto si la lista está vacía
//   else
//   begin
//     if L^.dato < valorMinimo(L^.sig) then
//       valorMinimo := L^.dato
//     else
//       valorMinimo := valorMinimo(L^.sig);
//   end;
// end;

// procedure valorMinimo(L: lista;var min: integer);


// begin
//   if(L <> nil)then
//     begin
//       sacarUnMinimo(min,L^.dato);
//       valorMinimo(L^.sig,min);
//     end;
// end;

procedure imprimirLista(L: lista);
begin
  While L <> nil do
    begin
      Writeln(' ',L^.dato);
      L:= L^.sig;
    end;  
end;

procedure sacarMinimo(num: integer; var max: integer);
begin
  if(num > max)then
    max:= num;  
end;

procedure valorMaximo(L: lista;var max: integer);

begin
  if(L<>nil)then
    begin
      sacarMinimo(L^.dato,max);
      valorMaximo(L^.sig,max);
    end;
end;

function busquedaLista(L: lista; numBuscado: integer): Boolean;

begin
  // if(L <> nil)then
  //   begin
  //     if{(L <> nil) and} (L^.dato <> numBuscado )then  
  //       busquedaLista(L^.sig,numBuscado)
  //     else
  //       busquedaLista:= true;
  //   end;
  //   busquedaLista:= false;
  IF(L <> nil)then
    begin
      if(L^.dato = numBuscado)then
        busquedaLista:= true
      else
        busquedaLista:=busquedaLista(L^.sig,numBuscado);
    end
  else
    busquedaLista:= false;
end;

var
  L,Ult: lista;
  min: integer;
  max: integer;
  numBuscado: integer;
begin
  randomize;
  inicializarLista(L);
  cargarEstructura(L,Ult);
  imprimirLista(L);
  min:= 999;
  valorMinimo(L,min);
  Writeln('El valor minimo de la lista es: ',min);
  max:= -999;
  valorMaximo(L,max);
  Writeln('El valor maximo en la lista es: ',max);

  Writeln('Ingrese el numero buscado ');
  readln(numBuscado);
  if(busquedaLista(L,numBuscado))then
    Writeln('Se encontro el numero buscado ')
  else
    Writeln('error');
end.