package dev.lebenkov.todo.api.controller;

import dev.lebenkov.todo.api.service.TaskCreationService;
import dev.lebenkov.todo.api.service.TaskQueryService;
import dev.lebenkov.todo.api.service.TaskUpdateService;
import dev.lebenkov.todo.store.dto.TaskCreateRequest;
import dev.lebenkov.todo.store.dto.TaskResponse;
import dev.lebenkov.todo.store.dto.TaskUpdateRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {

    TaskCreationService taskCreationService;
    TaskQueryService taskQueryService;
    TaskUpdateService taskUpdateService;

    private static final String TASK_ID = "/{taskId}";
    private static final String CATEGORY_ID = "/{categoryId}";

    @GetMapping
    public ResponseEntity<List<TaskResponse>> fetchAllTasks() {
        return new ResponseEntity<>(taskQueryService.fetchAllTasks(), HttpStatus.OK);
    }

    @GetMapping(CATEGORY_ID)
    public ResponseEntity<List<TaskResponse>> fetchAllTasksByCategory(@PathVariable ObjectId categoryId) {
        return new ResponseEntity<>(taskQueryService.fetchAllTasksByCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping("/completed-task")
    public ResponseEntity<List<TaskResponse>> fetchAllCompletedTasks() {
        return new ResponseEntity<>(taskQueryService.fetchAllCompletedTasks(), HttpStatus.OK);
    }

    @GetMapping("/today-tasks")
    public ResponseEntity<List<TaskResponse>> fetchTodayTasks() {
        return new ResponseEntity<>(taskQueryService.fetchTodayTasks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskCreateRequest taskCreateRequest) {
        taskCreationService.createTask(taskCreateRequest);
        return new ResponseEntity<>("Task was successfully created!", HttpStatus.OK);
    }

    @PutMapping(TASK_ID)
    public ResponseEntity<String> updateTask(@PathVariable ObjectId taskId, @RequestBody TaskUpdateRequest taskUpdateRequest) {
        taskUpdateService.updateTask(taskId, taskUpdateRequest);
        return new ResponseEntity<>("Task was successfully updated!", HttpStatus.OK);
    }

    @PatchMapping(TASK_ID)
    public ResponseEntity<String> updateTaskStatus(@PathVariable ObjectId taskId, @RequestParam Boolean isCompleted) {
        log.info("We here");
        taskUpdateService.updateTaskStatus(taskId, isCompleted);
        return new ResponseEntity<>("Status was successfully updated!", HttpStatus.OK);
    }
}
