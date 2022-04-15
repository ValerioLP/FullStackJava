package blogvirtuale;

import java.time.LocalDate;

public interface Scrittore {
	
	public void scriviArticolo(int id, String titolo, LocalDate data, String testo, Categoria categoria, Tags tags);

}
