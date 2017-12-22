package victorAdded;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ChristmasCardBack extends FullFunctionScreen implements FileRequester{

	public TextArea text;
	private Visible background;
	public AnimatedComponent fireworks;
	public AnimatedComponent fireworks2;
	
	public ChristmasCardBack(int width, int height) {
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
		background = new Graphic(0, 0, "resources/fireworksBack.jpg");
		viewObjects.add(background);
		text = new TextArea(200, 250, 400, 100, "Happy New Year!");
		viewObjects.add(text);
		fireworks = new AnimatedComponent(50, 100, 160, 112);
		fireworks.addSequence("resources/firework-spritesheet.png", 150, 0, 0, 160, 112, 15);
		Thread run = new Thread(fireworks);
		run.start();
		viewObjects.add(fireworks);
		
		fireworks2 = new AnimatedComponent(400, 100, 160, 112);
		fireworks2.addSequence("resources/firework-spritesheet.png", 147, 0, 0, 160, 112, 15);
		Thread run2 = new Thread(fireworks2);
		run2.start();
		viewObjects.add(fireworks2);
	}
	
	private void setCustomFont(){
		InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("Christmas.ttf");
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(40f);
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
