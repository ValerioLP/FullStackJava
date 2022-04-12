package homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Scuola {

	List<Studente> studenti;
	List<Materia> materie;
	Map<Studente, Double> mappaVoti = new HashMap<>();
	
	public Scuola(List<Studente> studenti, List<Materia> materie) {
		this.studenti = studenti;
		this.materie = materie;
	}
	
	public List<Studente> getPromossi() {
		return studenti.stream().filter(studente -> studente.promosso()).collect(Collectors.toList());
	}
	
	public List<Studente> getStudentiList() {
		return studenti;
	}
	
	public String getStudenti() {
		StringBuilder s1 = new StringBuilder("[");
		for(Studente s : getStudentiList())
			s1.append(s.toString() + ", ");
		return s1.replace(s1.length()-2, s1.length()-1, "]").toString();
	}
	
	public Studente getStudenteMigliore() {
		double sum;
		for(Studente s : studenti) {
			sum = 0;
			for(Materia m : materie) {
				sum += s.getMediaVotoMateria(m);
			}
			mappaVoti.put(s, sum);
		}
		
		double votoMigliore = mappaVoti.values().stream()
				.mapToDouble(Double::doubleValue).summaryStatistics().getMax();
		for(Studente s : mappaVoti.keySet())
			if(mappaVoti.get(s) == votoMigliore)
				return s;	
		return null;
	}
	
    public void writeToTextFile(String fileName) throws IOException {
        try {
        	Files.write(Paths.get(fileName), getStudenti().getBytes(), StandardOpenOption.CREATE);
        }
        catch (IOException e) {
        	System.out.println("Errore nella creazione del file");
        }
    }
}
