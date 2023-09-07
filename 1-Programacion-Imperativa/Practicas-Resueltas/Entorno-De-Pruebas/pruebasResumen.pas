program pruebasResumen;

type

  vector = array[1..10]of integer;

  lista = ^nodo;

  nodo = record
    dato: integer;
    sig: lista;
  end;

procedure cargarVector(var v: vector);
var
  i: integer;
begin
  for i:= 1 to 10 do
    v[i]:= random(11)+1;
end;


procedure incrementarVector(var v: vector;dimL: integer; i: integer);
begin
  if( i <= dimL)then  
    begin
      incrementarVector(v,dimL,i+1);
      v[i]:= v[i]+1;      
    end;
end;

procedure imprimirVector(v: vector);
var
  i: integer;
begin
  for i:= 1 to 10 do
    Writeln('En la pos: ',i,' hay: ',v[i]);
end;

procedure imprimirLista(L: lista);
begin
  if(L <> nil)then
    begin
      imprimirLista(L^.sig);
      Writeln('Lo que hay en la lista ',L^.dato);
    end;
end;


// procedure imprimirLista(L: lista);
// begin
//   if(L <> nil)then
//     begin
//       Writeln('Lo que hay en la lista ',L^.dato);
//       imprimirLista(L^.sig);
//       //  Writeln('Lo que hay en la lista ',L^.dato);
//     end;
// end;

//usando un agregarAdelante con recursion nos queda un agregarAtras
// procedure CargarLista (var l: lista);
// var 
//   numero: integer;
//   nuevo: lista;
// Begin
//   write ('Ingrese un numero: ');
//   readln(numero);  
//   if (numero <> -1 )  then 
//     begin
//       CargarLista (l);
//       new (nuevo);
//       nuevo^.dato:= numero;
//       nuevo^.sig:= l;
//       l:= nuevo;   
//     end
//   else 
//     l:= nil
// End;

//usando un agregarAdelante con recursion nos queda un agregarAdelante
procedure CargarLista (var l: lista);
var 
  numero: integer;
  nuevo: lista;
Begin
  write ('Ingrese un numero: ');
  readln(numero);  
  if (numero <> -1 )  then 
    begin
        new (nuevo);
        nuevo^.dato:= numero;
        nuevo^.sig:= l;
        l:= nuevo;
        CargarLista (l);
    end;
End;

// procedure busquedaDicotomicaRecursiva (v: vector ; ini: integer ; fin: integer ; valorBuscado: integer ; var pos: integer;var encontrado:Boolean);
// var
//   mid: integer;
// begin
//   if (ini > fin) then
//     pos:= -1
//   else
//     begin
//       mid:= (ini + fin) div 2;
//       if (valorBuscado = v[mid]) then
//         begin
//           pos:= mid;
//           encontrado:= true;
//         end
//       else
//         begin
//           if (valorBuscado < v[mid]) then
//             busquedaDicotomicaRecursiva(v, ini, (mid - 1), valorBuscado, pos,encontrado)
//           else
//             busquedaDicotomicaRecursiva(v, (mid + 1), fin, valorBuscado, pos,encontrado);
//         end;
//     end;
// end;


procedure imprimirPreOrden(a: arbol);
begin
  if(a <> nil)then
    begin
      Writeln('PreOrden: full izquierda, full Derecha(extremos)',a^.dato);
      imprimirPreOrden(a^.hi);
      imprimirPreOrden(a^.hd);
    end;
end;

procedure imprimirInOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirInOrder(a^.hi);
      Writeln('In Order: de menor a mayor',a^.dato);
      imprimirInOrder(a^.hd);
    end;
end;
//espejo
procedure imprimirInOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirInOrder(a^.hd);
      Writeln('In Order: de mayor a menor',a^.dato);
      imprimirInOrder(a^.hi);
    end;
end;


procedure imprimirPosOrder(a: arbol);
begin
  if(a <> nil)then
    begin
      imprimirPosOrder(a^.hi);
      imprimirPosOrder(a^.hd);
      Writeln('PosOrder: full derecha, full izquierda(extremos)',a^.dato);
    end;
end;



procedure Borrar(x: elem; var a: arbol; var ok: boolean);
var
  aux: arbol;
begin
  if (a = nil) then
    ok := false
  else 
    begin
      if (x < a^.dato) then	// BUSCO EN EL SUBARBOL IZQUIERDO
        Borrar (x, a^.HI, ok)
      else
        begin
          If (x > a^.dato) then	// BUSCO EN EL SUBARBOL DERECHO
            Borrar (x, a^.HD, ok)
          else 
            begin
              ok := true;
              if (a^.HI = nil) then 
                begin				// SOLO HIJO A DERECHA
                  aux := a;
                  a := a^.HD;
                  dispose(aux)
                end
              else
                if (a^.HD = nil) then 
                  begin		// SOLO HIJO A IZQUIERDA
                    aux := a;
                    a := a^.HI;
                    dispose(aux)
                  end
                else 
                  begin		// DOS HIJOS. REEMPLAZO CON EL MENOR DE LA DERECHA
                    aux := Minimo(a^.HD);
                    a^.dato = aux^.dato;
                    Borrar(a^.dato, a^.HD, ok);
                  end
                end
            end;
        
    end;
end;



procedure generarEstante(var L: lista);
var
  car: string;
begin
  Writeln('Ingrese algo (sarasa para para cortar) ');
  readln(car);
  while (car <> 'sarasa') do
  begin
  	agregarAtras(L, car);
  	Writeln('Ingrese algo ');
  	readln(car);
	end;
end;


procedure minimo(var E1,E2:lista; var min:string);
begin
  min := 'zzz';
  if (E1 <> nil) and (E2 <> nil) then
    begin
      if (E1^.dato <= E2^.dato) then
        begin
          min:= E1^.dato;
          E1:= E1^.sig;
        end
      else
        begin
          min:= E2^.dato;
          E2:= E2^.sig;
        end;
    end
  else 
    if (E1 <> nil) and (E2 = nil) then
      begin
        min:= E1^.dato;
        E1:= E1^.sig;
      end 
    else 
      if (E1 = nil) and (E2 <> nil) then
        begin
          min:= E2^.dato;
          E2:= E2^.sig; 
      end;
end;


procedure merge (E1,E2:lista; var Enuevo:lista);
var 
  min: string;
begin
  Enuevo:= nil;
  minimo (E1,E2,min);
  while (min <> 'zzz') do
    begin
      agregarAtras (Enuevo,min);
      minimo (E1,E2,min);
    end;
end; 


var
  i: integer;
  dimL: integer;
  v: vector;
  l: lista;
begin
  // i:= 0;
  // randomize;
  // cargarVector(v);
  // imprimirVector(v);
  // Writeln(); Writeln();
  // dimL:= 10;
  // i:= 1;
  // incrementarVector(v,dimL,i);
  // imprimirVector(v);
  l:= nil;
  randomize;
  cargarLista(l);
  imprimirLista(L);
end.