package br.com.productapi.controllers;

import br.com.productapi.modules.DTOs.CategoryRequestDTO;
import br.com.productapi.modules.DTOs.CategoryResponse;
import br.com.productapi.modules.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequestDTO request) {
        return categoryService.save(request);
    }
}
