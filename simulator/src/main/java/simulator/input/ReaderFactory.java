package simulator.input;

public class ReaderFactory {

	public InputReader createReader(String type) {
		if (type == null || type.isEmpty())
			return null;
		if ("STDIN".equals(type)) {
			return new StdinReader();
		}
		return null;
	}

}
