package main.java.com.inteliment.wordsearchcount.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.inteliment.wordsearchcount.dao.TextsCountDao;

/**
 * @author Nipun 
 * This service class returns the frequency of given 
 * list of text and top frequency of X number of texts
 */
@Component
public class TextCountServiceImpl implements TextCountService {
	@Autowired
	TextsCountDao textsCountDao;

	public TextCountServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see main.java.com.inteliment.wordsearchcount.service.TextCountService#getCounts(java.lang.Integer)
	 */
	public String getCounts(Integer topItems) {
		int soFar = 0;
		StringBuffer resultBuffer = new StringBuffer();
		if (topItems < 1)
			return resultBuffer.toString();

		List<String> countsList = textsCountDao.getSortedCountByOccurrenceList();

		for (String temp : countsList) {
			resultBuffer.append(temp);
			soFar++;
			if (soFar >= topItems) {
				return resultBuffer.toString();
			}
		}
		return resultBuffer.toString();
	}

	
	/* (non-Javadoc)
	 * @see main.java.com.inteliment.wordsearchcount.service.TextCountService#getCounts(java.util.List)
	 */
	public Map<String, Integer>[] getCounts(List<String> texts) {
		List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
		int number = 0;
		int index = 0;

		for (String text : texts) {
			HashMap<String, Integer> countMap = new HashMap<String, Integer>();
			text = text.toLowerCase();

			if (textsCountDao.getTextCountMap().containsKey(text))
				number = (Integer) textsCountDao.getTextCountMap().get(text);
			else
				number = 0;

			countMap.put(text, number);
			list.add(countMap);
		}
		HashMap<String, Integer>[] maps = list.toArray(new HashMap[list.size()]);
		return maps;
	}
}
