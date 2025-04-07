package edu.uwp.cs.csci340.assignments.ers;

public class EmergencyIncident implements Comparable {
    // Instance Variables
    private int idCounter;
    private int incidentID;
    private String incidentType;
    private int severityLevel;
    private int responseTime;
    private int location;


    /** 5-param constructor for an Emergency Incident.
     * @param incidentType The type of incident that is being reported (i.e. 'medical').
     * @param incidentID The ID of the incident.
     * @param severityLevel The severity level of the incident on a 5-point scale (1-Highest, 5-Lowest).
     * @param responseTime The response time it takes to reach the incident.
     * @param location The location of the incident.
     */
    public EmergencyIncident(String incidentType, int incidentID, int severityLevel, int responseTime, int location) {
        this.incidentType = incidentType;
        this.incidentID = incidentID;
        this.severityLevel = severityLevel;
        this.responseTime = responseTime;
        this.location = location;
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

    /** Sets the severity level on a 5 point scale (1-Highest, 5-Lowest)
     * @param severityLevel
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

    /** Sets the numerical location as a value (1-22)
     * @param location
     */
    public void setLocation(int location) {
        this.location = location;
    }

}
