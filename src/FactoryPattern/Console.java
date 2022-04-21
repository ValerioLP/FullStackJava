package FactoryPattern;

public class Console extends Giocattolo {

	private GiocattoloFactory fabbrica;
	private String nome;
	
	public Console(String nome) {
		this.nome = nome;
	}
	
	public void setFabbrica(GiocattoloFactory fabbrica) {
		this.fabbrica = fabbrica;
	}
	
	public void implementaGiocattolo() {
		fabbrica.implementaGiocattolo(nome, this);
	}

}
