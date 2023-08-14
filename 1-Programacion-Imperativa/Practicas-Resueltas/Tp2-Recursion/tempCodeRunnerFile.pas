procedure valorMinimo(L: lista;var min: integer);


begin
  if(L <> nil)then
    begin
      sacarUnMinimo(min,L^.dato);
      valorMinimo(L^.sig,min);
    end;
end;