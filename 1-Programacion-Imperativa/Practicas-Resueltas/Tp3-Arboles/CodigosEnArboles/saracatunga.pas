program saracatunga;

// BUSCAR EN UN ARBOL RESPETANDO EL ORDEN. Devuelve un puntero de tipo arbol. Si no lo encuentra devuelve nil

function Buscar (a:arbol; x:integer): arbol;
begin
	if (a = nil) then 
		Buscar := nil
	else
		if (x = a^.dato) then
			Buscar := a
		else
			if (x < a^.dato) then
				Buscar := Buscar(a^.HI, x)
			else
				Buscar := Buscar(a^.HD, x)
end;

// BUSCAR EN UN ARBOL SIN RESPETAR EL ORDEN. Devuelve un puntero de tipo arbol. Si no lo encuentra devuelve nil

function Buscar (a:arbol; x:integer): arbol;
begin
	if (a = nil) then
		Buscar := nil
	else
		if (x = a^.dato) then
			Buscar := a
		else
  Buscar := Buscar(a^.HI, x) or Buscar(a^.HD, x);

end;


function buscar (a:arbol; x: integer):boolean;
begin
  if (a=nil)then
    ok:=false
  else
    begin
      buscar:= buscar(a^.hi,x) + buscar(a^.hd,x);
      if(a^.dato = x)then
        buscar:= true;
      end;
    end;
end;





begin
  
end.