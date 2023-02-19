package br.com.productapi.modules.category.services;

import br.com.productapi.exceptions.ValidationException;
import br.com.productapi.modules.category.DTOs.CategoryRequestDTO;
import br.com.productapi.modules.category.DTOs.CategoryResponse;
import br.com.productapi.modules.category.repositories.CategoryRepository;
import br.com.productapi.modules.category.models.Category;
import br.com.productapi.modules.supplier.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(int id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no category for the given id."));
    }

    public CategoryResponse save(CategoryRequestDTO request) {
        validateCategoryNameInformed(request);

        var category = categoryRepository.save(Category.of(request));

        return CategoryResponse.of(category);
    }

    private void validateCategoryNameInformed(CategoryRequestDTO request) {
        if(isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }
}
