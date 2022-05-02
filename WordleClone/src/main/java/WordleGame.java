import java.util.ArrayList;
import java.util.List;

public class WordleGame {
	
	/**
	 * Here are some ideas, some might be redundant like the board and the guesses.
	 * Maybe the list should actually be an array.
	 * Maybe the wordleWords show be 
	 */
	private WordleWord answer;
	private char[][] board;
	private List<WordleWord> guesses;
	private int wordLength;
	private int maxAttempts;
	
	public WordleGame(List<WordleWord> words) {
		guesses = new ArrayList<WordleWord>(words);
	}
	
	// This is just playing around:
	public void printboard() {
		StringBuilder sb = new StringBuilder();
		
		for (WordleWord wordleWord : guesses) {
			sb.setLength(0); // Clear String Builder.
			
			// Construct Letter String:
			for (char letter : wordleWord.wordValue) {
				// Maybe I can some how integrate the colors into the letter like having a letter class
				sb.append("[" + ConsoleColor.GREEN + letter + ConsoleColor.RESET + "]");
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		List<WordleWord> words = new ArrayList<WordleWord>();
		words.add(new WordleWord("orate"));
		words.add(new WordleWord("hello"));
		words.add(new WordleWord("balls"));
		words.add(new WordleWord("fudge"));
		words.add(new WordleWord("dodge"));
		
		WordleGame wg = new WordleGame(words);
		
		wg.printboard();
		
	}

}
