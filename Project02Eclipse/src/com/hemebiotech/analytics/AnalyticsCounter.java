package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	ISymptomReader reader ;
	ISymptomWriter writer ;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	/**
	 * method to retrieve the list of entries in the file using the instance of ISymptomReader
	 * @return
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * method that counts occurrences of each existing symptom
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		// Map to store words and their number of occurrences
		Map<String, Integer> result = new HashMap<>();
		for (String symptom : symptoms) {
			result.put(symptom, result.getOrDefault(symptom, 0) + 1);
		}
		return result;
	}

	/**
	 * method that sorts the list of symptoms and occurrences alphabetically
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
	}

	/**
	 *
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
