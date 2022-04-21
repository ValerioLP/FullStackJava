package FactoryPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GiocattoloFactory {
	
	private Map<String,Supplier<Giocattolo>> fabbrica = new HashMap<>();

	public Giocattolo creaGiocattolo(String nome) {
		if(fabbrica.containsKey(nome))
			return fabbrica.get(nome).get();
		throw new IllegalStateException("Non è possibile creare il giocattolo richiesto");
	}
	
	public void implementaGiocattolo(String nome, Giocattolo giocattolo) {
		Supplier<Giocattolo> supplier = () -> giocattolo;
		if(! fabbrica.containsKey(nome))
			fabbrica.put(nome, supplier);
		throw new IllegalStateException("La fabbrica è gia in grado di costruire il giocattolo richiesto");
	}
}
