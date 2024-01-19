package dev.lebenkov.todo.store.repository;

import dev.lebenkov.todo.store.model.Account;
import dev.lebenkov.todo.store.model.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, ObjectId> {
    List<Task> findAllByAccount(Account account);
}
