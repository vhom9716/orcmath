package myStuff;

public class MoveJustin implements MoveInterfaceVictor {

	private ButtonInterfaceVictor moveButton;
	
	public MoveJustin(ButtonInterfaceVictor button) {
		this.moveButton = button;
	}

	@Override
	public ButtonInterfaceVictor getButton() {
		return this.moveButton;
	}

}
