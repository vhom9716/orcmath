package practice;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PractiveScreen extends FullFunctionScreen{

	private Button buttonThing;
	private TextLabel counter;
	private TextLabel countdown;
	private int count = 0;
	
	public PractiveScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		countdown = new TextLabel(400, 400, 200, 40, "");
		viewObjects.add(countdown);
		counter = new TextLabel(600, 600, 200, 40, "The count is: "+count);
		viewObjects.add(counter);
		buttonThing = new Button(100, 100, 200, 40, "Ready", new Action() {
			public void act() {
				Thread time = new Thread(new Runnable(){
					public void run() {
						buttonThing.setEnabled(false);
						for(int i = 3; i > 0; i--) {
							countdown.setText(i + ".........");
							System.out.println(i);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(i == 1) {
								countdown.setText("Go");
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						buttonThing.setEnabled(true);
						buttonThing.setText("Click Me!");
						countdown.setText("");
						buttonThing.setAction(new Action(){
							public void act() {
								count++;
								counter.setText("Score: "+count);
								update();
							}
						});
						Thread time = new Thread(new Runnable(){
							public void run() {
								countdown.setText("5");
								for(int i = 5; i > 0; i--) {
									Thread blah = new Thread();
									try {
										Thread.sleep(1000);						
									} catch (InterruptedException e) {							
										e.printStackTrace();
									}
									countdown.setText(""+(i - 1));
								}
								buttonThing.setText("Done");
								buttonThing.setEnabled(false);
							}});
						time.run();
					}
				});
				time.start();
				countdown.setText("");
			}
		});
		viewObjects.add(buttonThing);	
	};
}
