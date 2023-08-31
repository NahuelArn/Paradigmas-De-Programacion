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

```pas

procedure buscarNumero(numAbuscar: integer; v1: vPrimero; ini,mitad,fin: integer;var encontrado: Boolean;);
begin
  if ((ini <= fin) And (encontrado <> true)) Do
    Begin
      mitad := (ini+fin) Div 2;
      If (v1[mitad] =numAbuscar) Then
        encontrado := true
      Else If (numAbuscar < v1[mitad])Then
             fin := mitad-1
      Else If (numAbuscar> v1[mitad])Then
             ini := mitad+1;
      buscarNumero(numAbuscar,v1,ini,mitad,fin,encontrado);
    End
  else
    encontrado := encontrado;
end;


Function buscarNumero(numAbuscar: integer; v1: vPrimero; ini,mitad,fin: integer;encontrado: Boolean): Boolean;  
Begin
  if ((ini <= fin) And (encontrado <> true)) Do
    Begin
      mitad := (ini+fin) Div 2;
      If (v1[mitad] =numAbuscar) Then
        encontrado := true
      Else If (numAbuscar < v1[mitad])Then
             fin := mitad-1
      Else If (numAbuscar> v1[mitad])Then
             ini := mitad+1;
      buscarNumero:= buscarNumero(numAbuscar,v1,ini,mitad,fin,encontrado);
    End
  else
    buscarNumero := encontrado;
End;

```
