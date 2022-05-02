// This is just an experiment. It's not currently being used.

public class Letter {
	
	private char value;
	private String color;
	
	public Letter(char letter) {
		this.value = letter;
		this.color = "";
	}
	
	public Letter(char letter, String colorCode) {
		this.value = letter;
		this.color = colorCode;
	}
	
	
	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	

	@Override
	public String toString() {
		return color + value + ConsoleColor.RESET;
	}
	
	public static void main(String[] args) {
		Letter letter = new Letter('c', ConsoleColor.GREEN);
		System.out.println("[" + letter + "]");
	}
}
