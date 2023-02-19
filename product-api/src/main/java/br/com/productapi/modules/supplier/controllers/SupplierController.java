package br.com.productapi.modules.supplier.controllers;

import br.com.productapi.modules.supplier.DTOs.SupplierRequestDTO;
import br.com.productapi.modules.supplier.DTOs.SupplierResponse;
import br.com.productapi.modules.supplier.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public SupplierResponse save(@RequestBody SupplierRequestDTO request) {
        return supplierService.save(request);
    }
}
