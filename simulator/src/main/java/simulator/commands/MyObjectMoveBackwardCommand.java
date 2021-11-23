package simulator.commands;

import simulator.Area;
import simulator.MyObject;

public class MyObjectMoveBackwardCommand implements Command {
	private MyObject object;
	private Area area;

	public MyObjectMoveBackwardCommand(MyObject myobject, Area area) {
		object = myobject;
		this.area = area;
	}

	@Override
	public boolean execute() {
		object.moveBackward();
		return area.withInLimits(object.getLocation());
	}

}
