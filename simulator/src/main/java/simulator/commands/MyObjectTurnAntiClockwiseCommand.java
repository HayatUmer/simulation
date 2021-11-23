package simulator.commands;

import simulator.MyObject;

public class MyObjectTurnAntiClockwiseCommand implements Command {
	private MyObject object;

	public MyObjectTurnAntiClockwiseCommand(MyObject myobject) {
		object = myobject;
	}

	@Override
	public boolean execute() {
		return object.turnLeft();
	}

}
