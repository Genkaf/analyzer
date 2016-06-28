package com.genafeldman.json.analyzer;

public class JsonSentence {

	private String sentence = null;

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public String toString() {

		return "The sentence says:" + getSentence();
	}
}
