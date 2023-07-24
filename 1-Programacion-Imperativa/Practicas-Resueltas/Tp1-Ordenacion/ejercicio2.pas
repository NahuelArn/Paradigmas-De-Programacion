{2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de 
las expensas de dichas oficinas.  
Implementar un programa modularizado que: 
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina se 
ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura finaliza 
cuando se ingresa el código de identificación -1, el cual no se procesa. 
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la oficina. 
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.}

program ejercicio2;
const
  dimFedificio = 300;
type
  oficina = record
    codIdentificacion: integer;
    dniPropietario: integer;
    valorExpensa: real;
  end;

  vEdificio = array[1..dimFedificio]of oficina; 

procedure leerDatos(var o: oficina);
begin
  // Writeln('Ingrese el cod de identificacion');
  o.codIdentificacion:= random(403)-1; //dice codigo de identificacion no tiene porq ser de 1..300
  // Writeln('Ingrese el dni del propietario ');
  o.dniPropietario:= random(1000);
  // Writeln('Ingrese el valor de las expensa ');
  o.valorExpensa:= random(500);
  {readln(o.codIdentificacion);
  readln(o.dniPropietario);
  readln(o.valorExpensa);}
end;

procedure cargarVector(var v: vEdificio; var dimL: integer);
var
  o: oficina;
begin
  dimL:= 0;
  leerDatos(o);
  While (dimL < dimFedificio) and (o.codIdentificacion <> -1) do
    begin
      dimL:= dimL+1;
      v[dimL]:= o;
      leerDatos(o); 
      // Writeln('Prueba randomize',i); Joya
    end;
end;

procedure ordenarVectorPorSeleccion(var v: vEdificio; dimL: integer);
var
  a,b,i: integer;
  min: oficina;
begin
  for i:=  1 to dimL -1 do
    begin
      a:= i;
      for b:= i+1 to dimL do
        begin
          if(v[b].codIdentificacion < v[a].codIdentificacion)then
            a:= b;
        end;
        min:= v[a];
        v[a]:= v[i];
        v[i]:= min;
    end;
end;

procedure ordenarVectorPorInsercion(var v: vEdificio; dimL: integer);
var
  i,b: integer;
  act: oficina;
begin
  for i:= 2 to dimL do
    begin
      act:= v[i];
      b:= i-1;
      While( b > 0) and (v[b].codIdentificacion > act.codIdentificacion) do
        begin
          v[b+1]:= v[b];
          b:= b-1;
        end;
        v[b+1]:= act;
    end;
end;

var
  v: vEdificio;
  dimL: integer;
begin
  randomize;
  cargarVector(v,dimL);
  ordenarVectorPorSeleccion(v,dimL);
  ordenarVectorPorInsercion(v,dimL);
end.