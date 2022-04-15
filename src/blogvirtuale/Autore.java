package blogvirtuale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Autore è una classe che contiene le seguenti informazioni, relative all'autore dell’articolo:
	• id, nome, cognome
 */
public class Autore implements Scrittore {
	
	private int id;
	private String nome;
	private String cognome;
	private List<Articolo> articoli_scritti = new ArrayList<>();

	public Autore(int id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Autore(int id, String nome, String cognome, List<Articolo> articoli_scritti) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.articoli_scritti = articoli_scritti;
	}

	@Override
	public void scriviArticolo(int id, String titolo, LocalDate data, String testo, 
										Categoria categoria, Tags tags) {
		articoli_scritti.add(categoria.equals(Categoria.FANTASY) ? 
								new ArticoloFantasy(id, titolo, data, "Questo è un testo della categoria fantasy", testo, this, tags) :
							categoria.equals(Categoria.NOIR) ?
							    new ArticoloNoir(id, titolo, data, "Questo è un testo della categoria noir",testo, this, tags) :
							new Articolo(id, titolo, data, testo, categoria, this, tags));
	}
	
	public int getID() { return id; }
	public List<Articolo> getArticoli() { return articoli_scritti; }
	
    @Override
    public boolean equals(Object o) { 
        if (o == this) { return true; } 
        if (!(o instanceof Autore)) { return false; }
        
        Autore a = (Autore) o;         
        return a.getID() == this.id;
    }
	
	public String toString() { return nome + " " + cognome;	}

}
