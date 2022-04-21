package FactoryPattern;

public class NegozioGiocattoli {
	
	private GiocattoloFactory fabbrica;
	
	public NegozioGiocattoli(GiocattoloFactory fabbrica) {
		this.fabbrica = fabbrica;
	}

	public Giocattolo ordinaGiocattolo(String nome) {
		return fabbrica.creaGiocattolo(nome);
	}
	
}
