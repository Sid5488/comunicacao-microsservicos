package br.com.productapi.modules.repositories;

import br.com.productapi.modules.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {}