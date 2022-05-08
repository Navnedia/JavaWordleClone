
/**
 * Contains evaluation constants to represent the three possible
 * states of a letter after being evaluated.
 * 
 * <ul>
 * 		<li>CORRECT: The letter is in the word AND in the correct spot.</li>
 * 		<li>PRESENT: The letter is in the word BUT in the wrong spot.</li>
 * 		<li>ABSENT: The letter is NOT in the word.</li>
 * </ul>
 * 
 * @author Navnedia
 */
public interface evaluationConstants {
	
	// Letter Evaluations:
	/** The letter is in the word AND in the correct spot. */
	static final byte CORRECT = 0;
	/** The letter is in the word BUT in the wrong spot. */
	static final byte PRESENT = 1;
	/** The letter is NOT in the word. */
	static final byte ABSENT = -1;
}
