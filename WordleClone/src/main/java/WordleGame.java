import java.io.Serializable;

/**
 * @author Navnedia
 */
public class WordleGame  implements Serializable, evaluationConstants {

	private static final long serialVersionUID = -61192559081134857L;
	
	/**
	 * Here are some ideas, some might be redundant like the board and the guesses.
	 * Maybe the list should actually be an array.
	 * Maybe the wordleWords show be 
	 */
	private WordleWord answer;
	private String[][] boardEvaluations; // "correct", "present", or "absent".
	private WordleWord[] guesses;
	static final int WORD_LENGTH = 5;
	static final int MAX_ATTEMPTS = 6;
	
	
	public WordleGame(WordleWord[] words) {
		this.guesses = words;
	}
	
	// This is just playing around:
	public void printBoard() {
		StringBuilder sb = new StringBuilder();
		
		for (WordleWord wordleWord : guesses) {
			sb.setLength(0); // Clear String Builder.
			
			// Construct Letter String:
			for (char letter : wordleWord.wordValue.toCharArray()) {
				// Maybe I can some how integrate the colors into the letter like having a letter class
				sb.append("[" + ConsoleColor.GREEN + letter + ConsoleColor.RESET + "]");
			}
			System.out.println(sb.toString() + "\n");
		}
	}
	
	public static void main(String[] args) {
		WordleWord[] words = {new WordleWord("orate"),
							  new WordleWord("hello"),
							  new WordleWord("balls"),
							  new WordleWord("fudge"),
							  new WordleWord("dodge")};
		
		WordleGame wg = new WordleGame(words);
		
		wg.printBoard();
	}

}
