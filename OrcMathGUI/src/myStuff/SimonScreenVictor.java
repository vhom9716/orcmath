package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenVictor extends ClickableScreen implements Runnable{

	private ArrayList<MoveInterfaceVictor> moveList;
	private ProgressInterfaceVictor progress;
	private int roundNum;
	private boolean isPlayerTurn;
	
	
	public SimonScreenVictor(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		progress.updateProgress(roundNum);
		makeRandSequence();
		final Button b = getAButton();
		b.setAction(new Action(){

			public void act(){

			Thread blink = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				}
			//code for turning on, sleeping for 800ms and turning back off again goes here.
			});
			blink.start();

			}

		});
	}

	private Button getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	
	public void makeRandSequence() {
		
	}

}
