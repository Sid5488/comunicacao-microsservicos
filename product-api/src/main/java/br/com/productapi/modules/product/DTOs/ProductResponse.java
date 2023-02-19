package br.com.productapi.modules.product.DTOs;

import br.com.productapi.modules.category.DTOs.CategoryResponse;
import br.com.productapi.modules.product.models.Product;
import br.com.productapi.modules.supplier.DTOs.SupplierResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
public class ProductResponse {
    private int id;
    private String name;
    private CategoryResponse category;
    private SupplierResponse supplier;
    private int quantityAvailable;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public static ProductResponse of(Product product) {
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .quantityAvailable(product.getQuantityAvailable())
                .supplier(SupplierResponse.of(product.getSupplier()))
                .category(CategoryResponse.of(product.getCategory()))
                .createdAt(product.getCreatedAt())
                .build();
    }
}
