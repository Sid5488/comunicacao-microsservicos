package br.com.productapi.modules.product.DTOs;

import br.com.productapi.modules.category.DTOs.CategoryResponse;
import br.com.productapi.modules.supplier.DTOs.SupplierResponse;
import lombok.Builder;
import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;
    private int categoryId;
    private int supplierId;
    private int quantityAvailable;
}
