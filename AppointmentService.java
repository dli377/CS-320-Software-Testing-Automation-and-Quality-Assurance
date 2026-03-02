import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Add appointment: Throws exception if ID exists
    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists or is null");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete appointment: Throws exception if ID not found
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentId);
    }
    
    // Update appointment: throws exception if ID not found. Only updates non-null fields.
    public void updateAppointment(String appointmentId, java.util.Date newDate, String newDescription) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        
        Appointment appointment = appointments.get(appointmentId);
        
        if (newDate != null) {
            appointment.setAppointmentDate(newDate);
        }
        if (newDescription != null) {
            appointment.setDescription(newDescription);
        }
    }

    // Helper for verification
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
