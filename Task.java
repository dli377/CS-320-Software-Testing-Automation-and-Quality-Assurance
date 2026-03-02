public class Task {

    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        // Task ID: not null, max 10 chars
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        
        // Name: not null, max 20 chars
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        
        // Description: not null, max 50 chars
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getTaskId() { return taskId; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    // Setters
    // No setter for taskId as it shall not be updatable 

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
