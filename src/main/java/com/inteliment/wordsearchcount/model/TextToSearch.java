package main.java.com.inteliment.wordsearchcount.model;

import java.util.List;
public class TextToSearch   {
 
  	private List<String> searchText;	 
 
	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}

	public TextToSearch() {
		
	}
	public TextToSearch(List<String> searchText) {
		super();
		this.searchText = searchText;
	}
}

 