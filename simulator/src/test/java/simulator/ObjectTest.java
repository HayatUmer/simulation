package simulator;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ObjectTest {

	@ParameterizedTest
	@MethodSource("start")
	void testMoveForward(Point start) {
		MyObject obj = new MyObject(new Point(start));
		obj.moveForward();
		assertEquals(start.x + obj.getDirection().getValue().x, obj.getLocation().x);
		assertEquals(start.y + obj.getDirection().getValue().y, obj.getLocation().y);
	}
	
	@ParameterizedTest
	@MethodSource("start")
	void testMoveBackwards(Point start) {
		MyObject obj = new MyObject(new Point(start));
		obj.moveBackward();
		assertEquals(start.x - obj.getDirection().getValue().x, obj.getLocation().x);
		assertEquals(start.y - obj.getDirection().getValue().y, obj.getLocation().y);
	}

	private static Stream<Arguments> start() {
	    return Stream.of(
				Arguments.of(new Point(0, 1)),
	            Arguments.of(new Point(-1, 0)),
	            Arguments.of(new Point(0, -1)),
	            Arguments.of(new Point(0, 1))
	            
	    );
	}
	
	@Test
	void testTurnRight() {
		MyObject obj = new MyObject(new Point(0, 0));
		obj.turnRight();
		assertEquals(Direction.EAST, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
		obj.turnRight();
		assertEquals(Direction.SOUTH, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
		obj.turnRight();
		assertEquals(Direction.WEST, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
		obj.turnRight();
		assertEquals(Direction.NORTH, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
	}
	
	@Test
	void testTurnLeft() {
		MyObject obj = new MyObject(new Point(0, 0));
		obj.turnLeft();
		assertEquals(Direction.WEST, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
		obj.turnLeft();
		assertEquals(Direction.SOUTH, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
		obj.turnLeft();
		assertEquals(Direction.EAST, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
		obj.turnLeft();
		assertEquals(Direction.NORTH, obj.getDirection());
		assertEquals(new Point(0, 0), obj.getLocation());
	}
	
	
}
