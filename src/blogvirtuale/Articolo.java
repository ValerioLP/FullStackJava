package blogvirtuale;

import java.time.LocalDate;

/*
 * Una classe Articolo che contiene le informazioni relative ad un articolo:
	• id, titolo, data, categoria, testo, Autore, Tags
 */
public class Articolo {
	
	private int id;
	private String titolo;
	private LocalDate data_produzione;
	private String testo;
	private Categoria categoria;
	private Autore autore;
	private Tags tags;

	public Articolo(int id, String titolo, LocalDate data_produzione, String testo, Categoria categoria,
			Autore autore, Tags tags) {
		this.id = id;
		this.titolo = titolo;
		this.data_produzione = data_produzione;
		this.testo = testo;
		this.categoria = categoria;
		this.autore = autore;
		this.tags = tags;
	}
	
	public int getID() { return id; }
	public Categoria getCategoria() { return categoria;	}
	public Autore getAutore() { return autore; }
	public Tags getTags() { return tags; }
	public LocalDate getDate() { return data_produzione; }
	public String getTesto() { return testo; }
	
    @Override
    public boolean equals(Object o) { 
        if (o == this) { return true; } 
        if (!(o instanceof Articolo)) { return false; }
        
        Articolo a = (Articolo) o;         
        return a.getID() == this.id;
    }
	
	public String toString() { return "Titolo: " + titolo + ", Autore: " + autore; }
	
}
