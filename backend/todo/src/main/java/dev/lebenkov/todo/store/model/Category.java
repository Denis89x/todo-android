package dev.lebenkov.todo.store.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value = "category")
public class Category {

    @Id
    private ObjectId id;

    private String name;

    private boolean isEditable;

    private Color color;

    private Icon icon;

    private Account account;
}
