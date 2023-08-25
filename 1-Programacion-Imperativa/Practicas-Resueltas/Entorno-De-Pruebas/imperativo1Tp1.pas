{1.-  Implementar  un  programa  que  procese  la  información  de  las  ventas  de  productos  de  un 
comercio (como máximo 20).  
De cada venta se conoce código del producto (entre 1 y 15) y cantidad vendida (como máximo 
99 unidades).  El ingreso de las ventas finaliza con el código 0 (no se procesa). 
a. Almacenar la información de las ventas en un vector. El código debe generarse 
automáticamente (random) y la cantidad se debe leer.  [X]
b. Mostrar el contenido del vector resultante. [X]
c. Ordenar el vector de ventas por código. 
d. Mostrar el contenido del vector resultante. 
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

  //se podria hacer el vector de integer y tomar que cada pos corresponde al cod de producto y en cada pos solo guarda la cantVendida
  vVentas = array[1..dimFCod]of venta; //empieza en 1, porq al ingresar el 0 no voy a evaluarlo

//inicializa  los 2 campos, cod, de 1 a 15 y la cant en 0 
procedure inicializarV(var v: vVentas);
var
  i: integer;
begin
  for i:= 1 to dimFCod do
    begin
      v[i].codProducto:= i; //asi se carga una unica vez
      v[i].cantVent:= 0;
    end;
end;

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
      Writeln('Ingrese la cantidad vendida ');
      readln(v.cantVent);
    end;
end;
//solo asigna a los campos de array la cant, q acaba de leer, los cod ya fueron cargados por pos;
procedure cargarArray(var vv: vVentas; v: venta);
begin
  //aca vas a hacer asignaciones de mas en codProducto, por cada vez q entre va volver a reasignar el mismo cod, pero bue
  // vv[v.codProducto]:= v.codProducto; //solucionado en el modulo de inicializarArray
  vv[v.codProducto].cantVent:= vv[v.codProducto].cantVent + v.cantVent;
end;

procedure cargarVentas(var v: vVentas);
var
  vent: venta;
  i: integer;
begin
  i:= 0;
  leerVenta(vent);
  While(vent.codProducto <> 0) and (i < maxVentas)do  //While el cod 0 de producto no se procesa
    begin
      i:= i+1;  // ventas  de  productos  de  un comercio (como máximo 20)
      cargarArray(v,vent);
      leerVenta(vent);
    end;
end;

procedure imprimirVector(v: vVentas);
var
  i: integer;
begin
  for i:= 1 to dimFCod do
    Writeln('La cantidad de ventas en el cod',i, ' es: ',v[i].cantVent);
end;

var
  v: vVentas;
begin
  randomize;
  inicializarV(v);
  cargarVentas(v);
  //termine de leer
  imprimirVector(v);  //[b]
end.