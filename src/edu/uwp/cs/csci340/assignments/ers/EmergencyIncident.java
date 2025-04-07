package edu.uwp.cs.csci340.assignments.ers;

import java.time.LocalDateTime;

public class EmergencyIncident implements Comparable<EmergencyIncident> {
    // Instance Variables
    private int idCounter;
    private int incidentID;
    private String incidentType;
    private int severityLevel;
    private int responseTime;
    private int location;

    /** 4-param constructor for an Emergency Incident.
     * @param incidentType The type of incident that is being reported (i.e. 'medical').
     * @param incidentID The ID of the incident.
     * @param severityLevel The severity level of the incident on a 5-point scale (1-Highest, 5-Lowest).
     * @param location The location of the incident.
     */
    public EmergencyIncident(int incidentID, String incidentType, int severityLevel, int location) {
        this.incidentType = incidentType;
        this.incidentID = incidentID;
        this.severityLevel = severityLevel;
        this.location = location;

        // This sets the response time based on the district the incident is in
        if(getLocation() >= 2 && getLocation() <= 5) {
            setResponseTime(5);
        } else if(getLocation() >= 6 && getLocation() <= 8) {
            setResponseTime(7);
        } else if(getLocation() >= 9 && getLocation() <= 13 || getLocation() == 21) {
            // I placed location 21 (The Azure Bridge) in here since it was closer to this district, but wasn't listed in the districts
            setResponseTime(10);
        } else if(getLocation() == 16 || getLocation() == 19 || getLocation() == 20) {
            setResponseTime(20);
        } else if(getLocation() == 17 || getLocation() == 18 || getLocation() == 14 || getLocation() == 15 || getLocation() == 22) {
            // I placed location 22 (Downtown Stortward) in here because it's closest to this district and wasn't listed in the districts
            setResponseTime(15);
        }
    }

    /** Gets the ID Counter.
     * @return int value.
     */
    public int getIdCounter() {
        return idCounter;
    }

    /** Sets the ID Counter.
     * @param idCounter int value.
     */
    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    /** Returns the incident ID for the incident.
     * @return in value that is greater than or equal to 1.
     */
    public int getIncidentID() {
        return incidentID;
    }

    /** Sets the incident ID, which is the identifier for the n-th incident to be reported.
     * @param incidentID int value that is greater than or equal to 1.
     */
    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

    /** Returns the incident type for the incident.
     * @return String represenation of an incident (i.e. 'medical')
     */
    public String getIncidentType() {
        return incidentType;
    }

    /** Sets the incident type for the incident
     * @param incidentType String representation of an incident (i.e. 'medical')
     */
    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    /** Gets the severity level for an incident
     * @return The severity level (1-5)
     */
    public int getSeverityLevel() {
        return severityLevel;
    }

    /** Sets the severity level on a 5 point integer scale
     * @param severityLevel int storing the severity level (1-Highest, 5-Lowest)
     */
    public void setSeverityLevel(int severityLevel) {
        // Performs some error checking to make sure the severity level is strictly between 1 and 5 (inclusive)
        if(severityLevel >=5) {
            severityLevel = 5;
        } else if(severityLevel <= 1) {
            severityLevel = 1;
        }
        this.severityLevel = severityLevel;
    }

    /** Gets the response time for an incident
     * @return int response time (int minutes)
     */
    public int getResponseTime() {
        return responseTime;
    }

    /** Sets the response time of an incident.
     * @param responseTime int response time (int minutes)
     */
    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    /** Gets the location of the incident
     * @return int ranging from 1-22
     */
    public int getLocation() {
        return location;
    }

    /** Sets the numerical location as a value
     * @param location int value for the location valid values are 1-22 inclusive
     */
    public void setLocation(int location) {
        if(location >= 1 && location <= 22) {
            this.location = location;
        } else {
            // Defaults to -1, which is not a given location
            this.location = -1;
        }
    }

    /**
     * @param o the object to be compared.
     * @return 0 if the incidents are of equal priority, 1 if the first incident is of higher priority, -1 if the passed (second) incident is of higher priority.
     */
    @Override
    public int compareTo(EmergencyIncident o) {
        // To determine the ordering of incidents, we first look at the incident with the highest priority (1-Highest, 5-Lowest)
        if(this.severityLevel > o.getSeverityLevel()) {
            return 1;
        } else if(this.severityLevel < o.severityLevel) {
            return -1;
        }

        // If the severity level of two incidents are the same, we choose the incident with the lowest response time
        if(this.responseTime < o.responseTime) {
            return 1;
        } else if(this.responseTime > o.responseTime) {
            return -1;
        } else {
            // If they are the same, it doesn't matter which is picked
            return 0;
        }
    }

    /** Generates a report-styled block of the attributes of an incident, which include things such as the severity, ID, and date/time the report was created.
     * @return List of attributes that an incident has
     */
    @Override
    public String toString() {
        // Gets the string associated with the severity depending on the severity level
        String severity = switch (getSeverityLevel()) {
            case 1 -> "High";
            case 2 -> "Medium-High";
            case 3 -> "Medium";
            case 4 -> "Medium-Low";
            case 5 -> "Low";
            default -> "Low";
        };

        // List of locations
        String[] locations = {"Fire Station", "Auden Winstone residence", "Philberta Thornee residence", "Shelby Halee residence", "Brock Wynnee residence", "Woodrow Langley residence", "Hayden Browne residence", "North Island Hospital", "Fairburne Manufacturing", "Bloodworthe Construction", "Graham Medical", "Stortward School", "Blythe Hartelle's Blacksmith Shoppe", "Baxtere's Department Storee", "Stortward Watertower", "Harper Vanne's Fish Market", "Caulfielde's Supermarket", "Linley Wilkiee's Shoe Shoppe", "Stortward Power Plant", "South Pier", "Azure Bridge", "Downtown Stortward"};

        // Gets the district name that the incident took place in
        String district = "";
        if(getLocation() >= 2 && getLocation() <= 5) {
            district = "Residential District";
        } else if(getLocation() >= 6 && getLocation() <= 8) {
            district = "Fishing District";
        } else if(getLocation() >= 9 && getLocation() <= 13) {
            district = "Industrial District";
        } else if(getLocation() == 16 || getLocation() == 19 || getLocation() == 20 || getLocation() == 21) {
            district = "South Pier District";
        } else if(getLocation() == 17 || getLocation() == 18 || getLocation() == 14 || getLocation() == 15 || getLocation() == 22) {
            district = "Downtown";
        }

        // Gets the local date and time
        LocalDateTime dateTime = LocalDateTime.now();

        // Generates the formatted EmergencyIncident object as a string
        return  dateTime + "\n" +
                "| ID: " + getIncidentID() + "\n" +
                "| Type: " + getIncidentType() + "\n" +
                "| Severity: " + severity + "(" + getSeverityLevel() + ")\n" +
                "| Location: " + locations[getLocation() - 1] + "(" + getLocation() + ")\n" +
                "| District: " + district + "\n" +
                "| Response Time: " + getResponseTime() + " minutes\n" +
                "+----------\n";
    }
}
