package dev.lebenkov.todo.store.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value = "icon")
public class Icon {

    @Id
    private ObjectId id;

    private String name;

    private String symbol;
}