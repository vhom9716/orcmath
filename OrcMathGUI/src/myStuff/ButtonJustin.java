package myStuff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJustin extends Button implements ButtonInterfaceVictor {

	private Color buttonColor;
	private Color originalColor;
	private Color lighterColor;
	private boolean enabled;
	
	public ButtonJustin(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, "", color, action);
		enabled = false;
		setColor(color);
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
		if(color != null) {
			originalColor = buttonColor = color; 
			lighterColor = buttonColor.brighter();
		}
		update();
	}
	
	@Override
	public void light() {
		enabled = true;
		update();
	}

	@Override
	public void dim() {
		enabled = false;
		update();
	}
	
	public void update() {
		if(enabled) {
			buttonColor = lighterColor;
		}
		else {
			buttonColor = originalColor;
		}
		BufferedImage hoverImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D hoverG = hoverImage.createGraphics();
		applyStyles(hoverG);
		drawButton(hoverG, true);
		super.update();
	}

}
