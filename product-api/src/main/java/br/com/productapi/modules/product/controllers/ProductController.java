package br.com.productapi.modules.product.controllers;

import br.com.productapi.modules.product.DTOs.ProductRequestDTO;
import br.com.productapi.modules.product.DTOs.ProductResponse;
import br.com.productapi.modules.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse save(@RequestBody ProductRequestDTO request) {
        return productService.save(request);
    }
}
