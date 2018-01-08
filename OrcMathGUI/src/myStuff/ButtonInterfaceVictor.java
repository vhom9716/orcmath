package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceVictor extends Clickable{

	void setColor(Color color);
	void setX(double x);
	void setY(double y);
	void setAction(Action a);
	void light();
	void dim();

}
