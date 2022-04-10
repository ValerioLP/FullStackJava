package homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
		
	public static Map<Materia,List<Double>> generaMap(List<Materia> materie) {
		Map<Materia,List<Double>> mappaVoti = new HashMap<>();
		for(Materia m : materie) {
			mappaVoti.put(m, new ArrayList<>());
			for(int i=0;i<=3;i++)
				mappaVoti.get(m).add(ThreadLocalRandom.current().nextDouble(0, 10.0));			
		}
		return mappaVoti;
	}
	
	public static void main(String[] args) throws IOException {
		
		Materia m1 = new Materia("Algebra");
		Materia m2 = new Materia("Ingegneria del Software");
		Materia m3 = new Materia("Interazione Uomo-Macchina");
		Materia m4 = new Materia("Linguaggi e Tecnologie per il Web");
		Materia m5 = new Materia("Linguaggi e Compilatori");
		Materia m6 = new Materia("Linguaggi di Programmazione");
		List<Materia> materie = List.of(m1,m2,m3,m4,m5,m6);
		
		Studente s1 = new Studente("000001", "Valerio", "Mezzoprete",
				Sesso.MASCHIO, generaMap(materie));
		Studente s2 = new Studente("000002", "Francesca", "Rossi",
				Sesso.FEMMINA, generaMap(materie));
		Studente s3 = new Studente("000003", "Maria", "Verdi",
				Sesso.FEMMINA, generaMap(materie));
		Studente s4 = new Studente("000004", "Massimo", "Rossi",
				Sesso.MASCHIO, generaMap(materie));
		Studente s5 = new Studente("000005", "Gianluca", "Gialli",
				Sesso.MASCHIO, generaMap(materie));
		Studente s6 = new Studente("000006", "Danilo", "Bianchi",
				Sesso.MASCHIO, generaMap(materie));		
		List<Studente> studenti = List.of(s1,s2,s3,s4,s5,s6);		
		
		Scuola sapienza = new Scuola(studenti, materie);
		
		System.out.println("******** Lista degli Studenti ********");
		List<Studente> studentiScuola = sapienza.getStudentiList();
		System.out.println(studentiScuola);
		
		System.out.println("******** Lista degli Studenti promossi ********");
		List<Studente> promossi = sapienza.getPromossi();
		System.out.println(promossi);
		sapienza.writeToTextFile("G:\\Uni\\Primo_Anno\\Java\\Corso\\src\\homework\\studenti");
	
	}

}
