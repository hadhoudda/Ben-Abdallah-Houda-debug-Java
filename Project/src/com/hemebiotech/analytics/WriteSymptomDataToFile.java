package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
    private String filepath;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * method to writer symptoms to a file
     * @param symptoms : list of symptoms and occurrences
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (symptoms == null || symptoms.isEmpty()) {
            System.err.println("No symptoms to write.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            symptoms.forEach((key, value) -> {
                try {
                    writer.write(key + " : " + value);
                    writer.newLine();
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + filepath + " because : " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filepath + " because : " + e.getMessage());
        }
    }
}