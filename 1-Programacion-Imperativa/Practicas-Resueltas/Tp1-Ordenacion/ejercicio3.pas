{ Netflix ha publicado la lista de películas que estarán disponibles durante el mes de diciembre 
de 2022. De cada película se conoce: código de película, código de género (1: acción, 2: aventura, 
3:  drama,  4:  suspenso,  5:  comedia,  6:  bélica,  7:  documental  y  8:  terror)  y  puntaje  promedio 
otorgado por las críticas.  
Implementar un programa modularizado que: 
a.  Lea  los  datos  de  películas  y  los  almacene  por  orden  de  llegada  y  agrupados  por  código  de 
género, en una estructura de datos adecuada. La lectura finaliza cuando se lee el código de la 
película -1.  
b. Una vez almacenada la información, genere un vector que guarde, para cada género, el código 
de película con mayor puntaje obtenido entre todas las críticas.
c.  Ordene  los  elementos  del  vector  generado  en  b)  por  puntaje  utilizando  alguno  de  los  dos 
métodos vistos en la teoría.  
d. Luego de ordenar el vector, muestre el código de película con mayor puntaje y el código de 
película con menor puntaje.
}
program ejercicio3;
const
  dimF = 8;
type
  rango8 = 1..dimF;

  pelicula = record
    codPelicula: integer;
    codGenero: rango8;
    puntajePromedio: real;
  end;

  lista = ^nodo;

  nodo = record  
    dato: pelicula;
    sig: lista;
  end;

  // nuevaEstructura = record
  //   codPelicula: integer;
  //   puntaje: real;
  // end;

  vMejoresPuntajes = array[rango8]of pelicula;

procedure inicializarLista(var L: lista);
begin
  L:= nil;  
end;

procedure leerPelicula(var p: pelicula);
begin
  Writeln('Ingrese el codigo de la pelicula ');
  readln(p.codPelicula);
  if( p.codPelicula <> -1)then
    begin
      Writeln('Ingrese el codigo de genero de la pelicula ');
      readln(p.codGenero);
      Writeln('Ingrese el puntaje promedio otorgado por la critica ');
      readln(p.puntajePromedio);
    end;  
end;

procedure insertarOrdenado(var L: lista; p: pelicula);
var 
  ant,act: lista;
  nue: lista;
begin
  new(nue);
  nue^.dato:= p;
  ant:= L;
  act:= L;
  While(act <> nil ) and (p.codGenero > act^.dato.codGenero) do
    begin
      ant:= act;
      act:= act^.sig;
    end;
  if(act = L)then
    L:= act^.sig
  else
    ant^.sig:= nue;
  nue^.sig:= act;  
end;

procedure cargarLista(var L: lista);
var
  p: pelicula;
begin
  leerPelicula(p);
  While(p.codPelicula <> -1)do
    begin
      insertarOrdenado(L,p);
      leerPelicula(p);
    end;  
end;

procedure inicializarV(var v: vMejoresPuntajes);
var
  i: integer;
begin
  for i:= 1 to dimF do
    begin
      v[i].codGenero:= i;
      v[i].codPelicula:= 0;
      v[i].puntajePromedio:= 0
    end;
end;

procedure sacarMax(puntajeActual: real;var maxPuntaje: real; var codPeli: integer; var codPeliActual: integer);
begin
  if(puntajeActual > maxPuntaje)then
    begin
      codPeli:= codPeliActual;
      maxPuntaje:= puntajeActual;
    end;
end;
//ordenado de menor a mayor /  con criterio de puntaje de criticas
procedure ordenarVectorPorSeleccion(var v: vMejoresPuntajes);
var
  a,b,i: integer;
  dimL: integer;
  min: pelicula;
begin
  dimL:= dimF;
  for i:= 1 to dimL-1 do
    begin
      a:= i;
      for b:= i+1 to dimL do
        begin
          if(v[b].puntajePromedio < v[a].puntajePromedio)then
            a:= b;
        end;
      min:= v[a]; //guardo todo el dato, filtrado por el minimo puntaje
      v[a]:= v[i]; //hago el swap
      v[i]:= min; //pongo el minimo al principio
    end;
end;

procedure procesarDatos(L: lista; var v: vMejoresPuntajes;var dimL: integer);
var
  generoActual: rango8;
  max1: real;
  codPeli1: integer;
begin
  dimL:= 0;
  While (L<> nil)do
    begin
      generoActual:= L^.dato.codGenero;
      max1:= -999;
      While (L <> nil ) and (generoActual = L^.dato.codGenero)do
        begin
          sacarMax(L^.dato.puntajePromedio,max1,codPeli1,L^.dato.codPelicula);
          L:= L^.sig;
        end;
      dimL:= dimL+1;  //cada vez q pase por este punto se que pase un codigo de genero
      v[generoActual].codPelicula:= codPeli1;
      v[generoActual].codGenero:= generoActual;
      v[generoActual].puntajePromedio:= max1;
    end;  
    ordenarVectorPorSeleccion(v);
end;

//esto lo puedo hacer ya que lo ordene de menor a mayor, tambien obteniendo una dimL, se que en primero va ser el menor codPuntaje y el ultimo va ser el mayor codPuntaje
procedure mostrarMayorMenorPuntaje(v: vMejoresPuntajes; dimL: integer);
begin
  Writeln('El codigo de pelicula con menor puntaje es: ',v[1].codPelicula);
  Writeln('El codigo de pelicula con mejor puntaje es: ',v[dimL].codPelicula);
end;
var
  L: lista;
  v: vMejoresPuntajes;
  dimL: integer;
begin
  inicializarLista(L);
  cargarLista(L);
  inicializarV(v);
  procesarDatos(L,v,dimL);
  mostrarMayorMenorPuntaje(v,dimL);
end.