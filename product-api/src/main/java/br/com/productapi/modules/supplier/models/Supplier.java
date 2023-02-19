package br.com.productapi.modules.supplier.models;

import br.com.productapi.modules.supplier.DTOs.SupplierRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUPPLIER")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public static Supplier of(SupplierRequestDTO request) {
        var response = new Supplier();

        BeanUtils.copyProperties(request, response);

        return response;
    }
}
