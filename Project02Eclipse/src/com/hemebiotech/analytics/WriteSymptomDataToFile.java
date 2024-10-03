package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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

    @Override
    public Map<String, Integer> writeSymptoms() {

        Map<String, Integer> result = new HashMap<>();
        
        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                // Récupération de la clé et de la valeur
                String line = entry.getKey() + ": " + entry.getValue();
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filepath + " because : " + e.getMessage());
        }
        return Map.of();
    }
}
