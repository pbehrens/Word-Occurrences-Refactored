package occurrences;

/**
 * A simple immutable token.
 * 
 * @author Patrick Behrens
 */
public class DefaultToken implements Token {
final int lineNum;
final String tokenWord;
	/*
	 * Constructs a token from a word and line number.
	 * 
	 * @param word
	 *            the word
	 * @param line
	 *            the line number
	 */
	public DefaultToken(final String word, final int line) {
		
		if (word == null)
			throw new IllegalArgumentException("word == null");
		if (line <= 0)
			throw new IllegalArgumentException("line <= 0");
		this.lineNum = line;
		this.tokenWord = word;
		// TODO your job; also add any necessary fields
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.luc.cs.laufer.index.Token#getLine()
	 */
	@Override
	public int getLine() {		
		return lineNum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.luc.cs.laufer.index.Token#getWord()
	 */
	@Override
	public String getWord() {
		// TODO your job
		return tokenWord;
	}

	private static final long serialVersionUID = 5320093356413218994L;
}
