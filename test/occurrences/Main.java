package occurrences;

import java.io.StreamTokenizer;
import java.io.StringReader;

import occurrences.DefaultIndexImpl;
import occurrences.Index;

public class Main {

	/**
	 * Tests out the code for Occurrences
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Index index = new DefaultIndexImpl();

		String in = "politics without without principle\npleasure without conscience";
		StreamTokenizer s = new StreamTokenizer(new StringReader(in));
		s.ordinaryChar('.');

		int token;
		while ((token = s.nextToken()) != StreamTokenizer.TT_EOF) {
			if (token == StreamTokenizer.TT_WORD) {
				index.add(s.sval, s.lineno());
			}
		}

		System.out.println(index);
	}

}
