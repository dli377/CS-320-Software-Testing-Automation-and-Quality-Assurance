import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private final Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    // Add task with unique ID
    public boolean addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            return false;
        }
        tasks.put(task.getTaskId(), task);
        return true;
    }

    // Delete task per task ID 
    public boolean deleteTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            return false;
        }
        tasks.remove(taskId);
        return true;
    }

    // Update task fields per task ID
    public boolean updateTask(String taskId, String name, String description) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            return false;
        }

        Task task = tasks.get(taskId);

        if (name != null) task.setName(name);
        if (description != null) task.setDescription(description);

        return true;
    }

    // Helper for verification
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
