package br.com.productapi.modules.supplier.services;

import br.com.productapi.exceptions.ValidationException;
import br.com.productapi.modules.supplier.DTOs.SupplierRequestDTO;
import br.com.productapi.modules.supplier.DTOs.SupplierResponse;
import br.com.productapi.modules.supplier.models.Supplier;
import br.com.productapi.modules.supplier.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier findById(int id) {
        return supplierRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no supplier for the given id."));
    }

    public SupplierResponse save(SupplierRequestDTO request) {
        validateSupplierNameInformed(request);

        var supplier = supplierRepository.save(Supplier.of(request));

        return SupplierResponse.of(supplier);
    }

    private void validateSupplierNameInformed(SupplierRequestDTO request) {
        if(isEmpty(request.getName())) {
            throw new ValidationException("The suppliers name was not informed.");
        }
    }
}
