package practice;

import guiTeacher.GUIApplication;

public class PracticeGUI extends GUIApplication{

	PractiveScreen Screen;
	
	public PracticeGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		Screen = new PractiveScreen(getHeight(), getWidth());
		setScreen(Screen);
	}
	
	public static void main(String[] args) {
		PracticeGUI bla = new PracticeGUI(1000, 1000);
		Thread blah = new Thread(bla);
		blah.start();
	}

}
