public class MainWordleRunner {
	
	public WordleGame game;
	
	
	public static void main(String[] args) {
		new MainWordleRunner().runGame();
	}
	
	// Used when starting/loading a new game:
	public MainWordleRunner() {
		this.game = new WordleGame(null);
	}
	
	// Used when loading an existing game:
	public MainWordleRunner(WordleGame game) {
		this.game = game;
	}
	
	public void runGame() {
		// Get inputs and run game here!!
		
		System.out.println("hi");
	}
}
