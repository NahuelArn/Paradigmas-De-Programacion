{Una oficina requiere el procesamiento de los reclamos de las personas. De cada reclamo
se lee código, DNI de la persona, año y tipo de reclamo. La lectura finaliza con el código de
igual a -1. Se pide:
a) Un módulo que retorne estructura adecuada para la búsqueda por DNI. Para cada DNI
se deben tener almacenados cada reclamo y la cantidad total de reclamos que realizó.
b) Un módulo que reciba la estructura generada en a) y un DNI y retorne la cantidad de
reclamos efectuados por ese DNI.
c) Un módulo que reciba la estructura generada en a) y dos DNI y retorne la cantidad de
reclamos efectuados por todos los DNI comprendidos entre los dos DNI recibidos.
d) Un módulo que reciba la estructura generada en a) y un año y retorne los códigos de
los reclamos realizados en el año recibido.}

{
	intro : reclamo = cod,dniDeLaPersona, anho, tipoReclamo; la lectura finaliza con el cod -1
a: almacenar en un arbol cadaReclamo y la cantidadTotalDeReclamos --> arbol eficiente para la busquede por dni
b: buscada de manera eficiente en el arbol un dni y retorna la cant de reclamos disponibles
c: entre 2 rangos de dni de manera eficiente contar cuantos reclamos totales hay entre esos rangos 
d: buscar en todo el arbol e ir generando una lista una lista de codigos de reclamos q se dieron en ese anho

0:08
 0: 55 no testeado
]
}
program ejercicio4;
	
type
	reclamo = record
		cod: integer;
		dniPersona: integer;
		anho: integer;
		tipo: integer; //1 nose 2 nose2 3 robo etc etc
	end;
	
	//--------------------
	
	listaReclamos = ^nodo;
	
	nodo = record
		dato: reclamo;
		sig: listaReclamos
	end;
	
	arbol = ^nodoArbol;
	
	nodoArbol = record
		dni: integer;
		cantTotalReclamos: integer;
		dato: listaReclamos;
		hi: arbol;  hd: arbol;
	end;
	//---------
	Lista3 = ^nodo3;	//se guarda los cod de reclamos en un anho X
	nodo3 = record
		dato: integer;		
		sig:Lista3;
	end;

procedure inicializarPuntero(var a: arbol);
begin
	a:= nil;
end;

procedure leerReclamo(var r: reclamo);
begin
	Writeln('cod: ');
	readln(r.cod);
	if(r.cod <> -1)then
		begin
				Writeln('dni ');
				readln(r.dniPersona);
				Writeln('anho: ');
				readln(r.anho);
				Writeln('tipo reclamo: ');
				readln(r.tipo);
		end;
end;

procedure inicializarLista(var L: listaReclamos);
begin
	L:= nil;
end;

procedure ponerDataEnSuLugar(r: reclamo; var a: arbol);
begin
	a^.dni:= r.dniPersona;
	a^.cantTotalReclamos:= 1;
end;

procedure agregarAdelante(var L: listaReclamos; r: reclamo);
var nue: listaReclamos;
begin
	new(nue);
	nue^.dato:= r;
	nue^.sig:= L;
	L:= nue;
end;

//procedure ponerDataEnSuLugarOtroReclamo(r: relamo; var cant: integer);
//begin
//	cant:= cant +1;
//end;

procedure cargarArbol(var a: arbol; r: reclamo);
begin
	if(a = nil)then
		begin
			new(a);
			inicializarLista(a^.dato);
			ponerDataEnSuLugar(r,a);
			agregarAdelante(a^.dato,r);
			a^.hi:= nil;	a^.hd:= nil;
		end
	else
		begin
			if(r.dniPersona <= a^.dni)then
				begin
					if(r.dniPersona = a^.dni)then
						begin
							a^.cantTotalReclamos:= a^.cantTotalReclamos+1;
							//ponerDataEnSuLugarOtroReclamo(r,a^.cantTotalReclamos);
							agregarAdelante(a^.dato,r);
						end;
					cargarArbol(a^.hi,r);
				end
			else
				begin
					if(r.dniPersona > a^.dni)then
						cargarArbol(a^.hd,r);
				end;
		end;
end;

procedure cargarReclamos(var a: arbol);
var  r: reclamo;
begin
	leerReclamo(r);
	While(r.cod <> -1)do
		begin
			cargarArbol(a,r); //adentro tiro toda la data en sus campos
			leerReclamo(r);
		end;
end;

{b) Un módulo que reciba la estructura generada en a) y un DNI y retorne la cantidad de
reclamos efectuados por ese DNI.}
{b: buscada de manera eficiente en el arbol un dni y retorna la cant de reclamos disponibles
}
function cantReclamos(a: arbol; dniBuscado: integer): integer;
begin
	if(a = nil)then
		cantReclamos:= 0
	else
		begin
			if(a^.dni = dniBuscado)then
				cantReclamos:= a^.cantTotalReclamos		
			else
				begin
					if(dniBuscado < a^.dni)then
						cantReclamos:= cantReclamos(a^.hi,dniBuscado)
					else
						cantReclamos:= cantReclamos(a^.hd,dniBuscado)
				end;
		end;
end;

{c) Un módulo que reciba la estructura generada en a) y dos DNI y retorne la cantidad de
reclamos efectuados por todos los DNI comprendidos entre los dos DNI recibidos.
}

function cantDeReclamosEntreRangos(a: arbol; izquierda,derecha: integer): integer;
begin
	if(a = nil)then
		cantDeReclamosEntreRangos:= 0
	else
		begin
			if(a^.dni > izquierda) and (a^.dni < derecha)then
				cantDeReclamosEntreRangos:= cantDeReclamosEntreRangos(a^.hi,izquierda,derecha) + a^.cantTotalReclamos + cantDeReclamosEntreRangos(a^.hd,izquierda,derecha)
			else
				begin
					if(a^.dni > izquierda)then	
						cantDeReclamosEntreRangos(a^.hi,izquierda,derecha)
					else
						begin
							if(a^.dni < derecha)then	
								cantDeReclamosEntreRangos(a^.hd,izquierda,derecha)
						end;
				end;
		end;
end;


{d) Un módulo que reciba la estructura generada en a) y un año y retorne los códigos de
los reclamos realizados en el año recibido.]}
procedure agregarAdelante2(var L: Lista3; x: integer);
var nue: Lista3;
begin
	new(nue);
	nue^.dato:= x;
	nue^.sig:= L;
	L:= nue;
end;


procedure buscarEnNodo(L:listaReclamos; x: integer; var L2: Lista3 );

begin
	if(L <> nil)then
		begin
			if(x = L^.dato.anho)then
				agregarAdelante2(L2,L^.dato.cod);
			buscarEnNodo(L^.sig,x,L2);
		end;
end;

procedure reclamosEnAnhoX(a: arbol; anhoX: integer; var L2: Lista3);
begin
	if(a <> nil)then
		begin
			reclamosEnAnhoX(a^.hi,anhoX,L2);
			buscarEnNodo(a^.dato,anhoX,L2);
			reclamosEnAnhoX(a^.hi,anhoX,L2);

		end;
end;

var
	a: arbol;
	dniBuscado: integer;
	totalReclamos: integer;
	izquierda,derecha: integer;
	//aux: integer;
	
	L3: Lista3;
	anhoBuscado: integer;
begin
	inicializarPuntero(a);
	cargarReclamos(a);
	dniBuscado:= 4540;
	totalReclamos:= cantReclamos(a,dniBuscado);
	if(totalReclamos <> 0)then
		Writeln('la cant de reclamos de ese dni es: ',totalReclamos);
	izquierda:= 2; derecha:= 20;
	Writeln('la cantidad es: ',cantDeReclamosEntreRangos(a,izquierda,derecha));
	//aux:= cantDeReclamosEntreRangos(a,izquierda,derecha); si tuviera q usar para algo esto lo guardaria en una var auxiliar
	L3:= nil;
	anhoBuscado:= 2023;
	reclamosEnAnhoX(a,anhoBuscado,L3)
end.




