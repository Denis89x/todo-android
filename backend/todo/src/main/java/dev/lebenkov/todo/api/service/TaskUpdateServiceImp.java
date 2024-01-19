package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskUpdateRequest;
import dev.lebenkov.todo.store.model.Task;
import dev.lebenkov.todo.store.repository.CategoryRepository;
import dev.lebenkov.todo.store.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskUpdateServiceImp implements TaskUpdateService {

    CategoryRepository categoryRepository;
    TaskRepository taskRepository;

    @Override
    public void updateTaskStatus(ObjectId id, Boolean isCompleted) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not founded!"));
        task.setIsCompleted(isCompleted);
        taskRepository.save(task);
    }

    @Override
    @Transactional
    public void updateTask(ObjectId id, TaskUpdateRequest taskUpdateRequest) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not founded!"));
        task.setName(taskUpdateRequest.getName());
        task.setDate(taskUpdateRequest.getDate());
        task.setCategory(categoryRepository.findById(taskUpdateRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not founded!")));
        task.setDate(taskUpdateRequest.getDate());
        taskRepository.save(task);
    }
}
