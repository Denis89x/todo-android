package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskUpdateRequest;
import org.bson.types.ObjectId;

public interface TaskUpdateService {
    void updateTaskStatus(ObjectId id, Boolean isCompleted);
    void updateTask(ObjectId id, TaskUpdateRequest taskUpdateRequest);
}

