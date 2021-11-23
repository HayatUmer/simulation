package simulator.commands;

import simulator.Area;
import simulator.MyObject;

public class MyObjectStopAndExitCommand implements Command {
	private MyObject object;

	public MyObjectStopAndExitCommand(MyObject myobject, Area area) {
		object = myobject;
	}

	@Override
	public boolean execute() {
		System.out.println("[" + object.getLocation().x + "," + object.getLocation().y + "]");
		return true;
	}

}
