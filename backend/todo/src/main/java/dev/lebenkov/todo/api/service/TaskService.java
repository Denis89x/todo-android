package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskCreateRequest;
import dev.lebenkov.todo.store.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> fetchAllTasks();
    void createTask(TaskCreateRequest taskCreateRequest);
}
