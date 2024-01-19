package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskCreateRequest;
import dev.lebenkov.todo.store.model.Task;
import dev.lebenkov.todo.store.repository.CategoryRepository;
import dev.lebenkov.todo.store.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskCreationServiceImp implements TaskCreationService {

    TaskRepository taskRepository;
    CategoryRepository categoryRepository;

    AccountService accountService;

    @Override
    public void createTask(TaskCreateRequest taskCreateRequest) {
        taskRepository.save(convertToTask(taskCreateRequest));
    }

    private Task convertToTask(TaskCreateRequest taskCreateRequest) {
        return Task.builder()
                .account(accountService.fetchAccount())
                .category(categoryRepository.findById(taskCreateRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not founded!")))
                .name(taskCreateRequest.getName())
                .isCompleted(taskCreateRequest.getIsCompleted())
                .date(taskCreateRequest.getDate())
                .build();
    }
}
