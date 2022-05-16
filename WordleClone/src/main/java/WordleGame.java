import java.io.Serializable;

/**
 * @author Navnedia
 */
public class WordleGame  implements Serializable, evaluationConstants {

	private static final long serialVersionUID = -61192559081134857L;
	
	private final WordleWord answer;
	private byte[][] boardEvaluations; // "correct" = 0, "present" = 1, or "absent" = -1.
	private String[] guesses;
	private boolean won;
	private boolean lost;
	
	static final int WORD_LENGTH = 5;
	static final int MAX_ATTEMPTS = 6;
	
	
	public WordleGame(String answerWord) {
		this.answer = new WordleWord(answerWord);
		this.boardEvaluations = new byte[MAX_ATTEMPTS][WORD_LENGTH];
		this.guesses = new String[MAX_ATTEMPTS];
		this.won = false;
		this.lost = false;
	}
	
	// This is just playing around:
	public void printBoard() {
		StringBuilder sb = new StringBuilder();
		
		for (String word : guesses) {
			sb.setLength(0); // Clear String Builder.
			
			// Construct Letter String:
			for (char letter : word.toCharArray()) {
				sb.append("[" + ConsoleColor.GREEN + letter + ConsoleColor.RESET + "]");
			}
			System.out.println(sb.toString() + "\n");
		}
	}
	
	public static void main(String[] args) {
		WordleGame wg = new WordleGame("orate");
		wg.printBoard();
	}

}
