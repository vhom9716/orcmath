package victorAdded;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		CatalogScreen s = new CatalogScreen(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		CatalogMakerGUI gui = new CatalogMakerGUI(500, 800);
		Thread go = new Thread(gui);
		go.start();
		// TODO Auto-generated method stub

	}

}
