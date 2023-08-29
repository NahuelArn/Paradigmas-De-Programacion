{Se desea procesar la información de las ventas de productos de un comercio (como máximo
50).
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce el
día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).
b. Un módulo que muestre el contenido del vector resultante del punto a).
c. Un módulo que ordene el vector de ventas por código.
d. Un módulo que muestre el contenido del vector resultante del punto c).
e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.
f. Un módulo que muestre el contenido del vector resultante del punto e).
g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
h. Un módulo que muestre la información obtenida en el punto g)}

program ejercicio1_2023;

const
  dimF31 = 31;
  dimF50 = 50;
type
  rango15 = 1..15;
  rango31 = 1..31;
  rango99 = 1..99;
  
  venta = record
    dia: rango31;
    codProducto: rango15;
    cantVendida: rango99;
  end;

  vectorVentas = array[1..dimF50]of venta;
  
  //----------------------------------------
 // codPar = record
 //   dia: rango31;
 //   codProducto: rango15;
 //   cantVendida: rango99;
 // end;
  
  listaCodPar  = ^nodoCodPar;
  
  nodoCodPar = record
   // dato: codPar;
    dato: venta;
    sig: listacodPar ;
  end;
  
  estructuraAretornar = record
    ventaMismoCodigo: listacodPar ;
    totalProductosVendidos: integer;
  end;
  
  listaAretornar = ^nodoAretornar;
  
  nodoAretornar = record
    dato: estructuraAretornar;
    sig: listaAretornar;
  end;
  
  //----------------------------------------
  
procedure leerVenta(var v: venta);
begin
  Writeln('dia: ' );
  v.dia:= random(31)+1;  //corte con 0, no se procesa
  Writeln('codProducto: ');
  v.codProducto:= random(16)+1;
  Writeln('cant vendida: ');
  v.cantVendida:= random(100)+1;
end;

procedure cargarVectorVentas(var v: vectorVentas; var dimL: integer);
var
  vent: venta;
begin
  dimL:= 0;
  leerVenta(vent);
  While (dimL < dimF50) and (vent.dia <> 0)do
    begin
      dimL:= dimL+1;
      v[dimL]:= vent;
      leerVenta(vent);
    end;
end;

procedure informarCampos(v: venta);
begin
  Writeln('dia: ',v.dia);
  Writeln('codProducto: ',v.codProducto);
  Writeln('cant vendida: ',v.cantVendida);
end;

procedure imprimirVector(v: vectorVentas; dimL: integer);
var
  i: integer;
begin
  if(dimL = 0)then
    Writeln('Lista vacia')
  else
    begin
      for i:= 1 to dimL do
        begin
          informarCampos(v[i]);
        end;
    end;
end;

//criterio de orden: codigo de producto
procedure ordenarSeleccion(var v: vectorVentas; dimL: integer);
var
  a,b,i: integer;
  min: venta;
begin
  for i:= 1 to dimL-1 do
    begin
      a:= i;
      for b:= i+1 to dimL do
        begin
          if(v[b].codProducto < v[a].codProducto)then
            a:= b;
          min:= v[a]; //agarro el minimo
          v[a]:= v[i]; //swap intercambop
          v[i]:= min; // tiro el minimo al principio
        end;
    end;
end;

//no se evalua que la pos, q sea > 0 and pos <= dimL         
procedure eliminarV(var v: vectorVentas; var dimL: integer; izquierda: integer);
var
  i: integer;
begin
  for i := izquierda to dimL-1 do
    begin
      v[i]:= v[i+1];
    end;
  dimL:= dimL-1;
end;

procedure eliminarEntreRangos(var v: vectorVentas; var dimL: integer; izquierda,derecha: integer);
begin
  izquierda:= izquierda+1;
  derecha:= derecha+1;
  While(izquierda < dimL)do
    begin
      eliminarV(v,dimL,izquierda);
      izquierda:= izquierda+1;
    end;
end;

procedure inicializarLista(var L:listaAretornar);
begin
  L:= nil;
end;

procedure agregarAtras(var L,Ult: listaCodPar; v: venta);
var
  nue: listaCodPar;
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

procedure agregarAtras2(var L,Ult: listaAretornar; v: estructuraAretornar);
var
  nue: listaAretornar;
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

 
procedure generarEstructura(var L: listaAretornar;v: vectorVentas; dimL: integer);
var
  i: integer;
  codActual: integer;
  ventasMismoProducto: estructuraAretornar ;  //registro con lista
  auxConTotalVentas: integer;
  Ult: listaCodPar;
  Ult2: listaAretornar;
begin
  i:= 1;
  While (i < dimL)do
    begin
      // i:= i+1;
      codActual:= v[i].codProducto;
      auxConTotalVentas:= 0;
      if(codActual mod 2 = 0)then
        begin
          ventasMismoProducto.ventaMismoCodigo:= nil;
          While(i < dimL) and (codActual = v[i].codProducto)do
            begin
              auxConTotalVentas:= auxConTotalVentas+ v[i].cantVendida;
              agregarAtras(ventasMismoProducto.ventaMismoCodigo,Ult,v[i]);
              i:= i+1;
            end;
          //salgo de cargar el mismo codigo
          ventasMismoProducto.totalProductosVendidos:= auxConTotalVentas;
          agregarAtras2(L,Ult2,ventasMismoProducto)
        end
      else
        i:= i+1;
    end;
end;

procedure imprimirEstructura(L: listaAretornar);
begin
  While(L <> nil)do
    begin
      Writeln('Cant vendida total: ',L^.dato.totalProductosVendidos);
      L:= L^.sig;
    end;
end;

var
  v: vectorVentas;
  dimL: integer;
  izquierda,derecha: integer;
  L: listaAretornar ;
begin 
  cargarVectorVentas(v,dimL); //a
  
 
  
  imprimirVector(v,dimL);  //b
  
  ordenarSeleccion(v,dimL);  //c
  
  imprimirVector(v,dimL); //d
  Writeln('Ingresa el valor del rango izquierdo ');
  readln(izquierda);
  Writeln('Ingrese el valor del rango derecho ');
  readln(derecha);
  eliminarEntreRangos(v,dimL,derecha,izquierda);  //e
  imprimirVector(v,dimL); //f
  inicializarLista(L);
   
  generarEstructura(L,v,dimL);

  Writeln(); Writeln();
  Writeln('sarasa 0');
  Writeln(); Writeln();
  imprimirEstructura(L);
end.
