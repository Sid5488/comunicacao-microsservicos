package br.com.productapi.modules.supplier.repositories;

import br.com.productapi.modules.supplier.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {}