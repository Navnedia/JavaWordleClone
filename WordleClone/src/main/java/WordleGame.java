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
	private boolean won;
	private boolean lost;
	
	static final int DEFAULT_WORD_LENGTH = 5;
	static final int DEFAULT_MAX_ATTEMPTS = 6;
	
	public WordleGame(String answerWord) {
		this.answer = new WordleWord(answerWord);
		initalizeEvaluations(DEFAULT_MAX_ATTEMPTS, DEFAULT_WORD_LENGTH);
		initalizeGuesses(DEFAULT_MAX_ATTEMPTS, DEFAULT_WORD_LENGTH);
		this.won = false;
		this.lost = false;
	}
	
	/*  TEMPORARY!!!
	 * 
	 *  Note to self:
	 *  In the future instead of filling them just only define the rows length
	 *  and handle the null arrays in the print or display methods.
	 */
	private void initalizeEvaluations(int attempts, int wordLength) {
		this.boardEvaluations = new byte[DEFAULT_MAX_ATTEMPTS][DEFAULT_WORD_LENGTH];
		
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
	private void initalizeGuesses(int attempts, int wordLength) {
		this.guesses = new String[attempts];
		
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
