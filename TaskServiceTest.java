import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskServiceTest {

    private TaskService service;

    @Before
    public void setUp() {
        service = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1001", "Task 1", "Description 1");
        assertTrue(service.addTask(task));
        assertEquals(task, service.getTask("1001"));
    }

    @Test
    public void testAddDuplicateTask() {
        Task task1 = new Task("1001", "Task 1", "Description 1");
        Task task2 = new Task("1001", "Task 2", "Description 2");
        assertTrue(service.addTask(task1));
        assertFalse(service.addTask(task2)); // Should fail
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1001", "Task 1", "Description 1");
        service.addTask(task);
        assertTrue(service.deleteTask("1001"));
        assertNull(service.getTask("1001"));
    }

    @Test
    public void testDeleteNonExistentTask() {
        assertFalse(service.deleteTask("9999"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("1001", "Task 1", "Description 1");
        service.addTask(task);

        boolean updated = service.updateTask("1001", "Updated Name", "Updated Desc");
        assertTrue(updated);
        
        Task updatedTask = service.getTask("1001");
        assertEquals("Updated Name", updatedTask.getName());
        assertEquals("Updated Desc", updatedTask.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTaskInvalidName() {
        Task task = new Task("1001", "Task 1", "Description 1");
        service.addTask(task);
        // Name > 20 chars should throw exception
        service.updateTask("1001", "123456789012345678901", "Valid Desc");
    }
}
