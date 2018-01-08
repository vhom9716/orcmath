package myStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJustin extends Button implements ButtonInterfaceVictor {

	private Color buttonColor;
	private Color originalColor;
	private Color lighterColor;
	private boolean enabled;
	
	public ButtonJustin(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, "", color, null);
		enabled = false;
		if(color != null) {
			originalColor = buttonColor = color; 
			lighterColor = buttonColor.brighter();
		}
		update();
	}
	
	@Override
	public void drawButton(Graphics2D g, boolean hover){
		Ellipse2D ellipse = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
		g.setColor(buttonColor);
		g.draw(ellipse);
		g.fill(ellipse);
	}

	@Override
	public void setColor(Color color) {
		if(buttonColor != null) {
			buttonColor = color;
			lighterColor = buttonColor.brighter();
		}
	}
	
	@Override
	public void light() {
		enabled = true;
	}

	@Override
	public void dim() {
		enabled = false;
	}
	
	public void update() {
		if(enabled) {
			setColor(lighterColor);
		}
		else {
			setColor(originalColor);
		}
		super.update();
	}

}
