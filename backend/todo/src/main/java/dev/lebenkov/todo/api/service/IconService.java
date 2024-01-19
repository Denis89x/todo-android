package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.IconRequest;

public interface IconService {
    void saveIcon(IconRequest iconRequest);
}
