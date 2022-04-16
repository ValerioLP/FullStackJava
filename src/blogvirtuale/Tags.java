package blogvirtuale;

import java.util.List;

/*
 * Tags è una classe che contiene un ArrayList di stringhe che rappresentano i tag dell'articolo.
 */
public class Tags {
	
	private List<String> tags;

	public Tags(List<String> tags) { this.tags = tags; }
	
	public List<String> getTagsList() { return tags; }
	
}
