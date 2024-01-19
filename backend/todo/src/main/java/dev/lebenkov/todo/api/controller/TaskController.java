package dev.lebenkov.todo.api.controller;

import dev.lebenkov.todo.api.service.TaskService;
import dev.lebenkov.todo.store.dto.TaskResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {

    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> fetchAllTasks() {
        return new ResponseEntity<>(taskService.fetchAllTasks(), HttpStatusCode.valueOf(200));
    }

/*    @PostMapping
    public ResponseEntity<String> createTask() {

    }*/
}
