package br.com.productapi.modules.repositories;

import br.com.productapi.modules.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
