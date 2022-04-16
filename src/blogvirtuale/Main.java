package blogvirtuale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
• Creare un'applicazione che simuli un blog virtuale con le seguenti caratteristiche.
• Una classe Articolo che contiene le informazioni relative ad un articolo:
	• id, titolo, data, categoria, testo, Autore, Tags
• dove Autore è una classe che contiene le seguenti informazioni, relative all'autore dell’articolo:
	• id, nome, cognome
e Tags è una classe che contiene un ArrayList di stringhe che rappresentano i tag dell'articolo.

La classe Autore implementa l'interfaccia Scrittore, che espone il metodo:
• scriviArticolo( ... info articolo ) -> che prese in ingresso le informazioni dell'articolo, ne crea uno a nome dell'autore e
lo restituisce.
Abbiamo poi 2 categorie differenti di articoli prodotti dalle sottoclassi:
• ArticoloFantasy e ArticoloNoir, che aggiungono il campo descrizione, utile a descrivere la categoria.
Infine, abbiamo la classe Blog, che possiede un ArrayList di articoli in memoria, ed i metodi:
- stampaArticoloPerId( id )
- stampaArticoli()
Nel main, realizzare 4 articoli (e strutture annesse) con valori a piacere, aggiungerli al blog e chiedere all'utente
attraverso un menù se vuole stampare in output le informazioni di tutti gli articoli oppure solo di un articolo, passando
un determinato id.
 */

public class Main {
	
	public static void main(String[] args) {
		Autore svevo = new Autore(1, "Italo", "Svevo");
		svevo.scriviArticolo(1, "La coscienza di Zeno", LocalDate.of(1923,01,01), "Testo dell'articolo", Categoria.ROMANZO, 
				new Tags(new ArrayList<String>(List.of("#zeno","#autobiografia","#psicoanalisi","#psiche"))));
		
		Autore wilde = new Autore(2, "Oscar", "Wilde");
		wilde.scriviArticolo(2, "Il ritratto di Dorian Gray", LocalDate.of(1890,07,01), "Testo dell'articolo", Categoria.NARRATIVA, 
				new Tags(new ArrayList<String>(List.of("#dorian","#gray","#ritratto","#londra"))));
		
		Autore king = new Autore(3, "Stephen", "King");
		king.scriviArticolo(3, "L'ultimo cavaliere", LocalDate.of(1982,01,01), "Testo dell'articolo", Categoria.FANTASY, 
				new Tags(new ArrayList<String>(List.of("#stephen","#king","#torre","#nera", "#fantasy"))));
		king.scriviArticolo(4, "L'acchiappasogni", LocalDate.of(2001,01,01), "Testo dell'articolo", Categoria.FANTASCIENZA, 
				new Tags(new ArrayList<String>(List.of("#stephen","#king","#sogni","#fantascienza"))));
		
		Blog blog = new Blog("MyBlog");
		blog.addAutori(List.of(svevo, wilde, king));
		//blog.stampaArticoli();
		//blog.stampaArticoloPerId(1);
		blog.stampaArticoloPerTag("#king");
	}

}
