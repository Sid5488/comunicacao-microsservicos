package br.com.productapi.modules.supplier.DTOs;

import br.com.productapi.modules.supplier.models.Supplier;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@Setter
@Getter
public class SupplierResponse {
    private int id;
    private String name;

    public static SupplierResponse of(Supplier supplier) {
        var response = new SupplierResponse();

        System.out.println("Supplier id: " + supplier.getId());

        BeanUtils.copyProperties(supplier, response);

        return response;
    }
}
