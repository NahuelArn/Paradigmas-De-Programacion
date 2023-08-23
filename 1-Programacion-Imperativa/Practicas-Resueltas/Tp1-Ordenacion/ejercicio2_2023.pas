{2.- Implementar un programa que procese información de propiedades que están a la venta
en una inmobiliaria.
Se pide:
a) Implementar un módulo para almacenar en una estructura adecuada, las propiedades
agrupadas por zona. 

Las propiedades de una misma zona deben quedar almacenadas
ordenadas por tipo de propiedad. Para cada propiedad debe almacenarse el código, el tipo de
propiedad y el precio total.

 De cada propiedad se lee: zona (1 a 5), código de propiedad, tipo
de propiedad, cantidad de metros cuadrados y precio del metro cuadrado. La lectura finaliza
cuando se ingresa el precio del metro cuadrado -1.

b) Implementar un módulo que reciba la estructura generada en a), un número de zona y un tipo de  // en esta parte tenes que generar una nueva lista con estos datos
propiedad y retorne los códigos de las propiedades de la zona recibida y del tipo recibido. }

program ejercicio2_2023;

const
  dimF5 = 5;
type

  rango5 = 1..dimF5;

  propiedad = record
    zona: rango5;
    codPropiedad: integer;
    tipoDePropiedad: integer;
    cantMts2: integer;
    precioMts2: real;
  end;
  
  {propiedad = record // quedarme con esto
    codPropiedad: integer;
    tipoPropiedad: integer;
    precioTotal: real;  //cantMt2*precioMt2;
  end;}

  estructuraAretornar = record  // 
    codPropiedad: integer;
    tipoPropiedad: integer;
  end;

  lista = ^nodo;

  nodo = record
    dato: propiedad;
    sig: lista;
  end;
    
  vPropiedades = array[rango5]of lista;

procedure inicializarLista(var L: lista);
begin
  L:= nil;
end;

procedure inicializarListaALL(var vProp: vPropiedades);
var 
  i: integer;
begin
  for i:= 1 to dimF5 do
    inicializarLista(vProp[i]);
end;

procedure leerPropiedad(var p: propiedad);
begin
  Writeln('Ingrese la zona: ');
  p.zona:= random(5)+1; //genera un numero de 1 a 5
  Writeln('Ingrese el codigo de la propiedad: ');
  p.codPropiedad:= random(200);//numeros random de 0 a 200
  Writeln('Ingrese el tipo de propiedad: '); //debe ser un tipo categorias // 1:amueblado, 2: sin muebles etc etc
  p.tipoDePropiedad:= random(6);
  Writeln('Ingrese la cantidad de mts2 ');
  p.cantMts2:= random(15);
  Writeln('Ingrese el precio del mtr2 ');
  p.precioMts2:= random(5000)-1;
end;

procedure insertarOrdenado(var l: lista; p: propiedad);
var
  nue: lista;
  ant,act: lista;
begin
  ant:= l;
  act:= l;
  new(nue);
  nue^.dato:= p;
  While(act <> nil) and ( p.tipoDePropiedad > act^.dato.tipoDePropiedad )do
    begin
      ant:= act;
      act:= act^.sig;
    end;
  if(act = ant)then
    L:= nue
  else
    ant^.sig:= nue;
  nue^.sig:= act;
end;

procedure cargarPropiedades(var vProp: vPropiedades);
var
  p: propiedad;
begin
  leerPropiedad(p);
  While(p.precioMts2 <> -1)do
    begin
      insertarOrdenado(vProp[p.zona],p);
      leerPropiedad(p);
    end;
end;

//el tema de retonar esta raro// preguntar
procedure buscarEnZona(L: lista; tipoProp:integer);

begin
  While(L <> nil)do //ya estamos en X zona
    begin
      if(L^.dato.tipoDePropiedad = tipoProp)then  //ahora buscamos por el tipo de zona, ya que esta ordenado tengo q buscar la primera ocurrencia
        begin
          While(L <> nil) and (L^.dato.tipoDePropiedad = tipoProp)do
            begin
              Writeln('Codigos: ',L^.dato.codPropiedad);
              L:= L^.sig;
            end;
        end
      else
        L:= L^.sig;
    end;
end;

procedure filtrarPropiedad(v: vPropiedades; numZona: rango5; tipoProp: integer);

begin
  buscarEnZona(v[numZona],tipoProp);
end;

var
  vProp: vPropiedades;
  numZona: rango5;
  tipoPropiedad: integer;
begin
  randomize;
  inicializarListaALL(vProp);
  cargarPropiedades(vProp);

{b) Implementar un módulo que reciba la estructura generada en a), un número de zona y un tipo de
propiedad y retorne los códigos de las propiedades de la zona recibida y del tipo recibido.}
  Writeln('Ingrese un numero de zona: ');
  readln(numZona);
  Writeln('Ingrese un tipo de propiedad: ');
  readln(tipoPropiedad);
  filtrarPropiedad(vProp,numZona,tipoPropiedad);
end.