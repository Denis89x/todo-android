package dev.lebenkov.todo.store.repository;

import dev.lebenkov.todo.store.model.Icon;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends MongoRepository<Icon, ObjectId> {
}
