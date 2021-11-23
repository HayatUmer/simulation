package simulator;

import java.awt.Point;
import java.util.EnumSet;

public enum Direction {
	NORTH(0, -1), SOUTH(0, 1), EAST(1, 0), WEST(-1, 0);

	private Point value;

	Direction(int x, int y) {
		value = new Point(x, y);
	}

	public Point getValue() {
		return value;
	}

	public static Direction fromValue(Point value) {
		return EnumSet.allOf(Direction.class).stream().filter(d -> d.value.equals(value)).findAny().orElse(null);
	}

}
