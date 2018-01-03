package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameVictor extends GUIApplication{
	
	public SimonGameVictor(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SimonGameVictor game = new SimonGameVictor(600, 800);
		Thread runner = new Thread(game);
		runner.start();
	}
	
	@Override
	public void initScreen() {
		SimonScreenVictor screen = new SimonScreenVictor(getWidth(), getHeight());
		setScreen(screen);
	}

}
