package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskResponse;
import org.bson.types.ObjectId;

import java.util.List;

public interface TaskQueryService {
    List<TaskResponse> fetchAllTasks();
    List<TaskResponse> fetchAllCompletedTasks();
    List<TaskResponse> fetchAllTasksByCategory(ObjectId categoryId);
    List<TaskResponse> fetchTodayTasks();
}

