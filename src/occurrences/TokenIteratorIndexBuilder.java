package occurrences;

import java.util.Iterator;

/**
 * An index builder that populates an index from a source represented by an
 * iterator over tokens.
 * 
 * @author Patrick Behrens
 */
public class TokenIteratorIndexBuilder {
private Index index;
	/**
	 * Constructs a builder for the given index.
	 * 
	 * @param index
	 *            the Index to be built
	 */
	public TokenIteratorIndexBuilder(final Index index) {
		if (index == null)
			throw new IllegalArgumentException("index == null");
		//builder = new StreamTokenizerIndexBuilder(index);
		this.index = index;
	}

	/**
	 * Builds the index from the given source.
	 * 
	 * @param source
	 *            the Iterator over Tokens from which to build the index
	 */
	public void buildFrom(final Iterator<Token> source) {
		if (source == null)
			throw new IllegalArgumentException("source == null");
		Token t = null;
		while(source.hasNext()){
			t = source.next();
			index.add(t.getWord(), t.getLine());
		}
			
	}
}
