package dev.lebenkov.todo.api.controller;

import dev.lebenkov.todo.api.service.ColorService;
import dev.lebenkov.todo.store.dto.ColorRequest;
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
@RequestMapping("/api/v1/colors")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ColorController {

    ColorService colorService;

    @PostMapping
    public ResponseEntity<String> createColor(@RequestBody ColorRequest colorRequest) {
        colorService.saveColor(colorRequest);
        return new ResponseEntity<>("Color was successfully saved", HttpStatus.OK);
    }
}
