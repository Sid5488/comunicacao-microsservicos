package br.com.productapi.modules.product.services;

import br.com.productapi.exceptions.ValidationException;
import br.com.productapi.modules.category.services.CategoryService;
import br.com.productapi.modules.product.DTOs.ProductRequestDTO;
import br.com.productapi.modules.product.DTOs.ProductResponse;
import br.com.productapi.modules.product.models.Product;
import br.com.productapi.modules.product.repositories.ProductRepository;
import br.com.productapi.modules.supplier.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CategoryService categoryService;

    private static final int ZERO = 0;

    public ProductResponse save(ProductRequestDTO request) {
        validateProductDataInformed(request);
        validateCategoryAndSupplierInformed(request);

        var category = categoryService.findById(request.getCategoryId());
        var supplier = supplierService.findById(request.getSupplierId());
        var product = productRepository.save(Product.of(request, category, supplier));

        return ProductResponse.of(product);
    }

    private void validateProductDataInformed(ProductRequestDTO request) {
        if(isEmpty(request.getName())) {
            throw new ValidationException("The product's name was not informed.");
        }

        if(isEmpty(request.getQuantityAvailable())) {
            throw new ValidationException("The product's quantity was not informed.");
        }

        if(request.getQuantityAvailable() <= ZERO) {
            throw new ValidationException("The quantity should not be less or equal to zero.");
        }
    }

    private void validateCategoryAndSupplierInformed(ProductRequestDTO request) {
        if(isEmpty(request.getCategoryId())) {
            throw new ValidationException("The product's category was not informed.");
        }

        if(isEmpty(request.getSupplierId())) {
            throw new ValidationException("The product's supplier was not informed.");
        }
    }
}
