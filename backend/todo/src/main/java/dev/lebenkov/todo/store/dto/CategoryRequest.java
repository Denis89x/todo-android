package dev.lebenkov.todo.store.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CategoryRequest {
    private String name;
    private ObjectId colorId;
    private ObjectId iconId;
}
