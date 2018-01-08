package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenVictor extends ClickableScreen implements Runnable{

	private ArrayList<MoveInterfaceVictor> moveList;
	private ProgressInterfaceVictor progress;
	private TextLabel roundInfo;
	private ButtonInterfaceVictor[] buttons;
	private int roundNum;
	private boolean isPlayerTurn;
	private int lastButton;
	private int moveIdx; 
	
	
	public SimonScreenVictor(int width, int height) {
		super(width, height);
		Thread run = new Thread(this);
		run.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		roundInfo.setText("");
	    nextRound();
	}

	private void nextRound() {
		isPlayerTurn = false;
		roundNum++;
		moveList.add(getRandMove());
		progress.setRound(roundNum);
		progress.setSeqNum(moveList.size());
		changeText("Simon's Turn");
		Thread run = new Thread(this);
		run.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		changeText("");
		playSequence();
		changeText("Your turn");
		isPlayerTurn = true;
		moveIdx = 0;
	}

	private void playSequence() {
		// TODO Auto-generated method stub
		int sleep = 0;
		ButtonInterfaceVictor b = null;
		for(int i = 0; i < moveList.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = moveList.get(i).getButton();
			b.light();
			sleep = 1000 - (30 * roundNum);
			if(sleep <= 0) {
				sleep = 1;
			}
			Thread run = new Thread(this);
			run.start();
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		roundInfo.setText(string);
	}

	private ButtonInterfaceVictor getAButton() {
		// TODO Auto-generated method stub
		return new ButtonJustin(0,0, 40, 40, "", Color.BLACK, null);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		roundNum = 0;
		intButtons();
		for(ButtonInterfaceVictor b: buttons) {
			viewObjects.add(b);
		}
		progress = getProgress();
		viewObjects.add(progress);
		roundInfo = new TextLabel(100, 100, 200, 200, "This is Simon's game");
		viewObjects.add(roundInfo);
		moveList = new ArrayList<MoveInterfaceVictor>();
		moveList.add(getRandMove());
		moveList.add(getRandMove());
		lastButton = -1; 
	}
	
	private ProgressInterfaceVictor getProgress() {
		// TODO Auto-generated method stub
		return new ProgressJustin(0,0, 100, 100);
	}

	private void intButtons() {
		buttons = new ButtonInterfaceVictor[6];
		Color[] colors = {Color.blue, Color.gray, Color.red, Color.green, Color.pink, Color.cyan};
		for(int i = 0; i < buttons.length; i++) {
			ButtonInterfaceVictor b = getAButton();
			b.setColor(colors[i]);
			b.setX(200 + (int)Math.sin((Math.toRadians(i*60)))*20);
			b.setY(200 + (int)Math.cos((Math.toRadians(i*60)))*20);
			b.setAction(new Action(){
				public void act(){
					if(isPlayerTurn) {
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.light();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	
									b.dim();
							}
						});
						blink.start();
					}
					if(b == moveList.get(moveIdx).getButton()) {
						moveIdx++;
						if(moveIdx == moveList.size()){ 
						    Thread nextRound = new Thread(SimonScreenVictor.this); 
						    nextRound.start(); 
						}
					}else {
						progress.gameOver();
					}
					
				}

			});
			buttons[i] = b;
		}
	}

	public MoveInterfaceVictor getRandMove() {
		int randNum = (int) (Math.random() * buttons.length);
		while(randNum == lastButton) {
			randNum = (int) (Math.random() * buttons.length);
		}
		return getMove(randNum);
	}

	private MoveInterfaceVictor getMove(int randNum) {
		// TODO Auto-generated method stub
		return new MoveJustin(buttons[randNum]);
	}

}
