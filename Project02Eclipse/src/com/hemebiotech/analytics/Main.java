package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

//
//        analyticsCounter.getSymptoms();
//        System.out.println(analyticsCounter.getSymptoms());
//        System.out.println(result);
//        analyticsCounter.countSymptoms(analyticsCounter.getSymptoms());
//        System.out.println(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()));
//        //sorts symptots in alphabetical order
//        analyticsCounter.sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()));
//        System.out.println(analyticsCounter.sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms())));
        //write to file result.out
        analyticsCounter.writeSymptoms((analyticsCounter.sortSymptoms(analyticsCounter.countSymptoms(analyticsCounter.getSymptoms()))));
    }
}
