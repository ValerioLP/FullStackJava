/*
* Il singleton è un design pattern creazionale che ha lo scopo di garantire che di una determinata classe venga creata una e una sola istanza,
* e di fornire un punto di accesso globale a tale istanza.
* 
* Esempio: Paperino e Paperinik sono un'unica entità.
* Questo è possibile solo con il singleton pattern.*
*/

public class Paperino extends PersonaggioDisney implements DoppiaVita {

	static private Paperinik paperinik;

	static public Paperino getIstance() {
		if(paperinik == null) paperinik = new Paperinik();
		return paperinik;
	}

	private Paperino() {}

	@Override
	public Supereroe assumiIdentitàSegreta() { 
		return paperinik; 
	}

	@Override
	public PersonaggioDisney assumiIdentitàPubblica() { 
		return this;
	}

	//implementa Paperinik con una classe interna privata
	static private class Paperinik extends Paperino implements Supereroe {

		private Paperinik() {}

		@Override
		public Supereroe assumiIdentitàSegreta() {
			return this;
		}

		@Override
		public PersonaggioDisney assumiIdentitàPubblica() {
			return this;
		}
	}
}