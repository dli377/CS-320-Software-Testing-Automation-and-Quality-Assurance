import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // In-memory data structure to store contacts
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add contact with unique ID
    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            return false; // Contact already exists or is null
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    // Delete contact per contact ID
    public boolean deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            return false;
        }
        contacts.remove(contactId);
        return true;
    }

    // Update contact fields per contact ID 
    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            return false;
        }
        
        Contact contact = contacts.get(contactId);

        // Update fields if the new values are not null.
        // The Contact class setters handle the validation logic
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);

        return true;
    }
    
    // Helper method to verify data in tests
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
