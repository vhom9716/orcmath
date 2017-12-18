package victorAdded;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogeMaker {

	private static ArrayList<Painting> paintings;
	public static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CatalogeMaker maker = new CatalogeMaker();
		System.out.println(maker.getCSVContent());
		System.out.println("Type add to add more items.");
		String s = in.nextLine();
		while(!s.equals("add")) {
			s = in.nextLine();
		}
		while(!s.equals("end")){
			addItem();
			System.out.print("type end to stop adding paintings.");
			s = in.nextLine();
			System.out.println(maker.getCSVContent());
		}
		System.out.print("type save to save the catalouge");
		s = in.nextLine();
		if(s.equals("save")){
			testSaveContent("catalouge.csv");
		}
		
		
		//use split function to load items
	}
	
	public CatalogeMaker() {
		paintings = new ArrayList<Painting>();
		paintings.add(new Painting("Vincent van Gouh", "1889", "Impressionist", "temp", "Starry Night", "73.7", "92.1"));
		paintings.add(new Painting("Edvard Munch", "1893", "Expressionist", "temp", "The Scream", "91", "73.5"));
		paintings.add(new Painting("Leonardo da Vinci", "1517", "Renaissance", "temp", "Mona Lisa", "77", "53"));
		paintings.add(new Painting("Claude Monet", "1920", "Impressionist", "temp", "Reflections of Clouds on the Water-Lily Pond", "200", "1276"));
	}

	public String getCSVContent() {
		String data = "";
		for(Painting p: paintings) {
			data += p+"\n";
		}
		return data;
	}
	
	public static void addItem() {

		ArrayList<String> items = new ArrayList<String>();
		System.out.println("Please type the painter");
		String s = in.nextLine();
		while(s.equals("add")) {
			System.out.println("Please type in the artist");
			s = in.nextLine();
		}
		items.add(s);
		System.out.println(s);
		System.out.println("Please type the year completed");
		while(s.equals(items.get(0))) {
			s = in.nextLine();
		}
		items.add(s);
		System.out.println(s);
		System.out.println("Please type the artistic movement");
		while(s.equals(items.get(1))) {
			s = in.nextLine();
		}
		items.add(s);
		System.out.println(s);
		System.out.println("Please type the imageAddress");
		while(s.equals(items.get(2))) {
			s = in.nextLine();
		}
		items.add(s);
		System.out.println(s);

		System.out.println("Please type the name");
		while(s.equals(items.get(3))) {
			s = in.nextLine();
		}
		items.add(s);
		System.out.println(s);
		
		System.out.println("Please type the height");
		while(s.equals(items.get(4))) {
			s = in.nextLine();
		}
		items.add(s);
		System.out.println(s);
		
		System.out.println("Please type the width");
		while(s.equals(items.get(5))) {
			s = in.nextLine();
		}
		items.add(s);
		System.out.println(s);
		
		paintings.add(new Painting(items.get(0), items.get(1), items.get(2), items.get(3), items.get(4), items.get(5), items.get(6)));
		
	}
	
	private static void testSaveContent(String fileName) {

		 try{    

		 FileWriter fw=new FileWriter(fileName);    

		 for(Painting p: paintings) {
			 fw.write(p.toString()+"\n");
		 }

		 fw.close();    

		 System.out.println("Success! File \""+fileName+"\" saved!");

		 }catch(IOException e){

		 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		 }
	}
	
	private static List<String> testFileLoading() {

		 Scanner in = new Scanner(System.in);

		 String fileName = "";

		 List<String> content = new ArrayList<String>();

		 //use this boolean to control the while loop. The user should have multiple chances to enter a correct filename

		 boolean opened = false;

		 while(!opened){

		 try {

		 System.out.println("Enter a file to open");

		 fileName = in.nextLine();

		 FileReader fileReader = new FileReader(new File(fileName));

		 String line = "";

		 //a BufferedReader enables us to read teh file one line at a time

		 BufferedReader br = new BufferedReader(fileReader);

		 while ((line = br.readLine()) != null) {



		 content.add(line);



		 /*

		  * useful later:

		  * split only a comma that has an even number of quotes ahead of it

		 String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

		  */





		 }

		 br.close();

		 opened = true;

		 }catch (IOException e) {

		 System.out.println("The file name you specified does not exist.");

		 }

		 }

		 



		 //close the Scanner

		 in.close();

		 return content;

		 }
	
	
	
}


	
