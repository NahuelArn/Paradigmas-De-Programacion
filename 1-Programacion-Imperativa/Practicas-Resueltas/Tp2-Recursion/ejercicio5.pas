{
Implementar  un  módulo  que  realice  una  búsqueda  dicotómica  en  un  vector,  utilizando  el 
siguiente encabezado: 
    Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice); 
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra 
en el vector.  
}

program ejercicio5;

const
  dimF = 3;
type
  vectorRandom = array[1..dimF]of integer;

procedure cargarVector(var v: vectorRandom);
var 
  i: integer;
begin
  for i:= 1 to dimF do
    begin
      Writeln('Ingrese un valor');
      readln(v[i]); 
    end;
    // v[i]:= random(21); //carga numeros random de 0 a 20
    
end;

function busquedaDicotomica(v: vectorRandom; numBuscado: integer; dimL: integer):integer;
var
  ini,mitad,fin: integer;
  pos: integer;
begin
  pos:= -1;
  ini:= 1;
  fin:= dimL;
  While((ini <= fin) and (pos = -1))do
    begin
      mitad:= (ini+fin) div 2;
      if(v[mitad] = numBuscado)then
        pos:= mitad
      else
        if(numBuscado < v[mitad])then
          fin:= mitad-1
        else
          if(numBuscado > v[mitad])then
            ini:= mitad+1;
    end;
    busquedaDicotomica:= pos;
end;

var
  vR: vectorRandom;
  numBuscado: integer;
  pos: integer;
begin
  randomize;
  cargarVector(vR);
  Writeln('Ingrese el numero ha buscar en el vector ');
  readln(numBuscado);
  pos:=  busquedaDicotomica(vR,numBuscado,dimF);
  if (pos <> -1)then
    Writeln('El valor buscado se encuentra en la pos: ',pos,' y contiene el valor: ',vR[pos])
  else
    Writeln('No se encontradaba en el vector el elemento ');
end.

// {
// Implementar  un  módulo  que  realice  una  búsqueda  dicotómica  en  un  vector,  utilizando  el 
// siguiente encabezado: 
//     Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice); 
// Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra 
// en el vector.  
// }

// program ejercicio5;

// const
//   dimF = 3;
// type
//   vectorRandom = array[1..dimF]of integer;

// procedure cargarVector(var v: vectorRandom);
// var 
//   i: integer;
// begin
//   for i:= 1 to dimF do
//     begin
//       Writeln('Ingrese un valor');
//       readln(v[i]); 
//     end;
//     // v[i]:= random(21); //carga numeros random de 0 a 20
    
// end;

// function busquedaDicotomica(v: vectorRandom; numBuscado: integer; dimL: integer):integer;
// var
//   ini,mitad,fin: integer;
//   pos: integer;
// begin
//   pos:= -1;
//   ini:= 1;
//   fin:= dimL;
//   While((ini <= fin) and (v[pos] <> numBuscado))do
//     begin
//       mitad:= (ini+fin) div 2;
//       if(v[mitad] = numBuscado)then
//         pos:= mitad
//       else
//         if(numBuscado < v[mitad])then
//           fin:= mitad-1
//         else
//           if(numBuscado > v[mitad])then
//             ini:= mitad+1;
//     end;
//     busquedaDicotomica:= pos;
// end;

// var
//   vR: vectorRandom;
//   numBuscado: integer;
//   pos: integer;
// begin
//   randomize;
//   cargarVector(vR);
//   Writeln('Ingrese el numero ha buscar en el vector ');
//   readln(numBuscado);
//   pos:=  busquedaDicotomica(vR,numBuscado,dimF);
//   if (pos <> -1)then
//     Writeln('El valor buscado se encuentra en la pos: ',pos,' y contiene el valor: ',vR[pos])
//   else
//     Writeln('No se encontradaba en el vector el elemento ');
// end.