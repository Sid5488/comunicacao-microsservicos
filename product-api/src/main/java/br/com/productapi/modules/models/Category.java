package br.com.productapi.modules.models;

import br.com.productapi.modules.DTOs.CategoryRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    public static Category of(CategoryRequestDTO request) {
        var response = new Category();

        BeanUtils.copyProperties(request, response);

        return response;
    }
}
