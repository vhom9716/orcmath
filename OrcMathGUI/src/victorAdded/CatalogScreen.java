package victorAdded;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.FileOpenButton;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester{

	private TextField titleField;
	private TextField painterField;
	private TextField dateField;
	private TextField moveField;
	private TextField addressField;
	private Button buttonAdd;
	private Button buttonSave;
	private Button buttonDelete;
	private FileOpenButton buttonFileOpen;
	private TextArea text;
	public CatalogMaker paintingCatalog = new CatalogMaker();
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		titleField = new TextField(40, 40, 200, 30, "", "Title");
		viewObjects.add(titleField);
		painterField = new TextField(40, 90, 200, 30, "", "Author");
		viewObjects.add(painterField);
		dateField = new TextField(40, 140, 200, 30, "", "Date of Completion");
		dateField.setInputType(TextField.INPUT_TYPE_NUMERIC); 
		viewObjects.add(dateField);
		moveField = new TextField(40, 190, 200, 30, "", "Artistic Movement");
		viewObjects.add(moveField);
		addressField = new TextField(40, 240, 200, 30, "", "ImageAddress");
		viewObjects.add(addressField);
		buttonAdd = new Button(40, 400, 60, 30, "Add", new Action() {
			
			@Override
			public void act() {
				addClicked();
				titleField.setText("");
				dateField.setText("");
				painterField.setText("");
				moveField.setText("");
				addressField.setText("");
			}
		}); 
		viewObjects.add(buttonAdd);
		buttonSave = new Button(40, 500, 60, 30, "Save", new Action() {
			
			@Override
			public void act() {
				saveClicked();
			}
		});
		viewObjects.add(buttonSave);	
		buttonDelete = new Button(40, 550, 60, 30, "Delete", new Action() {
			
			@Override
			public void act() {
				deleteClicked();
			}
		});
		viewObjects.add(buttonDelete);
		buttonFileOpen = new FileOpenButton(40, 600, 60, 30, null, this);
		viewObjects.add(buttonFileOpen);
		
		text = new TextArea(40, 450, 200, 200, "Text Area");
		viewObjects.add(text);
	}

	protected void saveClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void openFile() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void addClicked() {
		Painting p = new Painting(painterField.getText(), moveField.getText(), Integer.parseInt(dateField.getText()), addressField.getText(), titleField.getText());
		paintingCatalog.addPainting(p);
		text.setText(text.getText() + p +"\n");
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
}