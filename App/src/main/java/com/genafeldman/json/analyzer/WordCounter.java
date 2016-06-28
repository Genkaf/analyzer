package com.genafeldman.json.analyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

	public WordCount[] calculateWordOccurance(List<JsonSentence> sentenceList) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (JsonSentence s : sentenceList) {
			String[] wordsInSentence = s.getSentence().split("\\s+");
			for (String word : wordsInSentence) {
				if (map.containsKey(word)) {
					Integer value = map.get(word);
					value++;
					map.put(word, value);
				} else {
					map.put(word, new Integer(1));
				}

			}
		}

		System.out.println("Print the map in WordCounter - START");
		WordCount[] wc = new WordCount[map.keySet().size()];
		int i = 0;
		for (String oc : map.keySet()) {
			Integer value = map.get(oc);
			wc[i] = new WordCount(oc, value);
			i++;
			
			System.out.println("Word in Sentence:* " + oc + " *Count of Apperances: " + value);
			
			
		}
		System.out.println("Print the map in WordCounter - END");

		return wc;
	}

}
