package homework;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

public class Studente {
	
	String matricola;
	String nome;
	String cognome;
	Sesso genere;
	Map<Materia, List<Double>> mappaVoti;
	
	public Studente(String matricola, String nome, 
			String cognome, Sesso genere, Map<Materia,List<Double>> mappaVoti) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.genere = genere;
		this.mappaVoti = mappaVoti;
	}
	
	public double getMediaVotoMateria(Materia materia) {
		return mappaVoti.get(materia).stream().collect(summingDouble(Double::valueOf)) 
				/ mappaVoti.get(materia).size();
	}
	
	public double getVotoMiglioreMateria(Materia materia) {
		return mappaVoti.get(materia).stream().mapToDouble(Double::doubleValue).summaryStatistics().getMax();
	}
	
	public boolean promosso() {
		int count = 0;
		for(Materia m : mappaVoti.keySet()) {
			if(count >= 4)
				return false;
			if(getMediaVotoMateria(m) < 6)
				count++;
		}
		return true;
	}
	
	public String toString() {
		return matricola + " - " + nome + " " + cognome;
	}
}
