 package main.java.com.inteliment.wordsearchcount.model;
 import java.util.Map;
/**
 * 
 * @author Nipun
 * Class encapsulating the search results
 * SearchResults class containing a Map of the texts and their counts
 */
public class TextSearchResults {

	Map<String,Integer>[] counts;
 
	public Map<String,Integer>[] getCounts() {
		return counts;
	}
	public void setCounts(Map<String,Integer>[] counts) {
		this.counts = counts;
	}

}