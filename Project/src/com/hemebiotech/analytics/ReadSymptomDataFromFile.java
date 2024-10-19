package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {
	private String filepath;

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * method to read all symptoms to file
	 * @return result : list of symptoms
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Error write to file : "+ e);
			}
		}
		return result;
	}
}