package occurrences;

//import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.IOException;

/**
 * An adapter that makes a StreamTokenizer look like an Iterator.
 * 
 * @author Patrick Behrens
 */
public class StreamTokenizerIteratorAdapter implements Iterator<Token> {
	
	StreamTokenizer st;

	/**
	 * Constructs an adapter for the given StreamTokenizer.
	 * 
	 * @param source
	 *            the StreamTokenizer
	 */
	public StreamTokenizerIteratorAdapter(final StreamTokenizer source) {
		if (source == null)
			throw new IllegalArgumentException("source == null");
		// added field
		st = source;
	}

	/**
	 * hasNext() Returns true if the iteration has more elements. 
	 * 
	 * @return true if the iteration has more elements.
	 * @return false if the iteration has no more elements.
	 */
	
	@SuppressWarnings("unused")
	@Override
	public boolean hasNext() {
		
		// added
		//check if the streamtokenizer is null
		if (st == null)
			{
				throw new IllegalArgumentException("source == null");
			}
		//if the next token is the EOF return false
			try {
				if(st.nextToken() == StreamTokenizer.TT_EOF) {
					return false;
			}
			else
			return true;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	

	/**
	 * next() Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration.
	 * @throws NoSuchElementException - iteration has no more elements.
	 */
	@Override
	public Token next() {
		//return a default token with the proper values
		DefaultToken tempToken = new DefaultToken(st.sval, st.lineno());;
		return tempToken;
	}

	/**
	 * remove () Removes from the underlying collection the last 
	 * element returned by the iterator (optional operation). T
	 * his method can be called only once per call to next. 
	 * The behavior of an iterator is unspecified if the underlying 
	 * collection is modified while the iteration is in progress in 
	 * any way other than by calling this method.
	 * 
	 * @throws UnsupportedOperationException - if the remove 
	 * 			operation is not supported by this Iterator. 
	 * @throws IllegalStateException - if the next method has 
	 * 			not yet been called, or the remove method has already 
	 * 			been called after the last call to the next method.
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
