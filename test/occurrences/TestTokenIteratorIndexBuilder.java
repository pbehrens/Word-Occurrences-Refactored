package occurrences;

import static occurrences.Constants.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import occurrences.DefaultIndexImpl;
import occurrences.Index;
import occurrences.StreamTokenizerIndexBuilder;
import occurrences.Token;
import occurrences.TokenIteratorIndexBuilder;

/**
 * Tests the TIIB. Makes sure the indexes are built correctly for given strings.
 * 
 * @author Patrick Behrens
 * 
 */
public class TestTokenIteratorIndexBuilder {

	/**
	 * Test method for
	 * {@link occurrences.TokenIteratorIndexBuilder#TokenIteratorIndexBuilder(java.util.Iterator)}.
	 */
	@Test
	public void testTokenIteratorIndexBuilder() {
		try {
			new StreamTokenizerIndexBuilder(null);
			fail("expected assertion != null");
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link occurrences.TokenIteratorIndexBuilder#build(occurrences.Index)}.
	 */
	@Test
	public void testBuild() throws Exception {
		Index index = new DefaultIndexImpl();
		TokenIteratorIndexBuilder builder = new TokenIteratorIndexBuilder(index);
		builder.buildFrom(stringToList(s7).iterator());
		assertEquals(s7index, index);
	}

	/**
	 * Test method for
	 * {@link occurrences.TokenIteratorIndexBuilder#build(occurrences.Index)}.
	 */
	@Test
	public void testBuild2() throws Exception {
		Index index = new DefaultIndexImpl();
		TokenIteratorIndexBuilder builder = new TokenIteratorIndexBuilder(index);
		builder.buildFrom(stringToList(s8).iterator());
		assertEquals(s8index, index);
	}

	/**
	 * Converts a string to a list of tokens.
	 * 
	 * @param string
	 *            the input string
	 * @return the resulting list of tokens
	 */
	private List<Token> stringToList(final String string) throws IOException{
		// TODO your job
		// follow Main.main but put the tokens into a suitable list

		LinkedList<Token> al = new LinkedList<Token>();
		 
		  //String word = "";
		 
		  String in = string;
		  StreamTokenizer s = new StreamTokenizer(new StringReader(in));
		 
		  int token;
		  while ((token = s.nextToken()) != StreamTokenizer.TT_EOF) {
		   if (token == StreamTokenizer.TT_WORD) {
		     //problem here, not reading the sval from the StreamTokenizer!!!
		    DefaultToken t = new DefaultToken(s.sval, s.lineno());
		    al.add(t);
		  }
		  //return al;
		  }
		  return al;
	}
}
