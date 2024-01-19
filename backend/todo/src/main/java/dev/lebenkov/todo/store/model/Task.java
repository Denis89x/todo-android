package dev.lebenkov.todo.store.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "task")
public class Task {

    @Id
    private ObjectId id;

    private Account account;

    private Category category;

    private String name;

    private Boolean isCompleted;

    private LocalDateTime date;
}