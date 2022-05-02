import java.io.Serializable;
import java.util.Arrays;

public class WordleWord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public char[] wordValue;
	
	
	public WordleWord(String word) {
		this.wordValue = word.toCharArray();
	}
	
	public WordleWord(char[] word) {
		this.wordValue = word;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(wordValue);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {return true;}
		if (obj == null) {return false;}
		if (getClass() != obj.getClass()) {return false;}
		
		WordleWord other = (WordleWord) obj;
		if (!Arrays.equals(wordValue, other.wordValue)) {return false;}
		
		return true;
	}
	
}
