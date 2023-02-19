package br.com.productapi.modules.product.repositories;

import br.com.productapi.modules.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
