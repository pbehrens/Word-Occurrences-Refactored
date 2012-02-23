package occurrences;
 
import java.io.IOException;
import java.io.StreamTokenizer;
 
/**
 * An index builder that populates an index from a source represented by a
 * StreamTokenizer.
 * 
 * @author Patrick Behrens
 * 
 */
public class StreamTokenizerIndexBuilder {
 
 //private Index i = new DefaultIndexImpl();
 private Index index;
 
 /**
  * Constructs a builder for the given index.
  * 
  * @param index
  *            the Index to be built
  */
 public StreamTokenizerIndexBuilder(final Index index) {
  if (index == null)
   throw new IllegalArgumentException("index == null");
  // added field
  this.index = index;
 }
 
 /**
  * Builds the index from the given source.
  * 
  * @param source
  *            the StreamTokenizer from which to build the index
  */
 public void buildFrom(StreamTokenizer source) {
  if (source == null)
   throw new IllegalArgumentException("source == null");
  try {
   // added
   
   
   while((source.nextToken()) != StreamTokenizer.TT_EOF){

	   //get the value of the token and the line number and add it to the index
     String word = source.sval;
     int line = source.lineno();
     index.add(word, line);
     
    
    
   }
   System.out.println(index);
  
  } catch (IOException e) {
   throw new RuntimeException(e);
  }
 }
 
}