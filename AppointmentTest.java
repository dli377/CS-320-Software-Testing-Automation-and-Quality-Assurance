import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentClassSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); 
        Appointment appointment = new Appointment("1234567890", futureDate, "Description");

        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Description", appointment.getDescription());
    }

    @Test
    public void testSettersSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); 
        Appointment appointment = new Appointment("1234567890", futureDate, "Description");
        
        Date newDate = new Date(System.currentTimeMillis() + 90000000);
        appointment.setAppointmentDate(newDate);
        appointment.setDescription("New Description");
        
        assertEquals(newDate, appointment.getAppointmentDate());
        assertEquals("New Description", appointment.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIdTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        new Appointment("12345678901", futureDate, "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000);
        new Appointment("12345", pastDate, "Description");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetAppointmentDateInPast() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); 
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        
        Date pastDate = new Date(System.currentTimeMillis() - 86400000);
        appointment.setAppointmentDate(pastDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        new Appointment("12345", futureDate, "123456789012345678901234567890123456789012345678901");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); 
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        appointment.setDescription("123456789012345678901234567890123456789012345678901");
    }
}
