package simulator.commands;


import simulator.Area;
import simulator.MyObject;

public class MyObjectMoveForwardCommand implements Command {
	private MyObject object;
	private Area area;

	public MyObjectMoveForwardCommand(MyObject myobject, Area area) {
		object = myobject;
		this.area = area;
	}

	@Override
	public boolean execute() {
		object.moveForward();
		return area.withInLimits(object.getLocation());
	}

}
