<h1 align="center"> Estructuras a mano </h1>

```pas
  //uso del randomize
  programa principal

  randomize;


  variable:= random(10) = genera numeros random del 0 al 9
  variable:= random(10)+1 = genera numeros random del 0 al 10
  variable:= random(11)-1 = genera numeros random del -1 al 10
  
```

<h2 align="center">moduloDebugArbolRecursiono</h2>

```pas

  program moduloDebugArbolRecursion;
  
  type
  	arbol = ^nodo;
  	
  	nodo = record
  		dato: integer;
  		hi: arbol;
  		hd: arbol
  	end;
  	
  procedure inicializarLista(var L: arbol);
  begin
  	L:= nil;
  end;
  	
  procedure cargarArbol(var a: arbol; n: integer);
  begin
  	if(a = nil)then
  		begin
  			new(a);
  			a^.dato:= n;
  			a^.hi:= nil;
  			a^.hd:= nil;
  		end
  	else
  		begin
  			if(n < a^.dato) then
  				cargarArbol(a^.hi,n)
  			else
  				if(n > a^.dato)then
  					cargarArbol(a^.hd,n);
  		end;
  end;
  
  procedure cuantosEntreRango(a: arbol;izquierda,derecha: integer;var cantCumplen: integer);
  begin
  	// if(a^.dato.numSocio = derecha)then //termina cuando llego al limite superior
  	if(a <> nil)then
  begin     
    if( a^.dato> izquierda ) and (a^.dato < derecha) then  //el actual no es menor al limite inferior
      begin
  			cuantosEntreRango(a^.hi,izquierda,derecha,cantCumplen);
  			cuantosEntreRango(a^.hd,izquierda,derecha,cantCumplen);
  			// if( a^.dato.numSocio > izquierda ) and (a^.dato.numSocio < derecha) then
  			//if( a^.dato > izquierda ) and (a^.dato < derecha) then
  			cantCumplen:= cantCumplen+1;
  				//en teoria cuando este aca, voy a estar parado en la pos q queria         
  		end;
  end
  
  end;
  
  procedure imprimirArbolInOrder(a: arbol);
  begin
  	if(a <> nil)then
  		begin
  			imprimirArbolInOrder(a^.hi);
  			Writeln('In order: ',a^.dato);
  			imprimirArbolInOrder(a^.hd);
  		end;
  end;
  
  var 
    L: arbol;
    num: integer;
    a,b: integer;
    cantCumplen: integer;
  begin
    randomize;
    inicializarLista(L);
    Writeln('Ingresa un numero');
    readln(num);
    While(num <> 0)do
  		begin
  			cargarArbol(L,num);
  			Writeln('Ingresa un numero');
  			readln(num);
  		end;
  	imprimirArbolInOrder(L);
  	Writeln('ingrese a: ');
  	readln(a);
  	Writeln('Ingrese b: ');
  	readln(b);
  	cantCumplen:= 0;
  	cuantosEntreRango(L,a,b,cantCumplen);
  	Writeln('cantidad q cumplen: ',cantCumplen);
  end.

```

<h2 align="center">moduloDebugListaRecursion</h2>

```pas
program moduloDebugListaRecursion;

type
  lista = ^nodo;
  
  nodo = record
    dato: integer;
    sig: lista;
  end;
  
procedure agregarAdelante(var L: lista; n: integer);
var
  nue: lista;
begin
  new(nue);
  nue^.dato:= n;
  nue^.sig:= L;
  L:= nue;
end;
//busca max, en una lista de manera recursiva
function buscarMaximo(L: lista; max: integer): integer;  //max lo pasas en 0
begin
  if(L = nil)then
    buscarMaximo:= max
  else
    begin
      if(L^.dato > max)then
        max:= L^.dato;
      buscarMaximo:= buscarMaximo(L^.sig,max);
    end;
end;

var
  L: lista;
  num, max: integer;
begin
  L:= nil;
  Writeln('Ingrese un numero: ');
  readln(num);
  While(num <> 0)do
    begin
      agregarAdelante(L,num);
      Writeln('Ingrese un numero: ');
      readln(num);
    end;
  max:= 0;
  Writeln('El numero maximo en la lista es: ',buscarMaximo(l,max));
end.

```
