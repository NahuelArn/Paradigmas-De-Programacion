<h1 align="center"> 2 Algoritmos de Ordenacion </h1>

<p align="center">Algoritmos que se repiten</p>

<h1 align="center"> Ordenacion-Seleccion </h1>

```pas 

procedure ordenarVectorSeleccion(var v: vOrdenar; dimL: integer);
var a,b,i,min: integer;
begin
  for i:= 1 to (dimL-1) do  
    begin
      a:= i; 
      for b:= i+1 to dimL do
        begin
          if(v[b] < v[a])then 
            begin
              a:= b; 
            end;          
          min:= v[a]; 
          v[a]:= v[i]; 
          v[i]:= min;  
        end;
    end;
end;

```
* <details>
  <summary> Explicacion1 </summary>
        
  ```pas
        {este metodo busca en todo el array el minimo y lo va posicionando al principiendo uno a uno,
        busco [i] si es mas chico q algun elemento del array me lo guardo en la iteracion que este i
        }
        procedure ordenarVectorSeleccion(var v: vOrdenar; dimL: integer);
        var a,b,i,min: integer;
        begin
          for i:= 1 to (dimL-1) do  //por que -1? porque arrancamos tomando un valor q va ser el minimo, el campo tomado en cada iteracion tomamos como -1
            begin
              a:= i; //me paro en la [x posicion]
              for b:= i+1 to dimL do
                begin
                  if(v[b] < v[a])then {pregunta si i+1 es mayor al primer campo, si es asi, cambia de lugar y asi se queda con el minimo, asi campo x campo va preguntando}
                    begin
                      a:= b; //en A tengo guardado la posicion del minimo de todo el vector
                    end;
                  {aca hacen el swap, intercambia los valores en sus posiciones correspondientes
                  Minmo lo guarda en la iteracion i, y lo que habia en i posicion lo intercambia en el lugar de la pos del minimo donde se encontraba}
                  min:= v[a]; //salvo el valor del minimo
                  v[a]:= v[i]; //swap de valores  // en la pos[A que es el de la 2da iteracion] me guardo el valor que habia en el elemento pos[i] // en este punto tengo la pos[i] libre para guardar mi minimo al principio
                  v[i]:= min; //guardo en la pos i el valor minimo de todo el vector    
                end;
            end;
        end;
     ```
</details>


<h1 align="center"> Ordenacion-Insercion </h1>

  
```pas 
Procedure ordenarVectorInsercion(v: vector; dimL: integer)
var
  elemAct,i,b: integer;
begin
  for i = 2 to (dimL-1) do
    begin
      elemAct = v[i];
      b = i - 1;
      while b > 0 and (v[b] > elemAct) do  //si el anterior es mas grande que el segundo 
        begin
          v[b+1] := v[b]; 
          b = b - 1;
        end;
        v[b+1] = elemAct
    end;
end;

```
* <details>
  <summary> 1) Explicacion </summary>
        
  ```pas
        {Este algoritmo, va ordenando usando los elementos de la izquierda para comparar q este ordenado, compara de izquierda a derecha, empieza en la pos 2 para tener una comparacion en la primera itereracion, usa el     
        mismo principio de una baraja de cartas, a medida que recorremos los elementos de la lista, vamos insertando cada elemento en su posición correcta entre los elementos previamente ordenados.
        arrayDePrueba = [4],[2],[10],[9] = dimL 4
        }
  
        Procedure ordenarVectorInsercion(v: vector; dimL: integer)
        var
          act,i,b: integer;
        begin
          for i = 2 to (dimL-1) do  //empiezo en 2
            begin
              act := v[i]; //inicializa en v[2]= 2
              b := i - 1; //b = pos 1
              while b > 0 and (v[b] > act) do  //4> 2?//si el anterior es mas grande que el act, hace la insercion tenia 4,2, 10,9  
                begin
                  v[b+1] := v[b]; //v[2]:= v[1]; v[2]:= 4; ahora tengo 
                  4,4,10,9 
                  b := b - 1; //b = 0 // en la 2da comparacion el el while no entra por el 0 
                end;
                v[b+1] := act //v[1]:= 2
                //me queda [2],[4],[10],[9]
            end;
        end;
     ```
</details>

<h1 align="center"> AgregarAtrasIneficiente </h1>

<p align="center">Se usa cuando tenes un vector de listas y te pide que queden ordenadas por orden de llegada, el otro algoritmo no te sirve, el Ult se pierde en cada Iteracion</p>

```pas 

procedure agregarAtrasIneficiente(var L: lista; p: pelicula);
var
  nue,ant,act: lista;
begin
  new(nue);
  nue^.dato:= p;
  ant:= L;
  act:= L;
  While (act <> nil) do
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

```