package br.com.productapi.modules.services;

import br.com.productapi.exceptions.ValidationException;
import br.com.productapi.modules.DTOs.CategoryRequestDTO;
import br.com.productapi.modules.DTOs.CategoryResponse;
import br.com.productapi.modules.models.Category;
import br.com.productapi.modules.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

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
