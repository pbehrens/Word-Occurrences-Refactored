package occurrences;

import java.util.Map.Entry;
import java.util.*;

/**
* An efficient implementation of an index that keeps the index in alphabetical
* order.
*
* @author Patrick Behrens
* @author Kathy Rusniak
* @author Chris Abplanalp
* @author Shun Matsushita
*/
public  final class DefaultIndexImpl implements Index {
	private Map<String, List<Integer>> index;
	private final List<Integer> emptyList = new LinkedList<Integer>();
	private final List<Integer> finalList = Collections.unmodifiableList(emptyList);
	
	/**
	* DefaultIndexImpl()
	* Creates a new TreeMap structure for index
	*
	*/
	public DefaultIndexImpl() {
	       index = new TreeMap<String, List<Integer>>();
	   }
	
	/**
	* DefaultIndexImpl()
	* Creates a copy of the Map to pass the instances
	*
	*/
	public DefaultIndexImpl(Map<String, List<Integer>> otherMap) {
	       index = otherMap;
	}
	
	
	/**
	* getMap()
	* Returns the map in which the index is stored. Performs lazy
	* initialization. Must be used in other methods instead of direct access to
	* the map instance variable.
	*
	* @return the map
	*/
	protected Map<String, List<Integer>> getMap() {
		if(index == null)
		{
			index = new TreeMap<String, List<Integer>>();
			return index;
		}
		else
		{
			return index;
		}
	}
	
	/**
	* lines()
	* Returns immutable list of line numbers (possibly containing duplicates) where a
	* specific word occurs in a document.
	*
	* @param     word        word whose occurrence is counted in a document.
	*
	*
	*/  
	@Override
	public List<Integer> lines(final String word) {
	  
	    if(this.getMap().containsKey(word)) {
	       List<Integer> fList = this.getMap().get(word);
	       return Collections.unmodifiableList(fList);
	    }
	       return finalList;
	}
	
	/**
	* add()
	* put a word and a line number into the map
	*
	* @param     word        word to be stored in the map.
	* @param     line          line number to be stored in the map
	*
	*/  
	@Override
	public void add(final String word, final int line) {
	
		if(this.getMap().containsKey(word))
		{
			this.getMap().get(word).add(line);
		}
		else
		{
			List<Integer> lineCount = new LinkedList<Integer>();
			lineCount.add(line);
			this.getMap().put(word, lineCount);
		}
	}
	
	/**
	* frequency()
	* Returns the numbers of counting a particular word in a particular line.
	*
	* @param     word        word to be counted.
	*
	* @return     number of the word in a line
	*/
	@Override
	public int frequency(final String word) {
	
		return this.lines(word).size();
	}
	
	/**
	* iterator()
	* Returns an iterator for the Entries in the map
	*
	* @return New instance of iterator for each entry in the index
	*/
	@Override
	public Iterator<Entry<String, List<Integer>>> iterator() {
		return this.getMap().entrySet().iterator();
	}
	
	/**
	* clear()
	* Removes all data from the map.
	*
	*/
	@Override
	public void clear() {
	   this.getMap().clear();
	  }
	
	/**
	* size()
	* Returns the number of words in the map.
	*
	* @return the number of words
	*/
	@Override
	public int size() {
	// TODO your job
		return this.getMap().size();
	}
	
	/**
	* contains()
	* Checks whether the map contains a particular word.
	*
	* @param word the word
	* @return whether the map contains the word
	*/
	@Override
	public boolean contains(String word) {
	// TODO your job
		return this.getMap().containsKey(word);
	}
	
	/**
	* equals()
	* Checks the equality of objects in DefaultIndexImpl
	*
	* @param that Object to compare to this object
	* @return True if this and that is equal, otherwise return false
	*/
	@Override
	public boolean equals(Object that) {
	// TODO your job
	// HINT use that's iterator to construct a (unsorted) set of entries
	// then compare the set with this's entry set
		if(that == null)
			return false;
		if(!(that instanceof DefaultIndexImpl))
		return false;
		Iterator<Map.Entry<String, List<Integer>>> thatIter = ((DefaultIndexImpl) that).iterator();
		Iterator<Map.Entry<String, List<Integer>>> thisIter = ((DefaultIndexImpl) this).iterator();
		HashSet<Entry> thatSet = new HashSet<Entry>();
		HashSet<Entry> thisSet = new HashSet<Entry>();
		   while(thatIter.hasNext())
		   {
		       thatSet.add(thatIter.next());
		   }
		   while(thisIter.hasNext())
		   {
		       thisSet.add(thisIter.next());
		   }
		
		   return thisSet.equals(thatSet);
	  }
	
	/**
	* toString()
	* Returns String of the map
	*
	* @return the index
	*/
	@Override
	public String toString() {
	      return index.toString();
	  }
	
	private static final long serialVersionUID = 8119984256641351649L;
}

