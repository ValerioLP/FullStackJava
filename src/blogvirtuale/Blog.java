package blogvirtuale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Blog {
	
	private String titolo;
	private List<Articolo> articoli = new ArrayList<>();
	private List<Autore> autori = new ArrayList<>();
	private Map<Integer,Autore> autoreHashMap = new HashMap<>();
	private Map<Integer,Articolo> articoliHashMap = new HashMap<>();
	
	public Blog(String titolo) { this.titolo = titolo; }
	public Blog(String titolo, List<Articolo> articoli) { this.articoli = articoli;	}
	
	public void addAutore(Autore autore) { 
		autori.add(autore);
		articoli.addAll(autore.getArticoli());
		int hash = hash(autore);
		while(autoreHashMap.containsKey(hash))
			hash++;
		autoreHashMap.put(hash, autore);
	}
	
	public void addAutori(List<Autore> autori) { for(Autore a : autori)	addAutore(a); }	
	
	static final int hash(Object key) {
		int h = key.hashCode();
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	public void addArticolo(Articolo articolo) { 
		articoli.add(articolo); 
		int hash = hash(articolo);
		while(autoreHashMap.containsKey(hash))
			hash++;
		articoliHashMap.put(hash, articolo);
	}
	
	public String getTitolo() { return titolo; }
	public List<Articolo> getArticoli() { return articoli; }
	public List<Autore> getAutori() { return autori; }
	
	public void stampaArticoloPerId(int id) {
		articoli.stream().filter(articolo -> articolo.getID() == id).findFirst().ifPresent(System.out::println);
	}
	
	public void stampaArticoloPerTag(String tag) {
		if(tag.charAt(0) != '#')
			System.out.println("Devi inserire un tag valido. Inserisci '#' seguito dal tag");
		else {
			articoli.forEach(articolo -> articolo.getTags().getTagsList().stream()
					.filter(t -> t.equals(tag)).map(t -> articolo).findFirst().ifPresent(System.out::println)); 
		}
	}
	
	public void stampaArticoli() { articoli.forEach(articolo -> System.out.println(articolo)); }

}
