package victorAdded;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField titleField;
	private TextField authorField;
	private TextField dateField;
	private TextField moveField;
	private TextField addressField;
	private TextField heightField;
	private TextField widthField;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		titleField = new TextField(40, 40, 200, 30, "Text goes here.", "Title");
		viewObjects.add(titleField);
		authorField = new TextField(40, 90, 200, 30, "Text goes here.", "Author");
		viewObjects.add(authorField);
		dateField = new TextField(40, 140, 200, 30, "Text goes here.", "Date of Completion");
		viewObjects.add(dateField);
		moveField = new TextField(40, 190, 200, 30, "Text goes here.", "Artistic Movement");
		viewObjects.add(moveField);
		addressField = new TextField(40, 240, 200, 30, "Text goes here.", "ImageAddress");
		viewObjects.add(addressField);
		heightField = new TextField(40, 290, 200, 30, "Text goes here.", "Height");
		viewObjects.add(heightField);
		widthField = new TextField(40, 340, 200, 30, "Text goes here.", "Width");
		viewObjects.add(widthField);
	}

}
