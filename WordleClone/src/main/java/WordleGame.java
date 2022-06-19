import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Navnedia
 */
public class WordleGame  implements Serializable, evaluationConstants {

	private static final long serialVersionUID = -61192559081134857L;
	
	// Default parameters (class attributes):
	private static final int DEFAULT_WORD_LENGTH = 5;
	private static final int DEFAULT_MAX_ATTEMPTS = 6;
	
	
	// Instance attributes: 
	private final WordleWord answer;
	private byte[][] boardEvaluations; // "correct" = 0, "present" = 1, or "absent" = -1.
	private String[] guesses;
	private int nextIndex = 0; // This holds the index to place the next guess in the guesses array, and the row for the boardEvaluations.
	private List<String> validWords; // Contains a list of accepted words.
	private final int wordLength;
	private final int maxAttempts;
	private boolean won = false; // NOT SURE IF THIS WILL BE NEEDED.
	private boolean lost = false; // NOT SURE IF THIS WILL BE NEEDED.
	
	
	// Constructor for randomly selected answer word:
	public WordleGame() {
		this.answer = new WordleWord(selectAnswer());
		this.wordLength = DEFAULT_WORD_LENGTH;
		this.maxAttempts = DEFAULT_MAX_ATTEMPTS;
		
		initValidWords();
		initEvaluations();
		initGuesses();
	}
	
	// Constructor for custom answer word:
	public WordleGame(String answerWord) {
		this.answer = new WordleWord(answerWord.toUpperCase());
		this.wordLength = DEFAULT_WORD_LENGTH;
		this.maxAttempts = DEFAULT_MAX_ATTEMPTS;
		
		initValidWords();
		initEvaluations();
		initGuesses();
	}
	
	
	// Loads words and selects a random one as the answer:
	// This might be changed or optimized in the future.
	private static String selectAnswer() {
		List<String> wordList = new ArrayList<>();
		Random rand = new Random();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\wordList.txt"));
			
			String line;
			while ((line = br.readLine()) != null) {
				wordList.add(line);
			}
			
			br.close();
		} catch (Exception  e) {
			e.printStackTrace();
		}
		
		return wordList.get(rand.nextInt(wordList.size()));
	}
	
	/*  TEMPORARY!!!
	 * 
	 *  Note to self:
	 *  In the future instead of filling them just only define the rows length
	 *  and handle the null arrays in the print or display methods.
	 */
	private void initEvaluations() { // Initialize evaluations
		this.boardEvaluations = new byte[maxAttempts][wordLength];
		
		/* Fill every column in every row with the -1 byte representing a blank
		 * evaluation of absent. This is so the evaluation is absent by default.
		 * This is done as a temporary solution; see method comment.
		 */
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
	private void initGuesses() { // Initialize guesses
		this.guesses = new String[maxAttempts];
		
		/* Fill each guess string with a string consisting of the appropriate
		 * number of blank spaces. This is done as a temporary solution; see
		 * method comment.
		 */
		for (int i = 0; i < guesses.length; i++) {
			guesses[i] = "";
			for (int spaces = 0; spaces < wordLength; spaces++) {
				guesses[i] += " ";
			}
		}
	}
	
	
	private void initValidWords() {
		this.validWords = new ArrayList<>();
	
		try {
			BufferedReader br = new BufferedReader(new FileReader("src//main//resources//validGuesses.txt"));
			
			String line;
			while ((line = br.readLine()) != null) {
				validWords.add(line);
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Validates input against the valid words list to ensure the word
	 * is a valid accepted word.
	 * 
	 * @param guess {@code String} to validate.
	 * @return {@code true} if the word is in the list.
	 */
	private boolean isValid(String guess) {
		return Collections.binarySearch(validWords, guess.toUpperCase()) >= 0;
	}
	
	
	public boolean addGuess(String guess) {
		if (guess == null || guess.length() != wordLength || !isValid(guess)) {
			return false;
		}
		
		guess = guess.toUpperCase();
		guesses[nextIndex] = guess;
		boardEvaluations[nextIndex++] = answer.evaluateAdvanced(guess);
		
		return true;
	}
	
	public void printBoard() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int guessIndex = 0; guessIndex < guesses.length; guessIndex++) {
			String[] evalColors = WordleWord.translateToColors(boardEvaluations[guessIndex]);
			char[] word = guesses[guessIndex].toCharArray();
			
			// Construct Letter String:
			for (int letterIndex = 0; letterIndex < word.length; letterIndex++) {
				sb.append("[" + evalColors[letterIndex] + word[letterIndex] + ConsoleColor.RESET + "]");
			}
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		WordleGame game = new WordleGame("midst");
		
		game.addGuess("orate");
		game.addGuess("thank");
		game.addGuess("still");
		game.addGuess("buist");
		game.addGuess("midst");
		
		game.printBoard();
	}

}
