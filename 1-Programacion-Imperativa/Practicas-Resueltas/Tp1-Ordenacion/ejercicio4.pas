{Una librería requiere el procesamiento de la información de sus productos. De cada producto 
se conoce el código del producto, código de rubro (del 1 al 8) y precio.  
Implementar un programa modularizado que: 
a. Lea los datos de los productos y los almacene ordenados por código de producto y agrupados 
por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza cuando se 
lee el precio 0. 
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro. 
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que 
puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3 
es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.  
d.  Ordene,  por  precio,  los  elementos  del  vector  generado  en  b)  utilizando  alguno  de  los  dos 
métodos vistos en la teoría.  
e. Muestre los precios del vector ordenado. }

{//0.13
  producto = record
    codProducto = integer;
    codRubro = 1..8
    precio: real;
  end;

  a) "filtrar por codigo de producto y agrupado por cod de rubro", no se sabe la cantidad de productos es una lista
  vector ---> de listas (prodcutos)
  (leo veo q cod de rubro y mando un insertarOrdenado por codigo de producto)
  la lectura finaliza cuando se ingresa el precio 0// while no pueden tener productos con coste 0

  b) imprimo los cod de productos de cada campo
  c) genero un nuevo vector de 1..30, llevando una dimL y mi estructura de datos q consumo va ser los primeros 30 elementos de la lista del campo 3 del vector de listas
  d) ordenar el vector nuevo generado, necesito la dimL para este punto
  e) imprimo los campos "precio" del vector ordenado (Ordenar por precio)
}
program ejercicio4;

const
  dimF8 = 8;
  dimF30 = 30;
type
  rango8 = 1..dimF8;

  producto = record
    codProducto: integer;
    codRubro: rango8;
    precio: real;
  end;

  lista = ^nodo;

  nodo = record
    dato: producto;
    sig: lista;
  end;

  vProductos= array[rango8]of lista;  //vector de listas

  vCategoria3 = array[1..dimF30]of producto;

procedure inicializarVlista(var v: vProductos);
var
  i: integer;
begin
  for i:= 1 to dimF8 do
      v[i]:= nil; 
end;

procedure leerProducto(var p: producto);
begin
  Writeln('Ingrese el precio del producto ');
  readln(p.precio);
  if(p.precio <> 0)then
    begin
      Writeln('Ingrese el cod de producto');
      readln(p.codProducto);
      Writeln('Ingrese el cod de rubro ');
      readln(p.codRubro);
    end;
  // Writeln('Ingrese el precio del producto ');
  // readln(p.precio); ///esto podria pedirlo primero para no procesar data de mas si es 0
end;

procedure insertarOrdenado(var L: lista; p: producto);
var
  ant,act: lista;
  nue: lista;
begin
  new(nue);
  nue^.dato:= p;
  act:= L;
  ant:= L;
  While( act <> nil ) and (p.codProducto > act^.dato.codProducto) do // va quedar de manera ascendente
    begin
      ant:= act;
      act:= act^.sig;
    end;
  if(act = ant)then //primera elemento
    L:= nue
  else
    ant^.sig:= nue;
  nue^.sig:= act;
end;

procedure cargarData(var v: vProductos);
var
  p: producto;
  L: lista;
begin
  inicializarVlista(v);
  leerProducto(p);
  While(p.precio <> 0)do
    begin
      L:= v[p.codRubro];  // en teoria aca estoy filtrando por el cod de rubro y posicionandome en la direccion del ultimo elemento de ese campo
      insertarOrdenado(L,p);
      v[p.codRubro]:= L;  //aca vuelvo a actualizar la direccion del campo, esto se podria simplificar directamente pasandole a insertarOrdenado(v[p.codRubro],p);
      leerProducto(p);
    end;  
end;
//------------------------

procedure imprimirLista(L: lista);
begin
  if(L = nil)then
    Writeln('Lista vacia');
  While( L <> nil)do
    begin
      Writeln('Cod producto ',L^.dato.codProducto);
      Writeln('Cod de rubro ',L^.dato.codRubro);
      Writeln('Precio de producto ',L^.dato.precio);
      L:= L^.sig;
    end;
end;

procedure imprimirVLista(v: vProductos);
var
  i: integer;
begin
  for i:= 1 to dimF8 do
    begin
      imprimirLista(v[i]);
    end;
end;
//------------------------
//cargo mi vector con los productos de una Lista, corta por 2 cuestiones llegue al final de la lista o llegue a mi tope de 30, mantengo una dimL para saber hasta donde se cargo
procedure cargarVectorNuevoCat3(L: lista;var vCat3: vCategoria3; var dimL: integer);
begin
  dimL:= 0;
  While(L <> nil) and (dimL < dimF30) do
    begin
      dimL:= dimL+1;
      vCat3[dimL]:= L^.dato;
      L:= L^.sig;
    end;
end;

procedure ordenarVectorPorSeleccion(var vCat3: vCategoria3; dimL: integer);
var
  a,b,i: integer;
  min: producto;
begin
  for i:= 1 to dimL-1 do
    begin
      a:= i;
      for b:= i+1 to dimL do
        begin
          if(vCat3[b].precio < vCat3[a].precio)then
            a:= b;
        end;
        min:= vCat3[a];
        vCat3[a]:= vCat3[i];
        vCat3[i]:= min;
    end;
end;

procedure imprimirVectorYaOrdenado(v: vCategoria3; dimL: integer);
var
  i: integer;
begin
  for i:= 1 to dimL do
    begin
      Writeln('El precio del campo precio',i, ' es: ',v[i].precio);
    end;
end;

var
  vCat3: vCategoria3;
  v: vProductos;
  dimL: integer;
begin
  cargarData(v);
  imprimirVLista(v);  //Imprime un mensaje de lista vacia, si la categoria no fue usada
  cargarVectorNuevoCat3(v[3],vCat3,dimL);
  ordenarVectorPorSeleccion(vCat3,dimL);
  imprimirVectorYaOrdenado(vCat3,dimL); //se podria implementar dentro del ordenar una vez terminado el orden, no especifica que sea un modulo
end.


//Writeln('Flag1');









































// //variacion hasta el A
// program ejercicio4;

// const
//   dimF8 = 8;
// type
//   rango8 = 1..dimF8;
//   producto = record
//     codProducto: integer;
//     codRubro: rango8;
//     precio: real;
//   end;

//   lista = ^nodo;

//   nodo = record
//     dato: producto;
//     sig: lista;
//   end;

//   vProductos= array[rango8]of lista;  //vector de listas

// procedure inicializarVlista(var v: vProductos);
// var
//   i: integer;
// begin
//   for i:= 1 to dimF8 do
//       v[i]:= nil; 
// end;

// procedure leerProducto(var p: producto);
// begin
//   Writeln('Ingrese el precio del producto ');
//   readln(p.precio);
//   if(p.precio <> 0)then
//     begin
//       Writeln('Ingrese el cod de producto');
//       readln(p.codProducto);
//       Writeln('Ingrese el cod de rubro ');
//       readln(p.codRubro);
//     end;
//   // Writeln('Ingrese el precio del producto ');
//   // readln(p.precio); ///esto podria pedirlo primero para no procesar data de mas si es 0
// end;

// procedure insertarOrdenado(var L: lista; p: producto);
// var
//   ant,act: lista;
//   nue: lista;
// begin
//   new(nue);
//   nue^.dato:= p;
//   act:= L;
//   ant:= L;
//   While( act <> nil ) and (p.codProducto > act^.dato.codProducto) do // va quedar de manera ascendente
//     begin
//       ant:= act;
//       act:= act^.sig;
//     end;
//   if(act = ant)then //primera elemento
//     L:= nue
//   else
//     ant^.sig:= nue;
//   nue^.sig:= act;
// end;

// // procedure imprimirGeneral(p: producto);
// // begin
// //   Writeln('Cod producto ',p.codProducto);
// //   Writeln('Cod de rubro ',p.codRubro);
// //   Writeln('Precio de producto ',p.precio);  
// // end;

// procedure cargarData(var v: vProductos);
// var
//   p: producto;
//   L: lista;
// begin
//   inicializarVlista(v);
//   leerProducto(p);
//   While(p.precio <> 0)do
//     begin
//       L:= v[p.codRubro];  // en teoria aca estoy filtrando por el cod de rubro y posicionandome en la direccion del ultimo elemento de ese campo
//       insertarOrdenado(L,p);
//       v[p.codRubro]:= L;
//       leerProducto(p);
//     end;  
// end;
// //------------------------
//   //modulo debuggin
// // procedure imprimirLista(L: lista);
// // begin
// //   if(L = nil)then
// //     Writeln('Lista vacia');
// //   While( L <> nil)do
// //     begin
// //       Writeln('Por q no imprime?',L^.dato.codProducto);
// //       Writeln('Por q no imprime?',L^.dato.codRubro);
// //       Writeln('Por q no imprime?',L^.dato.precio);
// //       L:= L^.sig;
// //     end;
// // end;

// procedure imprimirLista(L: lista);
// begin
//   if(L = nil)then
//     Writeln('Lista vacia');
//   While( L <> nil)do
//     begin
//       Writeln('Por q no imprime?',L^.dato.codProducto);
//       Writeln('Por q no imprime?',L^.dato.codRubro);
//       Writeln('Por q no imprime?',L^.dato.precio);
//       L:= L^.sig;
//     end;
// end;

// procedure imprimirVLista(v: vProductos);
// var
//   i: integer;
// begin
//   for i:= 1 to dimF8 do
//     begin
//       Writeln('Flag3');
//       imprimirLista(v[i]);
//       Writeln('Flag4');
//     end;
// end;
// //------------------------
// var
//   // L: lista;
//   v: vProductos;
// begin
//   cargarData(v);
//   Writeln('Flag1');
//   imprimirVLista(v);
//   Writeln('Flag2');
// end.