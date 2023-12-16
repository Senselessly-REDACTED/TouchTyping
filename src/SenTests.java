/***
 * @author Raymond Klarr
 * 12/16/2023
 * Class contains methods related to the comparison of input to the prompt. Class may be merged to SentencePractice.java later.
 */

import java.util.ArrayList;
import java.util.List;

public class SenTests 
{
	
	/**
	 * checks the equality of each word within entry and template, then returns the number of equal words
	 * 
	 * @param entry - the user input
	 * @param template - the prompt
	 * @return number of equal words between entry and template
	 */
	public int equalityCheckSen(String entry, String template)
	{
		String[] eList = entry.split(" ");
		String[] tList = template.split(" ");
		int end = 0;
		
		for(String x : eList)
			for(String y : tList)
			{
				if((x.equals(y)))
					end++;
			}
		return end;
	}
	
	/**
	 * fills arrayList strings with amount strings
	 * @param amount - num of strings to fill list with.
	 */
	@SuppressWarnings("unused")
	public List<String> fillWithStrings(int amount)
	{		
		return SGen.genSen(amount);
	}
	
	/**
	 * fills arrayList strings with amount words
	 * @param amount - num of words to fill list with.
	 */
	@SuppressWarnings("unused")
	public List<String> fillWithWords(int amount)
	{
		List<String> x = new ArrayList<>();
		for(int i = 0; i < amount; i++)
			x.add(SGen.retRanWord());
		
		return x;
	}
}
