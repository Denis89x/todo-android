package dev.lebenkov.todo.store.repository;

import dev.lebenkov.todo.store.model.Account;
import dev.lebenkov.todo.store.model.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
    List<Category> findAllByAccount(Account account);
}
