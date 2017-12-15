package victorAdded;

import java.util.ArrayList;

public class CatalogeMaker {

	private ArrayList<Painting> paintings;
	
	public static void main(String[] args) {
		CatalogeMaker maker = new CatalogeMaker();
		System.out.println(maker.getCSVContent());
	}
	
	public CatalogeMaker() {
		paintings = new ArrayList<Painting>();
		paintings.add(new Painting("Vincent van Gouh", "1889", "Impressionist", "temp", "Starry Night", 73.7, 92.1));
		paintings.add(new Painting("Edvard Munch", "1893", "Expressionist", "temp", "The Scream", 91, 73.5));
		paintings.add(new Painting("Leonardo da Vinci", "1517", "Renaissance", "temp", "Mona Lisa", 77, 53));
		paintings.add(new Painting("Claude Monet", "1920", "Impressionist", "temp", "Reflections of Clouds on the Water-Lily Pond", 200, 1276));
	}

	public String getCSVContent() {
		String data = "";
		for(Painting p: paintings) {
			data += p+"\n";
		}
		return data;
	}
}
