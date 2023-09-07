program rePensandoLaRecursion;

  //1 caso base	
  //1: imprimir Lista normal como estaba cargada
  //
procedure imprimirLista(L: lista);
begin
	if(L <> nil)then
		begin
			Writeln('Imprimiendo lista normal como quedo cargada: 'L^.dato);
			imprimirLista(L^.sig);
		end;
end;
//2: imprimir Lista al revez de como estaba cargada

procedure imprimirLista(L: lista);	//en procedimientos pensarlo como pila (mientrasUses L <> nil)
begin
	if(L <> nil)then
		begin
			imprimirLista(L^.sig);
			Writeln('Imprimiendo lista al revez de como quedo cargada: 'L^.dato);
		end;
end;
//3: funcion que retorne el maximo elemento de una lista de enteros
//pensar en instancias |  espacio tiempo diferentes en cada vuelta con el backtracking
//lo que hagas en ese espacio tiempo va quedar en ese espacio tiempo, a menos que quieras avisar al espacio tiempo que sigue algun dato(se lo podes comunicar)
function numMaximoDeLaLista(L: lista): integer;
var
  max: integer;
begin
	if(L = nil)then
		max:= -1 //llego al final de la lista, ok, toma tu minimo para comparar durante el backtracking
	else
		begin
			max:= numMaximoDeLaLista(L^.sig); //recorro
			Writeln('estas viendo un numero en otro espacio tiempo: ',max);
			if (L^.dato > max) then
        numMaximoDeLaLista := L^.dato   // Si es el mayor se actualiza
      else
        numMaximoDeLaLista := max;   // si no es el maximo le asigno a mi funcion el ultimo valor de max
		end;
end;

//4: funcion que retorne la suma de los elementos de la lista

function sumarElementosDeLista(L: lista): integer;
begin
	if(L = nil)then
		retornarMaximoLista:= 0
	else
		begin
			retornarMaximoLista:= retornarMaximoLista(L^.sig)+L^.dato;
		end;
end;

begin
  

end.