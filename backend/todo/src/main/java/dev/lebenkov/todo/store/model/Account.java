package dev.lebenkov.todo.store.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(value = "account")
public class Account {

    @Id
    private ObjectId id;

    private String username;

    private String email;

    private String role;

    private String password;
}
