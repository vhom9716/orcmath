package victorAdded;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;

public class CatalogMaker {

	private static ArrayList<Painting> paintings;
	public static Scanner in;
	
	public static void main(String[] args){
		CatalogMaker maker = new CatalogMaker();
		in = new Scanner(System.in);
		maker.menu();
	}
	
	public CatalogMaker() {
		paintings = new ArrayList<Painting>();
		paintings.add(new Painting("Vincent van Gouh", "Impressionist", 1889, "temp", "Starry Night"));
		paintings.add(new Painting("Edvard Munch", "Expressionist", 1893, "temp", "The Scream"));
		paintings.add(new Painting("Leonardo da Vinci", "Renaissance", 1517, "temp", "Mona Lisa"));
		paintings.add(new Painting("Claude Monet", "Impressionist", 1920, "temp", "Reflections of Clouds on the Water-Lily Pond"));
	}

	public void add() {

		ArrayList<String> items = new ArrayList<String>();
		displayMessage("Please type the painter");
		items.add(getStringInput());
		displayMessage("Please type in the artist");
		items.add(getStringInput());
		displayMessage("Please type the year completed");
		items.add(getStringInput());
		displayMessage("Please type the artistic movement");
		items.add(getStringInput());
		displayMessage("Please type the imageAddress");
		items.add(getStringInput());
		displayMessage("Please type the name");
		items.add(getStringInput());
		addPainting(new Painting(items.get(0), items.get(1), Integer.parseInt(items.get(2)), items.get(3), items.get(4)));
		
	}
	
	private void menu() {
		displayMessage("Would you like to \"load\" a save file or \"create\" a new list? ");
		String[] allowedEntry = {"load","create"};
		String input = getEntry(allowedEntry);
		if(input.equals("load")){
			load();
		}else{
			create();
		}
	}

	private void create() {
		
		boolean running = true;
		while(running){
			showCatalog();
			displayMessage("Would you like to \"add\", \"save\", or \"quit\"?");
			String[] allowedEntry = {"add","save","quit"};
			String selection = getEntry(allowedEntry);
			if(selection.equals("add")){
				add();
			}else if(selection.equals("save")){
				save();
			}else{
				running = false;
			}
		}
	}
	
	private static void displayMessage(String message){
		System.out.println(message);
	}

//	private int getIntegerInput() {
//		String text = in.nextLine();
//		int value = 0;
//		boolean valid = false;
//		while(!valid){
//			try{
//				value = Integer.parseInt(text);
//				valid = true;
//			}catch(NumberFormatException nfe){
//				displayMessage("You must enter an integer.");
//				text = in.nextLine();
//			}
//		}
//		return value;
//	}

	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}


	public void addPainting(Painting b){
		paintings.add(b);
	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("BookCatalog.csv");
			for(Painting b: paintings){
				fw.write(b+"\n");    	
			}

			fw.close();    
			displayMessage("Success! File \"BookCatalog.csv\" saved!");
		}catch(IOException e){
			displayMessage("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private static String getEntry(String[] allowedEntry) {
		String input = in.nextLine();
		while(!matchesEntry(input, allowedEntry)){
			displayMessage("You must enter one of these words: ");
			for(String s: allowedEntry){
				System.out.print(s+" ");
			}
			displayMessage("\n");
			input = in.nextLine();
		}
		return input;
	}

	private static boolean matchesEntry(String text, String[] list){
		for(String l: list){
			if(l.equals(text))return true;
		}
		return false;
	}

	private  void showCatalog() {
		displayMessage("The catalog contains these Paintings:\n");
		for(Painting b: paintings){
			displayMessage("   "+b.toString()+"\n");
		}
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		paintings = new ArrayList<Painting>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				displayMessage("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split(",");
					//add a new Book for each line in the save file
					paintings.add(new Painting(param[0],param[1],Integer.parseInt(param[2]),param[3],param[4]));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				displayMessage("The file name you specified does not exist.");
			}
		}
		create();

	}
	
	
}


	
