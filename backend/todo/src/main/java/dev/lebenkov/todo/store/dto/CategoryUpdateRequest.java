package dev.lebenkov.todo.store.dto;

import lombok.Data;

@Data
public class CategoryUpdateRequest {
    private String name;
    private Boolean isEditable;
    private ColorRequest colorRequest;
    private IconRequest iconRequest;
}
