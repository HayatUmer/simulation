package simulator.input;

import java.util.Scanner;

public class StdinReader implements InputReader {


	public String[] read() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().split(",");
	}

}
