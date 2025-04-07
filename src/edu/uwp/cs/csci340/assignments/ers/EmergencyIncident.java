package edu.uwp.cs.csci340.assignments.ers;

public class EmergencyIncident implements Comparable {

    // Instance Variables
    private int idCounter;
    private int incidentID;
    private String incidentType;
    private int severityLevel;
    private int responseTime;
    private int location;


    public EmergencyIncident(String incidentType, int incidentID, int severityLevel, int responseTime, int location) {
        this.incidentType = incidentType;
        this.incidentID = incidentID;
        this.severityLevel = severityLevel;
        this.responseTime = responseTime;
        this.location = location;
    }
}
