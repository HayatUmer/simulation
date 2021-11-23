package simulator;

import java.awt.Point;

import simulator.commands.MyObjectMoveBackwardCommand;
import simulator.commands.MyObjectMoveForwardCommand;
import simulator.commands.MyObjectStopAndExitCommand;
import simulator.commands.MyObjectTurnAntiClockwiseCommand;
import simulator.commands.MyObjectTurnClockwiseCommand;
import simulator.input.InputReader;
import simulator.input.ReaderFactory;

public class Simulator {

	private MyObject object;
	private Area room;

	private Controler controller;

	public Simulator(int roomWidth, int roomHeight, int carLocationX, int carLocationY) {
		room  = new Rectangle(roomHeight, roomWidth);
		object = new MyObject(new Point(carLocationX, carLocationY));
		controller = new Controler();
		controller.addCommand("0", new MyObjectStopAndExitCommand(object, room));
		controller.addCommand("1", new MyObjectMoveForwardCommand(object, room));
		controller.addCommand("2", new MyObjectMoveBackwardCommand(object, room));
		controller.addCommand("3", new MyObjectTurnClockwiseCommand(object));
		controller.addCommand("4", new MyObjectTurnAntiClockwiseCommand(object));
	}
	
	public static void main(String[] args) {


		InputReader reader = reader();
		String[] header = reader.read();
		validateHeader(header);
		Simulator simulator = simulator(header);

		String[] commands = reader.read();
		validateCommands(commands);
		if (!simulator.runCommands(commands)) {
			System.out.println("[-1,-1]");
		}

	}

	private static InputReader reader() {
		ReaderFactory factory = new ReaderFactory();
		return factory.createReader("STDIN");
	}

	private static Simulator simulator(String[] header) {
		return new Simulator(
				Integer.valueOf(header[0]), 
				Integer.valueOf(header[1]),
				Integer.valueOf(header[2]), 
				Integer.valueOf(header[3]));
	}

	private boolean runCommands(String[] commands) {
		for (String command : commands) {
			if (!controller.getCommand(command).execute()) {
				return false;
				}
			}
		return true;
	}

	static void validateHeader(String[] args) {
		if (args.length < 1 || args.length < 4) {
			throw new IllegalArgumentException(
					"Invalid Arguments: Please provide size of table and starting position of object e.g 4,4,2,2");
		}
	}

	static void validateCommands(String[] commands) {
		for(String command: commands) {
			Integer cmNo = Integer.valueOf(command);
			if (cmNo < 0 || cmNo > 4) {
				throw new IllegalArgumentException("Invalid command");
			}
		}
	}

}
