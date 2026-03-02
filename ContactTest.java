import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testContactClassSuccess() {
        Contact contact = new Contact("1234567890", "Daniel", "Student", "1234567890", "San Francisco, CA");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Daniel", contact.getFirstName());
        assertEquals("Student", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("San Francisco, CA", contact.getAddress());
    }
    // ID too long
    @Test(expected = IllegalArgumentException.class)
    public void testContactIdTooLong() {
        new Contact("12345678901", "Daniel", "Student", "1234567890", "SF");
    }
    // ID null
    @Test(expected = IllegalArgumentException.class)
    public void testContactIdNull() {
        new Contact(null, "Daniel", "Student", "1234567890", "SF");
    }
    // First name too long
    @Test(expected = IllegalArgumentException.class)
    public void testContactFirstNameTooLong() {
        new Contact("12345", "DanielDaniel", "Student", "1234567890", "SF");
    }
    // First name null
    @Test(expected = IllegalArgumentException.class)
    public void testContactFirstNameNull() {
        new Contact("12345", null, "Student", "1234567890", "SF");
    }
    // Last name too long
    @Test(expected = IllegalArgumentException.class)
    public void testContactLastNameTooLong() {
        new Contact("12345", "Daniel", "StudentStudent", "1234567890", "SF");
    }
    // Last name null
    @Test(expected = IllegalArgumentException.class)
    public void testContactLastNameNull() {
        new Contact("12345", "Daniel", null, "1234567890", "SF");
    }
    // Phone too long
    @Test(expected = IllegalArgumentException.class)
    public void testContactPhoneTooLong() {
        new Contact("12345", "Daniel", "Student", "12345678901", "SF");
    }
    // Phone too short
    @Test(expected = IllegalArgumentException.class)
    public void testContactPhoneTooShort() {
        new Contact("12345", "Daniel", "Student", "12345", "SF");
    }
    // Phone not digits
    @Test(expected = IllegalArgumentException.class)
    public void testContactPhoneNotDigits() {
        new Contact("12345", "Daniel", "Student", "12345abcde", "SF");
    }
    // Phone null
    @Test(expected = IllegalArgumentException.class)
    public void testContactPhoneNull() {
        new Contact("12345", "Daniel", "Student", null, "SF");
    }
    // Address too long
    @Test(expected = IllegalArgumentException.class)
    public void testContactAddressTooLong() {
        new Contact("12345", "Daniel", "Student", "1234567890", "1234567890123456789012345678901");
    }
    // Address null
    @Test(expected = IllegalArgumentException.class)
    public void testContactAddressNull() {
        new Contact("12345", "Daniel", "Student", "1234567890", null);
    }
}
