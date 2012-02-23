package occurrences;

import static occurrences.Constants.s7;
import static occurrences.Constants.s7index;
import static occurrences.Constants.s8;
import static occurrences.Constants.s8index;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import org.junit.Test;

import occurrences.StreamTokenizerIteratorAdapter;

/**
 * Tests for STIA.  It tests building indexes from certain constants using the STIA.
 * 
 * 
 * @author Patrick Behrens
 * 
 */
public class TestStreamTokenizerIteratorAdapter {
	
	DefaultIndexImpl index;
	StreamTokenizer st;
	ArrayList<Token> al = new ArrayList<Token>();

	/**
	 * Test method for
	 * {@link occurrences.StreamTokenizerIteratorAdapter#StreamTokenizerIteratorAdapter(java.io.StreamTokenizer)}.
	 */
	@Test
	public void testStreamTokenizerIteratorAdapter() {
		try {
			new StreamTokenizerIteratorAdapter(null);
			fail("expected assertion != null");
		} catch (IllegalArgumentException e) {

		}
	}

	/**
	 * Test method for
	 * {@link occurrences.StreamTokenizerIteratorAdapter}.
	 * @throws IOException 
	 */
	@Test
	public void testBuild() throws IOException  {
		// TODO your job: create a TIIB, then build the index from a STIA wrapped
		// around a StreamTokenizer
		
		Index index = new DefaultIndexImpl();
		StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s7));
		StreamTokenizerIteratorAdapter stia = new StreamTokenizerIteratorAdapter(tokenizer);
		TokenIteratorIndexBuilder builder = new TokenIteratorIndexBuilder(index); 
		builder.buildFrom(stia);
		assertEquals(s7index, index);
	}

	/**
	 * Test method for
	 * {@link occurrences.StreamTokenizerIteratorAdapter}.
	 * @throws IOException 
	 */
	@Test
	public void testBuild2() throws IOException {

		
		Index index = new DefaultIndexImpl();
		StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s8));
		StreamTokenizerIteratorAdapter stia = new StreamTokenizerIteratorAdapter(tokenizer);
		TokenIteratorIndexBuilder builder = new TokenIteratorIndexBuilder(index); 
		builder.buildFrom(stia);
		assertEquals(s8index, index);
		
		
	}

}
