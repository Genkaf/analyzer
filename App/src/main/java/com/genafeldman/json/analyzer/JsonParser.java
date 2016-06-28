package com.genafeldman.json.analyzer;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	private final static String JSON_FILE_EXT = ".json";

	public List<JsonSentence> getListOfSentences(String path) {
		
		ObjectMapper m = new ObjectMapper();
		List<JsonSentence> returnList  = null;
		
		File[] relevantFiles = getRelevantFiles(path);
		if (relevantFiles != null && relevantFiles.length > 0) {
			 returnList = new ArrayList<JsonSentence>();
		}
		for (File f : relevantFiles) {
			System.out.println("Reading info from: " + f.getName());
			JsonSentence value;
			try {
				value = m.readValue(f, JsonSentence.class);
				returnList.add(value);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return returnList;
	}

	private File[] getRelevantFiles(String path) {
		File f = new File(path);

		File[] listFiles = null;

		if (f.isDirectory()) {
			listFiles = f.listFiles(new FileFilter() {

				public boolean accept(File f) {
					return f.getName().endsWith(JSON_FILE_EXT);
				}

			});
		} else {
			listFiles = new File[1];
			listFiles[0] = f;
		}

		return listFiles;
	}
}
