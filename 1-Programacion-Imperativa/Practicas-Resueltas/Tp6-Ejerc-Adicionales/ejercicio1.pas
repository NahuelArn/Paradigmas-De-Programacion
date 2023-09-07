{El administrador de un edificio de oficinas, cuenta en papel, con la información del pago
de las expensas de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se debe leer, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación -1.
b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.
c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo, debe
retornar la posición del vector donde se encuentra y en caso contrario debe retornar 0.
Luego el programa debe informar el DNI del propietario o un cartel indicando que no
se encontró la oficina.
d) Un módulo recursivo que retorne el monto total de las expensas.}

{
* a: un vector de dimF =  300 y manteniendo una dimL, se leen data de oficinas | criterio de corte codIdentificacion -1
* b: ordenar el vector por codigo de identificacion de la oficicina (puedo usar cualqueira de los 2 metodos de Ordenacion)
* c: hacer una busqueda dicotomica al vector, recibe el vector y un codDeIdentificacionDeOficina, si encuentro retorno la posicion sino retorno 0 y hago los respectivos informes
* d: un modulo recusivo que recorra el vector y retorne la suma total de las expensas
* 0.8
* }
//0.56 no testeado
//+40 testeado
//1:36
program onlyPruebas;

const
	dimF300 = 300;
type
	
	oficina = record
		codIdentificacion: integer;
		dniPropietario: integer;
		valorExpensa: real;
	end;
	
	vOficinas = array[1..dimF300]of oficina;
	
{a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se debe leer, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación -1.}

procedure leerOficina(var o: oficina);
begin
	Writeln('cod identificacion ');
	readln(o.codIdentificacion);
	//o.codIdentificacion:= random(11)-1;
	if(o.codIdentificacion <> -1)then
		begin
			Writeln('dni propietario ');
			//readln(o.dniPropietario);
			o.dniPropietario:= random(20);
			Writeln('valor expensa ');
			readln(o.valorExpensa);
			//o.valorExpensa:= random(32);
		end;
end;

procedure asignarEnLaEstructura(var v: vOficinas;o: oficina;var dimL: integer);
begin
	dimL:= dimL+1;
	v[dimL]:= o;
end;

procedure cargarOficinas(var v: vOficinas;var dimL: integer);
var
	o: oficina;
begin
	leerOficina(o);
	dimL:= 0;
	While (dimL < dimF300) and (o.codIdentificacion <> -1)do
		begin
			asignarEnLaEstructura(v,o,dimL);
			leerOficina(o);
		end;
end;

{b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.}
procedure ordernarPorSeleccion(var v: vOficinas; dimL: integer);
var
	a,b,i: integer;
	min: oficina;
begin
	for i:= 1 to dimL-1 do
		begin
			a:= i;
			for b:= i+1 to dimL do
				begin
					if(v[b].codIdentificacion < v[a].codIdentificacion)then	
						a:= b;
				end;
				min:= v[a];
				v[a]:= v[i];
				v[i]:= min;
		end;
end;


function busquedaDicotomica(v: vOficinas; dimL,codOficinaBuscada: integer): integer;
var
	ini,mid,fin: integer;
	ok: Boolean; pos: integer;
begin
	pos:= 0;
  ok:= false;
	ini:= 1;
	fin:= dimL;
	While(ini <= fin) and (ok = false)do
		begin
			mid:= (ini+fin) div 2;
			if(v[mid].codIdentificacion = codOficinaBuscada)then
        begin
				  ok:= true;
          pos:= mid;
        end
			else
				if(v[mid].codIdentificacion > codOficinaBuscada)then
					fin:= mid-1
				else
					ini:= mid+1
		end;
		busquedaDicotomica:= pos;
end;

{d) Un módulo recursivo que retorne el monto total de las expensas.}
function sumarTodasLasExpensas(v: vOficinas;dimL,i: integer):real;
begin
  if(i = dimL)then
    sumarTodasLasExpensas:= v[dimL].valorExpensa
  else
    if(i < dimL)then
     sumarTodasLasExpensas:= sumarTodasLasExpensas(v,dimL,i+1)+ v[i].valorExpensa
    else
      sumarTodasLasExpensas:= 0;
end;

procedure imprimirVector(v: vOficinas; dimL: integer);
var	i: integer;
begin
	for i:= 1 to dimL do
		Writeln('imprimiendo: ',v[i].codIdentificacion);
end;

var
	v: vOficinas;
	dimL: integer;
	codOficinaBuscada: integer;
	auxBusquedaDicotomica: integer;
	i: integer;
begin
	randomize;
	cargarOficinas(v,dimL);
	Writeln(); Writeln();
	imprimirVector(v,dimL);
	Writeln(); Writeln();
	ordernarPorSeleccion(v,dimL);
	Writeln(); Writeln();
	imprimirVector(v,dimL);
	Writeln(); Writeln();
	Writeln('Ingrese un cod de oficina a buscar en la estructura ');
	readln(codOficinaBuscada);
	auxBusquedaDicotomica:= busquedaDicotomica(v,dimL,codOficinaBuscada);
	if(auxBusquedaDicotomica <> 0)then
		Writeln('El dni del propietario de la pos buscada es: ',v[auxBusquedaDicotomica].dniPropietario)
	else	
		Writeln('No se encontro la oficina ');
	i:= 1;
	Writeln('el total de expensas de toda la estructura es: ',sumarTodasLasExpensas(v,dimL,i):2:2);
end.


