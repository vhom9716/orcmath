package victorAdded;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ChristmasCard extends FullFunctionScreen implements FileRequester{

	private Button button;
	private Graphic snowman;
	private TextArea title;
	private Graphic background;
	
	public ChristmasCard(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setCustomFont();
		background = new Graphic(0, 0, "resources/snow.jpg");
		viewObjects.add(background);
		button = new Button(30, 700, 150, 30, "Open card", new Action() {
			
			@Override
			public void act() {
				christmasGUI.card.setScreen(christmasGUI.insideScreen);
			}
		});
		viewObjects.add(button);
		snowman = new Graphic(100, 200, "resources/snowman.jpg");
		viewObjects.add(snowman);
		title = new TextArea(200, 100, 400, 80, "Happy Holidays!");
		viewObjects.add(title);
	}
	
	private void setCustomFont(){
		InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("Christmas.ttf");
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(30f);
			StyledComponent.setBaseFont(font);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
