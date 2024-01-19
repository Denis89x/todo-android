package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.IconRequest;
import dev.lebenkov.todo.store.model.Icon;
import dev.lebenkov.todo.store.repository.IconRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IconServiceImp implements IconService {

    IconRepository iconRepository;

    ModelMapper modelMapper;

    @Override
    public void saveIcon(IconRequest iconRequest) {
        iconRepository.save(convertToIcon(iconRequest));
    }

    private Icon convertToIcon(IconRequest iconRequest) {
        return modelMapper.map(iconRequest, Icon.class);
    }
}
