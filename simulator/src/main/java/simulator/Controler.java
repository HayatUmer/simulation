package simulator;

import java.util.HashMap;
import java.util.Map;

import simulator.commands.Command;

public class Controler {

	private Map<String, Command> commandMap;

	public Controler() {
		commandMap = new HashMap<>();
	}

	public Map<String, Command> addCommand(String key, Command command) {
		commandMap.put(key, command);
		return commandMap;
	}

	public Command getCommand(String key) {
		return commandMap.get(key);
	}

}
