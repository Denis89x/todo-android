package dev.lebenkov.todo.store.model;

import dev.lebenkov.todo.store.enums.TokenType;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "token")
public class Token {

    @Id
    public ObjectId id;

    public String token;

/*    @Enumerated(EnumType.STRING)*/
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    public Account account;
}