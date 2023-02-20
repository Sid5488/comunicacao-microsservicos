package br.com.productapi.modules.category.services;

import br.com.productapi.exceptions.ValidationException;
import br.com.productapi.modules.category.DTOs.CategoryRequestDTO;
import br.com.productapi.modules.category.DTOs.CategoryResponse;
import br.com.productapi.modules.category.repositories.CategoryRepository;
import br.com.productapi.modules.category.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse findByIdResponse(int id) {
        if(isEmpty(id)) throw new ValidationException("The category id was not informed.");

        return CategoryResponse.of(findById(id));
    }

    public Category findById(int id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no category for the given id."));
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public List<CategoryResponse> findByDescription(String description) {
        if(isEmpty(description)) throw new ValidationException("The category description must be informed.");

        return categoryRepository
                .findByDescriptionIgnoreCaseContaining(description)
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public CategoryResponse save(CategoryRequestDTO request) {
        validateCategoryNameInformed(request);

        var category = categoryRepository.save(Category.of(request));

        return CategoryResponse.of(category);
    }

    private void validateCategoryNameInformed(CategoryRequestDTO request) {
        if(isEmpty(request.getDescription()))
            throw new ValidationException("The category description was not informed.");
    }
}
