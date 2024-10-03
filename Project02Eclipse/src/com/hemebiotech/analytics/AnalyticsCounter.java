package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	private static int  headCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	//Creating the interface object ISymptomReader
	ISymptomReader reader2 = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
	//Creating the interface object ISymptomWrite
	ISymptomWriter write2 = new WriteSymptomDataToFile("result.out");


	public AnalyticsCounter(ISymptomReader reader2, ISymptomWriter write2) {
		this.reader2 = reader2;
		this.write2 = write2;
	}

	/**
	 * method to retrieve the list of entries in the file using the instance of ISymptomReader
	 * @return
	 */
	public List<String> getSymptoms() {
		return reader2.GetSymptoms();
	}

	/**
	 * method that counts occurrences of each existing symptom
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		// Map to store words and their number of occurrences
		Map<String, Integer> symptomCount = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
		}

		Map<String, Integer> result = new HashMap<>();

		for (Map.Entry<String, Integer> entry : symptomCount.entrySet()) {
			String symptom = entry.getKey();
			int count = entry.getValue();
			result.put(symptom , count);
		}

		return result;
	}

	/**
	 * method that sorts the list of symptoms and occurrences alphabetically
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		Map<String, Integer> result = new TreeMap<>(symptoms);
		return  result;

	}

	//
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptoms = write2.writeSymptoms();
	}

	public static void main(String[] args) throws IOException {

		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
            System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}

		FileWriter writer = new FileWriter ("result.out");

        writer.write("headache: " + headCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
