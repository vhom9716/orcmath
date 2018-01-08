package myStuff;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceVictor extends Visible{

	void gameOver();

	void setRound(int roundNum);

	void setSeqNum(int size);

}
