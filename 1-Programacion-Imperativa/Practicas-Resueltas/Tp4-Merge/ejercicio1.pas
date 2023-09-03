{
* 1.   Una  biblioteca  nos  ha  encargado  procesar  la  información  de  los  préstamos  realizados 
durante cada el año  2021. De  cada préstamo se  conoce el ISBN del libro, el número de socio, 
día y mes del préstamo y cantidad de días prestados. Implementar un programa con: 
a.  Un módulo que lea préstamos y retorne en una estructura adecuada la información de los 
préstamos  organizada  por  mes.  Para  cada  mes,  los  préstamos  deben  quedar  ordenados  por 
ISBN. La lectura de los préstamos finaliza con ISBN -1. 
b.  Un  módulo  recursivo  que  reciba  la  estructura  generada  en  a.  y  muestre,  para  cada  mes, 
ISBN y numero de socio. 
c.  Un  módulo  que  reciba  la  estructura  generada  en  a.  y  retorne  una  nueva  estructura  con 
todos los préstamos ordenados por ISBN. 
d.  Un  módulo  recursivo  que  reciba  la  estructura  generada  en  c.  y  muestre  todos  los  ISBN  y 
número de socio correspondiente. 
e.  Un módulo que reciba la  estructura  generada en  a. y retorne una nueva estructura 
ordenada  ISBN,  donde  cada  ISBN  aparezca  una  vez  junto  a  la  cantidad  total  de  veces  que  se 
prestó durante el año 2021. 
f. Un módulo recursivo que reciba la estructura generada en e. y muestre su contenido.
* }

//a vector[1..12] de listas Con un insertarOrdenado por ISBN  
//b recorrer el vector, cada campo e ir imprimiendo 
//c recibo un vector de listas y devuelvo una lista/ Hago un merge de 12 listas y retorno una sola
//d recorro mi lista nueva y imprimo todo
//e merge acumulador [banco x cada sucursal]
//f recorro toda la lista nueva

program ejercicio1;

const
	dimF12 = 12;
type	
	rango12 = 1..dimF12;
	
	prestamo = record
		isbn: integer;
		numSocio: integer;
		dia: integer;	//estaria para hacer un registro fecha 
		mes: rango12;
	end;
	
	lista = ^nodo;
	
	nodo = record
		dato: prestamo;
		sig: lista;
	end;
	
	vMeses = array[1..dimF12]of lista;

procedure inicializarLista(var L: lista);
begin
	L:= nil;
end;

procedure inicializarVector(var vM: vMeses);
var
	i: rango12;
begin
	for i:= 1 to dimF12 do
		inicializarLista(vM[i]);
end;

//ver data q necesito para debugear [lo cargo a mano] //despues el relleno random
procedure leerPrestamo(var p: prestamo);
begin
	Writeln('Ingrese el isbn (Finaliza con -1 )');
	readln(p.isbn);
	if(p.isbn <> -1)then
		begin
			Writeln('Ingrese el numero de socio ');
			p.numSocio:= random(101);
			Writeln('Ingrese el dia del prestamo');
			p.dia:= random(32)+1;
			Writeln('Ingrese el mes del prestamo ');
			readln(p.mes);
		end;
end;

procedure insertarOrdenado(var L: lista; p: prestamo);
var
	ant,act: lista;
	nue: lista;
begin
	new(nue);
	nue^.dato:= p;
	nue^.sig:= nil;
	ant:= L;
	act:= L;
	While(act <> nil) and (p.isbn > act^.dato.isbn) do
		begin
			ant:= act;
			act:= act^.sig;
		end;
	if(ant = act)then
		L:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;

//criterio  de corte: isbn = -1 | criterio de ordenacion isbn
procedure cargarPrestamos(var vM: vMeses);
var
	p: prestamo;
begin
	leerPrestamo(p);
	While(p.isbn <> -1)do
		begin
			insertarOrdenado(vM[p.mes],p);
			leerPrestamo(p);
		end;
end;

procedure imprimirIsbNumsocio(p: prestamo);
begin
	Writeln('Isbn del socio: ',p.isbn);
	Writeln('numero del socio: ',p.numSocio);
	//Writeln('Isbn del socio: ',p.numSocio, ' es: ',p.isbn);
end;

//isbn y numSocio
procedure imprimirMes(L: lista);
begin
	if(L <> nil)then
		begin
			imprimirIsbNumsocio(L^.dato);
			imprimirMes(L^.sig);
		end;
end;

procedure mostrarVentaMeses(vM: vMeses; i: integer);
begin
	if(i < dimF12)then
		begin	//isbn, numsocio
			i:= i+1;
			Writeln('--------------------------------------------------------------------');
			Writeln('Se van ha imprimir los Isbn y numero de socios del mes: ',i); 
			imprimirMes(vM[i]);
			Writeln('--------------------------------------------------------------------');
			mostrarVentaMeses(vM,i);
		end;
end;



{---------------------------------------}
// Merge de mas de dos listas usando un vector. Guarda el ultimo minimo en cada comparación
// (si existe un dato del mismo tipo) y lo guarda en una lista.

procedure minimo(var v: vMeses; var min: prestamo);
var
	i, pos: integer;
begin
	min.isbn := 9999;		//  "9999" - valor muy alto para encontrar el minimo posible
	pos := -1;			// Flag por si no encontré
  for i := 1 to dimF12 do	{ Recorro el vector de listas }
    begin
      { Si la lista no esta vacia y Si encuentro un dato menor o igual al minimo, actualizo el minimo}
      if (v[i] <> nil) and (v[i]^.dato.isbn <= min.isbn) then 
        begin
          pos := i;							// Guardo el indice actual
          min := v[i]^.dato;		// Actualizo el minimo actual
        end;
    end;
   if (pos <> -1) then	{Si encontré un minimo}
     v[pos] := v[pos]^.sig;				// Paso al siguiente elemento de la lista
end;

procedure agregarAtras(var L, ult:lista ; p:prestamo);
var
	nue:lista;
begin
	new(nue);
	nue^.dato:= p;
	nue^.sig:= nil;
	if (L = nil) then
		L:= nue
	else
		ult^.sig:= nue;
	ult:= nue;
	Writeln('SARASA 3');
end;

procedure generarMerge(vM: vMeses; var  Lnueva: lista);
var
	min: prestamo;
  ult: lista;
begin
	inicializarLista(Lnueva);
	minimo(vM, min);						// Busco un dato minimo entre todas las listas
	Writeln('SARASA 2');
	while (min.isbn <> 9999) do  // Si encontré un minimo | Si es 9999 se terminaron las listas
    begin	
      agregarAtras(Lnueva, ult,min);	// Agrego el nuevo dato minimo a la estructura de datos
      minimo(vM, min);					// Vuelvo a buscar un nuevo dato minimo entre las listas
		end;
end;

{---------------------------------------}

procedure imprimirListaNueva(L: lista);
begin
  while (L <> nil) do
    begin
      imprimirIsbNumsocio(L^.dato);
      L:= L^.sig;
    end;  
end;

var
	vM: vMeses;
	i: integer;
	Lnueva: lista;
begin
	inicializarVector(vM);
	cargarPrestamos(vM);
	i:= 0;
	mostrarVentaMeses(vM,i);
	Writeln('SARASA 0');
	generarMerge(vM,Lnueva);  //Lnueva se crea inicializa dentro del merge
  imprimirListaNueva(Lnueva);
end.
