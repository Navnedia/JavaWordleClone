public class MainWordleRunner {
	
	public transient WordleGame game;

	
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
	
	
	
	public static void main(String[] args) {
		new MainWordleRunner().runGame();
	}
	
	// Should this be static or no? 
	// Should this take a file path argument?
	private void saveGame(WordleGame game) {
		
	}
	
	public static WordleGame loadGame(String path) {
		return null;
	}
}
