package br.com.productapi.modules.repositories;

import br.com.productapi.modules.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}
