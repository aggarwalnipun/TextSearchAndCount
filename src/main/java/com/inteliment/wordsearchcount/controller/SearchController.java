package main.java.com.inteliment.wordsearchcount.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.inteliment.wordsearchcount.model.TextToSearch1;
import main.java.com.inteliment.wordsearchcount.model.TextToSearch;
import main.java.com.inteliment.wordsearchcount.model.TextSearchResults;
import main.java.com.inteliment.wordsearchcount.service.TextCountService;

/**
 * 
 * @author Nipun 
 * Controller class to execute /search to search the text(provided
 * in json format) and return the counts of each respectively in json
 *
 */
@RestController
@RequestMapping("counter-api/search")
public class SearchController {
	@Autowired
	TextCountService textCountService;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody TextSearchResults getTextCounts( @RequestBody TextToSearch textToSearch) {
		List<String> textsList = textToSearch.getSearchText();
		TextSearchResults searchResults = new TextSearchResults();
		
		// pass text to TextCountService method to fetch the counts
		Map<String, Integer>[] textCounts = textCountService.getCounts(textsList);
		searchResults.setCounts(textCounts);
		
		// return search results as ResponseBody return parameter, where jackson transforms it into json representation
		return searchResults;
	}
}