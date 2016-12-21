package main.java.com.inteliment.wordsearchcount.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

/**
 * @author Nipun 
 * This class when provided a file of text, counts the 
 * resp. text occurrence and stores in a map
 *
 */
@Component
public class TextsCountDao {
	// Map: text as the key and the count as the value
	private static TreeMap<String, Integer> textCountMap = new TreeMap<String, Integer>();
	private static List<String> sortedCountByOccurrenceList = new ArrayList<String>();

	public static TreeMap<String, Integer> getTextCountMap() {
		return textCountMap;
	}

	public static void setTextCountMap(TreeMap<String, Integer> textCountMap) {
		TextsCountDao.textCountMap = textCountMap;
	}

	public static List<String> getSortedCountByOccurrenceList() {
		return sortedCountByOccurrenceList;
	}

	public static void setSortedCountByOccurrenceList(List<String> sortedCountByOccurrenceList) {
		TextsCountDao.sortedCountByOccurrenceList = sortedCountByOccurrenceList;
	}

	public TextsCountDao() throws Exception {
		if (textCountMap.isEmpty())
			populateCountMap();
	};

	//read the input text and populate the count map and list
	public void populateCountMap() throws Exception {
		InputStream input = getClass().getClassLoader().getResourceAsStream("input_para.txt");
		if (input == null)
			throw new Exception("Input file:: input_para.txt doesn't exist");

		Integer count = 0;
		try {
			InputStreamReader isr = new InputStreamReader(input);
			BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			String[] texts = null;
			while (line != null) {
				texts = line.split("\\W+");
				for (String text : texts) {
					text = text.toLowerCase();
					if (textCountMap.containsKey(text)) {
						count = (Integer) textCountMap.get(text) + 1;
					} else {
						count = 1;
					}
					textCountMap.put(text, count);
				}
				line = reader.readLine();
			}
		} catch (Exception e) {
			throw new Exception("exception " + e.getMessage());
		}
		populateTopItems();
	}

	/**
	 * Populate list used for top items
	 */
	public static void populateTopItems() {

		Set<Entry<String, Integer>> set = textCountMap.entrySet();
		ArrayList<Entry<String, Integer>> tempList = new ArrayList<Entry<String, Integer>>(set);

		// sort based on frequency of occurence
		Collections.sort(tempList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Entry<String, Integer> e1 = (Entry<String, Integer>) o1;
				Entry<String, Integer> e2 = (Entry<String, Integer>) o2;
				return (e2.getValue() > e1.getValue()) ? 1 : -1;
			}
		});

		for (Entry<String, Integer> temp : tempList) {
			sortedCountByOccurrenceList.add(temp.getValue() + "|" + temp.getKey() + "\r\n");
		}
	}
}