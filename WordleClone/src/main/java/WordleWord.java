import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * @author Navnedia
 */
public class WordleWord implements Serializable {
	
	private static final long serialVersionUID = -5748366559941088303L;
	
	public String wordValue;
	
	
	public WordleWord(String word) {
		this.wordValue = word;
	}
	
	/**
	 * Compares an input word against this {@code WordleWord} object.
	 * Simple first pass for evaluating. More complex logic down the line.
	 * 
	 * @param guess the {@code String} word to evaluate against.
	 * @return A {@code byte[]} with the evaluations of each index/letter of the word.
	 * 		   0 when the letter is in the word AND in the correct spot.
	 * 		   1 when the letter is in the word BUT in the wrong spot.
	 *  	   -1 when the letter is NOT in the word.
	 */
	public byte[] evaluate(String guess) {
		// Guard statement to protect against bad inputs:
		if (guess == null || guess.length() != wordValue.length()) { throw new IllegalArgumentException();}
		
		char[] guessChars = guess.toCharArray();
		byte[] evaluations = new byte[wordValue.length()];
		
		for (int i = 0; i < guessChars.length; i++) {
			int location = wordValue.indexOf(guessChars[i]);
			
			if (location == i) {
				evaluations[i] = WordleGame.CORRECT;
			} else if (location >= 0) {
				evaluations[i] = WordleGame.PRESENT;
			} else {
				evaluations[i] = WordleGame.ABSENT;
			}
		}
		
		return evaluations;
	}
	
	public static String[] translateEvaluation(byte[] origEvaluation) {
		String[] strEvaluation = new String[origEvaluation.length];
		
		for (int i = 0; i < strEvaluation.length; i++) {
			switch (origEvaluation[i]) {
			case WordleGame.CORRECT:
				strEvaluation[i] = "correct";
				break;
			case WordleGame.PRESENT:
				strEvaluation[i] = "present";
				break;
			case WordleGame.ABSENT:
				strEvaluation[i] = "absent";
				break;
			default:
				throw new IllegalArgumentException("Input contains an invalid evaluation int");
			}
		}
		
		return strEvaluation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wordValue == null) ? 0 : wordValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {return true;}
		if (obj == null) {return false;}
		if (getClass() != obj.getClass()) {return false;}
		
		WordleWord otherWord = (WordleWord) obj;
		if (wordValue == null) {
			if (otherWord.wordValue != null) {return false;}
		} else if (!wordValue.equals(otherWord.wordValue)) {
			return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		WordleWord answer = new WordleWord("midst");
		
		byte[] evaluation = answer.evaluate("title");
		
		System.out.println(Arrays.toString(translateEvaluation(evaluation)));
	}
	
}
