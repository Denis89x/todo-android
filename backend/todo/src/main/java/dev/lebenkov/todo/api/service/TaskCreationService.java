package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskCreateRequest;

public interface TaskCreationService {
    void createTask(TaskCreateRequest taskCreateRequest);
}
