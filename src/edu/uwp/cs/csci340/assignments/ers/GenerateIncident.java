package edu.uwp.cs.csci340.assignments.ers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateIncident {
    // This generates incidents randomly and stores it in a CSV file

    public static void main(String[] args) {
        // Create the file
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

        // Write the incidents to the file
        try {
            FileWriter fileOut = new FileWriter("incidents.csv");

            // Sets the number of incidents to generate
            int maxIncidents = 10;

            // Creates a String array of possible incident types
            String[] incidentTypes = {"fire", "medical", "accident"};

            for(int i = 1; i <= maxIncidents; i++) {
                // Incidents are formated as [incidentID],[incidentType],[incidentSeverity],[incidentLocation]
                // [incidentID] is the number of the incident, so we can use the counter i as the ID.

                Random randomInt = new Random();

                // Generates a random incident from the available types and stores it as a String.
                String randomIncident = incidentTypes[randomInt.ints(0, incidentTypes.length).findFirst().getAsInt()];

                // Generates the incident severity. For this project, the valid levels are integers 1-5, with 1 being the most severe
                int randomSeverity = randomInt.ints(1, 6).findFirst().getAsInt();

                // Generates the location of the incident. For this project, there are 21 possible locations outside of the origin (labeled as 1), so valid locations are integers 2-22
                int randomLocation = randomInt.ints(2, 23).findFirst().getAsInt();

                // Writes the incidents to the CSV
                fileOut.write(i + "," + randomIncident + "," + randomSeverity + "," + randomLocation + "\n");
            }
            fileOut.close();
        } catch(IOException e) {
            System.out.println("Cannot write to file.");
        }

    }
}
