package victorAdded;

import guiTeacher.GUIApplication;

public class christmasGUI extends GUIApplication{

	public static christmasGUI card;
	public static ChristmasCard frontScreen;
	public static ChristmasCard insideScreen;
	
	
	public christmasGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		christmasGUI card = new christmasGUI(600, 900);
		Thread go = new Thread(card);
		go.start();
	}
	
	public void initScreen() {
		frontScreen = new ChristmasCard(getWidth(), getHeight());
		insideScreen = new ChristmasCard(getWidth(), getHeight());
		setScreen(frontScreen);
	}

}
