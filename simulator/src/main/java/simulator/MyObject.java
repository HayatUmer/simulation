package simulator;

import java.awt.Point;

public class MyObject {

	private Direction direction;
	private Point location;

	public MyObject(Point location) {
		this.direction = Direction.NORTH;
		this.location = location;
	}

	public boolean moveForward() {
		location.setLocation(location.getX() + direction.getValue().getX(),
				location.getY() + direction.getValue().getY());
		return true;
	}

	public boolean moveBackward() {
		location.setLocation(location.getX() - direction.getValue().getX(),
				location.getY() - direction.getValue().getY());
		return true;
	}

	public boolean turnRight() {
		Point newDirection = new Point(direction.getValue().y * -1, direction.getValue().x); // switch -y,x
		direction = Direction.fromValue(newDirection);
		return true;
	}

	public boolean turnLeft() {
		Point newDirection = new Point(direction.getValue().y, direction.getValue().x * -1); // switch y,-x
		direction = Direction.fromValue(newDirection);
		return true;
	}

	public Point getLocation() {
		return location;
	}

	public Direction getDirection() {
		return direction;
	}

}
