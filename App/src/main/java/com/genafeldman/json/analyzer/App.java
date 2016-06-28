package com.genafeldman.json.analyzer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class App {
	public static void main(String[] args) {
		JsonParser p = new JsonParser();
		List<JsonSentence> listOfSentences = p.getListOfSentences("C:\\temp\\superman");

		for (JsonSentence s : listOfSentences) {
			System.out.println(s);
		}

		WordCounter wc = new WordCounter();
		WordCount[] counts = wc.calculateWordOccurance(listOfSentences);
		
		Arrays.sort(counts, new Comparator<WordCount>() {

			public int compare(WordCount w1, WordCount w2) {
				return w2.getCount() - w1.getCount();
			}
			
		});
		
		System.out.println("Print the array sorted in App - START");
		for (WordCount c: counts) {
			System.out.println(c.getWord() + " " + c.getCount());
		}
		System.out.println("Print the array sorted in App - END");
		
	
	}
}
