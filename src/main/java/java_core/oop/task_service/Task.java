package java_core.oop.task_service;

public class Task {
    private final long id;
    private final String title;
    private final User user;
    private TaskStatus status;

    public Task(long id, String title, User user) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        this.id = id;
        this.status = TaskStatus.TODO;
        this.title = title;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void start() {
        if (this.status != TaskStatus.TODO) {
            throw new IllegalStateException("Only TODO task can be started");
        }
        this.status = TaskStatus.IN_PROGRESS;
    }

    public void complete() {
        if (this.status == TaskStatus.TODO || this.status == TaskStatus.IN_PROGRESS) {
            this.status = TaskStatus.DONE;
        } else {
            throw new IllegalStateException("Task is already completed");
        }
    }
}