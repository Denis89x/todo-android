package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.dto.*;
import dev.lebenkov.todo.store.model.Category;
import dev.lebenkov.todo.store.model.Color;
import dev.lebenkov.todo.store.model.Icon;
import dev.lebenkov.todo.store.repository.CategoryRepository;
import dev.lebenkov.todo.store.repository.ColorRepository;
import dev.lebenkov.todo.store.repository.IconRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImp implements CategoryService {

    CategoryRepository categoryRepository;
    ColorRepository colorRepository;
    IconRepository iconRepository;

    AccountService accountService;

    ModelMapper modelMapper;

    @Override
    public List<CategoryResponse> findAllCategories() {
        return categoryRepository.findAllByAccount(accountService.fetchAccount()).stream().map
                (this::convertToCategoryResponse).collect(Collectors.toList());
    }

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
                .icon(iconRepository.findById(categoryRequest.getIconId()).orElseThrow(() -> new RuntimeException("Icon not founded!")))
                .color(colorRepository.findById(categoryRequest.getColorId()).orElseThrow(() -> new RuntimeException("Color not founded!")))
                .account(accountService.fetchAccount())
                .isEditable(true)
                .name(categoryRequest.getName())
                .build();
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(ObjectId id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCategory(ObjectId id, CategoryUpdateRequest categoryUpdateRequest) {
        if (categoryRepository.findById(id).isPresent()) {
            Category category = categoryRepository.findById(id).get();

            iconRepository.save(convertToIcon(category.getIcon(), categoryUpdateRequest.getIconRequest()));
            colorRepository.save(convertToColor(category.getColor(), categoryUpdateRequest.getColorRequest()));

            category.setName(categoryUpdateRequest.getName());
            category.setEditable(categoryUpdateRequest.getIsEditable());
            category.setIcon(convertToIcon(category.getIcon(), categoryUpdateRequest.getIconRequest()));
            category.setColor(convertToColor(category.getColor(), categoryUpdateRequest.getColorRequest()));

            categoryRepository.save(category);
        }
    }

    private CategoryResponse convertToCategoryResponse(Category category) {
        return modelMapper.map(category, CategoryResponse.class);
    }

    private Icon convertToIcon(Icon icon, IconRequest iconRequest) {
        return Icon.builder()
                .id(icon.getId())
                .name(iconRequest.getName())
                .symbol(iconRequest.getSymbol())
                .build();
    }

    private Color convertToColor(Color color, ColorRequest colorRequest) {
        return Color.builder()
                .id(color.getId())
                .name(colorRequest.getName())
                .code(colorRequest.getCode())
                .build();
    }
}