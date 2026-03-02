import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContactServiceTest {

    private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1001", "Daniel", "Test", "5551234567", "123 Test Lane");
        assertTrue(service.addContact(contact));
        assertEquals(contact, service.getContact("1001"));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("1001", "Daniel", "Test", "5551234567", "123 Test Lane");
        Contact contact2 = new Contact("1001", "Jane", "Doe", "5559876543", "456 Other Rd");
        assertTrue(service.addContact(contact1));
        assertFalse(service.addContact(contact2)); // Should fail
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1001", "Daniel", "Test", "5551234567", "123 Test Lane");
        service.addContact(contact);
        assertTrue(service.deleteContact("1001"));
        assertNull(service.getContact("1001"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertFalse(service.deleteContact("9999"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1001", "Daniel", "Test", "5551234567", "123 Test Lane");
        service.addContact(contact);

        boolean updated = service.updateContact("1001", "Johnny", "Mnemonic", "5550001111", "321 Cyber St");
        assertTrue(updated);
        
        Contact updatedContact = service.getContact("1001");
        assertEquals("Johnny", updatedContact.getFirstName());
        assertEquals("Mnemonic", updatedContact.getLastName());
        assertEquals("5550001111", updatedContact.getPhone());
        assertEquals("321 Cyber St", updatedContact.getAddress());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateContactInvalidFirstName() {
        Contact contact = new Contact("1001", "Daniel", "Test", "5551234567", "123 Test Lane");
        service.addContact(contact);
        // This should throw because the name is too long
        service.updateContact("1001", "ChristopherChristopher", null, null, null); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateContactInvalidPhone() {
        Contact contact = new Contact("1001", "Daniel", "Test", "5551234567", "123 Test Lane");
        service.addContact(contact);
        // This should throw because phone is not digits
        service.updateContact("1001", null, null, "ABC1234567", null); 
    }
}
