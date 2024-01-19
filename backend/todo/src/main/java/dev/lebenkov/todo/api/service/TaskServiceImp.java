package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.TaskCreateRequest;
import dev.lebenkov.todo.store.dto.TaskResponse;
import dev.lebenkov.todo.store.model.Task;
import dev.lebenkov.todo.store.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskServiceImp implements TaskService {

    TaskRepository taskRepository;

    AccountService accountService;

    ModelMapper modelMapper;

    @Override
    public List<TaskResponse> fetchAllTasks() {
        return taskRepository.findAllByAccount(accountService.fetchAccount()).stream().map(this::convertToTaskResponse).toList();
    }

    @Override
    public void createTask(TaskCreateRequest taskCreateRequest) {

    }

    private TaskResponse convertToTaskResponse(Task task) {
        return modelMapper.map(task, TaskResponse.class);
    }

    private Task convertToTask(TaskCreateRequest taskCreateRequest) {
        return Task.builder()

                .build();
    }
}
