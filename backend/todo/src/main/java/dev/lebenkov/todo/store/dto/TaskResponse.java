package dev.lebenkov.todo.store.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponse {
    private String name;
    private boolean isCompleted;
    private LocalDateTime date;
}
