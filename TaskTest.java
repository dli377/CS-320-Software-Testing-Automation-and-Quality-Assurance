import static org.junit.Assert.*;
import org.junit.Test;

public class TaskTest {

    @Test
    public void testTaskClassSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdTooLong() {
        new Task("12345678901", "Name", "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdNull() {
        new Task(null, "Name", "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameTooLong() {
        // 21 characters
        new Task("12345", "123456789012345678901", "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameNull() {
        new Task("12345", null, "Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionTooLong() {
        // 51 characters
        new Task("12345", "Name", "123456789012345678901234567890123456789012345678901");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionNull() {
        new Task("12345", "Name", null);
    }
}
