package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskResponse;
import dev.lebenkov.todo.store.model.Task;
import dev.lebenkov.todo.store.repository.CategoryRepository;
import dev.lebenkov.todo.store.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskQueryServiceImp implements TaskQueryService {

    CategoryRepository categoryRepository;
    TaskRepository taskRepository;

    AccountService accountService;

    ModelMapper modelMapper;

    @Override
    public List<TaskResponse> fetchAllTasks() {
        return taskRepository.findAllByAccount(accountService.fetchAccount()).stream().map(this::convertToTaskResponse).toList();
    }

    @Override
    public List<TaskResponse> fetchAllCompletedTasks() {
        List<TaskResponse> tasks = fetchAllTasks();
        return tasks.stream()
                .filter(TaskResponse::isCompleted)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskResponse> fetchAllTasksByCategory(ObjectId categoryId) {
        List<Task> tasks = taskRepository.findAllByCategory(categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not founded!")));
        return tasks.stream().map(this::convertToTaskResponse).toList();
    }

    @Override
    public List<TaskResponse> fetchTodayTasks() {
        List<TaskResponse> tasks = fetchAllTasks();

        return tasks.stream()
                .filter(task -> task.getDate().toLocalDate().equals(LocalDateTime.now().toLocalDate()))
                .collect(Collectors.toList());
    }

    private TaskResponse convertToTaskResponse(Task task) {
        return modelMapper.map(task, TaskResponse.class);
    }
}
