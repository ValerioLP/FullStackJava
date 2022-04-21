package FactoryPattern;

public class Cicciobello extends Giocattolo {

	private GiocattoloFactory fabbrica;
	private String nome;
	
	public Cicciobello(String nome) {
		this.nome = nome;
	}
	
	public void setFabbrica(GiocattoloFactory fabbrica) {
		this.fabbrica = fabbrica;
	}
	
	public void implementaGiocattolo() {
		fabbrica.implementaGiocattolo(nome, this);
	}
}
