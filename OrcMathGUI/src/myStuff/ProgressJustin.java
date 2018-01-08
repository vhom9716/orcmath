package myStuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;
import guiTeacher.components.StyledComponent;

public class ProgressJustin extends StyledComponent implements ProgressInterfaceVictor {

	private int roundNumber;
	private int seqNumber;
	private boolean gameOver;
	
	public ProgressJustin(int x, int y, int w, int h) {
		super(x, y, w, h);
		gameOver = false;
		update();
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void setRound(int roundNum) {
		roundNumber = roundNum;
		update();
	}

	@Override
	public void setSeqNum(int size) {
		seqNumber = size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		Font myFont = new Font("Helvetica", Font.PLAIN, 20);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver) {
			g.drawString("Game Over! You lost!", 0, fm.getHeight());
		}
		else {
			g.drawString("Round Number: " + roundNumber, 0, fm.getHeight());
			g.drawString("Sequence Number: " + seqNumber, 0, fm.getHeight() * 2);
		}
	}

}
