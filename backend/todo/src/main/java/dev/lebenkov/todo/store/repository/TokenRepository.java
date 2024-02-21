package dev.lebenkov.todo.store.repository;

import dev.lebenkov.todo.store.model.Token;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<Token, ObjectId> {
    List<Token> findByAccountIdAndExpiredIsFalseAndRevokedIsFalse(ObjectId accountId);

    Optional<Token> findByToken(String token);
}
