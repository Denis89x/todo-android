package dev.lebenkov.todo.store.dto;

import dev.lebenkov.todo.store.model.Color;
import dev.lebenkov.todo.store.model.Icon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {

    private String name;

    private Color color;

    private Icon icon;
}
