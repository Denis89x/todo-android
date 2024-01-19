package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.CategoryRequest;
import dev.lebenkov.todo.store.dto.CategoryResponse;
import dev.lebenkov.todo.store.dto.CategoryUpdateRequest;
import org.bson.types.ObjectId;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAllCategories();
    void createCategory(CategoryRequest categoryRequest);
    void deleteCategory(ObjectId id);
    void updateCategory(ObjectId id, CategoryUpdateRequest categoryUpdateRequest);
}
