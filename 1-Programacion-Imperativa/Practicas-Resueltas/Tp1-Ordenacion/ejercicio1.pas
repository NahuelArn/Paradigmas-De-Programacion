{1.-  Implementar  un  programa  que  procese  la  información  de  las  ventas  de  productos  de  un 
comercio (como máximo 20).  
De cada venta se conoce código del producto (entre 1 y 15) y cantidad vendida (como máximo 
99 unidades).  El ingreso de las ventas finaliza con el código 0 (no se procesa). 
a. Almacenar la información de las ventas en un vector. El código debe generarse 
automáticamente (random) y la cantidad se debe leer.  [X]
b. Mostrar el contenido del vector resultante. [X]
c. Ordenar el vector de ventas por código.  [x]
d. Mostrar el contenido del vector resultante. [x]
e.  Eliminar  del  vector  ordenado  las  ventas  con  código  de  producto  entre  dos  valores  que  se 
ingresan como parámetros.  
f. Mostrar el contenido del vector resultante. 
g.  Generar  una  lista  ordenada  por  código  de  producto  de  menor  a  mayor  a  partir  del  vector 
resultante del inciso e., sólo para los códigos pares. 
h. Mostrar la lista resultante.}

program ejercicio1;
const
  dimFCod = 15;
  maxVentas = 20;
type
  rango15 = 0..dimFCod;  //empieza en 0 par q entre en el corte
  rango99 = 0..99;  //puede tener 0 ventas

  venta = record
    codProducto: rango15;
    cantVent: rango99;
  end;
  
  lista = ^nodo;  //para el punto G
                  //
  nodo = record   //
    dato: venta;  //
    sig: lista;   //
  end;            //

  vVentas = array[1..maxVentas]of venta; //empieza en 1, porq al ingresar el 0 no voy a evaluarlo

// procedure inicializarV(var v: vVentas);
// var
//   i: integer;
// begin
//   for i:= 1 to maxVentas do
//       v[i].cantVent:= 0;
// end;

//lee los 2 campos, filtra el 0
procedure leerVenta(var v: venta);
var
  codRandom: integer;
begin
  Writeln('El cod del producto se genera de manera random');
  codRandom:= random(dimFCod+1); //genera un codigo entre 0 y 15   //se podria hacer sin usar una variable auxiliar v.codProducto:= random(dimFcod+1)
  if(codRandom <> 0)then
    begin
      v.codProducto:= codRandom;  // y aca te ahorrarias de hacer esto, ya q el condicional te lo valido q sea <> 0
      repeat
      Writeln('Ingrese la cantidad vendida ');
      readln(v.cantVent);
      until (v.cantVent <= 99) and (v.cantVent > -1);  //si entra en el loop es porq estan introduciendo valores mas altos o mas bajos q -1 o 99
    end;
end;


procedure cargarVentas(var v: vVentas; var dimL: integer);
var
  vent: venta;
begin
  dimL:= 0;
  leerVenta(vent);
  While(vent.codProducto <> 0) and (dimL < maxVentas)do  //While el cod 0 de producto no se procesa
    begin
      dimL:= dimL+1;  // ventas  de  productos  de  un comercio (como máximo 20)
      v[dimL]:= vent;
      leerVenta(vent);
    end;
end;

procedure imprimirVector(v: vVentas; dimL: integer);
var
  i: integer;
begin
  for i:= 1 to dimL do
    begin
      Writeln('En la pos',i, ' estan estos datos');
      Writeln('codigo de producto: ',v[i].codProducto);
      Writeln('cantidad vendida: ',v[i].cantVent);
    end;
end;

procedure ordenarVector(var v: vVentas; dimL: integer);
var
  a,b,i: integer;
  min: venta;
begin
  for i:= 1 to dimL-1 do
    begin
      a:= i;
      for b:= i+1 to dimL do
        begin
          if(v[b].codProducto < v[a].codProducto) then
            a:= b;
        end;
        min:= v[a];
        v[a]:= v[i];
        v[i]:= min;
    end;
end;

// function validador(pos,mayorQue,menorQue: integer): Boolean;
// begin
//   validador:= pos > mayorQue and pos < menorQue;  
// end;

procedure pedirPosiciones(var posTop,posBot: integer);


// begin
//   Writeln('Ingrese 2 posiciones, se van a eliminar todas las ventas entre estas posiciones');
//   Writeln('Ingrese la primera posicion');
//   readln(posTop);
//   if(validador(posTop,0,21))then
//     begin
//       Writeln('Ingrese la segunda posicion');
//       readln(posBot);
//       if(validador(posBot,0,21) and  validador(posBot,0,posTop))then
//     end;

begin
  Writeln('Ingrese 2 posiciones, se van a eliminar todas las ventas entre estas posiciones');
  
  // Ingresar la primera posición
  repeat
    Writeln('Ingrese la primera posicion (entre 1 y 20): ');
    readln(posBot);
  until (posBot > 0) and (posBot <= 20);

  // Ingresar la segunda posición
  repeat
    Writeln('Ingrese la segunda posicion (entre 1 y 20): ');
    readln(posTop);
  until (posTop > 0 ) and (posTop <= 20) and (posTop > posBot);
end;
//posBot-----------------posTop
//1 2 3 4 .. 12. 15 18 20

procedure eliminarEnVectorOrdenado(var v: vVentas; var dimL: integer; posBot: integer);
var
  i: integer;
begin
  for i:= posBot to dimL-1 do
    begin
      v[i]:= v[i+1];
    end;
    dimL:= dimL-1;
end;

procedure eliminarEntreRangos(var v: vVentas; var dimL: integer; posTop,posBot: integer);

begin
  posBot:= posBot+1;
  posTop:= posTop-1;
  While posBot < posTop do  //si no entra significa que los 2 valores son iguales top y bot valen lo mismo y no hay nada entre medio para borrar
    begin
      eliminarEnVectorOrdenado(v,dimL,posBot);
      posBot:= posBot+1;
    end;
end;

procedure agregarAtras(var L,Ult: lista; v: venta);
var 
  nue: lista;
begin
  new(nue);
  nue^.dato:= v;
  nue^.sig:= nil;
  if(L = nil)then
    L:= nue
  else
    Ult^.sig:= nue;
  Ult:= nue;

end;

procedure cargarLista(var L: lista; v: vVentas; dimL: integer);
var
  i: integer;
  Ult: lista;
begin
  L:= nil;
  i:= 0;
  While i < dimL do
    begin
      i:= i+1;
      if(v[i].codProducto mod 2 = 0)then
        agregarAtras(L,Ult,v[i]);
    end;
end;

procedure imprimirLista(L: lista);
var
  i: integer;
begin
  i:= 0;
  While (L <> nil )do
    begin
      i:= i+1;
      Writeln('En la pos',i, ' estan estos datos');
      Writeln('codigo de producto: ',L^.dato.codProducto);
      Writeln('cantidad vendida: ',L^.dato.cantVent);
      L:= L^.sig;
    end;  
end;

var
  v: vVentas;
  dimL: integer;
  posTop,posBot: integer;
  L: lista;
begin
  randomize;
  // inicializarV(v);
  cargarVentas(v,dimL);
  //termine de leer
  imprimirVector(v,dimL);  //[b]
  ordenarVector(v,dimL);  //[c]
  imprimirVector(v,dimL); //[d]
  pedirPosiciones(posTop,posBot);
  eliminarEntreRangos(v,dimL,posTop,posBot);  //[e]
  imprimirVector(v,dimL);// [f]
  //en este punto puede generar mi lista con un agregar Atras ya que el vector se encuentra ordenado, seria logica de mas usar un insertarOrdenado
  cargarLista(L,v,dimL);  //[g]
  imprimirLista(L); //[h]
end.































//variacion
{enTornodepruebas}