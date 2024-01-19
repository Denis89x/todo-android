package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.ColorRequest;
import dev.lebenkov.todo.store.model.Color;
import dev.lebenkov.todo.store.repository.ColorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ColorServiceImp implements ColorService {

    ColorRepository colorRepository;

    ModelMapper modelMapper;

    @Override
    public void saveColor(ColorRequest colorRequest) {
        colorRepository.save(convertToColor(colorRequest));
    }

    private Color convertToColor(ColorRequest colorRequest) {
        return modelMapper.map(colorRequest, Color.class);
    }
}
