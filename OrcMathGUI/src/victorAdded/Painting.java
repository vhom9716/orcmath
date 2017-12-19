package victorAdded;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Painting extends Component {

	String artist;
	String dateOfCompletion;
	String artisticMovement;
	String imageAddress;
	String title;
	String height;
	String width;
	
	public Painting(String artist, String dateComplete, String artMove, String imgAdd, String title, String h, String w) {
		super(100, 200, 64, 64);
		this.artist = artist;
		dateOfCompletion = dateComplete;
		artisticMovement = artMove;
		imageAddress = imgAdd;
		this.title = title;
		height = h;
		width = w;
		
		/**
		 * for animating below
		 */
		//addSequence("resources/SpriteSheet.png", 150, 0, 192, 64, 64, 9);
		//Thread animation = new Thread(this);
		//animation.start();
		//update();
	}

	public String toString() {
		return title + "," + artist + "," + artisticMovement + "," + dateOfCompletion + "," + height + "," + width;
	}
	
	@Override
	public void update(Graphics2D g) {
		//super.update(g);
		//importing files
		//drag/drop into resources folder, or copy and paste it into it.
	}

}
