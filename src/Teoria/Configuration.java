package Teoria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*Esercizio 3.5.1. Si consideri il seguente codice:*/
public class Configuration {
	
	public final static String FILENAME = "config/project.properties";
	private Map<String, String> config = new HashMap<>();
	
	/*aggiungo un campo statico privato che rappresenta l'unica istanza della classe*/
	private static Configuration istanza;
	
	/*rendo il costruttore privato in modo da non permettere la creazione di piu' istanze
	della classe*/
	private Configuration() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(FILENAME));
			while(br.ready()) {
				String[] pair = br.readLine().split("=");
				config.put(pair[0], pair[1]);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	/*creo un metodo statico getIstance che restituisce l'istanza della classe*/
	public static Configuration getIstance() {
		if (istanza == null) istanza = new Configuration();
		return istanza;
	}
	
	public String get(String name) { return config.get(name); }
}

	/*Modificare la classe utilizzando un design pattern appropriato in modo tale
	che la stessa, unica configurazione sia accessibile da qualsiasi classe del progetto.*/
