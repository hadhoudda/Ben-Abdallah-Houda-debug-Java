package com.hemebiotech.analytics;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
//	private static int  headCount = 0;
//	private static int rashCount = 0;
//	private static int pupilCount = 0;

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
		Map<String, Integer> result = new TreeMap<>(symptoms);
		return  result;
	}

	/**
	 *
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}


//	public static void main(String[] args) throws IOException {
//
//		// first get input
//		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
//		String line = reader.readLine();
//
//		while (line != null) {
//            System.out.println("symptom from file: " + line);
//			if (line.equals("headache")) {
//				headCount++;
//				System.out.println("number of headaches: " + headCount);
//			}
//			else if (line.equals("rush")) {
//				rashCount++;
//			}
//			else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//
//			line = reader.readLine();
//		}
//
//		FileWriter writer = new FileWriter ("result.out");
//
//        writer.write("headache: " + headCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		writer.close();
//	}
}
