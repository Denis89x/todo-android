package dev.lebenkov.todo.store.dto;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@ToString
@Data
public class TaskCreateRequest {
    private String name;
    private ObjectId categoryId;
    private Boolean isCompleted;
    private LocalDateTime date;
}
