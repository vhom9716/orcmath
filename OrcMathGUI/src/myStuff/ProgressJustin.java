package myStuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJustin extends Component implements ProgressInterfaceVictor {

	private int roundNumber;
	private int seqNumber;
	private boolean gameOver;
	
	public ProgressJustin(int x, int y, int w, int h) {
		super(x, y, w, h);
		gameOver = false;
	}

	@Override
	public void gameOver() {
		gameOver = true;
	}

	@Override
	public void setRound(int roundNum) {
		roundNumber = roundNum;
	}

	@Override
	public void setSeqNum(int size) {
		seqNumber = size;
	}

	@Override
	public void update(Graphics2D g) {
		Font myFont = new Font("Serif", Font.PLAIN, 12);
		g.setFont(myFont);
		g.setColor(Color.BLACK);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver) {
			g.drawString("Game Over! You lost!", 0, fm.getHeight());
		}
		else {
			g.drawString("Round Number: " + roundNumber + "\n" +
						 "Sequence Number: " + seqNumber + "\n", 0, fm.getHeight());
		}
	}

}
