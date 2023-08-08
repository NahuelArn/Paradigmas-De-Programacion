  procedure inicializarLista(var L:lista);
  begin
    L:= nil;  
  end;

  procedure agregarAtrasOptimizado(var L,Ult: lista; n: integer);
  var
    nue: lista;
  begin
    new(nue);
    nue^.dato:= n;
    nue^.sig:= Nil;
    if(L = nil)then
      L:= nue
    else
      Ult^.sig:= nue;
    Ult:= nue;
  end;

  procedure cargarEstructura(var L: lista);
  var
    n: integer;
    Ult: lista;
  begin
    n:= random(101);
    if(n <> 0)then
      begin
        agregarAtrasOptimizado(L,Ult,n);
        cargarEstructura(L);
      end;
  end;