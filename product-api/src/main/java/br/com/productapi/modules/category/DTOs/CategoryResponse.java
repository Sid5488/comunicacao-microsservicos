package br.com.productapi.modules.category.DTOs;

import br.com.productapi.modules.category.models.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Data
@Setter
@Getter
public class CategoryResponse {
    private int id;
    private String description;

    public static CategoryResponse of(Category category) {
        var response = new CategoryResponse();

        BeanUtils.copyProperties(category, response);

        return response;
    }
}
