package simulator.commands;

import simulator.MyObject;

public class MyObjectTurnClockwiseCommand implements Command {
	private MyObject object;

	public MyObjectTurnClockwiseCommand(MyObject myobject) {
		object = myobject;
	}

	@Override
	public boolean execute() {
		return object.turnRight();
	}

}
