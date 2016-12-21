package main.java.com.inteliment.wordsearchcount.service;
import java.util.Map;
import java.util.List;
/**
 * @author Nipun
 *
 */
public interface TextCountService {
  	public String getCounts(Integer topItems );
  	public Map<String,Integer>[] getCounts(List<String> texts);
}