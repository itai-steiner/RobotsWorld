//Name: Itai Steiner
public class IllegalPosition extends Exception {
	private static final long serialVersionUID = 42L;

	public String getMessage() {
		return "You chose an Illegal Position.";
	}
}