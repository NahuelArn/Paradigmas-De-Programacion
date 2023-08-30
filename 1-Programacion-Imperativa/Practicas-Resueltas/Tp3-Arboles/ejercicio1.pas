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
  str20 = string[20];

  socio = record
    numSocio: integer;
    nombre: str20;
    edad: integer;
  end;

  arbol = ^nodo;
  
  nodo = record
    dato: socio;
    hi: arbol;
    hd: arbol;
  end;

procedure inicializarArbol(var a: arbol);
begin
  a:= nil;  
end;

procedure leerDatos(var s: socio);
begin
  Writeln('Ingrese el numero de socio: ');
  readln(s.numSocio);
  if(s.numSocio <> 0)then
    begin
      Writeln('Ingrese el nombre del socio: ');
      readln(s.nombre);
      Writeln('Ingrese la edad del socio: ');
      s.edad:= random(21);
      // readln(s.edad);
    end;
end;

procedure cargarArbol(var a: arbol; s: socio);
begin
  if( a = nil)then  //si es el primer el elemento o se crea un nuevo nodo
    begin
      new(a); //creo el MAIN (en la primera iteracion) / despues crea el Main de los nodos
      a^.dato:= s;
      a^.hi:= nil;
      a^.hd:= nil;
    end
  else
    if( s.numSocio < a^.dato.numSocio)then
      cargarArbol(a^.hi,s)
    else  
      if(s.numSocio > a^.dato.numSocio)then //no almacena los numeros de socio repetidos
       cargarArbol(a^.hd,s);
end;

procedure imprimir(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimir(a^.hi);
      Writeln(a^.dato.numSocio);
      Writeln(a^.dato.edad);
      imprimir(a^.hd);
    end;  
end;

{i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que 
retorne dicho valor. }
function numSocioMasGrande(a: arbol;numSocioMax: integer): integer;
begin
  if(a = nil)then
    numSocioMasGrande:= numSocioMax
  else
    begin
      if(a^.dato.numSocio > numSocioMax)then
        numSocioMax:= a^.dato.numSocio;
      numSocioMasGrande:= numSocioMasGrande(a^.hd,numSocioMax);
    end;
end;

{ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un 
módulo recursivo que retorne dicho socio. }
function buscarSocioChico(a: arbol;numSocioMin: integer): arbol;
begin
  if(a = nil)then
    buscarSocioChico:= a
  else
    begin
      if(a^.dato.numSocio < numSocioMin)then
        numSocioMin:= a^.dato.numSocio;
      if(a^.hi= nil)then
        buscarSocioChico:= a
      else
        buscarSocioChico:= buscarSocioChico(a^.hi,numSocioMin);
    end;
end;

procedure informarDatosSocioMasChico(a: arbol);
var
  nodoBuscado: arbol;
  numSocioMin: integer;
begin
  numSocioMin:= 9999;
  nodoBuscado:= buscarSocioChico(a,numSocioMin);
  if(nodoBuscado <> nil)then
    // imprimir()
    begin
      Writeln('num socio: ',nodoBuscado^.dato.numSocio);
      Writeln('nombre socio: ',nodoBuscado^.dato.nombre);
      Writeln('edad socio: ',nodoBuscado^.dato.edad);
    end
  else
    Writeln('Arbol vacio / algun error');
end;

{iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que 
retorne dicho valor. }
function informarNumSocioMayorEdad(a: arbol;maxEdad,numSocio: integer):integer;
begin
  if(a = nil)then
    informarNumSocioMayorEdad:= numSocio
  else
    begin
      if(a^.dato.edad > maxEdad)then
        begin
          maxEdad:= a^.dato.edad;
          numSocio:= a^.dato.numSocio;
        end;
        
      informarNumSocioMayorEdad:= informarNumSocioMayorEdad(a^.hi,maxEdad,numSocio);
      //
      informarNumSocioMayorEdad:= informarNumSocioMayorEdad(a^.hd,maxEdad,numSocio);
    end;
end;

{iv. Aumente en 1 la edad de todos los socios. }
//con un While es directamente un suicidio no? como haces para ir y venir entre ramas
procedure moduloEnvejecedor(a: arbol);
begin
  // While(a <> nil)do 
  if(a <> nil)then
    begin
      a^.dato.edad:= a^.dato.edad +1;
      moduloEnvejecedor(a^.hi);
        //
      moduloEnvejecedor(a^.hd);

    end;
end;

{v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a 
un módulo recursivo que reciba el valor leído y retorne verdadero o falso. }
//no aclara pero supongo que ese valor entero es el numero de socio
function buscarSocio(a: arbol; sb: integer;aux: Boolean): boolean; //socio buscado
begin
  if (a = nil) then
    begin
      buscarSocio:= aux;
    end
  else
    begin
      if(sb = a^.dato.numSocio)then
        aux:= true;
      buscarSocio:= buscarSocio(a^.hi,sb,aux);
      buscarSocio:= buscarSocio(a^.hd,sb,aux);
    end;
end;

{vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a 
un módulo recursivo que reciba el nombre leído y retorne verdadero o falso. 
 }
function recibirNombre(a: arbol;name: string; estado: Boolean):Boolean;
begin
  if(a = nil) or (estado = true )then
    begin
      recibirNombre:= estado;
    end
  else
    begin
      if(a^.dato.nombre = name)then
        estado:= true;
      recibirNombre:= recibirNombre(a^.hi,name,estado);
      recibirNombre:= recibirNombre(a^.hd,name,estado);
    end;
end;

{vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha 
cantidad.}
function cuantosSociosHay(a: arbol;cont:integer): integer; //cada nodo representa a un socio
begin
  if(a = nil)then
    begin
      cuantosSociosHay:= cont;
    end
  else
    begin
      cont:= cont+1;
      cuantosSociosHay:= cuantosSociosHay(a^.hi,cont);
      //
      cuantosSociosHay:= cuantosSociosHay(a^.hd,cont);
    end;
end;

{viii. Informe el promedio de edad de los socios. Debe invocar a un módulo recursivo que 
retorne dicho promedio. }
function promedio(suma,cont: integer): real;
begin
  promedio:= suma/cont;
end;

procedure sumaAndCont(a: arbol;var suma,cont: integer;var prom: real); //retorna la suma de los socios y la cantidad de socios
begin
  if(a = nil)then
    begin
      prom:= promedio(suma,cont);
      // Writeln('el promedio de los socios es: ',promedio(suma,cont));
    end
  else
    begin
      cont:= cont + 1;
      suma:= suma + a^.dato.edad;
      sumaAndCont(a^.hi,suma,cont,prom);
      sumaAndCont(a^.hd,suma,cont,prom);
    end;
end;

{ix. Informe, a partir de dos valores que se leen, la cantidad de socios en el árbol cuyo 
número de socio se encuentra entre los dos valores ingresados. Debe invocar a un módulo 
recursivo que reciba los dos valores leídos y retorne dicha cantidad.}

// procedure buscarEnArbol();
// //nombre del padre e hijo espir
// procedure cuantosEntreRango(a: arbol;izquierda,derecha: integer;var cantCumplen: integer);
// begin
//   // if(a^.dato.numSocio = derecha)then //termina cuando llego al limite superior
//   if(a <> nil)then
//     begin     
//       cantCumplen:= 0;
//     end
//   else
//     begin
//       if( a^.dato.numSocio < izquierda )then  //el actual no es menor al limite inferior
//         begin
//           cuantosEntreRango(a^.hi,izquierda,derecha,cantCumplen);
//           cuantosEntreRango(a^.hd,izquierda,derecha,cantCumplen);
//           //en teoria cuando este aca, voy a estar parado en la pos q queria
//           if(a^.dato.numSocio < derecha)then
//             begin
//               cuantosEntreRango(a^.hd,izquierda,derecha,cantCumplen);
//               cuantosEntreRango(a^.hi,izquierda,derecha,cantCumplen);
//             end;         
//         end;
//     end;
// end;

// //nombre del padre e hijo espir
// procedure cuantosEntreRango(a: arbol;izquierda,derecha: integer;var cantCumplen: integer);
// begin
//   // if(a^.dato.numSocio = derecha)then //termina cuando llego al limite superior
//   if(a <> nil)then
//     begin     
//       if( a^.dato.numSocio < izquierda )then  //el actual no es menor al limite inferior
//         begin
//           cuantosEntreRango(a^.hi,izquierda,derecha,cantCumplen);
//           cuantosEntreRango(a^.hd,izquierda,derecha,cantCumplen);
//           cantCumplen:= cantCumplen+1;
//           //en teoria cuando este aca, voy a estar parado en la pos q queria
//           if(a^.dato.numSocio < derecha)then
//             begin
//               cuantosEntreRango(a^.hd,izquierda,derecha,cantCumplen);
//               cuantosEntreRango(a^.hi,izquierda,derecha,cantCumplen);
//               cantCumplen:= cantCumplen+1;
//             end;         
//         end;
//     end;
// end;

//nombre del padre e hijo espir
procedure cuantosEntreRango(a: arbol;izquierda,derecha: integer;var cantCumplen: integer);
begin
  // if(a^.dato.numSocio = derecha)then //termina cuando llego al limite superior
  if(a <> nil)then
    begin     
      if( a^.dato.numSocio > izquierda ) and (a^.dato.numSocio < derecha) then  //el actual no es menor al limite inferior
        begin
          cuantosEntreRango(a^.hi,izquierda,derecha,cantCumplen);
          cuantosEntreRango(a^.hd,izquierda,derecha,cantCumplen);
          // if( a^.dato.numSocio > izquierda ) and (a^.dato.numSocio < derecha) then
          if( a^.dato.numSocio > izquierda ) and (a^.dato.numSocio < derecha) then
            cantCumplen:= cantCumplen+1;
          //en teoria cuando este aca, voy a estar parado en la pos q queria         
        end;
    end;
end;


var
  a: arbol; 
  s: socio;
  numSocioMax: integer;
  maxEdad,numSocio: integer;
  valorEntero: integer;
  aux: Boolean;
  estado: Boolean;
  name: string;
  cont: integer;  //cont lo voy reutilizando para cada llamado a un modulo
  suma: integer;
  prom: real;
begin
  randomize;
  inicializarArbol(a);
  leerDatos(s);
  While(s.numSocio <> 0)do
    begin
      cargarArbol(a,s);
      leerDatos(s);
    end;
  imprimir(a);
  numSocioMax:= -1;
  Writeln('El numero de socio mas grande es: ',numSocioMasGrande(a,numSocioMax));
  informarDatosSocioMasChico(a);

  //busca y retonar al socio con mayor edad/ tengo que recorrer todo el arbol
  maxEdad:= -999;
  numSocio:= 0;
  Writeln('El numero de socio con mayor edad es: ',informarNumSocioMayorEdad(a,maxEdad,numSocio));

  //
  Writeln('Ingrese un valor entero: ');
  readln(valorEntero);

  aux:= false;
  if(buscarSocio(a,valorEntero,aux))then
    Writeln('Existe en el arbol ')
  else
    Writeln('Ocurrio algun error');
  
//
  Writeln('Ingrese el nombre del socio a buscar: ');
  readln(name);
  estado:= false;
  if(recibirNombre(a,name,estado))then
    Writeln('el socio: ',name,' se encuentra en la estructura')
  else
    Writeln('Error VI');
  
  cont:= 0;
  Writeln('hay :',cuantosSociosHay(a,cont),' socios');

  //
  suma:= 0;
  cont:= 0;
  sumaAndCont(a,suma,cont,prom);
  Writeln('El promedio de los socios es: ',prom);
  //
  
  
end.