package dev.lebenkov.todo.api.controller;

import dev.lebenkov.todo.api.service.IconService;
import dev.lebenkov.todo.store.dto.IconRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/icons")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IconController {

    IconService iconService;

    @PostMapping
    public ResponseEntity<String> createIcon(@RequestBody IconRequest iconRequest) {
        iconService.saveIcon(iconRequest);
        return new ResponseEntity<>("Icon was successfully saved", HttpStatus.OK);
    }
}
