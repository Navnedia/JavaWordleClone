import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Navnedia
 */
public class WordleWord implements Serializable, evaluationConstants {
	
	private static final long serialVersionUID = -5748366559941088303L;
	
	public final String wordValue;
	
	
	public WordleWord(String word) {
		this.wordValue = word;
	}
	
	/**
	 * Compares an input word against this {@code WordleWord} object.
	 * Simple first pass for evaluating. More complex logic down the line.
	 * 
	 * @param guess the {@code String} word to evaluate against.
	 * @return A {@code byte[]} with the evaluations of each index/letter of the word.
	 * 			<ul>
	 * 				<li>CORRECT: 0 when the letter is in the word AND in the correct spot.</li>
	 * 				<li>PRESENT: 1 when the letter is in the word BUT in the wrong spot.</li>
	 * 				<li>ABSENT: -1 when the letter is NOT in the word.</li>
	 * 			</ul>
	 */
	public byte[] evaluateSimple(String guess) {
		// Guard statement to protect against bad inputs:
		if (guess == null || guess.length() != wordValue.length()) { throw new IllegalArgumentException();}
		
		char[] guessChars = guess.toCharArray();
		byte[] evaluations = new byte[wordValue.length()];
		
		for (int i = 0; i < guessChars.length; i++) {
			int location = wordValue.indexOf(guessChars[i]);
			
			if (location == i) {
				evaluations[i] = CORRECT;
			} else if (location >= 0) {
				evaluations[i] = PRESENT;
			} else {
				evaluations[i] = ABSENT;
			}
		}
		
		return evaluations;
	}
	
	
	public byte[] evaluateAdvanced(String guess) {
		// Guard statement to protect against bad inputs:
		if (guess == null || guess.length() != wordValue.length()) { throw new IllegalArgumentException();}
		
		char[] guessChars = guess.toCharArray();
		byte[] evaluations = new byte[wordValue.length()];
		Arrays.fill(evaluations, ABSENT);
		
		for (int answerIndex = 0; answerIndex < wordValue.length(); answerIndex++) {
			char answerLetter = wordValue.charAt(answerIndex);
			
			if (guessChars[answerIndex] == answerLetter) {
				evaluations[answerIndex] = CORRECT;
			} else {
				for (int guessIndex = 0; guessIndex < guessChars.length; guessIndex++) {
					if ((evaluations[guessIndex] != PRESENT && evaluations[guessIndex] != CORRECT) && (guessChars[guessIndex] == answerLetter)) {
						evaluations[guessIndex] = PRESENT;
						break;
					}
				}
			}
		}
		
		return evaluations;
	}
	
	
	/**
	 * This method allows you to convert/translate a byte[] of evaluations
	 * into a more easily understandable String[] representation. This method
	 * is primarily for debugging purposes. 
	 * 
	 * @param origEvaluation {@code byte[]} to be translated.
	 * @return A {@code String[]} that provides a more readable representation
	 * 		   of the evaluation.
	 * 			<ul>
	 * 				<li>"correct" when the letter is in the word AND in the correct spot.</li>
	 * 				<li>"present" when the letter is in the word BUT in the wrong spot.</li>
	 * 				<li>"absent" when the letter is NOT in the word.</li>
	 * 			</ul>
	 */
	public static String[] translateEvaluation(byte[] origEvaluation) {
		String[] strEvaluation = new String[origEvaluation.length];
		
		for (int i = 0; i < strEvaluation.length; i++) {
			switch (origEvaluation[i]) {
			case CORRECT:
				strEvaluation[i] = "correct";
				break;
			case PRESENT:
				strEvaluation[i] = "present";
				break;
			case ABSENT:
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
		
		byte[] evaluation = answer.evaluateAdvanced("title");
		
		System.out.println(Arrays.toString(evaluation));
		System.out.println(Arrays.toString(translateEvaluation(evaluation)));
	}
	
}
