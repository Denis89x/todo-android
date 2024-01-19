package dev.lebenkov.todo.store.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class TaskUpdateRequest {
    private ObjectId categoryId;

    private String name;

    private Boolean isCompleted;

    private LocalDateTime date;
}
