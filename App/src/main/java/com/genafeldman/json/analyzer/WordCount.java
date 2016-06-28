package com.genafeldman.json.analyzer;

public class WordCount {

	private String word = null;
	private Integer count = null;

	public WordCount() {
		// TODO Auto-generated constructor stub
	}

	public WordCount(String s, Integer c) {
		setWord(s);
		setCount(c);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
