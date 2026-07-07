package java_core.oop.task_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskService {
    private final Map<Long, Task> tasksById = new HashMap<>();
    private long nextId = 1;

    public Task createTask(String title, User user) {
        long taskId = nextId++;
        Task task = new Task(taskId, title, user);
        tasksById.put(taskId, task);
        return task;
    }

    public Optional<Task> findTaskById(long id) {
        return Optional.ofNullable(tasksById.get(id));
    }

    public List<Task> getAllTasksByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        return tasksById
                .values()
                .stream()
                .filter(task -> task.getUser().getId() == user.getId())
                .collect(Collectors.toList());
    }

    public void completeTask(long taskId) {
        Task task = getTaskOrThrow(taskId);
        task.complete();
    }

    public void startTask(long taskId) {
        Task task = getTaskOrThrow(taskId);
        task.start();
    }

    private Task getTaskOrThrow(long taskId) {
        return findTaskById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found: " + taskId));
    }
}