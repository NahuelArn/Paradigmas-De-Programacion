<h1 align="center"> Modulos Recursivos </h1>

<p align="center">Modulo validador para ver si se encuentra un numero en la lista</p>

```pas
  function estaEnLaLista(L: lista; valorBuscado: integer): boolean;
  begin
    if(L = nil) then
      estaEnLaLista:= false
    else
      if(L^.dato = valorBuscado)then
        estaEnLaLista:= true
      else
        estaEnLaLista:= estaEnLaLista(L^.sig,valorBuscado)
  end;

  if(estaEnLaLista(L,buscado))then
      Writeln('valor encontrado ' )
    else
      Writeln('no esta en la lista');

```

<h1 align="center"> Sacar un el digito maximo de un numero</h1>

```pas

  program sarasaRecursion;

  procedure digitoMaximo(n: integer; var max: integer);
  var
    dig: integer;
  begin
    dig:= n mod 10;
    if(dig > max)then
      max:= dig;
    n:= n div 10;
    if( n <> 0)then
      digitoMaximo(n,max);
      Writeln('valor de n 13:  ',n,' valor de dig 2: ',dig,' y max 3: ', max);
  end;

  var
    n: integer;
    max: integer;
  begin
    n:= 132;
    max:= -1;
    digitoMaximo(n,max);
  end.

```

<h1 align="center"> busqueda binaria recursiva / busqueda dicotomica</h1>

<p>2 variaciones de la busqueda binaria algo parecidos pero recursivos</p>

```pas

  procedure busquedaDicotomicaRecursiva (v: vector ; ini: integer ; fin: integer ; valorBuscado: integer ; var pos: integer;var encontrado:Boolean);
  var
    mid: integer;
  begin
    if (ini > fin) then
      pos:= -1
    else
      begin
        mid:= (ini + fin) div 2;
        if (valorBuscado = v[mid]) then
          begin
            pos:= mid;
            encontrado:= true;
          end
        else
          if (valorBuscado < v[mid]) then
            busquedaDicotomicaRecursiva(v, ini, (mid - 1), valorBuscado, pos,encontrado)
          else
            busquedaDicotomicaRecursiva(v, (mid + 1), fin, valorBuscado, pos,encontrado)
      end;
  end;


  procedure buscarNumero(numAbuscar: integer; v1: vector; ini,mitad,fin: integer;var encontrado: Boolean);

  begin
    if ((ini <= fin) And (encontrado <> true)) then
      Begin
        mitad := (ini+fin) Div 2;
        If (v1[mitad] = numAbuscar) Then
          encontrado := true
        Else
          begin
            If (numAbuscar < v1[mitad])Then
              fin := mitad-1
            Else
              If (numAbuscar > v1[mitad])Then
                ini := mitad+1;
          end;
        buscarNumero(numAbuscar,v1,ini,mitad,fin,encontrado);
      End
    else
      encontrado:= encontrado;
  end;

```

* <details>
  <summary> 1) Codigo Prueba de los 2 Algoritmos </summary>
        
  ```pas
       
  program Hello;
  type

    vector = array[1..10]of integer;

  procedure cargarVector(var v: vector);
  var
    i: integer;
  begin
    for i:= 1 to 10 do  
      v[i]:= random(10);
  end;

  procedure imprimirVector(var v: vector);
  var
    i: integer;
  begin
    for i:= 1 to 10 do
      Writeln('estamos en la iteracion: ',i,' y tiene este valor: ',v[i]);
  end;

  procedure busquedaDicotomicaRecursiva (v: vector ; ini: integer ; fin: integer ; valorBuscado: integer ; var pos: integer;var encontrado:Boolean);
  var
    mid: integer;
  begin
    if (ini > fin) then
      pos:= -1
    else
      begin
        mid:= (ini + fin) div 2;
        if (valorBuscado = v[mid]) then
          begin
            pos:= mid;
            encontrado:= true;
          end
        else
          if (valorBuscado < v[mid]) then
            busquedaDicotomicaRecursiva(v, ini, (mid - 1), valorBuscado, pos,encontrado)
          else
            busquedaDicotomicaRecursiva(v, (mid + 1), fin, valorBuscado, pos,encontrado)
      end;
  end;


  procedure ordenarPorSeleccion(var v: vector; dimL: integer);
  var
    a,b,i,min: integer;
  begin
    for i:= 1 to dimL-1 do
      begin
        a:= i;
        for b:= i+1 to dimL-1 do
          begin
            if(v[b] < v[a])then
              a:= b;
          end;
          min:= v[a];
          v[a]:= v[i];
          v[i]:= min;
      end;  
  end;


  procedure buscarNumero(numAbuscar: integer; v1: vector; ini,mitad,fin: integer;var encontrado: Boolean);

  begin
    if ((ini <= fin) And (encontrado <> true)) then
      Begin
        mitad := (ini+fin) Div 2;
        If (v1[mitad] = numAbuscar) Then
          encontrado := true
        Else 
          begin
            If (numAbuscar < v1[mitad])Then
              fin := mitad-1
            Else 
              If (numAbuscar > v1[mitad])Then
                ini := mitad+1;
          end;
        buscarNumero(numAbuscar,v1,ini,mitad,fin,encontrado);
      End
    else
      encontrado:= encontrado;
  end;

  var
    v: vector;
    valorB,ini,pos,fin: integer;
    encontrado: Boolean;
    dimL: integer;
    mitad: integer;
  begin
    randomize;
    cargarVector(v);
    dimL:= 10;
    ordenarPorSeleccion(v,dimL);
    imprimirVector(v);
    Writeln('Ingrese un valor ha buscar ');
    readln(valorB);
    encontrado:= false;
    busquedaDicotomicaRecursiva(v,1,10,valorB,pos,encontrado);
    if(encontrado)then
      Writeln('Se encontro el numero: ',pos)
    else  
      Writeln('error: ',pos);

    Writeln('El HABIA hecho yo ');
    Writeln();Writeln();
    encontrado:= false;
    buscarNumero(valorB,v,1,mitad,10,encontrado);
    Writeln();Writeln();
    if(encontrado)then
      Writeln('Se encontro el numero: ')
    else  
      Writeln('error: ');
  end.


     ```
</details>


<!--
<h1 align="center"> busqueda binaria recursiva / busqueda dicotomica</h1>

```pas

procedure buscarNumero(numAbuscar: integer; v1: vPrimero; ini,mitad,fin: integer;var encontrado: Boolean;);
begin
  if ((ini <= fin) And (encontrado <> true)) Do
    Begin
      mitad := (ini+fin) Div 2;
      If (v1[mitad] =numAbuscar) Then
        encontrado := true
      Else
        If (numAbuscar < v1[mitad])Then
          fin := mitad-1
        Else
          If (numAbuscar> v1[mitad])Then
           ini := mitad+1;
      buscarNumero(numAbuscar,v1,ini,mitad,fin,encontrado);
    End
  else
    encontrado := encontrado;
end;


procedure buscarNumero(numAbuscar: integer; v1: vPrimero; ini,mitad,fin: integer;var encontrado: Boolean;);
begin
  if ((ini <= fin) And (encontrado <> true)) Do
    Begin
      mitad := (ini+fin) Div 2;
      If (v1[mitad] =numAbuscar) Then
        encontrado := true
      Else
        If (numAbuscar < v1[mitad])Then
          fin := mitad-1
        Else
          If (numAbuscar> v1[mitad])Then
           ini := mitad+1;
      buscarNumero(numAbuscar,v1,ini,mitad,fin,encontrado);
    End
  else
    encontrado := encontrado;
end;

```
-->
