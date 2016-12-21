package main.java.com.inteliment.wordsearchcount.model;

import java.util.List;

public class TextToSearch1   {
 
  	private List<String> searchText;	 
 
	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}

	public TextToSearch1(List<String> searchText) {
		this.searchText = searchText;
	}
}

 