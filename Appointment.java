import java.util.Date;

public class Appointment {

    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // ID: Not null, max 10 chars
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        
        // Date: Not null, not in the past
        updateAppointmentDate(appointmentDate);
        
        // Description: Not null, max 50 chars
        updateDescription(description);

        this.appointmentId = appointmentId;
    }

    // Getters
    public String getAppointmentId() { return appointmentId; }
    public Date getAppointmentDate() { return appointmentDate; }
    public String getDescription() { return description; }

    // Setters (Added per feedback)
    // Using custom private helper methods or public setters to consolidate validation logic is best practice
    
    public void setAppointmentDate(Date appointmentDate) {
        updateAppointmentDate(appointmentDate);
    }

    public void setDescription(String description) {
        updateDescription(description);
    }

    // Helper methods to avoid code duplication between constructor and setters
    private void updateAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;
    }

    private void updateDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
