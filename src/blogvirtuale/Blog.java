package blogvirtuale;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

public class Blog {
	
	private String titolo;
	private List<Articolo> articoli = new ArrayList<>();
	private List<Autore> autori = new ArrayList<>();
	
	public Blog(String titolo) { this.titolo = titolo; }
	public Blog(String titolo, List<Articolo> articoli) { this.articoli = articoli;	}
	
	public void addAutore(Autore autore) { 
		autori.add(autore);
		articoli.addAll(autore.getArticoli());
	}
	
	public void addAutori(List<Autore> autori) { 
		this.autori.addAll(autori);
		articoli.addAll(autori.stream().map(autore -> autore.getArticoli())
				.flatMap(List::stream).distinct().collect(toCollection(ArrayList::new)));
	}
	
	public void addArticoli(Articolo articolo) { articoli.add(articolo); }
	
	public String getTitolo() { return titolo; }
	public List<Articolo> getArticoli() { return articoli; }
	public List<Autore> getAutori() { return autori; }
	
	public void stampaArticoloPerId(int id) {
		articoli.stream().filter(articolo -> articolo.getID() == id).findFirst().ifPresent(System.out::println);
	}
	
	public void stampaArticoli() { articoli.forEach(articolo -> System.out.println(articolo)); }

}
