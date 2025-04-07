package edu.uwp.cs.csci340.assignments.ers;

import java.io.File;
import java.io.IOException;

public class GenerateIncident {
    // This generates incidents randomly and stores it in a CSV file
    public static void main(String[] args) {
        try {
            File incidents = new File("incidents.csv");
            if(incidents.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("File could not be created.");
        }
    }
}
