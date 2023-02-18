package br.com.productapi.modules.DTOs;

import br.com.productapi.modules.models.Category;
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
