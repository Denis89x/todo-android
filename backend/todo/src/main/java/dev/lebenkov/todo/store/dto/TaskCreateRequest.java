package dev.lebenkov.todo.store.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskCreateRequest {
    private String name;
    private String categoryId;
    private boolean isCompleted;
    private LocalDateTime date;
}
