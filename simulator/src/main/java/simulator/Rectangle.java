package simulator;

import java.awt.Point;

public class Rectangle implements Area {

	private final int width;
	private final int length;

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public boolean withInLimits(Point location) {
		return (location.x >= 0 && location.y >= 0 && location.x < width - 1 && location.y < length - 1);
	}

}
