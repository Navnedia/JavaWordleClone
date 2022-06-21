import javax.swing.JOptionPane;

public class MainWordleRunner {
	
	public WordleGame game;

	
	public static void main(String[] args) {
		new MainWordleRunner().runGame();
	}
	
	
	
	// Used when starting/loading a new game:
	public MainWordleRunner() {
		this.game = new WordleGame();
	}
	
	// Used when loading an existing game:
	public MainWordleRunner(WordleGame game) {
		this.game = game;
	}
	
	public void runGame() {
		// Get inputs and run game here!!
		
		while (!game.hasWon() && !game.hasLost()) {
			boolean guessValid = false;
			
			while (!guessValid) {
				String guessInput = JOptionPane.showInputDialog("Enter your guess:");
				guessValid = game.addGuess(guessInput);
			}
		}
	}
	
	
	// Should this be static or no? 
	// Should this take a file path argument?
	private void saveGame(WordleGame game) {
		
	}
	
	public static WordleGame loadGame(String path) {
		return null;
	}
}
