import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService service;
    private Date futureDate;

    @Before
    public void setUp() {
        service = new AppointmentService();
        futureDate = new Date(System.currentTimeMillis() + 86400000); 
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("1001", futureDate, "Description");
        service.addAppointment(appointment); // No assertion needed; success if no exception thrown
        assertEquals(appointment, service.getAppointment("1001"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("1001", futureDate, "Description 1");
        Appointment appointment2 = new Appointment("1001", futureDate, "Description 2");
        service.addAppointment(appointment1);
        service.addAppointment(appointment2); // Should throw exception
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("1001", futureDate, "Description");
        service.addAppointment(appointment);
        service.deleteAppointment("1001"); // Should succeed
        assertNull(service.getAppointment("1001"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentAppointment() {
        service.deleteAppointment("9999"); // Should throw exception
    }
    
    @Test
    public void testUpdateAppointment() {
        Appointment appointment = new Appointment("1001", futureDate, "Original Description");
        service.addAppointment(appointment);
        
        Date newDate = new Date(System.currentTimeMillis() + 90000000);
        service.updateAppointment("1001", newDate, "Updated Description");
        
        Appointment updated = service.getAppointment("1001");
        assertEquals(newDate, updated.getAppointmentDate());
        assertEquals("Updated Description", updated.getDescription());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistentAppointment() {
        service.updateAppointment("9999", futureDate, "Desc");
    }
}
