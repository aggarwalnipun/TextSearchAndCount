package main.java.com.inteliment.wordsearchcount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.inteliment.wordsearchcount.service.TextCountService;


/**
 * 
 * @author Nipun 
 * Controller class to execute /top/{count} (as Path Variable) to return 
 * texts which have the highest counts in the Sample Paragraphs provided
 */
@RestController
@RequestMapping("/counter-api/top")
public class MaxCountController {
	@Autowired
	TextCountService textCountService;

	@RequestMapping(value = "{topCount}", method = RequestMethod.GET, produces = "text/csv")
	public @ResponseBody String getTop(@PathVariable String topCount) {
		int count = 0;
		try {
			count = Integer.parseInt(topCount);
		} catch (NumberFormatException nfe) {
			//setting default value to 1 in case of bad input e.g. alphabet instead of number
			count = 1;
		}

		String wordCount = textCountService.getCounts(count);
		return wordCount;
	}
}
