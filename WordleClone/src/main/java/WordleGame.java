import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Navnedia
 */
public class WordleGame  implements Serializable, evaluationConstants {

	private static final long serialVersionUID = -61192559081134857L;
	
	private final WordleWord answer;
	private byte[][] boardEvaluations; // "correct" = 0, "present" = 1, or "absent" = -1.
	private String[] guesses;
	private final int wordLength;
	private final int maxAttempts;
	private boolean won;
	private boolean lost;
	
	
	// Default parameters:
	static final int DEFAULT_WORD_LENGTH = 5;
	static final int DEFAULT_MAX_ATTEMPTS = 6;
	
	public WordleGame(String answerWord) {
		this.answer = new WordleWord(answerWord);
		this.wordLength = DEFAULT_WORD_LENGTH;
		this.maxAttempts = DEFAULT_MAX_ATTEMPTS;
		this.won = false;
		this.lost = false;
		
		initalizeEvaluations();
		initalizeGuesses();
	}
	
	/*  TEMPORARY!!!
	 * 
	 *  Note to self:
	 *  In the future instead of filling them just only define the rows length
	 *  and handle the null arrays in the print or display methods.
	 */
	private void initalizeEvaluations() {
		this.boardEvaluations = new byte[maxAttempts][wordLength];
		
		for (byte[] row : boardEvaluations) {
			Arrays.fill(row, (byte) -1);
		}
	}
	
	
	/*	TEMPORARY!!!
	 * 
	 *  Note to self: 
	 *  In the future instead of filling them with spaces just handle the null
	 *  values in the print or display methods.
	 */
	private void initalizeGuesses() {
		this.guesses = new String[maxAttempts];
		
		for (int i = 0; i < guesses.length; i++) {
			guesses[i] = "";
			for (int spaces = 0; spaces < wordLength; spaces++) {
				guesses[i] += " ";
			}
		}
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
