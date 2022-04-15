package blogvirtuale;

import java.time.LocalDate;

public class ArticoloNoir extends Articolo {
	
	private String descrizione;

	public ArticoloNoir(int id, String titolo, LocalDate data_produzione, 
							String descrizione, String testo, Autore autore, Tags tags) {
		super(id, titolo, data_produzione, testo, Categoria.NOIR, autore, tags);
		this.descrizione = descrizione;
	}
	
	public String getDescrizione() { return descrizione; }

}
