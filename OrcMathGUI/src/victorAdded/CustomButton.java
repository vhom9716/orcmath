package victorAdded;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {

	private String s1;
	private String s2;
	private Color c;

	public CustomButton(int x, int y) {
		super(x, y, 200, 100, "", null);
		// TODO Auto-generated constructor stub
	}

	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.black);
		g.drawString(s1, 30, 50);
		g.drawString(s2, 30, 50);
		g.setColor(c);
		g.drawRect(0, 0, 200, 200);
	}
	
	public void updateString1() {
		
	}
	
	public void updateString2() {
		
	}
	
	public void setIconColor() {
		
	}
	
}
