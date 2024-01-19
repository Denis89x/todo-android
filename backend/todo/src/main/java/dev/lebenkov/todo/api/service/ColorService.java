package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.ColorRequest;

public interface ColorService {
    void saveColor(ColorRequest colorRequest);
}
