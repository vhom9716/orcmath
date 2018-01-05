package myStuff;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceVictor extends Visible{

	void getProgress();

	void gameOver();

	void setRound(int roundNum);

	void setSeqNum(int size);

}
