package dev.lebenkov.todo.api.controller;

import dev.lebenkov.todo.api.service.CategoryService;
import dev.lebenkov.todo.store.dto.CategoryRequest;
import dev.lebenkov.todo.store.dto.CategoryResponse;
import dev.lebenkov.todo.store.dto.CategoryUpdateRequest;
import dev.lebenkov.todo.store.model.Category;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {

    CategoryService categoryService;

    private final static String CATEGORY_ID = "/{categoryId}";

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>("Category was successfully saved", HttpStatus.CREATED);
    }

    @DeleteMapping(CATEGORY_ID)
    public ResponseEntity<String> deleteCategory(@PathVariable ObjectId categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("Category was successfully deleted", HttpStatus.OK);
    }

    @PutMapping(CATEGORY_ID)
    public ResponseEntity<String> updateCategory(@PathVariable ObjectId categoryId, @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        categoryService.updateCategory(categoryId, categoryUpdateRequest);
        return new ResponseEntity<>("Category was successfully updated", HttpStatus.OK);
    }
}
