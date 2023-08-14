{Escribir un programa que: 
a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol 
binario de búsqueda. De cada socio se lee número de socio, nombre y edad. La lectura finaliza 
con el número de socio 0 y el árbol debe quedar ordenado por número de socio. 
b.  Una  vez  generado  el  árbol,  realice  módulos  independientes  que  reciban  el  árbol  como 
parámetro y que :  
i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que 
retorne dicho valor. 
ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un 
módulo recursivo que retorne dicho socio. 
iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que 
retorne dicho valor. 
iv. Aumente en 1 la edad de todos los socios. 
v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a 
un módulo recursivo que reciba el valor leído y retorne verdadero o falso. 
vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a 
un módulo recursivo que reciba el nombre leído y retorne verdadero o falso. 
vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha 
cantidad. 
viii. Informe el promedio de edad de los socios. Debe invocar a un módulo recursivo que 
retorne dicho promedio. 
ix. Informe, a partir de dos valores que se leen, la cantidad de socios en el árbol cuyo 
número de socio se encuentra entre los dos valores ingresados. Debe invocar a un módulo 
recursivo que reciba los dos valores leídos y retorne dicha cantidad. 
x. Informe los números de socio en orden creciente.  
xi. Informe los números de socio pares en orden decreciente. }

program ejercicio1;



type
  arbol = ^nodo;
  
  nodo = record
    dato: integer;
    hi: arbol;
    hd: arbol;
  end;

procedure inicializarArbol(var a: arbol);
begin
  a:= nil;  
end;

procedure cargarArbol(var a: arbol; num: integer);
begin
  if( a = nil)then  //si es el primer el elemento o se crea un nuevo nodo
    begin
      new(a); //creo el MAIN (en la primera iteracion) / despues crea el Main de los nodos
      a^.dato:= num;
      a^.hi:= nil;
      a^.hd:= nil;
    end
  else
    if( num < a^.dato)then
      cargarArbol(a^.hi,num)
    else
      cargarArbol(a^.hd,num);
end;

procedure imprimir(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimir(a^.hi);
      Writeln(a^.dato);
      imprimir(a^.hd);
    end;  
end;

var
  a: arbol; 
  n: integer;
begin
  inicializarArbol(a);
  Writeln('Ingrese un numero: ');
  readln(n);
  While(n <> 0)do
    begin
      cargarArbol(a,n);
      Writeln('Ingrese un numero: ');
      readln(n);
    end;
  imprimir(a);
end.